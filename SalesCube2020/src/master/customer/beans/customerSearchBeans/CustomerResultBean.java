package master.customer.beans.customerSearchBeans;
/**
 * �ڋq���
 * �ڋq�����̌������ʂɕt������T�[�r�X��񋟂���<br>
 * �E�ڋq�R�[�h���擾����<br>
 * �E�ڋq�����擾����<br>
 * �ETEL���擾����<br>
 * �E�S���҂��擾����<br>
 * �E����敪���擾����<br>
 * �E�x�����������擾����<br>
 * �E���Ə�����ݒ肷��<br>
 * �E���������擾����<br>
 * 
 * �E�ڋq�R�[�h��ݒ肷��<br>
 * �E�ڋq����ݒ肷��<br>
 * �ETEL��ݒ肷��<br>
 * �E�S���҂�ݒ肷��<br>
 * �E����敪��ݒ肷��<br>
 * �E�x����������ݒ肷��<br>
 * �E���Ə�����ݒ肷��<br>
 * �E��������ݒ肷��<br>
 * 
 * @author �v��
 * @version 1.0
 * 
 */

public class CustomerResultBean {

	/** �ڋq�R�[�h  �F �ڋq�R�[�h��ۑ�����@ */
	private int customerCode;
	
	/** �ڋq�� �F�@�ڋq����ۑ����� */
	private String customerName;
	
	/** TEL �F  TEL��ۑ����� */
	private String tel;

	/** �S���� �F �S���҂�ۑ����� */
	private String PCName;
	
	/** ����敪 �F  ����敪��ۑ����� */
	private String salesCMCategory;

	/** �x�������� �F �x����������ۑ����� */
	private String cutoffGroup;
	
	/** ���Ə��� �F ���Ə�����ۑ����� */
	private String officeName;
	
	/** ������ �F ��������ۑ����� */
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

