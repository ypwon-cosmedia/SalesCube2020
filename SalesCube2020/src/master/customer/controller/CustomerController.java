package master.customer.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;

import java.util.*;
import java.sql.SQLException;
import java.lang.*;

import user.DAO.*;
import user.beans.*;

public class CustomerController extends BaseController{
	
	public CustomerController() {
	}
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");
/*		
		if(action.equals("moveModifySetProduct")) forwardURL = moveModifySetProduct(request, response);
		else if(action.equals("searchSetProduct")) forwardURL = searchSetProduct(request, response);
		else if(action.equals("deleteSetProduct")) forwardURL = deleteSetProduct(request, response);
		else if(action.equals("modifySetProduct")) forwardURL = modifySetProduct(request, response);
		else if(action.equals("searchSetProduct")) forwardURL = searchSetProduct(request, response);
		else if(action.equals("deleteSetProduct")) forwardURL = deleteSetProduct(request, response);
		else if(action.equals("modifySetProduct")) forwardURL = modifySetProduct(request, response);
		else if(action.equals("searchSetProduct")) forwardURL = searchSetProduct(request, response);
		else if(action.equals("deleteSetProduct")) forwardURL = deleteSetProduct(request, response);
		else if(action.equals("modifySetProduct")) forwardURL = modifySetProduct(request, response);
*/
		
  		return forwardURL;
	}
}
