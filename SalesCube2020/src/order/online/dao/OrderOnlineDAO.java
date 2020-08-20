package order.online.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.MissingResourceException;

import common.dao.BaseDAO;
import order.online.beans.OrderOnlineBillBean;
import order.online.beans.OrderOnlineDetailBean;
import sql.order.OrderSQL;

public class OrderOnlineDAO extends BaseDAO {

	public int onlineInputBill(OrderOnlineBillBean bean) throws SQLException, ClassNotFoundException, MissingResourceException {
		
		int roSlipId = 0;
		
		Connection con;
		Statement stmt = null;
		String sql = new OrderSQL().onlineInputBill(bean);
		
		con = super.getConnection();
		stmt = con.createStatement();
		
		stmt.executeUpdate(sql);
		
		con.commit();
		
		super.releaseDB(con, stmt);
		
		Connection con2;
		Statement stmt2 = null;
		String sql2 = new OrderSQL().endOfRoSlipId();
		ResultSet result = null;
	
		con = super.getConnection();
		stmt = con.createStatement();
		
		result = stmt.executeQuery(sql2);
		
		while(result.next()) {
			roSlipId = result.getInt("RO_SLIP_ID");
		}
		
		return roSlipId;
	}
	
	public void onlineInputDetail(OrderOnlineDetailBean bean) throws SQLException, ClassNotFoundException, MissingResourceException {
		
		Connection con;
		Statement stmt = null;
		String sql = new OrderSQL().onlineInputDetail(bean);
		
		con = super.getConnection();
		stmt = con.createStatement();
		
		stmt.executeUpdate(sql);
		
		con.commit();
		
		super.releaseDB(con, stmt);

	}
}
