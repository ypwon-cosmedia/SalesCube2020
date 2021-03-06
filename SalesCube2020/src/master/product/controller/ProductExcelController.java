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

		if(action.equals("productExcelOutput")) 	forwardURL = productExcelOutput(request, response);
		
		/**SalesCubeの全機能
			if(action.equals("productExcelInput")) 			forwardURL = productExcelInput(request, response);
			else if(action.equals("productExcelOutput")) 	forwardURL = productExcelOutput(request, response);
			else if(action.equals("productHistoryOutput"))  forwardURL = productHistoryOutput(request, response);
		 **/
  		return forwardURL;
	}	
	
	private String productExcelOutput(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<ProductModifyBean> list = new ArrayList<>();
		
		try {
			
		//DAOを呼び出す
		ProductSearchDAO psd = new ProductSearchDAO();
		//検索条件の取得

		request.setCharacterEncoding("UTF-8");
		
		String productCode = null;
		String productName = null;
		String productKana = null;
		String supplierCode = null;
		String supplierName = null;
		String productStandardCategory = null;
		String productStatusCategory = null;
		String productStockCategory = null;
		String setTypeCategory = null;
		String remarks = null;
		String product1 = null;
		String product2 = null;
		String product3 = null;
		
		productCode = (String)request.getParameter("productCode");
		productName = (String)request.getParameter("productName");
		productKana = (String)request.getParameter("productKana");
		supplierCode = (String)request.getParameter("supplierCode");
		supplierName = (String)request.getParameter("supplierName");
		productStandardCategory = (String)request.getParameter("productStandardCategory");
		productStatusCategory = (String)request.getParameter("productStatusCategory");
		productStockCategory = (String)request.getParameter("productStockCategory");
		setTypeCategory = (String)request.getParameter("setTypeCategory");
		remarks = (String)request.getParameter("remarks");
		product1 = (String)request.getParameter("product1");
		product2 = (String)request.getParameter("product2");
		product3 = (String)request.getParameter("product3");
		

			ProductSearchBean bean = new ProductSearchBean();
			bean.setProductCode(productCode);
			bean.setProductName(productName);
			bean.setProductKana(productKana);
			bean.setSupplierCode(supplierCode);
			bean.setSupplierName(supplierName);
			bean.setProductStandardCategory(productStandardCategory);
			bean.setProductStatusCategory(productStatusCategory);
			bean.setProductStockCategory(productStockCategory);
			bean.setSetTypeCategory(setTypeCategory);
			bean.setRemarks(remarks);
			bean.setProduct1(product1);
			bean.setProduct2(product2);
			bean.setProduct3(product3);
		
		//検索結果をlistに入れる
			try {
				
				list = psd.searchAllProduct( bean );
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

			/**CSVファイルの指定
			PrintWriter p = new PrintWriter( new BufferedWriter( new OutputStreamWriter( new FileOutputStream("C:\\Users\\cosmedia\\Desktop\\SalesCubeテスト用", false),"utf-8")));
			**/
			// 出力ファイルの作成
            File file = new File("C:/Users/cosmedia/Desktop/商品マスタ.csv");

            int k = 1;
            while( file.exists() ){
            	file = new File("C:/Users/cosmedia/Desktop/商品マスタ("+ k +").csv");
            		k++;
            	}

            PrintWriter p = new PrintWriter( new BufferedWriter( new OutputStreamWriter( new FileOutputStream(file, false),"SJIS")));
            
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
			p.print("上代");
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
			p.print("平均出荷数");
			p.print(",");
			p.print("在庫限度数");
			p.print(",");
			p.print("在庫限度数自動更新");
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
			p.print("商品ランク");
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
			p.print("出荷数偏差");
			p.print(",");
			p.print("自社安全在庫数");
			p.print(",");
			p.print("自社安全在庫数自動更新");
			p.print(",");
			p.print("委託在庫安全在庫数");
			p.print(",");
			p.print("作成機能");
			p.print(",");
			p.print("作成日時");
			p.print(",");
			p.print("作成者");
			p.print(",");
			p.print("更新機能");
			p.print(",");
			p.print("更新日時");
			p.print(",");
			p.print("更新者");
			p.print(",");
			p.print("削除機能");
			p.print(",");
			p.print("削除日時");
			p.print(",");
			p.print("削除者");
			p.print(",");
			
			//改行
			p.println();

			///ボディ部

			for(int i = 0; i < list.size(); i++) {
				
				p.print( list.get(i).getProductCode() );
				p.print(",");
				p.print( list.get(i).getProductName() );
				p.print(",");
				p.print( list.get(i).getProductKana() );
	            p.print(",");
				p.print( list.get(i).getOnlinePcode() );
				p.print(",");
				p.print( list.get(i).getSupplierPcode() );
				p.print(",");
				p.print( list.get(i).getSupplierCode());
				p.print(",");
				p.print( list.get(i).getRackCode() );
	            p.print(",");
				p.print( list.get(i).getSupplierPriceYen() );
				p.print(",");
				p.print( list.get(i).getSupplierPriceDol() );
				p.print(",");
				p.print( list.get(i).getRetailPrice() );
				p.print(",");
				p.print( list.get(i).getSoRate() );
	            p.print(",");
				p.print( list.get(i).getUnitCategory() );
				p.print(",");
				p.print( list.get(i).getPackQuantity() );
				p.print(",");
				p.print( list.get(i).getJanPcode() );
				p.print(",");
				p.print( list.get(i).getWidth() );
	            p.print(",");
	            p.print( list.get(i).getWidthUnitSizeCategory() );
				p.print(",");
				p.print( list.get(i).getDepth() );
				p.print(",");
				p.print( list.get(i).getDepthUnitSizeCategory() );
				p.print(",");
				p.print( list.get(i).getHeight() );
	            p.print(",");
	            p.print( list.get(i).getHeightUnitSizeCategory() );
				p.print(",");
				p.print( list.get(i).getWeight() );
				p.print(",");
				p.print( list.get(i).getWeightUnitSizeCategory() );
				p.print(",");
				p.print( list.get(i).getLength() );
	            p.print(",");
	            p.print( list.get(i).getLengthUnitSizeCategory() );
				p.print(",");
				p.print( list.get(i).getPoLot() );
				p.print(",");
				p.print( list.get(i).getLotUpdFlag() );
				p.print(",");
				p.print( list.get(i).getLeadTime() );
	            p.print(",");
	            p.print( list.get(i).getPoNum() );
				p.print(",");
				p.print( list.get(i).getPoUpdFlag() );
				p.print(",");
				p.print( list.get(i).getAvgShipCount() );
				p.print(",");
				p.print( list.get(i).getMaxStockNum() );
	            p.print(",");
	            p.print( list.get(i).getStockUpdFlag() );
				p.print(",");
				p.print( list.get(i).getTermShipNum() );
				p.print(",");
				p.print( list.get(i).getMaxPoNum() );
				p.print(",");
				p.print( list.get(i).getMaxPoUpdFlag() );
	            p.print(",");
	            p.print( list.get(i).getFractCategory() );
				p.print(",");
				p.print( list.get(i).getTaxCategory() );
				p.print(",");
				p.print( list.get(i).getStockCtlCategory() );
				p.print(",");
				p.print( list.get(i).getStockAssesCategory() );
	            p.print(",");
	            p.print( list.get(i).getProductCategory() );
				p.print(",");
				p.print( list.get(i).getProduct1() );
				p.print(",");
				p.print( list.get(i).getProduct2() );
				p.print(",");
				p.print( list.get(i).getProduct3() );
	            p.print(",");
	            p.print( list.get(i).getRoMaxNum() );
				p.print(",");
				p.print( list.get(i).getProductRank() );
				p.print(",");
				p.print( list.get(i).getSetTypeCategory() );
				p.print(",");
				p.print( list.get(i).getProductStatusCategory() );
	            p.print(",");
	            p.print( list.get(i).getProductStockCategory() );
				p.print(",");
				p.print( list.get(i).getProductPurvayCategory() );
				p.print(",");
				p.print( list.get(i).getProductStandardCategory() );
				p.print(",");
				p.print( list.get(i).getCoreNum() );
	            p.print(",");
	            p.print( list.get(i).getNum1() );
				p.print(",");
				p.print( list.get(i).getNum2() );
				p.print(",");
				p.print( list.get(i).getNum3() );
				p.print(",");
				p.print( list.get(i).getNum4() );
	            p.print(",");
	            p.print( list.get(i).getNum5() );
				p.print(",");
				p.print( list.get(i).getDec1() );
				p.print(",");
				p.print( list.get(i).getDec2() );
				p.print(",");
				p.print( list.get(i).getDec3() );
	            p.print(",");
	            p.print( list.get(i).getDec4() );
				p.print(",");
				p.print( list.get(i).getDec5() );
				p.print(",");
				p.print( list.get(i).getDiscardDate() );
				p.print(",");
				p.print( list.get(i).getRemarks() );
	            p.print(",");
	            p.print( list.get(i).getEadRemarks() );
				p.print(",");
				p.print( list.get(i).getCommentData() );
				p.print(",");
				p.print( list.get(i).getLastRoDate() );
				p.print(",");
				p.print( list.get(i).getSalesStandardDeviation() );
	            p.print(",");
	            p.print( list.get(i).getMineSafetyStock() );
				p.print(",");
				p.print( list.get(i).getMineSafetyStockUpdFlag() );
				p.print(",");
				p.print( list.get(i).getEntrustSafetyStock() );
				p.print(",");
				p.print( list.get(i).getCreFunc() );
	            p.print(",");
	            p.print( list.get(i).getCreDatetm() );
				p.print(",");
				p.print( list.get(i).getCreUser() );
				p.print(",");
				p.print( list.get(i).getUpdFunc() );
				p.print(",");
				p.print( list.get(i).getUpdDatetm() );
	            p.print(",");
	            p.print( list.get(i).getUpdUser() );
				p.print(",");
				p.print( list.get(i).getDelFunc() );
				p.print(",");
				p.print( list.get(i).getDelDatetm() );
				p.print(",");
				p.print( list.get(i).getDelUser() );
	            
				//改行
				p.println();
				
			}
			//フッター部
			p.close();
			System.out.println("Excel出力が完了しましたよ");
			
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("IOException");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ClassNotFoundException");
		}
		System.out.println("終了処理");
		return "/SalesCube?action=searchProduct";
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
