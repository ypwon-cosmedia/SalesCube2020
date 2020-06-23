package master.product.beans;

/**
 * 商品を表示する<br>
 * ・商品コードを取得する<br>
 * ・商品名を取得する<br>
 * ・商品名カナを取得する<br>
 * ・仕入先コードを取得する<br>
 * ・仕入先名を取得する<br>
 * ・分類状況を設定する<br>
 * ・分類保管を設定する<br>
 * ・商品分類１を設定する<br>
 * ・商品分類２を設定する<br>
 * ・商品分類３を取得する<br>
 * ・備考を設定する<br>
 * 
 * @author 宮本
 * @version 1.0
 */

public class ProductSearchBean {

	/** 商品コード：商品コードを保持する */
	private String productCode;
	
	/** 商品名：商品名を保持する */
	private String productName;	
		
	/** 商品名カナ：商品名カナを保持する */
	private String productKana;
		
	/** 仕入先コード：仕入先コードを保持する */
	private String supplierCode;
		
	/** 仕入先名：仕入先名を保持する */
	private String supplierName;
	
	/** 分類標準：分類標準を保持する */
	private String productStandardCategory;
	
	/** 分類状況：分類状況を保持する */
	private String productStatusCategory;
		
	/** 分類保管：分類保管を保持する */
	private String productStockCategory;
	
	/** セット商品フラグ：セット商品フラグを保持する */
	private String setTypeCategory;
	
	/** 備考：備考を保持する */
	private String remarks;	
	
	/** 商品分類１：商品分類１を保持する */
	private String product1;
	
	/** 商品分類２：商品分類２を保持する */
	private String product2;
		
	/** 商品分類３：商品分類３を保持する */
	private String product3;
	
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
	
	public String getProductKana() {
		return productKana;
	}
	
	public void setProductKana(String productKana) {
		this.productKana = productKana;
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

	public String getProductStandardCategory() {
		return productStandardCategory;
	}

	public void setProductStandardCategory(String productStandardCategory) {
		this.productStandardCategory = productStandardCategory;
	}

	public String getSetTypeCategory() {
		return setTypeCategory;
	}

	public void setSetTypeCategory(String setTypeCategory) {
		this.setTypeCategory = setTypeCategory;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
