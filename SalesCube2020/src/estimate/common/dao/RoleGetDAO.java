package estimate.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.dao.BaseDAO;
import estimate.common.beans.GetRoleBean;

public class RoleGetDAO extends BaseDAO{
	
	//権限情報を取得する
	public List<GetRoleBean> RoleGet() throws SQLException, ClassNotFoundException{
		
		List<GetRoleBean> list = new ArrayList<> ();
		
		Connection con;
	 	Statement stmt=null;
	 	ResultSet result=null;
	 	
	 	con = super.getConnection();
		stmt = con.createStatement();
		
		String sql;
		
		sql ="SELECT "
				+ "ROLE_ID, "
				+ "NAME "
			+ "FROM "
				+ "ROLE_MST_XXXXX "
			+ "ORDER BY "
 				+ "ROLE_ID ";
		
		result = stmt.executeQuery(sql);
		
		//SQL文の検索結果の出力
		while( result.next() ) {//権限情報をリストに登録
				GetRoleBean category = new GetRoleBean();
				category.setRoleId(result.getString("ROLE_ID"));
				category.setRoleName(result.getString("NAME"));
				
				list.add(category);	
			}
			super.releaseDB(con, stmt, result);//DBの開放
		 	return list;//GetRoleBean型のlistを戻り値として返す
	}
}
