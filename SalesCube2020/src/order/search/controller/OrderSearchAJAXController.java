package order.search.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.MissingResourceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.BaseAJAXController;
import order.search.dao.OrderSearchDAO;
import user.beans.UserInfoBean;

public class OrderSearchAJAXController extends BaseAJAXController{


	public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("configModalUpdate")) configModalUpdate(request, response);
	}
	
	private void configModalUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrderSearchDAO dao = new OrderSearchDAO();
		HttpSession session = request.getSession(true);
		
		String[] showlistvalue = request.getParameterValues("showlistvalue");
		String searchsubject = request.getParameter("searchsubject");
		UserInfoBean userID = (UserInfoBean) session.getAttribute("userInfo");
			
		try {
			dao.configUpdate(showlistvalue, searchsubject, userID.getUserID());
		} catch (ClassNotFoundException | MissingResourceException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
