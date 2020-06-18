package master.product.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.dao.BaseDAO;
import master.product.beans.ProductCategoryBean;


public class ProductDAO extends BaseDAO {

	public List<ProductCategoryBean> getCategory() throws SQLException, ClassNotFoundException{
	 	
		List<ProductCategoryBean> list = new ArrayList<ProductCategoryBean>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();	
	 	sql = "select CLASS_CODE_1, CLASS_CODE_2, CLASS_CODE_3, CLASS_NAME from product_class_mst_xxxxx";	
	 	result = stmt.executeQuery(sql);	
		
	 	while (result.next()) {
	 		//1レコードずつItemBeanセットする
	 		ProductCategoryBean bean = new ProductCategoryBean();
	 		bean.setProduct1(result.getString("CLASS_CODE_1"));
	 		bean.setProduct2(result.getString("CLASS_CODE_2"));
	 		bean.setProduct3(result.getString("CLASS_CODE_3"));
	 		bean.setProductName(result.getString("CLASS_NAME"));
	 		list.add(bean);
	 	}

		return list;
	}
}
