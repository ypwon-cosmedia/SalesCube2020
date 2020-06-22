package master.product.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;
import master.customer.beans.customerSearchBeans.CustomerResultBean;
import master.product.DAO.GetCategoryDAO;
import master.product.DAO.ProductDAO;
import master.product.beans.ProductBigCategoryBean;
import master.product.beans.ProductMiddleCategoryBean;
import master.product.beans.ProductSearchBean;
import master.product.beans.ProductSmallCategoryBean;

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

		if(action.equals("getBigCategory")) forwardURL = getBigCategory(request, response);
		else if(action.equals("getMiddleCategory")) forwardURL = getMiddleCategory(request, response);
		else if(action.equals("getSmallCategory")) forwardURL = getSmallCategory(request, response);

		
		return forwardURL;
	}

	
	private String getBigCategory(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
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
	
	private String getMiddleCategory(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<ProductMiddleCategoryBean> list = new ArrayList<>();
		
		GetCategoryDAO dao = new GetCategoryDAO();
		String bigCode;
		bigCode = (String)request.getParameter("product1");
			
		try {
			list = dao.getMiddleCategory(bigCode);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("category", list);
		
		return "/productsearch.jsp";
	}
	
	private String getSmallCategory(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<ProductSmallCategoryBean> list = new ArrayList<>();
		
		GetCategoryDAO dao = new GetCategoryDAO();
		String bigCode;
		String middleCode;
		bigCode = (String)request.getParameter("product1");
		middleCode = (String)request.getParameter("product2");
		
		
		try {
			list = dao.getSmallCategory(bigCode, middleCode);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("category", list);
		
		return "/productsearch.jsp";
	}

}
