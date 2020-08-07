package common.modal.stock.beans;

public class StockBean {

	/* 商品コード */
	private String productCode;
	
	/* 仕入先商品コード */
	private String supplierPCode;
	
	/* セット分類 */
	private String setTypeCategory;
	
	/* 商品名 */
	private String productName;
	
	/* 倉庫名 */
	private String warehouseName;
	
	/* 棚番 */
	private String rackCode;
	
	/* 分類状態 */
	private String productStatusCategory;
	
	/* 分類保管 */
	private String productStockCategory;
	
	/* 現在庫総数 */
	private String stockQuantity;
	
	/* 受注残数 */
	private String quantity;
	
	/* 受注番号 */
	private String roSlipId;
	
	/* 受注行 */
	private String roLineId;
	
	/* 出荷日 */
	private String shipDate;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getSupplierPCode() {
		return supplierPCode;
	}

	public void setSupplierPCode(String supplierPCode) {
		this.supplierPCode = supplierPCode;
	}

	public String getSetTypeCategory() {
		return setTypeCategory;
	}

	public void setSetTypeCategory(String setTypeCategory) {
		this.setTypeCategory = setTypeCategory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getRackCode() {
		return rackCode;
	}

	public void setRackCode(String rackCode) {
		this.rackCode = rackCode;
	}

	public String getProductStatusCategory() {
		return productStatusCategory;
	}

	public void setProductStatusCategory(String productStatusCategory) {
		this.productStatusCategory = productStatusCategory;
	}

	public String getProductStockCategory() {
		return productStockCategory;
	}

	public void setProductStockCategory(String productStockCategory) {
		this.productStockCategory = productStockCategory;
	}

	public String getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(String stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getRoSlipId() {
		return roSlipId;
	}

	public void setRoSlipId(String roSlipId) {
		this.roSlipId = roSlipId;
	}

	public String getRoLineId() {
		return roLineId;
	}

	public void setRoLineId(String roLineId) {
		this.roLineId = roLineId;
	}

	public String getShipDate() {
		return shipDate;
	}

	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
	
	
}
