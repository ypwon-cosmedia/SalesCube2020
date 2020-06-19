package master.product.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;
import master.product.DAO.ProductDAO;
import master.product.beans.ProductBigCategoryBean;

import java.util.*;
import java.sql.SQLException;
import java.lang.*;

import user.DAO.*;
import user.beans.*;

public class ProductModifyController extends BaseController{
	
	public ProductModifyController() {
		
	}
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");

		if(action.equals("moveModifyProduct")) forwardURL = moveModifyProduct(request, response);
		else if(action.equals("modifyProduct")) forwardURL = modifyProduct(request, response);
  		return forwardURL;
      	}


	private String modifyProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/productaddmodify.jsp";
	}


	private String moveModifyProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/productaddmodify.jsp";
	}


}

