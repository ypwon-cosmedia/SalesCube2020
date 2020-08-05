package common.modal.supplier.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import common.dao.BaseDAO;
import common.modal.supplier.beans.SupplierSearchBean;
import common.modal.supplier.beans.SupplierSearchResultBean;
import estimate.common.beans.CategoryBean;

public class SupplierDAO extends BaseDAO{

	public List<SupplierSearchResultBean> SearchSupplier(SupplierSearchBean search) throws ClassNotFoundException, MissingResourceException, SQLException {
		
		List<SupplierSearchResultBean> list = new ArrayList<> ();
		
		Connection con;
		Statement stmt = null;
		ResultSet result = null;
		
		con = super.getConnection();
		stmt = con.createStatement();

		String sql;

		sql = "SELECT "
				+ "SUPPLIER_CODE, "
				+ "SUPPLIER_NAME, "
				+ "SUPPLIER_PC_NAME "
				+ "CATEGORY_CODE_NAME, "
				+ "REMARKS "
			+ "FROM supplier_mst_xxxxx " 
				+ "LEFT OUTER JOIN category_trn_xxxxx " 
					+ "ON supplier_mst_xxxxx.SUPPLIER_CM_CATEGORY = category_trn_xxxxx.CATEGORY_CODE " 
					+ "AND category_trn_xxxxx.CATEGORY_ID='13'"
			;/*+ "WHERE"
			+ " SUPPLIER_CODE=" + "' 1 '"
			+ " SUPPLIER_NAME=" + "' あんぱんまん食品 '"
			+ " SUPPLIER_KANA=" + "' アンパンマンショクヒン '" ;*/
		
		result = stmt.executeQuery(sql);
		
		//SQL文の検索結果の出力
		while( result.next() ) {	//区分情報をリストに登録
			SupplierSearchResultBean supplier = new SupplierSearchResultBean();
			supplier.setSupplierCode( result.getString("SUPPLIER_CODE") );
			supplier.setSupplierName( result.getString("SUPPLIER_NAME") );
			supplier.setSupplierPCName( result.getString("SUPPLIER_PC_NAME") );
			supplier.setCategoryCodeName( result.getString("CATEGORY_CODE_NAME") );
			supplier.setRemarks( result.getString("REMARKS") );
	 		
	 		list.add(supplier);
	 	}
	 	
	 	super.releaseDB(con, stmt, result);	//DBの開放
	 	return list;	//SupplierSearchResultBean型のlistを戻り値として返す
	}
		
}

