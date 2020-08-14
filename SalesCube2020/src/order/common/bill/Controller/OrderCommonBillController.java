package order.common.bill.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		else if(action.equals("billlink")) {
			try {
				EstimateToOrderInput(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/* 見積検索 */
	private void searchEstimate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		List<OrderCommonBillBean> list = new ArrayList<>();
		OrderCommonBillDAO dao = new OrderCommonBillDAO();
		
		
		String estimateSheetId = request.getParameter("estimateSheetId");
		String estimateDate = request.getParameter("estimateDate");
		String submitName = request.getParameter("submitName");
		String title = request.getParameter("title");
		
		OrderCommonBillBean bean = new OrderCommonBillBean();
		
		list = dao.billSearch(estimateSheetId, estimateDate, submitName, title, bean);

		request.setAttribute("billSearch", list);
		
	}
	
	/* 見積番号押下 受注新規登録画面に反映 */
	private void EstimateToOrderInput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		OrderCommonBillDAO dao = new OrderCommonBillDAO();
		OrderCommonBillBean bean1 = new OrderCommonBillBean();
		OrderCommonBillBean bean2 = new OrderCommonBillBean();
		OrderCommonBillBean bean3 = new OrderCommonBillBean();
		
		String estimateSheetId = request.getParameter("estimateSheetId");
		
		bean1 = dao.billToTaxRate(estimateSheetId);
		bean2 = dao.billToCustomer(estimateSheetId);
		bean3 = dao.billToDelivery(estimateSheetId);
		
		request.setAttribute("stockTaxRate", bean1);
		request.setAttribute("stockCustomer", bean2);
		request.setAttribute("stockDelivery", bean3);

	}
}
