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
import master.product.DAO.MoveModifyProductDAO;
import master.product.DAO.ProductModifyDAO;
import master.product.DAO.ProductSearchDAO;
import master.product.beans.ProductCategoryAllBean;
import master.product.beans.ProductModifyBean;
import master.product.beans.ProductResultBean;
import master.product.beans.ProductSearchBean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.sql.Date;


public class ProductModifyController extends BaseController{
	
	public ProductModifyController() {
		
	}
	
	public String execService(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");
		
		
		try {
			if(action.equals("moveModifyProduct")) forwardURL = moveModifyProduct(request, response);
			else if(action.equals("modifyProduct")) forwardURL = modifyProduct(request, response);
		
		
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


	private String modifyProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	

		
		try {
			String productCode = nullOrEmpty(request.getParameter("productCode"));
			String productName = nullOrEmpty(request.getParameter("productName"));
			String productKana = nullOrEmpty(request.getParameter("productKana"));
			String onlinePcode = nullOrEmpty(request.getParameter("onlinePcode"));
			String janPcode = nullOrEmpty(request.getParameter("janPcode"));
			String discardDate = nullOrEmpty(request.getParameter("discardDate"));
			String supplierCode = nullOrEmpty(request.getParameter("supplierCode"));
			String supplierName = nullOrEmpty(request.getParameter("supplierName"));
			String supplierPcode = nullOrEmpty(request.getParameter("supplierPcode"));
			String supplierPriceYen = nullOrEmpty(request.getParameter("supplierPriceYen"));
			String supplierPriceDol = nullOrEmpty(request.getParameter("supplierPriceDol"));
			String stockCtlCategory = nullOrEmpty(request.getParameter("stockCtlCategory"));
			String packQuantity = nullOrEmpty(request.getParameter("packQuantity"));
			String avgShipCount = nullOrEmpty(request.getParameter("avgShipCount"));
			String warehouseName = nullOrEmpty(request.getParameter("warehouseName"));
			String rackCode = nullOrEmpty(request.getParameter("rackCode"));
			String leadTime = nullOrEmpty(request.getParameter("leadTime"));
			String poNum = nullOrEmpty(request.getParameter("poNum"));
			String poUpdFlag = nullOrEmpty(request.getParameter("poUpdFlag"));
			String mineSafetyStock = nullOrEmpty(request.getParameter("mineSafetyStock"));
			String mineSafetyStockUpdFlag = nullOrEmpty(request.getParameter("mineSafetyStockUpdFlag"));
			String poLot = nullOrEmpty(request.getParameter("poLot"));
			String lotUpdFlag = nullOrEmpty(request.getParameter("lotUpdFlag"));
			String maxStockNum = nullOrEmpty(request.getParameter("maxStockNum"));
			String stockUpdFlag = nullOrEmpty(request.getParameter("stockUpdFlag"));
			String  maxPoNum = nullOrEmpty(request.getParameter("maxPoNum"));
			String maxPoUpdFlag = nullOrEmpty(request.getParameter("maxPoUpdFlag"));
			String roMaxNum = nullOrEmpty(request.getParameter("roMaxNum"));
			String retailPrice = nullOrEmpty(request.getParameter("retailPrice"));
			String discountId = nullOrEmpty(request.getParameter("discountId"));
			String productStatusCategory = nullOrEmpty(request.getParameter("productStatusCategory"));
			String productStockCategory = nullOrEmpty(request.getParameter("productStockCategory"));
			String productPurvayCategory = nullOrEmpty(request.getParameter("productPurvayCategory"));
			String productStandardCategory = nullOrEmpty(request.getParameter("productStandardCategory"));
			String soRate = nullOrEmpty(request.getParameter("soRate"));
			String setTypeCategory = nullOrEmpty(request.getParameter("setTypeCategory"));
			String product1 = nullOrEmpty(request.getParameter("product1"));
			String product2 = nullOrEmpty(request.getParameter("product2"));
			String product3 = nullOrEmpty(request.getParameter("product3"));
			String unitCategory = nullOrEmpty(request.getParameter("unitCategory"));
			String weight = nullOrEmpty(request.getParameter("weight"));
			String weightUnitSizeCategory = nullOrEmpty(request.getParameter("weightUnitSizeCategory"));
			String length = nullOrEmpty(request.getParameter("length"));
			String lengthUnitSizeCategory = nullOrEmpty(request.getParameter("lengthUnitSizeCategory"));
			String width = nullOrEmpty(request.getParameter("width"));
			String widthUnitSizeCategory = nullOrEmpty(request.getParameter("widthUnitSizeCategory"));
			String depth = nullOrEmpty(request.getParameter("depth"));
			String depthUnitSizeCategory = nullOrEmpty(request.getParameter("depthUnitSizeCategory"));
			String height = nullOrEmpty(request.getParameter("height"));
			String heightUnitSizeCategory = nullOrEmpty(request.getParameter("heightUnitSizeCategory"));
			String coreNum = nullOrEmpty(request.getParameter("coreNum"));
			String remarks = nullOrEmpty(request.getParameter("remarks"));
			String eadRemarks = nullOrEmpty(request.getParameter("eadRemarks"));
			String commentData = nullOrEmpty(request.getParameter("commentData"));
					
			ProductModifyBean bean = new ProductModifyBean();
			bean.setProductCode(productCode);
			bean.setProductName(productName);
			bean.setProductKana(productKana);
			bean.setOnlinePcode(onlinePcode);
			bean.setJanPcode(janPcode);
			bean.setDiscardDate(discardDate);
			bean.setSupplierCode(supplierCode);
			bean.setSupplierName(supplierName);
			bean.setSupplierPcode(supplierPcode);
			bean.setSupplierPriceYen(supplierPriceYen);
			bean.setSupplierPriceDol(supplierPriceDol);
			bean.setStockCtlCategory(stockCtlCategory);
			bean.setPackQuantity(packQuantity);
			bean.setAvgShipCount(avgShipCount);
			bean.setWarehouseName(warehouseName);
			bean.setRackCode(rackCode);
			bean.setLeadTime(leadTime);
			bean.setPoNum(poNum);
			bean.setPoUpdFlag(poUpdFlag);
			bean.setMineSafetyStock(mineSafetyStock);
			bean.setMineSafetyStockUpdFlag(mineSafetyStockUpdFlag);
			bean.setPoLot(poLot);
			bean.setLotUpdFlag(lotUpdFlag);
			bean.setMaxStockNum(maxStockNum);
			bean.setStockUpdFlag(stockUpdFlag);
			bean.setMaxPoNum(maxPoNum);
			bean.setMaxPoUpdFlag(maxPoUpdFlag);
			bean.setRoMaxNum(roMaxNum);
			bean.setRetailPrice(retailPrice);
			bean.setDiscountId(discountId);
			bean.setProductStatusCategory(productStatusCategory);
			bean.setProductStockCategory(productStockCategory);
			bean.setProductPurvayCategory(productPurvayCategory);
			bean.setProductStandardCategory(productStandardCategory);
			bean.setSoRate(soRate);
			bean.setSetTypeCategory(setTypeCategory);
			bean.setProduct1(product1);
			bean.setProduct2(product2);
			bean.setProduct3(product3);
			bean.setUnitCategory(unitCategory);
			bean.setWeight(weight);
			bean.setWeightUnitSizeCategory(weightUnitSizeCategory);
			bean.setLength(length);
			bean.setLengthUnitSizeCategory(lengthUnitSizeCategory);
			bean.setWidth(width);
			bean.setWidthUnitSizeCategory(widthUnitSizeCategory);
			bean.setDepth(depth);
			bean.setDepthUnitSizeCategory(depthUnitSizeCategory);
			bean.setHeight(height);
			bean.setHeightUnitSizeCategory(heightUnitSizeCategory);
			bean.setCoreNum(coreNum);
			bean.setRemarks(remarks);
			bean.setEadRemarks(eadRemarks);
			bean.setCommentData(commentData);
			
			
			ProductModifyDAO dao = new ProductModifyDAO();
			int result = dao.modifyProduct(bean);
			if(discountId != null) {
				dao.modifyProductDiscount(productCode, discountId);
			}

			
			if( result == 0) {
				String message = "編集できませんでした。<br>";
				request.setAttribute("addmodifyError", message);
			}else{
				String message = "編集が完了しました。<br>";
				request.setAttribute("addmodifysuccess", message);
			}
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
			
			return "/productsearch.jsp";
	}

			

	private String moveModifyProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		String productCode;
		
		productCode = (String) request.getParameter("productCode");
		
		request.setAttribute("productCode", productCode);
		
		List<ProductModifyBean> list9 = new ArrayList<ProductModifyBean>();
		List<ProductModifyBean> list10 = new ArrayList<ProductModifyBean>();
		List<ProductModifyBean> list11 = new ArrayList<ProductModifyBean>();
		List<ProductModifyBean> list12 = new ArrayList<ProductModifyBean>();

		MoveModifyProductDAO dao3 = new MoveModifyProductDAO();
		
		List<ProductStockCategoryBean> list2 = new ArrayList<>();
		List<SetTypeCategoryBean> list3 = new ArrayList<>();
		List<ProductStandardCategoryBean> list4 = new ArrayList<ProductStandardCategoryBean>();
		List<ProductStatusCategoryBean> list5 = new ArrayList<ProductStatusCategoryBean>();
		List<ProductCategoryAllBean> list8 = new ArrayList<ProductCategoryAllBean>();
		List<ProductPurvayCategoryBean> list = new ArrayList<ProductPurvayCategoryBean>();
		
		GetCategoryDAO dao = new GetCategoryDAO();
		MenuDAO dao2 = new MenuDAO();
		ProductModifyBean bean = new ProductModifyBean();
		ProductModifyBean bean1 = new ProductModifyBean();
		ProductModifyBean bean2 = new ProductModifyBean();
		ProductModifyBean bean3 = new ProductModifyBean();
		try {
			bean = dao3.moveModifyProduct(productCode);
			bean1 = dao3.moveModifyCategory(productCode);
			bean2 = dao3.moveModifyTokuseiCategory(productCode);
			bean3 = dao3.moveModifyRemarks(productCode);
			
			
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
		request.setAttribute("product", bean);
		request.setAttribute("product1", bean1);
		request.setAttribute("product2", bean2);
		request.setAttribute("product3", bean3);
		
		return "/productaddmodify.jsp";
	}
	
	public String nullOrEmpty(String str) {
		if (str == null || str.equals("")) {
			str = null;
		}
		return str;
	}


}



