package master.product.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;
import master.product.DAO.ProductAddDAO;
import master.product.DAO.ProductDAO;
import master.product.beans.ProductAddBean;
import master.product.beans.ProductCategoryBean;

import java.util.*;
import java.sql.SQLException;
import java.lang.*;

import user.DAO.*;
import user.beans.*;

public class ProductAddController extends BaseController{
	
	public ProductAddController() {
		
	}
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");
		
		
		try {
			if(action.equals("moveAddProduct")) forwardURL = moveAddProduct(request, response);
			else if(action.equals("addProduct")) forwardURL = addProduct(request, response);
		
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

  		return forwardURL;
  	}


	private String addProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String forwardURL = "/productaddmodify.jsp";
		String productCode = request.getParameter("productCode");
		String productName = request.getParameter("productName");
		String productKana = request.getParameter("productKana");
		String onlinePcode = request.getParameter("onlinePcode");
		String janCode = request.getParameter("janCode");
		String discardDate = request.getParameter("discardDate");
		String supplierCode = request.getParameter("supplierCode");
		String supplierPcode = request.getParameter("supplierPcode");
		String supplierPriceYen = request.getParameter("supplierPriceYen");
		String supplierPriceDol = request.getParameter("supplierPriceDol");
		String stockCtlCategory = request.getParameter("stockCtlCategory");
		String packQuantity = request.getParameter("packQuantity");
		String avgShipCount = request.getParameter("avgShipCount");
		String warehouseName = request.getParameter("warehouseName");
		String rackCode = request.getParameter("rackCode");
		String leadTime = request.getParameter("leadTime");
		String poNum = request.getParameter("poNum");
		String poUpdFlag = request.getParameter("poUpdFlag");
		String mineSafetyStock = request.getParameter("mineSafetyStock");
		String mineSafetyStockUpdFlage = request.getParameter("mineSafetyStockUpdFlag");
		String poLot = request.getParameter("poLot");
		String lotUpdFlag = request.getParameter("lotUpdFlag");
		String maxStockNum = request.getParameter("maxStockNum");
		String StockUpdFlag = request.getParameter("StockUpdFlag");
		String  maxPoNum = request.getParameter("maxPoNum");
		String maxPoUpdFlag = request.getParameter("maxPoUpdFlag");
		String roMaxNum = request.getParameter("roMaxNum");
		String retailPrice = request.getParameter("retailPrice");
		String discountId = request.getParameter("discountId");
		String productStatusCategory = request.getParameter("productStatusCategory");
		String productStockCategory = request.getParameter("productStockCategory");
		String productPurvayCategory = request.getParameter("productPurvayCategory");
		String productStandardCategory = request.getParameter("productStandardCategory");
		String soRate = request.getParameter("soRate");
		String setTypeCategory = request.getParameter("setTypeCategory");
		String product1 = request.getParameter("product1");
		String product2 = request.getParameter("product2");
		String product3 = request.getParameter("product3");
		String unitCategory = request.getParameter("unitCategory");
		String weight = request.getParameter("weight");
		String weightUnitSizeCategory = request.getParameter("weightUnitSizeCategory");
		String length = request.getParameter("length");
		String lengthUnitSizeCategory = request.getParameter("lengthUnitSizeCategory");
		String length = request.getParameter("length");
		String length = request.getParameter("length");
		String length = request.getParameter("length");
		String length = request.getParameter("length");
		String length = request.getParameter("length");
		String length = request.getParameter("length");
		String length = request.getParameter("length");
		String length = request.getParameter("length");
		String length = request.getParameter("length");
		
		
				
		
		
		String message = null;
		ProductAddBean bean = new ProductAddBean();
		ProductAddDAO dao = new ProductAddDAO();
		
		return forwardURL;
	}



	private String moveAddProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	
		String productCode;
	
		productCode = (String) request.getParameter("productCode");
	
		request.setAttribute("productCode", productCode);
	
		//System.out.println(productCode);
	
		return "/productaddmodify.jsp";
	}
}

