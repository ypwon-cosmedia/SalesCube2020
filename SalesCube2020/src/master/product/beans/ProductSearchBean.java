package master.product.beans;

/**
 * ���i��\������<br>
 * �E���i�R�[�h���擾����<br>
 * �E���i�����擾����<br>
 * �E���i���J�i���擾����<br>
 * �E�d����R�[�h���擾����<br>
 * �E�d���於���擾����<br>
 * �E���ޏ󋵂�ݒ肷��<br>
 * �E���ޕۊǂ�ݒ肷��<br>
 * �E���i���ނP��ݒ肷��<br>
 * �E���i���ނQ��ݒ肷��<br>
 * �E���i���ނR���擾����<br>
 * �E���l��ݒ肷��<br>
 * 
 * @author �{�{
 * @version 1.0
 */

public class ProductSearchBean {

	/** ���i�R�[�h�F���i�R�[�h��ێ����� */
	private String productCode;
	
	/** ���i���F���i����ێ����� */
	private String productName;	
		
	/** ���i���J�i�F���i���J�i��ێ����� */
	private String productKana;
		
	/** �d����R�[�h�F�d����R�[�h��ێ����� */
	private String supplierCode;
		
	/** �d���於�F�d���於��ێ����� */
	private String supplierName;
	
	/** ���ޕW���F���ޕW����ێ����� */
	private String productStandardCategory;
	
	/** ���ޏ󋵁F���ޏ󋵂�ێ����� */
	private String productStatusCategory;
		
	/** ���ޕۊǁF���ޕۊǂ�ێ����� */
	private String productStockCategory;
	
	/** �Z�b�g���i�t���O�F�Z�b�g���i�t���O��ێ����� */
	private String setTypeCategory;
	
	/** ���l�F���l��ێ����� */
	private String remarks;	
	
	/** ���i���ނP�F���i���ނP��ێ����� */
	private String product1;
	
	/** ���i���ނQ�F���i���ނQ��ێ����� */
	private String product2;
		
	/** ���i���ނR�F���i���ނR��ێ����� */
	private String product3;
	
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
	
	public String getProductKana() {
		return productKana;
	}
	
	public void setProductKana(String productKana) {
		this.productKana = productKana;
	}
	
	public String getSupplierCode() {
		return supplierCode;
	}
	
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	
	public String getSupplierName() {
		return supplierName;
	}
	
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public String getProductStatusCategory() {
		return productStatusCategory;
	}
	
	public void setProductStatusCategory(String productStatusCategory) {
		this.productStatusCategory = productStatusCategory;
	}
	
	public String getProductStockCategory() {
		return productStockCategory;
	}
	
	public void setProductStockCategory(String productStockCategory) {
		this.productStockCategory = productStockCategory;
	}
	
	public String getProduct1() {
		return product1;
	}
	
	public void setProduct1(String product1) {
		this.product1 = product1;
	}
	
	public String getProduct2() {
		return product2;
	}
	
	public void setProduct2(String product2) {
		this.product2 = product2;
	}

	public String getProduct3() {
		return product3;
	}
	
	public void setProduct3(String product3) {
		this.product3 = product3;
	}

	public String getProductStandardCategory() {
		return productStandardCategory;
	}

	public void setProductStandardCategory(String productStandardCategory) {
		this.productStandardCategory = productStandardCategory;
	}

	public String getSetTypeCategory() {
		return setTypeCategory;
	}

	public void setSetTypeCategory(String setTypeCategory) {
		this.setTypeCategory = setTypeCategory;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
