package master.product.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.dao.BaseDAO;
import master.product.beans.ProductSearchBean;


public class ProductSearchDAO extends BaseDAO{
	
	/* 商品検索情報の取得 */
	public List<ProductSearchBean> searchProduct() throws SQLException, ClassNotFoundException {

		List<ProductSearchBean> list = new ArrayList<ProductSearchBean>();

		Connection con;
	 	PreparedStatement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;

	 	con = super.getConnection();	
	 	sql = "SELECT pmx.PRODUCT_CODE, pmx.PRODUCT_NAME, A.SUPPLIER_NAME, B.CLASS_NAME, pmx.REMARKS FROM product_mst_xxxxx pmx "
	 			+ "LEFT OUTER JOIN (SELECT SUPPLIER_CODE ,SUPPLIER_NAME FROM supplier_mst_xxxxx AS smx) A on pmx.SUPPLIER_CODE = A.SUPPLIER_CODE "
	 			+ "LEFT OUTER JOIN (SELECT pcm.CLASS_CODE_1, pcm.CLASS_CODE_2, pcm.CLASS_NAME FROM product_class_mst_xxxxx pcm, product_mst_xxxxx pmx) B ON pmx.PRODUCT_1 = B.CLASS_CODE_1 AND CLASS_CODE_2 ='' "
	 			+ "WHERE pmx.PRODUCT_CODE = ? AND pmx.PRODUCT_NAME = ? AND pmx.PRODUCT_KANA = ? AND pmx.SUPPLIER_CODE = ? smx.SUPPLIER_NAME = ? pmx.PRODUCT_STANDARD_CATEGORY = ? AND pmx.PRODUCT_STATUS_CATEGORY = ? AND pmx.PRODUCT_STOCK_CATEGORY = ? AND pmx.SET_TYPE_CATEGORY = ? AND pmx.REMARKS = ? AND pmx.PRODUCT_1 = ? AND pmx.PRODUCT_2 = ? AND pmx.PRODUCT_3 = ? "
	 			+ "GROUP BY pmx.PRODUCT_CODE ORDER BY pmx.PRODUCT_CODE";
	 	result = stmt.executeQuery(sql);
	 	
	 	while (result.next()) {
	 		//1レコードずつItemBeanセットする
	 		ProductSearchBean bean = new ProductSearchBean();
	 		stmt.setString(1, bean.getProductCode());
	 		stmt.setString(2, bean.getProductName());
	 		stmt.setString(3, bean.getProductKana());
	 		stmt.setString(4, bean.getSupplierCode());
	 		stmt.setString(5, bean.getSupplierName());
	 		stmt.setString(6, bean.getProductStandardCategory());
	 		stmt.setString(7, bean.getProductStatusCategory());
	 		stmt.setString(8, bean.getProductStockCategory());
	 		stmt.setInt(9, bean.getSetTypeCategory());
	 		stmt.setString(10, bean.getRemarks());
	 		stmt.setString(11, bean.getProduct1());
	 		stmt.setString(12, bean.getProduct2());
	 		stmt.setString(13, bean.getProduct3());
	 		list.add(bean);
	 	}
	 	super.releaseDB(con, stmt, result);
	 	
		return list;
	}

}
