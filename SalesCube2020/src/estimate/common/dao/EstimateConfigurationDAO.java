package estimate.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import common.dao.BaseDAO;
import estimate.common.API.EstimateCommonSqlProperty;
import estimate.common.beans.EstimateConfigurationBean;


public class EstimateConfigurationDAO extends BaseDAO{
	
	public  List<EstimateConfigurationBean> showConfigurationGet(String userId) throws SQLException, ClassNotFoundException{
		
		List<EstimateConfigurationBean> list = new ArrayList<> ();
		
		Connection con;
		PreparedStatement pstm = null;
		ResultSet result = null;
		
		con = super.getConnection();
		
		String sql;
		
		/*
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
		*/
		sql = EstimateCommonSqlProperty.getEstimateCommonProperty("estimateConfigShow");
		pstm = con.prepareStatement(sql);
		
		pstm.setString(1, userId);
		result = pstm.executeQuery();
		
		//SQL文の検索結果の出力
		while( result.next() ) {	//表示項目をリストに登録
			EstimateConfigurationBean show = new EstimateConfigurationBean();
			show.setItemId( result.getString("ITEM_ID") );
			show.setItemName( result.getString("ITEM_NAME") );
			show.setSeq( Integer.parseInt( result.getString("SEQ") ) );
			
	 		list.add(show);
	 	}
		pstm.close();
		super.releaseDB(con, pstm);//DBの開放
	 	return list;//List<EstimateConfigurationBean>型のlistを戻り値として返す
 	
 	}
	
	public List<EstimateConfigurationBean> notShowConfigurationGet(String userId) throws SQLException, ClassNotFoundException, MissingResourceException {

		List<EstimateConfigurationBean> list = new ArrayList<> ();
		
		Connection con;
		ResultSet result;
		PreparedStatement pstm = null;
		
		con = super.getConnection();
		
		String sql;
		/*
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
		*/
		sql = EstimateCommonSqlProperty.getEstimateCommonProperty("estimateConfigNotShow");
		pstm = con.prepareStatement(sql);
		
		pstm.setString(1, userId);
		result = pstm.executeQuery();
		
		//SQL文の検索結果の出力
		while( result.next() ) {	//表示項目をリストに登録
			EstimateConfigurationBean notShow = new EstimateConfigurationBean();
			notShow.setItemId( result.getString("MST.ITEM_ID") );
			notShow.setItemName( result.getString("MST.ITEM_NAME") );
			notShow.setSeq( Integer.parseInt( result.getString("MST.SEQ") ) );
			
	 		list.add(notShow);
	 	}
		
		pstm.close();
		super.releaseDB(con, pstm);//DBの開放
	 	return list;//List<EstimateConfigurationBean>型のlistを戻り値として返す
	 	
	}
	
	public void UpdateConfig(String userId, String[] showItems) throws SQLException, ClassNotFoundException{
		
		Connection con;
		int result = 0;
		PreparedStatement pstm = null;
		
		String deleteSql;//表示項目の削除用のSQL
		String insertSql;//表示項目の登録用のSQL
		
		try {
		
		con = super.getConnection();
		
		/*表示項目の削除用のSQL
		deleteSql = "DELETE "
					+ "FROM DETAIL_DISP_ITEM_CFG_XXXXX "
					+ "WHERE "
						+ "USER_ID='" + userId + "' "
						+ "AND TARGET = '1' "
						+ "AND DETAIL_ID='0201';";
		*/
		deleteSql = EstimateCommonSqlProperty.getEstimateCommonProperty("estimateConfigDelete");
		pstm = con.prepareStatement(deleteSql);
		
		pstm.setString(1, userId);
		result = pstm.executeUpdate();//表示項目をリストから削除
		
		System.out.println("-----FINISH delete-----");
		
		/*表示項目の登録用のSQL
		insertSql = "INSERT "
				+ "INTO DETAIL_DISP_ITEM_CFG_XXXXX " 
					+ "(USER_ID, " 		//ログインユーザのID
					+ "DETAIL_ID, " 	//'0201'
					+ "TARGET, " 		//'1'(伝票）
					+ "ITEM_ID, " 		//項目のID
					+ "SEQ, " 			//順番号
					+ "CRE_DATETM, " 	//Now()
					+ "UPD_DATETM ) " 	//Now()
				+ "VALUES( " 
					+ "?, " 			//userId
					+ "?, "				//'0201'
					+ "?, " 			//'1'
					+ "?, " 			//showItems[]の項目
					+ "?, " 			//自動採番  （見積番号に注意）
					+ "?, " 
					+ "? " 
				+ ");";
		*/
		insertSql = EstimateCommonSqlProperty.getEstimateCommonProperty("estimateConfigUpdate");
		pstm = con.prepareStatement(insertSql);
		
		//見積番号を1番目に登録する
		pstm.setString(1, userId);
		pstm.setString(2, "0201");
		pstm.setString(3, "1");
		pstm.setString(4, "estimateSheetId");
		pstm.setInt(5, 1);
		pstm.setTimestamp(6, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
		pstm.setTimestamp(7, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
		result = pstm.executeUpdate();
		
		if(showItems != null) {
			for(int i=0; i<showItems.length; i++) {
			//showItems[i]を動的に入れる
				pstm.setString(4, showItems[i]);
				pstm.setInt(5, (i+2));
				result = pstm.executeUpdate();
				
			}
		}
		con.commit();	//"pstm"をコミットして登録
		
		System.out.println("-----FINISH update-----");
		pstm.close();
		super.releaseDB(con,pstm);//DBの開放
		
		}catch (SQLException e){
			  e.printStackTrace();
		}
	}
}
