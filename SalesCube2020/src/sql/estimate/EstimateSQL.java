package sql.estimate;

import estimate.Search.beans.EstimateSearchBean;
import estimate.common.beans.UserModalSearchBean;

public class EstimateSQL {
	
	public String stringIsNull(String str) {
		if(str == null || str.equals(""))
			return "LIKE '%' OR 1 = 1) ";
		else
			return "LIKE '"+str+"%') ";
	}
	
	//担当者検索
	public String userModalSearch(UserModalSearchBean bean) {
		String sql;		
		
		sql = "select " +
			  "USER_MST_XXXXX.USER_ID, NAME_KNJ, NAME as DEPT_ID " +
			  "from " +
			  "USER_MST_XXXXX " +
			  "left outer join " + 
			  "DEPT_MST_XXXXX " +
			  "using(DEPT_ID) " +
			  "right outer join " +
			  "(select ROLE_ID, USER_ID " +
			  "from GRANT_ROLE_XXXXX " +
			  "where " +
			  "(ROLE_ID " + stringIsNull(bean.getRoleId()) +
			  "AND (USER_ID " + stringIsNull(bean.getUserId()) +
			  ") as userrole " +
			  "using(USER_ID) " +
			  "where " +
			  "(USER_MST_XXXXX.USER_ID " + stringIsNull(bean.getUserId()) +
			  "and " +
			  "(NAME_KNJ " + stringIsNull(bean.getNameKnj()) +
			  "and " +
			  "(NAME_KANA " + stringIsNull(bean.getNameKana()) +
			  "and " +
			  "(USER_MST_XXXXX.DEPT_ID " + stringIsNull(bean.getDeptId()) +
			  "group by(USER_ID) ";
			  
		return sql;	
	}
	
	//見積検索
	public String estimateSearch(EstimateSearchBean bean) {
		String sql;	
		
		sql = "select " +
				"ESTIMATE_SHEET_ID, ESTIMATE_DATE, VALID_DATE, SUBMIT_NAME, a.CATEGORY_CODE_NAME, CUSTOMER_CODE, CUSTOMER_NAME, RETAIL_PRICE_TOTAL, CTAX_PRICE_TOTAL, DELIVERY_INFO, USER_NAME, USER_ID, REMARKS, DELIVERY_NAME, ESTIMATE_CONDITION, ESTIMATE_TOTAL, RETAIL_PRICE_TOTAL - COST_TOTAL, ROUND((RETAIL_PRICE_TOTAL - COST_TOTAL)/RETAIL_PRICE_TOTAL*100,2)
				from ESTIMATE_SHEET_TRN_XXXXX
				left outer join 
				(select CATEGORY_ID, CATEGORY_CODE, CATEGORY_CODE_NAME from CATEGORY_TRN_XXXXX  where CATEGORY_ID="10" )as a
				ON ESTIMATE_SHEET_TRN_XXXXX.SUBMIT_PRE = a.CATEGORY_CODE

				where (ESTIMATE_SHEET_ID LIKE '%' OR ESTIMATE_SHEET_ID IS NULL)
				AND  (ESTIMATE_DATE LIKE '%' OR ESTIMATE_DATE IS NULL)
				AND  (VALID_DATE LIKE '%' OR VALID_DATE IS NULL)
				AND  (USER_ID LIKE '%' OR USER_ID IS NULL)
				AND  (USER_NAME LIKE '%' OR USER_NAME IS NULL)
				AND  (TITLE LIKE '%' OR TITLE IS NULL)
				AND  (REMARKS LIKE '%' OR REMARKS IS NULL)
				AND  (SUBMIT_NAME LIKE '%' OR SUBMIT_NAME IS NULL)
				AND  (CUSTOMER_CODE LIKE '%' OR CUSTOMER_CODE IS NULL)
				AND  (CUSTOMER_NAME LIKE '%' OR CUSTOMER_NAME IS NULL)
				order by ESTIMATE_SHEET_ID;
	}
}

