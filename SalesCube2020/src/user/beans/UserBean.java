package user.beans;

/**
 * ���O�C�����
 * @author komori
 *
 */
public class UserBean {
	/**ID: ID��ێ�����*/
	private String userID;
	
	/**password: password��ێ�����*/
	private String password;
	
	/**
	 * ID���擾����
	 * @return (String)ID��Ԃ�
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * ID��ݒ肷��
	 * @param userID
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	/**
	 * password���擾����
	 * @return (String)password��Ԃ�
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * password��ݒ肷��
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}