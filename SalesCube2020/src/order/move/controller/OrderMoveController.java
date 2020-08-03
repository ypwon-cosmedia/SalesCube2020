package order.move.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.BaseController;
import order.common.init.DAO.OrderInitDAO;

public class OrderMoveController extends BaseController{
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");
		
		if(action.equals("orderinput")) forwardURL = moveOrderInput(request, response);
		else if(action.equals("orderupdate")) forwardURL = moveOrderUpdate(request, response);
		else if(action.equals("ordersearch")) forwardURL = moveOrderSearch(request, response);
		else if(action.equals("onlineorder")) forwardURL = moveOnlineOrder(request, response);
		
		return forwardURL;
	}
	
	private String moveOrderInput (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "order\\orderinput.jsp";
	}
	
	private String moveOrderUpdate (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "order\\orderupdate.jsp";
	}

	private String moveOrderSearch (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrderInitDAO dao = new OrderInitDAO();
		
		try {
			request.setAttribute("category", dao.initCategory());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "order\\ordersearch.jsp";
	}

	private String moveOnlineOrder (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		return "order\\onlineorderdataimport.jsp";
	}
}
