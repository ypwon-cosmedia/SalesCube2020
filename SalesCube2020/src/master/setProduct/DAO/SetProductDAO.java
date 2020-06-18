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
	 	SetProductSearchResultBean bean = new SetProductSearchResultBean();
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();	
	 	sql = "select PRODUCT_CODE, PRODUCT_NAME from product_mst_xxxxx;";	//追加必要	
	 	result = stmt.executeQuery(sql);	
		
	 	while (result.next()) {
	 		bean.setProductCode(result.getString("PRODUCT_NAME"));
	 		bean.setProductName(result.getString("PRODUCT_CODE"));
	 		list.add(bean);
	 	}
	 	
	 	return list;
	}
	
	
	public void setInfo (List<SetProductBean> inputList) throws ClassNotFoundException, MissingResourceException, SQLException {
		

		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
		
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	for(SetProductBean bean : inputList) {
	 		sql = "insert into product_set_mst_xxxxx(SET_PRODUCT_CODE, PRODUCT_CODE, QUANTITY) values(" 
	 				+ bean.getSetProductCode() + ","
	 				+ bean.getProductCode() + ","
	 				+ bean.getQuantity() + ")" ;	//追加必要	
		 	result = stmt.executeQuery(sql);
	 	}
	
	}
	
	public void deleteInfo (int[] code) throws ClassNotFoundException, MissingResourceException, SQLException {
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	for(int i = 0; i<code.length; i++) {
	 		sql = "delete from product_set_mst_xxxxx where PRODUCT_CODE = " + code[i] + ";";	//追加必要	
		 	result = stmt.executeQuery(sql);		
	 	}

	}
	
}
