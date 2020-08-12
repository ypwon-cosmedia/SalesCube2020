package order.move.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.BaseController;
import common.modal.product.init.ProductModalInit;
import order.common.init.DAO.OrderInitDAO;
import order.input.DAO.OrderInputDAO;
import order.input.beans.OrderInputBean;
import user.beans.UserInfoBean;

public class OrderMoveController extends BaseController{
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");
		
		if(action.equals("orderinput"))
			try {
				forwardURL = moveOrderInput(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if(action.equals("orderupdate"))
			try {
				forwardURL = moveOrderUpdate(request, response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if(action.equals("ordersearch")) forwardURL = moveOrderSearch(request, response);
		else if(action.equals("onlineorder")) forwardURL = moveOnlineOrder(request, response);
		
		return forwardURL;
	}
	
	private String moveOrderInput (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		OrderInputDAO dao = new OrderInputDAO();
		ProductModalInit init = new ProductModalInit();

		List<OrderInputBean> list1 = dao.getDcName();
		List<OrderInputBean> list2 = dao.getDcTimezone();
		List<OrderInputBean> list3 = dao.getTaxRate();
		init.initCombobox(request, response);

		request.setAttribute("initDcName", list1);
		request.setAttribute("initDcTimezone", list2);
		request.setAttribute("initTaxRate", list3);
		
		return "order\\orderinput.jsp";
		
	}
	
	private String moveOrderUpdate (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String roSlipId = request.getParameter("roSlipId");
		
		OrderInputDAO dao = new OrderInputDAO();
		ProductModalInit init = new ProductModalInit();

		List<OrderInputBean> list1 = dao.getDcName();
		List<OrderInputBean> list2 = dao.getDcTimezone();
		List<OrderInputBean> list3 = dao.getTaxRate();
		OrderInputBean bean = dao.getOrderInfo(roSlipId);
		init.initCombobox(request, response);

		request.setAttribute("initDcName", list1);
		request.setAttribute("initDcTimezone", list2);
		request.setAttribute("initTaxRate", list3);
		request.setAttribute("order", bean);

		return "order\\orderupdate.jsp";
	}

	private String moveOrderSearch (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrderInitDAO dao = new OrderInitDAO();
		HttpSession session = request.getSession(true);
		UserInfoBean userID = (UserInfoBean) session.getAttribute("userInfo");
		ProductModalInit init = new ProductModalInit();
		
		try {
			
			request.setAttribute("category", dao.initCategory());
			request.setAttribute("configDetailShow", dao.initConfigModalShow("0301", "2", userID.getUserID()));
			request.setAttribute("configBillShow", dao.initConfigModalShow("0301", "1", userID.getUserID()));
			request.setAttribute("configDetailNotShow", dao.initConfigModalNotShow("0301", "2", userID.getUserID()));
			request.setAttribute("configBillNotShow", dao.initConfigModalNotShow("0301", "1", userID.getUserID()));
			init.initCombobox(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "order\\ordersearch.jsp";
	}

	private String moveOnlineOrder (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		return "order\\onlineorderdataimport.jsp";
	}
}
