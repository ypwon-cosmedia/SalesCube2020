package master.product.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;
import master.product.DAO.GetCategoryDAO;
import master.product.DAO.ProductDeleteDAO;
import master.product.beans.ProductCategoryAllBean;
import java.util.*;
import java.sql.SQLException;
import java.lang.*;

public class ProductDeleteController extends BaseController{
	
	public ProductDeleteController() {
		
	}
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");

		 if(action.equals("deleteProduct"))
			try {
				forwardURL = deleteProduct(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return forwardURL;
	}
	
	
	private String deleteProduct(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException, ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub

		String forwardURL = "/productsearch.jsp";	
		
		//Category	
		List<ProductCategoryAllBean> list = new ArrayList<ProductCategoryAllBean>();		
		GetCategoryDAO dao = new GetCategoryDAO();
		
		try {
			list = dao.getAllCategory();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("all", list);
		
		//Delete
		String productCode = request.getParameter("productCode");
		ProductDeleteDAO dao2 = new ProductDeleteDAO();
		int check = dao2.deleteProduct(productCode);
		
		//Delete Check
		if( check == 0 ) {
			String message = "削除ができませんでした";
			request.setAttribute("addmodifyError", message);
		}else{
			String message = "削除が完了しました";
			request.setAttribute("addmodifysuccess", message);
		}
		
		return forwardURL;
	}

}