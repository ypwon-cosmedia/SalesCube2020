/*
 * �^�C�g���FSalesCube
 * �����@�@�F�Ǘ��V�X�e��
 *
 * ���쌠�@�F
 * ��Ж��@�F������ЃR�X���f�B�A
 *
 * �ύX�����F2020.06.16�@�V�K�쐬
 *
 */
package beans;

 /**
  * �X�֔ԍ��y�яZ�����
  * �X�֔ԍ��y�яZ���ɕt������T�[�r�X��񋟂���<br>
  * �E�X�֔ԍ����擾����<br>
  * �E�Z��1���擾����<br>
  * �E�Z��2���擾����<br> 
  * �E�X�֔ԍ���ݒ肷��<br>
  * �E�Z��1��ݒ肷��<br>
  * �E�Z��2��ݒ肷��<br>
  * 
  * @author �v��
  * @version 1.0
  * 
  */
public class AddressBean {
	/** �X�֔ԍ��@�F�@�X�֔ԍ���ێ����� */
	private int zipCode;

	/** �Z��1�@�F�@�Z��1��ێ����� */
	private String zipAddress1;
	
	/** �Z��2�@�F�@�Z��2(�ڍׂȏZ��)��ێ����� */
	private String zipAddress2;

	/**
	 * �X�֔ԍ����擾����
	 * 
	 * @return the zipCode �X�֔ԍ���Ԃ�
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * �X�֔ԍ���ݒ肷��
	 * 
	 * @param zipCode the zipCode to set �ݒ肷��X�֔ԍ�
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * �Z��1���擾����
	 * 
	 * @return the zipAddress1 �Z��1��Ԃ�
	 */
	public String getZipAddress1() {
		return zipAddress1;
	}

	/**
	 * �Z��1��ݒ肷��
	 * 
	 * @param zipAddress1 the zipAddress1 to set �ݒ肷��Z��1
	 */
	public void setZipAddress1(String zipAddress1) {
		this.zipAddress1 = zipAddress1;
	}

	/**
	 * �Z��2���擾����
	 * 
	 * @return the zipAddress2 �Z��2��Ԃ�
	 */
	public String getZipAddress2() {
		return zipAddress2;
	}

	/**
	 * �Z��2��ݒ肷��
	 * 
	 * @param zipAddress2 the zipAddress2 to set �ݒ肷��Z��2
	 */
	public void setZipAddress2(String zipAddress2) {
		this.zipAddress2 = zipAddress2;
	}
	
	
	
	
	
}
