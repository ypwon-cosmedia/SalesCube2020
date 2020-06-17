package master.customer.beans;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerHistoryBean {

	/** ����ID�F �����̏���ێ�����*/
	private int histID;
	
	/** �A�N�V�����̎�ށi�ǉ��E�ύX�E�폜�j�̏���ێ�����*/
	private String actionType;
	
	/** �A�N�V������Func�i�@�\���j��ێ�����*/
	private String actionFunc;
	
	/**���삵�������̏���ێ�����*/
	private Date recDatetm;
	
	/**���삵�����[�U��ID��ێ�����*/
	private String userID;
	
	/** �ڋq�R�[�h  �F �ڋq�R�[�h��ۑ�����@ */
	private int customerCode;
	
	/** �ڋq�� �F�@�ڋq����ۑ����� */
	private String customerName;
	
	/** �ڋq���J�i �F �ڋq���J�i��ۑ����� */
	private String customerKana;
	
	/** ���Ə��� �F ���Ə�����ۑ����� */
	private String officeName;

	/** ���Ə����J�i�F ���Ə����J�i��ۑ����� */
	private String officeNameKana;

	/** �ڋq����  �F �ڋq���̂�ۑ����� */
	private String customerAbbr;

	/** �X�֔ԍ� �F �X�֔ԍ���ۑ����� */
	private int zipCode;

	/** �Z��1 �F �Z��1 ��ۑ�����*/
	private String zipAddress1;

	/** �Z��2 �F  �Z��2��ۑ�����*/
	private String zipAddress2;

	/** �S���� �F �S���҂�ۑ����� */
	private String PCName;

	/** �S���҃J�i �F �S���҃J�i��ۑ����� */
	private String PCNameKana;

	/** �h�́F�@ �h�̂�ۑ����� */
	private String PCPreCategory;

	/** ������ �F ��������ۑ����� */
	private String deptName;

	/** ��E �F ��E ��ۑ����� */
	private String PCPost;

	/** TEL �F  TEL��ۑ����� */
	private String tel;

	/** FAX �F FAX ��ۑ����� */
	private String fax;

	/** E-MAIL �F  E-MAIL��ۑ����� */
	private String email;

	/** �ڋq�����N �F  �ڋq�����N��ۑ����� */
	private String rankCategory;

	/** �ڋq�����N�K�p �F  �ڋq�����N�K�p��ۑ����� */
	private String updateFlag;

	/** �󒍒�~ �F �󒍒�~��ۑ����� */
	private String ROCategory;
	
	/** �^�M���x�z �F �^�M���x�z��ۑ����� */
	private BigDecimal maxCreditLimit;

	/** �Ǝ� �F  �Ǝ��ۑ����� */
	private String businessCategory;

	/** �E�� �F  �E���ۑ����� */
	private String jobCategory;
	
	/** �Œ[������ �F  �Œ[��������ۑ����� */
	private String fractCategory;

	/** �œ]�� �F  �œ]�ł�ۑ����� */
	private String shiftCategory;

	/** �ŏI������ �F �ŏI������ ��ۑ����� */
	private Date lastCutoffDate;

	/** ����敪 �F  ����敪��ۑ����� */
	private String salesCMCategory;

	/** �x�������� �F �x����������ۑ����� */
	private String cutoffGroup;

	/** ������@ �F ������@ ��ۑ����� */
	private String paybackTypeCategory;
	
	/** ���������s�P�� �F  ���������s�P�ʂ�ۑ����� */
	private String billPrintUnit;
	
	/** �������t�L�� �F  �������t�L����ۑ����� */
	private String billDatePrint;
	
	/** ���[�i���o�͕s�� �F  ���[�i���o�͕s��ۑ����� */
	private String tempDeliverySlipFlag;
	
	/** �U�����` �F �U�����`��ۑ����� */
	private String paymentName;
	
	/** ���l �F  ���l��ۑ����� */
	private String remarks;
	
	/** �R�����g �F  �R�����g��ۑ����� */
	private String comment;
	
	/** �쐬���� �F �쐬���� ��ۑ����� */
	private Date creDate;
	
	/** �쐬�� �F  �쐬�҂�ۑ����� */
	private String creUser;	
	
	/** �X�V���� �F �X�V���� ��ۑ����� */
	private Date updDate;
	
	/** �X�V�� �F �X�V�҂�ۑ����� */
	private String updUser;
	
	/** �폜���� �F  �폜������ۑ����� */
	private Date delDate;
	
	/** �폜�� �F �폜�� ��ۑ����� */
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
