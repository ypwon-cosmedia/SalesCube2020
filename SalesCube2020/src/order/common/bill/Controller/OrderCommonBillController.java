package order.common.bill.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import common.controller.BaseAJAXController;
import common.controller.BaseController;
import order.common.bill.DAO.OrderCommonBillDAO;
import order.common.bill.beans.OrderCommonBillBean;

public class OrderCommonBillController extends BaseAJAXController {

	public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String action = request.getParameter("action");
				
		if(action.equals("billsearch")) {
				try {
					searchEstimate(request, response);
				} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	/* 見積検索 */
	private void searchEstimate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		List<OrderCommonBillBean> list = new ArrayList<OrderCommonBillBean>();
		OrderCommonBillDAO dao = new OrderCommonBillDAO();
		OrderCommonBillBean bean = new OrderCommonBillBean();
		
		bean.setEstimateSheetId(request.getParameter("inputEstimateSheetId"));
		bean.setEstimateDate1(request.getParameter("inputEstimateDate1"));
		bean.setEstimateDate2(request.getParameter("inputEstimateDate2"));
		bean.setSubmitName(request.getParameter("inputSubmitName"));
		bean.setTitle(request.getParameter("inputTitle"));
	
		Gson gson = new Gson();
		
		try {
			list = dao.billSearch(bean);
			JsonArray jArray = gson.toJsonTree(list).getAsJsonArray();
			
			JsonObject jObject = new JsonObject();
			
			jObject.add("list", jArray);
			
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(jObject);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
