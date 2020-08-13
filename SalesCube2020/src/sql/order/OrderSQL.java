package sql.order;


import order.search.beans.OrderSearchBean;

import order.common.bill.beans.OrderCommonBillBean;
import sql.common.CommonSQL;


public class OrderSQL {
	
	CommonSQL com = new CommonSQL();
	
	public String initCategory() {
		
		String sql;
		
		sql = "select CLASS_CODE_1, CLASS_CODE_2, CLASS_CODE_3, CLASS_NAME from product_class_mst_xxxxx";
		
		return sql;
		
	}
	
	public String initConfigModalShowList(String detailID, String target, String userID) {
		
		String sql;
		
		sql = "select " + 
				"ITEM_ID, " +
				"ITEM_NAME " + 
				"from " + 
				"detail_disp_item_mst_xxxxx AS a " + 
				"LEFT OUTER JOIN(" + 
				"select " + 
				"* " + 
				"from " + 
				"detail_disp_item_cfg_xxxxx " + 
				"where " + 
				"DETAIL_ID = '"+ detailID + "' " +
				"and " + 
				"TARGET = '"+ target + "' " +
				"and " + 
				"USER_ID = '"+ userID +"') AS b " + 
				"USING(DETAIL_ID, TARGET, ITEM_ID) " + 
				"where " + 
				"a.DETAIL_ID = '"+ detailID + "' " +
				"AND " + 
				"a.TARGET = '"+ target + "' " +
				"AND " + 
				"b.ITEM_ID = a.ITEM_ID " + 
				"ORDER BY b.SEQ";
		
		return sql;
	}
	
	public String initConfigModalNotShowList(String detailID, String target, String userID) {
		
		String sql;
		
		sql = "select " + 
				"ITEM_ID, " +
				"ITEM_NAME " + 
				"from " + 
				"detail_disp_item_mst_xxxxx AS a " + 
				"LEFT OUTER JOIN(" + 
				"select " + 
				"* " + 
				"from " + 
				"detail_disp_item_cfg_xxxxx " + 
				"where " + 
				"DETAIL_ID = '"+ detailID + "' " +
				"and " + 
				"TARGET = '"+ target + "' " +
				"and " + 
				"USER_ID = '"+ userID +"') AS b " + 
				"USING(DETAIL_ID, TARGET, ITEM_ID) " + 
				"where " + 
				"a.DETAIL_ID = '"+ detailID + "' " +
				"AND " + 
				"a.TARGET = '"+ target + "' " +
				"AND " + 
				"b.ITEM_ID IS NULL";
		
		return sql;
	}
	
	public String deleteConfigModal(String detailID, String target, String userID) {
		String sql;
		
		sql = 	"delete from detail_disp_item_cfg_xxxxx " +
				"where USER_ID = '" + userID + "' " +
				"and " +
				"DETAIL_ID = '" + detailID + "' " +
				"and " +
				"TARGET = '" + target + "'";
		
		return sql;
	}
	
	public String insertConfigModal(String detailID, String target, String userID, int seq, String itemID) {
		String sql;
		
		sql = 	"INSERT INTO detail_disp_item_cfg_xxxxx(USER_ID,DETAIL_ID,TARGET,ITEM_ID,SEQ) " +
				"VALUES('" +
				userID + "', '" +
				detailID + "', '" +
				target + "', '" +
				itemID + "', " +
				seq + ")";
		
		return sql;
	}
	
	/* 見積モーダル */
	/* 見積検索 */
	public String billSearch(String estimateSheetId, String estimateDate, String submitName, String title, OrderCommonBillBean bean) {
		
		String sql;
		
		if(bean.getEstimateSheetId() == null || bean.getEstimateSheetId().equals("")) {
			bean.setEstimateSheetId("%' OR ESTIMATE_SHEET_ID IS NULL");
		}else {
			bean.setEstimateSheetId(bean.getEstimateSheetId().concat("%'"));
		}
		if(bean.getEstimateDate() == null || bean.getEstimateDate().equals("")) {
			bean.setEstimateDate("%' OR ESTIMATE_DATE IS NULL");
		}else {
			bean.setEstimateDate(bean.getEstimateDate().concat("%'"));
		}
		if(bean.getSubmitName() == null || bean.getSubmitName().equals("")) {
			bean.setSubmitName("%' OR SUBMIT_NAME IS NULL");
		}else {
			bean.setSubmitName(bean.getSubmitName().concat("%'"));
		}
		if(bean.getTitle() == null || bean.getTitle().equals("")) {
			bean.setTitle("%' OR TITLE IS NULL");
		}else {
			bean.setTitle(bean.getTitle().concat("%'"));
		}
			
		sql = "SELECT " +		
				"ESTIMATE_SHEET_ID, " +
				"ESTIMATE_DATE, " +
				"SUBMIT_NAME, " +
				"TITLE " +
			"FROM "	+
				"estimate_sheet_trn_xxxxx " +
			"WHERE " + 
				"(ESTIMATE_SHEET_ID LIKE '" + bean.getEstimateSheetId() + "'" +
			") AND " + 
				"(ESTIMATE_DATE LIKE '" + bean.getEstimateDate() + "'" +
			") AND " +
				"(SUBMIT_NAME LIKE '" + bean.getSubmitName() + "'" +
			") AND " +
				"(TITLE LIKE '" + bean.getTitle() +"'" + 
			") GROUP BY " +
				"ESTIMATE_SHEET_ID " +
			"ORDER BY " + 
				"ESTIMATE_SHEET_ID";
		
		return sql;
		
	}
	
	/* 見積番号押下 消費税率反映 */
	public String billToTaxRate(String estimateSheetId) {
		
		String sql;
		
		sql = "SELECT DISTINCT " +
				"estx.CTAX_RATE " +
			"FROM " +
				"estimate_sheet_trn_xxxxx AS estx " +
			"WHERE " +
				"estx.ESTIMATE_SHEET_ID = '" + estimateSheetId + "'";
		
		return sql;
		
	}
	
	/* 見積番号押下 顧客情報反映 */
	public String billToCustomer(String estimateSheetId) {
		
		String sql;
		
		sql = "SELECT DISTINCT " + 
				"estx.CUSTOMER_CODE, " + 
				"cmx.CUSTOMER_NAME, " + 
				"a.CATEGORY_CODE_NAME, " + 
				"b.CATEGORY_CODE_NAME, " + 
				"c.CATEGORY_CODE_NAME, " + 
				"estx.CUSTOMER_REMARKS, " + 
				"estx.CUSTOMER_COMMENT_DATA " + 
			"FROM " + 
				"estimate_sheet_trn_xxxxx AS estx " + 
				"LEFT OUTER JOIN " + 
					"customer_mst_xxxxx AS cmx " + 
				"USING(CUSTOMER_CODE) " + 
				"LEFT OUTER JOIN " + 
					"(SELECT * FROM category_trn_xxxxx WHERE CATEGORY_ID='29') AS a " + 
				"ON " + 
					"cmx.TAX_SHIFT_CATEGORY=a.CATEGORY_CODE " + 
				"LEFT OUTER JOIN " + 
					"(SELECT * FROM category_trn_xxxxx WHERE CATEGORY_ID='11') AS b " + 
				"ON " + 
					"cmx.CUTOFF_GROUP=b.CATEGORY_CODE " + 
				"LEFT OUTER JOIN " + 
					"(SELECT * " + 
					"FROM category_trn_xxxxx " + 
					"WHERE CATEGORY_ID='32') AS c " + 
				"ON " + 
					"cmx.SALES_CM_CATEGORY = (c.CATEGORY_CODE + 1) " + 
			"WHERE " + 
				"estx.ESTIMATE_SHEET_ID = '" + estimateSheetId + "'";
		
		return sql;
	}
	
	/* 見積番号押下 納入先情報反映 */
	public String billToDelivery(String estimateSheetId) {
	
		String sql;
		
		sql = "SELECT DISTINCT " + 
				"dmx.DELIVERY_NAME, " + 
				"dmx.DELIVERY_OFFICE_NAME, " + 
				"dmx.DELIVERY_DEPT_NAME, " + 
				"dmx.DELIVERY_ZIP_CODE, " + 
				"dmx.DELIVERY_ADDRESS_1, " + 
				"dmx.DELIVERY_ADDRESS_2, " + 
				"dmx.DELIVERY_PC_NAME, " + 
				"dmx.DELIVERY_PC_KANA, " + 
				"a.CATEGORY_CODE_NAME, " + 
				"dmx.DELIVERY_TEL, " + 
				"dmx.DELIVERY_FAX, " + 
				"dmx.DELIVERY_EMAIL " + 
			"FROM " + 
				"delivery_mst_xxxxx AS dmx " + 
				"LEFT OUTER JOIN " + 
					"(SELECT * FROM category_trn_xxxxx WHERE CATEGORY_ID='10') AS a " + 
				"ON " + 
					"dmx.DELIVERY_PC_PRE_CATEGORY=CATEGORY_CODE " + 
				"LEFT OUTER JOIN " + 
					"estimate_sheet_trn_xxxxx AS estx " + 
				"ON " + 
					"estx.CUSTOMER_NAME=dmx.DELIVERY_NAME " + 
			"WHERE " + 
				"ESTIMATE_SHEET_ID = '" + estimateSheetId + "'";
		
		return sql;
		
	}
	
	/* 商品在庫モーダル */
	/* 親画面から在庫モーダル 商品情報反映 */
	public String StockInfoShow(String productCode) {
		
		String sql;
		
		sql = "SELECT" + 
				"pmx.PRODUCT_CODE, " + 
				"pmx.SUPPLIER_PCODE, " + 
				"b.CATEGORY_CODE_NAME, " + 
				"pmx.PRODUCT_NAME, " + 
				"a.WAREHOUSE_NAME, " + 
				"a.RACK_CODE, " + 
				"c.CATEGORY_CODE_NAME, " + 
				"d.CATEGORY_CODE_NAME, " + 
				"smx.STOCK_QUANTITY, " + 
				"SUM(rltx.QUANTITY) " + 
			"FROM " + 
				"product_mst_xxxxx AS pmx " + 
				"LEFT OUTER JOIN " + 
					"(SELECT RACK_CODE, WAREHOUSE_NAME FROM warehouse_mst_xxxxx " + 
				"LEFT OUTER JOIN rack_mst_xxxxx " + 
				"USING(WAREHOUSE_CODE)) AS a " + 
				"USING(RACK_CODE) " + 
				"LEFT OUTER JOIN " + 
					"(SELECT * FROM category_trn_xxxxx WHERE CATEGORY_ID='2') AS b " + 
				"ON " + 
					"pmx.SET_TYPE_CATEGORY = b.CATEGORY_CODE " + 
				"LEFT OUTER JOIN " + 
					"(SELECT * FROM category_trn_xxxxx WHERE CATEGORY_ID='16') AS c " + 
				"ON " + 
					"pmx.PRODUCT_STATUS_CATEGORY = c.CATEGORY_CODE " + 
				"LEFT OUTER JOIN " + 
					"(SELECT * FROM category_trn_xxxxx WHERE CATEGORY_ID='17') AS d " + 
				"ON " + 
					"pmx.PRODUCT_STOCK_CATEGORY = d.CATEGORY_CODE " + 
				"LEFT OUTER JOIN " + 
					"ro_line_trn_xxxxx AS rltx " + 
				"USING(PRODUCT_CODE) " + 
				"LEFT OUTER JOIN " + 
					"stock_mst_xxxxx AS smx " + 
				"USING(PRODUCT_CODE) " + 
			"WHERE pmx.Product_Code = '" + productCode + "'" +
			"GROUP BY PRODUCT_CODE";
		
		return sql;
	}
	
	/* 親画面から在庫モーダル 受注残明細反映 */
	public String StockDetailShow(String productCode) {
		
		String sql;
		
		sql = "SELECT DISTINCT " + 
				"CONCAT(rltx.RO_SLIP_ID, '-', rltx.LINE_NO), " + 
				"rstx.SHIP_DATE, " + 
				"rltx.QUANTITY " + 
			"FROM " + 
				"ro_line_trn_xxxxx AS rltx " + 
				"LEFT OUTER JOIN " + 
				"ro_slip_trn_xxxxx AS rstx " + 
				"USING(RO_SLIP_ID) " + 
			"WHERE " + 
				"PRODUCT_CODE = '" + productCode + "'";
		
		return sql;
		
	}
	
	/* 受注番号-行押下  編集画面に受注伝票反映 */
	public String linkUpdateOrder(String roSlipId) {
		
		String sql;
		
		sql = "SELECT DISTINCT " + 
				"RO_SLIP_ID, " + 
				"RO_DATE, " + 
				"SHIP_DATE, " + 
				"DELIVERY_DATE, " + 
				"RECEPT_NO, " + 
				"CUSTOMER_SLIP_NO, " + 
				"USER_NAME, " + 
				"REMARKS, " + 
				"DC_NAME, " + 
				"DC_TIMEZONE, " + 
				"CTAX_RATE " + 
			"FROM " + 
				"ro_slip_trn_xxxxx " + 
			"WHERE " + 
				"RO_SLIP_ID = '" + roSlipId + "'";
		
		return sql;
		
	}
	
	/* 受注番号-行押下  編集画面に顧客情報反映 */
	public String linkUpdateCustomer(String roSlipId) {
		
		String sql;
		
		sql = "SELECT DISTINCT " + 
				"rstx.CUSTOMER_CODE, " + 
				"rstx.CUSTOMER_NAME, " + 
				"a.CATEGORY_CODE_NAME, " + 
				"b.CATEGORY_CODE_NAME, " + 
				"c.CATEGORY_CODE_NAME, " + 
				"rstx.CUSTOMER_REMARKS, " + 
				"rstx.CUSTOMER_COMMENT_DATA " + 
			"FROM " + 
				"ro_slip_trn_xxxxx AS rstx " + 
				"LEFT OUTER JOIN " + 
					"ro_line_trn_xxxxx AS rltx " + 
				"USING(RO_SLIP_ID) " + 
				"LEFT OUTER JOIN " + 
					"(SELECT * FROM category_trn_xxxxx WHERE CATEGORY_ID='29') AS a " + 
				"ON " + 
					"rstx.TAX_SHIFT_CATEGORY=a.CATEGORY_CODE " + 
				"LEFT OUTER JOIN " + 
					"(SELECT * FROM category_trn_xxxxx WHERE CATEGORY_ID='11') AS b " + 
				"ON " + 
					"rstx.CUTOFF_GROUP=b.CATEGORY_CODE " + 
				"LEFT OUTER JOIN " + 
					"(SELECT * " + 
					"FROM category_trn_xxxxx " + 
					"WHERE CATEGORY_ID='32') AS c " + 
				"ON " + 
					"rstx.SALES_CM_CATEGORY = (c.CATEGORY_CODE + 1) " + 
			"WHERE rltx.RO_SLIP_ID = '" + roSlipId + "'";
		
		return sql;
				
	}
	
	/* 受注番号-行押下 編集画面に納入先情報反映 */
	public String linkUpdateDelivery(String roSlipId) {
		
		String sql;
		
		sql = "SELECT DISTINCT " + 
				"DELIVERY_NAME, " + 
				"DELIVERY_OFFICE_NAME, " + 
				"DELIVERY_DEPT_NAME, " + 
				"DELIVERY_ZIP_CODE, " + 
				"DELIVERY_ADDRESS_1, " + 
				"DELIVERY_ADDRESS_2, " + 
				"DELIVERY_PC_NAME, " + 
				"DELIVERY_PC_KANA, " + 
				"DELIVERY_PC_PRE, " + 
				"DELIVERY_TEL, " + 
				"DELIVERY_FAX, " + 
				"DELIVERY_EMAIL " + 
			"FROM " + 
				"ro_slip_trn_xxxxx " + 
				"LEFT OUTER JOIN " + 
					"ro_line_trn_xxxxx rltx " + 
				"USING(RO_SLIP_ID) " + 
			"WHERE rltx.RO_SLIP_ID = '" + roSlipId + "'";
		
		return sql;
		
	}
	
	/* 受注番号-行押下 編集画面に明細情報反映 */
	public String linkUpdateDetail(String roSlipId) {
		
		String sql;
		
		sql = "SELECT DISTINCT " +
				"rltx.PRODUCT_CODE, " +
				"pmx.PRODUCT_NAME, " +
				"rltx.PRODUCT_REMARKS, " +
				"pmx.RACK_CODE, " +
				"rltx.QUANTITY, " +
				"rltx.UNIT_COST, " +
				"rltx.COST, " +
				"rltx.UNIT_RETAIL_PRICE, " +
				"rltx.RETAIL_PRICE, " +
				"rltx.PRODUCT_ABSTRACT, " +
				"rltx.EAD_REMARKS, " +
				"rstn.RETAIL_PRICE_TOTAL, " +
				"rstn.CTAX_PRICE_TOTAL, " +
				"rstn.PRICE_TOTAL " +
			"FROM " +
				"ro_line_trn_xxxxx AS rltx " +
				"LEFT OUTER JOIN " +
					"product_mst_xxxxx AS pmx " +
					"USING(PRODUCT_CODE) " +
				"LEFT OUTER JOIN " +
					"ro_slip_trn_xxxxx AS rstn " +
					"USING(RO_SLIP_ID) " +
			"WHERE " +
				"RO_SLIP_ID LIKE '" + roSlipId + "'";
		
		return sql;
		
	}
	
	/* 受注新規登録画面から受注編集画面 */
	/* 受注番号入力 受注編集の受注、顧客、納入先反映 */
	public String moveOrderUpdateInfo(Integer roSlipId) {
		
		String sql;
		
		sql = "SELECT " + 
				"rstx.RO_SLIP_ID, " + 
				"rstx.RO_DATE, " + 
				"rstx.SHIP_DATE, " + 
				"rstx.DELIVERY_DATE, " + 
				"rstx.RECEPT_NO, " + 
				"rstx.CUSTOMER_SLIP_NO, " + 
				"rstx.USER_NAME, " + 
				"rstx.REMARKS, " + 
				"rstx.DC_NAME, " + 
				"rstx.DC_TIMEZONE, " + 
				"rstx.CTAX_RATE, " + 
				"rstx.CUSTOMER_CODE, " + 
				"rstx.CUSTOMER_NAME, " + 
				"a.CATEGORY_CODE_NAME, " + 
				"b.CATEGORY_CODE_NAME, " + 
				"c.CATEGORY_CODE_NAME, " + 
				"rstx.CUSTOMER_REMARKS, " + 
				"rstx.CUSTOMER_COMMENT_DATA, " + 
				"rstx.DELIVERY_NAME, " + 
				"rstx.DELIVERY_OFFICE_NAME, " + 
				"rstx.DELIVERY_DEPT_NAME, " + 
				"rstx.DELIVERY_ZIP_CODE, " + 
				"rstx.DELIVERY_ADDRESS_1, " + 
				"rstx.DELIVERY_ADDRESS_2, " + 
				"rstx.DELIVERY_PC_NAME, " + 
				"rstx.DELIVERY_PC_KANA, " + 
				"rstx.DELIVERY_PC_PRE, " + 
				"rstx.DELIVERY_TEL, " + 
				"rstx.DELIVERY_FAX, " + 
				"rstx.DELIVERY_EMAIL " + 
			"FROM " + 
				"ro_slip_trn_xxxxx AS rstx " + 
				"LEFT OUTER JOIN " + 
					"(SELECT * FROM category_trn_xxxxx WHERE CATEGORY_ID='29') AS a " + 
				"ON " + 
				"rstx.TAX_SHIFT_CATEGORY=a.CATEGORY_CODE " + 
				"LEFT OUTER JOIN " + 
					"(SELECT * FROM category_trn_xxxxx WHERE CATEGORY_ID='11') AS b " + 
				"ON " + 
				"rstx.CUTOFF_GROUP=b.CATEGORY_CODE " + 
				"LEFT OUTER JOIN " + 
					"(SELECT * FROM category_trn_xxxxx WHERE CATEGORY_ID='32') AS c " + 
				"ON " + 
				"rstx.SALES_CM_CATEGORY = (c.CATEGORY_CODE + 1) " + 
			"WHERE " + 
				"RO_SLIP_ID = '" + roSlipId + "'";
		
		return sql;
		
	}
	
	/* 受注番号入力 受注編集の受注明細反映 */
	public String moveOrderUpdateDetail(Integer roSlipId) {
		
		String sql;
		
		sql = "SELECT DISTINCT " + 
				"rltx.PRODUCT_CODE, " + 
				"pmx.PRODUCT_NAME, " + 
				"pmx.REMARKS, " + 
				"rltx.RACK_CODE_SRC, " + 
				"rltx.QUANTITY, " + 
				"rltx.UNIT_COST, " + 
				"rltx.COST, " + 
				"rltx.UNIT_RETAIL_PRICE, " + 
				"rltx.RETAIL_PRICE, " + 
				"rltx.REMARKS, " + 
				"rltx.EAD_REMARKS " + 
			"FROM " + 
				"ro_line_trn_xxxxx AS rltx " + 
				"LEFT OUTER JOIN " + 
					"product_mst_xxxxx AS pmx " + 
				"USING(PRODUCT_CODE) " + 
			"WHERE " + 
				"rltx.RO_SLIP_ID ='" + roSlipId + "'";
		
		return sql;
		
	}
	
	/* 顧客コード入力 納入先情報反映 */
	public String customerCodeToDeliveryInfo(String customerCode) {
		
		String sql;
		
		sql = "SELECT " + 
				"cmx.CUSTOMER_CODE, " + 
				"cmx.CUSTOMER_NAME, " + 
				"a.CATEGORY_CODE_NAME, " + 
				"b.CATEGORY_CODE_NAME, " + 
				"c.CATEGORY_CODE_NAME, " + 
				"cmx.REMARKS, " + 
				"cmx.COMMENT_DATA " + 
			"FROM " + 
				"customer_mst_xxxxx cmx " + 
				"LEFT OUTER JOIN " + 
					"(SELECT * FROM category_trn_xxxxx WHERE CATEGORY_ID='29') AS a " + 
				"ON " + 
					"cmx.TAX_SHIFT_CATEGORY=a.CATEGORY_CODE " + 
				"LEFT OUTER JOIN " + 
					"(SELECT * FROM category_trn_xxxxx WHERE CATEGORY_ID='11') AS b " + 
				"ON " + 
					"cmx.CUTOFF_GROUP=b.CATEGORY_CODE \r\n" + 
				"LEFT OUTER JOIN " + 
					"(SELECT * FROM category_trn_xxxxx WHERE CATEGORY_ID='32') AS c " + 
				"ON " + 
					"cmx.SALES_CM_CATEGORY = (c.CATEGORY_CODE + 1) " + 
			"WHERE " + 
				"cmx.CUSTOMER_CODE = '" + customerCode + "'";
		
		return sql;
	}
	
	/* 受注明細の新規入力（商品コードをもとに商品情報反映） */
	public String productCodeToOrderDetail(String productCode) {
		
		String sql;
		
		sql = "SELECT DISTINCT " + 
				"pmx.PRODUCT_CODE, " + 
				"pmx.PRODUCT_NAME, " + 
				"pmx.REMARKS, " + 
				"pmx.RACK_CODE, " + 
				"pmx.SUPPLIER_PRICE_YEN, " + 
				"pmx.RETAIL_PRICE, " + 
				"pmx.EAD_REMARKS " + 
			"FROM " + 
				"product_mst_xxxxx AS pmx " + 
			"WHERE " + 
				"pmx.PRODUCT_CODE = '" + productCode + "'";
		
		return sql;
		
	}
	
	/* 顧客納入先コンボボックス選択（選択結果をもとに納入先情報を反映） */
	public String deliveryNameToDeliveryInfo(String deliveryName) {
		
		String sql;
		
		sql = "SELECT DISTINCT " + 
				"dmx.DELIVERY_NAME, " + 
				"dmx.DELIVERY_OFFICE_NAME, " + 
				"dmx.DELIVERY_DEPT_NAME, " + 
				"dmx.DELIVERY_ZIP_CODE, " + 
				"dmx.DELIVERY_ADDRESS_1, " + 
				"dmx.DELIVERY_ADDRESS_2, " + 
				"dmx.DELIVERY_PC_NAME, " + 
				"dmx.DELIVERY_PC_KANA, " + 
				"a.CATEGORY_CODE_NAME, " + 
				"dmx.DELIVERY_TEL, " + 
				"dmx.DELIVERY_FAX, " + 
				"dmx.DELIVERY_EMAIL " + 
			"FROM " + 
				"delivery_mst_xxxxx AS dmx " + 
				"LEFT OUTER JOIN " + 
					"(SELECT * FROM category_trn_xxxxx WHERE CATEGORY_ID='10') AS a " + 
				"ON " + 
					"dmx.DELIVERY_PC_PRE_CATEGORY=a.CATEGORY_CODE " + 
			"WHERE " + 
				"DELIVERY_NAME = '" + deliveryName + "'";
		
		return sql;
		
	}
	
	/* 顧客納入先コンボボックス */
	public String initDeliveryName(String customerCode) {
		
		String sql;
		
		sql = "SELECT " + 
				"DELIVERY_NAME " + 
			"FROM " + 
				"delivery_mst_xxxxx AS dmx " + 
				"LEFT OUTER JOIN " + 
					"(SELECT * FROM customer_rel_xxxxx WHERE CUST_REL_CATEGORY='01') AS crx " + 
				"ON " + 
					"dmx.DELIVERY_CODE=crx.REL_CODE " + 
				"LEFT OUTER JOIN " + 
					"customer_mst_xxxxx " + 
				"USING(CUSTOMER_CODE) " + 
			"WHERE " + 
				"CUSTOMER_CODE='" + customerCode + "'";
		
		return sql;
		
	}
	
	/* 受注削除 */
	public String deleteOrderInfo(String roSlipId) {
		
		String sql;
		
		sql = "DELETE " + 
			"FROM " + 
				"ro_slip_trn_xxxxx " + 
			"WHERE " + 
				"RO_SLIP_ID='" + roSlipId + "'";
		
		return sql;
		
	}
	
	/* 受注削除 明細 */
	public String deleteOrderDetail(String roSlipId) {
		
		String sql;
		
		sql = "DELETE " + 
			"FROM " + 
				"ro_line_trn_xxxxx " + 
			"WHERE " + 
				"RO_SLIP_ID='" + roSlipId + "'";
		
		return sql;
		
	}
	
	/* 受注新規登録 */
	public String orderInputInfo() {
		
		String sql;
		
		sql = "INSERT INTO " + 
				"ro_slip_trn_xxxxx(RO_DATE, " + 
				"SHIP_DATE, " + 
				"DELIVERY_DATE, " +
				"RECEPT_NO, " + 
				"CUSTOMER_SLIP_NO, " +
				"USER_NAME, " + 
				"REMARKS, " + 
				"DC_NAME, " +
				"DC_TIMEZONE, " +
				"CTAX_RATE, " + 
				"CUSTOMER_CODE, " +
				"CUSTOMER_NAME, " + 
				"TAX_SHIFT_CATEGORY, " +
				"CUTOFF_GROUP, " +
				"SALES_CM_CATEGORY, " + 
				"CUSTOMER_REMARKS, " +
				"CUSTOMER_COMMENT_DATA, " + 
				"DELIVERY_NAME, " + 
				"DELIVERY_OFFICE_NAME, " +
				"DELIVERY_DEPT_NAME, " +
				"DELIVERY_ZIP_CODE, " +
				"DELIVERY_ADDRESS_1, " +
				"DELIVERY_ADDRESS_2, " + 
				"DELIVERY_PC_NAME, " +
				"DELIVERY_PC_KANA, " + 
				"DELIVERY_PC_PRE, " +
				"DELIVERY_TEL, " +
				"DELIVERY_FAX, " +
				"DELIVERY_EMAIL, " +
				"RETAIL_PRICE_TOTAL, " +
				"CTAX_PRICE_TOTAL, " +
				"PRICE_TOTAL) " +
				"VALUES " + 
				"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		return sql;
		
	}
	
	/* 受注新規登録 明細 */
	public String orderInputDetail() {
		
		String sql;
		
		sql = "INSERT INTO " +
				"ro_line_trn_xxxxx(PRODUCT_CODE, " +
				"PRODUCT_NAME, " +
				"PRODUCT_REMARKS, " +
				"RACK_CODE, " +
				"QUANTITY, " +
				"UNIT_COST, " +
				"COST, " +
				"UNIT_RETAIL_PRICE, " +
				"RETAIL_PRICE, " +
				"REMARKS, " +
				"EAD_REMARKS) " +
				"VALUES " +
				"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		return sql;
		
	}
	
	/* 受注更新 */
	public String orderUpdateInfo() {
		
		String sql;
		
		sql = "UPDATE " + 
				"ro_slip_trn_xxxxx " + 
			"SET " +
				"RO_DATE = ?, " +
				"SHIP_DATE = ?, " + 
				"DELIVERY_DATE = ?, " +
				"RECEPT_NO = ?, " + 
				"CUSTOMER_SLIP_NO = ?, " +
				"USER_NAME = ?, " + 
				"REMARKS = ?, " + 
				"DC_NAME = ?, " +
				"DC_TIMEZONE = ?, " +
				"CTAX_RATE = ?, " + 
				"CUSTOMER_CODE = ?, " +
				"CUSTOMER_NAME = ?, " + 
				"TAX_SHIFT_CATEGORY = ?, " +
				"CUTOFF_GROUP = ?, " +
				"SALES_CM_CATEGORY = ?, " + 
				"CUSTOMER_REMARKS = ?, " +
				"CUSTOMER_COMMENT_DATA = ?, " + 
				"DELIVERY_NAME = ?, " + 
				"DELIVERY_OFFICE_NAME = ?, " +
				"DELIVERY_DEPT_NAME = ?, " +
				"DELIVERY_ZIP_CODE = ?, " +
				"DELIVERY_ADDRESS_1 = ?, " +
				"DELIVERY_ADDRESS_2 = ?, " + 
				"DELIVERY_PC_NAME = ?, " +
				"DELIVERY_PC_KANA = ?, " + 
				"DELIVERY_PC_PRE = ?, " +
				"DELIVERY_TEL = ?, " +
				"DELIVERY_FAX = ?, " +
				"DELIVERY_EMAIL = ?, " +
				"RETAIL_PRICE_TOTAL = ?, " +
				"CTAX_PRICE_TOTAL = ?, " +
				"PRICE_TOTAL = ? " +
			"WHERE RO_SLIP_ID = ?";
		
		return sql;
		
	}
	
	/* 受注更新 明細 */
	public String orderUpdateDetail() {
		
		String sql;
		
		sql = "UPDATE " + 
				"ro_line_trn_xxxxx " +
			"SET " +
				"PRODUCT_CODE = ?, " +
				"PRODUCT_NAME = ?, " +
				"PRODUCT_REMARKS = ?, " +
				"RACK_CODE = ?, " +
				"QUANTITY = ?, " +
				"UNIT_COST = ?, " +
				"COST = ?, " +
				"UNIT_RETAIL_PRICE = ?, " +
				"RETAIL_PRICE = ?, " +
				"REMARKS = ?, " +
				"EAD_REMARKS = ? " +
			"WHERE RO_SLIP_ID = ?";
		
		return sql;
		
	}
	
	/* 取引区分コンボボックス */
	public String initSalesCmCategory() {
		
		String sql;
		
		sql = "SELECT DISTINCT " + 
				"rstx.SALES_CM_CATEGORY, " +
				"ctx.CATEGORY_CODE_NAME " + 
			"FROM " + 
				"ro_slip_trn_xxxxx AS rstx " + 
				"LEFT OUTER JOIN " + 
					"(SELECT * " + 
					"FROM category_trn_xxxxx " + 
					"WHERE CATEGORY_ID='32') AS ctx " + 
			"ON " + 
				"rstx.SALES_CM_CATEGORY = (ctx.CATEGORY_CODE + 1)";
		
		return sql;
		
	}
	
	/* 支払条件コンボボックス */
	public String initCutoffGroup() {
		
		String sql;
		
		sql = "SELECT CATEGORY_CODE_NAME " + 
				"FROM category_trn_xxxxx " + 
				"WHERE CATEGORY_ID='11'";
		
		return sql;
		
	}
	
	/* 税転嫁コンボボックス */
	public String initTaxShiftCategory() {
		
		String sql;
		
		sql = "SELECT CATEGORY_CODE_NAME " + 
				"FROM category_trn_xxxxx " + 
				"WHERE CATEGORY_ID='29'";
		
		return sql;
		
	}
		
	/* 配送業者コンボボックス */
	public String initDcName() {
		
		String sql;
		
		sql = "SELECT CATEGORY_CODE_NAME, CATEGORY_CODE " + 
				"FROM category_trn_xxxxx " + 
				"WHERE CATEGORY_ID='36'";
		
		return sql;
		
	}
	
	/* 配送時間帯コンボボックス */
	public String initDcTimezone() {
		
		String sql;
		
		sql = "SELECT CATEGORY_CODE_NAME, CATEGORY_CODE " + 
				"FROM category_trn_xxxxx " + 
				"WHERE CATEGORY_ID='37'";
		
		return sql;
		
	}
	
	/* 消費税率コンボボックス */
	public String initTaxRate() {
		
		String sql;
		
		sql = "SELECT TAX_RATE " + 
				"FROM tax_rate_mst_xxxxx";
		
		return sql;
		
	}

	
	public String searchOrderBill(OrderSearchBean bean, String[] inputlist, String rowCount, String sort, int currentPage, String orderBy) {
		
		String sql;
		
		sql = "SELECT";
		
		for(int i = 0; i <inputlist.length; i++) {
			sql = sql + " " + inputlist[i] + ",";
		}
		
		sql = sql.substring(0, sql.length()-1) + " ";
		
		sql = sql +
				"FROM " + 
				"ro_slip_trn_xxxxx AS rstx " +  
				"LEFT OUTER JOIN " + 
				"category_trn_xxxxx AS ctx1 " + 
				"ON rstx.tax_shift_category = ctx1.category_code " + 
				"AND ctx1.category_id = '29' " + 
				"LEFT OUTER JOIN " + 
				"category_trn_xxxxx AS ctx2 " + 
				"ON rstx.sales_cm_category = ctx2.category_code " + 
				"AND ctx2.category_id = '32' " +
				"LEFT OUTER JOIN " + 
				"category_trn_xxxxx AS ctx3 " + 
				"ON rstx.cutoff_group = ctx3.category_code " + 
				"AND ctx3.category_id = '5' " +
				"LEFT OUTER JOIN " + 
				"ro_line_trn_xxxxx AS rltx " +
				"USING(RO_SLIP_ID) " +
				"LEFT OUTER JOIN " + 
				"product_mst_xxxxx as pmx " + 
				"USING(PRODUCT_CODE) " +
				"WHERE " +
				"(rstx.ro_slip_id " + com.stringIsNull(bean.getOrderNo()) +
				"AND " +
				"(rstx.recept_no " + com.stringIsNull(bean.getRepNo()) +
				"AND " +
				"(rstx.ro_date " + dateIsNull(bean.getOrderDayStart(),bean.getOrderDayEnd()) +
				"AND " +
				"(rstx.ship_date " + dateIsNull(bean.getShipDayStart(),bean.getShipDayEnd()) +
				"AND " +
				"(rstx.delivery_date " + dateIsNull(bean.getDeliveryDayStart(),bean.getDeliveryDayEnd()) +
				"AND " +
				"(rltx.product_code " + com.stringIsNull(bean.getProductCode()) +
				"AND " +
				"(pmx.product_name " + com.stringIsNull(bean.getProductName()) +
				"AND " +
				"(rstx.sales_cm_category " + stringArrayIsNull(bean.getWithdrawl()) +
				"AND " +
				"(rstx.customer_code " + com.stringIsNull(bean.getCustomerCode()) +
				"AND " +
				"(rstx.customer_name " + com.stringIsNull(bean.getCustomerName()) +
				"AND " +
				"(pmx.product_1 " + com.stringIsNull(bean.getProduct1()) +
				"AND " +
				"(pmx.product_2 " + com.stringIsNull(bean.getProduct2()) +
				"AND " +
				"(pmx.product_3 " + com.stringIsNull(bean.getProduct3()) +
				"AND " +
				"(pmx.supplier_code " + com.stringIsNull(bean.getSupplierCode()) +
				"AND " +
				"(rstx.delivery_name " + com.stringIsNull(bean.getSupplierName()) +
				"GROUP BY (rstx.RO_SLIP_ID) " +
				"ORDER BY (" + sort + ") " + orderBy + " " +
			 	"LIMIT " + rowCount + " OFFSET " + Integer.parseInt(rowCount)*(currentPage-1);
				
		return sql;
	}
	
	public String getOrderBillCount(OrderSearchBean bean) {
		
		String sql;
		
		sql = "SELECT ";
		
		sql+= "COUNT(*) ";
		
		sql = sql +
				"FROM " + 
				"ro_slip_trn_xxxxx AS rstx " +  
				"LEFT OUTER JOIN " + 
				"category_trn_xxxxx AS ctx1 " + 
				"ON rstx.tax_shift_category = ctx1.category_code " + 
				"AND ctx1.category_id = '29' " + 
				"LEFT OUTER JOIN " + 
				"category_trn_xxxxx AS ctx2 " + 
				"ON rstx.sales_cm_category = ctx2.category_code " + 
				"AND ctx2.category_id = '32' " +
				"LEFT OUTER JOIN " + 
				"category_trn_xxxxx AS ctx3 " + 
				"ON rstx.cutoff_group = ctx3.category_code " + 
				"AND ctx3.category_id = '5' " +
				"LEFT OUTER JOIN " + 
				"ro_line_trn_xxxxx AS rltx " +
				"USING(RO_SLIP_ID) " +
				"LEFT OUTER JOIN " + 
				"product_mst_xxxxx as pmx " + 
				"USING(PRODUCT_CODE) " +
				"WHERE " +
				"(rstx.ro_slip_id " + com.stringIsNull(bean.getOrderNo()) +
				"AND " +
				"(rstx.recept_no " + com.stringIsNull(bean.getRepNo()) +
				"AND " +
				"(rstx.ro_date " + dateIsNull(bean.getOrderDayStart(),bean.getOrderDayEnd()) +
				"AND " +
				"(rstx.ship_date " + dateIsNull(bean.getShipDayStart(),bean.getShipDayEnd()) +
				"AND " +
				"(rstx.delivery_date " + dateIsNull(bean.getDeliveryDayStart(),bean.getDeliveryDayEnd()) +
				"AND " +
				"(rltx.product_code " + com.stringIsNull(bean.getProductCode()) +
				"AND " +
				"(pmx.product_name " + com.stringIsNull(bean.getProductName()) +
				"AND " +
				"(rstx.sales_cm_category " + stringArrayIsNull(bean.getWithdrawl()) +
				"AND " +
				"(rstx.customer_code " + com.stringIsNull(bean.getCustomerCode()) +
				"AND " +
				"(rstx.customer_name " + com.stringIsNull(bean.getCustomerName()) +
				"AND " +
				"(pmx.product_1 " + com.stringIsNull(bean.getProduct1()) +
				"AND " +
				"(pmx.product_2 " + com.stringIsNull(bean.getProduct2()) +
				"AND " +
				"(pmx.product_3 " + com.stringIsNull(bean.getProduct3()) +
				"AND " +
				"(pmx.supplier_code " + com.stringIsNull(bean.getSupplierCode()) +
				"AND " +
				"(rstx.delivery_name " + com.stringIsNull(bean.getSupplierName()) +
				"GROUP BY (rstx.RO_SLIP_ID) ";
		
		return sql;
	}
	
	public String searchOrderDetail(OrderSearchBean bean, String[] inputlist, String rowCount, String sort, int currentPage, String orderBy) {
		
		String sql;

		sql = "SELECT";
		
		for(int i = 0; i <inputlist.length; i++) {
			sql = sql + " " + inputlist[i] + ",";
		}
		
		sql = sql.substring(0, sql.length()-1) + " ";
		
		sql = sql + 
				"FROM " + 
				"ro_line_trn_xxxxx AS rltx " + 
				"LEFT OUTER JOIN " + 
				"ro_slip_trn_xxxxx AS rstx " + 
				"USING(ro_slip_id) " + 
				"LEFT OUTER JOIN " + 
				"category_trn_xxxxx AS ctx1 " + 
				"ON rstx.tax_shift_category = ctx1.category_code " + 
				"AND ctx1.category_id = '29' " + 
				"LEFT OUTER JOIN " + 
				"category_trn_xxxxx AS ctx2 " + 
				"ON rstx.sales_cm_category = ctx2.category_code " + 
				"AND ctx2.category_id = '32' " +
				"LEFT OUTER JOIN " + 
				"category_trn_xxxxx AS ctx3 " + 
				"ON rstx.CUTOFF_GROUP = ctx3.category_code " + 
				"AND ctx3.category_id = '5' " +
				"LEFT OUTER JOIN " + 
				"product_mst_xxxxx as pmx " + 
				"USING(PRODUCT_CODE) " +
				"WHERE " +
				"(rstx.ro_slip_id " + com.stringIsNull(bean.getOrderNo()) +
				"AND " +
				"(rstx.recept_no " + com.stringIsNull(bean.getRepNo()) +
				"AND " +
				"(rstx.ro_date " + dateIsNull(bean.getOrderDayStart(),bean.getOrderDayEnd()) +
				"AND " +
				"(rstx.ship_date " + dateIsNull(bean.getShipDayStart(),bean.getShipDayEnd()) +
				"AND " +
				"(rstx.delivery_date " + dateIsNull(bean.getDeliveryDayStart(),bean.getDeliveryDayEnd()) +
				"AND " +
				"(rltx.product_code " + com.stringIsNull(bean.getProductCode()) +
				"AND " +
				"(pmx.product_name " + com.stringIsNull(bean.getProductName()) +
				"AND " +
				"(rstx.sales_cm_category " + stringArrayIsNull(bean.getWithdrawl()) +
				"AND " +
				"(rstx.customer_code " + com.stringIsNull(bean.getCustomerCode()) +
				"AND " +
				"(rstx.customer_name " + com.stringIsNull(bean.getCustomerName()) +
				"AND " +
				"(pmx.product_1 " + com.stringIsNull(bean.getProduct1()) +
				"AND " +
				"(pmx.product_2 " + com.stringIsNull(bean.getProduct2()) +
				"AND " +
				"(pmx.product_3 " + com.stringIsNull(bean.getProduct3()) +
				"AND " +
				"(pmx.supplier_code " + com.stringIsNull(bean.getSupplierCode()) +
				"AND " +
				"(rstx.delivery_name " + com.stringIsNull(bean.getSupplierName()) +
				"GROUP BY (CONCAT(rltx.ro_slip_id, '-', rltx.line_no)) " +
				"ORDER BY (" + sort + ") " + orderBy + " " +
				"LIMIT " + rowCount + " OFFSET " + Integer.parseInt(rowCount)*(currentPage-1);
		
		return sql;
	}

	public String getOrderDetailCount(OrderSearchBean bean) {
		
		String sql;
		
		sql = "SELECT ";
		
		sql+= "COUNT(*) ";
		
		sql = sql + 
				"FROM " + 
				"ro_line_trn_xxxxx AS rltx " + 
				"LEFT OUTER JOIN " + 
				"ro_slip_trn_xxxxx AS rstx " + 
				"USING(ro_slip_id) " + 
				"LEFT OUTER JOIN " + 
				"category_trn_xxxxx AS ctx1 " + 
				"ON rstx.tax_shift_category = ctx1.category_code " + 
				"AND ctx1.category_id = '29' " + 
				"LEFT OUTER JOIN " + 
				"category_trn_xxxxx AS ctx2 " + 
				"ON rstx.sales_cm_category = ctx2.category_code " + 
				"AND ctx2.category_id = '32' " +
				"LEFT OUTER JOIN " + 
				"category_trn_xxxxx AS ctx3 " + 
				"ON rstx.sales_cm_category = ctx2.category_code " + 
				"AND ctx2.category_id = '5' " +
				"LEFT OUTER JOIN " + 
				"product_mst_xxxxx as pmx " + 
				"USING(PRODUCT_CODE) " +
				"WHERE " +
				"(rstx.ro_slip_id " + com.stringIsNull(bean.getOrderNo()) +
				"AND " +
				"(rstx.recept_no " + com.stringIsNull(bean.getRepNo()) +
				"AND " +
				"(rstx.ro_date " + dateIsNull(bean.getOrderDayStart(),bean.getOrderDayEnd()) +
				"AND " +
				"(rstx.ship_date " + dateIsNull(bean.getShipDayStart(),bean.getShipDayEnd()) +
				"AND " +
				"(rstx.delivery_date " + dateIsNull(bean.getDeliveryDayStart(),bean.getDeliveryDayEnd()) +
				"AND " +
				"(rltx.product_code " + com.stringIsNull(bean.getProductCode()) +
				"AND " +
				"(pmx.product_name " + com.stringIsNull(bean.getProductName()) +
				"AND " +
				"(rstx.sales_cm_category " + stringArrayIsNull(bean.getWithdrawl()) +
				"AND " +
				"(rstx.customer_code " + com.stringIsNull(bean.getCustomerCode()) +
				"AND " +
				"(rstx.customer_name " + com.stringIsNull(bean.getCustomerName()) +
				"AND " +
				"(pmx.product_1 " + com.stringIsNull(bean.getProduct1()) +
				"AND " +
				"(pmx.product_2 " + com.stringIsNull(bean.getProduct2()) +
				"AND " +
				"(pmx.product_3 " + com.stringIsNull(bean.getProduct3()) +
				"AND " +
				"(pmx.supplier_code " + com.stringIsNull(bean.getSupplierCode()) +
				"AND " +
				"(rstx.delivery_name " + com.stringIsNull(bean.getSupplierName()) +
				"GROUP BY (CONCAT(rltx.ro_slip_id, '-', rltx.line_no))" ;

		return sql;
	}

	public String dateIsNull(String str1, String str2) {
		
		if((str1 == null || str1.equals("")) && (str2 == null || str2.equals("")))
			return "between '1900-01-01' and '9999-12-31' OR 1 = 1) ";
		else if ((str1 != null) && (str2 == null || str2.equals("")))
			return "between '" + str1 + "' and '9999-12-31') ";
		else if ((str1 == null || str1.equals("")) && (str2 != null))
			return "between '1900-01-01' and '" + str2 + "') ";
		else
			return "between '" + str1 + "' and '" + str2 + "') ";

	}
	
	public String stringArrayIsNull(String[] str) {
		
		String tmp = "";
		
		if(str == null) {
			tmp += "LIKE '%' OR 1 = 1) ";
		}
		else { 
			tmp += "IN( '";
			for(int i = 0; i <str.length; i++) {
				tmp += str[i] + "',";
			}
			tmp = tmp.substring(0, tmp.length()-1) + ")) ";
		}
		
		
		return tmp;
	}

}
