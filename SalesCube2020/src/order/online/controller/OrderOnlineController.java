package order.online.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import common.controller.BaseController;
import order.online.beans.OrderOnlineBean;

@MultipartConfig
public class OrderOnlineController extends BaseController{

	public String execService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");
		
		if(action.equals("uploadcsv")) forwardURL = uploadcsv(request, response);
		
		return forwardURL;
	}

	public String uploadcsv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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

			String[] splitText = inputText.split(System.getProperty("line.separator"));

			List<String[]> list = new ArrayList<String[]>();			
			for(String s : splitText) {	
				String[] splitText2 = s.split(",");
				list.add(splitText2);
			}
			
			
			/* 最大値、最小値計算*/
			for(i = 0; i<list.size(); i++) {
				if(Integer.parseInt(list.get(i)[0]) > maxNum) {
					maxNum = Integer.parseInt(list.get(i)[0]);
				}
				
				if(Integer.parseInt(list.get(i)[0]) < minNum) {
					minNum = Integer.parseInt(list.get(i)[0]);
				}				
			}
			
			Collections.sort(list,new Comparator <String[]>() {
	            public int compare(String[] strings, String[] otherStrings) {
	                return strings[0].compareTo(otherStrings[0]);
	            }
	        });
			
			for (String[] sa : list) {
	            System.out.println(Arrays.toString(sa));
	        }
						
			int tmpNo = Integer.parseInt(list.get(0)[0]);
			for(int j = 0; i<list.size(); i++) {
				//orderInputInfo bean
				//orderInputDetail bean
				if(j != 0) {
					if(tmpNo == Integer.parseInt(list.get(i)[0])) {
						//orderInputDetail(bean)
						tmpNo = Integer.parseInt(list.get(i)[0]);
					} else {
						//orderInputInfo(bean);
						//orderInputDetail(bean)
					}
				} else {
					//orderInputInfo(bean);
					//orderInputDetail(bean)
				}
			}
			
			/* テーブル表示*/
			//List<bean> output = new ArrayList<bean>();
			//request.setAttribute("tableOutput", output);
			//
			//return "onlineorder.jsp";
			
		} else
			System.out.println("filePart is null");

		return "order\\onlineorderdataimport.jsp";
	}
	
}
