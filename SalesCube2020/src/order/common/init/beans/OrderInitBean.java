package order.common.init.beans;

/*
 * OrderInitBean
 * 
 * Version 1.0
 * 
 * Copyright cosmedia
 * 
 * ページのコンボボックスの情報を保存するBean
 */

public class OrderInitBean {
	
	private String categoryCode;		/* コンボボックスのvalue値 */
	private String categoryCodeName;	/* コンボボックスの表示値 */
	
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
