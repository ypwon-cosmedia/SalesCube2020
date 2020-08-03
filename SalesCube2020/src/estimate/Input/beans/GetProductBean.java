/**
 * 
 */
package estimate.Input.beans;

/**
 * @author cosmedia
 *
 */
public class GetProductBean {
	/** 商品コード */
	private String productCode;

	/** 商品名・摘要 */
	private String productAbstract;
	
	/** 仕入単価 */
	private int unitCost;
	
	/** 売価単価 */
	private int unitRetailPrice;

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

}
