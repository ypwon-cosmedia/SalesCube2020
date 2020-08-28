package estimate.Search.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import common.controller.BaseAJAXController;
import estimate.Search.beans.EstimateSearchBean;
import estimate.Search.beans.EstimateSearchResultBean;
import estimate.Search.dao.EstimateSearchDAO;
import estimate.common.beans.EstimateConfigurationBean;
import master.product.beans.ProductModifyBean;
import user.beans.UserInfoBean;



public class EstimateSearchAJAXController extends BaseAJAXController{
	
	public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		try {
			if(action.equals("estimateSearch")) estimateSearch(request,response);
			else if(action.equals("estimateCreateTable")) estimateCreateTable(request,response);
			else if(action.equals("estimateExcelOutput")) estimateExcelOutput(request,response); 
		} catch (MissingResourceException | ServletException | IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void estimateExcelOutput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		EstimateSearchDAO dao = new EstimateSearchDAO();
		EstimateSearchBean bean = new EstimateSearchBean();
		UserInfoBean user = new UserInfoBean();
		
		System.out.println("test0828");
		
		List<String[]> list = new ArrayList<>();
		
		try {
			//ユーザー情報取得
			HttpSession session = request.getSession();
			user =(UserInfoBean)session.getAttribute("userInfo");
			 
			//見積検索条件取得
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
			String sort = request.getParameter("sorting");
			String upDown = request.getParameter("updown");
			
			
			System.out.println(sort);
			if(sort == null)
				sort = "";
			
			String rowcount ="NO";
			String pageNum = null;
			
			try {
				list = dao.estimateSearchResult(bean, user, sort, upDown, rowcount, pageNum);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			// 出力ファイルの作成
	        File file = new File("C:/Users/cosmedia/Desktop/estiamteSearchResult.csv");
	
	        int k = 1;
	        while( file.exists() ){
	        	file = new File("C:/Users/cosmedia/Desktop/estiamteSearchResult("+ k +").csv");
	        		k++;
	        }
	        
	        PrintWriter p = new PrintWriter( new BufferedWriter( new OutputStreamWriter( new FileOutputStream(file, false),"SJIS")));

			
	        List<EstimateConfigurationBean> list2 = dao.estimateConfiguration(user); //ヘッダ部の並びを取得
	        
			//ヘッダ部
	        for(EstimateConfigurationBean config : list2) {
	    		p.print(config.getItemName());
	    		p.print(",");
	        }
	
			p.println();//改行
	
			//ボディ部
			for(int i = 0; i < list.size(); i++) {
				String[] raw = list.get(i);;
				
				for(int j = 0; j < raw.length; j++) {
					p.print(raw[j]);
					p.print(",");
				}
			}
			
			p.close();
			
		
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IOException");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ClassNotFoundException");
		}
		System.out.println("終了処理");
		
		
	}
	


	
	public void estimateSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EstimateSearchDAO dao = new EstimateSearchDAO();
		EstimateSearchBean bean = new EstimateSearchBean();
		UserInfoBean user = new UserInfoBean();
		
		 HttpSession session = request.getSession();
		 user =(UserInfoBean)session.getAttribute("userInfo");	
		 //見積検索条件
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
		String sort = request.getParameter("sorting");
		String upDown = request.getParameter("updown");
		String rowcount = request.getParameter("rowCount");
		String pageNum = request.getParameter("pageNum");
		
		System.out.println(sort);
		if(sort == null)
			sort = "";
		
		String count;
			
		
		
		List<String[]> list = new ArrayList<>();
		Gson gson = new Gson();
		
		try {
			list = dao.estimateSearchResult(bean, user, sort, upDown, rowcount, pageNum);
			String data = gson.toJson(list);
			JsonArray jArray = new JsonParser().parse(data).getAsJsonArray();
			
			count = dao.estimateSearchCount(bean, user, sort, upDown, rowcount, pageNum);
			
			JsonObject tmpObj = new JsonObject();
			tmpObj.addProperty("count", count);
			
			JsonObject jobj = new JsonObject();
			jobj.add("count", tmpObj);
			jobj.add("result", jArray);
						
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(jobj);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//見積検索（見出し部）
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
