package common.modal.stock.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.BaseAJAXController;
import common.controller.BaseController;
import common.modal.stock.dao.StockDAO;
import order.input.beans.OrderInputBean;

public class StockToOrderController extends BaseController {

	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");
		
		if(action.equals("stocklink"))
			try {
				moveStockToUpdate(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
		return forwardURL;
		
	}
	
	/* 在庫モーダルから編集画面へ受注内容 */
	private String moveStockToUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		StockDAO dao = new StockDAO();
		OrderInputBean bean = new OrderInputBean();
		
		Integer roSlipId = Integer.parseInt(request.getParameter("roSlipId"));
		
		bean = dao.StockToOrder(roSlipId);
		
		request.setAttribute("stockToOrder", bean);
		
		return "order\\orderupdate.jsp";
		
	}
}
