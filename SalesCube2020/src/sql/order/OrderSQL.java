package sql.order;

public class OrderSQL {
	
	public String initCategory() {
		
		String sql;
		
		sql = "select CLASS_CODE_1, CLASS_CODE_2, CLASS_CODE_3, CLASS_NAME from product_class_mst_xxxxx";
		
		return sql;
		
	}
	
	public String initConfigModalShowList(String detailID, String target) {
		
		String sql;
		
		sql = "select " + 
				"ITEM_ID, " +
				"ITEM_NAME " + 
				"from " + 
				"detail_disp_item_mst_xxxxx AS a " + 
				"LEFT OUTER JOIN(" + 
				"select " + 
				"* " + 
				"from " + 
				"detail_disp_item_cfg_xxxxx " + 
				"where " + 
				"DETAIL_ID = '"+ detailID + "' " +
				"and " + 
				"TARGET = '"+ target + "' " +
				"and " + 
				"USER_ID = 'SYSTEM') AS b " + 
				"USING(DETAIL_ID, TARGET, ITEM_ID) " + 
				"where " + 
				"a.DETAIL_ID = '"+ detailID + "' " +
				"AND " + 
				"a.TARGET = '"+ target + "' " +
				"AND " + 
				"b.ITEM_ID = a.ITEM_ID";
		
		return sql;
	}
	
	public String initConfigModalNotShowList(String detailID, String target) {
		
		String sql;
		
		sql = "select " + 
				"ITEM_ID, " +
				"ITEM_NAME " + 
				"from " + 
				"detail_disp_item_mst_xxxxx AS a " + 
				"LEFT OUTER JOIN(" + 
				"select " + 
				"* " + 
				"from " + 
				"detail_disp_item_cfg_xxxxx " + 
				"where " + 
				"DETAIL_ID = '"+ detailID + "' " +
				"and " + 
				"TARGET = '"+ target + "' " +
				"and " + 
				"USER_ID = 'SYSTEM') AS b " + 
				"USING(DETAIL_ID, TARGET, ITEM_ID) " + 
				"where " + 
				"a.DETAIL_ID = '"+ detailID + "' " +
				"AND " + 
				"a.TARGET = '"+ target + "' " +
				"AND " + 
				"b.ITEM_ID IS NULL";
		
		return sql;
	}
}
