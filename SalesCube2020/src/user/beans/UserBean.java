package user.beans;

/**
 * ƒƒOƒCƒ“î•ñ
 * @author komori
 *
 */
public class UserBean {
	/**ID: ID‚ğ•Û‚·‚é*/
	private String userID;
	
	/**password: password‚ğ•Û‚·‚é*/
	private String password;
	
	/**
	 * ID‚ğæ“¾‚·‚é
	 * @return (String)ID‚ğ•Ô‚·
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * ID‚ğİ’è‚·‚é
	 * @param userID
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	/**
	 * password‚ğæ“¾‚·‚é
	 * @return (String)password‚ğ•Ô‚·
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * password‚ğİ’è‚·‚é
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}