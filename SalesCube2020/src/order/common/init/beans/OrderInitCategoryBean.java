package order.common.init.beans;

/*
 * OrderInitCategoryBean
 * 
 * Version 1.0
 * 
 * Copyright cosmedia
 * 
 * 受注検索分類情報を保存するBean
 */

public class OrderInitCategoryBean {

	private String classCode1;	/* 大分類コード */
	private String classCode2;	/* 中分類コード */
	private String classCode3;	/* 小分類コード */
	private String className;	/* 分類名 */
	
	public String getClassCode1() {
		return classCode1;
	}
	public void setClassCode1(String classCode1) {
		this.classCode1 = classCode1;
	}
	public String getClassCode2() {
		return classCode2;
	}
	public void setClassCode2(String classCode2) {
		this.classCode2 = classCode2;
	}
	public String getClassCode3() {
		return classCode3;
	}
	public void setClassCode3(String classCode3) {
		this.classCode3 = classCode3;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	
}
