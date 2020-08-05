package order.search.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.MissingResourceException;

import common.dao.BaseDAO;
import sql.order.OrderSQL;

public class OrderSearchDAO extends BaseDAO{


	public void configUpdate(String[] showlistvalue, 
			String searchsubject, String userID) throws ClassNotFoundException, MissingResourceException, SQLException {
		// TODO Auto-generated method stub
		
		Connection con;
		Statement stmt = null;
		OrderSQL sqllist = new OrderSQL();		
		String flag;
		
		if(searchsubject.equals("伝票"))
			flag = "1";
		else
			flag = "2";
		
		con = super.getConnection();
		stmt = con.createStatement();

		String sql = sqllist.deleteConfigModal("0301", flag, userID);
		stmt.executeUpdate(sql);
		con.commit();
		for(int i = 0; i<showlistvalue.length; i++) {
			String sql2 = sqllist.insertConfigModal("0301", flag, userID, i+1, showlistvalue[i]);
			stmt.executeUpdate(sql2);
		}
		
		con.commit();
		con.close();
		stmt.close();		
	}
}
