package order.input.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductToOrder {
	
	public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String action = request.getParameter("action");
		
		if(action.equals("pcodetoinfo")) 
			productCodeToInfo(request, response);
		
	}	
		

	/* 受注明細 商品コードから商品情報 */
	private void productCodeToInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		String productCode = re
	}
}
