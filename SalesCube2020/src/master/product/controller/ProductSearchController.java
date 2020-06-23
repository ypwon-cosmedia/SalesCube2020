package master.product.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;
import master.customer.beans.customerSearchBeans.CustomerResultBean;
import master.product.DAO.GetCategoryDAO;
import master.product.DAO.ProductDAO;
import master.product.beans.ProductBigCategoryBean;
import master.product.beans.ProductSearchBean;

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
		
		return forwardURL;
	}
	
	private String searchProduct(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// TODO Auto-generated method stub
		
		List<ProductBigCategoryBean> list = new ArrayList<>();
		
		GetCategoryDAO dao = new GetCategoryDAO();
		
		try {
			list = dao.getBigCategory();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("category", list);
		
		return "/productsearch.jsp";
	}

}