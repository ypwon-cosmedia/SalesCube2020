package sql.estimate;

import estimate.common.beans.UserModalSearchBean;

public class EstimateSQL {
	public String stringIsNull(String str) {
		if(str == null || str.equals(""))
			return "LIKE '%' OR 1 = 1) ";
		else
			return "LIKE '"+str+"%') ";
	}
	
	public String userModalSearch(UserModalSearchBean bean) {
		String sql;		
		
		/*sql = "select USER_MST_XXXXX.USER_ID, NAME_KNJ, NAME from USER_MST_XXXXX" + 
				"left outer join " +  
					"DEPT_MST_XXXXX " +
					"using(DEPT_ID) " +				
				"right outer join " + 				
					"(select USER_ID, ROLE_ID " +
					"from GRANT_ROLE_XXXXX " + 
				"where " + 
					"(ROLE_ID " + stringIsNull(bean.getRoleId()) +
					"as userrole " + 
					"using(USER_ID) " +				
				"where " +	
					"(USER_MST_XXXXX.USER_ID " + stringIsNull(bean.getUserId()) +
					"and " +
					"(NAME_KNJ " + stringIsNull(bean.getNameKnj()) +
					"and " +
					"(NAME_KANA " + stringIsNull(bean.getNameKana()) +
					"and " +
					"(USER_MST_XXXXX.DEPT_ID " + stringIsNull(bean.getDeptId()) +
				"group by " +
					"USER_ID ";
		*/
		
		
		sql = "select USER_MST_XXXXX.USER_ID, NAME_KNJ, NAME as DEPT_ID from USER_MST_XXXXX " +
			  "left outer join " + 
			  "DEPT_MST_XXXXX " +
			  "USING(DEPT_ID) " +
			  "right outer join " +
			  "(select ROLE_ID, USER_ID  from GRANT_ROLE_XXXXX where (ROLE_ID LIKE '%' OR ROLE_ID IS NULL) ) as userrole " +
			  "USING(USER_ID) " +
			  "where (USER_MST_XXXXX.USER_ID LIKE '%' OR USER_MST_XXXXX.USER_ID IS NULL) " +
			  "and (NAME_KNJ LIKE '%' OR NAME_KNJ IS NULL)  " +
			  "and (NAME_KANA LIKE '%' OR NAME_KANA IS NULL) " +
			  "and (USER_MST_XXXXX.DEPT_ID LIKE '%' OR USER_MST_XXXXX.DEPT_ID IS NULL) " +
			  "group by(USER_ID) ";
			  
		return sql;	
	}
}

