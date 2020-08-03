package common.modal.customer.beans;

public class CustomerSearchBean {
	
	//顧客コード
	private String customerCode;
	
	//顧客名
	private String customerName;
	
	//顧客カナ
	private String customerKana;
	
	//支払条件
	private String cutoffGroup;

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
	 * @return the customerKana
	 */
	public String getCustomerKana() {
		return customerKana;
	}

	/**
	 * @param customerKana the customerKana to set
	 */
	public void setCustomerKana(String customerKana) {
		this.customerKana = customerKana;
	}

	/**
	 * @return the cutoffGroup
	 */
	public String getCutoffGroup() {
		return cutoffGroup;
	}

	/**
	 * @param cutoffGroup the cutoffGroup to set
	 */
	public void setCutoffGroup(String cutoffGroup) {
		this.cutoffGroup = cutoffGroup;
	}

}
