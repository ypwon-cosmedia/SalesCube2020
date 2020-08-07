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
import com.google.gson.JsonParser;

import common.controller.BaseAJAXController;
import order.search.beans.OrderSearchBean;
import order.search.dao.OrderSearchDAO;
import user.beans.UserInfoBean;

public class OrderSearchAJAXController extends BaseAJAXController{


	public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("configModalUpdate")) configModalUpdate(request, response);
		else if(action.equals("orderSearch")) orderSearch(request, response);
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
	
	private void orderSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		OrderSearchDAO dao = new OrderSearchDAO();
		OrderSearchBean bean = new OrderSearchBean();
		Gson gson = new Gson();
		String[] res;
		
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
		
		if(bean.getSelectView().equals("伝票")) res = billChanger(request.getParameterValues("list"));
		else res = detailChanger(request.getParameterValues("list"));
		
		String rowCount = request.getParameter("rowCount");
		
		try {
			List<String[]> list = dao.orderSearch(bean, res, rowCount);
			
			String data = gson.toJson(list);
			JsonArray jArray = new JsonParser().parse(data).getAsJsonArray();
			
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
			else if(tmp[i].equals("cutoffGroup")) tmp[i] = "rstx.CUTOFF_GROUP";
			else if(tmp[i].equals("deliveryDate")) tmp[i] = "rstx.DELIVERY_DATE";
			else if(tmp[i].equals("priceTotal")) tmp[i] = "rstx.PRICE_TOTAL";
			else if(tmp[i].equals("profit")) tmp[i] = "(rstx.retail_price_total - rstx.cost_total)";
			else if(tmp[i].equals("profitRatio")) tmp[i] = "((rstx.retail_price_total - rstx.cost_total) /retail_price_total)*100";
			else if(tmp[i].equals("receptNo")) tmp[i] = "rstx.RECEPT_NO";
			else if(tmp[i].equals("remarks")) tmp[i] = "rstx.REMARKS";
			else if(tmp[i].equals("retailPriceTotal")) tmp[i] = "rstx.RETAIL_PRICE_TOTAL";
			else if(tmp[i].equals("roDate")) tmp[i] = "rstx.RO_DATE";
			else if(tmp[i].equals("roSlipId")) tmp[i] = "rstx.RO_SLIP_ID";
			else if(tmp[i].equals("salesCmCategory")) tmp[i] = "ctx2.category_code_name";
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
}
