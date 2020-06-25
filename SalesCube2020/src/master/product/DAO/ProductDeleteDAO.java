package master.product.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import common.dao.BaseDAO;

/* �폜�@*/
public class ProductDeleteDAO extends BaseDAO {

	public int deleteProduct(String productCode) throws SQLException, ClassNotFoundException{

		Connection con;
	 	Statement stmt = null;
	 	int result = 0;
	 	String sql;

	 	con = super.getConnection();
	 	stmt = con.createStatement();	 	
	 	sql = "DELETE FROM product_mst_xxxxx WHERE PRODUCT_CODE = '" + productCode + "'";	

	 	try {
	 		result = stmt.executeUpdate(sql);
	 		con.commit();
	 	}catch(SQLException e) {
	 		result = 1;
	 	}finally {
	 		super.releaseDB(con, stmt);	 		
	 	}
	 	
		return result;

	}
	
}
