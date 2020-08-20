/**
 * 
 */
package estimate.Input.API;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;

import estimate.Input.beans.TaxRateBean;
import estimate.Input.dao.EstimateInputCommonDAO;
import estimate.common.beans.CategoryBean;
import estimate.common.dao.CategoryDAO;


public class estimateInputAPI {

	/* 消費税率取得 */
	public List<TaxRateBean> getTaxRateList()
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		EstimateInputCommonDAO dao =  new EstimateInputCommonDAO();
		List<TaxRateBean> taxRateList = dao.getTaxRate();
		
		return taxRateList;
	}
	
	/* カテゴリー取得 */
	public List<CategoryBean> getCategoryList(int categoryId)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		CategoryDAO cdao = new CategoryDAO();
		List<CategoryBean> submitPreList = cdao.CategoryGet(categoryId);
		
		return submitPreList;
	}
}
