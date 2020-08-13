package estimate.common.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import common.controller.BaseAJAXController;
import estimate.common.beans.EstimateConfigurationBean;
import estimate.common.dao.EstimateConfigurationDAO;
import user.beans.UserInfoBean;


public class EstimateConfigurationModalAJAXController extends BaseAJAXController{

	public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("estimateShowCfgGet")) configShowGet(request, response); 
		if(action.equals("estimateNotShowCfgGet")) configNotShowGet(request, response); 
		if(action.equals("estimateCfgUpd")) configUpd(request, response); 
		
	}
	
	//表示項目を取得するコントローラー
	private void configShowGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EstimateConfigurationDAO dao = new EstimateConfigurationDAO();
		List<EstimateConfigurationBean> list = new ArrayList<>();
		HttpSession session = request.getSession();
		
		//確認用（ユーザーIDがないため）--------------------------------------------------
		UserInfoBean test = new UserInfoBean();
		test.setUserID("est");
		session.setAttribute("userInfo", test);
		//------------------------------------------------------------------------
		
		UserInfoBean userInfo = (UserInfoBean) session.getAttribute("userInfo");
		String userId = userInfo.getUserID();
		
		
		Gson gson = new Gson();
		
		try {
			list = dao.showConfigurationGet(userId);//表示項目のリストを取得
		
			String data = gson.toJson(list);
			JsonArray jArray = new JsonParser().parse(data).getAsJsonArray();
					
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(jArray);
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	//非表示項目を取得するコントローラー
	private void configNotShowGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EstimateConfigurationDAO dao = new EstimateConfigurationDAO();
		List<EstimateConfigurationBean> list = new ArrayList<>();
		HttpSession session = request.getSession();
		
		//確認用（ユーザーIDがないため）----------------------------------------
		UserInfoBean test = new UserInfoBean();
		test.setUserID("est");
		session.setAttribute("userInfo", test);
		//確認用---------------------------------------------------------
		
		UserInfoBean userInfo = (UserInfoBean) session.getAttribute("userInfo");
		String userId = userInfo.getUserID();
		
		Gson gson = new Gson();
		
		try {
			list = dao.notShowConfigurationGet(userId);//非表示項目のリストを取得
		
			String data = gson.toJson(list);
			JsonArray jArray = new JsonParser().parse(data).getAsJsonArray();
					
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(jArray);
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (MissingResourceException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//設定の表示項目の更新
	private void configUpd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EstimateConfigurationDAO dao = new EstimateConfigurationDAO();
		String[] showItems = request.getParameterValues("showList");
		HttpSession session = request.getSession();
		
		if(showItems != null) {
			System.out.println("showItems;"+showItems.length);
			for(int i=0; i<showItems.length; i++) {
				System.out.println("from jsp:"+showItems[i]);
			}
		}
		//確認用（ユーザーIDがないため）----------------------------------------
		UserInfoBean test = new UserInfoBean();
		test.setUserID("est");
		session.setAttribute("userInfo", test);
		//確認用---------------------------------------------------------
		
		UserInfoBean userInfo = (UserInfoBean) session.getAttribute("userInfo");
		String userId = userInfo.getUserID();
		
		System.out.println("userId:" + userId);//userId:EstimateTest
		
		try {
			
			dao.UpdateConfig(userId, showItems);	//表示項目の設定を行う
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (MissingResourceException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}


