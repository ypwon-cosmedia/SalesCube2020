package estimate.common.controller;

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
import estimate.common.beans.CategoryBean;
import estimate.common.dao.CategoryDAO;

public class EstimateCategoryModalAJAXController extends BaseAJAXController{
	
	public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("estimateCategoryGet")) categoryGet(request, response); 
			

	}
	
	public void categoryGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CategoryDAO dao = new CategoryDAO();
		int categoryId = Integer.parseInt( request.getParameter("categoryId"));//区分IDを受け取る
		
		List<CategoryBean> list = new ArrayList<>();
		Gson gson = new Gson();
		try {
			list = dao.CategoryGet(categoryId);//区分IDで検索
			
			String data = gson.toJson(list);
			JsonArray jArray = new JsonParser().parse(data).getAsJsonArray();
						
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(jArray);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
