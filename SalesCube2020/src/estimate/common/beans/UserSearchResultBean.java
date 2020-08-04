package estimate.common.beans;

public class UserSearchResultBean {
	
	//担当者コード
	private String userId;
	
	//担当者名
	private String nameKnj;
	
	//部門
	private String deptId;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the nameKnj
	 */
	public String getNameKnj() {
		return nameKnj;
	}

	/**
	 * @param nameKnj the nameKnj to set
	 */
	public void setNameKnj(String nameKnj) {
		this.nameKnj = nameKnj;
	}

	/**
	 * @return the deptId
	 */
	public String getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	
	
}
