/**
 * 
 */
package estimate.Input.beans;

/**
 * @author cosmedia
 *
 */
public class EstimateProductAddBean {
	/** No */
	private Integer lineNo;
	
	/** 商品コード */
	private String productCode;

	/** 商品名・摘要 */
	private String productAbstract;
	
	/** 数量 */
	private Integer quantity;
	
	/** 仕入単価 */
	private Integer unitCost;
	
	/** 仕入金額 */
	private Integer cost;
	
	/** 売価単価 */
	private Integer unitRetailPrice;
	
	/** 売上金額 */
	private Integer retailPrice;
	
	/** 備考 */
	private String productRemarks;
	
	/** 作成日時 */
	private String creDate;
	
	/** 作成者 */
	private String creUser;

	/**
	 * @return the lineNo
	 */
	public Integer getLineNo() {
		return lineNo;
	}

	/**
	 * @param lineNo the lineNo to set
	 */
	public void setLineNo(Integer lineNo) {
		this.lineNo = lineNo;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the productAbstract
	 */
	public String getProductAbstract() {
		return productAbstract;
	}

	/**
	 * @param productAbstract the productAbstract to set
	 */
	public void setProductAbstract(String productAbstract) {
		this.productAbstract = productAbstract;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the unitCost
	 */
	public Integer getUnitCost() {
		return unitCost;
	}

	/**
	 * @param unitCost the unitCost to set
	 */
	public void setUnitCost(Integer unitCost) {
		this.unitCost = unitCost;
	}

	/**
	 * @return the cost
	 */
	public Integer getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(Integer cost) {
		this.cost = cost;
	}

	/**
	 * @return the unitRetailPrice
	 */
	public Integer getUnitRetailPrice() {
		return unitRetailPrice;
	}

	/**
	 * @param unitRetailPrice the unitRetailPrice to set
	 */
	public void setUnitRetailPrice(int unitRetailPrice) {
		this.unitRetailPrice = unitRetailPrice;
	}

	/**
	 * @return the retailPrice
	 */
	public Integer getRetailPrice() {
		return retailPrice;
	}

	/**
	 * @param retailPrice the retailPrice to set
	 */
	public void setRetailPrice(Integer retailPrice) {
		this.retailPrice = retailPrice;
	}

	/**
	 * @return the productRemarks
	 */
	public String getProductRemarks() {
		return productRemarks;
	}

	/**
	 * @param productRemarks the productRemarks to set
	 */
	public void setProductRemarks(String productRemarks) {
		this.productRemarks = productRemarks;
	}

	/**
	 * @return the creDateTM
	 */
	public String getCreDate() {
		return creDate;
	}

	/**
	 * @param creDateTM the creDateTM to set
	 */
	public void setCreDate(String creDate) {
		this.creDate = creDate;
	}

	/**
	 * @return the creUser
	 */
	public String getCreUser() {
		return creUser;
	}

	/**
	 * @param creUser the creUser to set
	 */
	public void setCreUser(String creUser) {
		this.creUser = creUser;
	}

}
