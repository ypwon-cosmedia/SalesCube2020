package sql.common;

import common.modal.product.beans.ProductModalSearchBean;

public class CommonSQL {
	
	public String stringIsNull(String str) {
		if(str == null || str.equals(""))
			return "LIKE '%' OR 1 = 1) ";
		else
			return "LIKE '"+str+"%') ";
	}
	

	public String initComboBox(String categoryID) {
		
		String sql;
		
		sql = "select CATEGORY_CODE, CATEGORY_CODE_NAME from category_trn_xxxxx where CATEGORY_ID = " + categoryID;
		
		return sql;
	}
	
	public String productModalSearch(ProductModalSearchBean bean) {
		
		String sql;
		
		sql = "select " + 
				"pmx.PRODUCT_CODE, " + 
				"pmx.PRODUCT_NAME, " + 
				"smx.SUPPLIER_NAME " + 
				"from " + 
				"product_mst_xxxxx as pmx " + 
				"left outer join " + 
				"supplier_mst_xxxxx as smx " + 
				"using(SUPPLIER_CODE) " + 
				"where " +
				"(pmx.PRODUCT_CODE " + stringIsNull(bean.getProductCode()) +
				"and " +
				"(pmx.SUPPLIER_PCODE " + stringIsNull(bean.getSupllierPcode()) +
				"and " +
				"(pmx.JAN_PCODE " + stringIsNull(bean.getJanPcode()) +
				"and " +
				"(pmx.SET_TYPE_CATEGORY " + stringIsNull(bean.getSetTypeCategory()) +
				"and " +
				"(pmx.PRODUCT_STANDARD_CATEGORY " + stringIsNull(bean.getProductStandardCategory()) +
				"and " +
				"(pmx.PRODUCT_STATUS_CATEGORY " + stringIsNull(bean.getProductStatusCategory()) +
				"and " +
				"(pmx.PRODUCT_NAME " + stringIsNull(bean.getProductName()) +
				"and " +
				"(pmx.PRODUCT_KANA " + stringIsNull(bean.getProductKana());
		
		return sql;
	}
}
