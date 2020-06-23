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
		List<SetProductBean> list = new ArrayList<SetProductBean>();
		SetProductDAO dao = new SetProductDAO();
		
		pCode = (String) request.getParameter("productCode");
		pName = (String) request.getParameter("productName");
		
		try {
			list = dao.getInfo(pCode);
		} catch (ClassNotFoundException | MissingResourceException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("productCode", pCode);
		request.setAttribute("productName", pName);
		request.setAttribute("result", list);

		return "/setproductmodify.jsp";
	}
	
	private String searchSetProduct (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<SetProductSearchResultBean> list = new ArrayList<SetProductSearchResultBean>();
		SetProductDAO dao = new SetProductDAO();
		SetProductSearchBean bean = new SetProductSearchBean();
		
		String tmp;
		int count;
		int totalCount;
		int totalPage;
		int currentPage;
			
		try {
			
			totalCount = dao.getCount();
			
			tmp = (String) request.getParameter("rowCount");
			count = Integer.parseInt(tmp);

			totalPage = totalCount/count;
			
			if(totalCount%count != 0) {
				totalPage++;
			}

			tmp = (String) request.getParameter("currentPage");
				
			if(tmp == null) {
				currentPage=1;
			}else {
				currentPage = Integer.parseInt(tmp);
			}

			bean.setSetProductCode((String) request.getParameter("data1"));
			bean.setSetProductName((String) request.getParameter("data2"));
			bean.setProductCode((String) request.getParameter("data3"));
			bean.setProductName((String) request.getParameter("data4"));
							
			if(bean.getSetProductCode() == "") {
				bean.setSetProductCode(null);
			}
			
			if(bean.getSetProductName() == "") {
				bean.setSetProductName(null);
			}
			
			if(bean.getProductCode() == "") {
				bean.setProductCode(null);
			}
			
			if(bean.getProductName() == "") {
				bean.setProductName(null);
			}
						
			list = dao.getProductInfo(bean, count, currentPage);
			
			int[] totalPageArr= new int[totalPage];
			
			for(int i = 0; i<totalPageArr.length; i++) {
				totalPageArr[i] = i+1;
			}
			
			request.setAttribute("searchData", list);
			request.setAttribute("totalPage", totalPageArr);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("rowCount", count);
			
			return "/setproduct.jsp";
			
		} catch (ClassNotFoundException | MissingResourceException | SQLException e) {

			e.printStackTrace();
		}
		
		return "/setproduct.jsp";
	}
	
	private String modifySetProduct (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SetProductDAO dao = new SetProductDAO();
		List<SetProductBean> list = new ArrayList<SetProductBean>();
		List<SetProductBean> list2 = new ArrayList<SetProductBean>();
		String setProductCode = null;
		String setProductName = null;
		
		setProductCode = (String) request.getParameter("productCode");
		setProductName = (String) request.getParameter("productName");
				
		String[] productCode = request.getParameterValues("code");
		String[] productName = request.getParameterValues("name");
		String[] quantity = request.getParameterValues("quantity");
		
		if(productCode != null) {
			for(int i = 0; i<productCode.length; i++) {				
				SetProductBean bean = new SetProductBean();
				bean.setProductCode(productCode[i]);
				bean.setProductName(productName[i]);
				bean.setQuantity(Integer.parseInt(quantity[i]));			
				list.add(bean);
			}
		}

		
		try {
			dao.setInfo(list, setProductCode);
			
			list2=dao.getInfo(setProductCode);
			
			request.setAttribute("result", list2);
			request.setAttribute("productCode", setProductCode);
			request.setAttribute("productName", setProductName);
			
		} catch (ClassNotFoundException | MissingResourceException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "/setproductmodify.jsp";
	}
	
	
	
}
