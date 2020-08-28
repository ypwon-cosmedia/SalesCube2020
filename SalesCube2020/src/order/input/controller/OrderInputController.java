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
		String[] productCode = request.getParameterValues("productCodeInput");
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
		int arrLength = productCode.length;

		if(request.getParameterValues("productCodeInput") == null) {
			productCode = new String[arrLength];
			productCode = stringArrayIsNull(productCode,arrLength);
		}else {
			productCode = request.getParameterValues("productCodeInput");
		}
		if(request.getParameterValues("productName") == null){
			productName = new String[arrLength];
			productName = stringArrayIsNull(productName,arrLength);
		}else {
			productName = request.getParameterValues("productName");
		}
		if(request.getParameterValues("productRemarks") == null) {
			productRemarks = new String[arrLength];
			productRemarks = stringArrayIsNull(productRemarks,arrLength);
		}else {
			productRemarks = request.getParameterValues("productRemarks");
		}
		if(request.getParameterValues("rackCode") == null) {
			rackCode = new String[arrLength];
			rackCode = stringArrayIsNull(rackCode,arrLength);
		}else {
			rackCode = request.getParameterValues("rackCode");
		}
		if(request.getParameterValues("quantity") == null) {
			quantity = new String[arrLength];
			quantity = stringArrayIsNull(quantity,arrLength);
		}else {
			quantity = request.getParameterValues("quantity");
		}
		if(request.getParameterValues("unitCost") == null) {
			unitCost = new String[arrLength];
			unitCost = stringArrayIsNull(unitCost,arrLength);
		}else {
			unitCost = request.getParameterValues("unitCost");
		}
		if(request.getParameterValues("cost") == null) {
			cost = new String[arrLength];
			cost = stringArrayIsNull(cost,arrLength);
		}else {
			cost = request.getParameterValues("cost");
		}
		if(request.getParameterValues("unitRetailPrice") == null) {
			unitRetailPrice = new String[arrLength];
			unitRetailPrice = stringArrayIsNull(unitRetailPrice,arrLength);
		}else {
			unitRetailPrice = request.getParameterValues("unitRetailPrice");
		}
		if(request.getParameterValues("retailPrice") == null) {
			retailPrice = new String[arrLength];
			retailPrice = stringArrayIsNull(retailPrice,arrLength);
		}else {
			retailPrice = request.getParameterValues("retailPrice");
		}
		if(request.getParameterValues("inputProductRemarks") == null) {
			inputProductRemarks = new String[arrLength];
			inputProductRemarks = stringArrayIsNull(inputProductRemarks,arrLength);
		}else {
			inputProductRemarks = request.getParameterValues("inputProductRemarks");
		}
		if(request.getParameterValues("eadRemarks") == null ) {
			eadRemarks = new String[arrLength];
			eadRemarks = stringArrayIsNull(eadRemarks,arrLength);
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
		
		if(productCode != null) {
			for(int i = 0; i < productCode.length; i++) {
				OrderInputBean bean2 = new OrderInputBean();
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
		
		List<OrderInputBean> list1 = dao.getDcName();
		List<OrderInputBean> list2 = dao.getDcTimezone();
		List<OrderInputBean> list3 = dao.getTaxRate();
				
		int result1 = dao.orderInputInfo(bean);
		int num = dao.roSlipLast();
		int result2 = dao.orderInputDetail(list, num);
		
		try {
			if(result1 == 0 && result2 == 0) {
				String message1 = "登録できませんでした。<br>";
				request.setAttribute("inputErr", message1);
				request.setAttribute("initDcName", list1);
				request.setAttribute("initDcTimezone", list2);
				request.setAttribute("initTaxRate", list3);
			}else {
				String message2 = "登録が完了しました。<br>";
				request.setAttribute("inputCmp", message2);
			}
		}catch (NullPointerException e) {
			String message = "ログインした後で利用できます。\nログインしてください。";
			request.setAttribute("loginError", message);
			return "login.jsp";
		}
		
		
		return "order\\orderinput.jsp";
		
	}
	

	/* 受注更新 */
	private String orderUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		OrderInputDAO dao = new OrderInputDAO();
		List<OrderInputBean> list = new ArrayList<>();
		
		Integer roSlipId = Integer.parseInt(request.getParameter("roSlipId"));
		
		//Delete
		dao.deleteOrderUpdateDetail(roSlipId);

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
		String[] productCode = request.getParameterValues("productCodeInput");
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
		int arrLength = productCode.length;

		if(request.getParameterValues("productCodeInput") == null) {
			productCode = new String[arrLength];
			productCode = stringArrayIsNull(productCode,arrLength);
		}else {
			productCode = request.getParameterValues("productCodeInput");
		}
		if(request.getParameterValues("productName") == null){
			productName = new String[arrLength];
			productName = stringArrayIsNull(productName,arrLength);
		}else {
			productName = request.getParameterValues("productName");
		}
		if(request.getParameterValues("productRemarks") == null) {
			productRemarks = new String[arrLength];
			productRemarks = stringArrayIsNull(productRemarks,arrLength);
		}else {
			productRemarks = request.getParameterValues("productRemarks");
		}
		if(request.getParameterValues("rackCode") == null) {
			rackCode = new String[arrLength];
			rackCode = stringArrayIsNull(rackCode,arrLength);
		}else {
			rackCode = request.getParameterValues("rackCode");
		}
		if(request.getParameterValues("quantity") == null) {
			quantity = new String[arrLength];
			quantity = stringArrayIsNull(quantity,arrLength);
		}else {
			quantity = request.getParameterValues("quantity");
		}
		if(request.getParameterValues("unitCost") == null) {
			unitCost = new String[arrLength];
			unitCost = stringArrayIsNull(unitCost,arrLength);
		}else {
			unitCost = request.getParameterValues("unitCost");
		}
		if(request.getParameterValues("cost") == null) {
			cost = new String[arrLength];
			cost = stringArrayIsNull(cost,arrLength);
		}else {
			cost = request.getParameterValues("cost");
		}
		if(request.getParameterValues("unitRetailPrice") == null) {
			unitRetailPrice = new String[arrLength];
			unitRetailPrice = stringArrayIsNull(unitRetailPrice,arrLength);
		}else {
			unitRetailPrice = request.getParameterValues("unitRetailPrice");
		}
		if(request.getParameterValues("retailPrice") == null) {
			retailPrice = new String[arrLength];
			retailPrice = stringArrayIsNull(retailPrice,arrLength);
		}else {
			retailPrice = request.getParameterValues("retailPrice");
		}
		if(request.getParameterValues("inputProductRemarks") == null) {
			inputProductRemarks = new String[arrLength];
			inputProductRemarks = stringArrayIsNull(inputProductRemarks,arrLength);
		}else {
			inputProductRemarks = request.getParameterValues("inputProductRemarks");
		}
		if(request.getParameterValues("eadRemarks") == null ) {
			eadRemarks = new String[arrLength];
			eadRemarks = stringArrayIsNull(eadRemarks,arrLength);
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
		
		if(productCode != null) {
			for(int i = 0; i < productCode.length; i++) {
				OrderInputBean bean2 = new OrderInputBean();
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
				bean2.setRoSlipId(roSlipId);
				list.add(bean2);
			}
		}
				
		int result1 = dao.orderUpdateInfo(bean);
		int result2 = dao.orderUpdateDetail(list);
		
		List<OrderInputBean> list1 = dao.getDcName();
		List<OrderInputBean> list2 = dao.getDcTimezone();
		List<OrderInputBean> list3 = dao.getTaxRate();
		
		try {
			if(result1 == 0 && result2 == 0) {
				String message1 = "更新できませんでした。<br>";
				request.setAttribute("updateErr", message1);
				request.setAttribute("initDcName", list1);
				request.setAttribute("initDcTimezone", list2);
				request.setAttribute("initTaxRate", list3);
			}else {
				String message2 = "更新が完了しました。<br>";
				request.setAttribute("updateCmp", message2);
			}
		}catch (NullPointerException e) {
			String message = "ログインした後で利用できます。\nログインしてください。";
			request.setAttribute("loginError", message);
			return "login.jsp";
		}
		
		
		return "order\\orderinput.jsp";
		
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
			
			try {
			//Delete Check
				if( check == 0 ) {
					String message = "削除ができませんでした";
					request.setAttribute("deleteError", message);
				}else{
					String message = "削除が完了しました";
					request.setAttribute("deleteCmp", message);
				}
			}catch (NullPointerException e) {
				String message = "ログインした後で利用できます。\nログインしてください。";
				request.setAttribute("loginError", message);
				return "login.jsp";
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
		System.out.println(estimateSheetId);
		
		bean1 = dao.billToTaxRate(estimateSheetId);
		bean2 = dao.billToCustomer(estimateSheetId);
		bean3 = dao.billToDelivery(String.valueOf(dao.billToCustomerCode(estimateSheetId))); 
		
		List<OrderInputBean> list1 = dao2.getDcName();
		List<OrderInputBean> list2 = dao2.getDcTimezone();
		List<OrderInputBean> list3 = dao2.getTaxRate();
		List<OrderCommonBillBean> list4 = dao.billToDeliveryCode(String.valueOf(dao.billToCustomerCode(estimateSheetId)));
		init.initCombobox(request, response);

		try {
			request.setAttribute("initDcName", list1);
			request.setAttribute("initDcTimezone", list2);
			request.setAttribute("initTaxRate", list3);
			request.setAttribute("deliveryCodeName", list4);
			
			request.setAttribute("stockTaxRate", bean1);
			request.setAttribute("stockCustomer", bean2);
			request.setAttribute("stockDelivery", bean3);
		}catch (NullPointerException e) {
			String message = "ログインした後で利用できます。\nログインしてください。";
			request.setAttribute("loginError", message);
			return "login.jsp";
		}
		
		return "order\\orderinput.jsp";

	}
	
	public String[] stringArrayIsNull(String[] str, int num) {
		for(int i = 0; i<num; i++) {
			str[i] = "";
		}
		return str;
	}
	
}
