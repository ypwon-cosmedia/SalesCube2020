package master.customer.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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

	//�ｿｽﾚ客�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ驛�ｿｽ\�ｿｽb�ｿｽh
	public List<CustomerResultBean> searchCustomer(CustomerInputBean bean) throws SQLException, ClassNotFoundException {
		
		List<CustomerResultBean> list = new ArrayList<> ();
		Connection con;
	 	PreparedStatement pstmt=null;
	 	ResultSet result=null;	
	 	String  sql;
	 	
	 	//Bean�ｿｽ�ｿｽ�ｿｽ迪滂ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾌ顧客�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ
	 	String customerCode   = bean.getCustomerCode();
	 	String customerName   = bean.getCustomerName();
	 	String customerKana   = bean.getCustomerKana();
	 	String officeName     = bean.getOfficeName();
	 	String officeNameKana = bean.getOfficeNameKana();
	 	String tel            = bean.getTel();
	 	String PCName         = bean.getPCName();
	 	String PCNameKana     = bean.getPCNameKana();
	 	String fax            = bean.getFax();
	 	String rankCategory   = bean.getRankCategory();
	 	String cutoffGroup    = bean.getCutoffGroup();
	 	String paymentName    = bean.getPaymentName();
	 	String remarks        = bean.getRemarks();
	 	
	 	//SQL�ｿｽ�ｿｽ�ｿｽﾉ使�ｿｽp�ｿｽ�ｿｽ�ｿｽ�ｿｽe�ｿｽﾏ撰ｿｽ�ｿｽﾌ宣言
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
	 	
	 	
	 	//null�ｿｽﾜゑｿｽ�ｿｽﾍ会ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾍゑｿｽ�ｿｽ�ｿｽﾄゑｿｽ�ｿｽﾈゑｿｽ�ｿｽﾆゑｿｽ�ｿｽ�ｿｽSQL�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�成
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
	 	//�ｿｽw�ｿｽ閧ｳ�ｿｽ黷ｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾉカ�ｿｽX�ｿｽ^�ｿｽ}�ｿｽ[�ｿｽ}�ｿｽX�ｿｽ^�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽSQL�ｿｽ�ｿｽ
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
	 	
	 	String salesCMCategory=null;
	 	String salesCMCategoryNum =null;
	 	String cutoffGroup2=null;
	 	String cutoffGroupNum=null;

	 	//SQL�ｿｽﾌ鯉ｿｽ�ｿｽﾊゑｿｽ�ｿｽ�ｿｽﾉ取得�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾚ客�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽP�ｿｽ�ｿｽ�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽ�ｿｽﾂ�ｿｽ�ｿｽX�ｿｽg�ｿｽﾉ登�ｿｽ^
	 	while (result.next()) {
	 		CustomerResultBean rbean = new CustomerResultBean();
	 		rbean.setCustomerCode(result.getString("CUSTOMER_CODE"));
	 		rbean.setCustomerName(result.getString("CUSTOMER_NAME"));
	    	rbean.setTel(result.getString("CUSTOMER_TEL"));
	    	rbean.setPCName(result.getString("CUSTOMER_PC_NAME"));
	    	
	    	salesCMCategoryNum = result.getString("SALES_CM_CATEGORY");
	    	if (salesCMCategoryNum.equals("1")) {
	    		salesCMCategory = "掛売";
	    	} else if(salesCMCategoryNum.equals("2")) {
	    		salesCMCategory = "現金";
	    	} else if(salesCMCategoryNum.equals("3")) {
	    		salesCMCategory = "サンプル";
	    	} else if(salesCMCategoryNum.equals("4")) {
	    		salesCMCategory = "代引き";
	    	} else if(salesCMCategoryNum.equals("5")) {
	    		salesCMCategory = "クレジット";
	    	} else if(salesCMCategoryNum.equals("6")) {
	    		salesCMCategory = "先入金";
	    	} else if(salesCMCategoryNum.equals("7")) {
	    		salesCMCategory = "通販サイト1経由";
	    	}
	    	rbean.setSalesCMCategory(salesCMCategory);
	    	
	    	cutoffGroupNum = result.getString("CUTOFF_GROUP");
	    	if (cutoffGroupNum.equals("1")) {
	    		cutoffGroup2 = "10日締め翌月10日";
	    	} else if(cutoffGroupNum.equals("2")) {
	    		cutoffGroup2 = "20日締め翌月20日";
	    	} else if(cutoffGroupNum.equals("3")) {
	    		cutoffGroup2 = "25日締め翌月末";
	    	} else if(cutoffGroupNum.equals("4")) {
	    		cutoffGroup2 = "月末締め翌月末日";
	    	} else if(cutoffGroupNum.equals("5")) {
	    		cutoffGroup2 = "月末締め翌々月5日";
	    	} else if(cutoffGroupNum.equals("6")) {
	    		cutoffGroup2 = "その他";
	    	}
	    	
	    	rbean.setCutoffGroup(cutoffGroup2);
	    	
	    	rbean.setOfficeName(result.getString("CUSTOMER_OFFICE_NAME"));
	    	rbean.setDeptName(result.getString("CUSTOMER_DEPT_NAME"));
			list.add(rbean);
	 	}
	 	
	 	super.releaseDB(con,pstmt,result);
	 	
	 	return list;
	}

	//�ｿｽw�ｿｽ閧ｳ�ｿｽ黷ｽ�ｿｽﾚ客�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽ�ｿｽ�ｿｽﾉ顧客�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ驛�ｿｽ\�ｿｽb�ｿｽh
	public CustomerModifyBean getCustomer(String customerCode) throws SQLException, ClassNotFoundException {

		Connection con;
		Statement stmt= null;
	 	ResultSet result=null;	
	 	String  sql;
	 	
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	//�ｿｽw�ｿｽ閧ｳ�ｿｽ黷ｽ�ｿｽﾚ客�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽ�ｿｽ�ｿｽﾚ客�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽSQL�ｿｽ�ｿｽ
	 	sql = "select * from customer_mst_xxxxx where CUSTOMER_CODE = " + customerCode;
	 	result = stmt.executeQuery(sql);
	 	
	 	CustomerModifyBean bean = new CustomerModifyBean();
	 	
	 	//�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾚ客�ｿｽ�ｿｽ�ｿｽ�ｿｽBean�ｿｽﾉセ�ｿｽb�ｿｽg�ｿｽ�ｿｽ�ｿｽ�ｿｽ
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
	
	//�ｿｽw�ｿｽ閧ｳ�ｿｽ黷ｽ�ｿｽﾚ客�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽ�ｿｽ�ｿｽﾉ納�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽX�ｿｽg�ｿｽﾅ取得�ｿｽ�ｿｽ�ｿｽ�ｿｽ
	public List<DeliveryModifyBean> getDelivery(String customerCode) throws SQLException, ClassNotFoundException {

		Connection con;
		Statement stmt= null;
	 	ResultSet result=null;	
	 	String  sql;
	 	
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	//�ｿｽw�ｿｽ閧ｳ�ｿｽ黷ｽ�ｿｽﾚ客�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽ�ｿｽ�ｿｽﾉ、�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ(�ｿｽﾖ連�ｿｽJ�ｿｽe�ｿｽS�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ01(�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ)�ｿｽﾉゑｿｽ�ｿｽﾄゑｿｽ�ｿｽ�ｿｽ)SQL�ｿｽ�ｿｽ
	 	sql = "SELECT * FROM customer_rel_xxxxx RIGHT OUTER JOIN delivery_mst_xxxxx "
	 			+ "ON customer_rel_xxxxx.REL_CODE = delivery_mst_xxxxx.DELIVERY_CODE "
	 			+ "WHERE customer_rel_xxxxx.CUSTOMER_CODE = " + customerCode
	 			+ " AND customer_rel_xxxxx.CUST_REL_CATEGORY = '01' ";
	 	result = stmt.executeQuery(sql);
	 	
	 	List<DeliveryModifyBean> list = new ArrayList<> ();
	 	
	 	//�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ1�ｿｽ�ｿｽ�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽ�ｿｽ�ｿｽBean�ｿｽﾉセ�ｿｽb�ｿｽg�ｿｽ�ｿｽ�ｿｽﾄ�ｿｽ�ｿｽX�ｿｽg�ｿｽﾉ追会ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ
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

	//�ｿｽw�ｿｽ閧ｳ�ｿｽ黷ｽ�ｿｽﾚ客�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽ�ｿｽ�ｿｽﾉ撰ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ
	public DeliveryModifyBean getDelivery2(String customerCode) throws SQLException, ClassNotFoundException {

		Connection con;
		Statement stmt= null;
	 	ResultSet result=null;	
	 	String  sql;
	 	
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	//�ｿｽw�ｿｽ閧ｳ�ｿｽ黷ｽ�ｿｽﾚ客�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽ�ｿｽ�ｿｽﾉ、�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ (�ｿｽﾖ連�ｿｽJ�ｿｽe�ｿｽS�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ02(�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ)�ｿｽﾉゑｿｽ�ｿｽﾄゑｿｽ�ｿｽ�ｿｽ)SQL�ｿｽ�ｿｽ
	 	sql = "SELECT * FROM customer_rel_xxxxx RIGHT OUTER JOIN delivery_mst_xxxxx "
	 			+ "ON customer_rel_xxxxx.REL_CODE = delivery_mst_xxxxx.DELIVERY_CODE "
	 			+ "AND customer_rel_xxxxx.CUST_REL_CATEGORY = '02' "
	 			+ "WHERE customer_rel_xxxxx.CUSTOMER_CODE = " + customerCode;
	 	result = stmt.executeQuery(sql);
	 	
	 	DeliveryModifyBean bean = new DeliveryModifyBean();
	 	
	 	//�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽBean�ｿｽﾉセ�ｿｽb�ｿｽg�ｿｽ�ｿｽ�ｿｽ�ｿｽ
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
	
	//�ｿｽﾚ客�ｿｽ�ｿｽﾇ会ｿｽ�ｿｽ�ｿｽ�ｿｽ驛�ｿｽ\�ｿｽb�ｿｽh
	public int addCustomer(CustomerAddBean bean) throws SQLException, ClassNotFoundException {

		Connection con;
		PreparedStatement pstmt= null;
	 	int result=0;	
	 	String  sql;
	 	
	 	//bean�ｿｽ�ｿｽ�ｿｽ�ｿｽﾇ会ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾚ客�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ
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
		
		LocalDateTime ldt           = LocalDateTime.now();
		String creDate              = ldt.toString();
	 	
	 	
	 	con = super.getConnection();
	 	//�ｿｽﾚ客�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾚ客�ｿｽ}�ｿｽX�ｿｽ^�ｿｽﾉ追会ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽSQL�ｿｽ�ｿｽ
	 	sql = "insert into customer_mst_xxxxx(CUSTOMER_CODE ,"
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
	 										+ "TAX_FRACT_CATEGORY ,"
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
	 										+ "COMMENT_DATA ,"
	 										+ "CRE_DATETM)"
	 										+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	 	pstmt = con.prepareStatement(sql);
	 	
	 	pstmt.setString(1, customerCode);
	 	
	 	if(customerName==null) {
	 		pstmt.setNull(2, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(2, customerName);
	 	}
	 	
	 	if(customerKana==null) {
	 		pstmt.setNull(3, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(3, customerKana);
	 	}
	 	
	 	if(officeName==null) {
	 		pstmt.setNull(4, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(4, officeName);
	 	}
	 	
	 	if(officeNameKana==null) {
	 		pstmt.setNull(5, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(5, officeNameKana);
	 	}
	 	
	 	if(customerAbbr==null) {
	 		pstmt.setNull(6, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(6, customerAbbr);
	 	}
	 	
	 	if(zipCode==null) {
	 		pstmt.setNull(7, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(7, zipCode);
	 	}
	 	
	 	if(zipAddress1==null) {
	 		pstmt.setNull(8, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(8, zipAddress1);
	 	}
	 	
	 	if(zipAddress2==null) {
	 		pstmt.setNull(9, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(9, zipAddress2);
	 	}
	 	
	 	if(PCName==null) {
	 		pstmt.setNull(10, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(10, PCName);
	 	}
	 	
	 	if(PCNameKana==null) {
	 		pstmt.setNull(11, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(11, PCNameKana);
	 	}
	 	
	 	if(PCPreCategory==null) {
	 		pstmt.setNull(12, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(12, PCPreCategory);
	 	}
	 	
	 	if(deptName==null) {
	 		pstmt.setNull(13, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(13, deptName);
	 	}
	 	
	 	
	 	if(PCPost==null) {
	 		pstmt.setNull(14, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(14, PCPost);
	 	}
	 	
	 	if(tel==null) {
	 		pstmt.setNull(15, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(15, tel);
	 	}
	 	
	 	if(fax==null) {
	 		pstmt.setNull(16, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(16, fax);
	 	}
	 	
	 	if(email==null) {
	 		pstmt.setNull(17, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(17, email);
	 	}
	 	
	 	if(rankCategory==null) {
	 		pstmt.setNull(18, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(18, rankCategory);
	 	}
	 	
	 	if(updateFlag==null) {
	 		pstmt.setNull(19, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(19, updateFlag);
	 	}
	 	
	 	if(ROCategory==null) {
	 		pstmt.setNull(20, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(20, ROCategory);
	 	}
	 	
	 	if(maxCreditLimit==0) {
	 		pstmt.setNull(21, Types.INTEGER);
	 	} else {
	 		pstmt.setInt(21, maxCreditLimit);
	 	}
	 	
	 	if(businessCategory==null) {
	 		pstmt.setNull(22, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(22, businessCategory);
	 	}
	 	
	 	if(jobCategory==null) {
	 		pstmt.setNull(23, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(23, jobCategory);
	 	}
	 	
	 	if(fractCategory==null) {
	 		pstmt.setNull(24, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(24, fractCategory);
	 	}
	 	
	 	if(shiftCategory==null) {
	 		pstmt.setNull(25, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(25, shiftCategory);
	 	}
	 	
	 	if(lastCutoffDate==null) {
	 		pstmt.setNull(26, Types.DATE);
	 	} else {
	 		pstmt.setNull(26, Types.DATE);
	 	}
	 	
	 	if(salesCMCategory==null) {
	 		pstmt.setNull(27, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(27, salesCMCategory);
	 	}
	 	
	 	if(cutoffGroup==null) {
	 		pstmt.setNull(28, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(28, cutoffGroup);
	 	}
	 	
	 	if(paybackTypeCategory==null) {
	 		pstmt.setNull(29, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(29, paybackTypeCategory);
	 	}
	 	
	 	if(billPrintUnit==null) {
	 		pstmt.setNull(30, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(30, billPrintUnit);
	 	}
	 	
	 	if(billDatePrint==null) {
	 		pstmt.setNull(31, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(31, billDatePrint);
	 	}
	 	
	 	if(tempDeliverySlipFlag==null) {
	 		pstmt.setNull(32, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(32, tempDeliverySlipFlag);
	 	}
	 	
	 	if(paymentName==null) {
	 		pstmt.setNull(33, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(33, paymentName);
	 	}
	 	
	 	if(remarks==null) {
	 		pstmt.setNull(34, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(34, remarks);
	 	}
	 	
	 	if(comment==null) {
	 		pstmt.setNull(35, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(35, comment);
	 	}
	 	
	 	if(creDate==null) {
	 		pstmt.setNull(36, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(36, creDate);
	 	}
	 	
	 	try {
	 		result = pstmt.executeUpdate();
	 		con.commit();
	 	} catch (SQLException e) {
	 		result = 999;
	 		e.printStackTrace();
	 	} finally {
	 		super.releaseDB(con,pstmt);
	 	}
	 	
	 	return result;

	}
	
	//�ｿｽ�ｿｽ�ｿｽﾝの納�ｿｽ�ｿｽ�ｿｽ�ｿｽR�ｿｽ[�ｿｽh�ｿｽﾌ最托ｿｽl+1�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ驛�ｿｽ\�ｿｽb�ｿｽh
	public String getMaxDeliveryCode() throws SQLException, ClassNotFoundException {

		Connection con;
		Statement stmt= null;
	 	ResultSet result=null;
	 	String  sql;
	 	String delCode=null;
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	//�ｿｽ�ｿｽ�ｿｽﾝの納�ｿｽ�ｿｽ�ｿｽ�ｿｽR�ｿｽ[�ｿｽh�ｿｽﾌ最托ｿｽl�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽSQL�ｿｽ�ｿｽ
	 	sql = "SELECT DELIVERY_CODE from delivery_mst_XXXXX where DELIVERY_CODE = "
	 			+ "(select max(DELIVERY_CODE) from delivery_mst_XXXXX)";
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	while(result.next()){
	 		delCode = result.getString("DELIVERY_CODE");
	 	}
	 	
	 	super.releaseDB(con,stmt,result);
	 	
	 	int idelCode = Integer.parseInt(delCode);
	 	idelCode = idelCode + 1;
		delCode = Integer.toString(idelCode);
	 	
	 	return delCode;
	}
	
	//�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾇ会ｿｽ�ｿｽ�ｿｽ�ｿｽ驛�ｿｽ\�ｿｽb�ｿｽh
	public int addDelivery(DeliveryAddBean bean) throws SQLException, ClassNotFoundException {

		Connection con;
		PreparedStatement pstmt= null;
	 	int result=0;
	 	String  sql;
	 	
	 	//Bean�ｿｽ�ｿｽ�ｿｽ�ｿｽﾇ会ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ
	 	String address1         = bean.getAddress1();
		String address2         = bean.getAddress2();
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
		
		String deliveryCode     = bean.getDeliveryCode();
		
		LocalDateTime ldt           = LocalDateTime.now();
		String creDate              = ldt.toString();
		
	 	
	 	con = super.getConnection();
	 	//�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽe�ｿｽ[�ｿｽu�ｿｽ�ｿｽ�ｿｽﾉ追会ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽSQL�ｿｽ�ｿｽ
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
	 										+ "DELIVERY_ZIP_CODE ,"
	 										+ "CRE_DATETM ,"
	 										+ "DELIVERY_CODE)"
	 										+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,?)";
	 	
	 	pstmt = con.prepareStatement(sql);
	 	
	 	if(address1==null) {
	 		pstmt.setNull(1, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(1, address1);
	 	}
	 	
	 	if(address2==null) {
	 		pstmt.setNull(2, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(2, address2);
	 	}
	 	
	 	if(deliveryKana==null) {
	 		pstmt.setNull(3, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(3, deliveryKana);
	 	}
	 	
	 	if(deliveryName==null) {
	 		pstmt.setNull(4, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(4, deliveryName);
	 	}
	 	
	 	if(deptName==null) {
	 		pstmt.setNull(5, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(5, deptName);
	 	}
	 	
	 	if(email==null) {
	 		pstmt.setNull(6, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(6, email);
	 	}
	 	
	 	if(fax==null) {
	 		pstmt.setNull(7, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(7, fax);
	 	}
	 	
	 	if(officeKana==null) {
	 		pstmt.setNull(8, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(8, officeKana);
	 	}
	 	
	 	if(officeName==null) {
	 		pstmt.setNull(9, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(9, officeName);
	 	}

	 	if(PCKana==null) {
	 		pstmt.setNull(10, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(10, PCKana);
	 	}
	 	
	 	if(PCName==null) {
	 		pstmt.setNull(11, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(11, PCName);
	 		
	 	}if(PCPreCategory==null) {
	 		pstmt.setNull(12, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(12, PCPreCategory);
	 	}
	 	
	 	if(tel==null) {
	 		pstmt.setNull(13, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(13, tel);
	 	}
	 	
	 	if(zipCode==null) {
	 		pstmt.setNull(14, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(14, zipCode);
	 	}
	 	
	 	if(creDate==null) {
	 		pstmt.setNull(15, Types.VARCHAR);
	 	} else {
	 		pstmt.setString(15, creDate);
	 	}
	 	
	 	pstmt.setString(16, deliveryCode);
	 	
	 	try {
	 		result = pstmt.executeUpdate();
	 		con.commit();
	 	} catch (SQLException e) {
	 		result = 999;
	 		e.printStackTrace();
	 	} finally {
	 		super.releaseDB(con,pstmt);
	 	}
	 	
	 	return result;
	}
	 
	//(�ｿｽo�ｿｽ^�ｿｽ�ｿｽ�ｿｽ�ｿｽ)�ｿｽﾅ新�ｿｽﾌ納�ｿｽ�ｿｽ�ｿｽ�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ
	/*public String getAddDeliveryCode() throws SQLException, ClassNotFoundException {
		
		Connection con;
		Statement stmt= null;
	 	ResultSet result=null;
	 	String  sql;
	 	String delCode=null;
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	//(�ｿｽo�ｿｽ^�ｿｽ�ｿｽ�ｿｽ�ｿｽ)�ｿｽﾅ新�ｿｽﾌ納�ｿｽ�ｿｽ�ｿｽ�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽSQL�ｿｽ�ｿｽ
	 	sql = "SELECT DELIVERY_CODE from delivery_mst_XXXXX where CRE_DATETM = "
	 			+ "(select max(CRE_DATETM) from delivery_mst_XXXXX)";
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	while(result.next()){
	 		delCode = result.getString("DELIVERY_CODE");
	 	}
	 	
	 	super.releaseDB(con,stmt,result);
	 	
	 	return delCode;
	}*/
	
	//�ｿｽﾖ連�ｿｽ}�ｿｽX�ｿｽ^�ｿｽe�ｿｽ[�ｿｽu�ｿｽ�ｿｽ�ｿｽ�ｿｽ(�ｿｽﾚ客�ｿｽR�ｿｽ[�ｿｽh�ｿｽA�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ(�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ)�ｿｽR�ｿｽ[�ｿｽh�ｿｽA�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ/�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽt�ｿｽ�ｿｽ�ｿｽO)�ｿｽ�ｿｽﾇ会ｿｽ�ｿｽ�ｿｽ�ｿｽ驛�ｿｽ\�ｿｽb�ｿｽh
	public int setRelation(String customerCode, String delCode, String relCategory) throws SQLException, ClassNotFoundException {
		
		
		Connection con;
		PreparedStatement pstmt= null;
	 	int result=0;
	 	String sql;
		
	 	con = super.getConnection();
	 	//�ｿｽﾖ連�ｿｽ}�ｿｽX�ｿｽ^�ｿｽe�ｿｽ[�ｿｽu�ｿｽ�ｿｽ�ｿｽ�ｿｽ(�ｿｽﾚ客�ｿｽR�ｿｽ[�ｿｽh�ｿｽA�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ(�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ)�ｿｽR�ｿｽ[�ｿｽh�ｿｽA�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ/�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽt�ｿｽ�ｿｽ�ｿｽO)�ｿｽ�ｿｽﾇ会ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽSQL�ｿｽ�ｿｽ
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
	 		result = 999;
	 		e.printStackTrace();
	 	} finally {
	 		super.releaseDB(con,pstmt);
	 	}
	 	
	 	return result;
	}
	
	//�ｿｽﾚ客�ｿｽ�ｿｽ�ｿｽ�ｿｽﾒ集�ｿｽ�ｿｽ�ｿｽ驛�ｿｽ\�ｿｽb�ｿｽh
	public int modifyCustomer(CustomerModifyBean bean) throws SQLException, ClassNotFoundException {
		
		Connection con;
		Statement stmt= null;
	 	int result=0;	
	 	String  sql;
	 	
	 	//�ｿｽﾒ集�ｿｽ�ｿｽ�ｿｽ�ｿｽﾚ客�ｿｽ�ｿｽ�ｿｽ�ｿｽbean�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ
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
		
		LocalDateTime ldt           = LocalDateTime.now();
		String updDate              = ldt.toString();
		String updDateSQL           = "'" + updDate + "'";
	 	
		String customerCodeSQL = "'" + customerCode + "'";
		
		String customerNameSQL;
		String customerKanaSQL;
		String officeNameSQL;
		String officeNameKanaSQL;
	 	String customerAbbrSQL;
	 	String zipCodeSQL;
	 	String zipAddress1SQL;
	 	String zipAddress2SQL;
		String PCNameSQL;
		String PCNameKanaSQL;
		String PCPreCategorySQL;
		String deptNameSQL;
		String PCPostSQL;
		String telSQL;
		String faxSQL;
		String emailSQL;
		String rankCategorySQL;
		String updateFlagSQL;
		String ROCategorySQL;
		int maxCreditLimitSQL;
		String businessCategorySQL;
		String jobCategorySQL;
		String fractCategorySQL;
		String shiftCategorySQL;
		String lastCutoffDateSQL;
		String salesCMCategorySQL;
		String cutoffGroupSQL;
		String paybackTypeCategorySQL;
		String billPrintUnitSQL;
		String billDatePrintSQL;
		String tempDeliverySlipFlagSQL;
		String paymentNameSQL;
		String remarksSQL;
		String commentSQL;
		
		if(customerName==null || customerName.equals("")) {
			customerNameSQL = null;
		} else {
			customerNameSQL = "'" + customerName + "'";
		}
		
		if(customerKana==null || customerKana.equals("")) {
			customerKanaSQL = null;
		} else {
			customerKanaSQL = "'" + customerKana + "'";
		}
	 	
		if(officeName==null || officeName.equals("")) {
			officeNameSQL = null;
		} else {
			officeNameSQL = "'" + officeName + "'";
		}
		
		if(officeNameKana==null || officeNameKana.equals("")) {
			officeNameKanaSQL = null;
		} else {
			officeNameKanaSQL = "'" + officeNameKana + "'";
		}
		
		if(customerAbbr==null || customerAbbr.equals("")) {
			customerAbbrSQL = null;
		} else {
			customerAbbrSQL = "'" + customerAbbr + "'";
		}
		
		if(zipCode==null || zipCode.equals("")) {
			zipCodeSQL = null;
		} else {
			zipCodeSQL = "'" + zipCode + "'";
		}

		if(zipAddress1==null || zipAddress1.equals("")) {
			zipAddress1SQL = null;
		} else {
			zipAddress1SQL = "'" + zipAddress1 + "'";
		}
		
		if(zipAddress2==null || zipAddress2.equals("")) {
			zipAddress2SQL = null;
		} else {
			zipAddress2SQL = "'" + zipAddress2 + "'";
		}
		
		if(PCName==null || PCName.equals("")) {
			PCNameSQL = null;
		} else {
			PCNameSQL = "'" + PCName + "'";
		}
		
		if(PCNameKana==null || PCNameKana.equals("")) {
			PCNameKanaSQL = null;
		} else {
			PCNameKanaSQL = "'" + PCNameKana + "'";
		}
	 	
		if(PCPreCategory==null || PCPreCategory.equals("")) {
			PCPreCategorySQL = null;
		} else {
			PCPreCategorySQL = "'" + PCPreCategory + "'";
		}
		
		if(deptName==null || deptName.equals("")) {
			deptNameSQL = null;
		} else {
			deptNameSQL = "'" + deptName + "'";
		}
		
		if(PCPost==null || PCPost.equals("")) {
			PCPostSQL = null;
		} else {
			PCPostSQL = "'" + PCPost + "'";
		}
		
		if(tel==null || tel.equals("")) {
			telSQL = null;
		} else {
			telSQL = "'" + tel + "'";
		}

		if(fax==null || fax.equals("")) {
			faxSQL = null;
		} else {
			faxSQL = "'" + fax + "'";
		}
		
		if(email==null || email.equals("")) {
			emailSQL = null;
		} else {
			emailSQL = "'" + email + "'";
		}
		
		if(rankCategory==null || rankCategory.equals("")) {
			rankCategorySQL = null;
		} else {
			rankCategorySQL = "'" + rankCategory + "'";
		}
		
		if(updateFlag==null || updateFlag.equals("")) {
			updateFlagSQL = null;
		} else {
			updateFlagSQL = "'" + updateFlag + "'";
		}
	 	
		if(ROCategory==null || ROCategory.equals("")) {
			ROCategorySQL = null;
		} else {
			ROCategorySQL = "'" + ROCategory + "'";
		}
		
		if(maxCreditLimit==0) {
			maxCreditLimitSQL = 0;
		} else {
			maxCreditLimitSQL = maxCreditLimit;
		}
		
		if(businessCategory==null || businessCategory.equals("")) {
			businessCategorySQL = null;
		} else {
			businessCategorySQL = "'" + businessCategory + "'";
		}
		
		if(jobCategory==null || jobCategory.equals("")) {
			jobCategorySQL = null;
		} else {
			jobCategorySQL = "'" + jobCategory + "'";
		}

		if(fractCategory==null || fractCategory.equals("")) {
			fractCategorySQL = null;
		} else {
			fractCategorySQL = "'" + fractCategory + "'";
		}
		
		if(shiftCategory==null || shiftCategory.equals("")) {
			shiftCategorySQL = null;
		} else {
			shiftCategorySQL = "'" + shiftCategory + "'";
		}
		
		if(lastCutoffDate==null || lastCutoffDate.equals("")) {
			lastCutoffDateSQL = null;
		} else {
			lastCutoffDateSQL = "'" + lastCutoffDate + "'";
		}
		
		if(salesCMCategory==null || salesCMCategory.equals("")) {
			salesCMCategorySQL = null;
		} else {
			salesCMCategorySQL = "'" + salesCMCategory + "'";
		}
	 	
		if(cutoffGroup==null || cutoffGroup.equals("")) {
			cutoffGroupSQL = null;
		} else {
			cutoffGroupSQL = "'" + cutoffGroup + "'";
		}
		
		if(paybackTypeCategory==null || paybackTypeCategory.equals("")) {
			paybackTypeCategorySQL = null;
		} else {
			paybackTypeCategorySQL = "'" + paybackTypeCategory + "'";
		}
		
		if(billPrintUnit==null || billPrintUnit.equals("")) {
			billPrintUnitSQL = null;
		} else {
			billPrintUnitSQL = "'" + billPrintUnit + "'";
		}
		
		if(billDatePrint==null || billDatePrint.equals("")) {
			billDatePrintSQL = null;
		} else {
			billDatePrintSQL = "'" + billDatePrint + "'";
		}

		if(tempDeliverySlipFlag==null || tempDeliverySlipFlag.equals("")) {
			tempDeliverySlipFlagSQL = null;
		} else {
			tempDeliverySlipFlagSQL = "'" + tempDeliverySlipFlag + "'";
		}
		
		if(paymentName==null || paymentName.equals("")) {
			paymentNameSQL = null;
		} else {
			paymentNameSQL = "'" + paymentName + "'";
		}
		
		if(remarks==null || remarks.equals("")) {
			remarksSQL = null;
		} else {
			remarksSQL = "'" + remarks + "'";
		}

		if(comment==null || comment.equals("")) {
			commentSQL = null;
		} else {
			commentSQL = "'" + comment + "'";
		}
		
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	//�ｿｽﾚ客�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽX�ｿｽV�ｿｽ�ｿｽ�ｿｽ�ｿｽSQL�ｿｽ�ｿｽ
	 	sql = "UPDATE customer_mst_xxxxx SET " +
	 			"CUSTOMER_NAME = " + customerNameSQL +
	 			", CUSTOMER_KANA = " + customerKanaSQL +
	 			", CUSTOMER_OFFICE_NAME = " + officeNameSQL +
	 			", CUSTOMER_OFFICE_KANA = " + officeNameKanaSQL +
	 			", CUSTOMER_ABBR = " + customerAbbrSQL +
	 			", CUSTOMER_ZIP_CODE = " + zipCodeSQL +
	 			", CUSTOMER_ADDRESS_1 = " + zipAddress1SQL +
	 			", CUSTOMER_ADDRESS_2 = " + zipAddress2SQL +
	 			", CUSTOMER_PC_NAME = " + PCNameSQL +
	 			", CUSTOMER_PC_KANA = " + PCNameKanaSQL +
	 			", CUSTOMER_PC_PRE_CATEGORY = " + PCPreCategorySQL +
	 			", CUSTOMER_DEPT_NAME = " + deptNameSQL +
	 			", CUSTOMER_PC_POST = " + PCPostSQL +
	 			", CUSTOMER_TEL = " + telSQL +
	 			", CUSTOMER_FAX = " + faxSQL + 
	 			", CUSTOMER_EMAIL = " + emailSQL +
	 			", CUSTOMER_RANK_CATEGORY = " + rankCategorySQL +
	 			", CUSTOMER_UPD_FLAG = " + updateFlagSQL +
	 			", CUSTOMER_RO_CATEGORY = " + ROCategorySQL +
	 			", MAX_CREDIT_LIMIT = " + maxCreditLimitSQL +
	 			", CUSTOMER_BUSINESS_CATEGORY = " + businessCategorySQL +
	 			", CUSTOMER_JOB_CATEGORY = " + jobCategorySQL +
	 			", TAX_FRACT_CATEGORY = " + fractCategorySQL +
	 			", TAX_SHIFT_CATEGORY = " + shiftCategorySQL +
	 			", LAST_CUTOFF_DATE = " + lastCutoffDateSQL +
	 			", SALES_CM_CATEGORY = " + salesCMCategorySQL +
	 			", CUTOFF_GROUP = " + cutoffGroupSQL +
	 			", PAYBACK_TYPE_CATEGORY = " + paybackTypeCategorySQL +
	 			", BILL_PRINT_UNIT = " + billPrintUnitSQL +
	 			", BILL_DATE_PRINT = " + billDatePrintSQL +
	 			", TEMP_DELIVERY_SLIP_FLAG = " + tempDeliverySlipFlagSQL +
	 			", PAYMENT_NAME = " + paymentNameSQL +
	 			", REMARKS = " + remarksSQL +
	 			", COMMENT_DATA = " + commentSQL +
	 			", UPD_DATETM = " + updDateSQL + 
	 			" WHERE CUSTOMER_CODE = " + customerCodeSQL;
	 			
	 	try {
	 		result = stmt.executeUpdate(sql);
	 		con.commit();
	 	} catch (SQLException e) {
	 		result = 999;
	 		e.printStackTrace();
	 	} finally {
	 		super.releaseDB(con,stmt);
	 	}
	 	
	 	return result;
		
	}
	
	//�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ(�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ)�ｿｽ�ｿｽﾒ集�ｿｽ�ｿｽ�ｿｽ驛�ｿｽ\�ｿｽb�ｿｽh
	public int modifyDelivery(DeliveryModifyBean bean) throws SQLException, ClassNotFoundException {

		Connection con;
		Statement stmt= null;
	 	int result=0;
	 	String  sql;
	 	
	 	//�ｿｽﾒ集�ｿｽ�ｿｽ�ｿｽ�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ(�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ)�ｿｽ�ｿｽ�ｿｽ�ｿｽbean�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ
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
		
		LocalDateTime ldt           = LocalDateTime.now();
		String updDate              = ldt.toString();
		String updDateSQL           = "'" + updDate + "'";
		
		String deliveryCodeSQL = "'" + deliveryCode + "'";
		
	 	String address1SQL;
		String address2SQL;
		String deliveryKanaSQL;
		String deliveryNameSQL;
	 	String deptNameSQL;
	 	String emailSQL;
	 	String faxSQL;
	 	String officeKanaSQL;
		String officeNameSQL;
		String PCKanaSQL;
		String PCNameSQL;
		String PCPreCategorySQL;
		String telSQL;
		String zipCodeSQL;
		
		
		if(address1==null || address1.equals("")) {
			address1SQL = null;
		} else {
			address1SQL = "'" + address1 + "'";
		}
		
		if(address2==null || address2.equals("")) {
			address2SQL = null;
		} else {
			address2SQL = "'" + address2 + "'";
		}
		
		
		if(deliveryKana==null || deliveryKana.equals("")) {
			deliveryKanaSQL = null;
		} else {
			deliveryKanaSQL = "'" + deliveryKana + "'";
		}
		
		if(deliveryName==null || deliveryName.equals("")) {
			deliveryNameSQL = null;
		} else {
			deliveryNameSQL = "'" + deliveryName + "'";
		}
		
		if(deptName==null || deptName.equals("")) {
			deptNameSQL = null;
		} else {
			deptNameSQL = "'" + deptName + "'";
		}
		
		if(email==null || email.equals("")) {
			emailSQL = null;
		} else {
			emailSQL = "'" + email + "'";
		}
		
		if(fax==null || fax.equals("")) {
			faxSQL = null;
		} else {
			faxSQL = "'" + fax + "'";
		}
		
		if(officeKana==null || officeKana.equals("")) {
			officeKanaSQL = null;
		} else {
			officeKanaSQL = "'" + officeKana + "'";
		}
		
		if(officeName==null || officeName.equals("")) {
			officeNameSQL = null;
		} else {
			officeNameSQL = "'" + officeName + "'";
		}
		
		if(PCKana==null || PCKana.equals("")) {
			PCKanaSQL = null;
		} else {
			PCKanaSQL = "'" + PCKana + "'";
		}
		
		if(PCName==null || PCName.equals("")) {
			PCNameSQL = null;
		} else {
			PCNameSQL = "'" + PCName + "'";
		}
		
		if(PCName==null ||PCPreCategory.equals("")) {
			PCPreCategorySQL = null;
		} else {
			PCPreCategorySQL = "'" +PCPreCategory + "'";
		}
		
		if(PCName==null ||tel.equals("")) {
			telSQL = null;
		} else {
			telSQL = "'" +tel + "'";
		}
		
		if(PCName==null ||zipCode.equals("")) {
			zipCodeSQL = null;
		} else {
			zipCodeSQL = "'" +zipCode + "'";
		}
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	//�ｿｽ[�ｿｽ�ｿｽ�ｿｽ�ｿｽ(�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ)�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽX�ｿｽV�ｿｽ�ｿｽ�ｿｽ�ｿｽSQL�ｿｽ�ｿｽ
	 	sql = "UPDATE delivery_mst_xxxxx SET " + 
	 			"DELIVERY_ADDRESS_1 = " + address1SQL +
	 			", DELIVERY_ADDRESS_2 = " + address2SQL +
	 			", DELIVERY_KANA = " + deliveryKanaSQL +
	 			", DELIVERY_NAME = " + deliveryNameSQL + 
	 			", DELIVERY_DEPT_NAME = " + deptNameSQL +
	 			", DELIVERY_EMAIL = " + emailSQL +
	 			", DELIVERY_FAX = " + faxSQL +
	 			", DELIVERY_OFFICE_KANA = " + officeKanaSQL +
	 			", DELIVERY_OFFICE_NAME = " + officeNameSQL +
	 			", DELIVERY_PC_KANA = " + PCKanaSQL +
	 			", DELIVERY_PC_NAME = " + PCNameSQL +
	 			", DELIVERY_PC_PRE_CATEGORY = " + PCPreCategorySQL +
	 			", DELIVERY_TEL = " + telSQL +
	 			", DELIVERY_ZIP_CODE = " + zipCodeSQL +
	 			", UPD_DATETM = " + updDateSQL +
	 			" WHERE DELIVERY_CODE = " + deliveryCodeSQL;
	 			
	 	try {
	 		result = stmt.executeUpdate(sql);
	 		con.commit();
	 	} catch (SQLException e) {
	 		result = 999;
	 		e.printStackTrace();
	 	} finally {
	 		super.releaseDB(con,stmt);
	 	}
	 	
	 	return result;
	}
	
	
	//�ｿｽﾖ連�ｿｽ}�ｿｽX�ｿｽ^�ｿｽe�ｿｽ[�ｿｽu�ｿｽ�ｿｽ�ｿｽ�ｿｽﾒ集�ｿｽ�ｿｽ�ｿｽ驛�ｿｽ\�ｿｽb�ｿｽh
	public int modifyRelation(String customerCode, String delCode, String relCategory) throws SQLException, ClassNotFoundException {
		
		
		Connection con;
		Statement stmt= null;
	 	int result=0;
	 	String sql;
		
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	//�ｿｽﾖ連�ｿｽ}�ｿｽX�ｿｽ^�ｿｽe�ｿｽ[�ｿｽu�ｿｽ�ｿｽ�ｿｽ�ｿｽﾒ集�ｿｽ�ｿｽ�ｿｽ�ｿｽSQL�ｿｽ�ｿｽ
	 	sql = "UPDATE customer_rel_xxxxx " +
	 			"REL_CODE = " + delCode +
	 			"CUST_REL_CATEGORY = " + relCategory +
	 			"WHERE CUSTOMER_CODE = " + customerCode;	 	
	 	
	 	try {
	 		result = stmt.executeUpdate(sql);
	 		con.commit();
	 	} catch (SQLException e) {
	 		result = 999;
	 		e.printStackTrace();
	 	} finally {
	 		super.releaseDB(con,stmt);
	 	}
	 	
	 	return result;
	}
	
	//�ｿｽﾚ客�ｿｽ尞懶ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ驛�ｿｽ\�ｿｽb�ｿｽh
	public int deleteCustomer(String customerCode) throws SQLException, ClassNotFoundException {

		Connection con;
		Statement stmt= null;
	 	int result=0;
	 	String  sql;
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	//�ｿｽﾚ客�ｿｽ尞懶ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽSQL�ｿｽ�ｿｽ
	 	sql = "DELETE FROM customer_mst_xxxxx WHERE CUSTOMER_CODE = " + customerCode;	 	
	 	
	 	try {
	 		result = stmt.executeUpdate(sql);
	 		con.commit();
	 	} catch (SQLException e) {
	 		result = 999;
	 		e.printStackTrace();
	 	} finally {
	 		super.releaseDB(con,stmt);
	 	}
	 	
	 	return result;
	}
	
	//�ｿｽX�ｿｽﾖ番搾ｿｽ�ｿｽy�ｿｽﾑ住�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ驛�ｿｽ\�ｿｽb�ｿｽh
	public List<AddressBean> searchAddress(AddressBean bean) throws SQLException, ClassNotFoundException {
		
		List<AddressBean> list = new ArrayList<> ();
		Connection con;
		Statement stmt= null;
	 	ResultSet result=null;	
	 	String  sql;
	 	
	 	//�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾌ郵�ｿｽﾖ番搾ｿｽ�ｿｽy�ｿｽﾑ住�ｿｽ�ｿｽ�ｿｽ�ｿｽbean�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ
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
	 	//�ｿｽw�ｿｽ閧ｳ�ｿｽ黷ｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾌ住�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ
	 	sql = "SELECT * FROM ZIP_MST_XXXXX where ( ZIP_CODE " + zipCodeSQL +
	 			" ) AND ( ZIP_ADDRESS_1 " + address1_SQL + " )"; 
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	AddressBean bean2 = new AddressBean();
	 	
	 	//�ｿｽ謫ｾ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽZ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ1�ｿｽ�ｿｽ�ｿｽR�ｿｽ[�ｿｽh�ｿｽ�ｿｽ�ｿｽ�ｿｽbean�ｿｽﾉセ�ｿｽb�ｿｽg�ｿｽ�ｿｽ�ｿｽA�ｿｽ�ｿｽ�ｿｽX�ｿｽg�ｿｽﾉ追会ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ
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
