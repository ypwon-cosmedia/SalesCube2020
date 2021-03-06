package order.common.bill.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.dao.BaseDAO;
import order.common.bill.beans.OrderCommonBillBean;
import sql.order.OrderSQL;

public class OrderCommonBillDAO extends BaseDAO{

	/* 見積検索 */
	public List<OrderCommonBillBean> billSearch(OrderCommonBillBean bean) throws SQLException, ClassNotFoundException {
		
		List<OrderCommonBillBean> list = new ArrayList<OrderCommonBillBean>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;

	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.billSearch(bean);
	 	
	 	result = stmt.executeQuery(sql);
	 	System.out.println(sql);
	 	
	 	while(result.next()) {
	 		OrderCommonBillBean bean2 = new OrderCommonBillBean();
	 		bean2.setEstimateSheetId(result.getString("ESTIMATE_SHEET_ID"));
	 		bean2.setEstimateDate1(result.getString("ESTIMATE_DATE"));
	 		bean2.setSubmitName(result.getString("SUBMIT_NAME"));
	 		bean2.setTitle(result.getString("TITLE"));
	 		list.add(bean2);
	 	}
	 	
	 	super.releaseDB(con, stmt, result);
	 	
	 	return list;
	}
	
	/* 見積番号押下 消費税率反映 */
	public OrderCommonBillBean billToTaxRate(String estimateSheetId) throws SQLException, ClassNotFoundException {
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;

	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.billToTaxRate(estimateSheetId);
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	OrderCommonBillBean bean = new OrderCommonBillBean();
	 	
	 	while(result.next()) {
	 		bean.setCtaxRate(result.getString("estx.CTAX_RATE"));
	 	}
	 	
	 	super.releaseDB(con, stmt, result);
	 	
	 	return bean;
	 	
	}
	
	/* 見積番号押下 顧客情報反映 */
	public OrderCommonBillBean billToCustomer(String estimateSheetId) throws SQLException, ClassNotFoundException {
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;

	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.billToCustomer(estimateSheetId);
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	OrderCommonBillBean bean = new OrderCommonBillBean();
	 	
	 	while(result.next()) {
	 		bean.setCustomerCode(result.getString("estx.CUSTOMER_CODE"));
		 	bean.setCustomerName(result.getString("cmx.CUSTOMER_NAME"));
		 	bean.setTaxShiftCategory(result.getString("a.CATEGORY_CODE_NAME"));
		 	bean.setCutoffGroup(result.getString("b.CATEGORY_CODE_NAME"));
		 	bean.setSalesCmCategory(result.getString("c.CATEGORY_CODE_NAME"));
		 	bean.setCustomerRemarks(result.getString("estx.CUSTOMER_REMARKS"));
		 	bean.setCustomerCommentData(result.getString("estx.CUSTOMER_COMMENT_DATA"));
	 	}
	 	
	 	super.releaseDB(con, stmt, result);
	 	
	 	return bean;
	 	
	}
	
	/* 見積番号押下 顧客コード反映 */
	public int billToCustomerCode(String estimateSheetId) throws SQLException, ClassNotFoundException {
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;

	 	con = super.getConnection();
	 	stmt = con.createStatement();

	 	sql = "SELECT DISTINCT " +
	 			"estx.CUSTOMER_CODE " +
	 			"FROM " +
	 				"estimate_sheet_trn_xxxxx AS estx " +
	 			"WHERE " +
	 				"estx.ESTIMATE_SHEET_ID = '" + estimateSheetId + "'";
	 	
	 	result = stmt.executeQuery(sql);
	 	System.out.println(sql);
	 	
	 	int num = 0;
	 	
	 	if(result.next()) {
	 		if(result.getString("estx.CUSTOMER_CODE") != null || result.getString("estx.CUSTOMER_CODE") != "") {
	 			num = Integer.parseInt(result.getString("estx.CUSTOMER_CODE"));
	 		}
	 	}
	 	
	 	super.releaseDB(con, stmt, result);
	 	
	 	return num;
	 	
	}
	
	/* 見積番号押下 納入先情報反映 */
	public OrderCommonBillBean billToDelivery(String customerCode) throws SQLException, ClassNotFoundException {
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;

	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.billToDelivery(customerCode);
	 	
	 	result = stmt.executeQuery(sql);
	 	OrderCommonBillBean bean = new OrderCommonBillBean();
	 	
	 	while(result.next()) {
		 	bean.setDeliveryOfficeName(result.getString("dmx.DELIVERY_OFFICE_NAME"));
		 	bean.setDeliveryDeptName(result.getString("dmx.DELIVERY_DEPT_NAME"));
		 	bean.setDeliveryZipCode(result.getString("dmx.DELIVERY_ZIP_CODE"));
		 	bean.setDeliveryAddress1(result.getString("dmx.DELIVERY_ADDRESS_1"));
		 	bean.setDeliveryAddress2(result.getString("dmx.DELIVERY_ADDRESS_2"));
		 	bean.setDeliveryPcName(result.getString("dmx.DELIVERY_PC_NAME"));
		 	bean.setDeliveryPcKana(result.getString("dmx.DELIVERY_PC_KANA"));
		 	bean.setDeliveryPcPre(result.getString("a.CATEGORY_CODE_NAME"));
		 	bean.setDeliveryTel(result.getString("dmx.DELIVERY_TEL"));
		 	bean.setDeliveryFax(result.getString("dmx.DELIVERY_FAX"));
		 	bean.setDeliveryEmail(result.getString("dmx.DELIVERY_EMAIL"));
	 	}
	 	
	 	super.releaseDB(con, stmt, result);
	 	
	 	return bean;
	 	
	}
	
	/* 見積番号押下 納入先コード・名反映 */
	public List<OrderCommonBillBean> billToDeliveryCode(String customerCode) throws SQLException, ClassNotFoundException {
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;

	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.billToDelivery(customerCode);
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	List<OrderCommonBillBean> list = new ArrayList<>();
	 	
	 	while(result.next()) {	
	 		OrderCommonBillBean bean = new OrderCommonBillBean();
	 		bean.setDeliveryCode(result.getString("dmx.DELIVERY_CODE"));
		 	bean.setDeliveryName(result.getString("dmx.DELIVERY_NAME"));
	 		list.add(bean);
	 	}
	 	
	 	super.releaseDB(con, stmt, result);
	 	
	 	return list;
	 	
	}
	
}
