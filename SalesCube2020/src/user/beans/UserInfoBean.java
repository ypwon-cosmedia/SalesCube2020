package user.beans;

public class UserInfoBean {
	/**ID: ID��ێ�����*/
	private String userID;
	/**nameKNJ: ��������ێ�����*/
	private String nameKNJ;
	
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
	 * nameKNJ���擾����
	 * @return (String)nameKNJ��Ԃ�
	 */
	public String getNameKNJ() {
		return nameKNJ;
	}
	/**
	 * nameKNJ��ݒ肷��
	 * @param nameKNJ
	 */
	public void setNameKNJ(String nameKNJ) {
		this.nameKNJ = nameKNJ;
	}

}
