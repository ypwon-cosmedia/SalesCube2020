package common.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;
import common.controller.CreateControllers;
import sun.font.CreatedFontTracker;

import java.util.*;
import java.sql.SQLException;

import user.DAO.*;
import user.beans.*;
import user.controller.*;

public class SalesCubeServlet extends HttpServlet {

	private HashMap<String, BaseController> controllerList;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
        String  forwardURL;

        request.setCharacterEncoding("Windows-31J");

        // リクエストパラメータの読み込み
        String action = request.getParameter("action");

        if ( action == null ) {									// actionパラメタが取得できない場合は
            action = "top";										// top画面を表示する
        }

		if (request.getAttribute("user") == null){
			action = "login";
		}

        // 業務の振り分け
        if  ( controllerList.containsKey(action) )  {							// actionに該当する業務コントローラがある場合
            BaseController controller = controllerList.get(action);			//   該当する業務コントローラを取得
            forwardURL = controller.execService(request, response);				//   業務コントローラに処理を委譲しフォワードするJSPのURLを取得する
            RequestDispatcher rd = request.getRequestDispatcher(forwardURL);	//   ディスパッチャーを取得
            rd.forward(request, response);										//   出力処理をJSPに委譲（フォワード）

        } else {
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
