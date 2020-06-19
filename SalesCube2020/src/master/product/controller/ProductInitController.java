package master.product.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;
import master.product.DAO.ProductDAO;
import master.product.beans.ProductCategoryBean;

import java.util.*;
import java.sql.SQLException;
import java.lang.*;

import user.DAO.*;
import user.beans.*;

public class ProductInitController extends BaseController{
	
	public ProductInitController() {
		
	}
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");

		
		 if(action.equals("initProduct")) forwardURL = initProduct(request, response);
		else if(action.equals("updateInitProduct")) forwardURL = updateInitProduct(request, response);
		
  		return forwardURL;
      	}

	
	private String initProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/productinit.jsp";
	}
	
	private String updateInitProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/productaddmodify.jsp";
	}

}
