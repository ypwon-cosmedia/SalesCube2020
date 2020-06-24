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
		
		if(action.equals("quantityDiscount")) 	forwardURL = quantityDiscount(request, response);
		
  		return forwardURL;
      	}


	private String quantityDiscount(HttpServletRequest request, HttpServletResponse response) {
		String forwardURL = "/quantitydiscount.jsp";
		
		//åüçıópBean
		QuantityDiscountBean qdb = new QuantityDiscountBean();
		ProductDiscountDAO discountDAO = new ProductDiscountDAO();
		
		try {
		String disId;
		String uf;
		String disNm;
		String rem;
		
		//JSPÇ©ÇÁèÓïÒÇéÊìæ
		if( (request.getParameter("discountId")) == null ) {
			disId = "";
		}else {
			disId = request.getParameter("discountId");
		}
		
		if( (request.getParameter("useFlag")) == null ) {
			uf = "";
		}else {
			uf = request.getParameter("useFlag");
		}
		
		if( (request.getParameter("discountName")) == null ) {
			disNm = "";
		}else {
			disNm = request.getParameter("discountName");
		}
		
		if( (request.getParameter("remarks")) == null ) {
			rem = "";
		}else {
			rem = request.getParameter("remarks");
		}

		qdb.setDiscountId( disId );
		qdb.setUseFlag( uf );
		qdb.setDiscountName( disNm );
		qdb.setRemarks( rem );
		
		List<DiscountSearchBean> list = discountDAO.searchQuantityDiscount(qdb);
		
		request.setAttribute("quantitydiscountsearchresultcount", list.size() );
		request.setAttribute("quantitydiscountsearchresult", list);
		
		
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return forwardURL;
	}


}

