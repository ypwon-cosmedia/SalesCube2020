package beans;

import java.util.Date;

/**
 * 商品の履歴情報を保持する
 * @author cosmedia
 *
 */
public class ProductHistoryBean {
	/** 履歴ID： 履歴の情報を保持する*/
	private int histID;
	/** アクションの種類の情報を保持する*/
	private String actionType;
	/** アクションの*/
	private String actionFunc;
	private Date recDatetm;
	private String userID;
	
	
	//histID
	public int getHistID() {
		return histID;
	}
	
	public void setHistID(int histID) {
		this.histID = histID;
	}
	
	//actionType
	public String getActionType() {
		return actionType;
	}
	
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	
	//actionFunc
	public String getActionFunc() {
		return actionFunc;
	}
	
	public void setActionFunc(String actionFunk) {
		this.actionFunc = actionFunc;
	}
	
	//recDatetm
	public Date getRecDatetm() {
		return recDatetm;
	}
	
	public void setRecDatetm(Date recDatetm) {
		this.recDatetm = recDatetm;
	}

}
