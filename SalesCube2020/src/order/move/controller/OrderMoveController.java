package order.move.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.BaseController;

public class OrderMoveController extends BaseController{
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");
		
		if(action.equals("orderinput")) forwardURL = moveOrderInput(request, response);
		else if(action.equals("orderedit")) forwardURL = moveOrderEdit(request, response);
		else if(action.equals("ordersearch")) forwardURL = moveOrderSearch(request, response);
		else if(action.equals("onlineorder")) forwardURL = moveOnlineOrder(request, response);
		
		return forwardURL;
	}
	
	private String moveOrderInput (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "order\\orderinput.jsp";
	}
	
	private String moveOrderEdit (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "order\\orderupdate.jsp";
	}

	private String moveOrderSearch (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		return "order\\ordersearch.jsp";
	}

	private String moveOnlineOrder (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		return "order\\onlineorderdataimport.jsp";
	}
}
