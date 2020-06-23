package master.product.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;
import master.product.DAO.GetCategoryDAO;
import master.product.DAO.ProductDAO;
import master.product.DAO.ProductDeleteDAO;
import master.product.beans.ProductCategoryAllBean;
import master.product.beans.ProductDeleteBean;

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
		
		List<ProductCategoryAllBean> list = new ArrayList<ProductCategoryAllBean>();		
		GetCategoryDAO dao = new GetCategoryDAO();
		
		try {
			list = dao.getAllCategory();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("all", list);
		
		ProductDeleteBean bean = new ProductDeleteBean();
		ProductDeleteDAO dao2 = new ProductDeleteDAO();
		
		String productCode = null;
		
		productCode = (String)request.getParameter("productCode");
		bean.setProductCode(productCode);
		
		return forwardURL;
	}

}