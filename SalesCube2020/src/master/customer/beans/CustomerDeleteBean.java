package master.customer.beans;

import java.util.Date;

/**
 * �ڋq���
 * �ڋq�폜�ɕt������T�[�r�X��񋟂���<br>
 * �E�ڋq�R�[�h���擾����<br>
 * �E�폜�������擾����<br>
 * �E�폜�҂��擾����<br>
 * �E�ڋq�R�[�h��ݒ肷��<br>
 * �E�폜������ݒ肷��<br>
 * �E�폜�҂�ݒ肷��<br>
 *
 * @author �v��
 * @version 1.0
 * 
 */
public class CustomerDeleteBean {

	/** �ڋq�R�[�h  �F �ڋq�R�[�h��ۑ�����@ */
	private int customerCode;
	
	/** �폜���� �F  �폜������ۑ����� */
	private Date delDate;
	
	/** �폜�� �F �폜�� ��ۑ����� */
	private String delUser;
	
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
	 * @return the delDate
	 */
	public Date getDelDate() {
		return delDate;
	}

	/**
	 * @param delDate the delDate to set
	 */
	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}

	/**
	 * @return the delUser
	 */
	public String getDelUser() {
		return delUser;
	}

	/**
	 * @param delUser the delUser to set
	 */
	public void setDelUser(String delUser) {
		this.delUser = delUser;
	}
}
