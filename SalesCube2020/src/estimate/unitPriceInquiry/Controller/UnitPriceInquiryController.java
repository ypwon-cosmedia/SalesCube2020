/**
 * 
 */
package estimate.unitPriceInquiry.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.BaseController;
import estimate.unitPriceInquiry.beans.OrderStatementBean;
import estimate.unitPriceInquiry.beans.QuantitySlideSettingBean;
import estimate.unitPriceInquiry.beans.UnitPriceInquirySearchResultBean;
import estimate.unitPriceInquiry.dao.UnitPriceInquiryDAO;


public class UnitPriceInquiryController extends BaseController {

	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");
		
		try {
			if(action.equals("moveUnitPriceInquiry")) forwardURL = moveUnitPriceInquiry(request, response);
			else if(action.equals("unitPriceInquirySearch")) forwardURL = unitPriceInquirySearch(request, response);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

  		return forwardURL;
	}
	
	private String moveUnitPriceInquiry(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL     = "estimate/unitpriceinquiry.jsp";
			
		return forwardURL;
		
	}
	
	private String unitPriceInquirySearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String forwardURL     = "estimate/unitpriceinquiry.jsp";
		
		//単価照会画面で入力した商品コード取得
		String productCode   = request.getParameter("productCode");
		
		//単価照会DAOをインスタンス化
		UnitPriceInquiryDAO dao = new UnitPriceInquiryDAO();
		//単価照会情報(数量スライド設定および受注残明細情報を除く)を取得
		UnitPriceInquirySearchResultBean searchResultBean = dao.unitPriceInquirySearch(productCode);
		//数量スライド設定を取得
		List<QuantitySlideSettingBean> quantitySlideSettingList = dao.getQuantitySetting(productCode);
		//受注残明細を取得
		List<OrderStatementBean> orderStatementList = dao.getOrderStatement(productCode);
		
		request.setAttribute("searchResult",searchResultBean);
		request.setAttribute("quantitySlideSettingList",quantitySlideSettingList);
		request.setAttribute("orderStatementList",orderStatementList);
		
		String productName = searchResultBean.getProductName();
		
		if(productName == null ) {
			request.setAttribute("status","err");
		} else {
			request.setAttribute("status","result");
		}	
		return forwardURL;
	}
}
