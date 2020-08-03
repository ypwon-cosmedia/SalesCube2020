/**
 * 
 */
package estimate.Input.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import common.dao.BaseDAO;
import estimate.Input.beans.GetCustomerBean;
import estimate.Input.beans.GetProductBean;

/**
 * @author cosmedia
 *
 */
public class EstimateInputCommonDAO extends BaseDAO {

	//顧客情報を取得するメソッド
	public GetCustomerBean getCustomer(int customerCode) throws SQLException, ClassNotFoundException {
		
		Connection con;
	 	Statement stmt=null;
	 	ResultSet result=null;
	 	String  sql;
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	sql="select CUSTOMER_NAME, " + 
	 				"REMARKS, " + 
	 				"COMMENT_DATA" + 
	 		"from customer_mst_xxxxx " + 
	 		"where CUSTOMER_CODE = " + customerCode;
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	GetCustomerBean bean = new GetCustomerBean();
		
	 	if (result.next()) {
	 		bean.setCustomerName(result.getString("CUSTOMER_NAME"));
	 		bean.setCustomerRemarks(result.getString("REMARKS"));
	 		bean.setCustomerComment(result.getString("COMMENT_DATA"));
	 	}
	 	
	 	super.releaseDB(con,stmt,result);
	 	
	 	return bean;
	}
	
	
	//商品情報を取得するメソッド
	public GetProductBean getProduct(int productCode) throws SQLException, ClassNotFoundException {
		
		Connection con;
	 	Statement stmt=null;
	 	ResultSet result=null;	
	 	String  sql;
	 	
	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	sql="select PRODUCT_NAME, " + 
	 				"SUPPLIER_PRICE_YEN, " +
	 				"RETAIL_PRICE " + 
	 		"from product_mst_xxxxx " + 
	 		"where PRODUCT_CODE = " + productCode;
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	GetProductBean bean = new GetProductBean();
		
	 	if (result.next()) {
	 		bean.setProductAbstract(result.getString("PRODUCT_NAME"));
	 		bean.setUnitCost(result.getInt("SUPPLIER_PRICE_YEN"));
	 		bean.setUnitRetailPrice(result.getInt("RETAIL_PRICE"));
	 	}
	 	
	 	super.releaseDB(con,stmt,result);
	 	
	 	return bean;
	}
}
