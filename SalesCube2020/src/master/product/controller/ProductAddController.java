package master.product.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;
import master.product.DAO.ProductAddDAO;
import master.product.beans.ProductAddBean;

import java.util.*;
import java.sql.SQLException;

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
		String janPcode = request.getParameter("janPcode");
		String discardDate = request.getParameter("discardDate");
		String supplierCode = request.getParameter("supplierCode");
		String supplierName = request.getParameter("supplierName");
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
		String stockUpdFlag = request.getParameter("stockUpdFlag");
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
		String width = request.getParameter("width");
		String widthUnitSizeCategory = request.getParameter("widthUnitSizeCategory");
		String depth = request.getParameter("depth");
		String depthUnitSizeCategory = request.getParameter("depthUnitSizeCategory");
		String height = request.getParameter("height");
		String heightUnitSizeCategory = request.getParameter("heightUnitSizeCategory");
		String coreNum = request.getParameter("coreNum");
		String remarks = request.getParameter("remarks");
		String eadRemarks = request.getParameter("eadRemarks");
		String commentData = request.getParameter("commentData");
		
		
		try {
			Date sqlDate = Date.valueOf(discardDate);
			int isupplierPriceYen = Integer.parseInt(supplierPriceYen);
			int isupplierPriceDol = Integer.parseInt(supplierPriceDol);
			int ipackQuantity = Integer.parseInt(packQuantity);
			int iavgShipCount = Integer.parseInt(avgShipCount);
			int ileadTime = Integer.parseInt(leadTime);
			int ipoNum = Integer.parseInt(poNum);
			short spoUpdFlag = Short.parseShort(poUpdFlag);
			int imineSafetyStock = Integer.parseInt(mineSafetyStock);
			short smineSafetyStockUpdFlag =Short.parseShort(mineSafetyStockUpdFlag);
			int ipoLot = Integer.parseInt(poLot);
			short slotUpdFlag = Short.parseShort(lotUpdFlag);
			int imaxStockNum = Integer.parseInt(maxStockNum);
			int istockUpdFlag = Integer.parseInt(stockUpdFlag);
			int imaxPoNum = Integer.parseInt(maxPoNum);
			short smaxPoUpdFlag = Short.parseShort(maxPoUpdFlag);
			short sroMaxNum = Short.parseShort(roMaxNum);
			int iretailPrice =Integer.parseInt(retailPrice);
			int isoRate =Integer.parseInt(soRate);
			double dweight = Double.parseDouble(weight);
			double dlength = Double.parseDouble(length);
			double dwidth = Double.parseDouble(width);
			double ddepth = Double.parseDouble(depth);
			double dheight = Double.parseDouble(height);
			
			
			ProductAddBean bean = new ProductAddBean();
			bean.setProductCode(productCode);
			bean.setProductName(productName);
			bean.setProductKana(productKana);
			bean.setOnlinePcode(onlinePcode);
			bean.setJanPcode(janPcode);
			bean.setDiscardDate(sqlDate);
			bean.setSupplierCode(supplierCode);
			bean.setSupplierName(supplierName);
			bean.setSupplierPcode(supplierPcode);
			bean.setSupplierPriceYen(isupplierPriceYen);
			bean.setSupplierPriceDol(isupplierPriceDol);
			bean.setStockCtlCategory(stockCtlCategory);
			bean.setPackQuantity(ipackQuantity);
			bean.setAvgShipCount(iavgShipCount);
			bean.setWarehouseName(warehouseName);
			bean.setRackCode(rackCode);
			bean.setLeadTime(ileadTime);
			bean.setPoNum(ipoNum);
			bean.setPoUpdFlag(spoUpdFlag);
			bean.setMineSafetyStock(imineSafetyStock);
			bean.setMineSafetyStockUpdFlag(smineSafetyStockUpdFlag);
			bean.setPoLot(ipoLot);
			bean.setLotUpdFlag(slotUpdFlag);
			bean.setMaxStockNum(imaxStockNum);
			bean.setStockUpdFlag(istockUpdFlag);
			bean.setMaxPoNum(imaxPoNum);
			bean.setMaxPoUpdFlag(smaxPoUpdFlag);
			bean.setRoMaxNum(sroMaxNum);
			bean.setRetailPrice(iretailPrice);
			bean.setDiscountId(discountId);
			bean.setProductStatusCategory(productStatusCategory);
			bean.setProductStockCategory(productStockCategory);
			bean.setProductPurvayCategory(productPurvayCategory);
			bean.setProductStandardCategory(productStandardCategory);
			bean.setSoRate(isoRate);
			bean.setSetTypeCategory(setTypeCategory);
			bean.setProduct1(product1);
			bean.setProduct2(product2);
			bean.setProduct3(product3);
			bean.setWeight(dweight);
			bean.setWeightUnitSizeCategory(weightUnitSizeCategory);
			bean.setLength(dlength);
			bean.setLengthUnitSizeCategory(lengthUnitSizeCategory);
			bean.setWidth(dwidth);
			bean.setWidthUnitSizeCategory(widthUnitSizeCategory);
			bean.setDepth(ddepth);
			bean.setDepthUnitSizeCategory(depthUnitSizeCategory);
			bean.setHeight(dheight);
			bean.setHeightUnitSizeCategory(heightUnitSizeCategory);
			bean.setCoreNum(coreNum);
			bean.setRemarks(remarks);
			bean.setEadRemarks(eadRemarks);
			bean.setCommentData(commentData);
			
			
			ProductAddDAO dao = new ProductAddDAO();
			int result = dao.addProduct(bean);
			
			if( result == 0 ) {
				request.setAttribute("message", "");
			}else{
				request.setAttribute("message", "’Ç‰Á‚ðŠ®—¹‚µ‚Ü‚µ‚½");
			}
			
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

