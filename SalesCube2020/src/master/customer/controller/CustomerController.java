package master.customer.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;
import master.customer.DAO.CustomerDAO;
import master.customer.beans.AddressBean;
import master.customer.beans.CustomerAddBean;
import master.customer.beans.CustomerModifyBean;
import master.customer.beans.DeliveryAddBean;
import master.customer.beans.DeliveryModifyBean;
import master.customer.beans.customerSearchBeans.CustomerInputBean;
import master.customer.beans.customerSearchBeans.CustomerResultBean;

import java.util.*;
import java.sql.SQLException;
	
import java.time.LocalDateTime;

public class CustomerController extends BaseController{
	
	String space = "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;";
	
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
			//else if(action.equals("customerExcelOutput")) forwardURL = customerExcelOutput(request, response);
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
			request.setAttribute("message","�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾉエ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾜゑｿｽ�ｿｽ�ｿｽ");
		} else {
			//request.setAttribute( "message", "�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾜゑｿｽ�ｿｽ�ｿｽ�ｿｽB");
		} */
		
		
		request.setAttribute("customerList",list);
			
		return forwardURL;
		
	}
	
	
	private String moveAddCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customeraddmodify.jsp";
		
		request.setAttribute("status", "add");
		
		return forwardURL;
		
	}
	
	
	private String moveModifyCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customeraddmodify.jsp";
		String customerCode   = request.getParameter("customerCode");
	
		
		CustomerDAO dao =  new CustomerDAO();
		
		CustomerModifyBean bean = dao.getCustomer(customerCode);
		
		List<DeliveryModifyBean> list = dao.getDelivery(customerCode);
		
		DeliveryModifyBean bean2 = dao.getDelivery2(customerCode);
		
		
		request.setAttribute("customer",bean);
		request.setAttribute("deliveryList",list);
		request.setAttribute("delivery2",bean2);
		
		request.setAttribute("status", "modify");
		
		return forwardURL;
		
	}
	
	
	private String searchAddress(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/zipsearch.jsp";
		
		String zipCode   = request.getParameter("zipCode");
		String address1   = request.getParameter("address1");
		
		
		AddressBean bean = new AddressBean();
		bean.setZipCode(zipCode);
		bean.setZipAddress1(address1);
		
		CustomerDAO dao =  new CustomerDAO();
		
		List<AddressBean> list = dao.searchAddress(bean);
		
	
		request.setAttribute("ZipList",list);
		
		return forwardURL;
		
	}
	
	
	private String addCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customersearch.jsp";
		
		
		String customerCode         = request.getParameter("customerCode");
		String customerName         = request.getParameter("customerName");
		String customerKana         = request.getParameter("customerKana");
		String officeName 	        = request.getParameter("officeName");
		String officeNameKana       = request.getParameter("officeNameKana");
	 	String customerAbbr         = request.getParameter("customerAbbr");
	 	String zipCode              = request.getParameter("zipCode");
	 	String zipAddress1          = request.getParameter("zipAddress1");
	 	String zipAddress2          = request.getParameter("zipAddress2");
		String PCName 		        = request.getParameter("PCName");
		String PCNameKana 	        = request.getParameter("PCNameKana");
		String PCPreCategory        = request.getParameter("PCPreCategory");
		String deptName             = request.getParameter("deptName");
		String PCPost               = request.getParameter("PCPost");
		String tel			        = request.getParameter("tel");
		String fax 			        = request.getParameter("fax");
		String email                = request.getParameter("email");
		String rankCategory         = request.getParameter("rankCategory");
		String updateFlag           = request.getParameter("updateFlag");
		String ROCategory           = request.getParameter("ROCategory");
		String str      = request.getParameter("maxCreditLimit");
		int maxCreditLimit ;
		if (str == null || str.length() == 0){
			maxCreditLimit = 0;
		}else{
		      try{
		    	  maxCreditLimit = Integer.parseInt(str);
		      }catch (NumberFormatException e){
		    	  maxCreditLimit = 0;
		      }
		    }
		
		String businessCategory     = request.getParameter("businessCategory");
		String jobCategory          = request.getParameter("jobCategory");
		String fractCategory        = request.getParameter("fractCategory");
		String shiftCategory        = request.getParameter("shiftCategory");
		String lastCutoffDate       = request.getParameter("lastCutoffDate");
		String salesCMCategory  	= request.getParameter("salesCMCategory");
		String cutoffGroup 	 	    = request.getParameter("cutoffGroup");
		String paybackTypeCategory  = request.getParameter("paybackTypeCategory");
		String billPrintUnit        = request.getParameter("billPrintUnit");
		String billDatePrint        = request.getParameter("billDatePrint");
		String tempDeliverySlipFlag = request.getParameter("tempDeliverySlipFlag");
		String paymentName 	        = request.getParameter("paymentName");
		String remarks 		        = request.getParameter("remarks");
		String comment              = request.getParameter("comment");
		
		
		CustomerAddBean bean = new CustomerAddBean();
		bean.setCustomerCode(customerCode);
		bean.setCustomerName(customerName);
		bean.setCustomerKana(customerKana);
		bean.setOfficeName(officeName);
		bean.setOfficeNameKana(officeNameKana);
		bean.setCustomerAbbr(customerAbbr);
		bean.setZipCode(zipCode);
		bean.setZipAddress1(zipAddress1);
		bean.setZipAddress2(zipAddress2);
		bean.setPCName(PCName);
		bean.setPCNameKana(PCNameKana);
		bean.setPCPreCategory(PCPreCategory);
		bean.setDeptName(deptName);
		bean.setPCPost(PCPost);
		bean.setTel(tel);
		bean.setFax(fax);
		bean.setEmail(email);
		bean.setRankCategory(rankCategory);
		bean.setUpdateFlag(updateFlag);
		bean.setROCategory(ROCategory);
		bean.setMaxCreditLimit(maxCreditLimit);
		bean.setBusinessCategory(businessCategory);
		bean.setJobCategory(jobCategory);
		bean.setFractCategory(fractCategory);
		bean.setShiftCategory(shiftCategory);
		bean.setLastCutoffDate(lastCutoffDate);
		bean.setSalesCMCategory(salesCMCategory);
		bean.setCutoffGroup(cutoffGroup);
		bean.setPaybackTypeCategory(paybackTypeCategory);
		bean.setBillPrintUnit(billPrintUnit);
		bean.setBillDatePrint(billDatePrint);
		bean.setTempDeliverySlipFlag(tempDeliverySlipFlag);
		bean.setPaymentName(paymentName);
		bean.setRemarks(remarks);
		bean.setComment(comment);
		
		
		CustomerDAO dao =  new CustomerDAO();
		
		int check = dao.addCustomer(bean);
		
		
		if(check == 999) {
			String message = space + "顧客情報の追加処理でエラーが生じました<br>";
			request.setAttribute("message",message);
		} 
		
		//�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		//String deliveryCode        = request.getParameter("deliveryCode");
		String deliveryName        = request.getParameter("deliveryName");
		String deliveryKana        = request.getParameter("deliveryKana");
		String delOfficeName 	   = request.getParameter("delOfficeName");
		String delOfficeKana       = request.getParameter("delOfficeNameKana");
	 	String delDeptName         = request.getParameter("delDeptName");
	 	String delZipCode          = request.getParameter("delZipCode");
	 	String delAddress1         = request.getParameter("delZipAddress1");
	 	String delAddress2         = request.getParameter("delZipAddress2");
		String delPCName 		   = request.getParameter("delPCName");
		String delPCNameKana 	   = request.getParameter("delPCNameKana");
		String delPCPreCategory    = request.getParameter("delPCPreCategory");
		String delTel			   = request.getParameter("delTel");
		String delFax 			   = request.getParameter("delFax");
		String delEmail            = request.getParameter("delEmail");
		
		//�ｿｽ�ｿｽ�ｿｽﾝ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ閧ｵ�ｿｽAString�ｿｽ^�ｿｽﾉ変奇ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		//LocalDateTime ldt           = LocalDateTime.now();
		//String creDate              = ldt.toString();
		
		//�ｿｽ�ｿｽ�ｿｽﾝの納�ｿｽ�ｿｽ�ｿｽR�ｿｽ[�ｿｽh�ｿｽﾌ最托ｿｽl+1�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		String deliveryCode = dao.getMaxDeliveryCode();
		
		
		//�ｿｽﾇ会ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽﾇ会ｿｽBean�ｿｽﾉセ�ｿｽb�ｿｽg�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		DeliveryAddBean delbean = new DeliveryAddBean();
		delbean.setAddress1(delAddress1);
		delbean.setAddress2(delAddress2);
		delbean.setDeliveryKana(deliveryKana);
		delbean.setDeliveryName(deliveryName);
		delbean.setDeptName(delDeptName);
		delbean.setEmail(delEmail);
		delbean.setFax(delFax);
		delbean.setOfficeKana(delOfficeKana);
		delbean.setOfficeName(delOfficeName);
		delbean.setPCKana(delPCNameKana);
		delbean.setPCName(delPCName);
		delbean.setPCPreCategory(delPCPreCategory);
		delbean.setTel(delTel);
		delbean.setZipCode(delZipCode);
		
		delbean.setDeliveryCode(deliveryCode);
		
		//�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽﾇ会ｿｽ�ｿｽ�ｿｽ�ｿｽ\�ｿｽb�ｿｽh�ｿｽ�ｿｽ�ｿｽﾄび出�ｿｽ�ｿｽ�ｿｽA�ｿｽG�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ鼾�ｿｽAcheck2�ｿｽ�ｿｽ"1"�ｿｽ�ｿｽ�ｿｽﾔゑｿｽ�ｿｽ�ｿｽ�ｿｽ
		int check2 = dao.addDelivery(delbean);
		
		//�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽﾇ会ｿｽ�ｿｽ�ｿｽ�ｿｽ\�ｿｽb�ｿｽh�ｿｽﾌエ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		if(check2 == 999) {
			String message2 = space + "納入先情報の追加処理でエラーが生じました<br>";
			request.setAttribute("message2",message2);
		} else {
			
		}
		
		//�ｿｽﾅ新�ｿｽﾌ納�ｿｽ�ｿｽ�ｿｽ�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽ�ｿｽ謫ｾ(�ｿｽ�ｿｽﾌ�ｿｽ�ｿｽ\�ｿｽb�ｿｽh�ｿｽﾅ登�ｿｽ^�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾛの納�ｿｽ�ｿｽ�ｿｽ�ｿｽR�ｿｽ[�ｿｽh)
		//String latestDelCode = dao.getAddDeliveryCode();
		
		//�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		//String deliveryCode2        = request.getParameter("deliveryCode2");
		String deliveryName2        = request.getParameter("deliveryName2");
		String deliveryKana2        = request.getParameter("deliveryKana2");
		String delOfficeName2 	   = request.getParameter("delOfficeName2");
		String delOfficeKana2       = request.getParameter("delOfficeNameKana2");
		String delDeptName2         = request.getParameter("delDeptName2");
		String delZipCode2          = request.getParameter("delZipCode2");
		String delAddress1_2         = request.getParameter("delZipAddress1_2");
		String delAddress2_2         = request.getParameter("delZipAddress2_2");
		String delPCName2 		   = request.getParameter("delPCName2");
		String delPCNameKana2 	   = request.getParameter("delPCNameKana2");
		String delPCPreCategory2    = request.getParameter("delPCPreCategory2");
		String delTel2			   = request.getParameter("delTel2");
		String delFax2 			   = request.getParameter("delFax2");
		String delEmail2            = request.getParameter("delEmail2");
		
		//�ｿｽ�ｿｽ�ｿｽﾝ趣ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ閧ｵ�ｿｽAString�ｿｽ^�ｿｽﾉ変奇ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		//LocalDateTime ldt2           = LocalDateTime.now();
		//String creDate2              = ldt2.toString();
		
		String deliveryCode2 = dao.getMaxDeliveryCode();
				
		//�ｿｽﾇ会ｿｽ�ｿｽ�ｿｽ�ｿｽ髏ｿ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽﾇ会ｿｽBean�ｿｽﾉセ�ｿｽb�ｿｽg�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		DeliveryAddBean delbean2 = new DeliveryAddBean();
		delbean2.setAddress1(delAddress1_2);
		delbean2.setAddress2(delAddress2_2);
		delbean2.setDeliveryKana(deliveryKana2);
		delbean2.setDeliveryName(deliveryName2);
		delbean2.setDeptName(delDeptName2);
		delbean2.setEmail(delEmail2);
		delbean2.setFax(delFax2);
		delbean2.setOfficeKana(delOfficeKana2);
		delbean2.setOfficeName(delOfficeName2);
		delbean2.setPCKana(delPCNameKana2);
		delbean2.setPCName(delPCName2);
		delbean2.setPCPreCategory(delPCPreCategory2);
		delbean2.setTel(delTel2);
		delbean2.setZipCode(delZipCode2);
		
		delbean2.setDeliveryCode(deliveryCode2);
		//delbean2.setCreDate(creDate2);
		
		//�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽi�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽj�ｿｽﾇ会ｿｽ�ｿｽ�ｿｽ�ｿｽ\�ｿｽb�ｿｽh�ｿｽ�ｿｽ�ｿｽﾄび出�ｿｽ�ｿｽ�ｿｽA�ｿｽG�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ鼾�ｿｽAcheck3�ｿｽ�ｿｽ"1"�ｿｽ�ｿｽ�ｿｽﾔゑｿｽ�ｿｽ�ｿｽ�ｿｽ
		int check3 = dao.addDelivery(delbean2);
		
		//�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽi�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽj�ｿｽﾇ会ｿｽ�ｿｽ�ｿｽ�ｿｽ\�ｿｽb�ｿｽh�ｿｽﾌエ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		if(check3 == 999) {
			String message3 = space + "請求先情報の追加処理でエラーが生じました<br><br>";
			request.setAttribute("message3",message3);
		}
		
		//�ｿｽﾅ新�ｿｽﾌ撰ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽ�ｿｽ謫ｾ(�ｿｽ�ｿｽﾌ�ｿｽ�ｿｽ\�ｿｽb�ｿｽh�ｿｽﾅ登�ｿｽ^�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾛの撰ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽR�ｿｽ[�ｿｽh)
		//String latestDelCode2 = dao.getAddDeliveryCode();
		
		//�ｿｽﾚ客�ｿｽﾖ連�ｿｽ�ｿｽ�ｿｽo�ｿｽ^�ｿｽ�ｿｽ�ｿｽ\�ｿｽb�ｿｽh�ｿｽ�ｿｽ�ｿｽﾄび出�ｿｽ�ｿｽ�ｿｽA(�ｿｽﾚ客�ｿｽR�ｿｽ[�ｿｽh�ｿｽA�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽR�ｿｽ[�ｿｽh�ｿｽy�ｿｽﾑ撰ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽR�ｿｽ[�ｿｽh�ｿｽA�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ/�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽt�ｿｽ�ｿｽ�ｿｽO)�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾉゑｿｽ�ｿｽﾄ、�ｿｽﾖ連�ｿｽ}�ｿｽX�ｿｽ^�ｿｽﾉ登�ｿｽ^�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		//�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽA�ｿｽG�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽcheck4,check5�ｿｽ�ｿｽ1�ｿｽ�ｿｽ�ｿｽﾔゑｿｽ�ｿｽ�ｿｽ�ｿｽ
		int check4 = dao.setRelation(customerCode, deliveryCode, "01");
		int check5 = dao.setRelation(customerCode, deliveryCode2, "02");
				
		if(check4 == 999 || check5 == 999) {
			String message3 = space + "関連情報の追加処理でエラーが生じました<br>";
			request.setAttribute("message4",message3);
		}

		
		if(check!=999 && check2!=999 && check3!=999 && check4!=999 && check5!=999) {
			String message6 = space + "顧客情報の追加が完了しました。";
			request.setAttribute("message",message6);
		}
		return forwardURL;
		
		
	}
	
	//�ｿｽﾚ客�ｿｽﾒ集�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ驛�ｿｽ\�ｿｽb�ｿｽh
	private String modifyCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customersearch.jsp";
		
		//�ｿｽﾒ集�ｿｽ�ｿｽ�ｿｽ�ｿｽﾚ客�ｿｽ�ｿｽ�ｿｽ
		String customerCode         = request.getParameter("customerCode");
		String customerName         = request.getParameter("customerName");
		String customerKana         = request.getParameter("customerKana");
		String officeName 	        = request.getParameter("officeName");
		String officeNameKana       = request.getParameter("officeNameKana");
	 	String customerAbbr         = request.getParameter("customerAbbr");
	 	String zipCode              = request.getParameter("zipCode");
	 	String zipAddress1          = request.getParameter("zipAddress1");
	 	String zipAddress2          = request.getParameter("zipAddress2");
		String PCName 		        = request.getParameter("PCName");
		String PCNameKana 	        = request.getParameter("PCNameKana");
		String PCPreCategory        = request.getParameter("PCPreCategory");
		String deptName             = request.getParameter("deptName");
		String PCPost               = request.getParameter("PCPost");
		String tel			        = request.getParameter("tel");
		String fax 			        = request.getParameter("fax");
		String email                = request.getParameter("email");
		String rankCategory         = request.getParameter("rankCategory");
		String updateFlag           = request.getParameter("updateFlag");
		String ROCategory           = request.getParameter("ROCategory");
		int maxCreditLimit          = Integer.parseInt(request.getParameter("maxCreditLimit"));
		String businessCategory     = request.getParameter("businessCategory");
		String jobCategory          = request.getParameter("jobCategory");
		String fractCategory        = request.getParameter("fractCategory");
		String shiftCategory        = request.getParameter("shiftCategory");
		String lastCutoffDate       = request.getParameter("lastCutoffDate");
		String salesCMCategory  	= request.getParameter("salesCMCategory");
		String cutoffGroup 	 	    = request.getParameter("cutoffGroup");
		String paybackTypeCategory  = request.getParameter("paybackTypeCategory");
		String billPrintUnit        = request.getParameter("billPrintUnit");
		String billDatePrint        = request.getParameter("billDatePrint");
		String tempDeliverySlipFlag = request.getParameter("tempDeliverySlipFlag");
		String paymentName 	        = request.getParameter("paymentName");
		String remarks 		        = request.getParameter("remarks");
		String comment              = request.getParameter("comment");
		
		//�ｿｽﾒ集�ｿｽ�ｿｽ�ｿｽ�ｿｽﾚ客�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾚ客�ｿｽﾒ集Bean�ｿｽﾉセ�ｿｽb�ｿｽg�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		CustomerModifyBean bean = new CustomerModifyBean();
		bean.setCustomerCode(customerCode);
		bean.setCustomerName(customerName);
		bean.setCustomerKana(customerKana);
		bean.setOfficeName(officeName);
		bean.setOfficeNameKana(officeNameKana);
		bean.setCustomerAbbr(customerAbbr);
		bean.setZipCode(zipCode);
		bean.setZipAddress1(zipAddress1);
		bean.setZipAddress2(zipAddress2);
		bean.setPCName(PCName);
		bean.setPCNameKana(PCNameKana);
		bean.setPCPreCategory(PCPreCategory);
		bean.setDeptName(deptName);
		bean.setPCPost(PCPost);
		bean.setTel(tel);
		bean.setFax(fax);
		bean.setEmail(email);
		bean.setRankCategory(rankCategory);
		bean.setUpdateFlag(updateFlag);
		bean.setROCategory(ROCategory);
		bean.setMaxCreditLimit(maxCreditLimit);
		bean.setBusinessCategory(businessCategory);
		bean.setJobCategory(jobCategory);
		bean.setFractCategory(fractCategory);
		bean.setShiftCategory(shiftCategory);
		bean.setLastCutoffDate(lastCutoffDate);
		bean.setSalesCMCategory(salesCMCategory);
		bean.setCutoffGroup(cutoffGroup);
		bean.setPaybackTypeCategory(paybackTypeCategory);
		bean.setBillPrintUnit(billPrintUnit);
		bean.setBillDatePrint(billDatePrint);
		bean.setTempDeliverySlipFlag(tempDeliverySlipFlag);
		bean.setPaymentName(paymentName);
		bean.setRemarks(remarks);
		bean.setComment(comment);
		
		
		CustomerDAO dao =  new CustomerDAO();
		//�ｿｽﾚ客DAO�ｿｽﾌ顧客�ｿｽﾒ集�ｿｽ�ｿｽ�ｿｽ\�ｿｽb�ｿｽh�ｿｽ�ｿｽ�ｿｽﾄび出�ｿｽ�ｿｽ�ｿｽA�ｿｽG�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽcheck�ｿｽ�ｿｽ1�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		int check = dao.modifyCustomer(bean);
		
		//�ｿｽﾚ客�ｿｽﾒ集�ｿｽﾌエ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		if(check == 999) {
			String message =  space + "顧客情報の編集処理でエラーが生じました<br><br>";
			request.setAttribute("message",message);
		}
		
		
		//�ｿｽﾒ集�ｿｽ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		String deliveryCode        = request.getParameter("deliveryCode");
		String deliveryName        = request.getParameter("deliveryName");
		String deliveryKana        = request.getParameter("deliveryKana");
		String delOfficeName 	   = request.getParameter("delOfficeName");
		String delOfficeKana       = request.getParameter("delOfficeNameKana");
	 	String delDeptName         = request.getParameter("delDeptName");
	 	String delZipCode          = request.getParameter("delZipCode");
	 	String delAddress1         = request.getParameter("delZipAddress1");
	 	String delAddress2         = request.getParameter("delZipAddress2");
		String delPCName 		   = request.getParameter("delPCName");
		String delPCNameKana 	   = request.getParameter("delPCNameKana");
		String delPCPreCategory    = request.getParameter("delPCPreCategory");
		String delTel			   = request.getParameter("delTel");
		String delFax 			   = request.getParameter("delFax");
		String delEmail            = request.getParameter("delEmail");
		
		LocalDateTime ldt           = LocalDateTime.now();
		String updDate              = ldt.toString();

		//�ｿｽﾒ集�ｿｽ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽﾒ集Bean�ｿｽﾉセ�ｿｽb�ｿｽg�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		DeliveryModifyBean delbean = new DeliveryModifyBean();
		delbean.setAddress1(delAddress1);
		delbean.setAddress2(delAddress2);
		delbean.setDeliveryCode(deliveryCode);
		delbean.setDeliveryKana(deliveryKana);
		delbean.setDeliveryName(deliveryName);
		delbean.setDeptName(delDeptName);
		delbean.setEmail(delEmail);
		delbean.setFax(delFax);
		delbean.setOfficeKana(delOfficeKana);
		delbean.setOfficeName(delOfficeName);
		delbean.setPCKana(delPCNameKana);;
		delbean.setPCName(delPCName);
		delbean.setPCPreCategory(delPCPreCategory);
		delbean.setTel(delTel);
		delbean.setZipCode(delZipCode);
		delbean.setUpdDate(updDate);
		
		//�ｿｽﾚ客DAO�ｿｽﾌ納�ｿｽ�ｿｽ�ｿｽ�ｿｽﾒ集�ｿｽ�ｿｽ�ｿｽ\�ｿｽb�ｿｽh�ｿｽ�ｿｽ�ｿｽﾄび出�ｿｽ�ｿｽ�ｿｽA�ｿｽG�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽcheck�ｿｽ�ｿｽ1�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		int check2 = dao.modifyDelivery(delbean);
		
		//�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽﾒ集�ｿｽﾌエ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		if(check2 == 999) {
			String message2 =  space + "納入先情報の編集処理でエラーが生じました<br>";
			request.setAttribute("message2",message2);
		}
		
		
		//�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		String deliveryCode2        = request.getParameter("deliveryCode2");
		String deliveryName2        = request.getParameter("deliveryName2");
		String deliveryKana2        = request.getParameter("deliveryKana2");
		String delOfficeName2 	   = request.getParameter("delOfficeName2");
		String delOfficeKana2       = request.getParameter("delOfficeNameKana2");
		String delDeptName2         = request.getParameter("delDeptName2");
		String delZipCode2          = request.getParameter("delZipCode2");
		String delAddress1_2         = request.getParameter("delZipAddress1_2");
		String delAddress2_2         = request.getParameter("delZipAddress2_2");
		String delPCName2 		   = request.getParameter("delPCName2");
		String delPCNameKana2 	   = request.getParameter("delPCNameKana2");
		String delPCPreCategory2    = request.getParameter("delPCPreCategory2");
		String delTel2			   = request.getParameter("delTel2");
		String delFax2 			   = request.getParameter("delFax2");
		String delEmail2            = request.getParameter("delEmail2");
				
		LocalDateTime ldt2           = LocalDateTime.now();
		String creDate2              = ldt2.toString();
				
		//�ｿｽﾒ集�ｿｽ�ｿｽ�ｿｽ髏ｿ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ(�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ)�ｿｽﾒ集Bean�ｿｽﾉセ�ｿｽb�ｿｽg�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		DeliveryModifyBean delbean2 = new DeliveryModifyBean();
		delbean2.setAddress1(delAddress1_2);
		delbean2.setAddress2(delAddress2_2);
		delbean2.setDeliveryCode(deliveryCode2);
		delbean2.setDeliveryKana(deliveryKana2);
		delbean2.setDeliveryName(deliveryName2);
		delbean2.setDeptName(delDeptName2);
		delbean2.setEmail(delEmail2);
		delbean2.setFax(delFax2);
		delbean2.setOfficeKana(delOfficeKana2);
		delbean2.setOfficeName(delOfficeName2);
		delbean2.setPCKana(delPCNameKana2);
		delbean2.setPCName(delPCName2);
		delbean2.setPCPreCategory(delPCPreCategory2);
		delbean2.setTel(delTel2);
		delbean2.setZipCode(delZipCode2);
		delbean2.setUpdDate(creDate2);
		
		//�ｿｽﾚ客DAO�ｿｽﾌ納�ｿｽ�ｿｽ�ｿｽ�ｿｽ(�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ)�ｿｽﾒ集�ｿｽ�ｿｽ�ｿｽ\�ｿｽb�ｿｽh�ｿｽ�ｿｽ�ｿｽﾄび出�ｿｽ�ｿｽ�ｿｽA�ｿｽG�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽcheck�ｿｽ�ｿｽ1�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		int check3 = dao.modifyDelivery(delbean2);
		//�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ(�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ)�ｿｽﾒ集�ｿｽﾌエ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		if(check3 == 999) {
			String message3 =  space + "請求先情報の編集処理でエラーが生じました<br>";
			request.setAttribute("message3",message3);
		}
				
//		String check4 = dao.setRelation(customerCode, deliveryCode, "01");
//		String check5 = dao.setRelation(customerCode, deliveryCode2, "02");
//		
//		//�ｿｽﾖ連�ｿｽ}�ｿｽX�ｿｽ^�ｿｽﾒ集�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾉでゑｿｽ�ｿｽﾈゑｿｽ�ｿｽ鼾�ｿｽﾌエ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ
//		if(check4 == "1" || check5 == "1") {
//			String message3 = "�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾌ追会ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾉゑｿｽ�ｿｽ�ｿｽ�ｿｽﾄエ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾜゑｿｽ�ｿｽ�ｿｽ";
//			request.setAttribute("message3",message3);
//		}
		
		if(check!=999 && check2!=999 && check3!=999) {
			String message4 =  space + "顧客情報の編集が完了しました";
			request.setAttribute("message",message4);
		}

		return forwardURL;
		
	}
	
	//�ｿｽﾚ客�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ尞懶ｿｽ�ｿｽ�ｿｽ驛�ｿｽ\�ｿｽb�ｿｽh
	private String deleteCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customersearch.jsp";
		
		String customerCode = request.getParameter("customerCode");
		
		CustomerDAO dao =  new CustomerDAO();
		//�ｿｽﾚ客�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ尞懶ｿｽ�ｿｽ�ｿｽ�ｿｽDAO�ｿｽﾌ�ｿｽ�ｿｽ\�ｿｽb�ｿｽh�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽs
		int check = dao.deleteCustomer(customerCode);
		
		//�ｿｽ尞懶ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾉでゑｿｽ�ｿｽﾈゑｿｽ�ｿｽ鼾�ｿｽﾌエ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ
		if(check == 999) {
			String message =  space + "顧客情報の削除処理でエラーが生じました";
			request.setAttribute("message",message);
		} else {
			String message =  space + "顧客情報の削除が完了しました";
			request.setAttribute("message",message);
		}
		
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
