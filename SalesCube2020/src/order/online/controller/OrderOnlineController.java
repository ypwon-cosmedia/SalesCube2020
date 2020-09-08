package order.online.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.MissingResourceException;
import java.util.stream.IntStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import common.controller.BaseController;
import order.online.beans.OrderOnlineBillBean;
import order.online.beans.OrderOnlineDetailBean;
import order.online.dao.OrderOnlineDAO;

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
		
		OrderOnlineDAO dao = new OrderOnlineDAO();
		
		if(filePart != null) {
			try {	
				InputStream fileContent = filePart.getInputStream();
				
				int i;
				String inputText = "";
				
				while(( i = fileContent.read())!=-1) {	         
		            char c = (char)i;
		            inputText += c;
		        }
				
				String[] splitText = inputText.split(System.getProperty("line.separator"));

				if(inputText == "") {
					request.setAttribute("checker", "2");
					return "order\\onlineorderdataimport.jsp";
				}
				
				if(!splitText[0].equals("óÔ,óú,o×ú,[úwèú,ótÔ,qæ`[Ô,ñv,ÁïÅ¦,ÚqR[h,[üæR[h,¤iR[h,Ê,ãP¿,¤iõl")) {
					request.setAttribute("checker", "1");
					return "order\\onlineorderdataimport.jsp";
				}
							
				List<String> list = new ArrayList<String>();
				
				for(String s : splitText) {	
					String[] splitText2 = s.split(",");
					if(splitText2.length > 14) {
						throw new IndexOutOfBoundsException();
					}
					for(int j = 0; j < splitText2.length; j++) {
						String tmptext = splitText[j];
						list.add(tmptext);
					}
				}
				
				for(int j = 0; j < 9; j++) {
					list.remove(j);
				}
	
				List<String> infolist = new ArrayList<String>();
				List<String> detaillist = new ArrayList<String>();
				
				for(String s : splitText) {	
					String[] tmpsplit = s.split(",");
					String tmptext ="";
					String detailtemp = "";
					for(int j = 0; j < 10; j++) {
						tmptext += tmpsplit[j] + ",";					
					}
					for(int j = 10; j < 14; j ++) {
						detailtemp += tmpsplit[j] + ",";
					}
					tmptext = tmptext.substring(0, tmptext.length()-1);
					detailtemp = tmpsplit[0] + "," + detailtemp.substring(0, detailtemp.length()-1);
					infolist.add(tmptext);
					detaillist.add(detailtemp);
				}
				
				infolist.remove(0);
				detaillist.remove(0);
				
				HashSet<String> distinctData = new HashSet<String>(infolist);
				infolist = new ArrayList<String>(distinctData);
				
				Collections.sort(infolist);
							
				HashMap<String, String> hs = new HashMap<String, String>();
	            
				for(int j = 0; j < infolist.size(); j ++) {
					String tmp[] = infolist.get(j).split(",");
					OrderOnlineBillBean bean = new OrderOnlineBillBean();
					bean.setRoDate(tmp[1]);
					bean.setShipDate(tmp[2]);
					bean.setDeliveryDate(tmp[3]);
					bean.setReceptNo(tmp[4]);
					bean.setCustomerSilpNo(tmp[5]);
					bean.setRemarks(tmp[6]);
					bean.setCtaxRate(tmp[7]);
					bean.setCustomerCode(tmp[8]);
					bean.setDeliveryCode(tmp[9]);
					
					int res = dao.onlineInputBill(bean);
					hs.put(infolist.get(j).split(",")[0], Integer.toString(res));
	
				}
				
				for(int j = 0; j < detaillist.size(); j ++) {
					if(hs.containsKey(detaillist.get(j).split(",")[0])) {
						String tmp = "";
						tmp += hs.get(detaillist.get(j).split(",")[0]) + "," + detaillist.get(j).substring(detaillist.get(j).indexOf(","));
						String tmpstr[] = tmp.split(",");
						System.out.println(tmp);
						OrderOnlineDetailBean bean = new OrderOnlineDetailBean();
						bean.setRoSlipId(Integer.parseInt(tmpstr[0]));
						bean.setProductCode(tmpstr[2]);
						bean.setQuantity(Integer.parseInt(tmpstr[3]));
						bean.setUnitRetailPrice(Integer.parseInt(tmpstr[4]));
						
						dao.onlineInputDetail(bean);	
					}					
				}
				
				ArrayList<Integer> mapToList = new ArrayList<Integer>();
				
				for(String key : hs.keySet()) {
					String roSlipId = hs.get(key);
					
						dao.onlineInputTotal(roSlipId);
						mapToList.add(Integer.parseInt(roSlipId));
				}
				
				Collections.sort(mapToList);
				
				String start = mapToList.get(0).toString();
				
				
				request.setAttribute("result", dao.onlineInputResult(start));
				request.setAttribute("checker", "0");
			} catch (ClassNotFoundException | MissingResourceException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IndexOutOfBoundsException e) {
				request.setAttribute("checker", "1");
			}
			
		} else {
			
		}
			
		return "order\\onlineorderdataimport.jsp";
	}
	
}
