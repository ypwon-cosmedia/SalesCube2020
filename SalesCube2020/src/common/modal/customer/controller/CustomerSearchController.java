package common.modal.customer.controller;

import java.io.IOException;
import java.util.MissingResourceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.BaseController;

public class CustomerSearchController extends BaseController {
		public CustomerSearchController() {
			
		}
		
		public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String forwardURL = "/estimateSearch.jsp";
			String action = request.getParameter("action");
			
			if(action.equals("customerSearch"))
			try {
				forwardURL = customerSearch(request, response);
			} catch (ClassNotFoundException | MissingResourceException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return forwardURL;
		}
		
		private String customerSearch(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException, ClassNotFoundException, MissingResourceException{
			
}
