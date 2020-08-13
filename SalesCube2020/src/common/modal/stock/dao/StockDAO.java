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
	 	
	 	StockBean bean = new StockBean();
	 	
	 	while(result.next()) {
	 		bean.setRoSlipId(result.getString("rltx.RO_SLIP_ID"));
		 	bean.setRoLineId(result.getString("rltx.LINE_NO"));
		 	bean.setShipDate(result.getString("rstx.SHIP_DATE"));
		 	list.add(bean);
	 	}
	 	
	 	super.releaseDB(con, stmt, result);
	 	
	 	return list;
	}
	
	/* 受注番号-行押下  編集画面に受注伝票反映 */
	public StockBean StockToOrder(String roSlipId) throws SQLException, ClassNotFoundException {
		
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
	 	
	 	bean.setRoSlipId(Integer.parseInt(result.getString("")));
	 	bean.setRoDate(result.getString(""));
	 	bean.setShipDate(result.getString(""));
	 	bean.setDeliveryDate(result.getString(""));
	 	bean.setDeliveryDate(deliveryDate);
	 	bean.setReceptNo(receptNo);
	 	bean.setCustomerSlipNo(customerSlipNo);
	 	bean.setUserName(userName);
	 	bean.setRemarks(remarks);
	 	bean.setDcName(dcName);
	 	bean.setDcTimezone(dcTimezone);
	 	bean.setCtaxRate(ctaxRate);
	 	bean.setCustomerCode(customerCode);
	 	bean.setCustomerName(customerName);
	 	bean.setTaxShiftCategory(taxShiftCategory);
	 	bean.setCutoffGroup(cutoffGroup);
	 	bean.setSalesCmCategory(salesCmCategory);
	 	bean.setCustomerRemarks(customerRemarks);
	 	bean.setCustomerCommentData(customerCommentData);
	 	bean.setDeliveryName(deliveryName);
	 	bean.setDeliveryOfficeName(deliveryOfficeName);
	 	bean.setDeliveryDeptName(deliveryDeptName);
	 	bean.setDeliveryZipCode(deliveryZipCode);
	 	bean.setDeliveryAddress1(deliveryAddress1);
	 	bean.setDeliveryAddress2(deliveryAddress2);
	 	bean.setDeliveryPcName(deliveryPcName);
	 	bean.setDeliveryPcKana(deliveryPcKana);
	 	bean.setDeliveryPcPre(deliveryPcPre);
	 	bean.setDeliveryTel(deliveryTel);
	 	bean.setDeliveryFax(deliveryFax);
	 	bean.setDeliveryEmail(deliveryEmail);
	 	bean.setProductCode(productCode);
	 	
	 	
	 	
	 	return bean;
	 	
	}
}
