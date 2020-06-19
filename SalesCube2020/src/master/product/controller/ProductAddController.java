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

public class ProductAddController extends BaseController{
	
	public ProductAddController() {
		
	}
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");

		if(action.equals("moveAddProduct")) forwardURL = moveAddProduct(request, response);
		else if(action.equals("addProduct")) forwardURL = addProduct(request, response);
		
  		return forwardURL;
      	}


	private String addProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/productaddmodify.jsp";
	}


	private String moveAddProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/productaddmodify.jsp";
	}

}
