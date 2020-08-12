package estimate.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import common.dao.BaseDAO;
import estimate.common.beans.EstimateConfigurationBean;


public class EstimateConfigurationDAO extends BaseDAO{
	
	public  List<EstimateConfigurationBean> showConfigurationGet(String userId) throws SQLException, ClassNotFoundException{
		
		List<EstimateConfigurationBean> list = new ArrayList<> ();
		
		Connection con;
		Statement stmt = null;
		ResultSet result = null;
		
		con = super.getConnection();
		stmt = con.createStatement();
		
		String sql;
		
		sql = "SELECT "
				+ "MST.ITEM_ID, "
				+ "MST.ITEM_NAME, "
				+ "CFG.SEQ "
			+ "FROM "
				+ "DETAIL_DISP_ITEM_CFG_XXXXX AS CFG "
			+ "LEFT OUTER JOIN "
				+ "DETAIL_DISP_ITEM_MST_XXXXX AS MST "
			+ "ON "
				+ "CFG.DETAIL_ID=MST.DETAIL_ID "
				+ "AND CFG.TARGET=MST.TARGET "
				+ "AND CFG.ITEM_ID=MST.ITEM_ID "
			+ " WHERE CFG.USER_ID='"
				+ userId
				+ "' AND CFG.TARGET='1' "
				+ "AND CFG.DETAIL_ID='0201' "
			+ " ORDER BY SEQ;";
		
		result = stmt.executeQuery(sql);
		
		//SQL文の検索結果の出力
		while( result.next() ) {	//表示項目をリストに登録
			EstimateConfigurationBean show = new EstimateConfigurationBean();
			show.setItemId( result.getString("ITEM_ID") );
			show.setItemName( result.getString("ITEM_NAME") );
			show.setSeq( Integer.parseInt( result.getString("SEQ") ) );
			
	 		list.add(show);
	 	}
	 	
	super.releaseDB(con, stmt, result);//DBの開放
 	return list;//List<EstimateConfigurationBean>型のlistを戻り値として返す
 	
 	}
	
	public List<EstimateConfigurationBean> notShowConfigurationGet(String userId) throws SQLException, ClassNotFoundException, MissingResourceException {

		List<EstimateConfigurationBean> list = new ArrayList<> ();
		
		Connection con;
		Statement stmt = null;
		ResultSet result = null;
		
		con = super.getConnection();
		stmt = con.createStatement();
		
		String sql;
		
		sql = "SELECT "
				+ "MST.ITEM_ID, "
				+ "MST.ITEM_NAME, "
				+ "MST.SEQ "
			+ "FROM "
				+ "DETAIL_DISP_ITEM_MST_XXXXX AS MST "
			+ "WHERE "
				+ "MST.DETAIL_ID='0201' "
				+ "AND NOT EXISTS( "
					+ "SELECT * "
					+ "FROM DETAIL_DISP_ITEM_CFG_XXXXX AS CFG "
					+ "WHERE "
						+ "MST.ITEM_ID=CFG.ITEM_ID "
						+ "AND CFG.USER_ID='"
						+ userId
						+ "' AND "
						+ "CFG.TARGET='1' "
						+ "AND CFG.DETAIL_ID='0201' "
				+ ") "
			+ "ORDER BY MST.SEQ;";
		
		result = stmt.executeQuery(sql);
		
		//SQL文の検索結果の出力
		while( result.next() ) {	//表示項目をリストに登録
			EstimateConfigurationBean notShow = new EstimateConfigurationBean();
			notShow.setItemId( result.getString("MST.ITEM_ID") );
			notShow.setItemName( result.getString("MST.ITEM_NAME") );
			notShow.setSeq( Integer.parseInt( result.getString("MST.SEQ") ) );
			
	 		list.add(notShow);
	 	}
	 	
	super.releaseDB(con, stmt, result);//DBの開放
 	return list;//List<EstimateConfigurationBean>型のlistを戻り値として返す
 	
	}
}
