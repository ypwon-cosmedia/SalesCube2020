package master.customer.beans.customerSearchBeans;
/**
 * �ڋq���
 * �ڋq�����̏����͂ɕt������T�[�r�X��񋟂���<br>
 * �E�ڋq�R�[�h���擾����<br>
 * �E�ڋq�����擾����<br>
 * �E�ڋq���J�i���擾����<br>
 * �E���Ə������擾����<br>
 * �E���Ə����J�i���擾����<br>
 * �ETEL���擾����<br>
 * �EFAX���擾����<br>
 * �E�S���҂��擾����<br>
 * �E�S���҃J�i���擾����<br>
 * �E�ڋq�����N���擾����<br>
 * �E�x�����������擾����<br>
 * �E�U�����`���擾����<br>
 * �E���l���擾����<br>
 * 
 * �E�ڋq�R�[�h��ݒ肷��<br>
 * �E�ڋq����ݒ肷��<br>
 * �E�ڋq���J�i��ݒ肷��<br>
 * �E���Ə�����ݒ肷��<br>
 * �E���Ə����J�i��ݒ肷��<br>
 * �ETEL��ݒ肷��<br>
 * �E�S���҂�ݒ肷��<br>
 * �E�S���҃J�i��ݒ肷��<br>
 * �EFAX��ݒ肷��<br>
 * �E�ڋq�����N��ݒ肷��<br>
 * �E�x����������ݒ肷��<br>
 * �E�U�����`��ݒ肷��<br>
 * �E���l��ݒ肷��<br>
 * 
 * @author �v��
 * @version 1.0
 * 
 */

public class CustomerInputBean {

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
	
	/** TEL �F  TEL��ۑ����� */
	private String tel;

	/** �S���� �F �S���҂�ۑ����� */
	private String PCName;

	/** �S���҃J�i �F �S���҃J�i��ۑ����� */
	private String PCNameKana;

	/** FAX �F FAX ��ۑ����� */
	private String fax;

	/** �ڋq�����N �F  �ڋq�����N��ۑ����� */
	private String rankCategory;

	/** �x�������� �F �x����������ۑ����� */
	private String paybackCycleCategory;

	/** �U�����` �F �U�����`��ۑ����� */
	private String paymentName;
	
	/** ���l �F  ���l��ۑ����� */
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

