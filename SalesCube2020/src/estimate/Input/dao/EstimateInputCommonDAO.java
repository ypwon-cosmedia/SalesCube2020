/**
 * 
 */
package estimate.Input.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.dao.BaseDAO;
import estimate.Input.beans.GetCustomerBean;
import estimate.Input.beans.GetProductBean;
import estimate.Input.beans.TaxRateBean;


public class EstimateInputCommonDAO extends BaseDAO {
	
	//消費税を取得するメソッド
	public List<TaxRateBean> getTaxRate() throws SQLException, ClassNotFoundException {
		Connection con;
	 	Statement stmt=null;
	 	ResultSet result=null;
	 	String  sql;
	 	
	 	List<TaxRateBean> list = new ArrayList<> ();
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	sql="select TAX_RATE from tax_rate_mst_xxxxx where TAX_TYPE_CATEGORY = '1'";
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	while (result.next()) {
	 		TaxRateBean bean = new TaxRateBean();
	 		bean.setTaxRate(result.getBigDecimal("TAX_RATE"));
	 		list.add(bean);
	 	}
	 	
	 	super.releaseDB(con,stmt,result);
	 	
	 	return list;
	}
	
	//見積番号が存在するか確認するメソッド
	public String confirmEstimateSheetId(String estimateSheetId) throws SQLException, ClassNotFoundException {
		
		Connection con;
	 	Statement stmt=null;
	 	ResultSet result=null;
	 	String  sql;
	 	String check = "NG";
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	sql="select ESTIMATE_SHEET_ID " + 
	 		"from estimate_sheet_trn_xxxxx " + 
	 		"where ESTIMATE_SHEET_ID = '" + estimateSheetId + "'";
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	if (result.next()) {
	 		String getEstimateSheetId = result.getString("ESTIMATE_SHEET_ID"); //一致している見積番号を取得
		 	if(getEstimateSheetId != null) { //見積番号が登録されている(取得できている)ならば 変数checkをtrueにして返す
		 		check = "OK";
		 	} else {
		 		check = "NG";
		 	}
	 	}
	 	
	 	super.releaseDB(con,stmt,result);
	 	
	 	return check;
	}

	//顧客情報を取得するメソッド
	public GetCustomerBean getCustomer(String customerCode) throws SQLException, ClassNotFoundException {
		
		Connection con;
	 	Statement stmt=null;
	 	ResultSet result=null;
	 	String  sql;
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	sql="select CUSTOMER_NAME, " + 
	 				"REMARKS, " + 
	 				"COMMENT_DATA " + 
	 		"from customer_mst_xxxxx " + 
	 		"where CUSTOMER_CODE = '" + customerCode + "'";
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	GetCustomerBean bean = new GetCustomerBean();
		
	 	if (result.next()) {
	 		bean.setCustomerName(result.getString("CUSTOMER_NAME"));
	 		bean.setCustomerRemarks(result.getString("REMARKS"));
	 		bean.setCustomerComment(result.getString("COMMENT_DATA"));
	 		
	 		if(bean.getCustomerName()== null || bean.getCustomerName().equals("")) {bean.setCustomerName("");};
	 		if(bean.getCustomerRemarks()== null || bean.getCustomerRemarks().equals("")) {bean.setCustomerRemarks("");};
	 		if(bean.getCustomerComment()== null || bean.getCustomerComment().equals("")) {bean.setCustomerComment("");};
	 	}
	 	
	 	super.releaseDB(con,stmt,result);
	 	
	 	return bean;
	}
	
	
	//商品情報を取得するメソッド
	public GetProductBean getProduct(String productCode) throws SQLException, ClassNotFoundException {
		
		Connection con;
	 	Statement stmt=null;
	 	ResultSet result=null;	
	 	String  sql;
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	sql="select PRODUCT_NAME, " + 
	 				"SUPPLIER_PRICE_YEN, " +
	 				"RETAIL_PRICE " + 
	 		"from product_mst_xxxxx " + 
	 		"where PRODUCT_CODE = '" + productCode + "'";
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	GetProductBean bean = new GetProductBean();
		
	 	if (result.next()) {
	 		bean.setProductAbstract(result.getString("PRODUCT_NAME"));
	 		bean.setUnitCost(result.getInt("SUPPLIER_PRICE_YEN"));
	 		bean.setUnitRetailPrice(result.getInt("RETAIL_PRICE"));
	 		
	 		if(bean.getProductAbstract()== null || bean.getProductAbstract().equals("")) {bean.setProductAbstract("");};

	 	}
	 	
	 	super.releaseDB(con,stmt,result);
	 	
	 	return bean;
	}
}
