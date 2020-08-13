package order.input.beans;

public class OrderInputCustomerBean {

	/* 顧客コード */
	private String customerCode;
	
	/* 顧客名 */
	private String customerName;
	
	/* 税転嫁 */
	private String taxShiftCategory;
	
	/* 支払条件 */
	private String cutoffGroup;
	
	/* 取引区分 */
	private String salesCmCategory;
	
	/* 備考 */
	private String customerRemarks;
	
	/* コメント */
	private String customerCommentData;

	/* 区分コード名 */
	private String categoryCodeName;
	
	/* 区分コード */
	private String categoryCode;
	
	public String getCategoryCodeName() {
		return categoryCodeName;
	}

	public void setCategoryCodeName(String categoryCodeName) {
		this.categoryCodeName = categoryCodeName;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getTaxShiftCategory() {
		return taxShiftCategory;
	}

	public void setTaxShiftCategory(String taxShiftCategory) {
		this.taxShiftCategory = taxShiftCategory;
	}

	public String getCutoffGroup() {
		return cutoffGroup;
	}

	public void setCutoffGroup(String cutoffGroup) {
		this.cutoffGroup = cutoffGroup;
	}

	public String getSalesCmCategory() {
		return salesCmCategory;
	}

	public void setSalesCmCategory(String salesCmCategory) {
		this.salesCmCategory = salesCmCategory;
	}

	public String getCustomerRemarks() {
		return customerRemarks;
	}

	public void setCustomerRemarks(String customerRemarks) {
		this.customerRemarks = customerRemarks;
	}

	public String getCustomerCommentData() {
		return customerCommentData;
	}

	public void setCustomerCommentData(String customerCommentData) {
		this.customerCommentData = customerCommentData;
	}
	
}
