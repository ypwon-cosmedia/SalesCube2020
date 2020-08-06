package order.search.beans;

public class OrderSearchBean {

	/* 検索対象 */
	private String selectView;
	
	/* 受注番号 */
	private String orderNo;
	
	/* 受付番号 */
	private String repNo;
	
	/* 受注日(開始) */
	private String orderDayStart;
	
	/* 受注日(終了) */
	private String orderDayEnd;
	
	/* 出荷日(開始) */
	private String shipDayStart;
	
	/* 出荷日(終了) */
	private String shipDayEnd;
	
	/* 納期指定日(開始) */
	private String deliveryDayStart;
	
	/* 納期指定日(終了) */
	private String deliveryDayEnd;
	
	/* 顧客コード  */
	private String customerCode;
	
	/* 顧客名 */
	private String customerName;
	
	/* 引出区分 */
	private String[] withdrawl;
	
	/* 商品コード */
	private String productCode;
	
	/* 商品名 */
	private String productName;
	
	/* 大分類コード */
	private String product1;
	
	/* 中分類コード */
	private String product2;
	
	/* 小分類コード */
	private String product3;
	
	/* 仕入先コード */
	private String supplierCode;
	
	/* 仕入先名 */
	private String supplierName;

	public String getSelectView() {
		return selectView;
	}
	public void setSelectView(String selectView) {
		this.selectView = selectView;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getRepNo() {
		return repNo;
	}
	public void setRepNo(String repNo) {
		this.repNo = repNo;
	}
	public String getOrderDayStart() {
		return orderDayStart;
	}
	public void setOrderDayStart(String orderDayStart) {
		this.orderDayStart = orderDayStart;
	}
	public String getOrderDayEnd() {
		return orderDayEnd;
	}
	public void setOrderDayEnd(String orderDayEnd) {
		this.orderDayEnd = orderDayEnd;
	}
	public String getShipDayStart() {
		return shipDayStart;
	}
	public void setShipDayStart(String shipDayStart) {
		this.shipDayStart = shipDayStart;
	}
	public String getShipDayEnd() {
		return shipDayEnd;
	}
	public void setShipDayEnd(String shipDayEnd) {
		this.shipDayEnd = shipDayEnd;
	}
	public String getDeliveryDayStart() {
		return deliveryDayStart;
	}
	public void setDeliveryDayStart(String deliveryDayStart) {
		this.deliveryDayStart = deliveryDayStart;
	}
	public String getDeliveryDayEnd() {
		return deliveryDayEnd;
	}
	public void setDeliveryDayEnd(String deliveryDayEnd) {
		this.deliveryDayEnd = deliveryDayEnd;
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
	public String[] getWithdrawl() {
		return withdrawl;
	}
	public void setWithdrawl(String[] withdrawl) {
		this.withdrawl = withdrawl;
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
	public String getProduct1() {
		return product1;
	}
	public void setProduct1(String product1) {
		this.product1 = product1;
	}
	public String getProduct2() {
		return product2;
	}
	public void setProduct2(String product2) {
		this.product2 = product2;
	}
	public String getProduct3() {
		return product3;
	}
	public void setProduct3(String product3) {
		this.product3 = product3;
	}
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
}
