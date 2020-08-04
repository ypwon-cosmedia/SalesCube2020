package estimate.Input.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.MissingResourceException;

import common.dao.BaseDAO;
import estimate.Input.beans.EstimateAddBean;
import estimate.Input.beans.EstimateModifyBean;
import estimate.Input.beans.EstimateProductAddBean;


public class EstimateModifyDAO extends BaseDAO {
	

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
	 	String ctaxRate			  = bean.getCtaxRate();
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
	 	String creDate		      = bean.getCreDate();
	 	String creUser			  = bean.getCreUser();
	 	
	 	//SQL変換
	 	String estimateSheetIdSQL;
	 	String estimateDateSQL;
	 	String deliveryInfoSQL;
	 	String validDateSQL;
	 	String userNameSQL;
	 	String titleSQL;
	 	String deliveryNameSQL;
	 	String estimateConditionSQL;
	 	String ctaxRateSQL;
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
	 	String creDateSQL;
	 	String creUserSQL;
	 	
	 	
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
		
		if(ctaxRate==null || ctaxRate.equals("")) {ctaxRateSQL = null;} 
		else {ctaxRateSQL = "'" + ctaxRate + "'";}
		
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
		
		if(creDate==null || creDate.equals("")) {creDateSQL = null;} 
		else {creDateSQL = "'" + creDate + "'";}
		
		if(creUser==null || creUser.equals("")) {creUserSQL = null;} 
		else {creUserSQL = "'" + creUser + "'";}
		
		con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	//見積登録をするSQL
	 	sql = "update estimate_sheet_trn_xxxxx set " +
	 		      "ESTIMATE_DATE = " + estimateDateSQL + ", " +
	 		      "DELIVERY_INFO = " + deliveryInfoSQL + ", " +
	 		      "VALID_DATE = " + validDateSQL + ", " +
	 		      "USER_NAME = " + userNameSQL + ", " +
	 		      "TITLE = " + titleSQL + ", " +
	 		      "DELIVERY_NAME = " + deliveryNameSQL + ", " +
	 		      "ESTIMATE_CONDITION = " + estimateConditionSQL + ", " +
	 		      "CTAX_RATE = " + ctaxRateSQL + ", " +
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
	 		      "CRE_DATETM = " + creDateSQL + ", " +
	 		      "CRE_USER = " + creUserSQL +
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

	 			
}
