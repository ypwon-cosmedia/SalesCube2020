package common.modal.product.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import common.controller.BaseAJAXController;
import common.modal.product.DAO.ProductModalDAO;
import common.modal.product.beans.ProductModalResultBean;
import common.modal.product.beans.ProductModalSearchBean;
import jdk.nashorn.internal.runtime.JSONListAdapter;
import order.common.init.DAO.OrderInitDAO;
import order.common.init.beans.OrderInitBean;

public class ProductModalAJAXController extends BaseAJAXController{


	public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		System.out.println(action);
		if(action.equals("productSearch")) productSearch(request, response); 
		else if(action.equals("initProductModal")) initProductModal(request, response); 

	}
	
	private void productSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductModalDAO dao = new ProductModalDAO();
		ProductModalSearchBean bean = new ProductModalSearchBean();
		bean.setProductCode(request.getParameter("productCode"));
		bean.setProductKana(request.getParameter("productKana"));
		bean.setProductName(request.getParameter("productName"));
		bean.setJanPcode(request.getParameter("janPcode"));
		bean.setProductStandardCategory(request.getParameter("productStandardCategory"));
		bean.setProductStatusCategory(request.getParameter("productStatusCategory"));
		bean.setSetTypeCategory(request.getParameter("setTypeCategory"));
		bean.setSupllierPcode(request.getParameter("supplierCode"));
		List<ProductModalResultBean> list = new ArrayList<>();
		Gson gson = new Gson();
		try {
			list = dao.productModalResult(bean);
			String data = gson.toJson(list);
			JsonArray jArray = new JsonParser().parse(data).getAsJsonArray();
						
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(jArray);
		} catch (ClassNotFoundException | SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void initProductModal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrderInitDAO dao = new OrderInitDAO();
		
		try {
			
			List<OrderInitBean> list1 = dao.initComboBox("2");
			List<OrderInitBean> list2 = dao.initComboBox("3");
			List<OrderInitBean> list3 = dao.initComboBox("16");

			Gson gson = new Gson();
			
			String data1 = gson.toJson(list1);
			String data2 = gson.toJson(list2);
			String data3 = gson.toJson(list3);
			
			JsonArray jArray1 = gson.toJsonTree(list1).getAsJsonArray();
			JsonArray jArray2 = gson.toJsonTree(list2).getAsJsonArray();
			JsonArray jArray3 = gson.toJsonTree(list3).getAsJsonArray();
			
			JsonObject jObject = new JsonObject();
			
			jObject.add("list1", jArray1);
			jObject.add("list2", jArray2);
			jObject.add("list3", jArray3);
			
			System.out.println(jObject.toString());
				
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(jObject);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
