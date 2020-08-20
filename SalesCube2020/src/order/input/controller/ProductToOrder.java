package order.input.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

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
		else if(action.equals("cuscodetodelivery"))
			try {
				customerCodeToDelivery(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}
	
	private void customerCodeToDelivery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		String customerCode = request.getParameter("customerCode");
		System.out.println(customerCode);
		
		OrderInputDAO dao = new OrderInputDAO();
		List<OrderInputBean> list = new ArrayList<>();

		Gson gson = new Gson();
		
		try {
			list = dao.customerCodeToDelivery(customerCode);
			String data = gson.toJson(list);
						
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(data);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	private void customerCodeToInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		String customerCode = request.getParameter("customerCode");
		System.out.println(customerCode);
		
		OrderInputDAO dao = new OrderInputDAO();
		OrderInputBean bean = new OrderInputBean();

		Gson gson = new Gson();
		
		try {
			bean = dao.customerCodeInfo(customerCode);
			String data = gson.toJson(bean);
						
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(data);
			
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
