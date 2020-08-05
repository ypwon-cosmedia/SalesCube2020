/**
 * 
 */
package estimate.Input.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.BaseController;

/**
 * @author cosmedia
 *
 */
public class EstimateInputCommonController extends BaseController  {

	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");

		try {
			if(action.equals("estimateCustomerSearch")) forwardURL = estimateCustomerSearch(request, response);
			else if(action.equals("estimateProductSearch")) forwardURL = estimateProductSearch(request, response);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

  		return forwardURL;

	}
	

	private String estimateCustomerSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL     = "";
			
		return forwardURL;
		
	}
	
	private String estimateProductSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL     = "";
			
		return forwardURL;
		
	}
	
}
