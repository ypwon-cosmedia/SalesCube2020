package order.online.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.BaseAJAXController;

public class OrderOnlineAJAXController extends BaseAJAXController{
	
	public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String action = request.getParameter("action");
		
		if(action.equals("uploadcsv")) uploadcsv(request, response);
	}
	
	public void uploadcsv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
