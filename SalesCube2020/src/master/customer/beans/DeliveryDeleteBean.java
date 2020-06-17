package master.customer.beans;

import java.util.Date;

/**
 * 納入先情報
 * 納入先情報削除に付随するサービスを提供する<br>
 * ・納入先コードを取得する<br>
 * ・削除日時を取得する<br>
 * ・削除者を取得する<br>
 * 
 * ・納入先コードを設定する<br>
 * ・削除日時を設定する<br>
 * ・削除者を設定する<br>
 * 
 * @author 久野
 * @version 1.0
 * 
 */

public class DeliveryDeleteBean {

	/** 納入先コード　：　納入先コードを保持する */
	private int deliveryCode;
	
	/** 削除日時 ：  削除日時を保存する */
	private Date delDate;
	
	/** 削除者 ： 削除者 を保存する */
	private String delUser;

	/**
	 * @return the deliveryCode
	 */
	public int getDeliveryCode() {
		return deliveryCode;
	}

	/**
	 * @param deliveryCode the deliveryCode to set
	 */
	public void setDeliveryCode(int deliveryCode) {
		this.deliveryCode = deliveryCode;
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
