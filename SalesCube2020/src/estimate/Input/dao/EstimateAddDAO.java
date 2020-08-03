package estimate.Input.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import estimate.Input.beans.EstimateAddBean;


public class EstimateAddDAO {
	
}
	public int addEstimate(EstimateAddBean bean) throws SQLException, ClassNotFoundException {
		
		Connection con;
		Statement stmt= null;
	 	int result=0;	
	 	String  sql;
	 	
	 	//変数宣言
	 	String customerCode  = bean.getCustomerCode();
	 	
	 	//nullの場合の処理
		if(cutoffGroup==null || cutoffGroup.equals("")) {
			cutoffGroupSQL = null;
		} else {
			cutoffGroupSQL = "'" + cutoffGroup + "'";
		}
		
		con = super.getConnection();
	 	stmt = con.createStatement();
	 	//見積登録をするSQL
	 	sql = "UPDATE customer_mst_xxxxx SET " ；
	 	
		try {
			result = stmt.executeUpdate(sql);
			con.commit();
		} catch (SQLException e) {
			result = 999;
			e.printStackTrace();
		} finally {
			super.releaseDB(con,stmt);
		}
		
		return result;
		
	}

	 			
}
