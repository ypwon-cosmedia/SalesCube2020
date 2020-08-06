package order.common.bill.beans;

/**
 * 
 * 作成日：2020/08/03
 * 作成者：宮本
 * 
 */

public class OrderCommonBillBean {
	/* 見積番号 */
	public String estimateSheetId;
	
	/* 見積日 */
	public String estimateDate;
	
	/* 提出先名 */
	public String submitName;
	
	/* 件名 */
	public String title;
	
	/* 消費税率 */
	private String ctaxRate;
	
	/* 顧客コード */
	private String customerCode;
	
	/* 顧客名 */
	private String customerName;
	
	/* 税転嫁 */
	private String taxShiftCategory;
	
	/* 支払条件 */
	private String cutoffGroup;
	
	/* 取引区分 */
	private String salesCmCategory;
	
	/* 備考 */
	private String customerRemarks;
	
	/* コメント */
	private String customerCommentData;
	
	/* 顧客納入先 */
	private String deliveryName;
	
	/* 事業所名 */
	private String deliveryOfficeName;
	
	/* 部署名 */
	private String deliveryDeptName;
	
	/* 郵便番号 */
	private String deliveryZipCode;
	
	/* 住所1 */
	private String deliveryAddress1;
	
	/* 住所2 */
	private String deliveryAddress2;
	
	/* 担当者 */
	private String deliveryPcName;
	
	/* 担当者カナ */
	private String deliveryPcKana;
	
	/* 敬称 */
	private String deliveryPcPre;
	
	/* TEL */
	private String deliveryTel;
	
	/* FAX */
	private String deliveryFax;
	
	/* Email */
	private String deliveryEmail;
	
	public String getCtaxRate() {
		return ctaxRate;
	}

	public void setCtaxRate(String ctaxRate) {
		this.ctaxRate = ctaxRate;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getTaxShiftCategory() {
		return taxShiftCategory;
	}

	public void setTaxShiftCategory(String taxShiftCategory) {
		this.taxShiftCategory = taxShiftCategory;
	}

	public String getCutoffGroup() {
		return cutoffGroup;
	}

	public void setCutoffGroup(String cutoffGroup) {
		this.cutoffGroup = cutoffGroup;
	}

	public String getSalesCmCategory() {
		return salesCmCategory;
	}

	public void setSalesCmCategory(String salesCmCategory) {
		this.salesCmCategory = salesCmCategory;
	}

	public String getCustomerRemarks() {
		return customerRemarks;
	}

	public void setCustomerRemarks(String customerRemarks) {
		this.customerRemarks = customerRemarks;
	}

	public String getCustomerCommentData() {
		return customerCommentData;
	}

	public void setCustomerCommentData(String customerCommentData) {
		this.customerCommentData = customerCommentData;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliveryOfficeName() {
		return deliveryOfficeName;
	}

	public void setDeliveryOfficeName(String deliveryOfficeName) {
		this.deliveryOfficeName = deliveryOfficeName;
	}

	public String getDeliveryDeptName() {
		return deliveryDeptName;
	}

	public void setDeliveryDeptName(String deliveryDeptName) {
		this.deliveryDeptName = deliveryDeptName;
	}

	public String getDeliveryZipCode() {
		return deliveryZipCode;
	}

	public void setDeliveryZipCode(String deliveryZipCode) {
		this.deliveryZipCode = deliveryZipCode;
	}

	public String getDeliveryAddress1() {
		return deliveryAddress1;
	}

	public void setDeliveryAddress1(String deliveryAddress1) {
		this.deliveryAddress1 = deliveryAddress1;
	}

	public String getDeliveryAddress2() {
		return deliveryAddress2;
	}

	public void setDeliveryAddress2(String deliveryAddress2) {
		this.deliveryAddress2 = deliveryAddress2;
	}

	public String getDeliveryPcName() {
		return deliveryPcName;
	}

	public void setDeliveryPcName(String deliveryPcName) {
		this.deliveryPcName = deliveryPcName;
	}

	public String getDeliveryPcKana() {
		return deliveryPcKana;
	}

	public void setDeliveryPcKana(String deliveryPcKana) {
		this.deliveryPcKana = deliveryPcKana;
	}

	public String getDeliveryPcPre() {
		return deliveryPcPre;
	}

	public void setDeliveryPcPre(String deliveryPcPre) {
		this.deliveryPcPre = deliveryPcPre;
	}

	public String getDeliveryTel() {
		return deliveryTel;
	}

	public void setDeliveryTel(String deliveryTel) {
		this.deliveryTel = deliveryTel;
	}

	public String getDeliveryFax() {
		return deliveryFax;
	}

	public void setDeliveryFax(String deliveryFax) {
		this.deliveryFax = deliveryFax;
	}

	public String getDeliveryEmail() {
		return deliveryEmail;
	}

	public void setDeliveryEmail(String deliveryEmail) {
		this.deliveryEmail = deliveryEmail;
	}

	public String getEstimateSheetId() {
		return estimateSheetId;
	}

	public void setEstimateSheetId(String estimateSheetId) {
		this.estimateSheetId = estimateSheetId;
	}

	public String getEstimateDate() {
		return estimateDate;
	}

	public void setEstimateDate(String estimateDate) {
		this.estimateDate = estimateDate;
	}

	public String getSubmitName() {
		return submitName;
	}

	public void setSubmitName(String submitName) {
		this.submitName = submitName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
