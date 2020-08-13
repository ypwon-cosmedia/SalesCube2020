package order.search.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import common.dao.BaseDAO;
import order.search.beans.OrderSearchBean;
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
	
	public List<String[]> orderSearch(OrderSearchBean bean, String[] inputlist, String rowCount, String sort, int currentPage, String orderBy) throws ClassNotFoundException, MissingResourceException, SQLException {
		
		Connection con;
		Statement stmt = null;
		ResultSet result = null;
		OrderSQL sqllist = new OrderSQL();

		String sql;
		
		con = super.getConnection();
		stmt = con.createStatement();
		
		if(bean.getSelectView().equals("伝票")) {
			List<String[]> resultlist = new ArrayList<String[]>();
			sql = sqllist.searchOrderBill(bean,inputlist,rowCount,sort, currentPage, orderBy);
			result = stmt.executeQuery(sql);
			while(result.next()) {
				String[] tmp = new String[inputlist.length];
				for(int i = 0; i<inputlist.length; i++) {
					tmp[i] = result.getString(i+1);
				}
				resultlist.add(tmp);
			}
			
			super.releaseDB(con, stmt, result);
			return resultlist;
		} else {
			List<String[]> resultlist = new ArrayList<String[]>();
			sql = sqllist.searchOrderDetail(bean,inputlist,rowCount,sort, currentPage, orderBy);
			System.out.println(sql);
			result = stmt.executeQuery(sql);
			while(result.next()) {
				String[] tmp = new String[inputlist.length];
				for(int i = 0; i<inputlist.length; i++) {
					tmp[i] = result.getString(i+1);
				}
				resultlist.add(tmp);
			}
			super.releaseDB(con, stmt, result);
			return resultlist;
		}
		
	}
	
	public int getBillCount(OrderSearchBean bean) throws ClassNotFoundException, MissingResourceException, SQLException {
		
		Connection con;
		Statement stmt = null;
		ResultSet result = null;
		OrderSQL sqllist = new OrderSQL();

		String sql;
		
		int tmp = 0;
		
		con = super.getConnection();
		stmt = con.createStatement();
		
		sql = sqllist.getOrderBillCount(bean);
		result = stmt.executeQuery(sql);
		while(result.next()) {
			tmp++;
		}
		
		super.releaseDB(con, stmt, result);
		return tmp;
		
	}
	
	public int getDetailCount(OrderSearchBean bean) throws ClassNotFoundException, MissingResourceException, SQLException {
		
		Connection con;
		Statement stmt = null;
		ResultSet result = null;
		OrderSQL sqllist = new OrderSQL();

		String sql;
		
		int tmp = 0;
		
		con = super.getConnection();
		stmt = con.createStatement();
		
		sql = sqllist.getOrderDetailCount(bean);
		result = stmt.executeQuery(sql);
		while(result.next()) {
			tmp++;
		}
		
		super.releaseDB(con, stmt, result);
		return tmp;
		
	}
}
