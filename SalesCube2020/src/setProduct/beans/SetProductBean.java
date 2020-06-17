package setProduct.beans;

/*
 * セット商品に関した情報を保存するBeanクラスです。
 */

public class SetProductBean {
	
	/*商品コードを保存するメンバー変数*/
	private String setProductCode;
	
	/*商品の中の商品コードを保存するメンバー変数」*/
	private String productCode;
	
	/*商品の数量を保存するメンバー変数*/
	private int quantity;
	
	
	public String getSetProductCode() {
		return setProductCode;
	}
	public void setSetProductCode(String setProductCode) {
		this.setProductCode = setProductCode;
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
}
