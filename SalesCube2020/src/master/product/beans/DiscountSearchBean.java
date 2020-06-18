package master.product.beans;

public class DiscountSearchBean {
	
	//表示行数
	private int lineNo;
	
	//範囲From
	private int dataFrom;
	
	//範囲To
	private int dataTo;
	
	//割引率
	private int discountRate;
	
	//割引コード
	private String discountId;
	
	//割引名
	private String discountName;
	
	//割引有効フラグ
	private String useFlag;

	
	public int getLineNo() {
		return lineNo;
	}

	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}

	public int getDataFrom() {
		return dataFrom;
	}

	public void setDataFrom(int dataFrom) {
		this.dataFrom = dataFrom;
	}

	public int getDataTo() {
		return dataTo;
	}

	public void setDataTo(int dataTo) {
		this.dataTo = dataTo;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

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
