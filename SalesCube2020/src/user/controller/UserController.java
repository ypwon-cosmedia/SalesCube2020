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
			message = "ID�ƃp�X���[�h������������܂���";
			request.setAttribute("loginError", message);
			
			forwardURL = "/login.jsp";
		}else {
			//�Z�b�V�����̈�̎擾
			HttpSession session = request.getSession();
			//�Z�b�V�����X�R�[�v�ɁAID�Ɗ�������o�^
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
