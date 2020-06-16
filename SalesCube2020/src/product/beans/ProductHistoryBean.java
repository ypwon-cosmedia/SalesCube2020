package product.beans;

import java.util.Date;

/**
 * 商品の履歴情報を保持する
 * @author komori
 *
 */

public class ProductHistoryBean {
	/** 履歴ID： 履歴の情報を保持する*/
	private int histID;
	/** アクションの種類（追加・変更・削除）の情報を保持する*/
	private String actionType;
	/** アクションのFunc（機能名）を保持する*/
	private String actionFunc;
	/**操作した日時の情報を保持する*/
	private Date recDatetm;
	/**操作したユーザのIDを保持する*/
	private String userID;
	
	
	/**
	 * 履歴のIDを取得する
	 * @return histID
	 */
	public int getHistID() {
		return histID;
	}
	/**
	 * 履歴のIDを設定する
	 * @param histID
	 */
	public void setHistID(int histID) {
		this.histID = histID;
	}
	
	/**
	 * アクションの種類（追加・変更・削除）を取得する
	 * @return actionType
	 */
	public String getActionType() {
		return actionType;
	}
	/**
	 * アクションの種類（追加・変更・削除）を設定する
	 * @param actionType
	 */
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	
	/**
	 * アクションのFunc（機能名）を取得する
	 * @return actionFunc
	 */
	public String getActionFunc() {
		return actionFunc;
	}
	/**
	 * アクションのFunc（機能名）を設定する
	 * @param actionFunc
	 */
	public void setActionFunc(String actionFunc) {
		this.actionFunc = actionFunc;
	}
	
	/**
	 * 操作した日時の情報を取得する
	 * @return recDatetm
	 */
	public Date getRecDatetm() {
		return recDatetm;
	}
	/**
	 * 操作した日時の情報を設定する
	 * @param recDatetm
	 */
	public void setRecDatetm(Date recDatetm) {
		this.recDatetm = recDatetm;
	}
	
	/**
	 * 操作したユーザーのIDを情報を保持する
	 * @return userID
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * 操作したユーザのIDを設定する
	 * @param userID
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

}