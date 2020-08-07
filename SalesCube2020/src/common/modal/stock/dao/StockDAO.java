package common.modal.stock.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.dao.BaseDAO;
import common.modal.stock.beans.StockBean;
import sql.order.OrderSQL;

public class StockDAO extends BaseDAO {
	
	/* 受注入力画面から商品コードをもとに商品在庫モーダルの初期値設定 */
	public StockBean OrderToStock(String productCode) throws SQLException, ClassNotFoundException {
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result1 = null;	
	 	ResultSet result2 = null;	
	 	String  sql1;
	 	String  sql2;
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	sql1 = ordersql.StockInfoShow(productCode);
	 	sql2 = ordersql.StockDetailShow(productCode);
	 	
	 	result1 = stmt.executeQuery(sql1);
	 	result2 = stmt.executeQuery(sql2);
	 	
	 	StockBean bean = new StockBean();
	 	bean.setProductCode(result1.getString("pmx.PRODUCT_CODE"));
	 	bean.setSupplierPCode(result1.getString("pmx.SUPPLIER_PCODE"));
	 	bean.setSetTypeCategory(result1.getString("b.CATEGORY_CODE_NAME"));
	 	bean.setProductName(result1.getString("pmx.PRODUCT_NAME"));
	 	bean.setWarehouseName(result1.getString("a.WAREHOUSE_NAME"));
	 	bean.setRackCode(result1.getString("a.RACK_CODE"));
	 	bean.setProductStatusCategory(result1.getString("c.CATEGORY_CODE_NAME"));
	 	bean.setProductStockCategory(result1.getString("d.CATEGORY_CODE_NAME"));
	 	bean.setStockQuantity(result1.getString("smx.STOCK_QUANTITY"));
	 	bean.setQuantity(result1.getString("SUM(rltx.QUANTITY)"));
	 	bean.setRoSlipId(result2.getString("rltx.RO_SLIP_ID"));
	 	bean.setRoLineId(result2.getString("rltx.LINE_NO"));
	 	bean.setShipDate(result2.getString("rstx.SHIP_DATE"));
	 	
	 	return bean;
	 	
	}

 	
}
