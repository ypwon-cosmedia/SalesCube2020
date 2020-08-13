package common.modal.product.init;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import order.common.init.DAO.OrderInitDAO;

public class ProductModalInit {
	
	public void initCombobox(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrderInitDAO dao = new OrderInitDAO();
		
		try {
			request.setAttribute("setProduct", dao.initComboBox("2"));
			request.setAttribute("standard", dao.initComboBox("3"));
			request.setAttribute("classStatus", dao.initComboBox("16"));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
