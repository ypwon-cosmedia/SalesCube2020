package master.product.beans;

public class DiscountDetailBean {
	//�����R�[�h
	private String discountId;
	
	//�\���s��
	private int lineNo;
	
	//�͈�From
	private int dataFrom;
	
	//�͈�To
	private int dataTo;
	
	//������
	private int discountRate;
	
	
	public String getDiscountId() {
		return discountId;
	}

	public void setDiscountId(String discountId) {
		this.discountId = discountId;
	}

	
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


}
