package master.product.beans;

public class QuantityDiscountBean {
//��������
	//�����R�[�h
	private String discountId;
	
	//�����L���t���O
	private String useFlag;
	
	//������
	private String discountName;
	
	//���l
	private String remarks;
//���������͂����܂�
	
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

	
	
