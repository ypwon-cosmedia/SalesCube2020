package common.modal.supplier.controller;

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
import common.modal.supplier.beans.SupplierSearchBean;
import common.modal.supplier.beans.SupplierSearchResultBean;
import common.modal.supplier.dao.SupplierDAO;

public class SupplierModalAJAXController extends BaseAJAXController{

	public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("searchModalSupplier")) searchModalSupplier(request, response); 
			
	}
	
	
	private void searchModalSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SupplierDAO dao = new SupplierDAO();
		SupplierSearchBean search = new SupplierSearchBean();
		
		search.setSupplierCode( request.getParameter("inputSupplierCode") );	//仕入れ先コードを受け取る
		search.setSupplierName( request.getParameter("inputSupplierName") );	//仕入れ先名を受け取る
		search.setSupplierKana( request.getParameter("inputSupplierKana") );	//仕入れ先カナを受け取る
		
		List<SupplierSearchResultBean> list = new ArrayList<>();
		Gson gson = new Gson();
		
		try {
			list = dao.SearchSupplier( search );	//検索を行う
			
			String data = gson.toJson(list);
			JsonArray jArray = new JsonParser().parse(data).getAsJsonArray();
						
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(jArray);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
