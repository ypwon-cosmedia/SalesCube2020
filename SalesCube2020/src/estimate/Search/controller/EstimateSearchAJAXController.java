package estimate.Search.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.MissingResourceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.BaseAJAXController;
import estimate.Search.beans.EstimateSearchBean;
import estimate.Search.dao.EstimateSearchDAO;

public class EstimateSearchAJAXController extends BaseAJAXController{
	
	public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("estimateSearch")) estimateSearch(request, response);
			
	}
	
	public void estimateSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, MissingResourceException, SQLException {
		
		EstimateSearchDAO dao = new EstimateSearchDAO();
		EstimateSearchBean bean = new EstimateSearchBean();
		bean.setEstimateSheetId(request.getParameter("estimateSheetId"));
		bean.setEstimateDateStart(request.getParameter("estimateDateStart"));
		bean.setEstimateDateEnd(request.getParameter("estimateDateEnd"));
		bean.setValidDateStart(request.getParameter("validDateStart"));
		bean.setValidDateEnd(request.getParameter("validDateEnd"));
		bean.setUserId(request.getParameter("userId"));
		bean.setUserName(request.getParameter("userName"));
		bean.setTitle(request.getParameter("title"));
		bean.setRemarks(request.getParameter("remarks"));
		bean.setSubmitName(request.getParameter("submitName"));
		bean.setCustomerCode(request.getParameter("customerCode"));
		bean.setCustomerName(request.getParameter("customerName"));
		
	}
}
