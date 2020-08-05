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
public class EstimateModifyController extends BaseController {

	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");
<<<<<<< HEAD
		
=======
>>>>>>> branch 'master' of https://github.com/ypwon-cosmedia/SalesCube2020.git

		try {
			if(action.equals("moveEstimateModify")) forwardURL = moveEstimateModify(request, response);
			else if(action.equals("estimateModify")) forwardURL = estimateModify(request, response);
			else if(action.equals("estimateDelete")) forwardURL = estimateDelete(request, response);
			else if(action.equals("estimatePdfOutput")) forwardURL = estimatePdfOutput(request, response);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

  		return forwardURL;

	}
	

	private String moveEstimateModify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL     = "";
			
		return forwardURL;
		
	}
	
	private String estimateModify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL     = "";
			
		return forwardURL;
		
	}
	
	private String estimatePdfOutput(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL     = "";
			
		return forwardURL;
		
	}
	
	private String estimateDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL     = "";
			
		return forwardURL;
		
	}

}

