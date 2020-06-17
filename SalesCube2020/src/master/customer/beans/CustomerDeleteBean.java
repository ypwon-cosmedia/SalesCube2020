package master.customer.beans;

import java.util.Date;

/**
 * 顧客情報
 * 顧客削除に付随するサービスを提供する<br>
 * ・顧客コードを取得する<br>
 * ・削除日時を取得する<br>
 * ・削除者を取得する<br>
 * ・顧客コードを設定する<br>
 * ・削除日時を設定する<br>
 * ・削除者を設定する<br>
 *
 * @author 久野
 * @version 1.0
 * 
 */
public class CustomerDeleteBean {

	/** 顧客コード  ： 顧客コードを保存する　 */
	private int customerCode;
	
	/** 削除日時 ：  削除日時を保存する */
	private Date delDate;
	
	/** 削除者 ： 削除者 を保存する */
	private String delUser;
	
	/**
	 * @return the customerCode
	 */
	public int getCustomerCode() {
		return customerCode;
	}

	/**
	 * @param customerCode the customerCode to set
	 */
	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	
	/**
	 * @return the delDate
	 */
	public Date getDelDate() {
		return delDate;
	}

	/**
	 * @param delDate the delDate to set
	 */
	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}

	/**
	 * @return the delUser
	 */
	public String getDelUser() {
		return delUser;
	}

	/**
	 * @param delUser the delUser to set
	 */
	public void setDelUser(String delUser) {
		this.delUser = delUser;
	}
}
