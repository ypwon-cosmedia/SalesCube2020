package master.customer.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;
import master.customer.DAO.CustomerDAO;
import master.customer.beans.CustomerModifyBean;
import master.customer.beans.customerSearchBeans.CustomerInputBean;
import master.customer.beans.customerSearchBeans.CustomerResultBean;

import java.util.*;
import java.sql.SQLException;
import java.lang.*;

import user.DAO.*;
import user.beans.*;

public class CustomerController extends BaseController{
	
	public CustomerController() {
	}
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");
		
		try {
			if(action.equals("searchCustomer")) forwardURL = searchCustomer(request, response);
			else if(action.equals("moveAddCustomer")) forwardURL = moveAddCustomer(request, response);
			else if(action.equals("moveModifyCustomer")) forwardURL = moveModifyCustomer(request, response);
			else if(action.equals("searchAddress")) forwardURL = searchAddress(request, response);
			else if(action.equals("addCustomer")) forwardURL = addCustomer(request, response);
			else if(action.equals("modifyCustomer")) forwardURL = modifyCustomer(request, response);
			else if(action.equals("deleteCustomer")) forwardURL = deleteCustomer(request, response);
			else if(action.equals("customerExcelOutput")) forwardURL = customerExcelOutput(request, response);
			//else if(action.equals("initCustomer")) forwardURL = initCustomer(request, response);
			//else if(action.equals("updateInitCostomer")) forwardURL = updateInitCostomer(request, response);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		
  		return forwardURL;
	}
	
	private String searchCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL     = "/customersearch.jsp";
		String customerCode   = request.getParameter("customerCode");
		String customerName   = request.getParameter("customerName");
		String customerKana   = request.getParameter("customerKana");
		String officeName 	  = request.getParameter("officeName");
		String officeNameKana = request.getParameter("officeNameKana");
		String tel			  = request.getParameter("tel");
		String PCName 		  = request.getParameter("PCName");
		String PCNameKana 	  = request.getParameter("PCNameKana");
		String fax 			  = request.getParameter("fax");
		String rankCategory   = request.getParameter("rankCategory");
		String cutoffGroup 	  = request.getParameter("cutoffGroup");
		String paymentName 	  = request.getParameter("paymentName");
		String remarks 		  = request.getParameter("remarks");
		
		
		
		CustomerInputBean bean = new CustomerInputBean();
		bean.setCustomerCode(customerCode);
		bean.setCustomerName(customerName);
		bean.setCustomerKana(customerKana);
		bean.setOfficeName(officeName);
		bean.setOfficeNameKana(officeNameKana);
		bean.setTel(tel);
		bean.setPCName(PCName);
		bean.setPCNameKana(PCNameKana);
		bean.setFax(fax);
		bean.setRankCategory(rankCategory);
		bean.setCutoffGroup(cutoffGroup);
		bean.setPaymentName(paymentName);
		bean.setRemarks(remarks);
		
		CustomerDAO dao =  new CustomerDAO();

		List<CustomerResultBean> list = dao.searchCustomer(bean);
		
		/*if(result == 0 ) {
			request.setAttribute("message","åüçıíÜÇ…ÉGÉâÅ[Ç™ê∂Ç∂Ç‹ÇµÇΩ");
		} else {
			//request.setAttribute( "message", "åüçıÇ™äÆóπÇµÇ‹ÇµÇΩÅB");
		} */
			    
		request.setAttribute("customerList",list);
			
		return forwardURL;
		
	}
	
	private String moveAddCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customeraddmodify.jsp";		
		
		return forwardURL;
		
	}
	
	private String moveModifyCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customeraddmodify.jsp";
		String customerCode   = request.getParameter("customerCode");
	
		CustomerDAO dao =  new CustomerDAO();
		CustomerModifyBean bean = dao.getCustomer(customerCode);
		
		request.setAttribute("customer",bean);
		
		return forwardURL;
		
	}
	
	private String searchAddress(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/zipsearch.jsp";
		
		return forwardURL;
		
	}
	
	private String addCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customeraddmodify.jsp";
		
		return forwardURL;
		
	}
	
	private String modifyCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customeraddmodify.jsp";
		
		return forwardURL;
		
	}
	
	private String deleteCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customersearch.jsp";
		//String status = request.getAttribute(status)
		/* if (status=="add" || status=="modify") {
		String forwardURL = "/customeraddmodify.jsp";
		} */
		
		return forwardURL;
		
	}
	
	private String customerExcelOutput(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customeraddmodify.jsp";
		
		return forwardURL;
		
	}
	
	/* private String initCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customersearch.jsp";
		
		return forwardURL;
		
	} */
	
	/* private String updateInitCostomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customersearch.jsp";
		
		return forwardURL;
		
	} */
}
