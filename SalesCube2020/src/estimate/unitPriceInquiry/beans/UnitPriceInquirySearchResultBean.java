/**
 * 
 */
package estimate.unitPriceInquiry.beans;

/**
 * @author cosmedia
 *
 */
public class UnitPriceInquirySearchResultBean {
	/** 商品コード */
	private String productCode;
	
	/** 商品名 */
	private String productName;

	/** 売単価 */
	private String retailPrice;
	
	/** 備考(商品) */
	private String productRemarks;

	/** 割引コード */
	private String discountId;
	
	/** 割引名 */
	private String discountName;

	/** 備考(割引) */
	private String discountRemarks;
	
	/** 仕入先商品コード */
	private String supplierPCode;

	/** セット分類 */
	private String setTypeCategory;
	
	/** 倉庫名 */
	private String warehouseName;

	/** 棚番 */
	private String rackCode;
	
	/** 分類-状態 */
	private String productStatus;

	/** 分類-保管 */
	private String productStock;
	
	/** 現在在庫数 */
	private String stockQuantity;

	/** 受注残数 */
	private String quantityTotal;

	
	/**
	 * @return the productName
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the retailPrice
	 */
	public String getRetailPrice() {
		return retailPrice;
	}

	/**
	 * @param retailPrice the retailPrice to set
	 */
	public void setRetailPrice(String retailPrice) {
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
	 * @return the discountId
	 */
	public String getDiscountId() {
		return discountId;
	}

	/**
	 * @param discountId the discountId to set
	 */
	public void setDiscountId(String discountId) {
		this.discountId = discountId;
	}

	/**
	 * @return the discountName
	 */
	public String getDiscountName() {
		return discountName;
	}

	/**
	 * @param discountName the discountName to set
	 */
	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	/**
	 * @return the discountRemarks
	 */
	public String getDiscountRemarks() {
		return discountRemarks;
	}

	/**
	 * @param discountRemarks the discountRemarks to set
	 */
	public void setDiscountRemarks(String discountRemarks) {
		this.discountRemarks = discountRemarks;
	}

	/**
	 * @return the supplierPCode
	 */
	public String getSupplierPCode() {
		return supplierPCode;
	}

	/**
	 * @param supplierPCode the supplierPCode to set
	 */
	public void setSupplierPCode(String supplierPCode) {
		this.supplierPCode = supplierPCode;
	}

	/**
	 * @return the setTypeCategory
	 */
	public String getSetTypeCategory() {
		return setTypeCategory;
	}

	/**
	 * @param setTypeCategory the setTypeCategory to set
	 */
	public void setSetTypeCategory(String setTypeCategory) {
		this.setTypeCategory = setTypeCategory;
	}

	/**
	 * @return the warehouseName
	 */
	public String getWarehouseName() {
		return warehouseName;
	}

	/**
	 * @param warehouseName the warehouseName to set
	 */
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	/**
	 * @return the rackCode
	 */
	public String getRackCode() {
		return rackCode;
	}

	/**
	 * @param rackCode the rackCode to set
	 */
	public void setRackCode(String rackCode) {
		this.rackCode = rackCode;
	}

	/**
	 * @return the productStatus
	 */
	public String getProductStatus() {
		return productStatus;
	}

	/**
	 * @param productStatus the productStatus to set
	 */
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	/**
	 * @return the productStock
	 */
	public String getProductStock() {
		return productStock;
	}

	/**
	 * @param productStock the productStock to set
	 */
	public void setProductStock(String productStock) {
		this.productStock = productStock;
	}

	/**
	 * @return the stockQuantity
	 */
	public String getStockQuantity() {
		return stockQuantity;
	}

	/**
	 * @param stockQuantity the stockQuantity to set
	 */
	public void setStockQuantity(String stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	/**
	 * @return the quantityTotal
	 */
	public String getQuantityTotal() {
		return quantityTotal;
	}

	/**
	 * @param quantityTotal the quantityTotal to set
	 */
	public void setQuantityTotal(String quantityTotal) {
		this.quantityTotal = quantityTotal;
	}

}
