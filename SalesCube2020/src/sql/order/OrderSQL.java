package sql.order;

public class OrderSQL {
	
	public String initCategory() {
		
		String sql;
		
		sql = "select CLASS_CODE_1, CLASS_CODE_2, CLASS_CODE_3, CLASS_NAME from product_class_mst_xxxxx";
		
		return sql;
		
	}
}
