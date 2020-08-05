/**
 * 
 */
package estimate.Input.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.BaseAJAXController;
import common.controller.BaseController;

/**
 * @author cosmedia
 *
 */
public class EstimateInputCommonController extends BaseAJAXController  {

	public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String action = request.getParameter("action");


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
