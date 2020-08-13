package common.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
abstract public class BaseAJAXController {

	protected BaseAJAXController() {}
	
	abstract public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
