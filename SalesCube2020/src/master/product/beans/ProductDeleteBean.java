package master.product.beans;

/**
 * 商品を削除する<br>
 * ・商品コードを取得する<br>
　* 
 * @author 物応
 * @version 1.0
 */

public class ProductDeleteBean {
	/** 商品コード：商品コードを保持する */
	private String productCode;

	
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


}
