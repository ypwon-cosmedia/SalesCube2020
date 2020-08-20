package estimate.Input.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import common.dao.BaseDAO;
import estimate.Input.API.EstimatePropertyUtil;
import estimate.Input.beans.EstimateModifyBean;
import estimate.Input.beans.InitEstimateBean;
import estimate.Input.beans.InitEstimateProductBean;


public class EstimateModifyDAO extends BaseDAO {
	
	/* 見積情報取得 */
	public InitEstimateBean getEstimate(String estimateSheetId) throws ClassNotFoundException, MissingResourceException, SQLException {
		
		Connection con;
		PreparedStatement pstmt= null;
	 	ResultSet result=null;
	 	String  sql;
	 	
	 	InitEstimateBean bean = new InitEstimateBean();
	 	
	 	con = super.getConnection();
	 	
	 	sql = EstimatePropertyUtil.getProperty("getEstimate"); //プロパティファイルから読み込み
	 	
	 	pstmt = con.prepareStatement(sql);
	 	
	 	pstmt.setString(1, estimateSheetId);
	 	
	 	result = pstmt.executeQuery();
	 	
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
	 	
	 	super.releaseDB(con,pstmt,result);
	 	
		return bean;
	}
	
	/* 見積商品情報取得 */
	public List<InitEstimateProductBean> getEstimateProduct(String estimateSheetId) throws ClassNotFoundException, MissingResourceException, SQLException {
		
		Connection con;
		PreparedStatement pstmt= null;
	 	ResultSet result=null;
	 	String  sql;
	 	
	 	List<InitEstimateProductBean> list = new ArrayList<InitEstimateProductBean>();
	 	
	 	con = super.getConnection();
	 	
	 	sql = EstimatePropertyUtil.getProperty("getEstimateProduct"); //プロパティファイルから読み込み
	 	
	 	pstmt = con.prepareStatement(sql);
	 	
	 	pstmt.setString(1, estimateSheetId);
	 	
	 	result = pstmt.executeQuery();
	 	
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
	 	
	 	super.releaseDB(con,pstmt,result);
	 	
		return list;
	}
	
	/* 見積更新 */
	public int modifyEstimate(EstimateModifyBean bean) throws ClassNotFoundException, MissingResourceException, SQLException {
		
		Connection con;
		PreparedStatement pstmt= null;
	 	int result = 0;
	 	String  sql;
	 	
	 	//変数宣言
	 	String estimateSheetId    = bean.getEstimateSheetId();
	 	String estimateDate		  = bean.getEstimateDate();
	 	String deliveryInfo		  = bean.getDeliveryInfo();
	 	String validDate		  = bean.getValidDate();
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
	 	
	 	//nullの場合の処理
		if(estimateSheetId.equals("")) {estimateSheetId = null;}
		if(estimateDate.equals("")) {estimateDate = null;}
		if(deliveryInfo.equals("")) {deliveryInfo = null;}
		if(validDate.equals("")) {validDate = null;}
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
		if(updDate.equals("")) {updDate = null;}
		if(updUser.equals("")) {updUser = null;}

		con = super.getConnection();
	 	
	 	sql = EstimatePropertyUtil.getProperty("modifyEstimate"); //プロパティファイルから読み込み
	 	
	 	pstmt = con.prepareStatement(sql);
	 	
	 	pstmt.setString(1, estimateDate);
	 	pstmt.setString(2, deliveryInfo);
	 	pstmt.setString(3, validDate);
	 	pstmt.setString(4, title);
	 	pstmt.setString(5, deliveryName);
	 	pstmt.setString(6, estimateCondition);
	 	pstmt.setDouble(7, ctaxRate);
	 	pstmt.setString(8, submitName);
	 	pstmt.setString(9, submitPre);
	 	pstmt.setString(10, customerCode);
	 	pstmt.setString(11, customerName);
	 	pstmt.setString(12, customerRemarks);
	 	pstmt.setString(13, customerComment);
	 	pstmt.setString(14, remarks);
	 	pstmt.setString(15, memo);
	 	pstmt.setInt(16, retailPriceTotal);
	 	pstmt.setInt(17, ctaxPriceTotal);
	 	pstmt.setInt(18, estimateTotal);
	 	pstmt.setString(19, updDate);
	 	pstmt.setString(20, updUser);
	 	
	 	pstmt.setString(21, estimateSheetId);
	 	
	 	
			 	
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
	
	/* 見積削除 */
	public int deleteEstimate(String estimateSheetId) throws ClassNotFoundException, MissingResourceException, SQLException {
		Connection con;
		PreparedStatement pstmt= null;
	 	int result=0;
	 	String  sql;
	 	
	 	con = super.getConnection();
	 	
	 	sql = EstimatePropertyUtil.getProperty("deleteEstimate"); //プロパティファイルから読み込み
	 	
	 	pstmt = con.prepareStatement(sql);
	 	
	 	pstmt.setString(1, estimateSheetId);
	 	
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
	
	/* 見積商品情報削除 */
	public int deleteEstimateProduct(String estimateSheetId) throws ClassNotFoundException, MissingResourceException, SQLException {
		Connection con;
		PreparedStatement pstmt= null;
	 	int result=0;
	 	String  sql;
	 	
	 	con = super.getConnection();
	 	
	 	sql = EstimatePropertyUtil.getProperty("deleteEstimateProduct"); //プロパティファイルから読み込み
	 	
	 	pstmt = con.prepareStatement(sql);
	 	
	 	pstmt.setString(1, estimateSheetId);
	 	
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
}
