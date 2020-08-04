package order.search.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.BaseController;
import common.modal.product.DAO.ProductModalDAO;
import common.modal.product.beans.ProductModalSearchBean;

public class OrderSearchController extends BaseController{
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");

		if(action.equals("productModalSearch")) forwardURL = productSearchResult(request, response);
		return forwardURL;
	}
	
	private String productSearchResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductModalDAO dao = new ProductModalDAO();

		try {
			ProductModalSearchBean bean = new ProductModalSearchBean();
			bean.setProductCode(request.getParameter("productCode"));
			bean.setSupllierPcode(request.getParameter("supllierPcode"));
			bean.setJanPcode(request.getParameter("janPcode"));
			bean.setSetTypeCategory(request.getParameter("setTypeCategory"));
			bean.setProductStandardCategory(request.getParameter("productStandardCategory"));
			bean.setProductStatusCategory(request.getParameter("productStatusCategory"));
			bean.setProductName(request.getParameter("productName"));
			bean.setProductKana(request.getParameter("productKana"));
			
			request.setAttribute("productSearchResult", dao.productModalResult(bean));			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "order\\ordersearch.jsp";
	}
}
