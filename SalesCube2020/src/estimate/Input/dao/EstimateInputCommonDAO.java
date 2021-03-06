/**
 * 
 */
package estimate.Input.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.dao.BaseDAO;
import estimate.Input.API.EstimatePropertyUtil;
import estimate.Input.beans.GetCustomerBean;
import estimate.Input.beans.GetProductBean;
import estimate.Input.beans.TaxRateBean;


public class EstimateInputCommonDAO extends BaseDAO {
	
	/* 消費税を取得する */
	public List<TaxRateBean> getTaxRate() throws SQLException, ClassNotFoundException, IOException {
		Connection con;
		PreparedStatement pstmt= null;
	 	ResultSet result=null;
	 	String  sql=null;
	 	
	 	List<TaxRateBean> list = new ArrayList<> ();
	 	
	 	con = super.getConnection();
	 	
	 	sql = EstimatePropertyUtil.getProperty("getTaxRate"); //プロパティファイルから読み込み
	 	
	 	pstmt = con.prepareStatement(sql);
	 	
	 	pstmt.setInt(1, 1);
	 	
	 	result = pstmt.executeQuery();
	 	
	 	while (result.next()) {
	 		TaxRateBean bean = new TaxRateBean();
	 		bean.setTaxRate(result.getBigDecimal("TAX_RATE"));
	 		list.add(bean);
	 	}
	 	super.releaseDB(con,pstmt,result);
	 	
	 	return list;
	}
	
	/* 見積番号が存在するか確認する */
	public String confirmEstimateSheetId(String estimateSheetId) throws SQLException, ClassNotFoundException {
		
		Connection con;
		PreparedStatement pstmt= null;
	 	ResultSet result=null;
	 	String  sql;
	 	String check = "NG";
	 	
	 	con = super.getConnection();
	 	
	 	sql = EstimatePropertyUtil.getProperty("confirmEstimateSheetId"); //プロパティファイルから読み込み
	 	
	 	pstmt = con.prepareStatement(sql);
	 	
	 	pstmt.setString(1, estimateSheetId);
	 	
	 	result = pstmt.executeQuery();
	 	
	 	if (result.next()) {
	 		String getEstimateSheetId = result.getString("ESTIMATE_SHEET_ID"); //一致している見積番号を取得
		 	if(getEstimateSheetId != null) { //見積番号が登録されている(取得できている)ならば 変数checkをtrueにして返す
		 		check = "OK";
		 	} else {
		 		check = "NG";
		 	}
	 	}
	 	super.releaseDB(con,pstmt,result);
	 	
	 	return check;
	}

	/* 顧客情報を取得する */
	public GetCustomerBean getCustomer(String customerCode) throws SQLException, ClassNotFoundException {
		
		Connection con;
		PreparedStatement pstmt= null;
	 	ResultSet result=null;
	 	String  sql;
	 	
	 	con = super.getConnection();
	 	
	 	sql = EstimatePropertyUtil.getProperty("getCustomer"); //プロパティファイルから読み込み
	 	
	 	pstmt = con.prepareStatement(sql);
	 	
	 	pstmt.setString(1, customerCode);
	 	
	 	result = pstmt.executeQuery();
	 	
	 	GetCustomerBean bean = new GetCustomerBean();
		
	 	if (result.next()) {
	 		bean.setCustomerName(result.getString("CUSTOMER_NAME"));
	 		bean.setCustomerRemarks(result.getString("REMARKS"));
	 		bean.setCustomerComment(result.getString("COMMENT_DATA"));
	 		
	 		if(bean.getCustomerName()== null || bean.getCustomerName().equals("")) {bean.setCustomerName("");};
	 		if(bean.getCustomerRemarks()== null || bean.getCustomerRemarks().equals("")) {bean.setCustomerRemarks("");};
	 		if(bean.getCustomerComment()== null || bean.getCustomerComment().equals("")) {bean.setCustomerComment("");};
	 	}
	 	super.releaseDB(con,pstmt,result);
	 	
	 	return bean;
	}
	
	
	/* 商品情報を取得するメソッド */
	public GetProductBean getProduct(String productCode) throws SQLException, ClassNotFoundException {
		
		Connection con;
		PreparedStatement pstmt= null;
	 	ResultSet result=null;	
	 	String  sql;
	 	
	 	con = super.getConnection();

	 	sql = EstimatePropertyUtil.getProperty("getProduct"); //プロパティファイルから読み込み
	 	
	 	pstmt = con.prepareStatement(sql);
	 	
	 	pstmt.setString(1, productCode);
	 	
	 	result = pstmt.executeQuery();
	 	
	 	GetProductBean bean = new GetProductBean();
		
	 	if (result.next()) {
	 		bean.setProductAbstract(result.getString("PRODUCT_NAME"));
	 		bean.setUnitCost(result.getInt("SUPPLIER_PRICE_YEN"));
	 		bean.setUnitRetailPrice(result.getInt("RETAIL_PRICE"));
	 		
	 		if(bean.getProductAbstract()== null || bean.getProductAbstract().equals("")) {bean.setProductAbstract("");};
	 	}
	 	super.releaseDB(con,pstmt,result);
	 	
	 	return bean;
	}
}
