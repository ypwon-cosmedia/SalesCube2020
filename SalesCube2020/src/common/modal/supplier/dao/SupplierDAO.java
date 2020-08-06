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

public class SupplierDAO extends BaseDAO{

	public List<SupplierSearchResultBean> SearchSupplier(SupplierSearchBean search) throws ClassNotFoundException, MissingResourceException, SQLException {
		
		List<SupplierSearchResultBean> list = new ArrayList<> ();
		
		Connection con;
		Statement stmt = null;
		ResultSet result = null;
		
		con = super.getConnection();
		stmt = con.createStatement();
		
		String inputSupplierCode = search.getSupplierCode();
		String inputSupplierName = search.getSupplierName();
		String inputSupplierKana = search.getSupplierKana();
		String sql;
		
		//検索項目がnullの場合の処理と部分検索の準備
		if(inputSupplierCode == null || inputSupplierCode.equals("")) {//inputSupplierCode
	 		search.setSupplierCode("%");
	 	}
	 	else {
	 		search.setSupplierCode("%" + search.getSupplierCode() + "%");
	 	}
		
		if(inputSupplierName == null || inputSupplierName.equals("")) {//inputSupplierName
	 		search.setSupplierName("%");
	 	}
	 	else {
	 		search.setSupplierName("%" + search.getSupplierName() + "%");
	 	}
		
		if(inputSupplierKana == null || inputSupplierKana.equals("")) {//inputSupplierKana
	 		search.setSupplierKana("%");
	 	}
	 	else {
	 		search.setSupplierKana("%" + search.getSupplierKana() + "%");
	 	}
		
		//setした値を受け取る
		inputSupplierCode = search.getSupplierCode();
		inputSupplierName = search.getSupplierName();
		inputSupplierKana = search.getSupplierKana();
		
		sql = "SELECT "
				+ "SUP.SUPPLIER_CODE, "
				+ "SUP.SUPPLIER_NAME, "
				+ "SUP.SUPPLIER_PC_NAME, "
				+ "CT.CATEGORY_CODE_NAME, "
				+ "SUP.REMARKS "
			+ "FROM SUPPLIER_MST_XXXXX AS SUP " 
				+ "LEFT OUTER JOIN CATEGORY_TRN_XXXXX AS CT " 
					+ "ON SUP.SUPPLIER_CM_CATEGORY = CT.CATEGORY_CODE " 
					+ "AND CT.CATEGORY_ID='13'"
			+ "WHERE"
			+ " SUPPLIER_CODE LIKE" + "'"
					+ inputSupplierCode
					+ "' AND"
			+ " SUPPLIER_NAME LIKE" + "'"
					+ inputSupplierName
					+ "' AND"
			+ " SUPPLIER_KANA LIKE" + "'"
					+ inputSupplierKana
					+ "';" ;
		
		result = stmt.executeQuery(sql);
		
		//SQL文の検索結果の出力
		while( result.next() ) {	//区分情報をリストに登録
			SupplierSearchResultBean supplier = new SupplierSearchResultBean();
			supplier.setSupplierCode( result.getString("SUPPLIER_CODE") );
			supplier.setSupplierName( result.getString("SUPPLIER_NAME") );
			supplier.setSupplierPCName( result.getString("SUPPLIER_PC_NAME") );
			supplier.setCategoryCodeName( result.getString("CATEGORY_CODE_NAME") );
			supplier.setRemarks( result.getString("REMARKS") );
	 		
			if(supplier.getCategoryCodeName()== null || supplier.getCategoryCodeName().equals("")) {supplier.setCategoryCodeName("");};
			if(supplier.getRemarks()== null || supplier.getRemarks().equals("")) {supplier.setRemarks("");};
			
	 		list.add(supplier);
	 	}
	 	
	 	super.releaseDB(con, stmt, result);	//DBの開放
	 	return list;	//SupplierSearchResultBean型のlistを戻り値として返す
	}
		
}

