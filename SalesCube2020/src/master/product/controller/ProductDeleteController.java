package master.product.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;
import master.product.DAO.GetCategoryDAO;
import master.product.DAO.ProductDAO;
import master.product.beans.ProductBigCategoryBean;

import java.util.*;
import java.sql.SQLException;
import java.lang.*;

import user.DAO.*;
import user.beans.*;

public class ProductDeleteController extends BaseController{
	
	public ProductDeleteController() {
		
	}
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");

		 if(action.equals("deleteProduct")) forwardURL = deleteProduct(request, response);
		
		return forwardURL;
	}
	
	
	private String deleteProduct(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// TODO Auto-generated method stub
		String forwardURL = "/productsearch.jsp";	
		
		List<ProductBigCategoryBean> list = new ArrayList<>();		
		GetCategoryDAO dao = new GetCategoryDAO();
		try {
			list = dao.getBigCategory();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("category", list);
		
		
		ProductDeleteBean bean = 
		
		String code = request.getParameter("productCode");
		int productCode = Integer.parseInt(code);

		
		return forwardURL;
	}

}