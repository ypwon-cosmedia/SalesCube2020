package master.product.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import common.dao.BaseDAO;
import master.product.beans.ProductSearchBean;
import master.product.beans.ProductModifyBean;
import master.product.beans.QuantityDiscountBean;

public class MoveModifyProductDAO extends BaseDAO {

	public List<ProductModifyBean> moveModifyProduct(String productCode) throws SQLException, MissingResourceException, ClassNotFoundException{

		List<ProductModifyBean> list = new ArrayList<ProductModifyBean>();
	
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String sql;
	 		
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	sql = "SELECT DISTINCT "
	 			+ "A.PRODUCT_CODE, "
	 			+ "A.PRODUCT_NAME, "
	 			+ "A.PRODUCT_KANA, "
	 			+ "A.ONLINE_PCODE, "
	 			+ "A.JAN_PCODE, "
	 			+ "A.DISCARD_DATE, "
	 			+ "A.SUPPLIER_CODE, "
	 			+ "B.SUPPLIER_NAME, "
	 			+ "A.SUPPLIER_PCODE, "
	 			+ "A.SUPPLIER_PRICE_YEN, "
	 			+ "A.SUPPLIER_PRICE_DOL, "
	 			+ "A.STOCK_CTL_CATEGORY, "
	 			+ "A.PACK_QUANTITY, "
	 			+ "A.AVG_SHIP_COUNT, "
	 			+ "D.WAREHOUSE_NAME, "
	 			+ "A.RACK_CODE, "
	 			+ "A.LEAD_TIME, "
	 			+ "A.PO_NUM, "
	 			+ "A.MINE_SAFETY_STOCK_UPD_FLAG, "
	 			+ "A.PO_LOT, "
	 			+ "A.MAX_STOCK_NUM, "
	 			+ "A.MAX_PO_NUM, "
	 			+ "A.RO_MAX_NUM, "
	 			+ "A.RETAIL_PRICE, "
	 			+ "E.DISCOUNT_ID "
	 			+ "FROM "
	 			+ "product_mst_xxxxx A "
	 			+ "LEFT OUTER JOIN (select SUPPLIER_CODE, SUPPLIER_NAME from supplier_mst_xxxxx) B ON A.SUPPLIER_CODE = B.SUPPLIER_CODE "
	 			+ "LEFT OUTER JOIN (select WAREHOUSE_CODE, RACK_CODE from rack_mst_xxxxx) C ON A.RACK_CODE = C.RACK_CODE "
	 			+ "LEFT OUTER JOIN (select WAREHOUSE_CODE, WAREHOUSE_NAME from warehouse_mst_xxxxx) D ON C.WAREHOUSE_CODE = D.WAREHOUSE_CODE "
	 			+ "LEFT OUTER JOIN (select PRODUCT_CODE, DISCOUNT_ID from discount_rel_xxxxx) E ON A.PRODUCT_CODE = E.PRODUCT_CODE"
	 			+ " WHERE"
	 			+ " A.PRODUCT_CODE = '" + productCode + "'";
	 	result = stmt.executeQuery(sql);	
	 	
	 	while (result.next()) {
	 		ProductModifyBean bean = new ProductModifyBean();
	 		bean.setProductCode(result.getString("PRODUCT_CODE"));
	 		bean.setProductName(result.getString("PRODUCT_NAME"));
	 		bean.setProductKana(result.getString("PRODUCT_KANA"));
	 		bean.setOnlinePcode(result.getString("ONLINE_PCODE"));
	 		bean.setJanPcode(result.getString("JAN_PCODE"));
	 		bean.setDiscardDate(result.getDate("DISCARD_DATE"));
	 		bean.setSupplierCode(result.getString("SUPPLIER_CODE"));
	 		bean.setSupplierName(result.getString("SUPPLIER_NAME"));
	 		bean.setSupplierPcode(result.getString("SUPPLIER_PCODE"));
	 		bean.setSupplierPriceYen(result.getInt("SUPPLIER_PRICE_YEN"));
	 		bean.setSupplierPriceDol(result.getInt("SUPPLIER_PRICE_DOL"));
	 		bean.setStockCtlCategory(result.getString("STOCK_CTL_CATEGORY"));
	 		bean.setPackQuantity(result.getInt("PACK_QUANTITY"));
	 		bean.setAvgShipCount(result.getInt("AVG_SHIP_COUNT"));
	 		bean.setWarehouseName(result.getString("WAREHOUSE_NAME"));
	 		bean.setRackCode(result.getString("RACK_CODE"));
	 		bean.setLeadTime(result.getInt("LEAD_TIME"));
	 		bean.setPoNum(result.getInt("PO_NUM"));
	 		bean.setMineSafetyStockUpdFlag(result.getShort("MINE_SAFETY_STOCK_UPD_FLAG"));
	 		bean.setPoLot(result.getInt("PO_LOT"));
	 		bean.setMaxStockNum(result.getInt("MAX_STOCK_NUM"));
	 		bean.setMaxPoNum(result.getInt("MAX_PO_NUM"));
	 		bean.setRoMaxNum(result.getShort("RO_MAX_NUM"));
	 		bean.setRetailPrice(result.getInt("RETAIL_PRICE"));
	 		bean.setDiscountId(result.getString("DISCOUNT_ID"));
	 	
	 		list.add(bean);
	 	}

	 	super.releaseDB(con, stmt, result);
		return list;
	
	}
	
	public List<ProductModifyBean> moveModifyCategory(String productCode) throws SQLException, MissingResourceException, ClassNotFoundException{

		List<ProductModifyBean> list = new ArrayList<ProductModifyBean>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String sql;
	 		
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	sql = "SELECT"
	 			+ " PRODUCT_STATUS_CATEGORY,"
	 			+ " PRODUCT_STOCK_CATEGORY,"
	 			+ " PRODUCT_PURVAY_CATEGORY,"
	 			+ " PRODUCT_STANDARD_CATEGORY,"
	 			+ " SO_RATE,"
	 			+ " SET_TYPE_CATEGORY,"
	 			+ " PRODUCT_1,"
	 			+ " PRODUCT_2,"
	 			+ " PRODUCT_3"
	 			+ " FROM"
	 			+ " product_mst_xxxxx"
	 			+ " WHERE"
	 			+ " PRODUCT_CODE = '" + productCode + "'";
	 	result = stmt.executeQuery(sql);

	 	while (result.next()) {
	 		ProductModifyBean bean = new ProductModifyBean();
	 		bean.setProductStatusCategory(result.getString("PRODUCT_STATUS_CATEGORY"));
	 		bean.setProductStockCategory(result.getString("PRODUCT_STOCK_CATEGORY"));
	 		bean.setProductPurvayCategory(result.getString("PRODUCT_PURVAY_CATEGORY"));
	 		bean.setSoRate(result.getInt("SO_RATE"));
	 		bean.setSetTypeCategory(result.getString("SET_TYPE_CATEGORY"));
	 		bean.setProduct1(result.getString("PRODUCT_1"));
	 		bean.setProduct2(result.getString("PRODUCT_2"));
	 		bean.setProduct3(result.getString("PRODUCT_3"));
	 	
	 		list.add(bean);
	 	}
	 	
	 	super.releaseDB(con, stmt, result);
		return list;
	 	
	}
	
	public List<ProductModifyBean> moveModifyTokuseiCategory(String productCode) throws SQLException, MissingResourceException, ClassNotFoundException{

		List<ProductModifyBean> list = new ArrayList<ProductModifyBean>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String sql;
	 		
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	sql = "SELECT "
				+ "UNIT_CATEGORY, "
				+ "WEIGHT, "
				+ "WEIGHT_UNIT_SIZE_CATEGORY, "
				+ "LENGTH, "
				+ "LENGTH_UNIT_SIZE_CATEGORY, "
				+ "WIDTH, "
				+ "WIDTH_UNIT_SIZE_CATEGORY, "
				+ "DEPTH, "
				+ "DEPTH_UNIT_SIZE_CATEGORY, "
				+ "HEIGHT, "
				+ "HEIGHT_UNIT_SIZE_CATEGORY, "
				+ "CORE_NUM "
				+ "FROM "
				+ "product_mst_xxxxx "
				+ "WHERE "
				+ "PRODUCT_CODE = '" + productCode + "'";
	 	result = stmt.executeQuery(sql);
	 	
	 	while (result.next()) {
	 		ProductModifyBean bean = new ProductModifyBean();
	 		bean.setUnitCategory(result.getString("UNIT_CATEGORY"));
	 		bean.setWeight(result.getDouble("WEIGHT"));
	 		bean.setWeightUnitSizeCategory(result.getString("WEIGHT_UNIT_SIZE_CATEGORY"));
	 		bean.setLength(result.getDouble("LENGTH"));
	 		bean.setLengthUnitSizeCategory(result.getString("LENGTH_UNIT_SIZE_CATEGORY"));
	 		bean.setWidth(result.getDouble("WIDTH"));
	 		bean.setWidthUnitSizeCategory(result.getString("WIDTH_UNIT_SIZE_CATEGORY"));
	 		bean.setDepth(result.getDouble("DEPTH"));
	 		bean.setDepthUnitSizeCategory(result.getString("DEPTH_UNIT_SIZE_CATEGORY"));
	 		bean.setHeight(result.getDouble("HEIGHT"));
	 		bean.setHeightUnitSizeCategory(result.getString("HEIGHT_UNIT_SIZE_CATEGORY"));
	 		bean.setCoreNum(result.getString("CORE_NUM"));
	 	
	 		list.add(bean);
	 	}
	 	super.releaseDB(con, stmt, result);
		return list;

	}

	public List<ProductModifyBean> moveModifyRemarks(String productCode) throws SQLException, MissingResourceException, ClassNotFoundException{

			List<ProductModifyBean> list = new ArrayList<ProductModifyBean>();
		
			Connection con;
		 	Statement stmt = null;
		 	ResultSet result = null;	
		 	String sql;
		 		
		 	con = super.getConnection();	
		 	stmt = con.createStatement();
		 	sql = "SELECT "
		 			+ "REMARKS, " 
		 			+ "EAD_REMARKS, " 
		 			+ "COMMENT_DATA "
		 			+ "FROM "
		 			+ "product_mst_xxxxx "
		 			+ "WHERE "
		 			+ "PRODUCT_CODE = '" + productCode + "'";
		 	result = stmt.executeQuery(sql);
		 	
		 	while (result.next()) {
		 		ProductModifyBean bean = new ProductModifyBean();
		 		bean.setRemarks(result.getString("REMARKS"));
		 		bean.setEadRemarks(result.getString("EAD_REMARKS"));
		 		bean.setCommentData(result.getString("COMMENT_DATA"));
		 	
		 		list.add(bean);
		 	}
		 	
		 	super.releaseDB(con, stmt, result);
			return list;

	}
	
}
