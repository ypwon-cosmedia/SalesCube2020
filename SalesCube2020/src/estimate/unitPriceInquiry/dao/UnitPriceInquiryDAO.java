/**
 * 
 */
package estimate.unitPriceInquiry.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.dao.BaseDAO;
import estimate.Input.beans.GetCustomerBean;
import estimate.unitPriceInquiry.beans.OrderStatementBean;
import estimate.unitPriceInquiry.beans.QuantitySlideSettingBean;
import estimate.unitPriceInquiry.beans.UnitPriceInquirySearchResultBean;
import master.customer.beans.DeliveryModifyBean;
import master.customer.beans.customerSearchBeans.CustomerInputBean;
import master.customer.beans.customerSearchBeans.CustomerResultBean;

/**
 * @author cosmedia
 *
 */
public class UnitPriceInquiryDAO extends BaseDAO {
	
	//単価照会(商品情報、割引情報)を取得
	public UnitPriceInquirySearchResultBean unitPriceInquirySearch(int productCode) throws SQLException, ClassNotFoundException {
		
		Connection con;
	 	Statement stmt=null;
	 	ResultSet result=null;
	 	String  sql;
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	sql="select " + 
	 			"PRODUCT_NAME,  " + 
	 			"RETAIL_PRICE,  " + 
	 			"PRODUCT_MST_XXXXX.REMARKS as PRODUCT_REMARKS,  " + 
	 			"DISCOUNT_ID,  " + 
	 			"DISCOUNT_NAME,  " + 
	 			"DISCOUNT_MST_XXXXX.REMARKS as DISCOUNT_REMARKS,  " + 
	 			"SUPPLIER_PCODE,  " + 
	 			"setType.CATEGORY_CODE_NAME as SET_TYPE_CATEGORY,  " + 
	 			"WAREHOUSE_NAME,  " + 
	 			"RACK_CODE,  " + 
	 			"status.CATEGORY_CODE_NAME as PRODUCT_STATUS_CATEGORY,  " + 
	 			"stock.CATEGORY_CODE_NAME as PRODUCT_STOCK_CATEGORY,  " + 
	 			"STOCK_QUANTITY,  " + 
	 			"QUANTITY_TOTAL " + 
	 		"from PRODUCT_MST_XXXXX  " + 
	 		"left outer join DISCOUNT_REL_XXXXX using(PRODUCT_CODE) " + 
	 		"left outer join DISCOUNT_MST_XXXXX using(DISCOUNT_ID)  " + 
	 		"left outer join (select * from CATEGORY_TRN_XXXXX where CATEGORY_ID='2')as setType " + 
	 			"on PRODUCT_MST_XXXXX.SET_TYPE_CATEGORY = setType.CATEGORY_CODE " + 
	 		"left outer join RACK_MST_XXXXX using(RACK_CODE) " + 
	 		"left outer join WAREHOUSE_MST_XXXXX using(WAREHOUSE_CODE) " + 
	 		"left outer join (select * from CATEGORY_TRN_XXXXX where CATEGORY_ID='16')as status " + 
	 			"on PRODUCT_MST_XXXXX.PRODUCT_STATUS_CATEGORY = status.CATEGORY_CODE " + 
	 		"left outer join (select * from CATEGORY_TRN_XXXXX where CATEGORY_ID='17')as stock " + 
	 			"on PRODUCT_MST_XXXXX.PRODUCT_STOCK_CATEGORY = stock.CATEGORY_CODE " + 
	 		"left outer join stock_mst_xxxxx using(PRODUCT_CODE) " + 
	 		"left outer join (select PRODUCT_CODE, sum(QUANTITY) as QUANTITY_TOTAL from RO_LINE_TRN_XXXXX GROUP BY PRODUCT_CODE)as quantityTotal " + 
	 			"on PRODUCT_MST_XXXXX.PRODUCT_CODE = quantityTotal.PRODUCT_CODE  " + 
	 		"where PRODUCT_MST_XXXXX.PRODUCT_CODE = " + productCode;
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	UnitPriceInquirySearchResultBean bean = new UnitPriceInquirySearchResultBean();
		
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
	 	
	 	super.releaseDB(con,stmt,result);
	 	
	 	return bean;
	}
	
	//数量スライド設定 取得
	public List<QuantitySlideSettingBean> GetQuantitySetting(int productCode) throws SQLException, ClassNotFoundException {
		
		Connection con;
	 	Statement stmt=null;
	 	ResultSet result=null;
	 	String  sql;
	 	
	 	List<QuantitySlideSettingBean> list = new ArrayList<> ();
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	sql="select " +
	 			"LINE_NO, " +
	 			"CONCAT( cast(IFNULL(DATA_FROM, '') as signed ), '～' ,  cast( IFNULL(DATA_TO, '') as signed) ) AS QUANTITY_DISCOUNT , " +
	 			"DISCOUNT_RATE " + 
	 		"from discount_trn_xxxxx  " + 
	 		"left outer join  discount_rel_xxxxx using(DISCOUNT_ID) " + 
	 		"where discount_rel_xxxxx.PRODUCT_CODE = " + productCode;

	 	
	 	result = stmt.executeQuery(sql);
		
	 	while(result.next()) {
		 	QuantitySlideSettingBean bean = new QuantitySlideSettingBean();
	 		bean.setLineNo(result.getString("LINE_NO"));
	 		bean.setDataFromTo(result.getString("QUANTITY_DISCOUNT"));
	 		bean.setDiscountRate(result.getDouble("DISCOUNT_RATE"));
	 		list.add(bean);
	 	}
	 	
	 	super.releaseDB(con,stmt,result);
	 	
	 	return list;
	}
	
	//受注残明細 取得
	public List<OrderStatementBean> GetOrderStatement(int productCode) throws SQLException, ClassNotFoundException {
		
		Connection con;
	 	Statement stmt=null;
	 	ResultSet result=null;
	 	String  sql;
	 	
	 	List<OrderStatementBean> list = new ArrayList<> ();
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	sql="select " + 
	 			"CONCAT(IFNULL(RO_SLIP_ID, '') , '-' ,  IFNULL(LINE_NO, '') ) as ORDER_NUMBER_LINE , " +
	 			"SHIP_DATE, " +
	 			"QUANTITY " + 
	 		"from RO_LINE_TRN_XXXXX " + 
	 		"left outer join RO_SLIP_TRN_XXXXX using(RO_SLIP_ID) " + 
	 		"where PRODUCT_CODE = " + productCode;

	 	
	 	result = stmt.executeQuery(sql);
		
	 	while(result.next()) {
	 		OrderStatementBean bean = new OrderStatementBean();
	 		bean.setOrderNoLine(result.getString("ORDER_NUMBER_LINE"));
	 		bean.setShipDate(result.getString("SHIP_DATE"));
	 		bean.setQuantity(result.getInt("QUANTITY"));
	 		list.add(bean);
	 	}
	 	
	 	super.releaseDB(con,stmt,result);
	 	
	 	return list;
	}
	
	
}
