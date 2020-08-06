package estimate.Search.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.MissingResourceException;

import common.dao.BaseDAO;
import sql.common.CommonSQL;

public class EstimateSearchDAO extends BaseDAO {
	public void configUpdate(String[] showlistname, String[] showlistvalue, String[] notshowlistname,
			String[] notshowlistvalue, String searchsubject) throws ClassNotFoundException, MissingResourceException, SQLException {
		// TODO Auto-generated method stub
		
		CommonSQL sqllist = new CommonSQL();
		
		Connection con;
		Statement stmt = null;
		ResultSet result = null;
		
		con = super.getConnection();
		stmt = con.createStatement();

		String sql;
	}
}

