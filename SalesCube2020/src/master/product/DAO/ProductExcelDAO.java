package master.product.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import common.dao.BaseDAO;

public class ProductExcelDAO extends BaseDAO {
	
	
	
	public void productExcelInput() {
		
		Connection con;
		Statement stmt = null;
		ResultSet result = null;	
		String  sql;
		
		con = super.getConnection();	
		stmt = con.createStatement();	
 	    sql = "";	
		result = stmt.executeQuery(sql);
		
	}
	
	public void productHistryOutput() {
		
		Connection con;
		Statement stmt = null;
		ResultSet result = null;	
		String  sql;
		
		con = super.getConnection();	
		stmt = con.createStatement();	
 	    sql = "";	
		result = stmt.executeQuery(sql);
		
	}

}
