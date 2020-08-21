package estimate.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.dao.BaseDAO;
import estimate.common.API.EstimateCommonSqlProperty;
import estimate.common.beans.CategoryBean;

public class CategoryDAO extends BaseDAO{
	
	public  List<CategoryBean> CategoryGet(int categoryId) throws SQLException, ClassNotFoundException{
		
		List<CategoryBean> list = new ArrayList<> ();
		
		Connection con;
		PreparedStatement pstm = null;
		ResultSet result = null;
		
		con = super.getConnection();
		
		String sql;

		sql = EstimateCommonSqlProperty.getEstimateCommonProperty("estimateCategory");
		
		pstm = con.prepareStatement(sql);
		
		pstm.setInt(1, categoryId);
		
		result = pstm.executeQuery();
		    
		//SQL文の検索結果の出力
		while( result.next() ) {//区分情報をリストに登録
			CategoryBean category = new CategoryBean();
			category.setCategoryCode(result.getString("CATEGORY_CODE"));
			category.setCategoryCodeName(result.getString("CATEGORY_CODE_NAME"));
	 		
	 		list.add(category);
	 	}
	 	
		super.releaseDB(con, pstm);//DBの開放
	 	return list;//List<EstimateConfigurationBean>型のlistを戻り値として返す
	}

}

