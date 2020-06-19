package master.product.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.dao.BaseDAO;
import master.product.beans.ProductDeleteBean;

public class ProductDeleteDAO extends BaseDAO {

	/* íœî•ñ‚Ìæ“¾@*/
	public String deleteProduct(ProductDeleteBean bean) throws SQLException, ClassNotFoundException{

		Connection con;
	 	PreparedStatement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;

	 	con = super.getConnection();
	 	sql = "DELETE * from product_mst_xxxxx WHERE PRODUCT_CODE = ?";	
	 	stmt = con.prepareStatement(sql);
	 	result = stmt.executeQuery(sql);
	 	stmt.setString(1, bean.getProductCode());

	 	super.releaseDB(con, stmt, result);
	 	
		return sql;

	}
	
}
