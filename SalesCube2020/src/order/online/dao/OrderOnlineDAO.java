package order.online.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import common.dao.BaseDAO;
import order.online.beans.OrderOnlineBillBean;
import order.online.beans.OrderOnlineDetailBean;
import order.online.beans.OrderOnlineResultBean;
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
		
		String sql2 = new OrderSQL().endOfRoSlipId();
		ResultSet result = null;
	
		con = super.getConnection();
		stmt = con.createStatement();
		
		result = stmt.executeQuery(sql2);
		
		while(result.next()) {
			roSlipId = result.getInt("RO_SLIP_ID");
		}
		
		super.releaseDB(con, stmt);
		
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
	
	public void onlineInputTotal(String roSlipId) throws SQLException, ClassNotFoundException, MissingResourceException {
		
		Connection con;
		Statement stmt = null;
		String sql = new OrderSQL().onlineInputTotal(roSlipId);
		
		con = super.getConnection();
		stmt = con.createStatement();
		
		stmt.executeUpdate(sql);
		
		con.commit();
		
		super.releaseDB(con, stmt);

	}
	
	public List<OrderOnlineResultBean> onlineInputResult(String roSlipId) throws SQLException, ClassNotFoundException, MissingResourceException {
		
		List<OrderOnlineResultBean> list = new ArrayList<OrderOnlineResultBean>();
		
		Connection con = null;
		Statement stmt = null;
		String sql2 = new OrderSQL().OrderInputResult(roSlipId);
		ResultSet result = null;
	
		con = super.getConnection();
		stmt = con.createStatement();
		
		result = stmt.executeQuery(sql2);
		
		while(result.next()) {
			OrderOnlineResultBean bean = new OrderOnlineResultBean();
			bean.setRoSlipId(result.getInt("ro_slip_id"));
			bean.setCustomerName(result.getString("customer_name"));
			bean.setRoDate(result.getDate("ro_date"));
			list.add(bean);
		}
		
		super.releaseDB(con, stmt);
		
		return list;
	}
}
