package master.customer.beans;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerHistoryBean {

	/** 履歴ID： 履歴の情報を保持する*/
	private int histID;
	
	/** アクションの種類（追加・変更・削除）の情報を保持する*/
	private String actionType;
	
	/** アクションのFunc（機能名）を保持する*/
	private String actionFunc;
	
	/**操作した日時の情報を保持する*/
	private Date recDatetm;
	
	/**操作したユーザのIDを保持する*/
	private String userID;
	
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
	private String cutoffGroup;

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
	
	/** 更新日時 ： 更新日時 を保存する */
	private Date updDate;
	
	/** 更新者 ： 更新者を保存する */
	private String updUser;
	
	/** 削除日時 ：  削除日時を保存する */
	private Date delDate;
	
	/** 削除者 ： 削除者 を保存する */
	private String delUser;

	public int getHistID() {
		return histID;
	}

	public void setHistID(int histID) {
		this.histID = histID;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getActionFunc() {
		return actionFunc;
	}

	public void setActionFunc(String actionFunc) {
		this.actionFunc = actionFunc;
	}

	public Date getRecDatetm() {
		return recDatetm;
	}

	public void setRecDatetm(Date recDatetm) {
		this.recDatetm = recDatetm;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerKana() {
		return customerKana;
	}

	public void setCustomerKana(String customerKana) {
		this.customerKana = customerKana;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getOfficeNameKana() {
		return officeNameKana;
	}

	public void setOfficeNameKana(String officeNameKana) {
		this.officeNameKana = officeNameKana;
	}

	public String getCustomerAbbr() {
		return customerAbbr;
	}

	public void setCustomerAbbr(String customerAbbr) {
		this.customerAbbr = customerAbbr;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getZipAddress1() {
		return zipAddress1;
	}

	public void setZipAddress1(String zipAddress1) {
		this.zipAddress1 = zipAddress1;
	}

	public String getZipAddress2() {
		return zipAddress2;
	}

	public void setZipAddress2(String zipAddress2) {
		this.zipAddress2 = zipAddress2;
	}

	public String getPCName() {
		return PCName;
	}

	public void setPCName(String pCName) {
		PCName = pCName;
	}

	public String getPCNameKana() {
		return PCNameKana;
	}

	public void setPCNameKana(String pCNameKana) {
		PCNameKana = pCNameKana;
	}

	public String getPCPreCategory() {
		return PCPreCategory;
	}

	public void setPCPreCategory(String pCPreCategory) {
		PCPreCategory = pCPreCategory;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getPCPost() {
		return PCPost;
	}

	public void setPCPost(String pCPost) {
		PCPost = pCPost;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRankCategory() {
		return rankCategory;
	}

	public void setRankCategory(String rankCategory) {
		this.rankCategory = rankCategory;
	}

	public String getUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}

	public String getROCategory() {
		return ROCategory;
	}

	public void setROCategory(String rOCategory) {
		ROCategory = rOCategory;
	}

	public BigDecimal getMaxCreditLimit() {
		return maxCreditLimit;
	}

	public void setMaxCreditLimit(BigDecimal maxCreditLimit) {
		this.maxCreditLimit = maxCreditLimit;
	}

	public String getBusinessCategory() {
		return businessCategory;
	}

	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}

	public String getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	public String getFractCategory() {
		return fractCategory;
	}

	public void setFractCategory(String fractCategory) {
		this.fractCategory = fractCategory;
	}

	public String getShiftCategory() {
		return shiftCategory;
	}

	public void setShiftCategory(String shiftCategory) {
		this.shiftCategory = shiftCategory;
	}

	public Date getLastCutoffDate() {
		return lastCutoffDate;
	}

	public void setLastCutoffDate(Date lastCutoffDate) {
		this.lastCutoffDate = lastCutoffDate;
	}

	public String getSalesCMCategory() {
		return salesCMCategory;
	}

	public void setSalesCMCategory(String salesCMCategory) {
		this.salesCMCategory = salesCMCategory;
	}

	public String getPaybackCycleCategory() {
		return cutoffGroup;
	}

	public void setCutoffGroup(String cutoffGroup) {
		this.cutoffGroup = cutoffGroup;
	}

	public String getPaybackTypeCategory() {
		return paybackTypeCategory;
	}

	public void setPaybackTypeCategory(String paybackTypeCategory) {
		this.paybackTypeCategory = paybackTypeCategory;
	}

	public String getBillPrintUnit() {
		return billPrintUnit;
	}

	public void setBillPrintUnit(String billPrintUnit) {
		this.billPrintUnit = billPrintUnit;
	}

	public String getBillDatePrint() {
		return billDatePrint;
	}

	public void setBillDatePrint(String billDatePrint) {
		this.billDatePrint = billDatePrint;
	}

	public String getTempDeliverySlipFlag() {
		return tempDeliverySlipFlag;
	}

	public void setTempDeliverySlipFlag(String tempDeliverySlipFlag) {
		this.tempDeliverySlipFlag = tempDeliverySlipFlag;
	}

	public String getPaymentName() {
		return paymentName;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreDate() {
		return creDate;
	}

	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}

	public String getCreUser() {
		return creUser;
	}

	public void setCreUser(String creUser) {
		this.creUser = creUser;
	}

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public String getUpdUser() {
		return updUser;
	}

	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}

	public Date getDelDate() {
		return delDate;
	}

	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}

	public String getDelUser() {
		return delUser;
	}

	public void setDelUser(String delUser) {
		this.delUser = delUser;
	}
	
}
