package order.input.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

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
		}else if(action.equals("orderinputCmp")) {
			forwardURL = orderInputCmp(request, response);
		}else if(action.equals("orderupdate")) {
				forwardURL = orderUpdate(request, response);
		}
		
		return forwardURL;
	}
	
	/* 受注新規登録 初期値 */
	private String orderInput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		OrderInputDAO dao = new OrderInputDAO();

		List<OrderInputBean> list1 = dao.getDcName();
		List<OrderInputBean> list2 = dao.getDcTimezone();
		List<OrderInputBean> list3 = dao.getTaxRate();

		request.setAttribute("initDcName", list1);
		request.setAttribute("initDcTimezone", list2);
		request.setAttribute("initTaxRate", list3);
		
		return "order\\orderinput.jsp";
		
	}
	
	/* 受注新規登録 */
	private String orderInputCmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		OrderInputDAO dao = new OrderInputDAO();
		
		Date roDate = request.getParameter("roDate");
		Date shipDate = nullOrEmpty(request.getParameter("shipDate"));
		Date deliveryDate = nullOrEmpty(request.getParameter("deliveryDate"));
		String ReceptNo = nullOrEmpty(request.getParameter("ReceptNo"));
		String customerSlipNo;
		String userName;
		String remarks;
		String dcName;
		String dcTimezone;
		String ctaxRate;
		String customerCode;
		String customerName;
		String taxShiftCategory;
		String cutoffGroup;
		String salesCmCategory;
		String customerRemarks;
		String customerCommentData;
		String deliveryName;
		String deliveryOfficeName;
		String deliveryDeptName;
		String deliveryZipCode;
		String deliveryAddress1;
		String deliveryAddress2;
		String deliveryPcName;
		String deliveryPcKana;
		String deliveryPcPre;
		String deliveryTel;
		String deliveryFax;
		String deliveryEmail;
		String productCode;
		String productName;
		String productRemarks;
		String rackCode;
		Integer quantity;
		Integer unitCost;
		Integer cost;
		Integer unitRetailPrice;
		Integer retailPrice;
		String inputProductRemarks;
		String eadRemarks;
		String prossProfit;
		String grossProfitRatio;
		String retailPriceTotal;
		Integer ctaxPriceTotal;
		String priceTotal;
		
		OrderInputBean bean = new OrderInputBean();
		bean.setRoDate(roDate);
		bean.setShipDate(shipDate);
		bean.setDeliveryDate(deliveryDate);
		bean.setReceptNo(ReceptNo);
		bean.setCustomerSlipNo(customerSlipNo);
		
		
		return "order\\orderinput.jsp";
		
	}
	

	/* 受注更新 */
	private String orderUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return null;
		
	}
	
	public String nullOrEmpty(String str) {
		if (str == null || str.equals("")) {
			str = null;
		}
		return str;
	}
	
}
