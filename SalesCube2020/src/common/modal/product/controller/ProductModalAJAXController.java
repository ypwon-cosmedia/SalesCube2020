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

public class ProductModalAJAXController extends BaseAJAXController{


	public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("productSearch")) productSearch(request, response); 
			

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
	
}
