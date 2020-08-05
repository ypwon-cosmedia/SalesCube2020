package order.search.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.MissingResourceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.BaseAJAXController;
import order.search.dao.OrderSearchDAO;

public class OrderSearchAJAXController extends BaseAJAXController{


	public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("configModalUpdate")) configModalUpdate(request, response);
	}
	
	private void configModalUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrderSearchDAO dao = new OrderSearchDAO();
		
		String[] showlistname = request.getParameterValues("showlistname");
		String[] showlistvalue = request.getParameterValues("showlistvalue");
		String[] notshowlistname = request.getParameterValues("notshowlistname");
		String[] notshowlistvalue = request.getParameterValues("notshowlistvalue");
		String searchsubject = request.getParameter("searchsubject");
		
		
		try {
			dao.configUpdate(showlistname, showlistvalue, notshowlistname, notshowlistvalue, searchsubject);
		} catch (ClassNotFoundException | MissingResourceException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
