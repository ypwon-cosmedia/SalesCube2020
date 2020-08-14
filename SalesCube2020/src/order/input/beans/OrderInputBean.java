package order.input.beans;

/** 
 * 
 * 作成日：2020/08/03
 * 作成者：宮本
 * 
 */

public class OrderInputBean {
	/* 受注番号 */
	private Integer roSlipId;

	/* 受注日 */
	private String roDate;
	
	/* 出荷日 */
	private String shipDate;
	
	/* 納期指定日 */
	private String deliveryDate;
	
	/* 受付番号 */
	private String receptNo;
	
	/* 客先伝票番号 */
	private String customerSlipNo;
	
	/* 入力担当者 */
	private String userName;
	
	/* 摘要 */
	private String remarks;
	
	/* 配送業者 */
	private String dcName;
	
	/* 配送時間帯 */
	private String dcTimezone;
	
	/* 消費税率 */
	private String ctaxRate;

	/* 区分コード名 */
	private String categoryCodeName;
	
	/* 区分コード */
	private String categoryCode;

	public Integer getRoSlipId() {
		return roSlipId;
	}

	public void setRoSlipId(Integer roSlipId) {
		this.roSlipId = roSlipId;
	}

	public String getRoDate() {
		return roDate;
	}

	public void setRoDate(String roDate) {
		this.roDate = roDate;
	}

	public String getShipDate() {
		return shipDate;
	}

	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getReceptNo() {
		return receptNo;
	}

	public void setReceptNo(String receptNo) {
		this.receptNo = receptNo;
	}

	public String getCustomerSlipNo() {
		return customerSlipNo;
	}

	public void setCustomerSlipNo(String customerSlipNo) {
		this.customerSlipNo = customerSlipNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDcName() {
		return dcName;
	}

	public void setDcName(String dcName) {
		this.dcName = dcName;
	}

	public String getDcTimezone() {
		return dcTimezone;
	}

	public void setDcTimezone(String dcTimezone) {
		this.dcTimezone = dcTimezone;
	}

	public String getCtaxRate() {
		return ctaxRate;
	}

	public void setCtaxRate(String ctaxRate) {
		this.ctaxRate = ctaxRate;
	}

	public String getCategoryCodeName() {
		return categoryCodeName;
	}

	public void setCategoryCodeName(String categoryCodeName) {
		this.categoryCodeName = categoryCodeName;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
}
