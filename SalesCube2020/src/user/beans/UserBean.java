package user.beans;

/**
 * ログイン情報
 * @author komori
 *
 */
public class UserBean {
	/**ID: IDを保持する*/
	private String userID;
	/**password: passwordを保持する*/
	private String password;
	/**message: エラーメッセージを保持する*/
	private String message;
	
	
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
	
	/**
	 * エラーメッセージを取得する
	 * @return message
	 */
    public String getMessage() {
    	return message;
    }
    /**
     * エラーメッセージを設定する
     * @param message
     */
    public void setMessage(String message) {
    	this.message = message;
    }
}