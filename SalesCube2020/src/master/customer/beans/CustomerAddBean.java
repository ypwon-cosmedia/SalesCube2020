package master.customer.beans;
/**
 * �ڋq���
 * �ڋq���ǉ��ɕt������T�[�r�X��񋟂���<br>
 * �ڋq�R�[�h���擾����<br>
 * �ڋq�����擾����<br>
 * �ڋq���J�i���擾����<br>
 * ���Ə������擾����<br>
 * ���Ə����J�i���擾����<br>
 * �ڋq���̂��擾����<br>
 * �X�֔ԍ����擾����<br>
 * �Z��1���擾����<br>
 * �Z��2���擾����<br>
 * �S���҂��擾����<br>
 * �S���҃J�i���擾����<br>
 * �h�̂��擾����<br>
 * ���������擾����<br>
 * ��E���擾����<br>
 * TEL���擾����<br>
 * FAX���擾����<br>
 * E-MAIL���擾����<br>
 * �ڋq�����N���擾����<br>
 * �ڋq�����N�K�p���擾����<br>
 * �󒍒�~���擾����<br>
 * �^�M���x�z���擾����<br>
 * �Ǝ���擾����<br>
 * �E����擾����<br>
 * �Œ[���������擾����<br>
 * �œ]�ł��擾����<br>
 * �ŏI���������擾����<br>
 * ����敪���擾����<br>
 * �x�����������擾����<br>
 * ������@���擾����<br>
 * ���������s�P�ʂ��擾����<br>
 * �������t�L�����擾����<br>
 * ���[�i���o�͕s���擾����<br>
 * �U�����`���擾����<br>
 * ���l���擾����<br>
 * �R�����g���擾����<br>
 * �쐬�������擾����<br>
 * �쐬�҂��擾����<br>
 * 
 * �ڋq�R�[�h��ݒ肷��<br>
 * �ڋq����ݒ肷��<br>
 * �ڋq���J�i��ݒ肷��<br>
 * ���Ə�����ݒ肷��<br>
 * ���Ə����J�i��ݒ肷��<br>
 * �ڋq���̂�ݒ肷��<br>
 * �X�֔ԍ���ݒ肷��<br>
 * �Z��1��ݒ肷��<br>
 * �Z��2��ݒ肷��<br>
 * �S���҂�ݒ肷��<br>
 * �S���҃J�i��ݒ肷��<br>
 * �h�̂�ݒ肷��<br>
 * ��������ݒ肷��<br>
 * ��E��ݒ肷��<br>
 * TEL��ݒ肷��<br>
 * FAX��ݒ肷��<br>
 * E-MAIL��ݒ肷��<br>
 * �ڋq�����N��ݒ肷��<br>
 * �ڋq�����N�K�p��ݒ肷��<br>
 * �󒍒�~��ݒ肷��<br>
 * �^�M���x�z��ݒ肷��<br>
 * �Ǝ��ݒ肷��<br>
 * �E���ݒ肷��<br>
 * �Œ[��������ݒ肷��<br>
 * �œ]�ł�ݒ肷��<br>
 * �ŏI��������ݒ肷��<br>
 * ����敪��ݒ肷��<br>
 * �x����������ݒ肷��<br>
 * ������@��ݒ肷��<br>
 * ���������s�P�ʂ�ݒ肷��<br>
 * �������t�L����ݒ肷��<br>
 * ���[�i���o�͕s��ݒ肷��<br>
 * �U�����`��ݒ肷��<br>
 * ���l��ݒ肷��<br>
 * �R�����g��ݒ肷��<br>
 * �쐬������ݒ肷��<br>
 * �쐬�҂�ݒ肷��<br>
 * 
 * @author �v��
 * @version 1.0
 * 
 */

import java.util.Date;
import java.math.BigDecimal;

public class CustomerAddBean {

	/** �ڋq�R�[�h  �F �ڋq�R�[�h��ۑ�����@ */
	private String customerCode;
	
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
	private String paybackCycleCategory;

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
