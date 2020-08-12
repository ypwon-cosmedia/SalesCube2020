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
import estimate.common.beans.GetDeptBean;
import estimate.common.beans.GetRoleBean;
import estimate.common.beans.UserModalResultBean;
import estimate.common.beans.UserModalSearchBean;
import estimate.common.dao.DeptGetDAO;
import estimate.common.dao.RoleGetDAO;
import estimate.common.dao.UserModalDAO;

public class UserModalAJAXController extends BaseAJAXController {

	@Override
	public void execService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		try {
			if(action.equals("userSearch")) userSearch(request,response);
			else if(action.equals("deptSearch")) deptSearch(request,response);
			else if(action.equals("roleSearch")) roleSearch(request,response);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void userSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserModalDAO dao = new UserModalDAO();
		UserModalSearchBean bean = new UserModalSearchBean();
		bean.setUserId(request.getParameter("userId"));
		bean.setNameKnj(request.getParameter("nameKnj"));
		bean.setNameKana(request.getParameter("nameKana"));
		bean.setDeptId(request.getParameter("deptId"));
		bean.setRoleId(request.getParameter("roleId"));
		
		System.out.print("UserId:");System.out.println(bean.getUserId());
		System.out.print("UserId:");System.out.println(request.getParameter("userId"));
		System.out.print("deptId:");System.out.println(request.getParameter("deptId"));
		System.out.print("roleId:");System.out.println(request.getParameter("roleId"));
		
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
	
	private void deptSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		DeptGetDAO dao = new DeptGetDAO();
		GetDeptBean bean = new GetDeptBean();
		bean.setDeptId(request.getParameter("deptId"));
		bean.setDeptName(request.getParameter("deptName"));
		
		System.out.println(request.getParameter("deptId"));
		System.out.println(request.getParameter("deptName"));
		
		List<GetDeptBean> list = dao.DeptGet();
		Gson gson = new Gson();
		try {
			list = dao.DeptGet();
			String data = gson.toJson(list);
			JsonArray jArray = new JsonParser().parse(data).getAsJsonArray();
						
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(jArray);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void roleSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		RoleGetDAO dao = new RoleGetDAO();
		GetRoleBean bean = new GetRoleBean();
		bean.setRoleId(request.getParameter("roleId"));
		bean.setRoleName(request.getParameter("roleName"));
		
		System.out.println(request.getParameter("roleId"));
		System.out.println(request.getParameter("roleName"));
		
		List<GetRoleBean> list = dao.RoleGet();
		Gson gson = new Gson();
		try {
			list = dao.RoleGet();
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
