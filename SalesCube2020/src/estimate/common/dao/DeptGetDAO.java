package estimate.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.dao.BaseDAO;
import estimate.common.beans.GetDeptBean;

public class DeptGetDAO extends BaseDAO {
	
	//部門情報を取得する
	public  List<GetDeptBean> DeptGet() throws SQLException, ClassNotFoundException{
		
		List<GetDeptBean> list = new ArrayList<> ();
		
		Connection con;
	 	Statement stmt=null;
	 	ResultSet result=null;
	 	
	 	con = super.getConnection();
		stmt = con.createStatement();
		
	 	String  sql;
	 	
	 	sql = "SELECT "
	 			+ "DEPT_ID, "
	 			+ "NAME "
	 		+ "FROM "
	 			+ "DEPT_MST_XXXXX "
	 		+ "ORDER BY "
	 			+ "DEPT_ID ";
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	//SQL文の検索結果の出力
	 			while( result.next() ) {//部門情報をリストに登録
	 				GetDeptBean category = new GetDeptBean();
	 				category.setDeptId(result.getString("DEPT_ID"));
	 				category.setDeptName(result.getString("NAME"));
	 				
	 				list.add(category);	
	 			}
	 			super.releaseDB(con, stmt, result);//DBの開放
	 		 	return list;//GetDeptBean型のlistを戻り値として返す
	}
}
