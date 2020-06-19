package master.product.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;
import master.product.DAO.ProductDAO;
import master.product.beans.ProductCategoryBean;
import master.product.beans.ProductModifyBean;

import java.util.*;
import java.sql.SQLException;
import java.lang.*;

import user.DAO.*;
import user.beans.*;

public class ProductExcelController extends BaseController{
	
	public ProductExcelController() {
		
	}
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");

		try {
			
		if(action.equals("productExcelInput")) 			forwardURL = productExcelInput(request, response);
		else if(action.equals("productExcelOutput")) 	forwardURL = productExcelOutput(request, response);
		else if(action.equals("productHistoryOutput"))  forwardURL = productHistoryOutput(request, response);
		
		}catch (ServletException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
  		return forwardURL;
	}	
	
	private String productExcelOutput(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<ProductModifyBean> list = new ArrayList<>();
		list = request.getAttribute("product");
		
		//DAOを呼ぶ
		
		try {
			//検索結果のExcel出力
			PrintWriter p = new PrintWriter( new BufferedWriter( new OutputStreamWriter( new FileOutputStream("//ファイルの場所//", false),"utf-8")));
			
			//ヘッダ
			p.print();
			p.print(",");
			
			
			p.println();)
			
			//検索結果
			for(int i = 0; i < .length; i++) {
				p.print( getProductCode() );
				p.print(",");
				
				
				
				
				
				p.println();
				
			}
			//閉じる
			p.close();
			System.out.println("Excel出力完了");
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return "/productsearch.jsp";
	}

/**	
	private String productExcelInput(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<ProductCategoryBean> list = new ArrayList<>();
		
		ProductDAO dao = new ProductDAO();
		
		//list = dao.getCategory();
		
		request.setAttribute("category", list);
		
		return "/productsearch.jsp";
	}
	
	private String productHistoryOutput(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		return "/productaddmodify.jsp";
	}
**/

}
