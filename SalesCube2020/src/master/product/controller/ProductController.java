package master.product.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;

import java.util.*;
import java.sql.SQLException;
import java.lang.*;

import user.DAO.*;
import user.beans.*;

public class ProductController extends BaseController{
	
	public ProductController() {
		
	}
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");

		if(action.equals("moveAddProduct")) forwardURL = moveAddProduct(request, response);
		else if(action.equals("moveModifyProduct")) forwardURL = moveModifyProduct(request, response);
		else if(action.equals("productExcelInput")) forwardURL = productExcelInput(request, response);
		else if(action.equals("productExcelOutput")) forwardURL = productExcelOutput(request, response);
		else if(action.equals("productHistoryOutput")) forwardURL = productHistoryOutput(request, response);
		else if(action.equals("initProduct")) forwardURL = initProduct(request, response);
		else if(action.equals("updateInitProduct")) forwardURL = updateInitProduct(request, response);
		else if(action.equals("quantityDiscount")) forwardURL = quantityDiscount(request, response);
		else if(action.equals("searchProduct")) forwardURL = searchProduct(request, response);
		else if(action.equals("deleteProduct")) forwardURL = deleteProduct(request, response);
		else if(action.equals("addProduct")) forwardURL = addProduct(request, response);
		else if(action.equals("modifyProduct")) forwardURL = modifyProduct(request, response);
		else if(action.equals("getCategory")) forwardURL = getCategory(request, response);
		
  		return forwardURL;
      	}

	private String getCategory(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		return "/productsearch.jsp";
	}

	private String modifyProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/productaddmodify.jsp";
	}

	private String addProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/productaddmodify.jsp";
	}

	private String deleteProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/productsearch.jsp";
	}

	private String searchProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/productsearch.jsp";
	}

	private String quantityDiscount(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/productaddmodify.jsp";
	}

	private String initProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/productinit.jsp";
	}
	
	private String updateInitProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/productaddmodify.jsp";
	}

	private String productExcelOutput(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/productsearch.jsp";
	}

	private String productExcelInput(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/productsearch.jsp";
	}
	
	private String productHistoryOutput(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/productaddmodify.jsp";
	}

	private String moveModifyProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/productaddmodify.jsp";
	}

	private String moveAddProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/productaddmodify.jsp";
	}

}
