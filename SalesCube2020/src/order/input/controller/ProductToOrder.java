package order.input.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.BaseAJAXController;
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
			}
		
	}	
		

	/* 受注明細 商品コードから商品情報 */
	private void productCodeToInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		String productCode = request.getParameter("productCode");
		String productName = request.getParameter("productName");
		
		OrderInputDAO dao = new OrderInputDAO();
		List<OrderInputBean> list = new ArrayList<>();
		OrderInputBean bean = new OrderInputBean();
		
		list = dao.productLinkToDetail(productCode, productName, bean);
		
		request.setAttribute("productlink", list);
		
	}
}
