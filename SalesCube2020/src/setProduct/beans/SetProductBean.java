package setProduct.beans;

/*
 * �Z�b�g���i�Ɋւ�������ۑ�����Bean�N���X�ł��B
 */

public class SetProductBean {
	
	/*���i�R�[�h��ۑ����郁���o�[�ϐ�*/
	private String setProductCode;
	
	/*���i�̒��̏��i�R�[�h��ۑ����郁���o�[�ϐ��v*/
	private String productCode;
	
	/*���i�̐��ʂ�ۑ����郁���o�[�ϐ�*/
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
