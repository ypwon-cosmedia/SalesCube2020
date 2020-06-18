package master.product.beans;

public class QuantityDiscountBean {
	
	//割引コード
	private String discountId;
	
	//割引有効フラグ
	private String useFlag;
	
	//割引名
	private String discountName;
	
	//備考
	private String remarks;
	
	
	public String getDiscountId() {
		return discountId;
	}
	
	public void setDiscountId(String discountId) {
		this.discountId = discountId;
	
	}
	
	public String getUseFlag() {
		return useFlag;
	}
	
	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;	
	}
	
	public String getDiscountName() {
		return discountName;
	}
	
	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}
	
	public String getRemarks() {
		return remarks;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
	
	
	
