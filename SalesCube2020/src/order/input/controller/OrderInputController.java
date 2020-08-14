package order.input.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.BaseController;
import order.input.DAO.OrderInputDAO;
import order.input.beans.OrderInputBean;
import order.input.beans.OrderInputCalcBean;
import order.input.beans.OrderInputCustomerBean;
import order.input.beans.OrderInputDeliveryBean;


public class OrderInputController extends BaseController {

	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");
				
		if(action.equals("orderinputCmp")) {
			try {
				forwardURL = orderInput(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(action.equals("orderupdateCmp")) {
				try {
					forwardURL = orderUpdate(request, response);
				} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return forwardURL;
	}
	
	/* 受注新規登録 */
	private String orderInput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		OrderInputDAO dao = new OrderInputDAO();
		List<OrderInputBean> list = new ArrayList<>();
		
		String roDate = nullOrEmpty(request.getParameter("roDate"));
		String shipDate = nullOrEmpty(request.getParameter("shipDate"));
		String deliveryDate = nullOrEmpty(request.getParameter("deliveryDate"));
		String ReceptNo = nullOrEmpty(request.getParameter("ReceptNo"));
		String customerSlipNo = nullOrEmpty(request.getParameter("customerSlipNo"));
		String userName = nullOrEmpty(request.getParameter("userName"));
		String remarks = nullOrEmpty(request.getParameter("remarks"));
		String dcName = nullOrEmpty(request.getParameter("dcName"));
		String dcTimezone = nullOrEmpty(request.getParameter("dcTimezone"));
		String ctaxRate = nullOrEmpty(request.getParameter("ctaxRate"));
		String customerCode = request.getParameter("customerCode");
		String customerName = nullOrEmpty(request.getParameter("customerName"));
		String taxShiftCategory = nullOrEmpty(request.getParameter("taxShiftCategory"));
		String cutoffGroup = nullOrEmpty(request.getParameter("cutoffGroup"));
		String salesCmCategory = nullOrEmpty(request.getParameter("salesCmCategory"));
		String customerRemarks = nullOrEmpty(request.getParameter("customerRemarks"));
		String customerCommentData = nullOrEmpty(request.getParameter("customerCommentData"));
		String deliveryName = nullOrEmpty(request.getParameter("deliveryName"));
		String deliveryOfficeName = nullOrEmpty(request.getParameter("deliveryOfficeName"));
		String deliveryDeptName = nullOrEmpty(request.getParameter("deliveryDeptName"));
		String deliveryZipCode = nullOrEmpty(request.getParameter("deliveryZipCode"));
		String deliveryAddress1 = nullOrEmpty(request.getParameter("deliveryAddress1"));
		String deliveryAddress2 = nullOrEmpty(request.getParameter("deliveryAddress2"));
		String deliveryPcName = nullOrEmpty(request.getParameter("deliveryPcName"));
		String deliveryPcKana = nullOrEmpty(request.getParameter("deliveryPcKana"));
		String deliveryPcPre = nullOrEmpty(request.getParameter("deliveryPcPre"));
		String deliveryTel = nullOrEmpty(request.getParameter("deliveryTel"));
		String deliveryFax = nullOrEmpty(request.getParameter("deliveryFax"));
		String deliveryEmail = nullOrEmpty(request.getParameter("deliveryEmail"));
		String[] productCode = request.getParameterValues("productCode");
		String[] productName = request.getParameterValues("productName");
		String[] productRemarks = request.getParameterValues("productRemarks");
		String[] rackCode = request.getParameterValues("rackCode");
		String[] quantity = request.getParameterValues("quantity");
		String[] unitCost = request.getParameterValues("unitCost");
		String[] cost = request.getParameterValues("cost");
		String[] unitRetailPrice = request.getParameterValues("unitRetailPrice");
		String[] retailPrice = request.getParameterValues("retailPrice");
		String[] inputProductRemarks = request.getParameterValues("inputProductRemarks");
		String[] eadRemarks = request.getParameterValues("eadRemarks");
		Integer retailPriceTotal = 0;
		Integer ctaxPriceTotal = 0;
		Integer priceTotal = 0;
		
		if(request.getParameter("retailPriceTotal") == null || request.getParameter("retailPriceTotal").contentEquals("")) {
			retailPriceTotal = 0;
		}else {
			retailPriceTotal = Integer.parseInt(request.getParameter("retailPriceTotal"));
		}
		if(request.getParameter("ctaxPriceTotal") == null || request.getParameter("ctaxPriceTotal").contentEquals("")) {
			ctaxPriceTotal = 0;
		}else {
			ctaxPriceTotal = Integer.parseInt(request.getParameter("ctaxPriceTotal"));
		}
		if(request.getParameter("priceTotal") == null || request.getParameter("priceTotal").contentEquals("")) {
			priceTotal = 0;
		}else {
			priceTotal = Integer.parseInt(request.getParameter("priceTotal"));
		}
		
		OrderInputBean bean = new OrderInputBean();
		bean.setRoDate(roDate);
		bean.setShipDate(shipDate);
		bean.setDeliveryDate(deliveryDate);
		bean.setReceptNo(ReceptNo);
		bean.setCustomerSlipNo(customerSlipNo);
		bean.setUserName(userName);
		bean.setRemarks(remarks);
		bean.setDcName(dcName);
		bean.setDcTimezone(dcTimezone);
		bean.setCtaxRate(ctaxRate);
		
		OrderInputCustomerBean bean2 = new OrderInputCustomerBean();
		bean2.setCustomerCode(customerCode);
		bean2.setCustomerName(customerName);
		bean2.setTaxShiftCategory(taxShiftCategory);
		bean2.setCutoffGroup(cutoffGroup);
		bean2.setSalesCmCategory(salesCmCategory);
		bean2.setCustomerRemarks(customerRemarks);
		bean2.setCustomerCommentData(customerCommentData);
		
		OrderInputDeliveryBean bean3 = new OrderInputDeliveryBean();
		bean3.setDeliveryName(deliveryName);
		bean3.setDeliveryOfficeName(deliveryOfficeName);
		bean3.setDeliveryDeptName(deliveryDeptName);
		bean3.setDeliveryZipCode(deliveryZipCode);
		bean3.setDeliveryAddress1(deliveryAddress1);
		bean3.setDeliveryAddress2(deliveryAddress2);
		bean3.setDeliveryPcName(deliveryPcName);
		bean3.setDeliveryPcKana(deliveryPcKana);
		bean3.setDeliveryPcPre(deliveryPcPre);
		bean3.setDeliveryTel(deliveryTel);
		bean3.setDeliveryFax(deliveryFax);
		bean3.setDeliveryEmail(deliveryEmail);
		
		OrderInputCalcBean bean4 = new OrderInputCalcBean();
		bean4.setRetailPriceTotal(retailPriceTotal);
		bean4.setCtaxPriceTotal(ctaxPriceTotal);
		bean4.setPriceTotal(priceTotal);		
		
		if(productCode != null) {
			for(int i = 0; i < productCode.length; i++) {
				bean2.setProductCode(Integer.parseInt(productCode[i]));
				bean2.setProductName(productName[i]);
				bean2.setProductRemarks(productRemarks[i]);
				bean2.setRackCode(rackCode[i]);
				bean2.setQuantity(Integer.parseInt(quantity[i]));
				bean2.setUnitCost(Integer.parseInt(unitCost[i]));
				bean2.setCost(Integer.parseInt(cost[i]));
				bean2.setUnitRetailPrice(Integer.parseInt(unitRetailPrice[i]));
				bean2.setRetailPrice(Integer.parseInt(retailPrice[i]));
				bean2.setInputProductRemarks(inputProductRemarks[i]);
				bean2.setEadRemarks(eadRemarks[i]);
				list.add(bean2);
			}
		}
				
		int result1 = dao.orderInputInfo(bean);
		int result2 = dao.orderInputDetail(list);
		
		if(result1 == 0 && result2 == 0) {
			String message1 = "登録できませんでした。<br>";
			request.setAttribute("inputErr", message1);
		}else {
			String message2 = "登録が完了しました。<br>";
			request.setAttribute("inputCmp", message2);
		}
		
		return "order\\orderinput.jsp";
		
	}
	

	/* 受注更新 */
	private String orderUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		OrderInputDAO dao = new OrderInputDAO();
		List<OrderInputBean> list = new ArrayList<>();
		
		String roDate = request.getParameter("roDate");
		String shipDate = nullOrEmpty(request.getParameter("shipDate"));
		String deliveryDate = nullOrEmpty(request.getParameter("deliveryDate"));
		String ReceptNo = nullOrEmpty(request.getParameter("ReceptNo"));
		String customerSlipNo = nullOrEmpty(request.getParameter("customerSlipNo"));
		String userName = nullOrEmpty(request.getParameter("userName"));
		String remarks = nullOrEmpty(request.getParameter("remarks"));
		String dcName = nullOrEmpty(request.getParameter("dcName"));
		String dcTimezone = nullOrEmpty(request.getParameter("dcTimezone"));
		String ctaxRate = nullOrEmpty(request.getParameter("ctaxRate"));
		String customerCode = request.getParameter("customerCode");
		String customerName = nullOrEmpty(request.getParameter("customerName"));
		String taxShiftCategory = nullOrEmpty(request.getParameter("taxShiftCategory"));
		String cutoffGroup = nullOrEmpty(request.getParameter("cutoffGroup"));
		String salesCmCategory = nullOrEmpty(request.getParameter("salesCmCategory"));
		String customerRemarks = nullOrEmpty(request.getParameter("customerRemarks"));
		String customerCommentData = nullOrEmpty(request.getParameter("customerCommentData"));
		String deliveryName = nullOrEmpty(request.getParameter("deliveryName"));
		String deliveryOfficeName = nullOrEmpty(request.getParameter("deliveryOfficeName"));
		String deliveryDeptName = nullOrEmpty(request.getParameter("deliveryDeptName"));
		String deliveryZipCode = nullOrEmpty(request.getParameter("deliveryZipCode"));
		String deliveryAddress1 = nullOrEmpty(request.getParameter("deliveryAddress1"));
		String deliveryAddress2 = nullOrEmpty(request.getParameter("deliveryAddress2"));
		String deliveryPcName = nullOrEmpty(request.getParameter("deliveryPcName"));
		String deliveryPcKana = nullOrEmpty(request.getParameter("deliveryPcKana"));
		String deliveryPcPre = nullOrEmpty(request.getParameter("deliveryPcPre"));
		String deliveryTel = nullOrEmpty(request.getParameter("deliveryTel"));
		String deliveryFax = nullOrEmpty(request.getParameter("deliveryFax"));
		String deliveryEmail = nullOrEmpty(request.getParameter("deliveryEmail"));
		String[] productCode = request.getParameterValues("productCode");
		String[] productName = request.getParameterValues("productName");
		String[] productRemarks = request.getParameterValues("productRemarks");
		String[] rackCode = request.getParameterValues("rackCode");
		String[] quantity = request.getParameterValues("quantity");
		String[] unitCost = request.getParameterValues("unitCost");
		String[] cost = request.getParameterValues("cost");
		String[] unitRetailPrice = request.getParameterValues("unitRetailPrice");
		String[] retailPrice = request.getParameterValues("retailPrice");
		String[] inputProductRemarks = request.getParameterValues("inputProductRemarks");
		String[] eadRemarks = request.getParameterValues("eadRemarks");
		String prossProfit = nullOrEmpty(request.getParameter("prossProfit"));
		String grossProfitRatio = nullOrEmpty(request.getParameter("grossProfitRatio"));
		String retailPriceTotal = request.getParameter("retailPriceTotal");
		String ctaxPriceTotal = request.getParameter("ctaxPriceTotal");
		String priceTotal = request.getParameter("priceTotal");
		
		OrderInputBean bean = new OrderInputBean();
		bean.setRoDate(roDate);
		bean.setShipDate(shipDate);
		bean.setDeliveryDate(deliveryDate);
		bean.setReceptNo(ReceptNo);
		bean.setCustomerSlipNo(customerSlipNo);
		bean.setUserName(userName);
		bean.setRemarks(remarks);
		bean.setDcName(dcName);
		bean.setDcTimezone(dcTimezone);
		bean.setCtaxRate(ctaxRate);
		bean.setCustomerCode(customerCode);
		bean.setCustomerName(customerName);
		bean.setTaxShiftCategory(taxShiftCategory);
		bean.setCutoffGroup(cutoffGroup);
		bean.setSalesCmCategory(salesCmCategory);
		bean.setCustomerRemarks(customerRemarks);
		bean.setCustomerCommentData(customerCommentData);
		bean.setDeliveryName(deliveryName);
		bean.setDeliveryOfficeName(deliveryOfficeName);
		bean.setDeliveryDeptName(deliveryDeptName);
		bean.setDeliveryZipCode(deliveryZipCode);
		bean.setDeliveryAddress1(deliveryAddress1);
		bean.setDeliveryAddress2(deliveryAddress2);
		bean.setDeliveryPcName(deliveryPcName);
		bean.setDeliveryPcKana(deliveryPcKana);
		bean.setDeliveryPcPre(deliveryPcPre);
		bean.setDeliveryTel(deliveryTel);
		bean.setDeliveryFax(deliveryFax);
		bean.setDeliveryEmail(deliveryEmail);
		bean.setProssProfit(Integer.parseInt(prossProfit));
		bean.setGrossProfitRatio(Integer.parseInt(grossProfitRatio));
		bean.setRetailPriceTotal(Integer.parseInt(retailPriceTotal));
		bean.setCtaxPriceTotal(Integer.parseInt(ctaxPriceTotal));
		bean.setPriceTotal(Integer.parseInt(priceTotal));		
		
		OrderInputBean bean2 = new OrderInputBean();
		
		for(int i = 0; i < productCode.length; i++) {
			bean2.setProductCode(Integer.parseInt(productCode[i]));
			bean2.setProductName(productName[i]);
			bean2.setProductRemarks(productRemarks[i]);
			bean2.setRackCode(rackCode[i]);
			bean2.setQuantity(Integer.parseInt(quantity[i]));
			bean2.setUnitCost(Integer.parseInt(unitCost[i]));
			bean2.setCost(Integer.parseInt(cost[i]));
			bean2.setUnitRetailPrice(Integer.parseInt(unitRetailPrice[i]));
			bean2.setRetailPrice(Integer.parseInt(retailPrice[i]));
			bean2.setInputProductRemarks(inputProductRemarks[i]);
			bean2.setEadRemarks(eadRemarks[i]);
			list.add(bean2);
		}
				
		int result1 = dao.orderUpdateInfo(bean);
		int result2 = dao.orderUpdateDetail(list);
		
		if(result1 == 0 && result2 == 0) {
			String message1 = "更新できませんでした。<br>";
			request.setAttribute("updateErr", message1);
		}else {
			String message2 = "更新が完了しました。<br>";
			request.setAttribute("updateCmp", message2);
		}
		
		return "order\\orderupdate.jsp";
		
	}
	
	public String nullOrEmpty(String str) {
		if (str == null || str.equals("")) {
			str = null;
		}
		return str;
	}
	
}
