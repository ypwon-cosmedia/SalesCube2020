package estimate.Search.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.dao.BaseDAO;
import estimate.Search.beans.EstimateSearchResultBean;
import estimate.Search.beans.EstimateSearchBean;
import sql.estimate.EstimateSQL;

public class EstimateSearchDAO extends BaseDAO {
	public List<EstimateSearchResultBean> estimateSearchResult(EstimateSearchBean bean) throws SQLException, ClassNotFoundException{
		
		List<EstimateSearchResultBean> list = new ArrayList<>();
		
		EstimateSQL sqllist = new EstimateSQL();
		
		Connection con;
		Statement stmt = null;
		ResultSet result = null;
		
		con = super.getConnection();
		stmt = con.createStatement();
		
		String sql;
		
		sql = sqllist.estimateSearch(bean);
		result = stmt.executeQuery(sql);
		
		while(result.next()) {
			EstimateSearchResultBean bean1 = new EstimateSearchResultBean();
			bean1.setEstimateSheetId(result.getString("ESTIMATE_SHEET_ID"));
			bean1.setEstimateDate(result.getString("ESTIMATE_DATE"));
			bean1.setValidDate(result.getString("VALID_DATE"));
			bean1.setSubmitName(result.getString("SUBMIT_NAME"));
			bean1.setSubmitPre(result.getString("SUBMIT_PRE"));
			bean1.setCustomerCode(result.getString("CUSTOMER_CODE"));
			bean1.setCustomerName(result.getString("CUSTOMER_NAME"));
			bean1.setGrossProfit(result.getString("RETAIL_PRICE_TOTAL - COST_TOTAL"));
			bean1.setGrossProfitMargin(result.getString("(RETAIL_PRICE_TOTAL - COST_TOTAL)/RETAIL_PRICE_TOTAL"));
			bean1.setRetailPriceTotal(result.getInt("RETAIL_PRICE_TOTAL"));
			bean1.setCtaxPriceTotal(result.getInt("CTAX_PRICE_TOTAL"));
			bean1.setDeliveryInfo(result.getString("DELIVERY_INFO"));
			bean1.setUserId(result.getString("USER_ID"));
			bean1.setUserName(result.getString("USER_NAME"));
			bean1.setRemarks(result.getString("REMARKS"));
			bean1.setDeliveryName(result.getString("DELIVERY_NAME"));
			bean1.setEstimateCondition(result.getString("ESTIMATE_CONDITION"));
			bean1.setEstimateTotal(result.getInt("ESTIMATE_TOTAL"));
			bean1.setTitle(result.getString("TITLE"));
			
			list.add(bean1);
		}
		System.out.println("listSize;"+list.size());
		super.releaseDB(con,stmt,result);
		
		return list;
			
	}
}

