package common.modal.stock.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.dao.BaseDAO;
import common.modal.stock.beans.StockBean;
import order.input.beans.OrderInputBean;
import sql.order.OrderSQL;

public class StockDAO extends BaseDAO {

	/* 受注入力画面から商品コードをもとに商品在庫モーダルの初期値設定 */
	public StockBean OrderToStock(String productCode) throws SQLException, ClassNotFoundException {
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;
	 	String  sql;
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.StockInfoShow(productCode);
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	StockBean bean = new StockBean();
	 	
	 	while(result.next()) {
	 		bean.setProductCode(result.getString("pmx.PRODUCT_CODE"));
		 	bean.setSupplierPCode(result.getString("pmx.SUPPLIER_PCODE"));
		 	bean.setSetTypeCategory(result.getString("b.CATEGORY_CODE_NAME"));
		 	bean.setProductName(result.getString("pmx.PRODUCT_NAME"));
		 	bean.setWarehouseName(result.getString("a.WAREHOUSE_NAME"));
		 	bean.setRackCode(result.getString("a.RACK_CODE"));
		 	bean.setProductStatusCategory(result.getString("c.CATEGORY_CODE_NAME"));
		 	bean.setProductStockCategory(result.getString("d.CATEGORY_CODE_NAME"));
		 	bean.setStockQuantity(result.getString("smx.STOCK_QUANTITY"));
		 	bean.setQuantity(result.getString("SUM(rltx.QUANTITY)"));
	 	}
	 	
	 	
	 	super.releaseDB(con, stmt, result);
	 	
	 	return bean;
	 	
	}

	/* 受注入力画面から商品コードをもとに商品在庫モーダルの初期値設定 明細 */
	public List<StockBean> OrderToStockDetail(String productCode) throws SQLException, ClassNotFoundException {
		
		List<StockBean> list = new ArrayList<>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;
	 	String  sql;
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.StockDetailShow(productCode);
	 	
	 	result = stmt.executeQuery(sql);
	 		 	
	 	while(result.next()) {
	 		StockBean bean = new StockBean();
	 		bean.setRoSlipId(result.getString("id"));
		 	bean.setShipDate(result.getString("SHIP_DATE"));
		 	bean.setQuantity(result.getString("QUANTITY"));
		 	list.add(bean);
	 	}
	 	
	 	super.releaseDB(con, stmt, result);
	 	
	 	return list;
	}
	
	/* 受注番号-行押下  編集画面へ */
	public OrderInputBean StockToOrder(Integer roSlipId) throws SQLException, ClassNotFoundException {
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;
	 	String  sql;
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.linkUpdateOrder(roSlipId);
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	OrderInputBean bean = new OrderInputBean();
	 	
	 	bean.setRoSlipId(Integer.parseInt(result.getString("RO_SLIP_ID")));
	 	bean.setRoDate(result.getString("RO_DATE"));
	 	bean.setShipDate(result.getString("SHIP_DATE"));
	 	bean.setDeliveryDate(result.getString("DELIVERY_DATE"));
	 	bean.setReceptNo(result.getString("RECEPT_NO"));
	 	bean.setCustomerSlipNo(result.getString("CUSTOMER_SLIP_NO"));
	 	bean.setUserName(result.getString("USER_NAME"));
	 	bean.setRemarks(result.getString("REMARKS"));
	 	bean.setDcName(result.getString("DC_NAME"));
	 	bean.setDcTimezone(result.getString("DC_TIMEZONE"));
	 	bean.setCtaxRate(result.getString("CTAX_RATE"));
	 	bean.setCustomerCode(result.getString("rstx.CUSTOMER_CODE"));
	 	bean.setCustomerName(result.getString("rstx.CUSTOMER_NAME"));
	 	bean.setTaxShiftCategory(result.getString("a.CATEGORY_CODE_NAME"));
	 	bean.setCutoffGroup(result.getString("b.CATEGORY_CODE_NAME"));
	 	bean.setSalesCmCategory(result.getString("c.CATEGORY_CODE_NAME"));
	 	bean.setCustomerRemarks(result.getString("rstx.CUSTOMER_REMARKS"));
	 	bean.setCustomerCommentData(result.getString("rstx.CUSTOMER_COMMENT_DATA"));
	 	bean.setDeliveryName(result.getString("DELIVERY_NAME"));
	 	bean.setDeliveryOfficeName(result.getString("DELIVERY_OFFICE_NAME"));
	 	bean.setDeliveryDeptName(result.getString("DELIVERY_DEPT_NAME"));
	 	bean.setDeliveryZipCode(result.getString("DELIVERY_ZIP_CODE"));
	 	bean.setDeliveryAddress1(result.getString("DELIVERY_ADDRESS_1"));
	 	bean.setDeliveryAddress2(result.getString("DELIVERY_ADDRESS_2"));
	 	bean.setDeliveryPcName(result.getString("DELIVERY_PC_NAME"));
	 	bean.setDeliveryPcKana(result.getString("DELIVERY_PC_KANA"));
	 	bean.setDeliveryPcPre(result.getString("DELIVERY_PC_PRE"));
	 	bean.setDeliveryTel(result.getString("DELIVERY_TEL"));
	 	bean.setDeliveryFax(result.getString("DELIVERY_FAX"));
	 	bean.setDeliveryEmail(result.getString("DELIVERY_EMAIL"));
	 	bean.setProductCode(result.getString("DELIVERY_ZIP_CODE"));
	 	bean.setProductRemarks(result.getString("DELIVERY_ZIP_CODE"));
	 	bean.setRackCode(result.getString("rltx.PRODUCT_CODE"));
	 	bean.setQuantity(Integer.parseInt(result.getString("pmx.PRODUCT_NAME")));
	 	bean.setUnitCost(Integer.parseInt(result.getString("rltx.PRODUCT_REMARKS")));
	 	bean.setCost(Integer.parseInt(result.getString("pmx.RACK_CODE")));
	 	bean.setUnitRetailPrice(Integer.parseInt(result.getString("rltx.QUANTITY")));
	 	bean.setRetailPrice(Integer.parseInt(result.getString("rltx.UNIT_COST")));
	 	bean.setInputProductRemarks(result.getString("rltx.COST"));
	 	bean.setEadRemarks(result.getString("rltx.UNIT_RETAIL_PRICE"));
	 	bean.setProssProfit(Integer.parseInt(result.getString("rltx.RETAIL_PRICE")));
	 	bean.setGrossProfitRatio(Integer.parseInt(result.getString("rltx.PRODUCT_ABSTRACT")));
	 	bean.setRetailPriceTotal(Integer.parseInt(result.getString("rltx.EAD_REMARKS")));
	 	bean.setRetailPriceTotal(Integer.parseInt(result.getString("rstn.RETAIL_PRICE_TOTAL")));
	 	bean.setCtaxPriceTotal(Integer.parseInt(result.getString("rstn.CTAX_PRICE_TOTAL")));
	 	bean.setPriceTotal(Integer.parseInt(result.getString("rstn.PRICE_TOTAL")));
	 	
	 	super.releaseDB(con, stmt, result);
	 	
	 	return bean;
	 	
	}
}
