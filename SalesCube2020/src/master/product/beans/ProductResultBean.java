package master.product.beans;

/**
 * ���i��\������<br>
 * �E���i�R�[�h���擾����<br>
 * �E���i�����擾����<br>
 * �E�d����R�[�h���擾����<br>
 * �E�d���於���擾����<br>
 * �E���i���ނP��ݒ肷��<br>
 * �E���l��ݒ肷��<br>
 * @author �{�{
 * @version 1.0
 */

public class ProductResultBean {
	/** ���i�R�[�h�F���i�R�[�h��ێ����� */
	private String productCode;
	
	/** ���i���F���i����ێ����� */
	private String productName;	
		
	/** �d���於�F�d���於��ێ����� */
	private String supplierName;
		
	/** ���i���ނP�F���i���ނP��ێ����� */
	private String product1;
		
	/** ���l�F���l��ێ����� */
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
