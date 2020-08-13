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
import estimate.Input.API.estimateSheetPDF.estimateSheetJasper;
import estimate.Input.beans.EstimateAddBean;
import estimate.Input.beans.EstimateModifyBean;
import estimate.Input.beans.EstimateProductAddBean;
import estimate.Input.beans.InitEstimateBean;
import estimate.Input.beans.InitEstimateProductBean;
import estimate.Input.beans.TaxRateBean;
import estimate.Input.dao.EstimateAddDAO;
import estimate.Input.dao.EstimateInputCommonDAO;
import estimate.Input.dao.EstimateModifyDAO;
import estimate.common.beans.CategoryBean;
import estimate.common.dao.CategoryDAO;

/**
 * @author cosmedia
 *
 */
public class EstimateModifyController extends BaseController {

	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");

		try {
			if(action.equals("moveEstimateModify")) forwardURL = moveEstimateModify(request, response);
			else if(action.equals("estimateModify")) forwardURL = estimateModify(request, response);
			else if(action.equals("estimateDelete")) forwardURL = estimateDelete(request, response);
			else if(action.equals("estimatePdfOutput")) forwardURL = estimatePdfOutput(request, response);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

  		return forwardURL;

	}
	
	/* 見積編集画面に遷移 */
	public String moveEstimateModify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL     = "estimate/estimatemodify.jsp";

		String estimateSheetId = request.getParameter("estimateSheetId");
		
		EstimateModifyDAO dao = new EstimateModifyDAO();
		
		InitEstimateBean bean = dao.getEstimate(estimateSheetId); //見積情報取得
		List<InitEstimateProductBean> list = dao.getEstimateProduct(estimateSheetId); //見積商品情報取得
		
		
		estimateInputAPI api = new estimateInputAPI(); //コンボボックスの初期値の取得に使用する
		
		//リクエストスコープに登録
		request.setAttribute("estimate",bean); //見積情報登録
		request.setAttribute("estimateProductList",list); //見積商品情報登録
		request.setAttribute("taxRateList",api.getTaxRateList()); //消費税率コンボボックス登録
		request.setAttribute("submitPreList",api.getCategoryList(10)); //提出先敬称コンボボックス登録
			
		return forwardURL;
		
	}
	
	/* 見積編集 */
	private String estimateModify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		EstimateModifyDAO mdao = new EstimateModifyDAO();
		EstimateAddDAO adao = new EstimateAddDAO();
		EstimateModifyBean bean = new EstimateModifyBean(); //(見積商品を除く)見積更新用のbean
		List<EstimateProductAddBean> list = new ArrayList<EstimateProductAddBean>(); //見積商品更新のリスト
		
		//(見積商品を除く)見積更新用のbeanに値をセット
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
		bean.setUpdUser(request.getParameter("userName"));
		
		//見積商品更新用の値の配列を取得
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
		
		//見積商品更新用のbeanに値をセット
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
			int result = mdao.modifyEstimate(bean); //(見積商品を除く)見積更新
			int result2 = mdao.deleteEstimateProduct(estimateSheetId); //見積商品削除
			int result3 = adao.addEstimateProduct(list); //見積商品登録
			
			if(result == 999 || result2 ==999 || result3 == 0) {
				request.setAttribute("status","modifyErr");
			} else {
				request.setAttribute("status","modifySuccess");
			}
			
		} catch (ClassNotFoundException | MissingResourceException | SQLException e) {
			request.setAttribute("status","modifyErr");
			e.printStackTrace();
		}	
			
		return moveEstimateModify(request, response);
		
	}
	
	/* PDF出力 */
	private String estimatePdfOutput(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		estimateSheetJasper jasper = new estimateSheetJasper();
		String estimateSheetId = request.getParameter("estimateSheetId");
		jasper.outputPdf(estimateSheetId);
			
		return moveEstimateModify(request, response);
		
	}
	
	/* 見積削除 */
	private String estimateDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		EstimateModifyDAO mdao = new EstimateModifyDAO();
		String estimateSheetId = request.getParameter("estimateSheetId");
		int result = mdao.deleteEstimate(estimateSheetId);
		int result2 = mdao.deleteEstimateProduct(estimateSheetId);
		
		if(result == 999 || result2 == 999) {
			request.setAttribute("status","deleteErr");
			return  moveEstimateModify(request, response);
		} else {
			request.setAttribute("status","deleteSuccess");
		}
		
		EstimateAddController controller = new EstimateAddController();
		
		return controller.moveEstimateAdd(request, response); //登録画面に遷移
		
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

