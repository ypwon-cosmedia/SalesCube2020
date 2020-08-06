package common.modal.supplier.beans;

public class SupplierSearchResultBean {
	//仕入れ先検索結果
	
	//仕入れ先コード
	private String supplierCode;
	//仕入れ先名
	private String supplierName;
	//仕入れ先担当者
	private String supplierPCName;
	//区分データ名(取引先区分)
	private String categoryCodeName;
	//備考
	private String remarks;
	
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
	public String getSupplierPCName() {
		return supplierPCName;
	}
	public void setSupplierPCName(String supplierPCName) {
		this.supplierPCName = supplierPCName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCategoryCodeName() {
		return categoryCodeName;
	}
	public void setCategoryCodeName(String categoryCodeName) {
		this.categoryCodeName = categoryCodeName;
	}
	

}
