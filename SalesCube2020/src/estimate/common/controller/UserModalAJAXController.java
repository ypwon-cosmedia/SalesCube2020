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
import estimate.common.beans.UserModalResultBean;
import estimate.common.beans.UserModalSearchBean;
import estimate.common.dao.UserModalDAO;

public class UserModalAJAXController extends BaseAJAXController {

	@Override
	public void execService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("userSearch")) userSearch(request,response);
		
	}
	
	private void userSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserModalDAO dao = new UserModalDAO();
		UserModalSearchBean bean = new UserModalSearchBean();
		bean.setUserId(request.getParameter("userId"));
		bean.setNameKnj(request.getParameter("nameKnj"));
		bean.setNameKana(request.getParameter("nameKana"));
		bean.setDeptId(request.getParameter("deptId"));
		bean.setRoleId(request.getParameter("roleId"));
		
		System.out.println(request.getParameter("userId"));
		System.out.println(request.getParameter("deptId"));
		System.out.println(request.getParameter("roleId"));
		
		List<UserModalResultBean> list = new ArrayList<>();
		Gson gson = new Gson();
		try {
			list = dao.userModalResult(bean);
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
