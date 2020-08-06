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
import estimate.Input.API.estimateInputAPI;
import estimate.Input.beans.EstimateAddBean;
import estimate.Input.beans.EstimateProductAddBean;
import estimate.Input.beans.TaxRateBean;
import estimate.Input.dao.EstimateAddDAO;
import estimate.Input.dao.EstimateInputCommonDAO;
import estimate.common.beans.CategoryBean;
import estimate.common.dao.CategoryDAO;
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

		estimateInputAPI api = new estimateInputAPI();

		request.setAttribute("taxRateList",api.getTaxRateList());
		request.setAttribute("submitPreList",api.getCategoryList(10));
			
		return forwardURL;
		
	}
	
	private String estimateAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
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
		bean.setCostTotal(Integer.parseInt(request.getParameter("costTotal")));
		bean.setCreUser(request.getParameter("userName"));
		
		//見積商品登録用の値の配列を取得
		//String[] lineNo = request.getParameterValues("lineNo");
		String   estimateSheetId = request.getParameter("estimateSheetId"); //見積番号(固定)
		String[] productCode = request.getParameterValues("productCode");
		String[] productAbstract = request.getParameterValues("productAbstract");
		String[] quantity = request.getParameterValues("quantity");
		String[] unitCost = request.getParameterValues("unitCost");
		String[] cost = request.getParameterValues("cost");
		String[] unitRetailPrice = request.getParameterValues("unitRetailPrice");
		String[] retailPrice = request.getParameterValues("retailPrice");
		String[] productRemarks = request.getParameterValues("productRemarks");
		String   creUser = request.getParameter("userName"); //作成者(固定)
		
		//見積商品登録用のbeanに値をセット
		if(productCode != null) {
			for(int i = 0; i<productCode.length; i++) {
				EstimateProductAddBean productBean = new EstimateProductAddBean();
				//productBean.setLineNo(Integer.parseInt(lineNo[i]));
				productBean.setLineNo(i + 1);
				productBean.setEstimateSheetId(estimateSheetId); //見積番号(固定)
				productBean.setProductCode(productCode[i]);
				productBean.setProductAbstract(productAbstract[i]);
				productBean.setQuantity(parseInt(quantity[i]));
				productBean.setUnitCost(parseInt(unitCost[i]));
				productBean.setCost(parseInt(cost[i]));
				productBean.setUnitRetailPrice(parseInt(unitRetailPrice[i]));
				productBean.setRetailPrice(parseInt(retailPrice[i]));
				productBean.setProductRemarks(productRemarks[i]);
				productBean.setCreUser(creUser); //作成者(固定)
				list.add(productBean);
			}
		}
		
		try {
			int result = dao.addEstimate(bean); //(見積商品を除く)見積登録
			int result2 = dao.addEstimateProduct(list); //見積商品登録
			
			if(result == 999 || result2 == 0) {
				request.setAttribute("status","err");
			} else {
				request.setAttribute("status","success");
			}
			
		} catch (ClassNotFoundException | MissingResourceException | SQLException e) {
			request.setAttribute("status","err");
			e.printStackTrace();
		}
		
		return moveEstimateAdd(request, response);
		
	}
	
	
	public static int parseInt(String value, int defaultValue) {
		 
	    try {
	        // intに変換して返す
	        return Integer.parseInt(value);
	    } catch ( NumberFormatException e ) {
	        // デフォルト値を返す
	        return defaultValue;
	    }
	}
	
	public static int parseInt(String value) {
		 
	    // int変換して返す
	    return parseInt(value, 0);
	}
}
