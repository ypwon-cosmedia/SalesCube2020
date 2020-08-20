package estimate.Search.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import common.dao.BaseDAO;
import estimate.Search.beans.EstimateSearchResultBean;
import estimate.common.beans.EstimateConfigurationBean;
import estimate.Search.beans.EstimateSearchBean;
import sql.estimate.EstimateSQL;
import user.beans.UserInfoBean;

public class EstimateSearchDAO extends BaseDAO {
	public List<String[]> estimateSearchResult(EstimateSearchBean bean, UserInfoBean user) throws SQLException, ClassNotFoundException{
		
		List<EstimateConfigurationBean> list1 =new ArrayList<>();
		List<String[]> list = new ArrayList<>();
		
		
		EstimateSQL sqllist = new EstimateSQL();
		
		Connection con;
		Statement stmt = null;
		ResultSet result = null;
		
		con = super.getConnection();
		stmt = con.createStatement();
		
		String estimateResult;
		
		list1 =  estimateConfiguration(user);
		
		
		//見積検索の見出し部の決定
		String row = "";
		for(int i = 0; i < list1.size(); i++) {
			switch(list1.get(i).getItemId()) {
				case "estimateSheetId" :
					row += "ESTIMATE_SHEET_ID, " ; 
					break;
				case "estimateDate" :
					row += "ESTIMATE_DATE, ";
					break;
				case "deliveryInfo" :
					row += "DELIVERY_INFO, ";
					break;
				case "validDate" :
					row += "VALID_DATE, ";
					break;
				case "userId" :
					row += "USER_ID, ";
					break;
				case "userName" :
					row += "USER_NAME, ";
					break;
				case "title" :
					row += "TITLE, ";
					break;
				case "remarks" :
					row += "REMARKS, ";
					break;
				case "deliveryName" :
					row += "DELIVERY_NAME, ";
					break;
				case "estimateCondition" :
					row += "ESTIMATE_CONDITION, ";
					break;
				case "submitName" :
					row += "SUBMIT_NAME , ";
					break;
				case "submitPre" :
					row += "(ctx.CATEGORY_CODE_NAME) as SUBMIT_PRE, ";
					break;
				case "customerCode" :
					row += "CUSTOMER_CODE, ";
					break;
				case "customerName" :
					row += "CUSTOMER_NAME, ";
					break;
				case "grossMargin" :
					row += "(RETAIL_PRICE_TOTAL - COST_TOTAL) as GrossProfit, ";
					break;
				case "grossMarginRate" :
					row += "(ROUND((RETAIL_PRICE_TOTAL - COST_TOTAL)/RETAIL_PRICE_TOTAL*100,2)) as GrossProfitMargin, ";
					break;
				case "retailPriceTotal" :
					row += "RETAIL_PRICE_TOTAL, ";
					break;
				case "ctaxPriceTotal" :
					row += "CTAX_PRICE_TOTAL, ";
					break;
				case "estimateTotal" :
					row += "ESTIMATE_TOTAL, ";
					break;
					
			}
		}
		row = row.substring(0, row.length()-2) + " ";
	
		//検索結果SQL
		estimateResult = "select " +
		
					row +		
		
				"from " +
				"ESTIMATE_SHEET_TRN_XXXXX " +
				"left outer join " +
				"(select CATEGORY_ID, CATEGORY_CODE, CATEGORY_CODE_NAME " +
				"from " +
				"CATEGORY_TRN_XXXXX  where CATEGORY_ID='10') " +
				"as ctx " +
				"ON SUBMIT_PRE = ctx.CATEGORY_CODE " +
				"where " +
				"(ESTIMATE_SHEET_ID " + stringIsNull(bean.getEstimateSheetId()) +
				"AND " +
				"(ESTIMATE_DATE " + stringIsNull(bean.getEstimateDateStart(),bean.getEstimateDateEnd()) +
				"AND " +
				"(VALID_DATE " + stringIsNull(bean.getValidDateStart(),bean.getValidDateEnd()) +
				"AND " +
				"(USER_ID " + stringIsNull(bean.getUserId()) +
				"AND " +
				"(USER_NAME " + stringIsNull(bean.getUserName()) +
				"AND " +
				"(TITLE " + stringIsNull(bean.getTitle()) +
				"AND " +
				"(REMARKS " + stringIsNull(bean.getRemarks()) +
				"AND " +
				"(SUBMIT_NAME " + stringIsNull(bean.getSubmitName()) +
				"AND " +
				"(CUSTOMER_CODE " + stringIsNull(bean.getCustomerCode()) +
				"AND " +
				"(CUSTOMER_NAME " + stringIsNull(bean.getCustomerName()) +
				"order by " +
				"ESTIMATE_SHEET_ID ";
		
		System.out.println("テスト"+ estimateResult);
		result = stmt.executeQuery(estimateResult);
		
		while(result.next()) {
			String[] tmp = new String[list1.size()];
			for(int i = 0; i<tmp.length; i++) {
				tmp[i] = result.getString(i+1);
			}
			
			list.add(tmp);
		}
		
		super.releaseDB(con,stmt,result);
		
		return list;
			
	}
	
	
	private String stringIsNull(String estimateDateStart, String estimateDateEnd) {
		// TODO Auto-generated method stub
		return null;
	}


	private String dateIsNull(String estimateDateStart, String estimateDateEnd) {
		// TODO Auto-generated method stub
		return null;
	}


	private String stringIsNull(String estimateSheetId) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<EstimateConfigurationBean> estimateConfiguration(UserInfoBean user) throws SQLException, ClassNotFoundException{
		List<EstimateConfigurationBean> list1 =new ArrayList<>();
		
		EstimateSQL sqllist = new EstimateSQL();
		
		Connection con;
		Statement stmt = null;
		ResultSet result = null;
		
		con = super.getConnection();
		stmt = con.createStatement();
		
		
		String estimateTableCreate;
		
		estimateTableCreate = sqllist.estimateTableCreate(user);
		
		result = stmt.executeQuery(estimateTableCreate);
		
		while(result.next()) {
			EstimateConfigurationBean cfg = new EstimateConfigurationBean();
			cfg.setItemId(result.getString("ITEM_ID"));
			cfg.setItemName(result.getString("ITEM_NAME"));
			cfg.setSortFlag(result.getString("SORT_FLAG"));
			
			list1.add(cfg);
		}
		super.releaseDB(con,stmt,result);
		
		return list1;
	}
}

