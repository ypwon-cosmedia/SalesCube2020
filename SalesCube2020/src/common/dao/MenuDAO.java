package common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import common.beans.ProductStockCategoryBean;

public class MenuDAO extends BaseDAO {

	public List<ProductStockCategoryBean> getProductStockCategory() throws ClassNotFoundException, MissingResourceException{
		
		List<ProductStockCategoryBean> list = new ArrayList<ProductStockCategoryBean>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
	 	try {
		 	con = super.getConnection();	
		 	stmt = con.createStatement();	
		 	sql = "select CATEGORY_CODE, CATEGORY_CODE_NAME from category_trn_xxxxx where CATEGORY_ID = 17;";	
		 	result = stmt.executeQuery(sql);	
			
		 	while (result.next()) {
	 		ProductStockCategoryBean bean = new ProductStockCategoryBean();
		 		bean.setProductStockCategoryCode(result.getInt("CATEGORY_CODE"));
		 		bean.setProductStockCategoryName(result.getString("CATEGORY_CODE_NAME"));
				list.add(bean);
		 	} 
		 	super.releaseDB(con, stmt, result);
		 	
	 	}	catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	 		
	 	
	 	return list;
	 }

	 
}