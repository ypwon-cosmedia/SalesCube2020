package master.product.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;
import master.customer.beans.customerSearchBeans.CustomerResultBean;
import master.product.DAO.ProductDAO;
import master.product.beans.ProductCategoryBean;
import master.product.beans.ProductSearchBean;

import java.util.*;
import java.sql.SQLException;
import java.lang.*;

import user.DAO.*;
import user.beans.*;

public class GetCategoryController extends BaseController {
	
	public GetCategoryController() {
		
	}
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");

		if(action.equals("getCategory")) forwardURL = getCategory(request, response);
		
		return forwardURL;
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

}
