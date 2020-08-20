package sql.estimate;

import estimate.Search.beans.EstimateSearchBean;
import estimate.common.beans.UserModalSearchBean;
import user.beans.UserInfoBean;

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
	
	//見積検索テーブル取得
	public String estimateTableCreate(UserInfoBean bean) {
		String sql;
		
		sql = "SELECT " +
				"MST.ITEM_ID, MST.ITEM_NAME, MST.SORT_FLAG " +
				"FROM " +
				"DETAIL_DISP_ITEM_MST_XXXXX AS MST " +
				"LEFT OUTER JOIN " +
				"DETAIL_DISP_ITEM_CFG_XXXXX AS CFG " +
				"ON CFG.DETAIL_ID=MST.DETAIL_ID AND CFG.TARGET=MST.TARGET AND CFG.ITEM_ID=MST.ITEM_ID " +
				"WHERE CFG.USER_ID= '"+ bean.getUserID() +"' " +
				"AND CFG.TARGET='1' AND CFG.DETAIL_ID='0201' " +
				"ORDER BY CFG.SEQ ";
		
		return sql;
	}
	

	
}

