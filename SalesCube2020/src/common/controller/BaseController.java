package common.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.util.*;
import java.sql.SQLException;
import java.lang.*;

@MultipartConfig
abstract public class BaseController {
	
	protected BaseController() {}
	
	abstract public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}