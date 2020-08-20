package estimate.Search.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import common.controller.BaseAJAXController;
import estimate.Search.beans.EstimateSearchBean;
import estimate.Search.beans.EstimateSearchResultBean;
import estimate.Search.dao.EstimateSearchDAO;
import estimate.common.beans.EstimateConfigurationBean;
import user.beans.UserInfoBean;



public class EstimateSearchAJAXController extends BaseAJAXController{
	
	public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		try {
			if(action.equals("estimateSearch")) estimateSearch(request,response);
			else if(action.equals("estimateCreateTable")) estimateCreateTable(request,response);
		} catch (MissingResourceException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	
	public void estimateSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EstimateSearchDAO dao = new EstimateSearchDAO();
		EstimateSearchBean bean = new EstimateSearchBean();
		UserInfoBean user = new UserInfoBean();
		
		 HttpSession session = request.getSession();
		 user =(UserInfoBean)session.getAttribute("userInfo");	
		
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
			list = dao.estimateSearchResult(bean, user);
			String data = gson.toJson(list);
			JsonArray jArray = new JsonParser().parse(data).getAsJsonArray();
						
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(jArray);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void estimateCreateTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EstimateSearchDAO dao = new EstimateSearchDAO();
		UserInfoBean user = new UserInfoBean();
		EstimateConfigurationBean cfg = new EstimateConfigurationBean();
		
		
		 HttpSession session = request.getSession();
		 user =(UserInfoBean)session.getAttribute("userInfo");	
		 
		 cfg.setItemId(request.getParameter("itemId"));
		 cfg.setItemName(request.getParameter("itemName"));
		 cfg.setSortFlag(request.getParameter("sortFlag"));
		 
		 List<EstimateConfigurationBean> list1 = new ArrayList<>();
			Gson gson = new Gson();
			
			try {
				list1 = dao.estimateConfiguration(user);
				String data = gson.toJson(list1);
				JsonArray jArray = new JsonParser().parse(data).getAsJsonArray();
							
				response.setContentType("application/x-json; charset=UTF-8");
				response.getWriter().print(jArray);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}
