package product.beans;

import java.util.Date;

/**
 * ���i�̗�������ێ�����
 * @author komori
 *
 */

public class ProductHistoryBean {
	/** ����ID�F �����̏���ێ�����*/
	private int histID;
	/** �A�N�V�����̎�ށi�ǉ��E�ύX�E�폜�j�̏���ێ�����*/
	private String actionType;
	/** �A�N�V������Func�i�@�\���j��ێ�����*/
	private String actionFunc;
	/**���삵�������̏���ێ�����*/
	private Date recDatetm;
	/**���삵�����[�U��ID��ێ�����*/
	private String userID;
	
	
	/**
	 * ������ID���擾����
	 * @return histID
	 */
	public int getHistID() {
		return histID;
	}
	/**
	 * ������ID��ݒ肷��
	 * @param histID
	 */
	public void setHistID(int histID) {
		this.histID = histID;
	}
	
	/**
	 * �A�N�V�����̎�ށi�ǉ��E�ύX�E�폜�j���擾����
	 * @return actionType
	 */
	public String getActionType() {
		return actionType;
	}
	/**
	 * �A�N�V�����̎�ށi�ǉ��E�ύX�E�폜�j��ݒ肷��
	 * @param actionType
	 */
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	
	/**
	 * �A�N�V������Func�i�@�\���j���擾����
	 * @return actionFunc
	 */
	public String getActionFunc() {
		return actionFunc;
	}
	/**
	 * �A�N�V������Func�i�@�\���j��ݒ肷��
	 * @param actionFunc
	 */
	public void setActionFunc(String actionFunc) {
		this.actionFunc = actionFunc;
	}
	
	/**
	 * ���삵�������̏����擾����
	 * @return recDatetm
	 */
	public Date getRecDatetm() {
		return recDatetm;
	}
	/**
	 * ���삵�������̏���ݒ肷��
	 * @param recDatetm
	 */
	public void setRecDatetm(Date recDatetm) {
		this.recDatetm = recDatetm;
	}
	
	/**
	 * ���삵�����[�U�[��ID������ێ�����
	 * @return userID
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * ���삵�����[�U��ID��ݒ肷��
	 * @param userID
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

}