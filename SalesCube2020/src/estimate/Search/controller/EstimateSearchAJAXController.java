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
			
			//ソート条件取得(見積番号順で固定)
			String sort =  "estimateSheetID";
			
			//検索結果をlistに入れる
			try {
				
				list = dao.estimateSearchResult(bean, user, sort);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			// 出力ファイルの作成
	        File file = new File("C:/Users/cosmedia/Desktop/見積検索結果.csv");
	
	        int k = 1;
	        while( file.exists() ){
	        	file = new File("C:/Users/cosmedia/Desktop/見積検索結果("+ k +").csv");
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
		
		String[] tmp;
		int count;
		int totalCount;
		int totalPage;
		int currentPage;
		
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
		if(sort == null)
			sort = "";
			
		//String orderBy = request.getParameter("orderBy");
		
		
		List<String[]> list = new ArrayList<>();
		Gson gson = new Gson();
		
		try {
			list = dao.estimateSearchResult(bean, user, sort);
			String data = gson.toJson(list);
			JsonArray jArray = new JsonParser().parse(data).getAsJsonArray();
						
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(jArray);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*private String estimateChanger1(String[] tmp) {
			for(int i = 0; i<tmp.length;i++) {
				if(tmp[i].equals("estimateSheetId")) tmp[i] = "ESTIMATE_SHEET_ID";
				else if(tmp[i].equals("estimateDate")) tmp[i] = "ESTIMATE_DATE";
				else if(tmp[i].equals("deliveryInfo")) tmp[i] = "DELIVERY_INFO";
				else if(tmp[i].equals("validDate")) tmp[i] = "VALID_DATE";
				else if(tmp[i].equals("userId")) tmp[i] = "USER_ID";
				else if(tmp[i].equals("userName")) tmp[i] = "USER_NAME";
				else if(tmp[i].equals("title")) tmp[i] = "TITLE";
				else if(tmp[i].equals("remarks")) tmp[i] = "REMARKS";
				else if(tmp[i].equals("deliveryName")) tmp[i] = "DELIVERY_NAME";
				else if(tmp[i].equals("estimateCondition")) tmp[i] = "ESTIMATE_CONDITION";
				else if(tmp[i].equals("submitName")) tmp[i] = "SUBMIT_NAME";
				else if(tmp[i].equals("submitPre")) tmp[i] = "(ctx.CATEGORY_CODE_NAME) as SUBMIT_PRE";
				else if(tmp[i].equals("customerCode")) tmp[i] = "CUSTOMER_CODE";
				else if(tmp[i].equals("customerName")) tmp[i] = "CUSTOMER_NAME";
				else if(tmp[i].equals("grossMargin")) tmp[i] = "(RETAIL_PRICE_TOTAL - COST_TOTAL) as GrossProfit";
				else if(tmp[i].equals("grossMarginRate")) tmp[i] = "(ROUND((RETAIL_PRICE_TOTAL - COST_TOTAL)/RETAIL_PRICE_TOTAL*100,2)) as GrossProfitMargin";
				else if(tmp[i].equals("retailPriceTotal")) tmp[i] = "RETAIL_PRICE_TOTAL";
				else if(tmp[i].equals("ctaxPriceTotal")) tmp[i] = "CTAX_PRICE_TOTAL";
				else if(tmp[i].equals("estimateTotal")) tmp[i] = "ESTIMATE_TOTAL";
			}
			return tmp;
		}
		
		private String estimateChanger2(String[] tmp) {
			
			if(tmp.equals("見積番号")) tmp = "ESTIMATE_SHEET_ID";
			else if(tmp.equals("見積日")) tmp = "ESTIMATE_DATE";
			else if(tmp.equals("有効期限")) tmp = "VALID_DATE";
			else if(tmp.equals("提出先名")) tmp = "SUBMIT_NAME";
			else if(tmp.equals("提出先敬称")) tmp = "(ctx.CATEGORY_CODE_NAME) as SUBMIT_PRE";
			else if(tmp.equals("顧客コード")) tmp = "CUSTOMER_CODE";
			else if(tmp.equals("顧客名")) tmp = "CUSTOMER_NAME";
			else if(tmp.equals("粗利益")) tmp = "(RETAIL_PRICE_TOTAL - COST_TOTAL) as GrossProfit";
			else if(tmp.equals("粗利益率")) tmp = "(ROUND((RETAIL_PRICE_TOTAL - COST_TOTAL)/RETAIL_PRICE_TOTAL*100,2)) as GrossProfitMargin,";
			else if(tmp.equals("金額合計")) tmp = "RETAILE_PRICE_TOTAL";
			else if(tmp.equals("消費税")) tmp = "CTAX_PRICE_TOTAL";
			else if(tmp.equals("納期または出荷日")) tmp = "DELIVERY_INFO";
			else if(tmp.equals("入力担当者コード")) tmp = "USER_ID";
			else if(tmp.equals("入力担当者")) tmp = "USER_NAME";
			else if(tmp.equals("摘要")) tmp = "REMARKS";
			else if(tmp.equals("納入先")) tmp = "DELIVERY_NAME";
			else if(tmp.equals("見積条件")) tmp = "ESTIMATE_CONDITION";
			else if(tmp.equals("伝票合計")) tmp = "ESTIMATE_TOTAL";
			else if(tmp.equals("件名")) tmp = "TITLE";
			
			return tmp;
		}*/
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
