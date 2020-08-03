package order.common.init.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.dao.BaseDAO;
import order.common.init.beans.OrderInitBean;
import order.common.init.beans.OrderInitCategoryBean;
import sql.common.CommonSQL;
import sql.order.OrderSQL;

public class OrderInitDAO extends BaseDAO{
	
	public List<OrderInitBean> initComboBox(String categoryID) throws SQLException, ClassNotFoundException{
		
		List<OrderInitBean> list = new ArrayList<> ();
		
		CommonSQL sqllist = new CommonSQL();
		
		Connection con;
		Statement stmt = null;
		ResultSet result = null;
		
		con = super.getConnection();
		stmt = con.createStatement();

		String sql;
		
		sql = sqllist.initComboBox(categoryID);
		
		result = stmt.executeQuery(sql);
		
		while(result.next()) {
			OrderInitBean bean = new OrderInitBean();
			bean.setCategoryCode(result.getString("CATEGORY_CODE"));
			bean.setCategoryCode(result.getString("CATEGORY_CODE_NAME"));
			list.add(bean);
		}
		
		super.releaseDB(con,stmt,result);
		
		return list;
	}

	public List<OrderInitCategoryBean> initCategory() throws SQLException, ClassNotFoundException {
		
		List<OrderInitCategoryBean> list = new ArrayList<> ();
		
		OrderSQL sqllist = new OrderSQL();
		
		Connection con;
		Statement stmt = null;
		ResultSet result = null;
		
		con = super.getConnection();
		stmt = con.createStatement();

		String sql;
		
		sql = sqllist.initCategory();
		
		result = stmt.executeQuery(sql);
		
		while(result.next()) {
			OrderInitCategoryBean bean = new OrderInitCategoryBean();
			bean.setClassCode1(result.getString("CLASS_CODE_1"));
			bean.setClassCode2(result.getString("CLASS_CODE_2"));
			bean.setClassCode3(result.getString("CLASS_CODE_3"));
			bean.setClassName(result.getString("CLASS_NAME"));
			list.add(bean);
		}
		
		super.releaseDB(con,stmt,result);
		
		return list;
	}
}
