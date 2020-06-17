package master.customer.beans.customerSearchBeans;
/**
 * 顧客情報
 * 顧客検索の情報入力に付随するサービスを提供する<br>
 * ・顧客コードを取得する<br>
 * ・顧客名を取得する<br>
 * ・顧客名カナを取得する<br>
 * ・事業所名を取得する<br>
 * ・事業所名カナを取得する<br>
 * ・TELを取得する<br>
 * ・FAXを取得する<br>
 * ・担当者を取得する<br>
 * ・担当者カナを取得する<br>
 * ・顧客ランクを取得する<br>
 * ・支払い条件を取得する<br>
 * ・振込名義を取得する<br>
 * ・備考を取得する<br>
 * 
 * ・顧客コードを設定する<br>
 * ・顧客名を設定する<br>
 * ・顧客名カナを設定する<br>
 * ・事業所名を設定する<br>
 * ・事業所名カナを設定する<br>
 * ・TELを設定する<br>
 * ・担当者を設定する<br>
 * ・担当者カナを設定する<br>
 * ・FAXを設定する<br>
 * ・顧客ランクを設定する<br>
 * ・支払い条件を設定する<br>
 * ・振込名義を設定する<br>
 * ・備考を設定する<br>
 * 
 * @author 久野
 * @version 1.0
 * 
 */

public class CustomerInputBean {

	/** 顧客コード  ： 顧客コードを保存する　 */
	private int customerCode;
	
	/** 顧客名 ：　顧客名を保存する */
	private String customerName;
	
	/** 顧客名カナ ： 顧客名カナを保存する */
	private String customerKana;
	
	/** 事業所名 ： 事業所名を保存する */
	private String officeName;

	/** 事業所名カナ： 事業所名カナを保存する */
	private String officeNameKana;
	
	/** TEL ：  TELを保存する */
	private String tel;

	/** 担当者 ： 担当者を保存する */
	private String PCName;

	/** 担当者カナ ： 担当者カナを保存する */
	private String PCNameKana;

	/** FAX ： FAX を保存する */
	private String fax;

	/** 顧客ランク ：  顧客ランクを保存する */
	private String rankCategory;

	/** 支払い条件 ： 支払い条件を保存する */
	private String paybackCycleCategory;

	/** 振込名義 ： 振込名義を保存する */
	private String paymentName;
	
	/** 備考 ：  備考を保存する */
	private String remarks;

	
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
	 * @return the officeNameKana
	 */
	public String getOfficeNameKana() {
		return officeNameKana;
	}

	/**
	 * @param officeNameKana the officeNameKana to set
	 */
	public void setOfficeNameKana(String officeNameKana) {
		this.officeNameKana = officeNameKana;
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
	 * @return the pCNameKana
	 */
	public String getPCNameKana() {
		return PCNameKana;
	}

	/**
	 * @param pCNameKana the pCNameKana to set
	 */
	public void setPCNameKana(String pCNameKana) {
		PCNameKana = pCNameKana;
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
	 * @return the rankCategory
	 */
	public String getRankCategory() {
		return rankCategory;
	}

	/**
	 * @param rankCategory the rankCategory to set
	 */
	public void setRankCategory(String rankCategory) {
		this.rankCategory = rankCategory;
	}

	/**
	 * @return the paybackCycleCategory
	 */
	public String getPaybackCycleCategory() {
		return paybackCycleCategory;
	}

	/**
	 * @param paybackCycleCategory the paybackCycleCategory to set
	 */
	public void setPaybackCycleCategory(String paybackCycleCategory) {
		this.paybackCycleCategory = paybackCycleCategory;
	}

	/**
	 * @return the paymentName
	 */
	public String getPaymentName() {
		return paymentName;
	}

	/**
	 * @param paymentName the paymentName to set
	 */
	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


}

