/**
 * 
 */
package estimate.Input.beans;

/**
 * @author cosmedia
 *
 */
public class GetCustomerBean {
	/** 顧客コード */
	private String customerCode;

	/** 顧客名 */
	private String customerName;
	
	/** 備考 */
	private String customerRemarks;
	
	/** コメント */
	private String customerComment;

	/**
	 * @return the customerCode
	 */
	public String getCustomerCode() {
		return customerCode;
	}

	/**
	 * @param customerCode the customerCode to set
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerRemarks
	 */
	public String getCustomerRemarks() {
		return customerRemarks;
	}

	/**
	 * @param customerRemarks the customerRemarks to set
	 */
	public void setCustomerRemarks(String customerRemarks) {
		this.customerRemarks = customerRemarks;
	}

	/**
	 * @return the customerComment
	 */
	public String getCustomerComment() {
		return customerComment;
	}

	/**
	 * @param customerComment the customerComment to set
	 */
	public void setCustomerComment(String customerComment) {
		this.customerComment = customerComment;
	}
}
