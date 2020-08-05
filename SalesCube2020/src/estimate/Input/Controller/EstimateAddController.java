/**
 * 
 */
package estimate.Input.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.BaseController;
import estimate.Input.beans.EstimateAddBean;
import estimate.Input.beans.EstimateProductAddBean;
import estimate.Input.beans.TaxRateBean;
import estimate.Input.dao.EstimateAddDAO;
import estimate.Input.dao.EstimateInputCommonDAO;
import master.setProduct.DAO.SetProductDAO;
import master.setProduct.beans.SetProductBean;


/**
 * @author cosmedia
 *
 */
public class EstimateAddController extends BaseController {

	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");
		
		try {
			if(action.equals("moveEstimateAdd")) forwardURL = moveEstimateAdd(request, response);
			else if(action.equals("estimateAdd")) forwardURL = estimateAdd(request, response);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

  		return forwardURL;
	}
	
	
	private String moveEstimateAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL     = "estimate/estimateadd.jsp";

		EstimateInputCommonDAO dao =  new EstimateInputCommonDAO();
		List<TaxRateBean> taxRateList = dao.getTaxRate();
		
		//+ 顧客敬称取得
		
		request.setAttribute("taxRateList",taxRateList);
			
		return forwardURL;
		
	}
	
	private String estimateAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL     = "estimate/estimateadd.jsp";
		
		EstimateAddDAO dao = new EstimateAddDAO();
		EstimateAddBean bean = new EstimateAddBean(); //(見積商品を除く)見積登録用のbean
		List<EstimateProductAddBean> list = new ArrayList<EstimateProductAddBean>(); //見積商品登録のリスト
		
		//(見積商品を除く)見積登録用のbeanに値をセット
		bean.setEstimateSheetId(request.getParameter("estimateSheetId"));
		bean.setEstimateDate(request.getParameter("estimateDate"));
		bean.setDeliveryInfo(request.getParameter("deliveryInfo"));
		bean.setValidDate(request.getParameter("validDate"));
		bean.setUserName(request.getParameter("userName"));
		bean.setTitle(request.getParameter("title"));
		bean.setDeliveryName(request.getParameter("deliveryName"));
		bean.setEstimateCondition(request.getParameter("estimateCondition"));
		bean.setCtaxRate(Double.parseDouble(request.getParameter("ctaxRate")));
		bean.setSubmitName(request.getParameter("submitName"));
		bean.setSubmitPre(request.getParameter("submitPre"));
		bean.setCustomerCode(request.getParameter("customerCode"));
		bean.setCustomerName(request.getParameter("customerName"));
		bean.setCustomerRemarks(request.getParameter("customerRemarks"));
		bean.setCustomerComment(request.getParameter("customerComment"));
		bean.setRemarks(request.getParameter("remarks"));
		bean.setMemo(request.getParameter("memo"));
		bean.setRetailPriceTotal(Integer.parseInt(request.getParameter("retailPriceTotal")));
		bean.setCtaxPriceTotal(Integer.parseInt(request.getParameter("taxPriceTotal")));
		bean.setEstimateTotal(Integer.parseInt(request.getParameter("estimateTotal")));
		bean.setCreUser(request.getParameter("userName"));
		
		//見積商品登録用の値の配列を取得
		String[] lineNo = request.getParameterValues("lineNo");
		String[] productCode = request.getParameterValues("productCode");
		String[] productAbstract = request.getParameterValues("productAbstract");
		String[] quantity = request.getParameterValues("quantity");
		String[] unitCost = request.getParameterValues("unitCost");
		String[] cost = request.getParameterValues("cost");
		String[] unitRetailPrice = request.getParameterValues("unitRetailPrice");
		String[] retailPrice = request.getParameterValues("retailPrice");
		String[] productRemarks = request.getParameterValues("productRemarks");
		String[] creUser = request.getParameterValues("userName");
		
		//見積商品登録用のbeanに値をセット
		if(productCode != null) {
			for(int i = 0; i<lineNo.length; i++) {				
				EstimateProductAddBean productBean = new EstimateProductAddBean();
				productBean.setLineNo(Integer.parseInt(lineNo[i]));
				productBean.setProductCode(productCode[i]);
				productBean.setProductAbstract(productAbstract[i]);
				productBean.setQuantity(Integer.parseInt(quantity[i]));
				productBean.setUnitCost(Integer.parseInt(unitCost[i]));
				productBean.setCost(Integer.parseInt(cost[i]));
				productBean.setUnitRetailPrice(Integer.parseInt(unitRetailPrice[i]));
				productBean.setRetailPrice(Integer.parseInt(retailPrice[i]));
				productBean.setProductRemarks(productRemarks[i]);
				productBean.setCreUser(creUser[i]);
				list.add(productBean);
			}
		}
		
		try {
			int result = dao.addEstimate(bean); //(見積商品を除く)見積登録
			int result2 = dao.addEstimateProduct(list); //見積商品登録
			
			if(result == 999 || result2 == 999) {
				request.setAttribute("status","err");
			} else {
				request.setAttribute("status","success");
			}
			
		} catch (ClassNotFoundException | MissingResourceException | SQLException e) {
			request.setAttribute("status","err");
			e.printStackTrace();
		}
		
			
		EstimateInputCommonDAO dao2 =  new EstimateInputCommonDAO();
		List<TaxRateBean> taxRateList = dao2.getTaxRate();
		
		//+ 顧客敬称取得
		
		request.setAttribute("taxRateList",taxRateList);
			
		return forwardURL;
		
	}
}
