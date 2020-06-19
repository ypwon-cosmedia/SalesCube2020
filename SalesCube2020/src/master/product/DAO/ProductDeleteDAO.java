package master.product.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.MissingResourceException;

import common.dao.BaseDAO;
import master.product.beans.ProductDeleteBean;

/* çÌèúÅ@*/
public class ProductDeleteDAO extends BaseDAO {

	public String deleteProduct(ProductDeleteBean bean, String productCode) throws SQLException, ClassNotFoundException{

		Connection con;
	 	Statement stmt = null;
	 	String  sql;

	 	con = super.getConnection();
	 	sql = "DELETE * from product_mst_xxxxx WHERE PRODUCT_CODE = " + productCode;	
	 	stmt = con.createStatement();
	 	stmt.executeUpdate(sql);

	 	super.releaseDB(con, stmt);
	 	
		return sql;

	}
	
}
