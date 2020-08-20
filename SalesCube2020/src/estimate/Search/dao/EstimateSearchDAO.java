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
	public List<EstimateSearchResultBean> estimateSearchResult(EstimateSearchBean bean, UserInfoBean user) throws SQLException, ClassNotFoundException{
		
		List<EstimateConfigurationBean> list1 =new ArrayList<>();
		List<EstimateSearchResultBean> list = new ArrayList<>();
		
		
		EstimateSQL sqllist = new EstimateSQL();
		
		Connection con;
		Statement stmt = null;
		ResultSet result = null;
		
		con = super.getConnection();
		stmt = con.createStatement();
		
		String estimateResult;
		
		 list1 =  estimateConfiguration(user);
		
		
		
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
		
		
				
		estimateResult = "select " +
		
					row +		
		
				//"ESTIMATE_SHEET_ID, ESTIMATE_DATE, VALID_DATE, SUBMIT_NAME , ctx.CATEGORY_CODE_NAME, CUSTOMER_CODE, CUSTOMER_NAME, RETAIL_PRICE_TOTAL, CTAX_PRICE_TOTAL, DELIVERY_INFO, USER_NAME, USER_ID, REMARKS, DELIVERY_NAME, ESTIMATE_CONDITION, ESTIMATE_TOTAL, (RETAIL_PRICE_TOTAL - COST_TOTAL) as GrossProfit, (ROUND((RETAIL_PRICE_TOTAL - COST_TOTAL)/RETAIL_PRICE_TOTAL*100,2)) as GrossProfitMargin, TITLE " +				
				"from " +
				"ESTIMATE_SHEET_TRN_XXXXX " +
				"left outer join " +
				"(select CATEGORY_ID, CATEGORY_CODE, CATEGORY_CODE_NAME " +
				"from " +
				"CATEGORY_TRN_XXXXX  where CATEGORY_ID='10') " +
				"as ctx " +
				"ON SUBMIT_PRE = ctx.CATEGORY_CODE " +
				"where " +
				"(ESTIMATE_SHEET_ID LIKE '%' OR ESTIMATE_SHEET_ID IS NULL) " +
				"AND " +
				"(ESTIMATE_DATE LIKE '%' OR ESTIMATE_DATE IS NULL) " +
				"AND " +
				"(VALID_DATE LIKE '%' OR VALID_DATE IS NULL) " +
				"AND " +
				"(USER_ID LIKE '%' OR USER_ID IS NULL) " +
				"AND " +
				"(USER_NAME LIKE '%' OR USER_NAME IS NULL) " +
				"AND " +
				"(TITLE LIKE '%' OR TITLE IS NULL) " +
				"AND " +
				"(REMARKS LIKE '%' OR REMARKS IS NULL) " +
				"AND " +
				"(SUBMIT_NAME LIKE '%' OR SUBMIT_NAME IS NULL) " +
				"AND " +
				"(CUSTOMER_CODE LIKE '%' OR CUSTOMER_CODE IS NULL) " +
				"AND " +
				"(CUSTOMER_NAME LIKE '%' OR CUSTOMER_NAME IS NULL) " +
				"order by " +
				"ESTIMATE_SHEET_ID ";
		System.out.println("テスト"+ estimateResult);
		result = stmt.executeQuery(estimateResult);
		
		while(result.next()) {
			EstimateSearchResultBean bean1 = new EstimateSearchResultBean();
			bean1.setEstimateSheetId(result.getString("ESTIMATE_SHEET_ID"));
			bean1.setEstimateDate(result.getString("ESTIMATE_DATE"));
			bean1.setValidDate(result.getString("VALID_DATE"));
			bean1.setSubmitName(result.getString("SUBMIT_NAME"));
			bean1.setSubmitPre(result.getString("SUBMIT_PRE"));
			bean1.setCustomerCode(result.getString("CUSTOMER_CODE"));
			bean1.setCustomerName(result.getString("CUSTOMER_NAME"));
			bean1.setGrossProfit(result.getString("GrossProfit"));
			bean1.setGrossProfitMargin(result.getString("GrossProfitMargin"));
			bean1.setRetailPriceTotal((result.getBigDecimal("RETAIL_PRICE_TOTAL")).intValue());
			bean1.setCtaxPriceTotal((result.getBigDecimal("CTAX_PRICE_TOTAL")).intValue());
			bean1.setDeliveryInfo(result.getString("DELIVERY_INFO"));
			bean1.setUserId(result.getString("USER_ID"));
			bean1.setUserName(result.getString("USER_NAME"));
			bean1.setRemarks(result.getString("REMARKS"));
			bean1.setDeliveryName(result.getString("DELIVERY_NAME"));
			bean1.setEstimateCondition(result.getString("ESTIMATE_CONDITION"));
			bean1.setEstimateTotal((result.getBigDecimal("ESTIMATE_TOTAL")).intValue());
			bean1.setTitle(result.getString("TITLE"));
			int i =0;
			String str = list1.get(i++).getItemId();
			bean1.setItemId(str);
			
			list.add(bean1);
		}
		
		super.releaseDB(con,stmt,result);
		
		return list;
			
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

