package master.product.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;
import master.product.DAO.ProductDAO;
import master.product.DAO.ProductSearchDAO;
import master.product.beans.ProductModifyBean;
import master.product.beans.ProductSearchBean;

import java.util.*;
import java.sql.SQLException;
import java.lang.*;

import user.DAO.*;
import user.beans.*;

public class ProductExcelController extends BaseController{
	
	public ProductExcelController() {
		
	}
	
	public String execService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardURL = "/menu.jsp";
		String action = request.getParameter("action");

		try {
			
		if(action.equals("productExcelInput")) 			forwardURL = productExcelInput(request, response);
		else if(action.equals("productExcelOutput")) 	forwardURL = productExcelOutput(request, response);
		else if(action.equals("productHistoryOutput"))  forwardURL = productHistoryOutput(request, response);
		
		}catch (ServletException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
  		return forwardURL;
	}	
	
	private String productExcelOutput(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<ProductModifyBean> list = new ArrayList<>();
		
		
		//DAOを呼び出す
		ProductSearchDAO psd = new ProductSearchDAO();
		//検索条件の取得
		ProductSearchBean bean = new ProductSearchBean();
		request.setCharacterEncoding(utf-8);
		bean.setProductCode( request.getParameter() );
		
		list = searchAllProduct( bean );
		
		
		try {
			
			//CSVファイルの指定
			PrintWriter p = new PrintWriter( new BufferedWriter( new OutputStreamWriter( new FileOutputStream("//Excelファイルの場所//", false),"utf-8")));
			
			//ヘッダ部
			p.print("商品コード");
			p.print(",");
			p.print("商品名");
			p.print(",");
			p.print("商品フリガナ");
			p.print(",");
			p.print("オンライン品番");
			p.print(",");
			p.print("仕入れ先品番");
			p.print(",");
			p.print("仕入れ先コード");
			p.print(",");
			p.print("標準棚番コード");
			p.print(",");
			p.print("仕入れ単価（￥）");
			p.print(",");
			p.print("仕入れ単価（＄）");
			p.print(",");
			p.print("売単価");
			p.print(",");
			p.print("特注品掛率");
			p.print(",");
			p.print("単位コード");
			p.print(",");
			p.print("入数");
			p.print(",");
			p.print("JANコード");
			p.print(",");
			p.print("幅");
			p.print(",");
			p.print("幅単位");
			p.print(",");
			p.print("奥行");
			p.print(",");
			p.print("奥行単位");
			p.print(",");
			p.print("高さ");
			p.print(",");
			p.print("高さ単位");
			p.print(",");
			p.print("重量");
			p.print(",");
			p.print("重量単位");
			p.print(",");
			p.print("長さ");
			p.print(",");
			p.print("長さ単位");
			p.print(",");
			p.print("発注ロット");
			p.print(",");
			p.print("発注ロット自動更新");
			p.print(",");
			p.print("リードタイム");
			p.print(",");
			p.print("発注点");
			p.print(",");
			p.print("発注点自動更新");
			p.print(",");
			p.print("安全在庫数");
			p.print(",");
			p.print("安全在庫数自動更新");
			p.print(",");
			p.print("委託安全在庫数");
			p.print(",");
			p.print("平均出荷数");
			p.print(",");
			p.print("最大保有数");
			p.print(",");
			p.print("最大保有数自動更新");
			p.print(",");
			p.print("期間出荷数");
			p.print(",");
			p.print("発注限度数");
			p.print(",");
			p.print("発注限度数自動更新");
			p.print(",");
			p.print("商品端数処理");
			p.print(",");
			p.print("課税区分");
			p.print(",");
			p.print("在庫管理区分");
			p.print(",");
			p.print("在庫評価方法");
			p.print(",");
			p.print("製品区分");
			p.print(",");
			p.print("商品分類１");
			p.print(",");
			p.print("商品分類2");
			p.print(",");
			p.print("商品分類３");
			p.print(",");
			p.print("受注限度数");
			p.print(",");
			p.print("数量割引コード");
			p.print(",");
			p.print("セット商品フラグ");
			p.print(",");
			p.print("分類状況");
			p.print(",");
			p.print("分類保管");
			p.print(",");
			p.print("分類調達");
			p.print(",");
			p.print("分類標準");
			p.print(",");
			p.print("芯数");
			p.print(",");
			p.print("整数１");
			p.print(",");
			p.print("整数2");
			p.print(",");
			p.print("整数3");
			p.print(",");
			p.print("整数４");
			p.print(",");
			p.print("整数５");
			p.print(",");
			p.print("小数１");
			p.print(",");
			p.print("小数2");
			p.print(",");
			p.print("小数3");
			p.print(",");
			p.print("小数４");
			p.print(",");
			p.print("小数５");
			p.print(",");
			p.print("廃棄日");
			p.print(",");
			p.print("備考");
			p.print(",");
			p.print("ピッキング備考");
			p.print(",");
			p.print("コメント");
			p.print(",");
			p.print("最終受注日");
			p.print(",");
			p.print("標準偏差");
			
			//改行
			p.println();

			///ボディ部

			for(int i = 0; i < list.size(); i++) {
				
				p.print( list.get(i).getProductCode() );
				p.print(",");
				p.print();
				p.print(",");
				p.print();
	            p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				p.print();
				p.print(",");
				
				//改行
				p.println();
				
			}
			//フッター部
			p.close();
			System.out.println("Excel出力が完了しました");
			
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ServletException e) {
			e.printStackTrace();
		}
		
		return "/productsearch.jsp";
	}

/**	
	private String productExcelInput(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<ProductCategoryBean> list = new ArrayList<>();
		
		ProductDAO dao = new ProductDAO();
		
		//list = dao.getCategory();
		
		request.setAttribute("category", list);
		
		return "/productsearch.jsp";
	}
	
	private String productHistoryOutput(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		return "/productaddmodify.jsp";
	}
**/

}
