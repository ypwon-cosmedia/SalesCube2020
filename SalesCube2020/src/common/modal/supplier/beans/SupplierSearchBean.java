package common.modal.supplier.beans;

public class SupplierSearchBean {
	//検索条件
	
	//仕入れ先コード
	private String supplierCode;
	//仕入れ先名
	private String supplierName;
	//仕入れ先カナ
	private String supplierKana;
	
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
	public String getSupplierKana() {
		return supplierKana;
	}
	public void setSupplierKana(String supplierKana) {
		this.supplierKana = supplierKana;
	}

}
