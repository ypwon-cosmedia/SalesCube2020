package common.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.beans.ProductStockCategoryBean;
import common.dao.MenuDAO;
import master.product.DAO.GetCategoryDAO;
import master.product.beans.ProductBigCategoryBean;

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
		
		List<ProductBigCategoryBean> list = new ArrayList<>();
		List<ProductStockCategoryBean> list2 = new ArrayList<>();
		
		GetCategoryDAO dao = new GetCategoryDAO();
		MenuDAO dao2 = new MenuDAO();
		
		list = dao.getBigCategory();
		list2= dao2.getProductStockCategory();
		
		request.setAttribute("category", list);
		request.setAttribute("prosearch", list2);
		
		return "/productsearch.jsp";
	}
	
	private String moveSetProduct (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "/setproduct.jsp";
	}
	
	private String moveMenu (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "/menu.jsp";
	}
		
}