package common.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract public class BaseAJAXController {

	protected BaseAJAXController() {}
	
	abstract public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
