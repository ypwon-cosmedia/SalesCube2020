package beans;

import java.util.Date;

/**
 * ���i�̗�������ێ�����
 * @author cosmedia
 *
 */
public class ProductHistoryBean {
	/** ����ID�F �����̏���ێ�����*/
	private int histID;
	/** �A�N�V�����̎�ނ̏���ێ�����*/
	private String actionType;
	/** �A�N�V������*/
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
