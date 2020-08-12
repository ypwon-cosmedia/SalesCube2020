package order.search.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.MissingResourceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import common.controller.BaseAJAXController;
import order.search.beans.OrderSearchBean;
import order.search.dao.OrderSearchDAO;
import user.beans.UserInfoBean;

public class OrderSearchAJAXController extends BaseAJAXController{


	public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("configModalUpdate")) configModalUpdate(request, response);
		else if(action.equals("orderSearch"))
			try {
				orderSearch(request, response);
			} catch (ClassNotFoundException | MissingResourceException | ServletException | IOException
					| SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private void configModalUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrderSearchDAO dao = new OrderSearchDAO();
		HttpSession session = request.getSession(true);
		
		String[] showlistvalue = request.getParameterValues("showlistvalue");
		String searchsubject = request.getParameter("searchsubject");
		UserInfoBean userID = (UserInfoBean) session.getAttribute("userInfo");
		
		
		try {
			dao.configUpdate(showlistvalue, searchsubject, userID.getUserID());
		} catch (ClassNotFoundException | MissingResourceException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void orderSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, MissingResourceException, SQLException {

		OrderSearchDAO dao = new OrderSearchDAO();
		OrderSearchBean bean = new OrderSearchBean();
		Gson gson = new Gson();
		String[] res;
		
		String tmp;
		int count;
		int totalCount;
		int totalPage;
		int currentPage;
		
		bean.setSelectView(request.getParameter("selectView"));
		bean.setOrderNo(request.getParameter("orderNo"));
		bean.setRepNo(request.getParameter("repNo"));
		bean.setOrderDayStart(request.getParameter("orderDayStart"));
		bean.setOrderDayEnd(request.getParameter("orderDayEnd"));
		bean.setShipDayStart(request.getParameter("shipDayStart"));
		bean.setShipDayEnd(request.getParameter("shipDayEnd"));
		bean.setDeliveryDayStart(request.getParameter("deliveryDayStart"));
		bean.setDeliveryDayEnd(request.getParameter("deliveryDayEnd"));
		bean.setCustomerCode(request.getParameter("customerCode"));
		bean.setCustomerName(request.getParameter("customerName"));
		bean.setWithdrawl(request.getParameterValues("withdrawl"));
		bean.setProductCode(request.getParameter("productCode"));
		bean.setProductName(request.getParameter("productName"));
		bean.setProduct1(request.getParameter("product1"));
		bean.setProduct2(request.getParameter("product2"));
		bean.setProduct3(request.getParameter("product3"));
		bean.setSupplierCode(request.getParameter("supplierCode"));
		bean.setSupplierName(request.getParameter("supplierName"));
		
		String sort = request.getParameter("sorting");
		if(sort == null)
			sort = "";
		
		if(bean.getSelectView().equals("伝票")) {
			res = billChanger(request.getParameterValues("list"));
			sort = orderBillChanger(sort);
			totalCount = dao.getBillCount(bean);
			
		} else {
			res = detailChanger(request.getParameterValues("list"));
			sort = orderDetailChanger(sort);
			totalCount = dao.getDetailCount(bean);
		}
		
		
		if(sort.equals("") && bean.getSelectView().equals("伝票"))
			sort = "rstx.RO_SLIP_ID";
		else if(sort.equals("") && bean.getSelectView().equals("明細"))
			sort = "CONCAT(rltx.ro_slip_id, '-', rltx.line_no)";
				
		
		tmp = (String) request.getParameter("rowCount");
		count = Integer.parseInt(tmp);

		totalPage = totalCount/count;
		
		if(totalCount%count != 0) {
			totalPage++;
		}
		

		tmp = (String) request.getParameter("paging");
			
		if(tmp == null) {
			currentPage=1;
		}else {
			currentPage = Integer.parseInt(tmp);
		}
		
		try {
			List<String[]> list = dao.orderSearch(bean, res, Integer.toString(count), sort, currentPage);
			
			JsonObject jobj = new JsonObject();
			jobj.addProperty("currentPage", currentPage);
			
			JsonObject jobj1 = new JsonObject();
			jobj1.addProperty("totalCount", totalCount);
			
			JsonObject jobj2 = new JsonObject();
			jobj2.addProperty("totalPage", totalPage);
			
			String data = gson.toJson(list);
			JsonArray jArray = new JsonParser().parse(data).getAsJsonArray();
			jArray.add(jobj);
			jArray.add(jobj1);
			jArray.add(jobj2);
			
			
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(jArray);
			
			
			
		} catch (ClassNotFoundException | MissingResourceException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private String[] billChanger(String[] tmp) {

		for(int i = 0; i<tmp.length;i++) {
			if(tmp[i].equals("ctaxPriceTotal")) tmp[i] = "rstx.CTAX_PRICE_TOTAL";
			else if(tmp[i].equals("customerCode")) tmp[i] = "rstx.CUSTOMER_CODE";
			else if(tmp[i].equals("customerName")) tmp[i] = "rstx.CUSTOMER_NAME";
			else if(tmp[i].equals("customerSlipNo")) tmp[i] = "rstx.CUSTOMER_SLIP_NO";
			else if(tmp[i].equals("cutoffGroup")) tmp[i] = "ctx2.category_code_name";
			else if(tmp[i].equals("deliveryDate")) tmp[i] = "rstx.DELIVERY_DATE";
			else if(tmp[i].equals("priceTotal")) tmp[i] = "rstx.PRICE_TOTAL";
			else if(tmp[i].equals("profit")) tmp[i] = "(rstx.retail_price_total - rstx.cost_total)";
			else if(tmp[i].equals("profitRatio")) tmp[i] = "((rstx.retail_price_total - rstx.cost_total) /retail_price_total)*100";
			else if(tmp[i].equals("receptNo")) tmp[i] = "rstx.RECEPT_NO";
			else if(tmp[i].equals("remarks")) tmp[i] = "rstx.REMARKS";
			else if(tmp[i].equals("retailPriceTotal")) tmp[i] = "rstx.RETAIL_PRICE_TOTAL";
			else if(tmp[i].equals("roDate")) tmp[i] = "rstx.RO_DATE";
			else if(tmp[i].equals("roSlipId")) tmp[i] = "rstx.RO_SLIP_ID";
			else if(tmp[i].equals("salesCmCategory")) tmp[i] = "ctx3.category_code_name";
			else if(tmp[i].equals("shipDate")) tmp[i] = "rstx.SHIP_DATE";
			else if(tmp[i].equals("taxShiftCategory")) tmp[i] = "ctx1.category_code_name";
			else if(tmp[i].equals("userId")) tmp[i] = "rstx.USER_ID";
			else if(tmp[i].equals("userName")) tmp[i] = "rstx.USER_NAME";
		}
		
		return tmp;
	}

	private String[] detailChanger(String[] tmp) {

		for(int i = 0; i<tmp.length;i++) {
			if(tmp[i].equals("cost")) tmp[i] = "rltx.cost";
			else if(tmp[i].equals("ctaxPriceTotal")) tmp[i] = "rstx.CTAX_PRICE_TOTAL";
			else if(tmp[i].equals("customerCode")) tmp[i] = "rstx.customer_code";
			else if(tmp[i].equals("customerName")) tmp[i] = "rstx.customer_name";
			else if(tmp[i].equals("customerSlipNo")) tmp[i] = "rstx.customer_slip_no";
			else if(tmp[i].equals("cutoffGroup")) tmp[i] = "ctx3.category_code_name";
			else if(tmp[i].equals("deliveryDate")) tmp[i] = "rstx.delivery_date";
			else if(tmp[i].equals("lineRemarks")) tmp[i] = "rltx.remarks";
			else if(tmp[i].equals("priceTotal")) tmp[i] = "PRICE_TOTAL";
			else if(tmp[i].equals("productAbstract")) tmp[i] = "rltx.product_abstract";
			else if(tmp[i].equals("productCode")) tmp[i] = "rltx.product_code";
			else if(tmp[i].equals("profit")) tmp[i] = "CTAX_PRICE_TOTAL";
			else if(tmp[i].equals("profitRatio")) tmp[i] = "CTAX_PRICE_TOTAL";
			else if(tmp[i].equals("quantity")) tmp[i] = "rltx.quantity";
			else if(tmp[i].equals("receptNo")) tmp[i] = "rstx.recept_no";
			else if(tmp[i].equals("remarks")) tmp[i] = "rstx.remarks";
			else if(tmp[i].equals("restQuantity")) tmp[i] = "rltx.rest_quantity";
			else if(tmp[i].equals("retailPrice")) tmp[i] = "rltx.retail_price";
			else if(tmp[i].equals("retailPriceTotal")) tmp[i] = "(rltx.retail_price + rltx.ctax_price)";
			else if(tmp[i].equals("roDate")) tmp[i] = "rstx.ro_date";
			else if(tmp[i].equals("roSlipId")) tmp[i] = "CONCAT(rltx.ro_slip_id, '-', rltx.line_no)";
			else if(tmp[i].equals("salesCmCategory")) tmp[i] = "ctx2.category_code_name";
			else if(tmp[i].equals("shipDate")) tmp[i] = "rstx.ship_date";
			else if(tmp[i].equals("status")) tmp[i] = "IF(rltx.status = \"0\", \"未納\" , \"\")";
			else if(tmp[i].equals("taxShiftCategory")) tmp[i] = "ctx1.category_code_name";
			else if(tmp[i].equals("unitCost")) tmp[i] = "rltx.unit_cost";
			else if(tmp[i].equals("unitRetailPrice")) tmp[i] = "rltx.unit_retail_price";
			else if(tmp[i].equals("userId")) tmp[i] = "rstx.user_id";
			else if(tmp[i].equals("userName")) tmp[i] = "rstx.user_name";
			
		}
		
		return tmp;
	}
	
	private String orderBillChanger(String tmp) {
		
		if(tmp.equals("消費税")) tmp = "rstx.CTAX_PRICE_TOTAL";
		else if(tmp.equals("顧客コード")) tmp = "rstx.CUSTOMER_CODE";
		else if(tmp.equals("顧客名")) tmp = "rstx.CUSTOMER_NAME";
		else if(tmp.equals("客先伝票番号")) tmp = "rstx.CUSTOMER_SLIP_NO";
		else if(tmp.equals("支払条件")) tmp = "ctx2.category_code_name";
		else if(tmp.equals("納期指定日")) tmp = "rstx.DELIVERY_DATE";
		else if(tmp.equals("伝票合計")) tmp = "rstx.PRICE_TOTAL";
		else if(tmp.equals("粗利益")) tmp = "(rstx.retail_price_total - rstx.cost_total)";
		else if(tmp.equals("粗利益率")) tmp = "((rstx.retail_price_total - rstx.cost_total) /retail_price_total)*100";
		else if(tmp.equals("受付番号")) tmp = "rstx.RECEPT_NO";
		else if(tmp.equals("摘要")) tmp = "rstx.REMARKS";
		else if(tmp.equals("金額合計")) tmp = "rstx.RETAIL_PRICE_TOTAL";
		else if(tmp.equals("受注日")) tmp = "rstx.RO_DATE";
		else if(tmp.equals("受注番号")) tmp = "rstx.RO_SLIP_ID";
		else if(tmp.equals("取引区分")) tmp = "ctx3.category_code_name";
		else if(tmp.equals("出荷日")) tmp = "rstx.SHIP_DATE";
		else if(tmp.equals("税転嫁")) tmp = "ctx1.category_code_name";
		else if(tmp.equals("入力担当者コード")) tmp = "rstx.USER_ID";
		else if(tmp.equals("入力担当者名")) tmp = "rstx.USER_NAME";
		
		return tmp;
	}
	
	private String orderDetailChanger(String tmp) {
		
		return tmp;
	}
}
