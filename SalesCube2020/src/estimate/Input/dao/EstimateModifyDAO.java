package estimate.Input.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import common.dao.BaseDAO;
import estimate.Input.beans.EstimateModifyBean;
import estimate.Input.beans.InitEstimateBean;
import estimate.Input.beans.InitEstimateProductBean;


public class EstimateModifyDAO extends BaseDAO {
	
	/* 見積情報取得 */
	public InitEstimateBean getEstimate(String estimateSheetId) throws ClassNotFoundException, MissingResourceException, SQLException {
		
		Connection con;
	 	Statement stmt=null;
	 	ResultSet result=null;
	 	String  sql;
	 	
	 	InitEstimateBean bean = new InitEstimateBean();
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	//見積情報を取得するSQL
	 	sql="select " + 
	 			"ESTIMATE_DATE, " + 
	 			"DELIVERY_INFO, " + 
	 			"VALID_DATE, " + 
	 			"USER_NAME, " + 
	 			"TITLE, " + 
	 			"DELIVERY_NAME, " + 
	 			"ESTIMATE_CONDITION, " + 
	 			"CTAX_RATE, " + 
	 			"SUBMIT_NAME, " + 
	 			"SUBMIT_PRE, " + 
	 			"CUSTOMER_CODE, " + 
	 			"CUSTOMER_NAME, " + 
	 			"CUSTOMER_REMARKS, " + 
	 			"CUSTOMER_COMMENT_DATA, " + 
	 			"REMARKS, " + 
	 			"MEMO, " + 
	 			"ESTIMATE_TOTAL " + 
	 		"from estimate_sheet_trn_xxxxx " + 
	 		"where ESTIMATE_SHEET_ID = " + estimateSheetId;
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	bean.setEstimateSheetId(estimateSheetId); //見積番号を登録
	 	
	 	if(result.next()) {
	 		bean.setEstimateDate(result.getString("ESTIMATE_DATE"));
	 		bean.setDeliveryInfo(result.getString("DELIVERY_INFO"));
	 		bean.setValidDate(result.getString("VALID_DATE"));
	 		bean.setUserName(result.getString("USER_NAME"));
	 		bean.setTitle(result.getString("TITLE"));
	 		bean.setDeliveryName(result.getString("DELIVERY_NAME"));
	 		bean.setEstimateCondition(result.getString("ESTIMATE_CONDITION"));
	 		bean.setCtaxRate(result.getDouble("CTAX_RATE"));
	 		bean.setSubmitName(result.getString("SUBMIT_NAME"));
	 		bean.setSubmitPre(result.getString("SUBMIT_PRE"));
	 		bean.setCustomerCode(result.getString("CUSTOMER_CODE"));
	 		bean.setCustomerName(result.getString("CUSTOMER_NAME"));
	 		bean.setCustomerRemarks(result.getString("CUSTOMER_REMARKS"));
	 		bean.setCustomerComment(result.getString("CUSTOMER_COMMENT_DATA"));
	 		bean.setRemarks(result.getString("REMARKS"));
	 		bean.setMemo(result.getString("MEMO"));
	 		bean.setEstimateTotal(result.getInt("ESTIMATE_TOTAL"));
	 	}
	 	
	 	super.releaseDB(con,stmt,result);
	 	
		return bean;
	}
	
	/* 見積商品情報取得 */
	public List<InitEstimateProductBean> getEstimateProduct(String estimateSheetId) throws ClassNotFoundException, MissingResourceException, SQLException {
		
		Connection con;
	 	Statement stmt=null;
	 	ResultSet result=null;
	 	String  sql;
	 	
	 	List<InitEstimateProductBean> list = new ArrayList<InitEstimateProductBean>();
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	sql="select " + 
	 			"LINE_NO, " + 
	 			"PRODUCT_CODE, " + 
	 			"PRODUCT_ABSTRACT, " + 
	 			"QUANTITY, " + 
	 			"UNIT_COST, " + 
	 			"COST, " + 
	 			"UNIT_RETAIL_PRICE, " + 
	 			"RETAIL_PRICE, " + 
	 			"REMARKS " + 
	 		"from estimate_line_trn_xxxxx " + 
	 		"where ESTIMATE_SHEET_ID = " + estimateSheetId;
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	while(result.next()) {
	 		InitEstimateProductBean bean = new InitEstimateProductBean();
	 		bean.setLineNo(Integer.parseInt(result.getString("LINE_NO")));
	 		bean.setProductCode(result.getString("PRODUCT_CODE"));
	 		bean.setProductAbstract(result.getString("PRODUCT_ABSTRACT"));
	 		bean.setQuantity(result.getInt("QUANTITY"));
	 		bean.setUnitCost(result.getInt("UNIT_COST"));
	 		bean.setCost(result.getInt("COST"));
	 		bean.setUnitRetailPrice(result.getInt("UNIT_RETAIL_PRICE"));
	 		bean.setRetailPrice(result.getInt("RETAIL_PRICE"));
	 		bean.setProductRemarks(result.getString("REMARKS"));
	 		list.add(bean);
	 	}
	 	
	 	super.releaseDB(con,stmt,result);
	 	
		return list;
	}
	
	/* 見積更新 */
	public int modifyEstimate(EstimateModifyBean bean) throws ClassNotFoundException, MissingResourceException, SQLException {
		
		Connection con;
		Statement stmt = null;
	 	int result = 0;
	 	String  sql;
	 	
	 	//変数宣言
	 	String estimateSheetId    = bean.getEstimateSheetId();
	 	String estimateDate		  = bean.getEstimateDate();
	 	String deliveryInfo		  = bean.getDeliveryInfo();
	 	String validDate		  = bean.getValidDate();
	 	String userName			  = bean.getUserName();
	 	String title			  = bean.getTitle();
	 	String deliveryName		  = bean.getDeliveryName();
	 	String estimateCondition  = bean.getEstimateCondition();
	 	double ctaxRate			  = bean.getCtaxRate();
	 	String submitName		  = bean.getSubmitName();
	 	String submitPre		  = bean.getSubmitPre();
	 	String customerCode		  = bean.getCustomerCode();
	 	String customerName		  = bean.getCustomerName();
	 	String customerRemarks	  = bean.getCustomerRemarks();
	 	String customerComment    = bean.getCustomerComment();
	 	String remarks			  = bean.getRemarks();
	 	String memo				  = bean.getMemo();
	 	Integer retailPriceTotal  = bean.getRetailPriceTotal();
	 	Integer ctaxPriceTotal	  = bean.getCtaxPriceTotal();
	 	Integer estimateTotal	  = bean.getEstimateTotal();
	 	String updUser			  = bean.getUpdUser();
	 	
	 	//現在時刻の取得
		LocalDateTime ldt           = LocalDateTime.now();
		String updDate              = ldt.toString();
	 	
	 	//SQL変換
	 	String estimateSheetIdSQL;
	 	String estimateDateSQL;
	 	String deliveryInfoSQL;
	 	String validDateSQL;
	 	String userNameSQL;
	 	String titleSQL;
	 	String deliveryNameSQL;
	 	String estimateConditionSQL;
	 	String submitNameSQL;
	 	String submitPreSQL;
	 	String customerCodeSQL;
	 	String customerNameSQL;
	 	String customerRemarksSQL;
	 	String customerCommentSQL;
	 	String remarksSQL;
	 	String memoSQL;
	 	Integer retailPriceTotalSQL;
	 	Integer ctaxPriceTotalSQL;
	 	Integer estimateTotalSQL;
	 	String updDateSQL;
	 	String updUserSQL;
	 	
	 	
	 	//nullの場合の処理
		if(estimateSheetId==null || estimateSheetId.equals("")) {estimateSheetIdSQL = null;} 
		else {estimateSheetIdSQL = "'" + estimateSheetId + "'";}
		
		if(estimateDate==null || estimateDate.equals("")) {estimateDateSQL = null;} 
		else {estimateDateSQL = "'" + estimateDate + "'";}
		
		if(deliveryInfo==null || deliveryInfo.equals("")) {deliveryInfoSQL = null;} 
		else {deliveryInfoSQL = "'" + deliveryInfo + "'";}
		
		if(validDate==null || validDate.equals("")) {validDateSQL = null;} 
		else {validDateSQL = "'" + validDate + "'";}
		
		if(userName==null || userName.equals("")) {userNameSQL = null;} 
		else {userNameSQL = "'" + userName + "'";}
		
		if(title==null || title.equals("")) {titleSQL = null;} 
		else {titleSQL = "'" + title + "'";}
		
		if(deliveryName==null || deliveryName.equals("")) {deliveryNameSQL = null;} 
		else {deliveryNameSQL = "'" + deliveryName + "'";}
		
		if(estimateCondition==null || estimateCondition.equals("")) {estimateConditionSQL = null;} 
		else {estimateConditionSQL = "'" + estimateCondition + "'";}
		
		if(submitName==null || submitName.equals("")) {submitNameSQL = null;} 
		else {submitNameSQL = "'" + submitName + "'";}
		
		if(submitPre==null || submitPre.equals("")) {submitPreSQL = null;} 
		else {submitPreSQL = "'" + submitPre + "'";}
		
		if(customerCode==null || customerCode.equals("")) {customerCodeSQL = null;} 
		else {customerCodeSQL = "'" + customerCode + "'";}
		
		if(customerName==null || customerName.equals("")) {customerNameSQL = null;} 
		else {customerNameSQL = "'" + customerName + "'";}
		
		if(customerRemarks==null || customerRemarks.equals("")) {customerRemarksSQL = null;} 
		else {customerRemarksSQL = "'" + customerRemarks + "'";}
		
		if(customerComment==null || customerComment.equals("")) {customerCommentSQL = null;} 
		else {customerCommentSQL = "'" + customerComment + "'";}
		
		if(remarks==null || remarks.equals("")) {remarksSQL = null;} 
		else {remarksSQL = "'" + remarks + "'";}
		
		if(memo==null || memo.equals("")) {memoSQL = null;} 
		else {memoSQL = "'" + memo + "'";}
		
		if(retailPriceTotal==null) {retailPriceTotalSQL = null;} 
		else {retailPriceTotalSQL = retailPriceTotal;}
		
		if(ctaxPriceTotal==null) {ctaxPriceTotalSQL = null;} 
		else {ctaxPriceTotalSQL = ctaxPriceTotal;}
		
		if(estimateTotal==null) {estimateTotalSQL = null;} 
		else {estimateTotalSQL = estimateTotal;}
		
		if(updDate==null || updDate.equals("")) {updDateSQL = null;} 
		else {updDateSQL = "'" + updDate + "'";}
		
		if(updUser==null || updUser.equals("")) {updUserSQL = null;} 
		else {updUserSQL = "'" + updUser + "'";}
		
		con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	//見積更新をするSQL
	 	sql = "update estimate_sheet_trn_xxxxx set " +
	 		      "ESTIMATE_DATE = " + estimateDateSQL + ", " +
	 		      "DELIVERY_INFO = " + deliveryInfoSQL + ", " +
	 		      "VALID_DATE = " + validDateSQL + ", " +
	 		      "USER_NAME = " + userNameSQL + ", " +
	 		      "TITLE = " + titleSQL + ", " +
	 		      "DELIVERY_NAME = " + deliveryNameSQL + ", " +
	 		      "ESTIMATE_CONDITION = " + estimateConditionSQL + ", " +
	 		      "CTAX_RATE = " + ctaxRate + ", " +
	 		      "SUBMIT_NAME = " + submitNameSQL + ", " +
	 		      "SUBMIT_PRE = " + submitPreSQL + ", " +
	 		      "CUSTOMER_CODE = " + customerCodeSQL + ", " +
	 		      "CUSTOMER_NAME = " + customerNameSQL + ", " +
	 		      "CUSTOMER_REMARKS = " + customerRemarksSQL + ", " +
	 		      "CUSTOMER_COMMENT_DATA = " + customerCommentSQL + ", " +
	 		      "REMARKS = " + remarksSQL + ", " +
	 		      "MEMO = " + memoSQL + ", " +
	 		      "RETAIL_PRICE_TOTAL = " + retailPriceTotalSQL + ", " +
	 		      "CTAX_PRICE_TOTAL = " + ctaxPriceTotalSQL + ", " +
	 		      "ESTIMATE_TOTAL = " + estimateTotalSQL + ", " +
	 		      "UPD_DATETM = " + updDateSQL + ", " +
	 		      "UPD_USER = " + updUserSQL +
	 		  "where ESTIMATE_SHEET_ID = " + estimateSheetIdSQL;
			 	
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
	
	
	/* 見積削除 */
	public int deleteEstimate(String estimateSheetId) throws ClassNotFoundException, MissingResourceException, SQLException {
		Connection con;
		Statement stmt= null;
	 	int result=0;
	 	String  sql;
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	//見積を削除するSQL
	 	sql = "delete from estimate_sheet_trn_xxxxx where ESTIMATE_SHEET_ID = " + estimateSheetId;	 	
	 	
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
	
	
	
	/* 見積商品情報削除 */
	public int deleteEstimateProduct(String estimateSheetId) throws ClassNotFoundException, MissingResourceException, SQLException {
		Connection con;
		Statement stmt= null;
	 	int result=0;
	 	String  sql;
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	//見積商品を削除するSQL
	 	sql = "delete from estimate_line_trn_xxxxx where ESTIMATE_SHEET_ID = " + estimateSheetId;	 	
	 	
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

	 			
}
