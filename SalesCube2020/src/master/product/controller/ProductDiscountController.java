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

public class ProductDiscountController extends BaseController{
	
	public ProductDiscountController() {
		
	}
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");


		 if(action.equals("quantityDiscount")) forwardURL = quantityDiscount(request, response);
		
  		return forwardURL;
      	}


	private String quantityDiscount(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/productaddmodify.jsp";
	}


}

