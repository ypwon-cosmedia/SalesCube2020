package order.online.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import common.controller.BaseAJAXController;

@MultipartConfig
public class OrderOnlineAJAXController extends BaseAJAXController{
	
	public void execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String action = request.getParameter("action");
		
		if(action.equals("uploadcsv")) uploadcsv(request, response);
	}
	
	public void uploadcsv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Part filePart = request.getPart("uploadcsv");

		if(filePart != null) {
			InputStream fileContent = filePart.getInputStream();
			
			int i;
			String inputText = "";
			while(( i = fileContent.read())!=-1) {	         
	            char c = (char)i;
	            inputText += c;
	         }
			
			String[] splitText = inputText.split(", |\n");
						
			for(String s : splitText) {
				System.out.print(s);
			}
			
		} else
			System.out.println("filePart is null");

			
	}
}
