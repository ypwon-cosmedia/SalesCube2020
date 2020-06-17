package common.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;
import common.controller.CreateControllers;


import java.util.*;
import java.sql.SQLException;

import user.DAO.*;
import user.beans.*;
import user.controller.*;

public class SalesCubeServlet extends HttpServlet {


	private HashMap<String, BaseController> controllerList;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String  forwardURL;
        System.out.println("test1");

        // リクエストパラメータの読み込み
        String action = request.getParameter("action");
        System.out.println(action);

        // 業務の振り分け
        if  ( controllerList.containsKey(action) )  {							// actionに該当する業務コントローラがある場合
        	System.out.println("test2");
        	BaseController controller = controllerList.get(action);			//   該当する業務コントローラを取得
            forwardURL = controller.execService(request, response);				//   業務コントローラに処理を委譲しフォワードするJSPのURLを取得する
            RequestDispatcher rd = request.getRequestDispatcher(forwardURL);	//   ディスパッチャーを取得
            rd.forward(request, response);										//   出力処理をJSPに委譲（フォワード）

        } else {
        	System.out.println("test3");
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");	// actionパラメタ値が見つからない場合は遷移エラーページを表示
            rd.forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

	public void init() throws ServletException {
    	// 業務コントローラをmapに登録
		
		controllerList = new CreateControllers().newControllers();
    }
}
