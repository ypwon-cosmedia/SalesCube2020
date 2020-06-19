package master.setProduct.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;
import master.setProduct.DAO.SetProductDAO;
import master.setProduct.beans.SetProductBean;
import master.setProduct.beans.SetProductSearchBean;
import master.setProduct.beans.SetProductSearchResultBean;

import java.util.*;
import java.sql.SQLException;
import java.lang.*;


final public class SetProductController extends BaseController{
	
	public SetProductController() {
	}
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");
		
		if(action.equals("moveModifySetProduct")) forwardURL = moveModifySetProduct(request, response);
		else if(action.equals("searchSetProduct")) forwardURL = searchSetProduct(request, response);
		else if(action.equals("modifySetProduct")) forwardURL = modifySetProduct(request, response);
		
  		return forwardURL;
    }
	
	private String moveModifySetProduct (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pCode;
		String pName;
		
		pCode = (String) request.getParameter("productCode");
		pName = (String) request.getParameter("productName");
		
		request.setAttribute("productCode", pCode);
		request.setAttribute("productName", pName);
		
		System.out.println(pCode);
		System.out.println(pName);
		

		return "/setproductmodify.jsp";
	}
	
	private String searchSetProduct (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<SetProductSearchResultBean> list = new ArrayList<SetProductSearchResultBean>();
		SetProductDAO dao = new SetProductDAO();
		SetProductSearchBean bean = new SetProductSearchBean();
		
		bean.setSetProductCode((String) request.getAttribute("data1"));
		bean.setSetProductName((String) request.getAttribute("data2"));
		bean.setProductCode((String) request.getAttribute("data3"));
		bean.setProductName((String) request.getAttribute("data4"));
		
		
		try {
			list = dao.getProductInfo(bean);
			request.setAttribute("searchData", list);
			
		
			
			return "/setproduct.jsp";
			
		} catch (ClassNotFoundException | MissingResourceException | SQLException e) {

			e.printStackTrace();
		}
		
		return "/setproduct.jsp";
	}
	
	private String modifySetProduct (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SetProductDAO dao = new SetProductDAO();
		List<SetProductBean> list = new ArrayList<SetProductBean>();
		String setProductCode = null;
		
		setProductCode = (String) request.getAttribute("setProductCode");
		//	for(int i = 0; ����; i++){
		//		SetProductBean bean = new SetProductBean();
		//		bean.setSetProductCode((String)request.getArribute(""));
		//		bean.setProductCode((String)request.getArribute(""));
		//		bean.setQuantity((int)request.getArribute(""));
		//		list.add(bean);
		//	}
		//
		//	dao.setInfo(list,setProductCode);
		
		return "/setproductmodify.jsp";
	}
}
