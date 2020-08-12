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
	 	ResultSet result = null;
	 	String  sql1;
	 	String  sql2;
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	sql1 = ordersql.StockInfoShow(productCode);
	 	sql2 = ordersql.StockDetailShow(productCode);
	 	
	 	result = stmt.executeQuery(sql1);
	 	
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
	 	
	 	result = stmt.executeQuery(sql2);
	 	
	 	bean.setRoSlipId(result.getString("rltx.RO_SLIP_ID"));
	 	bean.setRoLineId(result.getString("rltx.LINE_NO"));
	 	bean.setShipDate(result.getString("rstx.SHIP_DATE"));
	 	
	 	super.releaseDB(con, stmt, result);
	 	
	 	return bean;
	 	
	}

 	
}
