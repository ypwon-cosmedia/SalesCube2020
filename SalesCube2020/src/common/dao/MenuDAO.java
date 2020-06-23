package common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import common.beans.CustomerPayBean;
import common.beans.ProductStandardCategoryBean;
import common.beans.ProductStatusCategoryBean;
import common.beans.ProductStockCategoryBean;
import common.beans.SetTypeCategoryBean;

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
		 	return list;
		 	
	 	}	catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	 		
	 	
	 	return list;
	 }
	
	public List<SetTypeCategoryBean> getSetTypeCategory() throws ClassNotFoundException, MissingResourceException{
		
		List<SetTypeCategoryBean> list = new ArrayList<SetTypeCategoryBean>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
	 	try {
		 	con = super.getConnection();	
		 	stmt = con.createStatement();	
		 	sql = "select CATEGORY_CODE, CATEGORY_CODE_NAME from category_trn_xxxxx where CATEGORY_ID = 2;";	
		 	result = stmt.executeQuery(sql);	
			
		 	while (result.next()) {
		 		SetTypeCategoryBean bean = new SetTypeCategoryBean();
		 		bean.setSetTypeCategoryCode(result.getInt("CATEGORY_CODE"));
		 		bean.setSetTypeCategoryName(result.getString("CATEGORY_CODE_NAME"));
				list.add(bean);
		 	} 
		 	super.releaseDB(con, stmt, result);
		 	return list;
		 	
	 	}	catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	 		
	 	
	 	return list;

	}

	public List<ProductStandardCategoryBean> getProductStandardCategory() throws ClassNotFoundException, MissingResourceException{
		
		List<ProductStandardCategoryBean> list = new ArrayList<ProductStandardCategoryBean>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
	 	try {
		 	con = super.getConnection();	
		 	stmt = con.createStatement();	
		 	sql = "select CATEGORY_CODE, CATEGORY_CODE_NAME from category_trn_xxxxx where CATEGORY_ID = 3;";	
		 	result = stmt.executeQuery(sql);	
			
		 	while (result.next()) {
		 		ProductStandardCategoryBean bean = new ProductStandardCategoryBean();
		 		bean.setProductStandardCategoryCode(result.getInt("CATEGORY_CODE"));
		 		bean.setProductStandardCategoryName(result.getString("CATEGORY_CODE_NAME"));
				list.add(bean);
		 	} 
		 	super.releaseDB(con, stmt, result);
		 	return list;
		 	
	 	}	catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	 		
	 	
	 	return list;

	}
	
	public List<ProductStatusCategoryBean> getProductStatusCategory() throws ClassNotFoundException, MissingResourceException{
		
		List<ProductStatusCategoryBean> list = new ArrayList<ProductStatusCategoryBean>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
	 	try {
		 	con = super.getConnection();	
		 	stmt = con.createStatement();	
		 	sql = "select CATEGORY_CODE, CATEGORY_CODE_NAME from category_trn_xxxxx where CATEGORY_ID = 16;";	
		 	result = stmt.executeQuery(sql);	
			
		 	while (result.next()) {
		 		ProductStatusCategoryBean bean = new ProductStatusCategoryBean();
		 		bean.setProductStatusCategoryCode(result.getInt("CATEGORY_CODE"));
		 		bean.setProductStatusCategoryName(result.getString("CATEGORY_CODE_NAME"));
				list.add(bean);
		 	} 
		 	super.releaseDB(con, stmt, result);
		 	return list;
		 	
	 	}	catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	 		
	 	
	 	return list;

	}
	
	public List<CustomerPayBean> getCustomerPayInfo() throws ClassNotFoundException, MissingResourceException{
		
		List<CustomerPayBean> list = new ArrayList<CustomerPayBean>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
	 	try {
		 	con = super.getConnection();	
		 	stmt = con.createStatement();	
		 	sql = "select CATEGORY_CODE, CATEGORY_CODE_NAME from category_trn_xxxxx where CATEGORY_ID = 11;";	
		 	result = stmt.executeQuery(sql);	
			
		 	while (result.next()) {
		 		CustomerPayBean bean = new CustomerPayBean();
		 		bean.setCategoryCode(result.getString("CATEGORY_CODE"));
		 		bean.setCategoryCodeName(result.getString("CATEGORY_CODE_NAME"));
				list.add(bean);
		 	} 
		 	super.releaseDB(con, stmt, result);
		 	return list;
		 	
	 	}	catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	 		
	 	
	 	return list;

	}
}