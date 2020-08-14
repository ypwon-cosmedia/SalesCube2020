/**
 * 
 */
package estimate.Input.API.estimateSheetPDF;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import estimate.Input.beans.InitEstimateBean;
import estimate.Input.beans.InitEstimateProductBean;
import estimate.Input.dao.EstimateModifyDAO;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * @author cosmedia
 *
 */
public class estimateSheetJasper {
	public void outputPdf(String estimateSheetId) {
		try {
	        // テンプレートの読み込み
			File jasperFile = new File("C:\\Users\\cosmedia\\git\\SalesCube2020\\SalesCube2020\\src\\estimate\\Input\\API\\estimateSheetPDF\\jasper\\estimateSheet.jrxml");
	        // 帳票レイアウトのロード
	        JasperReport jasperReport = JasperCompileManager.compileReport(jasperFile.getAbsolutePath());
	        // データ作成（パラメータ）
	        HashMap<String,  Object> params = new HashMap<String,  Object>();
	        
	        //見積情報取得
	        EstimateModifyDAO dao = new EstimateModifyDAO();
	        InitEstimateBean bean = dao.getEstimate(estimateSheetId);

	        //顧客コード
	        if(bean.getCustomerCode() == null) { params.put("customerCode", ""); }
	        else {params.put("customerCode", bean.getCustomerCode()); }
	        //顧客名
	        if(bean.getCustomerName() == null) { params.put("customerName", ""); }
	        else {params.put("customerName", bean.getCustomerName()); }
	        //件名
	        if(bean.getTitle() == null) { params.put("title", ""); }
	        else {params.put("title", bean.getTitle()); }
	        //御見積金額(税込み)
	        if(bean.getEstimateTotal() == null) { params.put("estimateTotal", ""); }
	        else {params.put("estimateTotal", bean.getEstimateTotal()); }
	        //御見積有効期限
	        if(bean.getValidDate() == null) { params.put("validDate", ""); }
	        else {params.put("validDate", bean.getValidDate()); }
	        //納期または出荷日
	        if(bean.getDeliveryInfo() == null) { params.put("deliveryInfo", ""); }
	        else {params.put("deliveryInfo", bean.getDeliveryInfo()); }
	        //お支払い条件
	        if(bean.getEstimateCondition() == null) { params.put("estimateCondition", ""); }
	        else {params.put("estimateCondition", bean.getEstimateCondition()); }
	        //納入先
	        if(bean.getDeliveryName() == null) { params.put("deliveryName", ""); }
	        else {params.put("deliveryName", bean.getDeliveryName()); }
	        //摘要
	        if(bean.getRemarks() == null) { params.put("remarks", ""); }
	        else {params.put("remarks", bean.getRemarks()); }
	        
	        params.put("estimateSheetId", estimateSheetId); //見積番号
	        
	        //日付取得
	        Calendar calendar = Calendar.getInstance();
	        int year = calendar.get(Calendar.YEAR);
	        int month = calendar.get(Calendar.MONTH) + 1;
	        int day = calendar.get(Calendar.DATE);
	        String nowTime = year + "-" + month + "-" + day;
	        params.put("nowTime", nowTime); //発行日(現在時刻)
	       
	        // 見積商品情報作成（繰り返しデータ）
	        List<InitEstimateProductBean> list = dao.getEstimateProduct(estimateSheetId);
	       
	        // データの設定
	        JasperPrint print = JasperFillManager.fillReport(jasperReport,  params,  new JRBeanCollectionDataSource(list));
	       
			// 出力ファイルの作成
            File pdf = new File("C:/Users/cosmedia/Desktop/見積書.pdf");

            int k = 1;
            while( pdf.exists() ){
            	pdf = new File("C:/Users/cosmedia/Desktop/見積書("+ k +").pdf");
            		k++;
            	}
	       
	        // PDF出力
	        JasperExportManager.exportReportToPdfFile(print,  pdf.getAbsolutePath());
	       
	   } catch (Exception e) {
	        System.out.print(e.getMessage());
	   }
		
		 System.out.println("終了しました");
	}
}
