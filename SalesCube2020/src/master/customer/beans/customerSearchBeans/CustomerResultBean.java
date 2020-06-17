package master.customer.beans.customerSearchBeans;
/**
 * 顧客情報
 * 顧客検索の検索結果に付随するサービスを提供する<br>
 * ・顧客コードを取得する<br>
 * ・顧客名を取得する<br>
 * ・TELを取得する<br>
 * ・担当者を取得する<br>
 * ・取引区分を取得する<br>
 * ・支払い条件を取得する<br>
 * ・事業所名を設定する<br>
 * ・部署名を取得する<br>
 * 
 * ・顧客コードを設定する<br>
 * ・顧客名を設定する<br>
 * ・TELを設定する<br>
 * ・担当者を設定する<br>
 * ・取引区分を設定する<br>
 * ・支払い条件を設定する<br>
 * ・事業所名を設定する<br>
 * ・部署名を設定する<br>
 * 
 * @author 久野
 * @version 1.0
 * 
 */

public class CustomerResultBean {

	/** 顧客コード  ： 顧客コードを保存する　 */
	private int customerCode;
	
	/** 顧客名 ：　顧客名を保存する */
	private String customerName;
	
	/** TEL ：  TELを保存する */
	private String tel;

	/** 担当者 ： 担当者を保存する */
	private String PCName;
	
	/** 取引区分 ：  取引区分を保存する */
	private String salesCMCategory;

	/** 支払い条件 ： 支払い条件を保存する */
	private String cutoffGroup;
	
	/** 事業所名 ： 事業所名を保存する */
	private String officeName;
	
	/** 部署名 ： 部署名を保存する */
	private String deptName;

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
	 * @return the salesCMCategory
	 */
	public String getSalesCMCategory() {
		return salesCMCategory;
	}

	/**
	 * @param salesCMCategory the salesCMCategory to set
	 */
	public void setSalesCMCategory(String salesCMCategory) {
		this.salesCMCategory = salesCMCategory;
	}

	/**
	 * @return the paybackCycleCategory
	 */
	public String getCutoffGroup() {
		return cutoffGroup;
	}

	/**
	 * @param paybackCycleCategory the paybackCycleCategory to set
	 */
	public void setCutoffGroup(String cutoffGroup) {
		this.cutoffGroup = cutoffGroup;
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
}

