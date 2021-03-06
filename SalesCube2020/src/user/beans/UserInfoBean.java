package user.beans;

public class UserInfoBean {
	/**ID: IDを保持する*/
	private String userID;
	/**nameKNJ: 漢字名を保持する*/
	private String nameKNJ;
	
	/**
	 * IDを取得する
	 * @return (String)IDを返す
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * IDを設定する
	 * @param userID
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	/**
	 * nameKNJを取得する
	 * @return (String)nameKNJを返す
	 */
	public String getNameKNJ() {
		return nameKNJ;
	}
	/**
	 * nameKNJを設定する
	 * @param nameKNJ
	 */
	public void setNameKNJ(String nameKNJ) {
		this.nameKNJ = nameKNJ;
	}

}
