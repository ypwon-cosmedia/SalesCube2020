package master.product.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import common.dao.BaseDAO;

/* çÌèúÅ@*/
public class ProductDeleteDAO extends BaseDAO {

	public int deleteProduct(String productCode) throws SQLException, ClassNotFoundException{

		Connection con;
	 	Statement stmt = null;
	 	int result = 0;
	 	String sql;
	 	String check = "0";

	 	con = super.getConnection();
	 	sql = "DELETE * from product_mst_xxxxx WHERE PRODUCT_CODE = " + productCode;	
	 	stmt = con.createStatement();
	 	
	 	try {
	 		result = stmt.executeUpdate(sql);
	 		con.commit();
	 	}catch(SQLException e) {
	 		check = "1";
	 	}finally {
	 		super.releaseDB(con, stmt);	 		
	 	}
	 	
		return result;

	}
	
}
