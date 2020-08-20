package order.online.beans;

public class OrderOnlineDetailBean {

	private int roSlipId;
	private String productCode;
	private int quantity;
	private int unitRetailPrice;
	private int unitCost;
	private int ctaxRate;
	
	public int getRoSlipId() {
		return roSlipId;
	}
	public void setRoSlipId(int roSlipId) {
		this.roSlipId = roSlipId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUnitRetailPrice() {
		return unitRetailPrice;
	}
	public void setUnitRetailPrice(int unitRetailPrice) {
		this.unitRetailPrice = unitRetailPrice;
	}
	public int getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
	}
	public int getCtaxRate() {
		return ctaxRate;
	}
	public void setCtaxRate(int ctaxRate) {
		this.ctaxRate = ctaxRate;
	}
	
}
