package common.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import common.controller.BaseAJAXController;
import common.controller.CreateAJAXControllers;

public class SalesCubeAJAXServlet extends HttpServlet {
	
	private HashMap<String, BaseAJAXController> ajaxControllerList;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(ajaxControllerList.containsKey(action)) {
			BaseAJAXController controller = ajaxControllerList.get(action);
			controller.execService(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(ajaxControllerList.containsKey(action)) {
			BaseAJAXController controller = ajaxControllerList.get(action);
			controller.execService(request, response);
		}
		
	}
	
	public void init() throws ServletException {
		ajaxControllerList = new CreateAJAXControllers().newAJAXController();
	}
}
