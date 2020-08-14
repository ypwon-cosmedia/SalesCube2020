package order.input.beans;

public class OrderInputDeliveryBean {
	
	/* 顧客納入先 */
	private String deliveryName;
	
	/* 事業所名 */
	private String deliveryOfficeName;
	
	/* 部署名 */
	private String deliveryDeptName;
	
	/* 郵便番号 */
	private String deliveryZipCode;
	
	/* 住所1 */
	private String deliveryAddress1;
	
	/* 住所2 */
	private String deliveryAddress2;
	
	/* 担当者 */
	private String deliveryPcName;
	
	/* 担当者カナ */
	private String deliveryPcKana;
	
	/* 敬称 */
	private String deliveryPcPre;
	
	/* TEL */
	private String deliveryTel;
	
	/* FAX */
	private String deliveryFax;
	
	/* Email */
	private String deliveryEmail;
	
	/* 区分コード名 */
	private String categoryCodeName;
	
	/* 区分コード */
	private String categoryCode;

	public String getCategoryCodeName() {
		return categoryCodeName;
	}

	public void setCategoryCodeName(String categoryCodeName) {
		this.categoryCodeName = categoryCodeName;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliveryOfficeName() {
		return deliveryOfficeName;
	}

	public void setDeliveryOfficeName(String deliveryOfficeName) {
		this.deliveryOfficeName = deliveryOfficeName;
	}

	public String getDeliveryDeptName() {
		return deliveryDeptName;
	}

	public void setDeliveryDeptName(String deliveryDeptName) {
		this.deliveryDeptName = deliveryDeptName;
	}

	public String getDeliveryZipCode() {
		return deliveryZipCode;
	}

	public void setDeliveryZipCode(String deliveryZipCode) {
		this.deliveryZipCode = deliveryZipCode;
	}

	public String getDeliveryAddress1() {
		return deliveryAddress1;
	}

	public void setDeliveryAddress1(String deliveryAddress1) {
		this.deliveryAddress1 = deliveryAddress1;
	}

	public String getDeliveryAddress2() {
		return deliveryAddress2;
	}

	public void setDeliveryAddress2(String deliveryAddress2) {
		this.deliveryAddress2 = deliveryAddress2;
	}

	public String getDeliveryPcName() {
		return deliveryPcName;
	}

	public void setDeliveryPcName(String deliveryPcName) {
		this.deliveryPcName = deliveryPcName;
	}

	public String getDeliveryPcKana() {
		return deliveryPcKana;
	}

	public void setDeliveryPcKana(String deliveryPcKana) {
		this.deliveryPcKana = deliveryPcKana;
	}

	public String getDeliveryPcPre() {
		return deliveryPcPre;
	}

	public void setDeliveryPcPre(String deliveryPcPre) {
		this.deliveryPcPre = deliveryPcPre;
	}

	public String getDeliveryTel() {
		return deliveryTel;
	}

	public void setDeliveryTel(String deliveryTel) {
		this.deliveryTel = deliveryTel;
	}

	public String getDeliveryFax() {
		return deliveryFax;
	}

	public void setDeliveryFax(String deliveryFax) {
		this.deliveryFax = deliveryFax;
	}

	public String getDeliveryEmail() {
		return deliveryEmail;
	}

	public void setDeliveryEmail(String deliveryEmail) {
		this.deliveryEmail = deliveryEmail;
	}

}
