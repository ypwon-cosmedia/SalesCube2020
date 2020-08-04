/**
 * 
 */
package estimate.unitPriceInquiry.Controller;

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
public class UnitPriceInquiryController extends BaseController {

	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");
		
		try {
			if(action.equals("moveUnitPriceInquiry")) forwardURL = moveUnitPriceInquiry(request, response);
			else if(action.equals("unitPriceInquirySearch")) forwardURL = unitPriceInquirySearch(request, response);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

  		return forwardURL;
	}
	
	private String moveUnitPriceInquiry(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL     = "";
			
		return forwardURL;
		
	}
	
	private String unitPriceInquirySearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL     = "";
			
		return forwardURL;
		
	}
	
}
