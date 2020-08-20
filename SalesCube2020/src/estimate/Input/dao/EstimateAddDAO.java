package estimate.Input.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.MissingResourceException;

import common.dao.BaseDAO;
import estimate.Input.API.EstimatePropertyUtil;
import estimate.Input.beans.EstimateAddBean;
import estimate.Input.beans.EstimateProductAddBean;


public class EstimateAddDAO extends BaseDAO {
	
	/* (見積商品を除く)見積登録 */
	public int addEstimate(EstimateAddBean bean) throws ClassNotFoundException, MissingResourceException, SQLException {
		Connection con;
		PreparedStatement pstmt= null;
	 	int result = 0;
	 	String  sql;
	 	
	 	//変数宣言
	 	String estimateSheetId    = bean.getEstimateSheetId();
	 	String estimateDate		  = bean.getEstimateDate();
	 	String deliveryInfo		  = bean.getDeliveryInfo();
	 	String validDate		  = bean.getValidDate();
	 	String userName			  = bean.getUserName();
	 	String userId			  = bean.getUserId();
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
	 	Integer costTotal		  = bean.getCostTotal();
	 	String creUser			  = bean.getCreUser();
	 	
		LocalDateTime ldt           = LocalDateTime.now(); //現在時刻取得
		String creDate              = ldt.toString();
	 	
	 	//空文字が入った場合の処理
		if(estimateSheetId.equals("")) {estimateSheetId = null;} 
		if(estimateDate.equals("")) {estimateDate = null;} 
		if(deliveryInfo.equals("")) {deliveryInfo = null;} 
		if(validDate.equals("")) {validDate = null;} 
		if(userName.equals("")) {userName = null;} 
		if(userId.equals("")) {userId = null;} 
		if(title.equals("")) {title = null;} 
		if(deliveryName.equals("")) {deliveryName = null;} 
		if(estimateCondition.equals("")) {estimateCondition = null;} 
		if(submitName.equals("")) {submitName = null;} 
		if(submitPre.equals("")) {submitPre = null;} 
		if(customerCode.equals("")) {customerCode = null;} 
		if(customerName.equals("")) {customerName = null;} 
		if(customerRemarks.equals("")) {customerRemarks = null;} 
		if(customerComment.equals("")) {customerComment = null;} 
		if(remarks.equals("")) {remarks = null;} 
		if(memo.equals("")) {memo = null;} 
		if(creDate.equals("")) {creDate = null;} 
		if(creUser.equals("")) {creUser = null;} 
		
		con = super.getConnection();

	 	sql = EstimatePropertyUtil.getProperty("addEstimate"); //プロパティファイルから読み込み
	 	
	 	pstmt = con.prepareStatement(sql);
	 	
	 	pstmt.setString(1, estimateSheetId);
	 	pstmt.setString(2, estimateDate);
	 	pstmt.setString(3, deliveryInfo);
	 	pstmt.setString(4, validDate);
	 	pstmt.setString(5, userName);
	 	pstmt.setString(6, userId);
	 	pstmt.setString(7, title);
	 	pstmt.setString(8, deliveryName);
	 	pstmt.setString(9, estimateCondition);
	 	pstmt.setDouble(10, ctaxRate);
	 	pstmt.setString(11, submitName);
	 	pstmt.setString(12, submitPre);
	 	pstmt.setString(13, customerCode);
	 	pstmt.setString(14, customerName);
	 	pstmt.setString(15, customerRemarks);
	 	pstmt.setString(16, customerComment);
	 	pstmt.setString(17, remarks);
	 	pstmt.setString(18, memo);
	 	pstmt.setInt(19, retailPriceTotal);
	 	pstmt.setInt(20, ctaxPriceTotal);
	 	pstmt.setInt(21, estimateTotal);
	 	pstmt.setInt(22, costTotal);
	 	pstmt.setString(23, creDate);
	 	pstmt.setString(24, creUser);
			 	
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
	
	/* 見積商品登録 */
	public int addEstimateProduct (List<EstimateProductAddBean> list) throws ClassNotFoundException, MissingResourceException, SQLException {
		
		Connection con;
		PreparedStatement pstmt= null;
	 	int result = 0;
	 	String  sql;
	 	
	 	//見積商品登録の変数宣言
	 	Integer lineNo;
	 	String estimateSheetId;
	 	String productCode;
	 	String productAbstract;
	 	Integer quantity;
	 	Integer unitCost;
	 	Integer cost;
	 	Integer unitRetailPrice;
	 	Integer retailPrice;
	 	String productRemarks;
	 	String creUser;
	 	
		LocalDateTime ldt           = LocalDateTime.now(); 	 //現在の時間を取得
		String creDate              = ldt.toString();
	 	
	 	con = super.getConnection();	
	 	
	 	//最大見積伝票行IDの取得
	 	Integer estimateLineId = getMaxEstimateLineId();
	 	
		sql = EstimatePropertyUtil.getProperty("addEstimateProduct"); //プロパティファイルから読み込み
	 	
	 	for(EstimateProductAddBean bean : list) {
	 		estimateLineId++; //登録を繰り返すごとに最大見積伝票行IDを1ずつ増やしていく
			lineNo = bean.getLineNo();
			estimateSheetId = bean.getEstimateSheetId();
			productCode = bean.getProductCode();
			productAbstract = bean.getProductAbstract();
			quantity = bean.getQuantity();
			unitCost = bean.getUnitCost();
			cost = bean.getCost();
			unitRetailPrice = bean.getUnitRetailPrice();
			retailPrice = bean.getRetailPrice();
			productRemarks = bean.getProductRemarks();
			creUser = bean.getCreUser();
	 		
			//空文字の場合の処理
			if(productCode.equals("")) {productCode = null;}
			if(productAbstract == null || productAbstract.equals("")) {productAbstract = "";}
			if(productRemarks == null || productRemarks.equals("")) {productRemarks = "";}
			if(creDate.equals("")) {creDate = null;}
			if(creUser.equals("")) {creUser = null;}
			
	 		pstmt = con.prepareStatement(sql);
	 		
		 	pstmt.setInt(1, estimateLineId);
		 	pstmt.setInt(2, lineNo);
		 	pstmt.setString(3, estimateSheetId);
		 	pstmt.setString(4, productCode);
		 	pstmt.setString(5, productAbstract);
		 	pstmt.setInt(6, quantity);
		 	pstmt.setInt(7, unitCost);
		 	pstmt.setInt(8, cost);
		 	pstmt.setInt(9, unitRetailPrice);
		 	pstmt.setInt(10, retailPrice);
		 	pstmt.setString(11, productRemarks);
		 	pstmt.setString(12, creDate);
		 	pstmt.setString(13, creUser);
	 		
	 		result = pstmt.executeUpdate();
	 		con.commit();
	 	}
	 	
	 	super.releaseDB(con,pstmt);
	 	
	 	return result;
	 	
	}
	
	/* 見積商品IDの最大値を取得 */
	public Integer getMaxEstimateLineId () throws ClassNotFoundException, MissingResourceException, SQLException {
		Connection con;
		Statement stmt= null;
	 	ResultSet result=null;
	 	String  sql;
	 	
	 	Integer maxEstimateLineId=0; //最大見積伝票行ID
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();

	 	sql = EstimatePropertyUtil.getProperty("getMaxEstimateLineId"); //プロパティファイルから読み込み
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	while(result.next()){
	 		maxEstimateLineId = Integer.parseInt(result.getString("MAX_ESTIMATE_LINE_ID"));
	 	}
	 	
	 	super.releaseDB(con,stmt,result);
	 	
	 	return maxEstimateLineId;
	}		
}
