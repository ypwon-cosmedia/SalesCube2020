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
	
	//�Ɩ���U�蕪����R���g���[���[���\�b�h
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
	
	//�ڋq�����w�肳�ꂽ���Ɋ�Â��Č������郁�\�b�h
	private String searchCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL     = "/customersearch.jsp";
		//���[�U�[�����͂��������擾����
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
		
		
		//�ڋq����bean�ɃZ�b�g����
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
		
		//CustomerDAO�̌ڋq�������\�b�h���Ăяo���A���ʂ����X�g�ŕԂ�
		CustomerDAO dao =  new CustomerDAO();
		List<CustomerResultBean> list = dao.searchCustomer(bean);
		
		/*if(result == 0 ) {
			request.setAttribute("message","�������ɃG���[�������܂���");
		} else {
			//request.setAttribute( "message", "�������������܂����B");
		} */
		
		//�擾�����ڋq�������ʂ̃��X�g��"customerList"���L�[�ɂ��ă��N�G�X�g�X�R�[�v�ɓo�^����
		request.setAttribute("customerList",list);
			
		return forwardURL;
		
	}
	
	//�ڋq�o�^��ʂɑJ�ڂ��郁�\�b�h
	private String moveAddCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customeraddmodify.jsp";
		
		request.setAttribute("status", "add");
		
		return forwardURL;
		
	}
	
	//�ڋq�ҏW��ʂɑJ�ڂ��郁�\�b�h
	private String moveModifyCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customeraddmodify.jsp";
		String customerCode   = request.getParameter("customerCode");
	
		
		CustomerDAO dao =  new CustomerDAO();
		//�w�肳�ꂽ�ڋq�R�[�h����Ɍڋq�����擾����
		CustomerModifyBean bean = dao.getCustomer(customerCode);
		//�w�肳�ꂽ�ڋq�R�[�h����ɔ[��������擾����
		List<DeliveryModifyBean> list = dao.getDelivery(customerCode);
		//�w�肳�ꂽ�ڋq�R�[�h����ɐ���������擾����
		DeliveryModifyBean bean2 = dao.getDelivery2(customerCode);
		
		//�擾�����e�������N�G�X�g�X�R�[�v�ɓo�^����
		request.setAttribute("customer",bean);
		request.setAttribute("deliveryList",list);
		request.setAttribute("delivery2",bean2);
		
		request.setAttribute("status", "modify");
		
		return forwardURL;
		
	}
	
	//�w�肳�ꂽ������ɗX�֔ԍ��y�яZ������������
	private String searchAddress(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/zipsearch.jsp";
		
		String zipCode   = request.getParameter("zipCode");
		String address1   = request.getParameter("address1");
		
		//�X�֔ԍ�������Bean�ɗX�֔ԍ��ƏZ��1���Z�b�g����
		AddressBean bean = new AddressBean();
		bean.setZipCode(zipCode);
		bean.setZipAddress1(address1);
		
		CustomerDAO dao =  new CustomerDAO();
		//�ڋqDAO�̗X�֔ԍ��������\�b�h���w�肳�ꂽ���������ɂ��ČĂяo���A���ʂ����X�g�Ŏ擾����
		List<AddressBean> list = dao.searchAddress(bean);
		
		//�w�肳�ꂽ������ɗX�֔ԍ��ƏZ���̃��X�g��"ZipList"�Ƃ����L�[�Ń��N�G�X�g�X�R�[�v�ɓo�^����
		request.setAttribute("ZipList",list);
		
		return forwardURL;
		
	}
	
	//�ڋq�ǉ������郁�\�b�h
	private String addCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customersearch.jsp";
		
		//�ڋq���
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
		
		//�ڋq�����ڋq�ǉ�Bean�ɃZ�b�g����
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
		//�ڋqDAO�̌ڋq�ǉ����\�b�h���Ăяo���A�G���[����������check��1������
		int check = dao.addCustomer(bean);
		
		//�ڋq���ǉ��̃G���[����
		if(check == 1) {
			String message = "�ڋq���̒ǉ������ɂ����ăG���[���������܂���<br>";
			request.setAttribute("message",message);
		} 
		
		//�[������
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
		
		//���ݎ�������肵�AString�^�ɕϊ�����
		LocalDateTime ldt           = LocalDateTime.now();
		String creDate              = ldt.toString();

		
		
		//�ǉ�����[�������[����ǉ�Bean�ɃZ�b�g����
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
		
		//�[����ǉ����\�b�h���Ăяo���A�G���[���������ꍇ�Acheck2��"1"���Ԃ����
		int check2 = dao.addDelivery(delbean);
		
		//�[����ǉ����\�b�h�̃G���[����
		if(check2 == 1) {
			String message2 = "�[������̒ǉ������ɂ����ăG���[���������܂���<br>";
			request.setAttribute("message2",message2);
		} else {
			
		}
		
		//�ŐV�̔[����R�[�h���擾(��̃��\�b�h�œo�^�����ۂ̔[����R�[�h)
		String delCode = dao.getAddDeliveryCode();
		
		//������
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
		
		//���ݎ�������肵�AString�^�ɕϊ�����
		LocalDateTime ldt2           = LocalDateTime.now();
		String creDate2              = ldt2.toString();
				
		//�ǉ����鐿�������[����ǉ�Bean�ɃZ�b�g����
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
		
		//�[����ǉ����\�b�h���Ăяo���A�G���[���������ꍇ�Acheck3��"1"���Ԃ����
		int check3 = dao.addDelivery(delbean);
		
		//�[����ǉ����\�b�h�̃G���[����
		if(check3 == 1) {
			String message3 = "��������̒ǉ������ɂ����ăG���[���������܂���<br>";
			request.setAttribute("message3",message3);
		}
		
		//�ŐV�̐������R�[�h���擾(��̃��\�b�h�œo�^�����ۂ̐�����R�[�h)
		String delCode2 = dao.getAddDeliveryCode();
		
		//�ڋq�֘A���o�^���\�b�h���Ăяo���A(�ڋq�R�[�h�A�[����R�[�h�y�ѐ�����R�[�h�A�[����/������t���O)�������ɂ��āA�֘A�}�X�^�ɓo�^������
		//�����A�G���[����������check4,check5��1���Ԃ����
		int check4 = dao.setRelation(customerCode, delCode, "01");
		int check5 = dao.setRelation(customerCode, delCode2, "02");
				
		if(check4 == 1 || check5 == 1) {
			String message3 = "��������̒ǉ������ɂ����ăG���[���������܂���";
			request.setAttribute("message3",message3);
		}

		
		if(check!=1 && check2!=1 && check3!=1 && check4!=1 && check5!=1) {
			String message6 = "�ڋq���̒ǉ����������܂���";
			request.setAttribute("message",message6);
		}
		return forwardURL;
		
		
	}
	
	//�ڋq�ҏW�����郁�\�b�h
	private String modifyCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customersearch.jsp";
		
		//�ҏW����ڋq���
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
		
		//�ҏW����ڋq�����ڋq�ҏWBean�ɃZ�b�g����
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
		//�ڋqDAO�̌ڋq�ҏW���\�b�h���Ăяo���A�G���[����������check��1������
		int check = dao.modifyCustomer(bean);
		
		//�ڋq�ҏW�̃G���[����
		if(check == 1) {
			String message = "�ڋq���̒ǉ������ɂ����ăG���[���������܂���";
			request.setAttribute("message",message);
		}
		
		
		//�ҏW����[������
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

		//�ҏW����[�������[����ҏWBean�ɃZ�b�g����
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
		
		//�ڋqDAO�̔[����ҏW���\�b�h���Ăяo���A�G���[����������check��1������
		int check2 = dao.modifyDelivery(delbean);
		
		//�[����ҏW�̃G���[����
		if(check2 == 1) {
			String message2 = "�[������̒ǉ������ɂ����ăG���[���������܂���";
			request.setAttribute("message2",message2);
		}
		
		
		//��������
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
				
		//�ҏW���鐿�������[����(������)�ҏWBean�ɃZ�b�g����
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
		
		//�ڋqDAO�̔[����(������)�ҏW���\�b�h���Ăяo���A�G���[����������check��1������
		int check3 = dao.modifyDelivery(delbean2);
		//�[����(������)�ҏW�̃G���[����
		if(check3 == 1) {
			String message3 = "��������̒ǉ������ɂ����ăG���[���������܂���";
			request.setAttribute("message3",message3);
		}
				
//		String check4 = dao.setRelation(customerCode, deliveryCode, "01");
//		String check5 = dao.setRelation(customerCode, deliveryCode2, "02");
//		
//		//�֘A�}�X�^�ҏW����������ɂł��Ȃ��ꍇ�̃G���[����
//		if(check4 == "1" || check5 == "1") {
//			String message3 = "��������̒ǉ������ɂ����ăG���[���������܂���";
//			request.setAttribute("message3",message3);
//		}
		
		if(check!=1 && check2!=1 && check3!=1) {
			String message4 = "�ڋq���̕ҏW���������܂���";
			request.setAttribute("message",message4);
		}

		return forwardURL;
		
	}
	
	//�ڋq�����폜���郁�\�b�h
	private String deleteCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL = "/customersearch.jsp";
		
		String customerCode = request.getParameter("customerCode");
		
		CustomerDAO dao =  new CustomerDAO();
		//�ڋq�����폜����DAO�̃��\�b�h�����s
		int check = dao.deleteCustomer(customerCode);
		
		//�폜����������ɂł��Ȃ��ꍇ�̃G���[����
		if(check == 1) {
			String message = "�ڋq���̍폜�����ɂ����ăG���[���������܂���";
			request.setAttribute("message",message);
		} else {
			String message = "�ڋq���̍폜���������܂���";
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
