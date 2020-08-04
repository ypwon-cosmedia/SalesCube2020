/**
 * 
 */
package estimate.Input.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import estimate.Input.beans.TaxRateBean;
import estimate.Input.dao.EstimateInputCommonDAO;


/**
 * @author cosmedia
 *
 */
public class EstimateAddController {

	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");
		
		try {
			if(action.equals("moveEstimateAdd")) forwardURL = moveEstimateAdd(request, response);
			else if(action.equals("estimateAdd")) forwardURL = estimateAdd(request, response);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

  		return forwardURL;
	}
	
	
	private String moveEstimateAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL     = "";

		EstimateInputCommonDAO dao =  new EstimateInputCommonDAO();
		List<TaxRateBean> taxRateList = dao.getTaxRate();
		
		//+ 顧客敬称取得//
		
		
		request.setAttribute("taxRateList",taxRateList);
			
		return forwardURL;
		
	}
	
	private String estimateAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL     = "";
			
		return forwardURL;
		
	}
}
