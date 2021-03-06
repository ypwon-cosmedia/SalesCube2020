package master.product.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.dao.BaseDAO;
import master.product.beans.DiscountDetailBean;
import master.product.beans.DiscountSearchBean;
import master.product.beans.ProductResultBean;
import master.product.beans.ProductSearchBean;
import master.product.beans.QuantityDiscountBean;

public class ProductDiscountDAO extends BaseDAO{
	
	/* 数量割引検索情報の取得(Modal部以外） */
	public List<DiscountSearchBean> searchQuantityDiscount(QuantityDiscountBean bean) throws SQLException, ClassNotFoundException {

		List<DiscountSearchBean> list = new ArrayList<DiscountSearchBean>();

		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;

	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	if(bean.getDiscountId() == null || bean.getDiscountId().equals("")) {
	 		bean.setDiscountId("%");
	 	}
	 	if(bean.getUseFlag() == null || bean.getUseFlag().equals("")) {
	 		bean.setUseFlag("%");
	 	}
	 	if(bean.getDiscountName() == null || bean.getDiscountName().equals("")) {
	 		bean.setDiscountName("%");
	 	}
	 	if(bean.getRemarks() == null || bean.getRemarks().equals("")) {
	 		bean.setRemarks("%");
	 	}
	 	
	 	
	 	sql = "SELECT"
	 			+" * "
	 		  +" FROM"
	 			+" discount_mst_xxxxx dmx "
	 		  +" WHERE"
	 		    +" dmx.DISCOUNT_ID LIKE '" + bean.getDiscountId()
	 		    +"' AND 	dmx.USE_FLAG LIKE '" + bean.getUseFlag()
	 		    +"' AND 	dmx.DISCOUNT_NAME LIKE '" + bean.getDiscountName()
	 		    +"' AND 	dmx.REMARKS LIKE '" + bean.getRemarks()
	 		  +"' ORDER BY"
	 			+" dmx.DISCOUNT_ID";
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	while( result.next() ) {
	 		DiscountSearchBean dsb = new DiscountSearchBean();
	 		dsb.setDiscountId( result.getString("dmx.DISCOUNT_ID") );
	 		dsb.setUseFlag( result.getString("dmx.USE_FLAG") );
	 		dsb.setDiscountName( result.getString("dmx.DISCOUNT_NAME") );
	 		
	 		list.add(dsb);
	 	}
	 	
		super.releaseDB(con, stmt, result);
		return list; 
		
		}
	/**
	// 数量割引検索情報の取得(Modal部） 
	public List<DiscountDetailBean> searchModalDiscount(String discountId) throws SQLException, ClassNotFoundException {

		List<DiscountDetailBean> list = new ArrayList<DiscountDetailBean>();

		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;

	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	sql = "select * from discount_trn_xxxxx where discount_id = " + discountId + ";" ;
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	while( result.next() ) {
	 		DiscountDetailBean ddb = new DiscountDetailBean();
	 		ddb.setDiscountId("DISCOUNT_ID");
	 		ddb.setLineNo( result.getInt("LINE_NO") );
	 		ddb.setDataFrom( result.getInt("DATA_FROM") );
	 		ddb.setDataTo( result.getInt("DATA_TO") );
	 		ddb.setDiscountRate( result.getInt("DISCOUNT_RATE") );
	 		
	 		list.add(ddb);
	 	}
	 	
		super.releaseDB(con, stmt, result);
		return list; 
		
		}
	**/
}
