package order.input.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.BaseController;
import order.input.DAO.OrderInputDAO;
import order.input.beans.OrderInputBean;


public class OrderInputController extends BaseController {

	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");
				
		if(action.equals("orderinput")) {
				try {
					forwardURL = orderInput(request, response);
				} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else if(action.equals("orderupdate")) {
				forwardURL = orderUpdate(request, response);
		}
		
		return forwardURL;
	}
	
	/* 受注新規登録 */
	private String orderInput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		OrderInputDAO dao = new OrderInputDAO();
		
		OrderInputBean bean1 = new OrderInputBean();
		bean1.setDcName(request.getParameter("dcName"));
		List<OrderInputBean> list1 = new ArrayList<>();
		
		OrderInputBean bean2 = new OrderInputBean();
		bean2.setDcTimezone(request.getParameter("dcTimezone"));
		OrderInputBean bean3 = new OrderInputBean();
		bean3.setCtaxRate(request.getParameter("ctaxRate"));
		
		request.setAttribute("initDcName", bean1);
		request.setAttribute("initDcTimezone", bean2);
		request.setAttribute("initTaxRate", bean3);
		
		return "order\\orderinput.jsp";
		
	}
	
	/* 受注更新 */
	private String orderUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return null;
		
	}
	
}
