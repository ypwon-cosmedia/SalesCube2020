package master.product.beans;

/**
 * 商品を表示する<br>
 * ・商品コードを取得する<br>
 * ・商品名を取得する<br>
 * ・仕入先コードを取得する<br>
 * ・仕入先名を取得する<br>
 * ・商品分類１を設定する<br>
 * ・備考を設定する<br>
 * @author 宮本
 * @version 1.0
 */

public class ProductResultBean {
	/** 商品コード：商品コードを保持する */
	private String productCode;
	
	/** 商品名：商品名を保持する */
	private String productName;	
		
	/** 仕入先名：仕入先名を保持する */
	private String supplierName;
		
	/** 商品分類１：商品分類１を保持する */
	private String product1;
		
	/** 備考：備考を保持する */
	private String remarks;

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

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getProduct1() {
		return product1;
	}

	public void setProduct1(String product1) {
		this.product1 = product1;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
