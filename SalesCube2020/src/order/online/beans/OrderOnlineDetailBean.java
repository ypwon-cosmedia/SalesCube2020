package order.online.beans;

public class OrderOnlineDetailBean {

	private String productCode;
	private String productAbstract;
	private Integer quantity;
	private Integer unitCost;
	private Integer cost;
	private Integer unitRetailCost;
	private Integer retailCost;
	private String remarks;
	private String eadRemarks;
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductAbstract() {
		return productAbstract;
	}
	public void setProductAbstract(String productAbstract) {
		this.productAbstract = productAbstract;
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
	public Integer getUnitRetailCost() {
		return unitRetailCost;
	}
	public void setUnitRetailCost(Integer unitRetailCost) {
		this.unitRetailCost = unitRetailCost;
	}
	public Integer getRetailCost() {
		return retailCost;
	}
	public void setRetailCost(Integer retailCost) {
		this.retailCost = retailCost;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getEadRemarks() {
		return eadRemarks;
	}
	public void setEadRemarks(String eadRemarks) {
		this.eadRemarks = eadRemarks;
	}
	
}
