package common.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

public class SalesCubeAJAXServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action").equals("productSearch")) {
			JsonObject obj = new JsonObject();
			obj.addProperty("test", "success");
			
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(obj);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action").equals("productSearch")) {
			JsonObject obj = new JsonObject();
			obj.addProperty("test", "success");
			
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(obj);
		}
	}
	
	public void init() throws ServletException {
		
	}
}
