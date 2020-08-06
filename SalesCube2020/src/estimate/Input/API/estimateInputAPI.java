/**
 * 
 */
package estimate.Input.API;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import estimate.Input.beans.TaxRateBean;
import estimate.Input.dao.EstimateInputCommonDAO;
import estimate.common.beans.CategoryBean;
import estimate.common.dao.CategoryDAO;

/**
 * @author cosmedia
 *
 */
public class estimateInputAPI {

	
	public List<TaxRateBean> getTaxRateList()
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		EstimateInputCommonDAO dao =  new EstimateInputCommonDAO();
		List<TaxRateBean> taxRateList = dao.getTaxRate();
		
		return taxRateList;
	}
	
	public List<CategoryBean> getCategoryList(int categoryId)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		CategoryDAO cdao = new CategoryDAO();
		List<CategoryBean> submitPreList = cdao.CategoryGet(categoryId); // 提出先敬称取得
		
		return submitPreList;
	}
}
