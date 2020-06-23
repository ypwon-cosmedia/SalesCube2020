package master.product.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;
import master.product.DAO.ProductDAO;
import master.product.DAO.ProductDiscountDAO;
import master.product.beans.DiscountDetailBean;
import master.product.beans.DiscountSearchBean;
import master.product.beans.QuantityDiscountBean;

import java.util.*;
import java.sql.SQLException;
import java.lang.*;

import user.DAO.*;
import user.beans.*;

public class ProductDiscountController extends BaseController{
	
	public ProductDiscountController() {
		
	}
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");


		 if(action.equals("quantityDiscount")) forwardURL = quantityDiscount(request, response);
		
  		return forwardURL;
      	}


	private String quantityDiscount(HttpServletRequest request, HttpServletResponse response) {
		String forwardURL = "/quantitydiscount.jsp";
		String message = null;
		
		//åüçıópBean
		QuantityDiscountBean qdb = new QuantityDiscountBean();
		ProductDiscountDAO discountDAO = new ProductDiscountDAO();
		
		try {
		
		//JSPÇ©ÇÁèÓïÒÇéÊìæ
		qdb.setDiscountId( request.getParameter("discountCode") );
		qdb.setUseFlag( request.getParameter("useFlag") );
		qdb.setDiscountName( request.getParameter("discountName") );
		qdb.setRemarks( request.getParameter("remarks") );
		
		List<DiscountSearchBean> list = discountDAO.searchQuantityDiscount(qdb);
		
		request.setAttribute("quantitydiscountserchresultcount", list.size() );
		request.setAttribute("quantitydiscountserchresult", list);
		
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return forwardURL;
	}


}

