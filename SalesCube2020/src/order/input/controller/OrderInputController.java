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
import common.modal.product.init.ProductModalInit;
import master.product.DAO.GetCategoryDAO;
import master.product.DAO.ProductDeleteDAO;
import master.product.beans.ProductCategoryAllBean;
import order.common.bill.DAO.OrderCommonBillDAO;
import order.common.bill.beans.OrderCommonBillBean;
import order.input.DAO.OrderInputDAO;
import order.input.beans.OrderInputBean;


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
		}else if(action.equals("deleteOrder")) {
			try {
				forwardURL = deleteOrder(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(action.equals("billlink")) {
			try {
				forwardURL = EstimateToOrderInput(request, response);
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
		String[] productName;
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

		if(request.getParameterValues("productCode") == null || request.getParameterValues("productCode")[0].equals("")) {
			productCode = null ;
		}else {
			productCode = request.getParameterValues("productCode");
		}
		if(request.getParameterValues("productName") == null || request.getParameterValues("productName").equals("")) {
			productName = null ;
		}else {
			productName = request.getParameterValues("productName");
		}
		if(request.getParameterValues("productRemarks") == null || request.getParameterValues("productRemarks").equals("")) {
			productRemarks = null;
		}else {
			productRemarks = request.getParameterValues("productRemarks");
		}
		if(request.getParameterValues("rackCode") == null || request.getParameterValues("rackCode").equals("")) {
			rackCode = null;
		}else {
			rackCode = request.getParameterValues("rackCode");
		}
		if(request.getParameterValues("quantity") == null || request.getParameterValues("quantity").equals("")) {
			quantity = null;
		}else {
			quantity = request.getParameterValues("quantity");
		}
		if(request.getParameterValues("unitCost") == null || request.getParameterValues("unitCost").equals("")) {
			unitCost = null;
		}else {
			unitCost = request.getParameterValues("unitCost");
		}
		if(request.getParameterValues("cost") == null || request.getParameterValues("cost").equals("")) {
			cost = null;
		}else {
			cost = request.getParameterValues("cost");
		}
		if(request.getParameterValues("unitRetailPrice") == null || request.getParameterValues("unitRetailPrice").equals("")) {
			unitRetailPrice = null;
		}else {
			unitRetailPrice = request.getParameterValues("unitRetailPrice");
		}
		if(request.getParameterValues("retailPrice") == null || request.getParameterValues("retailPrice").equals("")) {
			retailPrice = null;
		}else {
			retailPrice = request.getParameterValues("retailPrice");
		}
		if(request.getParameterValues("inputProductRemarks") == null || request.getParameterValues("inputProductRemarks").equals("")) {
			inputProductRemarks = null;
		}else {
			inputProductRemarks = request.getParameterValues("inputProductRemarks");
		}
		if(request.getParameterValues("eadRemarks") == null || request.getParameterValues("eadRemarks").equals("")) {
			eadRemarks = null;
		}else {
			eadRemarks = request.getParameterValues("eadRemarks");
		}
		
		
		if(request.getParameter("retailPriceTotal") == null || request.getParameter("retailPriceTotal").equals("")) {
			retailPriceTotal = 0;
		}else {
			retailPriceTotal = Integer.parseInt(request.getParameter("retailPriceTotal"));
		}
		if(request.getParameter("ctaxPriceTotal") == null || request.getParameter("ctaxPriceTotal").equals("")) {
			ctaxPriceTotal = 0;
		}else {
			ctaxPriceTotal = Integer.parseInt(request.getParameter("ctaxPriceTotal"));
		}
		if(request.getParameter("priceTotal") == null || request.getParameter("priceTotal").equals("")) {
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
		bean.setRetailPriceTotal(retailPriceTotal);
		bean.setCtaxPriceTotal(ctaxPriceTotal);
		bean.setPriceTotal(priceTotal);		
		
		OrderInputBean bean2 = new OrderInputBean();
		if(productCode != null) {
			for(int i = 0; i < productCode.length; i++) {
				bean2.setProductCode(productCode[i]);
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
		
		Integer roSlipId = Integer.parseInt(request.getParameter("roSlipId"));

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
		String[] productName;
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
		
		if(request.getParameterValues("productCode") == null || request.getParameterValues("productCode")[0].equals("")) {
			productCode = null ;
		}else {
			productCode = request.getParameterValues("productCode");
		}
		if(request.getParameterValues("productName") == null || request.getParameterValues("productName").equals("")) {
			productName = null ;
		}else {
			productName = request.getParameterValues("productName");
		}
		if(request.getParameterValues("productRemarks") == null || request.getParameterValues("productRemarks").equals("")) {
			productRemarks = null;
		}else {
			productRemarks = request.getParameterValues("productRemarks");
		}
		if(request.getParameterValues("rackCode") == null || request.getParameterValues("rackCode").equals("")) {
			rackCode = null;
		}else {
			rackCode = request.getParameterValues("rackCode");
		}
		if(request.getParameterValues("quantity") == null || request.getParameterValues("quantity").equals("")) {
			quantity = null;
		}else {
			quantity = request.getParameterValues("quantity");
		}
		if(request.getParameterValues("unitCost") == null || request.getParameterValues("unitCost").equals("")) {
			unitCost = null;
		}else {
			unitCost = request.getParameterValues("unitCost");
		}
		if(request.getParameterValues("cost") == null || request.getParameterValues("cost").equals("")) {
			cost = null;
		}else {
			cost = request.getParameterValues("cost");
		}
		if(request.getParameterValues("unitRetailPrice") == null || request.getParameterValues("unitRetailPrice").equals("")) {
			unitRetailPrice = null;
		}else {
			unitRetailPrice = request.getParameterValues("unitRetailPrice");
		}
		if(request.getParameterValues("retailPrice") == null || request.getParameterValues("retailPrice").equals("")) {
			retailPrice = null;
		}else {
			retailPrice = request.getParameterValues("retailPrice");
		}
		if(request.getParameterValues("inputProductRemarks") == null || request.getParameterValues("inputProductRemarks").equals("")) {
			inputProductRemarks = null;
		}else {
			inputProductRemarks = request.getParameterValues("inputProductRemarks");
		}
		if(request.getParameterValues("eadRemarks") == null || request.getParameterValues("eadRemarks").equals("")) {
			eadRemarks = null;
		}else {
			eadRemarks = request.getParameterValues("eadRemarks");
		}
		
		
		if(request.getParameter("retailPriceTotal") == null || request.getParameter("retailPriceTotal").equals("")) {
			retailPriceTotal = 0;
		}else {
			retailPriceTotal = Integer.parseInt(request.getParameter("retailPriceTotal"));
		}
		if(request.getParameter("ctaxPriceTotal") == null || request.getParameter("ctaxPriceTotal").equals("")) {
			ctaxPriceTotal = 0;
		}else {
			ctaxPriceTotal = Integer.parseInt(request.getParameter("ctaxPriceTotal"));
		}
		if(request.getParameter("priceTotal") == null || request.getParameter("priceTotal").equals("")) {
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
		bean.setRetailPriceTotal(retailPriceTotal);
		bean.setCtaxPriceTotal(ctaxPriceTotal);
		bean.setPriceTotal(priceTotal);	
		bean.setRoSlipId(roSlipId);
		
		OrderInputBean bean2 = new OrderInputBean();
		
		if(productCode != null) {
			for(int i = 0; i < productCode.length; i++) {
				bean2.setProductCode(productCode[i]);
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
	
	/* 受注削除 */
	private String deleteOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {

			String forwardURL = "order\\orderinput.jsp";	
			
			//Delete
			String roSlipId = request.getParameter("roSlipId");
			OrderInputDAO dao = new OrderInputDAO();
			int check = dao.deleteOrder(roSlipId);
			
			//Delete Check
			if( check == 0 ) {
				String message = "削除ができませんでした";
				request.setAttribute("deleteError", message);
			}else{
				String message = "削除が完了しました";
				request.setAttribute("deleteCmp", message);
			}
			
			return forwardURL;

	}
	
	/* 見積番号押下 受注新規登録画面に反映 */
	private String EstimateToOrderInput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		ProductModalInit init = new ProductModalInit();
		OrderCommonBillDAO dao = new OrderCommonBillDAO();
		OrderInputDAO dao2 = new OrderInputDAO();
		OrderCommonBillBean bean1 = new OrderCommonBillBean();
		OrderCommonBillBean bean2 = new OrderCommonBillBean();
		OrderCommonBillBean bean3 = new OrderCommonBillBean();
		
		String estimateSheetId = request.getParameter("estimateSheetId");
		
		bean1 = dao.billToTaxRate(estimateSheetId);
		bean2 = dao.billToCustomer(estimateSheetId);
		bean3 = dao.billToDelivery(estimateSheetId);
		
		List<OrderInputBean> list1 = dao2.getDcName();
		List<OrderInputBean> list2 = dao2.getDcTimezone();
		List<OrderInputBean> list3 = dao2.getTaxRate();
		init.initCombobox(request, response);


		request.setAttribute("initDcName", list1);
		request.setAttribute("initDcTimezone", list2);
		request.setAttribute("initTaxRate", list3);
		
		request.setAttribute("stockTaxRate", bean1);
		request.setAttribute("stockCustomer", bean2);
		request.setAttribute("stockDelivery", bean3);
		
		return "order\\orderinput.jsp";

	}
	
}
