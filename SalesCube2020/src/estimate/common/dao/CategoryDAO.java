package estimate.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.dao.BaseDAO;
import estimate.common.beans.CategoryBean;

public class CategoryDAO extends BaseDAO{
	public  List<CategoryBean> CategoryGet(int categoryId) throws SQLException, ClassNotFoundException{
		
		List<CategoryBean> list = new ArrayList<> ();
		
		Connection con;
		Statement stmt = null;
		ResultSet result = null;
		
		con = super.getConnection();
		stmt = con.createStatement();

		String sql;

		sql = "SELECT "
					+ "CATEGORY_CODE, "
					+ "CATEGORY_CODE_NAME "
				+ "FROM "
					+ "CATEGORY_TRN_XXXXX "
				+ "WHERE "
					+ "CATEGORY_ID='"
					+ categoryId
				+ "' ORDER BY "
					+ "CATEGORY_CODE";
		
		result = stmt.executeQuery(sql);
		
		//SQL文の検索結果の出力
		while( result.next() ) {//区分情報をリストに登録
			CategoryBean category = new CategoryBean();
			category.setCategoryCode(result.getString("CATEGORY_CODE"));
			category.setCategoryCodeName(result.getString("CATEGORY_CODE_NAME"));
	 		
	 		list.add(category);
	 	}
	 	
	 	super.releaseDB(con, stmt, result);//DBの開放
	 	return list;//CategoryBean型のlistを戻り値として返す
	}

}

