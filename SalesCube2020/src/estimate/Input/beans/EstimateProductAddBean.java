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
	private int lineNo;
	
	/** 商品コード */
	private String productCode;

	/** 商品名・摘要 */
	private String productAbstract;
	
	/** 数量 */
	private int quantity;
	
	/** 仕入単価 */
	private int unitCost;
	
	/** 仕入金額 */
	private int cost;
	
	/** 売価単価 */
	private int unitRetailPrice;
	
	/** 売上金額 */
	private int retailPrice;
	
	/** 備考 */
	private String productRemarks;
	
	/** 作成日時 */
	private String creDateTM;
	
	/** 作成者 */
	private String creUser;

	/**
	 * @return the lineNo
	 */
	public int getLineNo() {
		return lineNo;
	}

	/**
	 * @param lineNo the lineNo to set
	 */
	public void setLineNo(int lineNo) {
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
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the unitCost
	 */
	public int getUnitCost() {
		return unitCost;
	}

	/**
	 * @param unitCost the unitCost to set
	 */
	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
	}

	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * @return the unitRetailPrice
	 */
	public int getUnitRetailPrice() {
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
	public int getRetailPrice() {
		return retailPrice;
	}

	/**
	 * @param retailPrice the retailPrice to set
	 */
	public void setRetailPrice(int retailPrice) {
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
	public String getCreDateTM() {
		return creDateTM;
	}

	/**
	 * @param creDateTM the creDateTM to set
	 */
	public void setCreDateTM(String creDateTM) {
		this.creDateTM = creDateTM;
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
