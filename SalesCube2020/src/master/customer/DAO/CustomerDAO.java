package master.customer.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import common.dao.BaseDAO;
import master.customer.beans.CustomerAddBean;
import master.customer.beans.CustomerModifyBean;
import master.customer.beans.customerSearchBeans.CustomerInputBean;
import master.customer.beans.customerSearchBeans.CustomerResultBean;
import user.beans.*;

public class CustomerDAO extends BaseDAO {

	
	public List<CustomerResultBean> searchCustomer(CustomerInputBean bean, int count, int currentPage) throws SQLException, ClassNotFoundException {
		
		List<CustomerResultBean> list = new ArrayList<> ();
		Connection con;
	 	PreparedStatement pstmt=null;
	 	ResultSet result=null;	
	 	String  sql;
	 	
	 	String customerCode      = bean.getCustomerCode();
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
	 	
	 	
	 	if(customerCode == null || customerCode == "") {
	 		customerCodeSQL = "LIKE '%'";
	 	} else {
	 		customerCodeSQL = "LIKE '" + customerCode + "%'";
	 	}
	 	
	 	if(customerName == null || customerName == "") {
	 		customerNameSQL = "LIKE '%' OR CUSTOMER_NAME IS NULL";
	 	} else {
	 		customerNameSQL = "LIKE '" + customerName + "%'";
	 	}
	 	
	 	if(customerKana == null || customerKana == "") {
	 		customerKanaSQL = "LIKE '%' OR CUSTOMER_KANA IS NULL";
	 	} else {
	 		customerKanaSQL = "LIKE '" + customerKana + "%'";
	 	}
	 	
	 	if(officeName == null || officeName == "") {
	 		officeNameSQL = "LIKE '%' OR CUSTOMER_OFFICE_NAME IS NULL";
	 	} else {
	 		officeNameSQL = "LIKE '" + officeName + "%'";
	 	}
	 	
	 	if(officeNameKana == null || officeNameKana == "") {
	 		officeNameKanaSQL = "LIKE '%' OR CUSTOMER_OFFICE_KANA IS NULL";
	 	} else {
	 		officeNameKanaSQL = "LIKE '" + officeNameKana + "%'";
	 	}
	 	
	 	if(tel == null || tel == "") {
	 		telSQL = "LIKE '%' OR CUSTOMER_TEL IS NULL";
	 	} else {
	 		telSQL = "LIKE '" + tel + "%'";
	 	}
	 	
	 	if(PCName == null || PCName == "") {
	 		PCNameSQL = "LIKE '%' OR CUSTOMER_PC_NAME IS NULL";
	 	} else {
	 		PCNameSQL = "LIKE '" + PCName + "%'";
	 	}
	 	
	 	if(PCNameKana == null || PCNameKana == "") {
	 		PCNameKanaSQL = "LIKE '%' OR CUSTOMER_PC_KANA IS NULL";
	 	} else {
	 		PCNameKanaSQL = "LIKE '" + PCNameKana + "%'";
	 	}
	 	
	 	if(fax == null || fax == "") {
	 		faxSQL = "LIKE '%' OR CUSTOMER_FAX IS NULL";
	 	} else {
	 		faxSQL = "LIKE '" + fax + "%'";
	 	}
	 	
	 	if(rankCategory == null || rankCategory == "") {
	 		rankCategorySQL = "LIKE '%' OR CUSTOMER_RANK_CATEGORY IS NULL";
	 	} else {
	 		rankCategorySQL = "LIKE '" + rankCategory + "%'";
	 	}
	 	
	 	if(cutoffGroup == null || cutoffGroup == "") {
	 		cutoffGroupSQL = "LIKE '%' OR CUTOFF_GROUP IS NULL";
	 	} else {
	 		cutoffGroupSQL = "LIKE '" + cutoffGroup + "%'";
	 	}
	 	
	 	if(paymentName == null || paymentName == "") {
	 		paymentNameSQL = "LIKE '%' OR PAYMENT_NAME IS NULL";
	 	} else {
	 		paymentNameSQL = "LIKE '" + paymentName + "%'";
	 	}
	 	
	 	if(remarks == null || remarks == "") {
	 		remarksSQL = "LIKE '%' OR REMARKS IS NULL";
	 	} else {
	 		remarksSQL = "LIKE '" + remarks + "%'";
	 	}
	 	

	 	con = super.getConnection();
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
	 										" ) and ( REMARKS " + remarksSQL + " ) " +
	 										"LIMIT " + count + " OFFSET " + count*(currentPage-1);;

	 	pstmt = con.prepareStatement(sql);

	 	result = pstmt.executeQuery(sql);

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


	public CustomerModifyBean getCustomer(String customerCode) throws SQLException, ClassNotFoundException {

		Connection con;
		Statement stmt= null;
	 	ResultSet result=null;	
	 	String  sql;
	 	
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	sql = "select * from customer_mst_xxxxx where CUSTOMER_CODE = " + customerCode;
	 	result = stmt.executeQuery(sql);
	 	
	 	CustomerModifyBean bean = new CustomerModifyBean();
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
	 	bean.setMaxCreditLimit(result.getBigDecimal("MAX_CREDIT_LIMIT"));
	 	bean.setOfficeName(result.getString("CUSTOMER_OFFICE_NAME"));
	 	bean.setOfficeNameKana(result.getString("CUSTOMER_OFFICE_KANA"));
	 	bean.setPaybackTypeCategory(result.getString("PAYBACK_TYPE_CATEGORY"));
	 	bean.setPaymentName(result.getString("PAYMENT_NAME"));
	 	bean.setPCName(result.getString("CUSTOMER_PC_NAME"));
	 	bean.setPCNameKana(result.getString("CUSTOMER_PC_KANA"));
	 	bean.setPCPost(result.getString("CUSTOMER_PC_POST"));
	 	bean.setPCPreCategory(result.getString("CUSTOMER_PC_PRE_CATEGORY"));
	 	bean.setRankCategory(result.getString("CUSTOMER_RANK_CATEGORY"));
	 	bean.setRemarks("REMARKS");
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
	 	
	 	
	 	super.releaseDB(con,stmt,result);
	 	
	 	return bean;
	 	
	}
	
	public int getCount() throws ClassNotFoundException, MissingResourceException, SQLException {
		

		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;
	 	String  sql1;

	 	int count = 0;
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	sql1 = "select COUNT(*) from customer_mst_xxxxx";
	 	result = stmt.executeQuery(sql1);

	 	while(result.next()) {
	 		count = result.getInt("COUNT(*)");
	 	}

	 	
	 	
	 	super.releaseDB(con, stmt);
	 	
	 	return count;
	
	}
	

}
