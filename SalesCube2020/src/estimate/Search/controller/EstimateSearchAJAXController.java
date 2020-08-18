package estimate.Search.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import common.controller.BaseAJAXController;
import estimate.Search.beans.EstimateSearchBean;
import estimate.Search.beans.EstimateSearchResultBean;
import estimate.Search.dao.EstimateSearchDAO;



public class EstimateSearchAJAXController extends BaseAJAXController{
	
	public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
			if(action.equals("estimateSearch")) estimateSearch(request,response);
	}

	
	public void estimateSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		List<EstimateSearchResultBean> list = new ArrayList<>();
		Gson gson = new Gson();
		
		try {
			list = dao.estimateSearchResult(bean);
			String data = gson.toJson(list);
			JsonArray jArray = new JsonParser().parse(data).getAsJsonArray();
						
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(jArray);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
}
