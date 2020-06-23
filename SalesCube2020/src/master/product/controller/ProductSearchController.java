package master.product.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;
import master.customer.beans.customerSearchBeans.CustomerResultBean;
import master.product.DAO.GetCategoryDAO;
import master.product.DAO.ProductDAO;
import master.product.DAO.ProductSearchDAO;
import master.product.beans.ProductResultBean;
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
		//ÉJÉeÉSÉäÅ[
		List<ProductBigCategoryBean> list = new ArrayList<>();
		List<ProductResultBean> list2 = new ArrayList<>();
		
		ProductSearchBean bean = new ProductSearchBean();
		
		GetCategoryDAO dao = new GetCategoryDAO();
		ProductSearchDAO dao2 = new ProductSearchDAO();
		
		try {
			list = dao.getBigCategory();
			list2 = dao2.searchProduct(bean);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("category", list);
		request.setAttribute("search", list2);
		
		//
		List<ProductSearchBean> list3 = new ArrayList<ProductSearchBean>();
		ProductSearchDAO dao3 = new ProductSearchDAO();

		String productCode = null;
		String productName = null;
		String productKana = null;
		String supplierCode = null;
		String supplierName = null;
		String productStandardCategory = null;
		String productStatusCategory = null;
		String productStockCategory = null;
		String setTypeCategory = null;
		String remarks = null;
		String product1 = null;
		String product2 = null;
		String product3 = null;
		
		productCode = (String)request.getParameter("productCode");
		productName = (String)request.getParameter("productName");
		productKana = (String)request.getParameter("productKana");
		supplierCode = (String)request.getParameter("supplierCode");
		supplierName = (String)request.getParameter("supplierName");
		productStandardCategory = (String)request.getParameter("productStandardCategory");
		productStatusCategory = (String)request.getParameter("productStatusCategory");
		productStockCategory = (String)request.getParameter("productStockCategory");
		setTypeCategory = (String)request.getParameter("setTypeCategory");
		remarks = (String)request.getParameter("remarks");
		product1 = (String)request.getParameter("product1");
		product2 = (String)request.getParameter("product2");
		product3 = (String)request.getParameter("product3");
		
		for(int i = 0; i < productCode.length(); i++) {
			ProductSearchBean bean2 = new ProductSearchBean();
			bean.setProductCode("productCode");
			bean.setProductName("productName");
			bean.setProductKana("productKana");
			bean.setSupplierCode("supplierCode");
			bean.setSupplierName("supplierName");
			bean.setProductStandardCategory("productStandardCategory");
			bean.setProductStatusCategory("productStatusCategory");
			bean.setProductStockCategory("productStockCategory");
			bean.setSetTypeCategory("setTypeCategory");
			bean.setRemarks("remarks");
			bean.setProduct1("product1");
			bean.setProduct2("product2");
			bean.setProduct3("product3");
			list3.add(bean2);
		}
		
		dao2.searchProduct(list2, productCode);
		request.setAttribute(, );
		
		return "/productsearch.jsp";
	}

}