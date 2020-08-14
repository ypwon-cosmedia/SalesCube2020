/**
 * 
 */
package estimate.Input.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import common.controller.BaseAJAXController;
import common.controller.BaseController;
import estimate.Input.beans.GetCustomerBean;
import estimate.Input.beans.GetProductBean;
import estimate.Input.dao.EstimateInputCommonDAO;
import estimate.common.beans.CategoryBean;
import estimate.common.dao.CategoryDAO;

/**
 * @author cosmedia
 *
 */
public class EstimateInputCommonController extends BaseAJAXController  {

	public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String action = request.getParameter("action");
		
		try {
		if(action.equals("confirmEstimateSheetId")) confirmEstimateSheetId(request, response);
		else if(action.equals("estimateCustomerSearch")) estimateCustomerSearch(request, response); 
		else if(action.equals("estimateProductSearch")) estimateProductSearch(request, response); 
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}


	private void confirmEstimateSheetId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String check = "NG";
		String estimateSheetId = request.getParameter("estimateSheetId");//見積番号を受け取る
		
		EstimateInputCommonDAO dao = new EstimateInputCommonDAO();
		
		Gson gson = new Gson();
		
		try {
			check = dao.confirmEstimateSheetId(estimateSheetId); //入力した見積番号が登録されているか確認
			
			String data = gson.toJson(check);
						
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(data);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	

	private void estimateCustomerSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String customerCode = request.getParameter("customerCode");//顧客コードを受け取る
		
		EstimateInputCommonDAO dao = new EstimateInputCommonDAO();
		
		GetCustomerBean bean = new GetCustomerBean();
		
		Gson gson = new Gson();
		try {
			bean = dao.getCustomer(customerCode);
			
			String data = gson.toJson(bean);
						
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(data);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void estimateProductSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String productCode = request.getParameter("productCode");//顧客コードを受け取る
		
		EstimateInputCommonDAO dao = new EstimateInputCommonDAO();
		
		GetProductBean bean = new GetProductBean();
		
		Gson gson = new Gson();
		try {
			bean = dao.getProduct(productCode);
			
			String data = gson.toJson(bean);
						
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(data);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
