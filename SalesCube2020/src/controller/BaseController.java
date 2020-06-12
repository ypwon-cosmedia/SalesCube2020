package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.SQLException;

abstract public class BaseController {
	
	protected BaseController() {}
	
	abstract public String execService(HttpServletRequest request, HttpServletResponse response);
	
}
