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

	public List<SetProductBean> getInfo (String code) throws ClassNotFoundException, MissingResourceException, SQLException {
		
		List<SetProductBean> list = new ArrayList<SetProductBean>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
		
	 	con = super.getConnection();	
	 	stmt = con.createStatement();	
	 	sql = "select distinct product_set_mst_xxxxx.PRODUCT_CODE " + 
	 			",product_mst_xxxxx.PRODUCT_NAME " + 
	 			",product_set_mst_xxxxx.QUANTITY " + 
	 			"from " + 
	 			"product_mst_xxxxx " + 
	 			"left outer join product_set_mst_xxxxx on product_mst_xxxxx.PRODUCT_CODE = product_set_mst_xxxxx.PRODUCT_CODE " + 
	 			"where product_set_mst_xxxxx.SET_PRODUCT_CODE = " + code;	
	 	result = stmt.executeQuery(sql);	
		
	 	while (result.next()) {
	 		SetProductBean bean = new SetProductBean();
	 		bean.setProductName(result.getString("PRODUCT_NAME"));
	 		bean.setProductCode(result.getString("PRODUCT_CODE"));
	 		bean.setQuantity(result.getInt("QUANTITY"));
	 		list.add(bean);
	 	}

		return list;
	}
	
	
	public SetProductSearchResultBean getProductInfo (int code) throws ClassNotFoundException, MissingResourceException, SQLException {

		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
	 	SetProductSearchResultBean bean = new SetProductSearchResultBean();
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();	
	 	sql = "select PRODUCT_CODE, PRODUCT_NAME from product_mst_xxxxx where PRODUCT_CODE = " + code + ";";	
	 	result = stmt.executeQuery(sql);	
		
	 	while (result.next()) {
	 		bean.setProductCode(result.getString("PRODUCT_NAME"));
	 		bean.setProductName(result.getString("PRODUCT_CODE"));
	 	}
	 	
	 	return bean;
	}
	

	public List<SetProductSearchResultBean> getProductInfo (SetProductSearchBean input) throws ClassNotFoundException, MissingResourceException, SQLException {

		List<SetProductSearchResultBean> list = new ArrayList<SetProductSearchResultBean>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
	 		
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	if(input.getSetProductCode() == null) {
	 		input.setSetProductCode("%");
	 	}
	 	
	 	if(input.getSetProductName() == null) {
	 		input.setSetProductName("%");
	 	}
	 	
	 	if(input.getProductName() == null) {
	 		input.setProductName("%' or b.PRODUCT_CODE IS NULL");
	 	}
	 	else {
	 		input.setProductName(input.getProductName().concat("'"));
	 	}
	 	
	 	if(input.getProductCode() == null) {
	 		input.setProductCode("%' or a.PRODUCT_NAME IS NULL");
	 	}
	 	else {
	 		input.setProductCode(input.getProductCode().concat("'"));
	 	}
	 	
	 	
	 	
	 	sql = "select distinct " + 
	 			"c.PRODUCT_CODE " + 
	 			",c.PRODUCT_NAME " + 
	 			"from " + 
	 			"(select " + 
	 			"PRODUCT_CODE " + 
	 			",PRODUCT_NAME " + 
	 			"from " + 
	 			"product_mst_xxxxx pmx  where pmx.SET_TYPE_CATEGORY = 1) c " + 
	 			"left join (select SET_PRODUCT_CODE, PRODUCT_CODE, QUANTITY from product_set_mst_xxxxx) b on c.PRODUCT_CODE = b.SET_PRODUCT_CODE " + 
	 			"left join (select PRODUCT_NAME, PRODUCT_CODE from product_mst_xxxxx) a on a.PRODUCT_CODE = b.PRODUCT_CODE " + 
	 			"where " + 
	 			"c.PRODUCT_CODE LIKE '" + input.getSetProductCode() + 
	 			"' and c.PRODUCT_NAME LIKE '" + input.getSetProductName() +
	 			"' and (b.PRODUCT_CODE LIKE '" + input.getProductCode() +
	 			") and (a.PRODUCT_NAME LIKE '" + input.getProductName() + ");";
	 			
	 				 	
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
	 				+ bean.getProductName() + ","
	 				+ bean.getProductCode() + ","
	 				+ bean.getQuantity() + ");";
	 		
		 	result = stmt.executeUpdate(sql2);
	 	}
	
	}


	
}
