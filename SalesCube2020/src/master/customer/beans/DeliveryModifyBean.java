package master.customer.beans;

import java.util.Date;

/**
 * �[������
 * �[������ύX�ɕt������T�[�r�X��񋟂���<br>
 * �E�[����R�[�h���擾����<br>
 * �E�[���於���擾����<br>
 * �E�[���於�J�i���擾����<br> 
 * �E���Ə������擾����<br>
 * �E���Ə����J�i���擾����<br>
 * �E���������擾����<br>
 * �E�Z��1���擾����<br>
 * �E�Z��2���擾����<br>
 * �E�S���҂��擾����<br>
 * �E�S���҃J�i���擾����<br>
 * �E�h�̂��擾����<br>
 * �ETEL���擾����<br>
 * �EFAX���擾����<br>
 * �EE-MAIL���擾����<br>
 * �EFAX���擾����<br>
 * �E�X�V�������擾����<br>
 * �E�X�V�҂��擾����<br>
 * 
 * �E�[����R�[�h��ݒ肷��<br>
 * �E�[���於��ݒ肷��<br>
 * �E�[���於�J�i��ݒ肷��<br> 
 * �E���Ə�����ݒ肷��<br>
 * �E���Ə����J�i��ݒ肷��<br>
 * �E��������ݒ肷��<br>
 * �E�Z��1��ݒ肷��<br>
 * �E�Z��2��ݒ肷��<br>
 * �E�S���҂�ݒ肷��<br>
 * �E�S���҃J�i��ݒ肷��<br>
 * �E�h�̂�ݒ肷��<br>
 * �ETEL��ݒ肷��<br>
 * �EFAX��ݒ肷��<br>
 * �EE-MAIL�ݒ肷��<br>
 * �EFAX��ݒ肷��<br>
 * �E�X�V������ݒ肷��<br>
 * �E�X�V�҂�ݒ肷��<br>
 * 
 * @author �v��
 * @version 1.0
 * 
 */

public class DeliveryModifyBean {

	/** �[����R�[�h�@�F�@�[����R�[�h��ێ����� */
	private int deliveryCode;

	/** �[���於�@�F�@�[���於��ێ����� */
	private String deliveryName;

	/** �[���於�J�i�@�F�@�[���於�J�i��ێ����� */
	private String deliveryKana;

	/** ���Ə����@�F�@���Ə�����ێ����� */
	private String officeName;

	/** ���Ə����J�i�@�F�@���Ə����J�i��ێ����� */
	private String officeKana;
	
	/** ������ �F�@��������ێ����� */
	private String deptName;

	/** �X�֔ԍ� �F�@�X�֔ԍ���ێ����� */
	private int zipCode;
	
	/** �Z��1 �F�@�Z��1��ێ����� */
	private String address1;
	
	/** �Z��2 �F�@�Z��2��ێ����� */
	private String address2;
	
	/** �S���� �F�@�S���҂�ێ����� */
	private String PCName;
	
	/** �S���҃J�i �F�@�S���҃J�i��ێ����� */
	private String PCKana;
	
	/** �h�� �F�@�h�̂�ێ����� */
	private String PCPreCategory;
	
	/** TEL �F�@TEL��ێ����� */
	private String tel;
	
	/** FAX �F�@FAX��ێ����� */
	private String fax;
	
	/** E-MAIL �F�@E-MAIL��ێ����� */
	private String email;
	
	/** �X�V���� �F �X�V���� ��ۑ����� */
	private Date updDate;
	
	/** �X�V�� �F �X�V�҂�ۑ����� */
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
