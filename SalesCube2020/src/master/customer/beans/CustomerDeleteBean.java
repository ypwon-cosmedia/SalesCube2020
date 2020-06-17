package master.customer.beans;
/**
 * 顧客情報
 * 顧客削除に付随するサービスを提供する<br>
 * 顧客コードを取得する<br>
 *
 * @author 久野
 * @version 1.0
 * 
 */
public class CustomerDeleteBean {

	/** 顧客コード  ： 顧客コードを保存する　 */
	private String customerCode;
	
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
}
