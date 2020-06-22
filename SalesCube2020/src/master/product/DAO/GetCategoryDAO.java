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
import master.product.beans.ProductBigCategoryBean;
import master.product.beans.ProductMiddleCategoryBean;
import master.product.beans.ProductSmailCategoryBean;

public class GetCategoryDAO extends BaseDAO {

	
	public List<ProductBigCategoryBean> getBigCategory() throws SQLException, ClassNotFoundException{

		List<ProductBigCategoryBean> list = new ArrayList<ProductBigCategoryBean>();

		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;

	 	con = super.getConnection();	
	 	stmt = con.createStatement();	
	 	sql = "select CLASS_CODE_1, CLASS_NAME from product_class_mst_xxxxx where CLASS_CODE_1 IS NOT NULL AND CLASS_CODE_2 = '';";	
	 	result = stmt.executeQuery(sql);	

	 	while (result.next()) {
	 		ProductBigCategoryBean bean = new ProductBigCategoryBean();
	 		bean.setProduct1(result.getString("CLASS_CODE_1"));
	 		bean.setProductName(result.getString("CLASS_NAME"));
	 		list.add(bean);
	 	}

		return list;
	}
	
	public List<ProductMiddleCategoryBean> getMiddleCategory(String bigCode) throws SQLException, ClassNotFoundException{

		List<ProductMiddleCategoryBean> list = new ArrayList<ProductMiddleCategoryBean>();

		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;

	 	con = super.getConnection();	
	 	stmt = con.createStatement();	
	 	sql = "select CLASS_CODE_2, CLASS_NAME from product_class_mst_xxxxx where CLASS_CODE_1 = " + bigCode + " AND CLASS_CODE_2 != '' AND CLASS_CODE_3 = '';";	
	 	result = stmt.executeQuery(sql);	

	 	while (result.next()) {
	 		ProductMiddleCategoryBean bean = new ProductMiddleCategoryBean();
	 		bean.setProduct2(result.getString("CLASS_CODE_2"));
	 		bean.setProductName(result.getString("CLASS_NAME"));
	 		list.add(bean);
	 	}

		return list;
	}
	
	public List<ProductSmailCategoryBean> getSmailCategory(String bigCode, String smailCode) throws SQLException, ClassNotFoundException{

		List<ProductSmailCategoryBean> list = new ArrayList<ProductSmailCategoryBean>();

		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;

	 	con = super.getConnection();	
	 	stmt = con.createStatement();	
	 	sql = "select CLASS_CODE_3, CLASS_NAME from product_class_mst_xxxxx where CLASS_CODE_1 = " + bigCode + " AND CLASS_CODE_2 = " + smailCode + " AND CLASS_CODE_3 != '';";	
	 	result = stmt.executeQuery(sql);	

	 	while (result.next()) {
	 		ProductSmailCategoryBean bean = new ProductSmailCategoryBean();
	 		bean.setProduct3(result.getString("CLASS_CODE_3"));
	 		bean.setProductName(result.getString("CLASS_NAME"));
	 		list.add(bean);
	 	}

		return list;
	}
	
}