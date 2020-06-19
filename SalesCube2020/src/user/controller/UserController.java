package user.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.websocket.Session;

import common.controller.BaseController;

import java.util.*;
import java.sql.SQLException;
import java.lang.*;

import user.DAO.*;
import user.beans.*;

public class UserController extends BaseController{
	
	public UserController() {
	}
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/login.jsp";
		String action = request.getParameter("action");
		
		try {
		
		if(action.equals("login")) 			forwardURL = login(request, response);
		else if(action.equals("logout")) 	forwardURL = logout(request, response);
		
		
		}catch (ServletException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
  		return forwardURL;
  		
	}
		
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forwardURL = "/login.jsp";
		String message = null;
		LoginBean user = new LoginBean();
		UserDAO userdao = new UserDAO();
		
		String userID = request.getParameter("userId");
		String password = request.getParameter("password");
		
		user = userdao.login(userID, password);
		
		if(user.getUserID() == null) {
			message = "IDとパスワードが正しくありません";
			request.setAttribute("loginError", message);
			
			forwardURL = "/login.jsp";
		}else {
			//セッション領域の取得
			HttpSession session = request.getSession();
			//セッションスコープに、IDと漢字名を登録
			UserInfoBean userInfo = new UserInfoBean();
			userInfo = userdao.userInfo(userID);
			session.setAttribute("userInfo", userInfo);
			
			forwardURL = "/menu.jsp";
		}
		return forwardURL;
	}
	
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		return "/login.jsp";
	}
}
