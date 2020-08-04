package common.modal.customer.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import common.controller.BaseController;

import common.modal.customer.beans.CustomerModalResultBean;
import common.modal.customer.beans.CustomerModalSearchBean;

public class CustomerModalAJAXController extends BaseController {
	
		public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String action = request.getParameter("action");
			
			if(action.equals("customerSearch")) customerSearch(request,response);

		}
		
		private void customerSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			CustomerModalDAO dao = new CustomerModalDAO();
			CustomerModalSearchBean bean = new CustomerModalSearchBean();
			bean.setCustomerCode(request.getParameter("customerCode"));
			bean.setCustomerName(request.getParameter("customerName"));
			bean.setCustomerKana(request.getParameter("customerKana"));
			bean.setCutoffGroup(request.getParameter("cutoffGroup"));
			
			List<CustomerModalResultBean> list = new ArrayList<>();
			Gson gson = new Gson();
			try {
				list = dao.customerModalResult(bean);
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
