package order.common.bill.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.BaseController;
import order.common.bill.DAO.OrderCommonBillDAO;
import order.common.bill.beans.OrderCommonBillBean;

public class OrderCommonBillController extends BaseController {

	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");
				
		if(action.equals("orderinput")) {
				try {
					forwardURL = EstimateToOrderInput(request, response);
				} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return forwardURL;
	}
	
	/* 見積検索 */
	private String searchEstimate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		List<OrderCommonBillBean> list1 = new ArrayList<>();
		OrderCommonBillDAO dao1 = new OrderCommonBillDAO();
		
		return null;
		
	}
	
	/* 見積番号押下 受注新規登録画面に反映 */
	private String EstimateToOrderInput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		OrderCommonBillDAO dao = new OrderCommonBillDAO();
		OrderCommonBillBean bean1 = new OrderCommonBillBean();
				
		
		return null;
		
		
	}
}
