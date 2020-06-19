package master.setProduct.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import common.dao.BaseDAO;
import master.setProduct.beans.SetProductBean;
import master.setProduct.beans.SetProductSearchBean;
import master.setProduct.beans.SetProductSearchResultBean;


public class SetProductDAO extends BaseDAO {

	public List<SetProductBean> getInfo () throws ClassNotFoundException, MissingResourceException, SQLException {
		
		List<SetProductBean> list = new ArrayList<SetProductBean>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
		
	 	con = super.getConnection();	
	 	stmt = con.createStatement();	
	 	sql = "select SET_PRODUCT_CODE, PRODUCT_CODE, QUANTITY from product_set_mst_xxxxx";	
	 	result = stmt.executeQuery(sql);	
		
	 	while (result.next()) {
	 		SetProductBean bean = new SetProductBean();
	 		bean.setSetProductCode(result.getString("SET_PRODUCT_CODE"));
	 		bean.setProductCode(result.getString("PRODUCT_CODE"));
	 		bean.setQuantity(result.getInt("QUANTITY"));
	 		list.add(bean);
	 	}

		return list;
	}
	
	//編集ページ表示用（オーバーライド）
	public SetProductSearchResultBean getProductInfo (int code) throws ClassNotFoundException, MissingResourceException, SQLException {

		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
	 	SetProductSearchResultBean bean = new SetProductSearchResultBean();
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();	
	 	sql = "select PRODUCT_CODE, PRODUCT_NAME from product_mst_xxxxx where PRODUCT_CODE = " + code + ";";	//追加必要	
	 	result = stmt.executeQuery(sql);	
		
	 	while (result.next()) {
	 		bean.setProductCode(result.getString("PRODUCT_NAME"));
	 		bean.setProductName(result.getString("PRODUCT_CODE"));
	 	}
	 	
	 	return bean;
	}
	
	//検索ページ表示用（オーバーライド）
	public List<SetProductSearchResultBean> getProductInfo (SetProductSearchBean input) throws ClassNotFoundException, MissingResourceException, SQLException {

		List<SetProductSearchResultBean> list = new ArrayList<SetProductSearchResultBean>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
	 	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();	
	 	sql = "select PRODUCT_CODE, PRODUCT_NAME from product_mst_xxxxx where SET_TYPE_CATEGORY = 1;";	//追加必要	
	 	result = stmt.executeQuery(sql);	
		
	 	while (result.next()) {
	 		SetProductSearchResultBean bean = new SetProductSearchResultBean();
	 		bean.setProductName(result.getString("PRODUCT_NAME"));
	 		bean.setProductCode(result.getString("PRODUCT_CODE"));
	 		list.add(bean);
	 	}
	 	
	 	return list;
	}
	
	
	public void setInfo (List<SetProductBean> inputList, String setProductCode) throws ClassNotFoundException, MissingResourceException, SQLException {
		

		Connection con;
	 	Statement stmt = null;
	 	int result;	
	 	String  sql1;
	 	String  sql2;
		
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	sql1 = "DELETE FROM product_set_mst_xxxxx WHERE SET_PRODUCT_CODE = " + setProductCode;
	 	result = stmt.executeUpdate(sql1);
	 	
	 	for(SetProductBean bean : inputList) {
	 		sql2 = "INSERT INTO (SET_PRODUCT_CODE, PRODUCT_CODE, QUANTITY) product_set_mst_xxxxx"
	 				+ "VALUES("
	 				+ bean.getSetProductCode() + ","
	 				+ bean.getProductCode() + ","
	 				+ bean.getQuantity() + ");";
	 		
		 	result = stmt.executeUpdate(sql2);
	 	}
	
	}
		
}
