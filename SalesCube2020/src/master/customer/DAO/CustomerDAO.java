package master.customer.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.dao.BaseDAO;
import master.customer.beans.AddressBean;
import master.customer.beans.CustomerAddBean;
import master.customer.beans.CustomerModifyBean;
import master.customer.beans.DeliveryAddBean;
import master.customer.beans.DeliveryModifyBean;
import master.customer.beans.customerSearchBeans.CustomerInputBean;
import master.customer.beans.customerSearchBeans.CustomerResultBean;

public class CustomerDAO extends BaseDAO {

	//�ڋq���������郁�\�b�h
	public List<CustomerResultBean> searchCustomer(CustomerInputBean bean) throws SQLException, ClassNotFoundException {
		
		List<CustomerResultBean> list = new ArrayList<> ();
		Connection con;
	 	PreparedStatement pstmt=null;
	 	ResultSet result=null;	
	 	String  sql;
	 	
	 	//Bean���猟�������̌ڋq�����擾����
	 	String customerCode   = bean.getCustomerCode();
	 	String customerName   = bean.getCustomerName();
	 	String customerKana   = bean.getCustomerKana();
	 	String officeName     = bean.getOfficeName();
	 	String officeNameKana = bean.getOfficeNameKana();
	 	String tel            = bean.getTel();
	 	String PCName         = bean.getPCName();
	 	String PCNameKana     = bean.getPaymentName();
	 	String fax            = bean.getFax();
	 	String rankCategory   = bean.getRankCategory();
	 	String cutoffGroup    = bean.getCutoffGroup();
	 	String paymentName    = bean.getPaymentName();
	 	String remarks        = bean.getRemarks();
	 	
	 	//SQL���Ɏg�p����e�ϐ��̐錾
	 	String customerCodeSQL;
	 	String customerNameSQL;
	 	String customerKanaSQL;
	 	String officeNameSQL;
	 	String officeNameKanaSQL;
	 	String telSQL;
	 	String PCNameSQL;
	 	String PCNameKanaSQL;
	 	String faxSQL;
	 	String rankCategorySQL;
	 	String cutoffGroupSQL;
	 	String paymentNameSQL;
	 	String remarksSQL;
	 	
	 	
	 	//null�܂��͉������͂���Ă��Ȃ��Ƃ���SQL�����쐬
	 	if(customerCode == null || customerCode == "") {
	 		customerCodeSQL = "LIKE '%'";
	 	} else {
	 		customerCodeSQL = "LIKE '" + customerCode + "%'";
	 	}
	 	
	 	if(customerName == null || customerName == "") {
	 		customerNameSQL = "LIKE '%' OR CUSTOMER_NAME IS NULL";
	 	} else {
	 		customerNameSQL = "LIKE '%" + customerName + "%'";
	 	}
	 	
	 	if(customerKana == null || customerKana == "") {
	 		customerKanaSQL = "LIKE '%' OR CUSTOMER_KANA IS NULL";
	 	} else {
	 		customerKanaSQL = "LIKE '%" + customerKana + "%'";
	 	}
	 	
	 	if(officeName == null || officeName == "") {
	 		officeNameSQL = "LIKE '%' OR CUSTOMER_OFFICE_NAME IS NULL";
	 	} else {
	 		officeNameSQL = "LIKE '%" + officeName + "%'";
	 	}
	 	
	 	if(officeNameKana == null || officeNameKana == "") {
	 		officeNameKanaSQL = "LIKE '%' OR CUSTOMER_OFFICE_KANA IS NULL";
	 	} else {
	 		officeNameKanaSQL = "LIKE '%" + officeNameKana + "%'";
	 	}
	 	
	 	if(tel == null || tel == "") {
	 		telSQL = "LIKE '%' OR CUSTOMER_TEL IS NULL";
	 	} else {
	 		telSQL = "LIKE '%" + tel + "%'";
	 	}
	 	
	 	if(PCName == null || PCName == "") {
	 		PCNameSQL = "LIKE '%' OR CUSTOMER_PC_NAME IS NULL";
	 	} else {
	 		PCNameSQL = "LIKE '%" + PCName + "%'";
	 	}
	 	
	 	if(PCNameKana == null || PCNameKana == "") {
	 		PCNameKanaSQL = "LIKE '%' OR CUSTOMER_PC_KANA IS NULL";
	 	} else {
	 		PCNameKanaSQL = "LIKE '%" + PCNameKana + "%'";
	 	}
	 	
	 	if(fax == null || fax == "") {
	 		faxSQL = "LIKE '%' OR CUSTOMER_FAX IS NULL";
	 	} else {
	 		faxSQL = "LIKE '%" + fax + "%'";
	 	}
	 	
	 	if(rankCategory == null || rankCategory == "") {
	 		rankCategorySQL = "LIKE '%' OR CUSTOMER_RANK_CATEGORY IS NULL";
	 	} else {
	 		rankCategorySQL = "= " + rankCategory;
	 	}
	 	
	 	if(cutoffGroup == null || cutoffGroup == "") {
	 		cutoffGroupSQL = "LIKE '%' OR CUTOFF_GROUP IS NULL";
	 	} else {
	 		cutoffGroupSQL = "= " + cutoffGroup;
	 	}
	 	
	 	if(paymentName == null || paymentName == "") {
	 		paymentNameSQL = "LIKE '%' OR PAYMENT_NAME IS NULL";
	 	} else {
	 		paymentNameSQL = "LIKE '%" + paymentName + "%'";
	 	}
	 	
	 	if(remarks == null || remarks == "") {
	 		remarksSQL = "LIKE '%' OR REMARKS IS NULL";
	 	} else {
	 		remarksSQL = "LIKE '%" + remarks + "%'";
	 	}
	 	

	 	con = super.getConnection();
	 	//�w�肳�ꂽ��������ɃJ�X�^�}�[�}�X�^��������擾����SQL��
	 	sql="select * from customer_mst_xxxxx where ( CUSTOMER_CODE " + customerCodeSQL + 
	 										" ) and ( CUSTOMER_NAME " + customerNameSQL + 
	 										" ) and ( CUSTOMER_KANA " + customerKanaSQL + 
	 										" ) and ( CUSTOMER_OFFICE_NAME " + officeNameSQL + 
	 										" ) and ( CUSTOMER_OFFICE_KANA " + officeNameKanaSQL + 
	 										" ) and ( CUSTOMER_TEL " + telSQL + 
	 										" ) and ( CUSTOMER_PC_NAME " + PCNameSQL + 
	 										" ) and ( CUSTOMER_PC_KANA " + PCNameKanaSQL + 
	 										" ) and ( CUSTOMER_FAX " + faxSQL + 
	 										" ) and ( CUSTOMER_RANK_CATEGORY " + rankCategorySQL + 
	 										" ) and ( CUTOFF_GROUP " + cutoffGroupSQL + 
	 										" ) and ( PAYMENT_NAME " + paymentNameSQL + 
	 										" ) and ( REMARKS " + remarksSQL + " )";

	 	pstmt = con.prepareStatement(sql);

	 	result = pstmt.executeQuery(sql);

	 	//SQL�̌��ʂ���Ɏ擾�����ڋq�����P���R�[�h�����X�g�ɓo�^
	 	while (result.next()) {
	 		CustomerResultBean rbean = new CustomerResultBean();
	 		rbean.setCustomerCode(result.getString("CUSTOMER_CODE"));
	 		rbean.setCustomerName(result.getString("CUSTOMER_NAME"));
	    	rbean.setTel(result.getString("CUSTOMER_TEL"));
	    	rbean.setPCName(result.getString("CUSTOMER_PC_NAME"));
	    	rbean.setSalesCMCategory(result.getString("SALES_CM_CATEGORY"));
	    	rbean.setCutoffGroup(result.getString("CUTOFF_GROUP"));
	    	rbean.setOfficeName(result.getString("CUSTOMER_OFFICE_NAME"));
	    	rbean.setDeptName(result.getString("CUSTOMER_DEPT_NAME"));
			list.add(rbean);
	 	}
	 	
	 	super.releaseDB(con,pstmt,result);
	 	
	 	return list;
	}

	//�w�肳�ꂽ�ڋq�R�[�h����Ɍڋq�����擾���郁�\�b�h
	public CustomerModifyBean getCustomer(String customerCode) throws SQLException, ClassNotFoundException {

		Connection con;
		Statement stmt= null;
	 	ResultSet result=null;	
	 	String  sql;
	 	
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	//�w�肳�ꂽ�ڋq�R�[�h����ڋq�����擾����SQL��
	 	sql = "select * from customer_mst_xxxxx where CUSTOMER_CODE = " + customerCode;
	 	result = stmt.executeQuery(sql);
	 	
	 	CustomerModifyBean bean = new CustomerModifyBean();
	 	
	 	//�擾�����ڋq����Bean�ɃZ�b�g����
	 	if(result.next()) {
	 		bean = new CustomerModifyBean();
		 	bean.setBillDatePrint(result.getString("BILL_DATE_PRINT"));
		 	bean.setBillPrintUnit(result.getString("BILL_PRINT_UNIT"));
		 	bean.setBusinessCategory(result.getString("CUSTOMER_BUSINESS_CATEGORY"));
		 	bean.setComment(result.getString("COMMENT_DATA"));
		 	bean.setCustomerAbbr(result.getString("CUSTOMER_ABBR"));
		 	bean.setCustomerCode(result.getString("CUSTOMER_CODE"));
		 	bean.setCustomerKana(result.getString("CUSTOMER_KANA"));
		 	bean.setCustomerName(result.getString("CUSTOMER_NAME"));
		 	bean.setCutoffGroup(result.getString("CUTOFF_GROUP"));
		 	bean.setDeptName(result.getString("CUSTOMER_DEPT_NAME"));
		 	bean.setEmail(result.getString("CUSTOMER_EMAIL"));
		 	bean.setFax(result.getString("CUSTOMER_FAX"));
		 	bean.setFractCategory(result.getString("TAX_FRACT_CATEGORY"));
		 	bean.setJobCategory(result.getString("CUSTOMER_JOB_CATEGORY"));
		 	//bean.setLastCutoffDate(result.getDate("LAST_CUTOFF_DATE"));
		 	bean.setMaxCreditLimit(result.getInt("MAX_CREDIT_LIMIT"));
		 	bean.setOfficeName(result.getString("CUSTOMER_OFFICE_NAME"));
		 	bean.setOfficeNameKana(result.getString("CUSTOMER_OFFICE_KANA"));
		 	bean.setPaybackTypeCategory(result.getString("PAYBACK_TYPE_CATEGORY"));
		 	bean.setPaymentName(result.getString("PAYMENT_NAME"));
		 	bean.setPCName(result.getString("CUSTOMER_PC_NAME"));
		 	bean.setPCNameKana(result.getString("CUSTOMER_PC_KANA"));
		 	bean.setPCPost(result.getString("CUSTOMER_PC_POST"));
		 	bean.setPCPreCategory(result.getString("CUSTOMER_PC_PRE_CATEGORY"));
		 	bean.setRankCategory(result.getString("CUSTOMER_RANK_CATEGORY"));
		 	bean.setRemarks(result.getString("REMARKS"));
		 	bean.setROCategory(result.getString("CUSTOMER_RO_CATEGORY"));
		 	bean.setSalesCMCategory(result.getString("SALES_CM_CATEGORY"));
		 	bean.setShiftCategory(result.getString("TAX_SHIFT_CATEGORY"));
		 	bean.setTel(result.getString("CUSTOMER_TEL"));
		 	bean.setTempDeliverySlipFlag(result.getString("TEMP_DELIVERY_SLIP_FLAG"));
		 	bean.setUpdateFlag(result.getString("CUSTOMER_UPD_FLAG"));
		 	bean.setZipAddress1(result.getString("CUSTOMER_ADDRESS_1"));
		 	bean.setZipAddress2(result.getString("CUSTOMER_ADDRESS_2"));
		 	bean.setZipCode(result.getString("CUSTOMER_ZIP_CODE"));
		 	//bean.setCreDate("CRE_DATETM");
		 	//bean.setUpdDate("UPD_DATETM");
	 	}
	 	
	 	super.releaseDB(con,stmt,result);
	 	
	 	return bean;
	}
	
	//�w�肳�ꂽ�ڋq�R�[�h����ɔ[����������X�g�Ŏ擾����
	public List<DeliveryModifyBean> getDelivery(String customerCode) throws SQLException, ClassNotFoundException {

		Connection con;
		Statement stmt= null;
	 	ResultSet result=null;	
	 	String  sql;
	 	
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	//�w�肳�ꂽ�ڋq�R�[�h����ɁA�[��������擾����(�֘A�J�e�S���[��01(�[����)�ɂ��Ă���)SQL��
	 	sql = "SELECT * FROM customer_rel_xxxxx RIGHT OUTER JOIN delivery_mst_xxxxx "
	 			+ "ON customer_rel_xxxxx.REL_CODE = delivery_mst_xxxxx.DELIVERY_CODE "
	 			+ "WHERE customer_rel_xxxxx.CUSTOMER_CODE = " + customerCode
	 			+ " AND customer_rel_xxxxx.CUST_REL_CATEGORY = '01' ";
	 	result = stmt.executeQuery(sql);
	 	
	 	List<DeliveryModifyBean> list = new ArrayList<> ();
	 	
	 	//�擾�����[�������1���R�[�h����Bean�ɃZ�b�g���ă��X�g�ɒǉ�����
	 	while(result.next()) {
	 		DeliveryModifyBean bean = new DeliveryModifyBean();
	 		bean.setAddress1(result.getString("DELIVERY_ADDRESS_1"));
	 		bean.setAddress2(result.getString("DELIVERY_ADDRESS_2"));
	 		bean.setDeliveryCode(result.getString("DELIVERY_CODE"));
	 		bean.setDeliveryKana(result.getString("DELIVERY_KANA"));
	 		bean.setDeliveryName(result.getString("DELIVERY_NAME"));
	 		bean.setDeptName(result.getString("DELIVERY_DEPT_NAME"));
	 		bean.setEmail(result.getString("DELIVERY_EMAIL"));
	 		bean.setFax(result.getString("DELIVERY_FAX"));
	 		bean.setOfficeKana(result.getString("DELIVERY_OFFICE_KANA"));
	 		bean.setOfficeName(result.getString("DELIVERY_OFFICE_NAME"));
	 		bean.setPCKana(result.getString("DELIVERY_PC_KANA"));
	 		bean.setPCName(result.getString("DELIVERY_PC_NAME"));
	 		bean.setPCPreCategory(result.getString("DELIVERY_PC_PRE_CATEGORY"));
	 		bean.setTel(result.getString("DELIVERY_TEL"));
	 		bean.setZipCode(result.getString("DELIVERY_ZIP_CODE"));
	 		list.add(bean);
	 	}
	 	
	 	super.releaseDB(con,stmt,result);
	 	
	 	return list;
	}

	//�w�肳�ꂽ�ڋq�R�[�h����ɐ���������擾����
	public DeliveryModifyBean getDelivery2(String customerCode) throws SQLException, ClassNotFoundException {

		Connection con;
		Statement stmt= null;
	 	ResultSet result=null;	
	 	String  sql;
	 	
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	//�w�肳�ꂽ�ڋq�R�[�h����ɁA����������擾���� (�֘A�J�e�S���[��02(������)�ɂ��Ă���)SQL��
	 	sql = "SELECT * FROM customer_rel_xxxxx RIGHT OUTER JOIN delivery_mst_xxxxx "
	 			+ "ON customer_rel_xxxxx.REL_CODE = delivery_mst_xxxxx.DELIVERY_CODE "
	 			+ "AND customer_rel_xxxxx.CUSTOMER_CODE = " + customerCode
	 			+ " AND customer_rel_xxxxx.CUST_REL_CATEGORY = '02' ";
	 	result = stmt.executeQuery(sql);
	 	
	 	DeliveryModifyBean bean = new DeliveryModifyBean();
	 	
	 	//�擾�����[�������Bean�ɃZ�b�g����
	 	if(result.next()) {
	 		bean.setAddress1(result.getString("DELIVERY_ADDRESS_1"));
	 		bean.setAddress2(result.getString("DELIVERY_ADDRESS_2"));
	 		bean.setDeliveryCode(result.getString("DELIVERY_CODE"));
	 		bean.setDeliveryKana(result.getString("DELIVERY_KANA"));
	 		bean.setDeliveryName(result.getString("DELIVERY_NAME"));
	 		bean.setDeptName(result.getString("DELIVERY_DEPT_NAME"));
	 		bean.setEmail(result.getString("DELIVERY_EMAIL"));
	 		bean.setFax(result.getString("DELIVERY_FAX"));
	 		bean.setOfficeKana(result.getString("DELIVERY_OFFICE_KANA"));
	 		bean.setOfficeName(result.getString("DELIVERY_OFFICE_NAME"));
	 		bean.setPCKana(result.getString("DELIVERY_PC_KANA"));
	 		bean.setPCName(result.getString("DELIVERY_PC_NAME"));
	 		bean.setPCPreCategory(result.getString("DELIVERY_PC_PRE_CATEGORY"));
	 		bean.setTel(result.getString("DELIVERY_TEL"));
	 		bean.setZipCode(result.getString("DELIVERY_ZIP_CODE"));
	 	}
	 	
	 	super.releaseDB(con,stmt,result);
	 	
	 	return bean;
	}
	
	//�ڋq��ǉ����郁�\�b�h
	public int addCustomer(CustomerAddBean bean) throws SQLException, ClassNotFoundException {

		Connection con;
		PreparedStatement pstmt= null;
	 	int result=0;	
	 	String  sql;
	 	
	 	//bean����ǉ�����ڋq�����擾����
	 	String customerCode         = bean.getCustomerCode();
		String customerName         = bean.getCustomerName();
		String customerKana         = bean.getCustomerKana();
		String officeName 	        = bean.getOfficeName();
		String officeNameKana       = bean.getOfficeNameKana();
	 	String customerAbbr         = bean.getCustomerAbbr();
	 	String zipCode              = bean.getZipCode();
	 	String zipAddress1          = bean.getZipAddress1();
	 	String zipAddress2          = bean.getZipAddress2();
		String PCName 		        = bean.getPCName();
		String PCNameKana 	        = bean.getPCNameKana();
		String PCPreCategory        = bean.getPCPreCategory();
		String deptName             = bean.getDeptName();
		String PCPost               = bean.getPCPost();
		String tel			        = bean.getTel();
		String fax 			        = bean.getFax();
		String email                = bean.getEmail();
		String rankCategory         = bean.getRankCategory();
		String updateFlag           = bean.getUpdateFlag();
		String ROCategory           = bean.getROCategory();
		int maxCreditLimit          = bean.getMaxCreditLimit();
		String businessCategory     = bean.getBusinessCategory();
		String jobCategory          = bean.getJobCategory();
		String fractCategory        = bean.getFractCategory();
		String shiftCategory        = bean.getShiftCategory();
		String lastCutoffDate       = bean.getLastCutoffDate();
		String salesCMCategory  	= bean.getSalesCMCategory();
		String cutoffGroup 	 	    = bean.getCutoffGroup();
		String paybackTypeCategory  = bean.getPaybackTypeCategory();
		String billPrintUnit        = bean.getBillPrintUnit();
		String billDatePrint        = bean.getBillDatePrint();
		String tempDeliverySlipFlag = bean.getTempDeliverySlipFlag();
		String paymentName 	        = bean.getPaymentName();
		String remarks 		        = bean.getRemarks();
		String comment              = bean.getComment();
	 	
	 	
	 	con = super.getConnection();
	 	//�ڋq�����ڋq�}�X�^�ɒǉ�����SQL��
	 	sql = "insert into customer_mst_xxxxx (CUSTOMER_CODE"
	 										+ "CUSTOMER_NAME ,"
	 										+ "CUSTOMER_KANA ,"
	 										+ "CUSTOMER_OFFICE_NAME ,"
	 										+ "CUSTOMER_OFFICE_KANA ,"
	 										+ "CUSTOMER_ABBR ,"
	 										+ "CUSTOMER_ZIP_CODE ,"
	 										+ "CUSTOMER_ADDRESS_1 ,"
	 										+ "CUSTOMER_ADDRESS_2 ,"
	 										+ "CUSTOMER_PC_NAME ,"
	 										+ "CUSTOMER_PC_KANA ,"
	 										+ "CUSTOMER_PC_PRE_CATEGORY ,"
	 										+ "CUSTOMER_DEPT_NAME ,"
	 										+ "CUSTOMER_PC_POST ,"
	 										+ "CUSTOMER_TEL ,"
	 										+ "CUSTOMER_FAX ,"
	 										+ "CUSTOMER_EMAIL ,"
	 										+ "CUSTOMER_RANK_CATEGORY ,"
	 										+ "CUSTOMER_UPD_FLAG ,"
	 										+ "CUSTOMER_RO_CATEGORY ,"
	 										+ "MAX_CREDIT_LIMIT ,"
	 										+ "CUSTOMER_BUSINESS_CATEGORY ,"
	 										+ "CUSTOMER_JOB_CATEGORY ,"
	 										+ "TAX_FRACT_CATEGORY"
	 										+ "TAX_SHIFT_CATEGORY ,"
	 										+ "LAST_CUTOFF_DATE ,"
	 										+ "SALES_CM_CATEGORY ,"
	 										+ "CUTOFF_GROUP ,"
	 										+ "PAYBACK_TYPE_CATEGORY ,"
	 										+ "BILL_PRINT_UNIT ,"
	 										+ "BILL_DATE_PRINT ,"
	 										+ "TEMP_DELIVERY_SLIP_FLAG ,"
	 										+ "PAYMENT_NAME ,"
	 										+ "REMARKS ,"
	 										+ "COMMENT_DATA)"
	 										+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	 	pstmt = con.prepareStatement(sql);
	 	pstmt.setString(1, customerCode);
	 	pstmt.setString(2, customerName);
	 	pstmt.setString(3, customerKana);
	 	pstmt.setString(4, officeName);
	 	pstmt.setString(5, officeNameKana);
	 	pstmt.setString(6, customerAbbr);
	 	pstmt.setString(7, zipCode);
	 	pstmt.setString(8, zipAddress1);
	 	pstmt.setString(9, zipAddress2);
	 	pstmt.setString(10, PCName);
	 	pstmt.setString(11, PCNameKana);
	 	pstmt.setString(12, PCPreCategory);
	 	pstmt.setString(13, deptName);
	 	pstmt.setString(14, PCPost);
	 	pstmt.setString(15, tel);
	 	pstmt.setString(16, fax);
	 	pstmt.setString(17, email);
	 	pstmt.setString(18, rankCategory);
	 	pstmt.setString(19, updateFlag);
	 	pstmt.setString(20, ROCategory);
	 	pstmt.setInt(21, maxCreditLimit);
	 	pstmt.setString(22, businessCategory);
	 	pstmt.setString(23, jobCategory);
	 	pstmt.setString(24, fractCategory);
	 	pstmt.setString(25, shiftCategory);
	 	pstmt.setString(26, lastCutoffDate);
	 	pstmt.setString(27, salesCMCategory);
	 	pstmt.setString(28, cutoffGroup);
	 	pstmt.setString(29, paybackTypeCategory);
	 	pstmt.setString(30, billPrintUnit);
	 	pstmt.setString(31, billDatePrint);
	 	pstmt.setString(32, tempDeliverySlipFlag);
	 	pstmt.setString(33, paymentName);
	 	pstmt.setString(34, remarks);
	 	pstmt.setString(35, comment);
	 	
	 	try {
	 		result = pstmt.executeUpdate();
	 		con.commit();
	 	} catch (SQLException e) {
	 		result = 1;
	 	} finally {
	 		super.releaseDB(con,pstmt);
	 	}
	 	
	 	return result;

	}
	
	//�[�����ǉ����郁�\�b�h
	public int addDelivery(DeliveryAddBean bean) throws SQLException, ClassNotFoundException {

		Connection con;
		PreparedStatement pstmt= null;
	 	int result=0;
	 	String  sql;
	 	
	 	//Bean����ǉ�����[��������擾����
	 	String address1         = bean.getAddress1();
		String address2         = bean.getAddress2();
		//String deliveryCode     = bean.getDeliveryCode();
		String deliveryKana 	= bean.getDeliveryKana();
		String deliveryName     = bean.getDeliveryName();
	 	String deptName         = bean.getDeptName();
	 	String email            = bean.getEmail();
	 	String fax              = bean.getFax();
	 	String officeKana       = bean.getOfficeKana();
		String officeName 		= bean.getOfficeName();
		String PCKana 	        = bean.getPCKana();
		String PCName           = bean.getPCName();
		String PCPreCategory    = bean.getPCPreCategory();
		String tel              = bean.getTel();
		String zipCode			= bean.getZipCode();
		String creDate          = bean.getCreDate();
		
	 	
	 	con = super.getConnection();
	 	//�[�������[����e�[�u���ɒǉ�����SQL��
	 	sql = "insert into delivery_mst_xxxxx (DELIVERY_ADDRESS_1 ,"
	 										+ "DELIVERY_ADDRESS_2 ,"
	 										+ "DELIVERY_KANA ,"
	 										+ "DELIVERY_NAME ,"
	 										+ "DELIVERY_DEPT_NAME ,"
	 										+ "DELIVERY_EMAIL ,"
	 										+ "DELIVERY_FAX ,"
	 										+ "DELIVERY_OFFICE_KANA ,"
	 										+ "DELIVERY_OFFICE_NAME ,"
	 										+ "DELIVERY_PC_KANA ,"
	 										+ "DELIVERY_PC_NAME ,"
	 										+ "DELIVERY_PC_PRE_CATEGORY ,"
	 										+ "DELIVERY_TEL	,"
	 										+ "DELIVERY_ZIP_CODE"
	 										+ "CRE_DATETM)"
	 										+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
	 	
	 	
	 	pstmt = con.prepareStatement(sql);
	 	pstmt.setString(1, address1);
	 	pstmt.setString(2, address2);
	 	pstmt.setString(3, deliveryKana);
	 	pstmt.setString(4, deliveryName);
	 	pstmt.setString(5, deptName);
	 	pstmt.setString(6, email);
	 	pstmt.setString(7, fax);
	 	pstmt.setString(8, officeKana);
	 	pstmt.setString(9, officeName);
	 	pstmt.setString(10, PCKana);
	 	pstmt.setString(11, PCName);
	 	pstmt.setString(12, PCPreCategory);
	 	pstmt.setString(13, tel);
	 	pstmt.setString(14, zipCode);
	 	pstmt.setString(15, creDate);
	 	
	 	
	 	try {
	 		result = pstmt.executeUpdate();
	 		System.out.println(result);
	 		con.commit();
	 	} catch (SQLException e) {
	 		result = 1;
	 	} finally {
	 		super.releaseDB(con,pstmt);
	 	}
	 	
	 	return result;
	}
	 
	//(�o�^����)�ŐV�̔[����R�[�h���擾����
	public String getAddDeliveryCode() throws SQLException, ClassNotFoundException {
		
		Connection con;
		Statement stmt= null;
	 	ResultSet result=null;
	 	String  sql;
	 	String delCode=null;
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	//(�o�^����)�ŐV�̔[����R�[�h���擾����SQL��
	 	sql = "SELECT DELIVERY_CODE from delivery_mst_XXXXX where CRE_DATETM = "
	 			+ "(select max(CRE_DATETM) from delivery_mst_XXXXX)";
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	
	 	while(result.next()){
	 		delCode = result.getString("DELIVERY_CODE");
	 	}
	 	
	 	super.releaseDB(con,stmt,result);
	 	
	 	return delCode;
	}
	
	//�֘A�}�X�^�e�[�u����(�ڋq�R�[�h�A�[����(������)�R�[�h�A�[����/������t���O)��ǉ����郁�\�b�h
	public int setRelation(String customerCode, String delCode, String relCategory) throws SQLException, ClassNotFoundException {
		
		
		Connection con;
		PreparedStatement pstmt= null;
	 	int result=0;
	 	String sql;
		
	 	
	 	con = super.getConnection();
	 	//�֘A�}�X�^�e�[�u����(�ڋq�R�[�h�A�[����(������)�R�[�h�A�[����/������t���O)��ǉ�����SQL��
	 	sql = "insert into customer_rel_xxxxx (CUSTOMER_CODE ,"
	 										+ "REL_CODE ,"
	 										+ "CUST_REL_CATEGORY)"
	 										+ " values (?, ?, ?)";
	 	
	 	
	 	pstmt = con.prepareStatement(sql);
	 	pstmt.setString(1, customerCode);
	 	pstmt.setString(2, delCode);
	 	pstmt.setString(3, relCategory);
	 	
	 	
	 	try {
	 		result = pstmt.executeUpdate();
	 		con.commit();
	 	} catch (SQLException e) {
	 		result = 1;
	 	} finally {
	 		super.releaseDB(con,pstmt);
	 	}
	 	
	 	return result;
	}
	
	//�ڋq����ҏW���郁�\�b�h
	public int modifyCustomer(CustomerModifyBean bean) throws SQLException, ClassNotFoundException {
		
		Connection con;
		Statement stmt= null;
	 	int result=0;	
	 	String  sql;
	 	
	 	//�ҏW����ڋq����bean����擾
	 	String customerCode         = bean.getCustomerCode();
		String customerName         = bean.getCustomerName();
		String customerKana         = bean.getCustomerKana();
		String officeName 	        = bean.getOfficeName();
		String officeNameKana       = bean.getOfficeNameKana();
	 	String customerAbbr         = bean.getCustomerAbbr();
	 	String zipCode              = bean.getZipCode();
	 	String zipAddress1          = bean.getZipAddress1();
	 	String zipAddress2          = bean.getZipAddress2();
		String PCName 		        = bean.getPCName();
		String PCNameKana 	        = bean.getPCNameKana();
		String PCPreCategory        = bean.getPCPreCategory();
		String deptName             = bean.getDeptName();
		String PCPost               = bean.getPCPost();
		String tel			        = bean.getTel();
		String fax 			        = bean.getFax();
		String email                = bean.getEmail();
		String rankCategory         = bean.getRankCategory();
		String updateFlag           = bean.getUpdateFlag();
		String ROCategory           = bean.getROCategory();
		int maxCreditLimit          = bean.getMaxCreditLimit();
		String businessCategory     = bean.getBusinessCategory();
		String jobCategory          = bean.getJobCategory();
		String fractCategory        = bean.getFractCategory();
		String shiftCategory        = bean.getShiftCategory();
		String lastCutoffDate       = bean.getLastCutoffDate();
		String salesCMCategory  	= bean.getSalesCMCategory();
		String cutoffGroup 	 	    = bean.getCutoffGroup();
		String paybackTypeCategory  = bean.getPaybackTypeCategory();
		String billPrintUnit        = bean.getBillPrintUnit();
		String billDatePrint        = bean.getBillDatePrint();
		String tempDeliverySlipFlag = bean.getTempDeliverySlipFlag();
		String paymentName 	        = bean.getPaymentName();
		String remarks 		        = bean.getRemarks();
		String comment              = bean.getComment();
	 	
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	//�ڋq�����X�V����SQL��
	 	sql = "UPDATE customer_mst_xxxxx SET " +
	 			"CUSTOMER_NAME = " + customerName +
	 			"CUSTOMER_KANA = " + customerKana +
	 			"CUSTOMER_OFFICE_NAME = " + officeName +
	 			"CUSTOMER_OFFICE_KANA = " + officeNameKana +
	 			"CUSTOMER_ABBR = " + customerAbbr +
	 			"CUSTOMER_ZIP_CODE = " + zipCode +
	 			"CUSTOMER_ADDRESS_1 = " + zipAddress1 +
	 			"CUSTOMER_ADDRESS_2 = " + zipAddress2 +
	 			"CUSTOMER_PC_NAME = " + PCName +
	 			"CUSTOMER_PC_KANA = " + PCNameKana +
	 			"CUSTOMER_PC_PRE_CATEGORY = " + PCPreCategory +
	 			"CUSTOMER_DEPT_NAME = " + deptName +
	 			"CUSTOMER_PC_POST = " + PCPost +
	 			"CUSTOMER_TEL = " + tel +
	 			"CUSTOMER_FAX = " + fax + 
	 			"CUSTOMER_EMAIL = " + email +
	 			"CUSTOMER_RANK_CATEGORY = " + rankCategory +
	 			"CUSTOMER_UPD_FLAG = " + updateFlag +
	 			"CUSTOMER_RO_CATEGORY = " + ROCategory +
	 			"MAX_CREDIT_LIMIT = " + maxCreditLimit +
	 			"CUSTOMER_BUSINESS_CATEGORY = " + businessCategory +
	 			"CUSTOMER_JOB_CATEGORY = " + jobCategory +
	 			"TAX_FRACT_CATEGORY" + fractCategory +
	 			"TAX_SHIFT_CATEGORY = " + shiftCategory +
	 			"LAST_CUTOFF_DATE = " + lastCutoffDate +
	 			"SALES_CM_CATEGORY = " + salesCMCategory +
	 			"CUTOFF_GROUP = " + cutoffGroup +
	 			"PAYBACK_TYPE_CATEGORY = " + paybackTypeCategory +
	 			"BILL_PRINT_UNIT = " + billPrintUnit +
	 			"BILL_DATE_PRINT = " + billDatePrint +
	 			"TEMP_DELIVERY_SLIP_FLAG = " + tempDeliverySlipFlag +
	 			"PAYMENT_NAME = " + paymentName +
	 			"REMARKS = " + remarks +
	 			"COMMENT_DATA = " + comment +
	 			"WHERE CUSTOMER_CODE = " + customerCode;
	 			

	 	
	 	try {
	 		result = stmt.executeUpdate(sql);
	 		con.commit();
	 	} catch (SQLException e) {
	 		result = 1;
	 	} finally {
	 		super.releaseDB(con,stmt);
	 	}
	 	
	 	return result;
		
	}
	
	//�[����(������)��ҏW���郁�\�b�h
	public int modifyDelivery(DeliveryModifyBean bean) throws SQLException, ClassNotFoundException {

		Connection con;
		Statement stmt= null;
	 	int result=0;
	 	String  sql;
	 	
	 	//�ҏW����[����(������)����bean����擾
	 	String address1         = bean.getAddress1();
		String address2         = bean.getAddress2();
		String deliveryCode     = bean.getDeliveryCode();
		String deliveryKana 	= bean.getDeliveryKana();
		String deliveryName     = bean.getDeliveryName();
	 	String deptName         = bean.getDeptName();
	 	String email            = bean.getEmail();
	 	String fax              = bean.getFax();
	 	String officeKana       = bean.getOfficeKana();
		String officeName 		= bean.getOfficeName();
		String PCKana 	        = bean.getPCKana();
		String PCName           = bean.getPCName();
		String PCPreCategory    = bean.getPCPreCategory();
		String tel              = bean.getTel();
		String zipCode			= bean.getZipCode();
		String updDate          = bean.getUpdDate();
		
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	//�[����(������)�����X�V����SQL��
	 	sql = "UPDATE delivery_mst_xxxxx SET " + 
	 			"DELIVERY_ADDRESS_1 = " + address1 +
	 			"DELIVERY_ADDRESS_2 = " + address2 +
	 			"DELIVERY_KANA = " + deliveryKana +
	 			"DELIVERY_NAME = " + deliveryName + 
	 			"DELIVERY_DEPT_NAME = " + deptName +
	 			"DELIVERY_EMAIL = " + email +
	 			"DELIVERY_FAX = " + fax +
	 			"DELIVERY_OFFICE_KANA = " + officeKana +
	 			"DELIVERY_OFFICE_NAME = " + officeName +
	 			"DELIVERY_PC_KANA = " + PCKana +
	 			"DELIVERY_PC_NAME = " + PCName +
	 			"DELIVERY_PC_PRE_CATEGORY = " + PCPreCategory +
	 			"DELIVERY_TEL = " + tel +
	 			"DELIVERY_ZIP_CODE = " + zipCode +
	 			"UPD_DATETM = " + updDate +
	 			"WHERE DELIVERY_CODE = " + deliveryCode;
	 			
	 	
	 	
	 	
	 	try {
	 		result = stmt.executeUpdate(sql);
	 		con.commit();
	 	} catch (SQLException e) {
	 		result = 1;
	 	} finally {
	 		super.releaseDB(con,stmt);
	 	}
	 	
	 	return result;
	}
	
	
	//�֘A�}�X�^�e�[�u����ҏW���郁�\�b�h
	public int modifyRelation(String customerCode, String delCode, String relCategory) throws SQLException, ClassNotFoundException {
		
		
		Connection con;
		Statement stmt= null;
	 	int result=0;
	 	String sql;
		
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	//�֘A�}�X�^�e�[�u����ҏW����SQL��
	 	sql = "UPDATE customer_rel_xxxxx " +
	 			"REL_CODE = " + delCode +
	 			"CUST_REL_CATEGORY = " + relCategory +
	 			"WHERE CUSTOMER_CODE = " + customerCode;	 	
	 	
	 	try {
	 		result = stmt.executeUpdate(sql);
	 		con.commit();
	 	} catch (SQLException e) {
	 		result = 1;
	 	} finally {
	 		super.releaseDB(con,stmt);
	 	}
	 	
	 	return result;
	}
	
	//�ڋq�폜�����郁�\�b�h
	public int deleteCustomer(String customerCode) throws SQLException, ClassNotFoundException {

		Connection con;
		Statement stmt= null;
	 	int result=0;
	 	String  sql;
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	//�ڋq�폜������SQL��
	 	sql = "DELETE FROM customer_mst_xxxxx�@WHERE CUSTOMER_CODE = " + customerCode;	 	
	 	
	 	try {
	 		result = stmt.executeUpdate(sql);
	 		con.commit();
	 	} catch (SQLException e) {
	 		result = 1;
	 	} finally {
	 		super.releaseDB(con,stmt);
	 	}
	 	
	 	return result;
	}
	
	//�X�֔ԍ��y�яZ�����擾���郁�\�b�h
	public List<AddressBean> searchAddress(AddressBean bean) throws SQLException, ClassNotFoundException {
		
		List<AddressBean> list = new ArrayList<> ();
		Connection con;
		Statement stmt= null;
	 	ResultSet result=null;	
	 	String  sql;
	 	
	 	//������������̗X�֔ԍ��y�яZ����bean����擾
	 	String zipCode = bean.getZipCode();
	 	String address1 = bean.getZipAddress1();
	 	
	 	String zipCodeSQL;
	 	String address1_SQL;
	 	
	 	if(zipCode == null || zipCode == "") {
	 		zipCodeSQL = "LIKE '%' OR ZIP_CODE IS NULL";
	 	} else {
	 		zipCodeSQL = "LIKE '" + zipCode + "%'";
	 	}
	 	
	 	if(address1 == null || address1 == "") {
	 		address1_SQL = "LIKE '%' OR ZIP_ADDRESS_1 IS NULL";
	 	} else {
	 		address1_SQL = "LIKE '" + address1 + "%'";
	 	}
	 	
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	//�w�肳�ꂽ�����̏Z�������擾����
	 	sql = "SELECT * FROM ZIP_MST_XXXXX where ( ZIP_CODE " + zipCodeSQL +
	 			" ) AND ( ZIP_ADDRESS_1 " + address1_SQL + " )"; 
	 			
	 			
	 			
	 	result = stmt.executeQuery(sql);
	 	
	 	AddressBean bean2 = new AddressBean();
	 	
	 	//�擾�����Z������1���R�[�h����bean�ɃZ�b�g���A���X�g�ɒǉ�����
	 	while(result.next()) {
	 		bean2.setZipCode(result.getString("ZIP_CODE"));
	 		bean2.setZipAddress1(result.getString("ZIP_ADDRESS_1"));
	 		bean2.setZipAddress2(result.getString("ZIP_ADDRESS_2"));
	 		list.add(bean2);
	 	}
	 	
	 	super.releaseDB(con,stmt,result);
	 	
	 	return list;
		
	}
	





		
		
		
		
		
		
		
		
		
}
