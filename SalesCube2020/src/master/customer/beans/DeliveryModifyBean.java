package master.customer.beans;

import java.util.Date;

/**
 * 納入先情報
 * 納入先情報変更に付随するサービスを提供する<br>
 * ・納入先コードを取得する<br>
 * ・納入先名を取得する<br>
 * ・納入先名カナを取得する<br> 
 * ・事業所名を取得する<br>
 * ・事業所名カナを取得する<br>
 * ・部署名を取得する<br>
 * ・住所1を取得する<br>
 * ・住所2を取得する<br>
 * ・担当者を取得する<br>
 * ・担当者カナを取得する<br>
 * ・敬称を取得する<br>
 * ・TELを取得する<br>
 * ・FAXを取得する<br>
 * ・E-MAILを取得する<br>
 * ・FAXを取得する<br>
 * ・更新日時を取得する<br>
 * ・更新者を取得する<br>
 * 
 * ・納入先コードを設定する<br>
 * ・納入先名を設定する<br>
 * ・納入先名カナを設定する<br> 
 * ・事業所名を設定する<br>
 * ・事業所名カナを設定する<br>
 * ・部署名を設定する<br>
 * ・住所1を設定する<br>
 * ・住所2を設定する<br>
 * ・担当者を設定する<br>
 * ・担当者カナを設定する<br>
 * ・敬称を設定する<br>
 * ・TELを設定する<br>
 * ・FAXを設定する<br>
 * ・E-MAIL設定する<br>
 * ・FAXを設定する<br>
 * ・更新日時を設定する<br>
 * ・更新者を設定する<br>
 * 
 * @author 久野
 * @version 1.0
 * 
 */

public class DeliveryModifyBean {

	/** 納入先コード　：　納入先コードを保持する */
	private int deliveryCode;

	/** 納入先名　：　納入先名を保持する */
	private String deliveryName;

	/** 納入先名カナ　：　納入先名カナを保持する */
	private String deliveryKana;

	/** 事業所名　：　事業所名を保持する */
	private String officeName;

	/** 事業所名カナ　：　事業所名カナを保持する */
	private String officeKana;
	
	/** 部署名 ：　部署名を保持する */
	private String deptName;

	/** 郵便番号 ：　郵便番号を保持する */
	private int zipCode;
	
	/** 住所1 ：　住所1を保持する */
	private String address1;
	
	/** 住所2 ：　住所2を保持する */
	private String address2;
	
	/** 担当者 ：　担当者を保持する */
	private String PCName;
	
	/** 担当者カナ ：　担当者カナを保持する */
	private String PCKana;
	
	/** 敬称 ：　敬称を保持する */
	private String PCPreCategory;
	
	/** TEL ：　TELを保持する */
	private String tel;
	
	/** FAX ：　FAXを保持する */
	private String fax;
	
	/** E-MAIL ：　E-MAILを保持する */
	private String email;
	
	/** 更新日時 ： 更新日時 を保存する */
	private Date updDate;
	
	/** 更新者 ： 更新者を保存する */
	private String updUser;

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
	 * @return the deliveryName
	 */
	public String getDeliveryName() {
		return deliveryName;
	}

	/**
	 * @param deliveryName the deliveryName to set
	 */
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	/**
	 * @return the deliveryKana
	 */
	public String getDeliveryKana() {
		return deliveryKana;
	}

	/**
	 * @param deliveryKana the deliveryKana to set
	 */
	public void setDeliveryKana(String deliveryKana) {
		this.deliveryKana = deliveryKana;
	}

	/**
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * @return the officeKana
	 */
	public String getOfficeKana() {
		return officeKana;
	}

	/**
	 * @param officeKana the officeKana to set
	 */
	public void setOfficeKana(String officeKana) {
		this.officeKana = officeKana;
	}

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @return the zipCode
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @return the pCName
	 */
	public String getPCName() {
		return PCName;
	}

	/**
	 * @param pCName the pCName to set
	 */
	public void setPCName(String pCName) {
		PCName = pCName;
	}

	/**
	 * @return the pCKana
	 */
	public String getPCKana() {
		return PCKana;
	}

	/**
	 * @param pCKana the pCKana to set
	 */
	public void setPCKana(String pCKana) {
		PCKana = pCKana;
	}

	/**
	 * @return the pCPreCategory
	 */
	public String getPCPreCategory() {
		return PCPreCategory;
	}

	/**
	 * @param pCPreCategory the pCPreCategory to set
	 */
	public void setPCPreCategory(String pCPreCategory) {
		PCPreCategory = pCPreCategory;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the updDate
	 */
	public Date getUpdDate() {
		return updDate;
	}

	/**
	 * @param updDate the updDate to set
	 */
	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	/**
	 * @return the updUser
	 */
	public String getUpdUser() {
		return updUser;
	}

	/**
	 * @param updUser the updUser to set
	 */
	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}
}
