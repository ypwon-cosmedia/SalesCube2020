package order.online.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
		
		
		int maxNum = 0;
		int minNum = 100;
		Part filePart = request.getPart("uploadcsv");

		if(filePart != null) {
			InputStream fileContent = filePart.getInputStream();
			
			int i;
			String inputText = "";
			while(( i = fileContent.read())!=-1) {	         
	            char c = (char)i;
	            inputText += c;
	         }
			
			String[] splitText = inputText.split("\n");
			List<String[]> list = new ArrayList<String[]>();			
			for(String s : splitText) {
				String[] splitText2 = s.split(",");
				list.add(splitText2);
			}
			
			for(i = 0; i<list.size(); i++) {
				if(Integer.parseInt(list.get(i)[0]) > maxNum) {
					maxNum = Integer.parseInt(list.get(i)[0]);
				}
				
				if(Integer.parseInt(list.get(i)[0]) < minNum) {
					minNum = Integer.parseInt(list.get(i)[0]);
				}				
			}
			
			System.out.println("minNum is " + minNum);
			System.out.println("maxNum is " + maxNum);
			
			/* DB入力ループ */
			//for(i = minNum; i <= maxNum; i++) {
				//
				//int roNum = dao.inputInfo(bean);
				//dao.inputdetail(i, list);
				//
			//}
			
			/* テーブル表示*/
			//List<bean> output = new ArrayList<bean>();
			//request.setAttribute("tableOutput", output);
			//
			//return "onlineorder.jsp";
			
		} else
			System.out.println("filePart is null");

			//return "onlineorder.jsp";
	}
}
