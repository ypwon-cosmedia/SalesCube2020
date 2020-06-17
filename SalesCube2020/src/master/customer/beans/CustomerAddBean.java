package master.customer.beans;
/**
 * 顧客情報
 * 顧客情報追加に付随するサービスを提供する<br>
 * 顧客コードを取得する<br>
 * 顧客名を取得する<br>
 * 顧客名カナを取得する<br>
 * 事業所名を取得する<br>
 * 事業所名カナを取得する<br>
 * 顧客略称を取得する<br>
 * 郵便番号を取得する<br>
 * 住所1を取得する<br>
 * 住所2を取得する<br>
 * 担当者を取得する<br>
 * 担当者カナを取得する<br>
 * 敬称を取得する<br>
 * 部署名を取得する<br>
 * 役職を取得する<br>
 * TELを取得する<br>
 * FAXを取得する<br>
 * E-MAILを取得する<br>
 * 顧客ランクを取得する<br>
 * 顧客ランク適用を取得する<br>
 * 受注停止を取得する<br>
 * 与信限度額を取得する<br>
 * 業種を取得する<br>
 * 職種を取得する<br>
 * 税端数処理を取得する<br>
 * 税転嫁を取得する<br>
 * 最終処理日を取得する<br>
 * 取引区分を取得する<br>
 * 支払い条件を取得する<br>
 * 回収方法を取得する<br>
 * 請求書発行単位を取得する<br>
 * 請求日付有無を取得する<br>
 * 仮納品書出力不可を取得する<br>
 * 振込名義を取得する<br>
 * 備考を取得する<br>
 * コメントを取得する<br>
 * 作成日時を取得する<br>
 * 作成者を取得する<br>
 * 
 * 顧客コードを設定する<br>
 * 顧客名を設定する<br>
 * 顧客名カナを設定する<br>
 * 事業所名を設定する<br>
 * 事業所名カナを設定する<br>
 * 顧客略称を設定する<br>
 * 郵便番号を設定する<br>
 * 住所1を設定する<br>
 * 住所2を設定する<br>
 * 担当者を設定する<br>
 * 担当者カナを設定する<br>
 * 敬称を設定する<br>
 * 部署名を設定する<br>
 * 役職を設定する<br>
 * TELを設定する<br>
 * FAXを設定する<br>
 * E-MAILを設定する<br>
 * 顧客ランクを設定する<br>
 * 顧客ランク適用を設定する<br>
 * 受注停止を設定する<br>
 * 与信限度額を設定する<br>
 * 業種を設定する<br>
 * 職種を設定する<br>
 * 税端数処理を設定する<br>
 * 税転嫁を設定する<br>
 * 最終処理日を設定する<br>
 * 取引区分を設定する<br>
 * 支払い条件を設定する<br>
 * 回収方法を設定する<br>
 * 請求書発行単位を設定する<br>
 * 請求日付有無を設定する<br>
 * 仮納品書出力不可を設定する<br>
 * 振込名義を設定する<br>
 * 備考を設定する<br>
 * コメントを設定する<br>
 * 作成日時を設定する<br>
 * 作成者を設定する<br>
 * 
 * @author 久野
 * @version 1.0
 * 
 */

import java.util.Date;
import java.math.BigDecimal;

public class CustomerAddBean {

	/** 顧客コード  ： 顧客コードを保存する　 */
	private String customerCode;
	
	/** 顧客名 ：　顧客名を保存する */
	private String customerName;
	
	/** 顧客名カナ ： 顧客名カナを保存する */
	private String customerKana;
	
	/** 事業所名 ： 事業所名を保存する */
	private String officeName;

	/** 事業所名カナ： 事業所名カナを保存する */
	private String officeNameKana;

	/** 顧客略称  ： 顧客略称を保存する */
	private String customerAbbr;

	/** 郵便番号 ： 郵便番号を保存する */
	private int zipCode;

	/** 住所1 ： 住所1 を保存する*/
	private String zipAddress1;

	/** 住所2 ：  住所2を保存する*/
	private String zipAddress2;

	/** 担当者 ： 担当者を保存する */
	private String PCName;

	/** 担当者カナ ： 担当者カナを保存する */
	private String PCNameKana;

	/** 敬称：　 敬称を保存する */
	private String PCPreCategory;

	/** 部署名 ： 部署名を保存する */
	private String deptName;

	/** 役職 ： 役職 を保存する */
	private String PCPost;

	/** TEL ：  TELを保存する */
	private String tel;

	/** FAX ： FAX を保存する */
	private String fax;

	/** E-MAIL ：  E-MAILを保存する */
	private String email;

	/** 顧客ランク ：  顧客ランクを保存する */
	private String rankCategory;

	/** 顧客ランク適用 ：  顧客ランク適用を保存する */
	private String updateFlag;

	/** 受注停止 ： 受注停止を保存する */
	private String ROCategory;
	
	/** 与信限度額 ： 与信限度額を保存する */
	private BigDecimal maxCreditLimit;

	/** 業種 ：  業種を保存する */
	private String businessCategory;

	/** 職種 ：  職種を保存する */
	private String jobCategory;
	
	/** 税端数処理 ：  税端数処理を保存する */
	private String fractCategory;

	/** 税転嫁 ：  税転嫁を保存する */
	private String shiftCategory;

	/** 最終処理日 ： 最終処理日 を保存する */
	private Date lastCutoffDate;

	/** 取引区分 ：  取引区分を保存する */
	private String salesCMCategory;

	/** 支払い条件 ： 支払い条件を保存する */
	private String paybackCycleCategory;

	/** 回収方法 ： 回収方法 を保存する */
	private String paybackTypeCategory;
	
	/** 請求書発行単位 ：  請求書発行単位を保存する */
	private String billPrintUnit;
	
	/** 請求日付有無 ：  請求日付有無を保存する */
	private String billDatePrint;
	
	/** 仮納品書出力不可 ：  仮納品書出力不可を保存する */
	private String tempDeliverySlipFlag;
	
	/** 振込名義 ： 振込名義を保存する */
	private String paymentName;
	
	/** 備考 ：  備考を保存する */
	private String remarks;
	
	/** コメント ：  コメントを保存する */
	private String comment;
	
	/** 作成日時 ： 作成日時 を保存する */
	private Date creDate;
	
	/** 作成者 ：  作成者を保存する */
	private String creUser;	
	
	
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
	 * @return the customerAbbr
	 */
	public String getCustomerAbbr() {
		return customerAbbr;
	}

	/**
	 * @param customerAbbr the customerAbbr to set
	 */
	public void setCustomerAbbr(String customerAbbr) {
		this.customerAbbr = customerAbbr;
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
	 * @return the zipAddress1
	 */
	public String getZipAddress1() {
		return zipAddress1;
	}

	/**
	 * @param zipAddress1 the zipAddress1 to set
	 */
	public void setZipAddress1(String zipAddress1) {
		this.zipAddress1 = zipAddress1;
	}

	/**
	 * @return the zipAddress2
	 */
	public String getZipAddress2() {
		return zipAddress2;
	}

	/**
	 * @param zipAddress2 the zipAddress2 to set
	 */
	public void setZipAddress2(String zipAddress2) {
		this.zipAddress2 = zipAddress2;
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
	 * @return the pCPost
	 */
	public String getPCPost() {
		return PCPost;
	}

	/**
	 * @param pCPost the pCPost to set
	 */
	public void setPCPost(String pCPost) {
		PCPost = pCPost;
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
	 * @return the updateFlag
	 */
	public String getUpdateFlag() {
		return updateFlag;
	}

	/**
	 * @param updateFlag the updateFlag to set
	 */
	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}

	/**
	 * @return the rOCategory
	 */
	public String getROCategory() {
		return ROCategory;
	}

	/**
	 * @param rOCategory the rOCategory to set
	 */
	public void setROCategory(String rOCategory) {
		ROCategory = rOCategory;
	}

	/**
	 * @return the maxCreditLimit
	 */
	public BigDecimal getMaxCreditLimit() {
		return maxCreditLimit;
	}

	/**
	 * @param maxCreditLimit the maxCreditLimit to set
	 */
	public void setMaxCreditLimit(BigDecimal maxCreditLimit) {
		this.maxCreditLimit = maxCreditLimit;
	}

	/**
	 * @return the businessCategory
	 */
	public String getBusinessCategory() {
		return businessCategory;
	}

	/**
	 * @param businessCategory the businessCategory to set
	 */
	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}

	/**
	 * @return the jobCategory
	 */
	public String getJobCategory() {
		return jobCategory;
	}

	/**
	 * @param jobCategory the jobCategory to set
	 */
	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	/**
	 * @return the fractCategory
	 */
	public String getFractCategory() {
		return fractCategory;
	}

	/**
	 * @param fractCategory the fractCategory to set
	 */
	public void setFractCategory(String fractCategory) {
		this.fractCategory = fractCategory;
	}

	/**
	 * @return the shiftCategory
	 */
	public String getShiftCategory() {
		return shiftCategory;
	}

	/**
	 * @param shiftCategory the shiftCategory to set
	 */
	public void setShiftCategory(String shiftCategory) {
		this.shiftCategory = shiftCategory;
	}

	/**
	 * @return the lastCutoffDate
	 */
	public Date getLastCutoffDate() {
		return lastCutoffDate;
	}

	/**
	 * @param lastCutoffDate the lastCutoffDate to set
	 */
	public void setLastCutoffDate(Date lastCutoffDate) {
		this.lastCutoffDate = lastCutoffDate;
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
	 * @return the paybackTypeCategory
	 */
	public String getPaybackTypeCategory() {
		return paybackTypeCategory;
	}

	/**
	 * @param paybackTypeCategory the paybackTypeCategory to set
	 */
	public void setPaybackTypeCategory(String paybackTypeCategory) {
		this.paybackTypeCategory = paybackTypeCategory;
	}

	/**
	 * @return the billPrintUnit
	 */
	public String getBillPrintUnit() {
		return billPrintUnit;
	}

	/**
	 * @param billPrintUnit the billPrintUnit to set
	 */
	public void setBillPrintUnit(String billPrintUnit) {
		this.billPrintUnit = billPrintUnit;
	}

	/**
	 * @return the billDatePrint
	 */
	public String getBillDatePrint() {
		return billDatePrint;
	}

	/**
	 * @param billDatePrint the billDatePrint to set
	 */
	public void setBillDatePrint(String billDatePrint) {
		this.billDatePrint = billDatePrint;
	}

	/**
	 * @return the tempDeliverySlipFlag
	 */
	public String getTempDeliverySlipFlag() {
		return tempDeliverySlipFlag;
	}

	/**
	 * @param tempDeliverySlipFlag the tempDeliverySlipFlag to set
	 */
	public void setTempDeliverySlipFlag(String tempDeliverySlipFlag) {
		this.tempDeliverySlipFlag = tempDeliverySlipFlag;
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

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the creDate
	 */
	public Date getCreDate() {
		return creDate;
	}

	/**
	 * @param creDate the creDate to set
	 */
	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}

	/**
	 * @return the creUser
	 */
	public String getCreUser() {
		return creUser;
	}

	/**
	 * @param creUser the creUser to set
	 */
	public void setCreUser(String creUser) {
		this.creUser = creUser;
	}
}
