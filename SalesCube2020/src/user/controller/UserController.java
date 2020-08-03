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
		
		//action�l�ɂ��
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
		
		//JSP��������擾
		String userID = request.getParameter("userId");
		String password = request.getParameter("password");
		//DB��ID�ƃp�X���[�h����v�����񂪂��邩��T��
		user = userdao.login(userID, password);
		
		//���O�C���̉ۂ̐ݒ�
		if(user == null ) {
			message = "正しいIDとPWを入力してください";
			request.setAttribute("loginError", message);
			
			forwardURL = "/login.jsp";
		}else {
			//�Z�b�V�����̈�̎擾
			HttpSession session = request.getSession();
			//�Z�b�V�����X�R�[�v�ɁAID�Ɗ�������o�^
			UserInfoBean userInfo = new UserInfoBean();
			userInfo = userdao.userInfo(userID);
			session.setAttribute("userInfo", userInfo);
			
			String a =userInfo.getNameKNJ();
			System.out.println( a );
			
			forwardURL = "/menu.jsp";
		}
		return forwardURL;
	}
	
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		//�Z�b�V�����̈�̎擾
		HttpSession session = request.getSession();
		//�Z�b�V�����������ׂč폜
		session.invalidate();

		return "/login.jsp";
	}
}
