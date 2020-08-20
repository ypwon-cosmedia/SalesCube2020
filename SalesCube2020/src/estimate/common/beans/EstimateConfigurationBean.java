package estimate.common.beans;

public class EstimateConfigurationBean {
	//設定の項目の取得・更新
	
	//項目ID
	private String itemId;
	//項目名
	private String itemName;
	//順番号
	private int seq;
	//ソート
	private String sortFlag;
	
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	/**
	 * @return the sortFlag
	 */
	public String getSortFlag() {
		return sortFlag;
	}
	/**
	 * @param sortFlag the sortFlag to set
	 */
	public void setSortFlag(String sortFlag) {
		this.sortFlag = sortFlag;
	}


}
