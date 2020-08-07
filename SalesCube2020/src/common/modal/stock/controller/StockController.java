package common.modal.stock.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.modal.stock.beans.StockBean;
import common.modal.stock.dao.StockDAO;

public class StockController {
	
	public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("stocksearch"))
			try {
				moveStock(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}

	/* 在庫モーダルへ商品情報 */
	private void moveStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		StockDAO dao = new StockDAO();
		StockBean bean = new StockBean();
		
		bean = dao.OrderToStock();
		
		
		
	}
}
