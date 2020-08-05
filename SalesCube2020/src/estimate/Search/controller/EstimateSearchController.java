package estimate.Search.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.BaseController;
import common.modal.customer.beans.CustomerModalSearchBean;
import common.modal.customer.dao.CustomerModalDAO;


public class EstimateSearchController extends BaseController {

	@Override
	public String execService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");
		
		if(action.equals("customerModalSearch")) forwardURL = customerSearchResult(request, response);
		return forwardURL;
	}
	
	private String customerSearchResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerModalDAO dao = new CustomerModalDAO();

		try {
			CustomerModalSearchBean bean = new CustomerModalSearchBean();
			bean.setCustomerCode(request.getParameter("customerCode"));
			bean.setCustomerName(request.getParameter("customerName"));
			bean.setCustomerKana(request.getParameter("customerKana"));
			bean.setCutoffGroup(request.getParameter("cutoffGroup"));			
			request.setAttribute("customerSearchResult", dao.customerModalResult(bean));			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "estimate\\estimateSearch.jsp";
	}
}
