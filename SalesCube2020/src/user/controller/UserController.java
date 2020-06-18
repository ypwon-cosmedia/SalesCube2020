package user.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

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
		
		if(action.equals("login")) forwardURL = login(request, response);
		else if(action.equals("logout")) forwardURL = logout(request, response);
		
  		return forwardURL;
    }

	public String login(HttpServletRequest request, HttpServletResponse response) {
		
		return "/menu.jsp";
	}
	
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		return "/login.jsp";
	}
}
