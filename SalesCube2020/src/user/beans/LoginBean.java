package user.beans;

/**
 * ログイン情報
 * @author komori
 *
 */
public class LoginBean {
	/**ID: IDを保持する*/
	private String userID;
	/**password: passwordを保持する*/
	private String password;
	
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
	 * passwordを取得する
	 * @return (String)passwordを返す
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * passwordを設定する
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}