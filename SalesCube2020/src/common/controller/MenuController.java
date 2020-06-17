package common.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import master.product.DAO.ProductDAO;
import master.product.beans.ProductCategoryBean;

import java.util.*;
import java.sql.SQLException;
import java.lang.*;

import user.DAO.*;
import user.beans.*;

final public class MenuController extends BaseController{
	
	protected MenuController() {
	}
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String forwardURL = "/menu.jsp";
			String action = request.getParameter("action");
			
			if(action.equals("customer")) forwardURL = moveCustomer(request, response);
			else if(action.equals("product"))
				try {
					forwardURL = moveProduct(request, response);
				} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else if(action.equals("setProduct")) forwardURL = moveSetProduct(request, response);
			else if(action.equals("menu")) forwardURL = moveMenu(request, response);
			
      		return forwardURL;
      }
	
	private String moveCustomer (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "/customersearch.jsp";
	}
	
	private String moveProduct (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		List<ProductCategoryBean> list = new ArrayList<>();
		
		ProductDAO dao = new ProductDAO();
		
		list = dao.getCategory();
		
		request.setAttribute("category", list);
		
		return "/productsearch.jsp";
	}
	
	private String moveSetProduct (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "/setproduct.jsp";
	}
	
	private String moveMenu (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "/menu.jsp";
	}
		
}