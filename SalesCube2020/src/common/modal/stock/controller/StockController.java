package common.modal.stock.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import common.controller.BaseAJAXController;
import common.controller.BaseController;
import common.modal.stock.beans.StockBean;
import common.modal.stock.dao.StockDAO;
import order.input.beans.OrderInputBean;

public class StockController extends BaseAJAXController {

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
		
		String productCode = request.getParameter("productCode");
		
		StockDAO dao = new StockDAO();
		StockBean bean = new StockBean();
		List<StockBean> list = new ArrayList<>();
		
		Gson gson = new Gson();
		
		try {
			bean = dao.OrderToStock(productCode);
			list = dao.OrderToStockDetail(productCode);
			String data = gson.toJson(bean);
			
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(data);
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
