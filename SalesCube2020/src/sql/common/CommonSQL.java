package sql.common;

public class CommonSQL {

	public String initComboBox(String categoryID) {
		
		String sql;
		
		sql = "select CATEGORY_CODE, CATEGORY_CODE_NAME from category_trn_xxxxx where CATEGORY_ID = " + categoryID;
		
		return sql;
	}
}
