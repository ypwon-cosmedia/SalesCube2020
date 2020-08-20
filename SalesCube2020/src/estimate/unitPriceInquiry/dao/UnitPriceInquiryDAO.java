/**
 * 
 */
package estimate.unitPriceInquiry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.dao.BaseDAO;
import estimate.Input.API.EstimatePropertyUtil;
import estimate.unitPriceInquiry.beans.OrderStatementBean;
import estimate.unitPriceInquiry.beans.QuantitySlideSettingBean;
import estimate.unitPriceInquiry.beans.UnitPriceInquirySearchResultBean;


public class UnitPriceInquiryDAO extends BaseDAO {
	
	//単価照会(商品情報、割引情報)を取得
	public UnitPriceInquirySearchResultBean unitPriceInquirySearch(String productCode) throws SQLException, ClassNotFoundException {
		
		Connection con;
		PreparedStatement pstmt= null;
	 	ResultSet result=null;
	 	String  sql;
	 	
	 	con = super.getConnection();
	 	
	 	sql = EstimatePropertyUtil.getProperty("unitPriceInquirySearch"); //プロパティファイルから読み込み
	 	
	 	pstmt = con.prepareStatement(sql);
	 	
	 	pstmt.setString(1, productCode);
	 	
	 	result = pstmt.executeQuery();
	 	
	 	UnitPriceInquirySearchResultBean bean = new UnitPriceInquirySearchResultBean();
		
	 	bean.setProductCode(productCode);
	 	
	 	if (result.next()) {
	 		bean.setProductName(result.getString("PRODUCT_NAME"));
	 		bean.setRetailPrice(result.getString("RETAIL_PRICE"));
	 		bean.setProductRemarks(result.getString("PRODUCT_REMARKS"));
	 		bean.setDiscountId(result.getString("DISCOUNT_ID"));
	 		bean.setDiscountName(result.getString("DISCOUNT_NAME"));
	 		bean.setDiscountRemarks(result.getString("DISCOUNT_REMARKS"));
	 		bean.setSupplierPCode(result.getString("SUPPLIER_PCODE"));
	 		bean.setSetTypeCategory(result.getString("SET_TYPE_CATEGORY"));
	 		bean.setWarehouseName(result.getString("WAREHOUSE_NAME"));
	 		bean.setRackCode(result.getString("RACK_CODE"));
	 		bean.setProductStatus(result.getString("PRODUCT_STATUS_CATEGORY"));
	 		bean.setProductStock(result.getString("PRODUCT_STOCK_CATEGORY"));
	 		bean.setStockQuantity(result.getString("STOCK_QUANTITY"));
	 		bean.setQuantityTotal(result.getString("QUANTITY_TOTAL"));
	 	}
	 	
	 	super.releaseDB(con,pstmt,result);
	 	
	 	return bean;
	}
	
	//数量スライド設定 取得
	public List<QuantitySlideSettingBean> getQuantitySetting(String productCode) throws SQLException, ClassNotFoundException {
		
		Connection con;
		PreparedStatement pstmt= null;
	 	ResultSet result=null;
	 	String  sql;
	 	
	 	List<QuantitySlideSettingBean> list = new ArrayList<> ();
	 	
	 	con = super.getConnection();
	 	
	 	sql = EstimatePropertyUtil.getProperty("getQuantitySetting"); //プロパティファイルから読み込み
	 	
	 	pstmt = con.prepareStatement(sql);
	 	
	 	pstmt.setString(1, productCode);
	 	
	 	result = pstmt.executeQuery();
		
	 	while(result.next()) {
		 	QuantitySlideSettingBean bean = new QuantitySlideSettingBean();
	 		bean.setLineNo(result.getString("LINE_NO"));
	 		bean.setDataFromTo(result.getString("QUANTITY_DISCOUNT"));
	 		bean.setDiscountRate(result.getDouble("DISCOUNT_RATE"));
	 		list.add(bean);
	 	}
	 	
	 	super.releaseDB(con,pstmt,result);
	 	
	 	return list;
	}
	
	//受注残明細 取得
	public List<OrderStatementBean> getOrderStatement(String productCode) throws SQLException, ClassNotFoundException {
		
		Connection con;
		PreparedStatement pstmt= null;
	 	ResultSet result=null;
	 	String  sql;
	 	
	 	List<OrderStatementBean> list = new ArrayList<> ();
	 	
	 	con = super.getConnection();
	 	
	 	sql = EstimatePropertyUtil.getProperty("getOrderStatement"); //プロパティファイルから読み込み

	 	pstmt = con.prepareStatement(sql);
	 	
	 	pstmt.setString(1, productCode);
	 	
	 	result = pstmt.executeQuery();
		
	 	while(result.next()) {
	 		OrderStatementBean bean = new OrderStatementBean();
	 		bean.setOrderNoLine(result.getString("ORDER_NUMBER_LINE"));
	 		bean.setShipDate(result.getString("SHIP_DATE"));
	 		bean.setQuantity(result.getInt("QUANTITY"));
	 		bean.setRoSlipId(result.getInt("RO_SLIP_ID"));
	 		list.add(bean);
	 	}
	 	
	 	super.releaseDB(con,pstmt,result);
	 	
	 	return list;
	}
}
