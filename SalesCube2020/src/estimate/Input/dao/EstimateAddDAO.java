package estimate.Input.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.MissingResourceException;

import common.dao.BaseDAO;
import estimate.Input.beans.EstimateAddBean;
import estimate.Input.beans.EstimateProductAddBean;


public class EstimateAddDAO extends BaseDAO {
	

	public int addEstimate(EstimateAddBean bean) throws ClassNotFoundException, MissingResourceException, SQLException {
		
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
	 	sql = "insert into estimate_sheet_trn_xxxxx (" +
	 		      "ESTIMATE_SHEET_ID, " + 
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
	 		      "RETAIL_PRICE_TOTAL, " + 
	 		      "CTAX_PRICE_TOTAL, " + 
	 		      "ESTIMATE_TOTAL, " + 
	 		      "CRE_DATETM, " +
	 		      "CRE_USER) " +
	 		  "values " +
	 		      "(" + estimateSheetIdSQL + ", " +
			 		     estimateDateSQL + ", " +
			 		     deliveryInfoSQL + ", " +
			 		     validDateSQL + ", " +
			 		     userNameSQL + ", " +
			 		     titleSQL + ", " +
			 		     deliveryNameSQL + ", " +
			 		     estimateConditionSQL + ", " +
			 		     ctaxRateSQL + ", " +
			 		     submitNameSQL + ", " +
			 		     submitPreSQL + ", " +
			 		     customerCodeSQL + ", " +
			 		     customerNameSQL + ", " +
			 		     customerRemarksSQL + ", " +
			 		     customerCommentSQL + ", " +
			 		     remarksSQL + ", " +
			 		     memoSQL + ", " +
			 		     retailPriceTotalSQL + ", " +
			 		     ctaxPriceTotalSQL + ", " +
			 		     estimateTotalSQL + ", " +
			 		     creDateSQL + ", " +
			 		     creUserSQL + ")";
			 	
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
	
	
	public int addEstimateProduct (List<EstimateProductAddBean> list) throws ClassNotFoundException, MissingResourceException, SQLException {
		
		Connection con;
		Statement stmt;
	 	int result = 0;
	 	String  sql;
	 	
	 	Integer lineNo;
	 	String productCode;
	 	String productAbstract;
	 	Integer quantity;
	 	Integer unitCost;
	 	Integer cost;
	 	Integer unitRetailPrice;
	 	Integer retailPrice;
	 	String productRemarks;
	 	String creUser;
	 	
		LocalDateTime ldt           = LocalDateTime.now();
		String creDate              = ldt.toString();
	 	
	 	Integer lineNoSQL;
	 	String productCodeSQL;
	 	String productAbstractSQL;
	 	Integer quantitySQL;
	 	Integer unitCostSQL;
	 	Integer costSQL;
	 	Integer unitRetailPriceSQL;
	 	Integer retailPriceSQL;
	 	String productRemarksSQL;
	 	String creDateSQL;
	 	String creUserSQL;
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	for(EstimateProductAddBean bean : list) {
	 		
			lineNo = bean.getLineNo();
			productCode = bean.getProductCode();
			productAbstract = bean.getProductAbstract();
			quantity = bean.getQuantity();
			unitCost = bean.getUnitCost();
			cost = bean.getCost();
			unitRetailPrice = bean.getUnitRetailPrice();
			retailPrice = bean.getRetailPrice();
			productRemarks = bean.getProductRemarks();
			creUser = bean.getCreUser();
	 		
			if(lineNo==null) {lineNoSQL = null;} 
			else {lineNoSQL = lineNo;}
			
			if(productCode==null || productCode.equals("")) {productCodeSQL = null;} 
			else {productCodeSQL = "'" + productCode + "'";}
			
			if(productAbstract==null || productAbstract.equals("")) {productAbstractSQL = null;} 
			else {productAbstractSQL = "'" + productAbstract + "'";}
			
			if(quantity==null) {quantitySQL = null;} 
			else {quantitySQL = quantity;}
			
			if(unitCost==null) {unitCostSQL = null;} 
			else {unitCostSQL = unitCost;}
			
			if(cost==null) {costSQL = null;} 
			else {costSQL = cost;}
			
			if(unitRetailPrice==null) {unitRetailPriceSQL = null;} 
			else {unitRetailPriceSQL = unitRetailPrice;}
			
			if(retailPrice==null) {retailPriceSQL = null;} 
			else {retailPriceSQL = retailPrice;}
			
			if(productRemarks==null || productRemarks.equals("")) {productRemarksSQL = null;} 
			else {productRemarksSQL = "'" + productRemarks + "'";}
			
			if(creDate==null || creDate.equals("")) {creDateSQL = null;} 
			else {creDateSQL = "'" + creDate + "'";}
			
			if(creUser==null || creUser.equals("")) {creUserSQL = null;} 
			else {creUserSQL = "'" + creUser + "'";}
	 	
	 		sql = "insert into estimate_line_trn_xxxxx (" +
	 					"LINE_NO, " +
	 					"PRODUCT_CODE, " +
	 					"PRODUCT_ABSTRACT, " +
	 					"QUANTITY, " +
	 					"UNIT_COST, " +
	 					"COST, " +
	 					"UNIT_RETAIL_PRICE, " +
	 					"RETAIL_PRICE, " +
	 					"REMARKS, " +
	 					"CRE_DATETM, " +
	 					"CRE_USER)" +
	 			  "values(" +
	 			  		lineNoSQL + ", " +
	 			  		productCodeSQL + ", " +
	 			  		productAbstractSQL + ", " +
	 			  		quantitySQL + ", " +
	 			  		unitCostSQL + ", " +
	 			  		costSQL + ", " +
	 			  		unitRetailPriceSQL + ", " +
	 			  		retailPriceSQL + ", " +
	 			  		productRemarksSQL + ", " +
	 			  		creDateSQL + ", " +
	 			  		creUserSQL + ")";
	 		
	 		result = stmt.executeUpdate(sql);
	 		con.commit();
	 	}
	 	
	 	super.releaseDB(con,stmt);
	 	
	 	return result;
	 	
	}


	 			
}
