package order.input.beans;

/** 
 * 
 * 作成日：2020/08/03
 * 作成者：宮本
 * 
 */

public class OrderInputBean {
	/* 受注番号 */
	private String roSlipId;

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
	
	/* 商品コード */
	private String productCode;
	
	/* 商品名 */
	private String productName;
	
	/* 商品備考 */
	private String productRemarks;
	
	/* 棚番 */
	private String rackCode;
	
	/* 数量 */
	private String quantity;
	
	/* 仕入単価 */
	private String unitCost;
	
	/* 仕入金額 */
	private String cost;
	
	/* 売上単価 */
	private String unitRetailPrice;
	
	/* 売価金額 */
	private String retailPrice;
	
	/* 備考 */
	private String inputProductRemarks;
	
	/* ピッキング備考 */
	private String eadRemarks;
	
	/* 粗利益 */
	private String prossProfit;
	
	/* 粗利益率 */
	private String grossProfitRatio;
	
	/* 金額合計 */
	private String retailPriceTotal;
	
	/* 消費税 */
	private String ctaxPriceTotal;
	
	/* 伝票合計 */
	private String priceTotal;
	
	/* 区分コード名 */
	private String categoryCodeName;
	
	/* 区分コード */
	private String categoryCode;

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryCodeName() {
		return categoryCodeName;
	}

	public void setCategoryCodeName(String categoryCodeName) {
		this.categoryCodeName = categoryCodeName;
	}

	public String getRoSlipId() {
		return roSlipId;
	}

	public void setRoSlipId(String roSlipId) {
		this.roSlipId = roSlipId;
	}

	public String getRoDate() {
		return roDate;
	}

	public void setRoDate(String roDate2) {
		this.roDate = roDate2;
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

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductRemarks() {
		return productRemarks;
	}

	public void setProductRemarks(String productRemarks) {
		this.productRemarks = productRemarks;
	}

	public String getRackCode() {
		return rackCode;
	}

	public void setRackCode(String rackCode) {
		this.rackCode = rackCode;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(String unitCost) {
		this.unitCost = unitCost;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getUnitRetailPrice() {
		return unitRetailPrice;
	}

	public void setUnitRetailPrice(String unitRetailPrice) {
		this.unitRetailPrice = unitRetailPrice;
	}

	public String getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(String retailPrice) {
		this.retailPrice = retailPrice;
	}

	public String getInputProductRemarks() {
		return inputProductRemarks;
	}

	public void setInputProductRemarks(String inputProductRemarks) {
		this.inputProductRemarks = inputProductRemarks;
	}

	public String getEadRemarks() {
		return eadRemarks;
	}

	public void setEadRemarks(String eadRemarks) {
		this.eadRemarks = eadRemarks;
	}

	public String getProssProfit() {
		return prossProfit;
	}

	public void setProssProfit(String prossProfit) {
		this.prossProfit = prossProfit;
	}

	public String getGrossProfitRatio() {
		return grossProfitRatio;
	}

	public void setGrossProfitRatio(String grossProfitRatio) {
		this.grossProfitRatio = grossProfitRatio;
	}

	public String getRetailPriceTotal() {
		return retailPriceTotal;
	}

	public void setRetailPriceTotal(String retailPriceTotal) {
		this.retailPriceTotal = retailPriceTotal;
	}

	public String getCtaxPriceTotal() {
		return ctaxPriceTotal;
	}

	public void setCtaxPriceTotal(String ctaxPriceTotal) {
		this.ctaxPriceTotal = ctaxPriceTotal;
	}

	public String getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(String priceTotal) {
		this.priceTotal = priceTotal;
	}
	
}
