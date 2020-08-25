package order.move.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.BaseController;
import common.modal.product.init.ProductModalInit;
import estimate.common.controller.EstimateCategoryModalAJAXController;
import order.common.init.DAO.OrderInitDAO;
import order.input.DAO.OrderInputDAO;
import order.input.beans.OrderInputBean;
import user.DAO.UserDAO;
import user.beans.UserInfoBean;
import user.controller.UserController;

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

		HttpSession session = request.getSession();
		UserInfoBean user = (UserInfoBean) session.getAttribute("userInfo");

		List<OrderInputBean> list1 = dao.getDcName();
		List<OrderInputBean> list2 = dao.getDcTimezone();
		List<OrderInputBean> list3 = dao.getTaxRate();

		try {
			session.setAttribute("user", user.getNameKNJ());
			request.setAttribute("initDcName", list1);
			request.setAttribute("initDcTimezone", list2);
			request.setAttribute("initTaxRate", list3);
		}catch (NullPointerException e) {
			String message = "ログインした後で利用できます。\nログインしてください。";
			request.setAttribute("loginError", message);
			return "login.jsp";
		}

		return "order\\orderinput.jsp";
		
	}
	
	private String moveOrderUpdate (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		Integer roSlipId;
	
		OrderInputDAO dao = new OrderInputDAO();
		ProductModalInit init = new ProductModalInit();

		List<OrderInputBean> list1 = dao.getDcName();
		List<OrderInputBean> list2 = dao.getDcTimezone();
		List<OrderInputBean> list3 = dao.getTaxRate();
		List<OrderInputBean> list5 = new ArrayList<>();
		init.initCombobox(request, response);
		
		OrderInputBean bean = new OrderInputBean();
		
		try {
			roSlipId = Integer.parseInt(request.getParameter("roSlipId"));
			bean = dao.getOrderInfo(roSlipId);
			list5 = dao.getOrderInfodetail(roSlipId);
		}catch(NumberFormatException e) {
			String message = "ログインした後で利用できます。\nログインしてください。";
			request.setAttribute("loginError", message);
			return "login.jsp";
		}
		
		try {
			request.setAttribute("initDcName", list1);
			request.setAttribute("initDcTimezone", list2);
			request.setAttribute("initTaxRate", list3);
			request.setAttribute("order", bean);
			request.setAttribute("orderlist", list5);
		} catch (NullPointerException e) {
			String message = "ログインした後で利用できます。\nログインしてください。";
			request.setAttribute("loginError", message);
			return "login.jsp";
		}

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
		} catch (NullPointerException e) {
			String message = "ログインした後で利用できます。\nログインしてください。";
			request.setAttribute("loginError", message);
			return "login.jsp";
		}
	
		return "order\\ordersearch.jsp";
	}

	private String moveOnlineOrder (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(true);
		
		if(session.getAttribute("userInfo") == null) {
			String message = "ログインした後で利用できます。\nログインしてください。";
			request.setAttribute("loginError", message);
			return "login.jsp";
		}
		return "order\\onlineorderdataimport.jsp";
	}
}
