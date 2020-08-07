package common.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.SQLException;
import java.lang.*;


abstract public class BaseController {
	
	protected BaseController() {}
	
	abstract public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}