package master.product.controller;
	
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
	
import common.controller.BaseController;
import master.product.DAO.ProductDAO;
import master.product.beans.ProductCategoryBean;
	
import java.util.*;
import java.sql.SQLException;
import java.lang.*;
	
import user.DAO.*;
import user.beans.*;
	
public class ProductController extends BaseController{
	
	public ProductController() {
		
	}
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");
		
		 if(action.equals("Product")) forwardURL = Product(request, response);
		
		return forwardURL;
	}
	
	private String deleteProduct(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// TODO Auto-generated method stub
		String forwardURL = "/productsearch.jsp";	
		
		List<ProductCategoryBean> list = new ArrayList<>();		
		ProductDAO dao = new ProductDAO();
		try {
			list = dao.getCategory();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("category", list);
		
		
		String code = request.getParameter("productCode");
		int productCode = Integer.parseInt(code);
		
		ProductDAO dao = new ProductDAO();
		
		return forwardURL;
	}
	
}
