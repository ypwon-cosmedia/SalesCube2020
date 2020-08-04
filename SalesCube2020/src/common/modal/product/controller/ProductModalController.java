package common.modal.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.BaseAJAXController;

public class ProductModalController extends BaseAJAXController{


	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String data = "";
		String action = request.getParameter("action");
		
		if(action.equals("productSearch")) data = productSearch(request, response); 
			
		return data;
	}
	
	private String productSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		return "";
	}
	
	

}
