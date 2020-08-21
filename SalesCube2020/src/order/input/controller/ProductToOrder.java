package order.input.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import common.controller.BaseAJAXController;
import estimate.Input.beans.GetProductBean;
import estimate.Input.dao.EstimateInputCommonDAO;
import order.input.DAO.OrderInputDAO;
import order.input.beans.OrderInputBean;

public class ProductToOrder extends BaseAJAXController {
	
	public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("pcodetoinfo"))
			try {
				productCodeToInfo(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}else if(action.equals("cuscodetoinfo"))
			try {
				customerCodeToInfo(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		else if(action.equals("deliverytoinfo"))
			try {
				deliveryToInfo(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
		
	private void customerCodeToInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		String customerCode = request.getParameter("customerCode");
		System.out.println(customerCode);
		
		OrderInputDAO dao = new OrderInputDAO();
		OrderInputBean bean = new OrderInputBean();
		List<OrderInputBean> list = new ArrayList<>();

		Gson gson = new Gson();
		
		try {
			bean = dao.customerCodeInfo(customerCode);
			list = dao.customerCodeToDelivery(customerCode);
			String data = gson.toJson(bean);
			
			JsonArray jArray = gson.toJsonTree(list).getAsJsonArray();
			JsonObject jObject = new JsonObject();
			
			jObject.add("bean", new Gson().toJsonTree(data));
			jObject.add("list", jArray);
						
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(jObject);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void deliveryToInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		String deliveryCode = request.getParameter("deliveryCode");
		String customerCode = request.getParameter("customerCode");
		System.out.println(deliveryCode);
		
		OrderInputDAO dao = new OrderInputDAO();
		List<OrderInputBean> list = new ArrayList<>();
		List<OrderInputBean> list2 = new ArrayList<>();

		Gson gson = new Gson();
		
		try {
			list = dao.deliveryNameToDeliveryInfo(deliveryCode);
			list2 = dao.customerCodeToDelivery(customerCode);
			
			JsonArray jArray = gson.toJsonTree(list).getAsJsonArray();
			JsonArray jArray2 = gson.toJsonTree(list2).getAsJsonArray();
			JsonObject jObject = new JsonObject();

			jObject.add("list", jArray);
			jObject.add("list2", jArray2);
						
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(jObject);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	/* 受注明細 商品コードから商品情報 */
	private void productCodeToInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		String productCode = request.getParameter("productCode");
		System.out.println(productCode);
		
		OrderInputDAO dao = new OrderInputDAO();
		OrderInputBean bean = new OrderInputBean();

		Gson gson = new Gson();
		
		try {
			bean = dao.productLinkToDetail(productCode);
			String data = gson.toJson(bean);
						
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(data);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
