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
	
	public CustomerController() {
	}
	
	//業務を振り分けるコントローラーメソッド
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
	
	//顧客情報を指定された情報に基づいて検索するメソッド
	private String searchCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL     = "/customersearch.jsp";
		//ユーザーが入力した情報を取得する
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
		
		
		//顧客情報をbeanにセットする
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
		
		//CustomerDAOの顧客検索メソッドを呼び出し、結果をリストで返す
		CustomerDAO dao =  new CustomerDAO();
		List<CustomerResultBean> list = dao.searchCustomer(bean);
		
		/*if(result == 0 ) {
			request.setAttribute("message","検索中にエラーが生じました");
		} else {
			//request.setAttribute( "message", "検索が完了しました。");
		} */
		
		//取得した顧客検索結果のリストを"customerList"をキーにしてリクエストスコープに登録する
		request.setAttribute("customerList",list);
			
		return forwardURL;
		
	}
	
	//顧客登録画面に遷移するメソッド
	private String moveAddCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customeraddmodify.jsp";
		
		request.setAttribute("status", "add");
		
		return forwardURL;
		
	}
	
	//顧客編集画面に遷移するメソッド
	private String moveModifyCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customeraddmodify.jsp";
		String customerCode   = request.getParameter("customerCode");
	
		
		CustomerDAO dao =  new CustomerDAO();
		//指定された顧客コードを基に顧客情報を取得する
		CustomerModifyBean bean = dao.getCustomer(customerCode);
		//指定された顧客コードを基に納入先情報を取得する
		List<DeliveryModifyBean> list = dao.getDelivery(customerCode);
		//指定された顧客コードを基に請求先情報を取得する
		DeliveryModifyBean bean2 = dao.getDelivery2(customerCode);
		
		//取得した各情報をリクエストスコープに登録する
		request.setAttribute("customer",bean);
		request.setAttribute("deliveryList",list);
		request.setAttribute("delivery2",bean2);
		
		request.setAttribute("status", "modify");
		
		return forwardURL;
		
	}
	
	//指定された情報を基に郵便番号及び住所を検索する
	private String searchAddress(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/zipsearch.jsp";
		
		String zipCode   = request.getParameter("zipCode");
		String address1   = request.getParameter("address1");
		
		//郵便番号検索のBeanに郵便番号と住所1をセットする
		AddressBean bean = new AddressBean();
		bean.setZipCode(zipCode);
		bean.setZipAddress1(address1);
		
		CustomerDAO dao =  new CustomerDAO();
		//顧客DAOの郵便番号検索メソッドを指定された情報を引数にして呼び出し、結果をリストで取得する
		List<AddressBean> list = dao.searchAddress(bean);
		
		//指定された情報を基に郵便番号と住所のリストを"ZipList"というキーでリクエストスコープに登録する
		request.setAttribute("ZipList",list);
		
		return forwardURL;
		
	}
	
	//顧客追加をするメソッド
	private String addCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customersearch.jsp";
		
		//顧客情報
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
		
		//顧客情報を顧客追加Beanにセットする
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
		//顧客DAOの顧客追加メソッドを呼び出し、エラーがあったらcheckに1が入る
		int check = dao.addCustomer(bean);
		
		//顧客情報追加のエラー処理
		if(check == 1) {
			String message = "顧客情報の追加処理においてエラーが発生しました<br>";
			request.setAttribute("message",message);
		} 
		
		//納入先情報
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
		
		//現在時刻を入手し、String型に変換する
		LocalDateTime ldt           = LocalDateTime.now();
		String creDate              = ldt.toString();

		
		
		//追加する納入先情報を納入先追加Beanにセットする
		DeliveryAddBean delbean = new DeliveryAddBean();
		delbean.setAddress1(delAddress1);
		delbean.setAddress2(delAddress2);
		//delbean.setDeliveryCode(deliveryCode);
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
		delbean.setCreDate(creDate);
		
		//納入先追加メソッドを呼び出し、エラーが生じた場合、check2に"1"が返される
		int check2 = dao.addDelivery(delbean);
		
		//納入先追加メソッドのエラー処理
		if(check2 == 1) {
			String message2 = "納入先情報の追加処理においてエラーが発生しました<br>";
			request.setAttribute("message2",message2);
		} else {
			
		}
		
		//最新の納入先コードを取得(上のメソッドで登録した際の納入先コード)
		String delCode = dao.getAddDeliveryCode();
		
		//請求先
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
		
		//現在時刻を入手し、String型に変換する
		LocalDateTime ldt2           = LocalDateTime.now();
		String creDate2              = ldt2.toString();
				
		//追加する請求先情報を納入先追加Beanにセットする
		DeliveryAddBean delbean2 = new DeliveryAddBean();
		delbean2.setAddress1(delAddress1_2);
		delbean2.setAddress2(delAddress2_2);
		//delbean2.setDeliveryCode(deliveryCode2);
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
		delbean2.setCreDate(creDate2);
		
		//納入先追加メソッドを呼び出し、エラーが生じた場合、check3に"1"が返される
		int check3 = dao.addDelivery(delbean);
		
		//納入先追加メソッドのエラー処理
		if(check3 == 1) {
			String message3 = "請求先情報の追加処理においてエラーが発生しました<br>";
			request.setAttribute("message3",message3);
		}
		
		//最新の請求先先コードを取得(上のメソッドで登録した際の請求先コード)
		String delCode2 = dao.getAddDeliveryCode();
		
		//顧客関連情報登録メソッドを呼び出し、(顧客コード、納入先コード及び請求先コード、納入先/請求先フラグ)を引数にして、関連マスタに登録をする
		//もし、エラーが生じたらcheck4,check5に1が返される
		int check4 = dao.setRelation(customerCode, delCode, "01");
		int check5 = dao.setRelation(customerCode, delCode2, "02");
				
		if(check4 == 1 || check5 == 1) {
			String message3 = "請求先情報の追加処理においてエラーが発生しました";
			request.setAttribute("message3",message3);
		}

		
		if(check!=1 && check2!=1 && check3!=1 && check4!=1 && check5!=1) {
			String message6 = "顧客情報の追加が完了しました";
			request.setAttribute("message",message6);
		}
		return forwardURL;
		
		
	}
	
	//顧客編集をするメソッド
	private String modifyCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customersearch.jsp";
		
		//編集する顧客情報
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
		
		//編集する顧客情報を顧客編集Beanにセットする
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
		//顧客DAOの顧客編集メソッドを呼び出し、エラーがあったらcheckに1が入る
		int check = dao.modifyCustomer(bean);
		
		//顧客編集のエラー処理
		if(check == 1) {
			String message = "顧客情報の追加処理においてエラーが発生しました";
			request.setAttribute("message",message);
		}
		
		
		//編集する納入先情報
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

		//編集する納入先情報を納入先編集Beanにセットする
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
		delbean.setPCKana(delPCNameKana);
		delbean.setPCName(delPCName);
		delbean.setPCPreCategory(delPCPreCategory);
		delbean.setTel(delTel);
		delbean.setZipCode(delZipCode);
		delbean.setUpdDate(updDate);
		
		//顧客DAOの納入先編集メソッドを呼び出し、エラーがあったらcheckに1が入る
		int check2 = dao.modifyDelivery(delbean);
		
		//納入先編集のエラー処理
		if(check2 == 1) {
			String message2 = "納入先情報の追加処理においてエラーが発生しました";
			request.setAttribute("message2",message2);
		}
		
		
		//請求先情報
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
				
		//編集する請求先情報を納入先(請求先)編集Beanにセットする
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
		
		//顧客DAOの納入先(請求先)編集メソッドを呼び出し、エラーがあったらcheckに1が入る
		int check3 = dao.modifyDelivery(delbean2);
		//納入先(請求先)編集のエラー処理
		if(check3 == 1) {
			String message3 = "請求先情報の追加処理においてエラーが発生しました";
			request.setAttribute("message3",message3);
		}
				
//		String check4 = dao.setRelation(customerCode, deliveryCode, "01");
//		String check5 = dao.setRelation(customerCode, deliveryCode2, "02");
//		
//		//関連マスタ編集処理が正常にできない場合のエラー処理
//		if(check4 == "1" || check5 == "1") {
//			String message3 = "請求先情報の追加処理においてエラーが発生しました";
//			request.setAttribute("message3",message3);
//		}
		
		if(check!=1 && check2!=1 && check3!=1) {
			String message4 = "顧客情報の編集が完了しました";
			request.setAttribute("message",message4);
		}

		return forwardURL;
		
	}
	
	//顧客情報を削除するメソッド
	private String deleteCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customersearch.jsp";
		
		String customerCode = request.getParameter("customerCode");
		
		CustomerDAO dao =  new CustomerDAO();
		//顧客情報を削除するDAOのメソッドを実行
		int check = dao.deleteCustomer(customerCode);
		
		//削除処理が正常にできない場合のエラー処理
		if(check == 1) {
			String message = "顧客情報の削除処理においてエラーが発生しました";
			request.setAttribute("message",message);
		} else {
			String message = "顧客情報の削除が完了しました";
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
