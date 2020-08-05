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
	public List<OrderCommonBillBean> billSearch(String estimateSheetId, String estimateDate, String submitName, String title, OrderCommonBillBean bean)
			throws SQLException, ClassNotFoundException {
		
		List<OrderCommonBillBean> list = new ArrayList<OrderCommonBillBean>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;

	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.billSearch(estimateSheetId, estimateDate, submitName, title, bean);
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	while(result.next()) {
	 		OrderCommonBillBean bean2 = new OrderCommonBillBean();
	 		bean.setEstimateSheetId(result.getString("ESTIMATE_SHEET_ID"));
	 		bean.setEstimateDate(result.getString("ESTIMATE_DATE"));
	 		bean.setSubmitName(result.getString("SUBMIT_NAME"));
	 		bean.setTitle(result.getString("TITLE"));
	 		list.add(bean2);
	 	}
	 	
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
	 	bean.setCtaxRate(result.getString("CTAX_RATE"));
	 	
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
	 	sql = ordersql.billToTaxRate(estimateSheetId);
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	OrderCommonBillBean bean = new OrderCommonBillBean();
	 	bean.setCtaxRate(result.getString("CUSTOMER_CODE"));
	 	bean.setCtaxRate(result.getString("CUSTOMER_NAME"));
	 	bean.setCtaxRate(result.getString("CUSTOMER_CODE"));
	 	bean.setCtaxRate(result.getString("CUSTOMER_CODE"));
	 	bean.setCtaxRate(result.getString("CUSTOMER_CODE"));
	 	bean.setCtaxRate(result.getString("CUSTOMER_REMARKS"));
	 	bean.setCtaxRate(result.getString("CUSTOMER_CODE"));
	 	
	 	return bean;
	 	
	}
	
	/* 見積番号押下 納入先情報反映 */
	public OrderCommonBillBean billToDelivery(String estimateSheetId) throws SQLException, ClassNotFoundException {
		
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
	 	bean.setCtaxRate(result.getString("CUSTOMER_CODE"));
	 	
	 	return bean;
	 	
	}
	
}
