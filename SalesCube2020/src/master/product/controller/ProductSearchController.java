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

public class ProductSearchController extends BaseController{
	
	public ProductSearchController() {
		
	}
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");

		if(action.equals("searchProduct")) forwardURL = searchProduct(request, response);
		else if(action.equals("getCategory")) forwardURL = getCategory(request, response);
		else if(action.equals("deleteProduct")) forwardURL = deleteProduct(request, response);
		else if(action.equals("moveModifyProduct")) forwardURL = moveModifyProduct(request, response);
		
		return forwardURL;
	}
	
	private String searchProduct(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// TODO Auto-generated method stub
		List<ProductCategoryBean> list = new ArrayList<>();
		
		ProductDAO dao = new ProductDAO();
		
		try {
			list = dao.getCategory();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("category", list);
		
		return "/productsearch.jsp";
	}
	
	private String getCategory(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<ProductCategoryBean> list = new ArrayList<>();
		
		ProductDAO dao = new ProductDAO();
		
		try {
			list = dao.getCategory();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("category", list);
		
		return "/productsearch.jsp";
	}

	private String deleteProduct(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// TODO Auto-generated method stub
		List<ProductCategoryBean> list = new ArrayList<>();
		
		ProductDAO dao = new ProductDAO();
		
		try {
			list = dao.getCategory();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("category", list);
		
		return "/productsearch.jsp";
	}

	private String moveModifyProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productCode;
		
		productCode = (String) request.getParameter("productCode");
		
		request.setAttribute("productCode", productCode);
		
		//System.out.println(productCode);
		
		return "/productaddmodify.jsp";
	}
}