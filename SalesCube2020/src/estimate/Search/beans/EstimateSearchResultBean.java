package estimate.Search.beans;

public class EstimateSearchResultBean {
	
	//見積番号
	private String estimateSheetId;
	
	//見積日
	private String estimateDate;
	
	//有効期限
	private String validDate;
	
	//提出先名
	private String submitName;
	
	//提出先敬称
	private String submitPre;
	
	//顧客コード
	private String customerCode;
	
	//顧客名
	private String customerName;
	
	//粗利益
	private String grossProfit;
	
	//粗利益率
	private String grossProfitMargin;

	//金額合計
	private int retailPriceTotal;
	
	//消費税
	private int ctaxPriceTotal;
	
	//納期または出荷日
	private String deliveryInfo;
	
	//入力担当者コード
	private String userId;
	
	//入力担当者
	private String userName;
	
	//摘要
	private String remarks;
	
	//納入先
	private String deliveryName;
	
	//見積条件
	private String estimateCondition;
	
	//伝票合計
	private int estimateTotal;
	
	//件名
	private String title;
	
	private String itemId;

	/**
	 * @return the estimateSheetId
	 */
	public String getEstimateSheetId() {
		return estimateSheetId;
	}

	/**
	 * @param estimateSheetId the estimateSheetId to set
	 */
	public void setEstimateSheetId(String estimateSheetId) {
		this.estimateSheetId = estimateSheetId;
	}

	/**
	 * @return the estimateDate
	 */
	public String getEstimateDate() {
		return estimateDate;
	}

	/**
	 * @param estimateDate the estimateDate to set
	 */
	public void setEstimateDate(String estimateDate) {
		this.estimateDate = estimateDate;
	}

	/**
	 * @return the validDate
	 */
	public String getValidDate() {
		return validDate;
	}

	/**
	 * @param validDate the validDate to set
	 */
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	/**
	 * @return the submitName
	 */
	public String getSubmitName() {
		return submitName;
	}

	/**
	 * @param submitName the submitName to set
	 */
	public void setSubmitName(String submitName) {
		this.submitName = submitName;
	}

	/**
	 * @return the submitPre
	 */
	public String getSubmitPre() {
		return submitPre;
	}

	/**
	 * @param submitPre the submitPre to set
	 */
	public void setSubmitPre(String submitPre) {
		this.submitPre = submitPre;
	}

	/**
	 * @return the customerCode
	 */
	public String getCustomerCode() {
		return customerCode;
	}

	/**
	 * @param customerCode the customerCode to set
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the grossProfit
	 */
	public String getGrossProfit() {
		return grossProfit;
	}

	/**
	 * @param grossProfit the grossProfit to set
	 */
	public void setGrossProfit(String grossProfit) {
		this.grossProfit = grossProfit;
	}

	/**
	 * @return the grossProfitMargin
	 */
	public String getGrossProfitMargin() {
		return grossProfitMargin;
	}

	/**
	 * @param grossProfitMargin the grossProfitMargin to set
	 */
	public void setGrossProfitMargin(String grossProfitMargin) {
		this.grossProfitMargin = grossProfitMargin;
	}

	/**
	 * @return the retailPriceTotal
	 */
	public int getRetailPriceTotal() {
		return retailPriceTotal;
	}

	/**
	 * @param retailPriceTotal the retailPriceTotal to set
	 */
	public void setRetailPriceTotal(int retailPriceTotal) {
		this.retailPriceTotal = retailPriceTotal;
	}

	/**
	 * @return the ctaxPriceTotal
	 */
	public int getCtaxPriceTotal() {
		return ctaxPriceTotal;
	}

	/**
	 * @param ctaxPriceTotal the ctaxPriceTotal to set
	 */
	public void setCtaxPriceTotal(int ctaxPriceTotal) {
		this.ctaxPriceTotal = ctaxPriceTotal;
	}

	/**
	 * @return the deliveryInfo
	 */
	public String getDeliveryInfo() {
		return deliveryInfo;
	}

	/**
	 * @param deliveryInfo the deliveryInfo to set
	 */
	public void setDeliveryInfo(String deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the deliveryName
	 */
	public String getDeliveryName() {
		return deliveryName;
	}

	/**
	 * @param deliveryName the deliveryName to set
	 */
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	/**
	 * @return the estimateCondition
	 */
	public String getEstimateCondition() {
		return estimateCondition;
	}

	/**
	 * @param estimateCondition the estimateCondition to set
	 */
	public void setEstimateCondition(String estimateCondition) {
		this.estimateCondition = estimateCondition;
	}

	/**
	 * @return the estimateTotal
	 */
	public int getEstimateTotal() {
		return estimateTotal;
	}

	/**
	 * @param estimateTotal the estimateTotal to set
	 */
	public void setEstimateTotal(int estimateTotal) {
		this.estimateTotal = estimateTotal;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	

}