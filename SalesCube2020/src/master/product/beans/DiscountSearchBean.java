package master.product.beans;

public class DiscountSearchBean {
	

	
	//割引コード
	private String discountId;
	
	//割引名
	private String discountName;
	
	//割引有効フラグ
	private String useFlag;

	

	public String getDiscountId() {
		return discountId;
	}

	public void setDiscountId(String discountId) {
		this.discountId = discountId;
	}

	public String getDiscountName() {
		return discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public String getUseFlag() {
		return useFlag;
	}

	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}
	
	
}
