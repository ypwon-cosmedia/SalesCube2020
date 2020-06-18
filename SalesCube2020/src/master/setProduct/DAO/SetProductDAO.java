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

	public List<SetProductBean> getModifyInfo () throws ClassNotFoundException, MissingResourceException, SQLException {
		
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

	public List<SetProductSearchResultBean> getSearchInfo (SetProductSearchBean searchBean) throws ClassNotFoundException, MissingResourceException, SQLException {
		
		List<SetProductSearchResultBean> list = new ArrayList<SetProductSearchResultBean>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
		
	 	con = super.getConnection();	
	 	stmt = con.createStatement();	
	 	sql = "select PRODUCT_CODE, PRODUCT_CODE, QUANTITY from product_mst_xxxxx where SET_TYPE_CATEGORY = 1 AND ";	//追加必要	
	 	result = stmt.executeQuery(sql);	
		
	 	while (result.next()) {
	 		SetProductSearchResultBean bean = new SetProductSearchResultBean();
	 		bean.setProductCode(result.getString("PRODUCT_NAME"));
	 		bean.setProductName(result.getString("PRODUCT_CODE"));
	 		list.add(bean);
	 	}

		return list;
	}
	
	public void setDetailInfo (List<SetProductBean> inputList) throws ClassNotFoundException, MissingResourceException, SQLException {
		

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
}
