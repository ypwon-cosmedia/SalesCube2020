package common.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.beans.CustomerPayBean;
import common.beans.ProductStandardCategoryBean;
import common.beans.ProductStatusCategoryBean;
import common.beans.ProductStockCategoryBean;
import common.beans.SetTypeCategoryBean;
import common.dao.MenuDAO;
import master.product.DAO.GetCategoryDAO;
import master.product.beans.ProductCategoryAllBean;

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
		
		List<CustomerPayBean> list = new ArrayList<CustomerPayBean>();
		MenuDAO dao = new MenuDAO();
		
		try {
			list = dao.getCustomerPayInfo();
			
			request.setAttribute("payInfo", list);
			
			return "/customersearch.jsp";
		} catch (ClassNotFoundException | MissingResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "/customersearch.jsp";
	}
	
	private String moveProduct (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		
		List<ProductStockCategoryBean> list2 = new ArrayList<ProductStockCategoryBean>();
		List<SetTypeCategoryBean> list3 = new ArrayList<SetTypeCategoryBean>();
		List<ProductStandardCategoryBean> list4 = new ArrayList<ProductStandardCategoryBean>();
		List<ProductStatusCategoryBean> list5 = new ArrayList<ProductStatusCategoryBean>();
		List<ProductCategoryAllBean> list8 = new ArrayList<ProductCategoryAllBean>();
		
		GetCategoryDAO dao = new GetCategoryDAO();
		MenuDAO dao2 = new MenuDAO();
		
		list2 = dao2.getProductStockCategory();
		list3 = dao2.getSetTypeCategory();
		list4 = dao2.getProductStandardCategory();
		list5 = dao2.getProductStatusCategory();
		list8 = dao.getAllCategory();
		
		request.setAttribute("prosearch", list2);
		request.setAttribute("setTypeCategory", list3);
		request.setAttribute("productStandardCategory", list4);
		request.setAttribute("productStatusCategory", list5);	
		request.setAttribute("all", list8);
		
		return "/productsearch.jsp";
	}
	
	private String moveSetProduct (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "/setproduct.jsp";
	}
	
	private String moveMenu (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		return "/menu.jsp";
	}
		
}