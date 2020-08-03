package estimate.common.beans;

public class CategoryBean {
	//区分情報の取得
	
	//区分ID
	private int categoryId;
	//区分コード
	private String categoryCode;
	//区分コード名
	private String categoryCodeName;
	
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryCodeName() {
		return categoryCodeName;
	}
	public void setCategoryCodeName(String categoryCodeName) {
		this.categoryCodeName = categoryCodeName;
	}
	
	
}
