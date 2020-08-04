package order.input.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.MissingResourceException;

import common.dao.BaseDAO;
import sql.order.OrderSQL;

public class OrderInputDAO extends BaseDAO{
	
	/**/
	public OrderInputDAO orderInput() throws SQLException, MissingResourceException, ClassNotFoundException{
	
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String sql;
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	
	 	
	 	result = stmt.executeUpdate(sql);
	 	
		return null;		
	 	
	}
	
	/* 受注番号押下 */
	public OrderInputDAO orderUpdate() throws SQLException, MissingResourceException, ClassNotFoundException{
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String sql;
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	
		return null;
	 	
	}
}
