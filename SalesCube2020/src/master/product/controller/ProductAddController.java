package master.product.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.beans.ProductPurvayCategoryBean;
import common.beans.ProductStandardCategoryBean;
import common.beans.ProductStatusCategoryBean;
import common.beans.ProductStockCategoryBean;
import common.beans.SetTypeCategoryBean;
import common.controller.BaseController;
import common.dao.MenuDAO;
import master.product.DAO.GetCategoryDAO;
import master.product.DAO.ProductAddDAO;
import master.product.beans.ProductAddBean;
import master.product.beans.ProductCategoryAllBean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.sql.Date;

public class ProductAddController extends BaseController{
	
	public ProductAddController() {
		
	}
	
	public String execService(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");
		
		
		try {
			if(action.equals("moveAddProduct")) forwardURL = moveAddProduct(request, response);
			else if(action.equals("addProduct")) forwardURL = addProduct(request, response);
		
		
		}catch(ServletException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

  		return forwardURL;
  	}


	private String addProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		String forwardURL = "/productsearch.jsp";
		String productCode = request.getParameter("productCode");
			//System.out.println(productCode);
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
		String mineSafetyStockUpdFlag = request.getParameter("mineSafetyStockUpdFlag");
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
			Date date;
			if(discardDate == null || discardDate.equals("")) {
				date = null;
			}
			else {
				date = Date.valueOf(discardDate);
			}
			
			if (request.getParameter("supplierPriceYen") == null) {
				supplierPriceYen = "";
			}else {
				supplierPriceYen = request.getParameter("supplierPriceYen");
			}
			
			if (request.getParameter("supplierPriceDol") == null) {
				supplierPriceDol = "";
			}else {
				supplierPriceDol = request.getParameter("supplierPriceDol");
			}
			
			if (request.getParameter("packQuantity") == null) {
				packQuantity = "";
			}else {
				packQuantity = request.getParameter("packQuantity");
			}
			
			if (request.getParameter("avgShipCount") == null) {
				avgShipCount = "";
			}else {
				avgShipCount = request.getParameter("avgShipCount");
			}
			
			if (request.getParameter("leadTime") == null) {
				leadTime = "";
			}else {
				leadTime = request.getParameter("leadTime");
			}
			
			if (request.getParameter("poNum") == null) {
				poNum = "";
			}else {
				poNum = request.getParameter("poNum");
			}
			
			if (request.getParameter("poUpdFlag") == null) {
				poUpdFlag = "";
			}else {
				poUpdFlag = request.getParameter("poUpdFlag");
			}
			
			if (request.getParameter("mineSafetyStock") == null) {
				mineSafetyStock = "";
			}else {
				mineSafetyStock = request.getParameter("mineSafetyStock");
			}
			
			if (request.getParameter("mineSafetyStockUpdFlag") == null) {
				mineSafetyStockUpdFlag = "";
			}else {
				mineSafetyStockUpdFlag = request.getParameter("mineSafetyStockUpdFlag");
			}
			
			if (request.getParameter("poLot") == null) {
				poLot = "";
			}else {
				poLot = request.getParameter("poLot");
			}
			
			if (request.getParameter("lotUpdFlag") == null) {
				lotUpdFlag = "";
			}else {
				lotUpdFlag = request.getParameter("lotUpdFlag");
			}
			
			if (request.getParameter("maxStockNum") == null) {
				maxStockNum = "";
			}else {
				maxStockNum = request.getParameter("maxStockNum");
			}
			
			if (request.getParameter("stockUpdFlag") == null) {
				stockUpdFlag = "";
			}else {
				stockUpdFlag = request.getParameter("stockUpdFlag");
			}
			
			if (request.getParameter("maxPoNum") == null) {
				maxPoNum = "";
			}else {
				maxPoNum = request.getParameter("maxPoNum");
			}
			
			if (request.getParameter("maxPoUpdFlag") == null) {
				maxPoUpdFlag = "";
			}else {
				maxPoUpdFlag = request.getParameter("maxPoUpdFlag");
			}
			
			if (request.getParameter("roMaxNum") == null) {
				roMaxNum = "";
			}else {
				roMaxNum = request.getParameter("roMaxNum");
			}
			
			if (request.getParameter("retailPrice") == null) {
				retailPrice = "";
			}else {
				retailPrice = request.getParameter("retailPrice");
			}
			
			if (request.getParameter("soRate") == null) {
				soRate = "";
			}else {
				soRate = request.getParameter("soRate");
			}
			
			if (request.getParameter("weight") == null) {
				weight = "";
			}else {
				weight = request.getParameter("weight");
			}
			
			if (request.getParameter("length") == null) {
				length = "";
			}else {
				length = request.getParameter("length");
			}
			
			if (request.getParameter("width") == null) {
				width = "";
			}else {
				width = request.getParameter("width");
			}
			
			if (request.getParameter("depth") == null) {
				depth = "";
			}else {
				depth = request.getParameter("depth");
			}
			
			
			if (request.getParameter("height") == null) {
				height = "";
			}else {
				height = request.getParameter("height");
			}
/*			
 *
 			int isupplierPriceYen = Integer.parseInt(supplierPriceYen);
			Integer isupplierPriceDol = new Integer(request.getParameter("supplierPriceDol"));
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
*/
			
			
			ProductAddBean bean = new ProductAddBean();
			bean.setProductCode(productCode);
			bean.setProductName(productName);
			bean.setProductKana(productKana);
			bean.setOnlinePcode(onlinePcode);
			bean.setJanPcode(janPcode);
			bean.setDiscardDate(date);
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
			
				String message = "é∏îs";
				request.setAttribute("addmodifyError", message);
			}else{
				request.setAttribute("message", "ê¨å˜");
			}
		}catch(NumberFormatException e) {
			request.setAttribute("message", "ê≥ÇµÇ≠ì¸óÕÇµÇƒÇ≠ÇæÇ≥Ç¢");
			e.printStackTrace();
		}
			
			
			
			return forwardURL;
	}

	
	private String moveAddProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		
		List<ProductStockCategoryBean> list2 = new ArrayList<>();
		List<SetTypeCategoryBean> list3 = new ArrayList<>();
		List<ProductStandardCategoryBean> list4 = new ArrayList<ProductStandardCategoryBean>();
		List<ProductStatusCategoryBean> list5 = new ArrayList<ProductStatusCategoryBean>();
		List<ProductCategoryAllBean> list8 = new ArrayList<ProductCategoryAllBean>();
		List<ProductPurvayCategoryBean> list = new ArrayList<ProductPurvayCategoryBean>();
		
		GetCategoryDAO dao = new GetCategoryDAO();
		MenuDAO dao2 = new MenuDAO();
		
		try {
			list2 = dao2.getProductStockCategory();
			list3 = dao2.getSetTypeCategory();
			list4 = dao2.getProductStandardCategory();
			list5 = dao2.getProductStatusCategory();
			list8 = dao.getAllCategory();
			list = dao2.getProductPurvayCategory();
		} catch (ClassNotFoundException | MissingResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("prosearch", list2);
		request.setAttribute("setTypeCategory", list3);
		request.setAttribute("productStandardCategory", list4);
		request.setAttribute("productStatusCategory", list5);	
		request.setAttribute("all", list8);
		request.setAttribute("purvey", list);
		
		request.setAttribute("status", "add");
		
		return "/productaddmodify.jsp";
	}
}

