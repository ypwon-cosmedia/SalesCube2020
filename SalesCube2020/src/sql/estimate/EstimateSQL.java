package sql.estimate;

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
}

