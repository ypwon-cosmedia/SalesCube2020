package master.customer.beans;

import java.util.Date;

/**
 * �[������
 * �[������폜�ɕt������T�[�r�X��񋟂���<br>
 * �E�[����R�[�h���擾����<br>
 * �E�폜�������擾����<br>
 * �E�폜�҂��擾����<br>
 * 
 * �E�[����R�[�h��ݒ肷��<br>
 * �E�폜������ݒ肷��<br>
 * �E�폜�҂�ݒ肷��<br>
 * 
 * @author �v��
 * @version 1.0
 * 
 */

public class DeliveryDeleteBean {

	/** �[����R�[�h�@�F�@�[����R�[�h��ێ����� */
	private int deliveryCode;
	
	/** �폜���� �F  �폜������ۑ����� */
	private Date delDate;
	
	/** �폜�� �F �폜�� ��ۑ����� */
	private String delUser;

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
