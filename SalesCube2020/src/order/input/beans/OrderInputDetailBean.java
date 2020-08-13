package order.input.beans;

public class OrderInputDetailBean {

	/* 商品コード */
	private Integer productCode;
	
	/* 商品名 */
	private String productName;
	
	/* 商品備考 */
	private String productRemarks;
	
	/* 棚番 */
	private String rackCode;
	
	/* 数量 */
	private Integer quantity;
	
	/* 仕入単価 */
	private Integer unitCost;
	
	/* 仕入金額 */
	private Integer cost;
	
	/* 売上単価 */
	private Integer unitRetailPrice;
	
	/* 売価金額 */
	private Integer retailPrice;
	
	/* 備考 */
	private String inputProductRemarks;
	
	/* ピッキング備考 */
	private String eadRemarks;

	public Integer getProductCode() {
		return productCode;
	}

	public void setProductCode(Integer productCode) {
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Integer unitCost) {
		this.unitCost = unitCost;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getUnitRetailPrice() {
		return unitRetailPrice;
	}

	public void setUnitRetailPrice(Integer unitRetailPrice) {
		this.unitRetailPrice = unitRetailPrice;
	}

	public Integer getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(Integer retailPrice) {
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
	
}
