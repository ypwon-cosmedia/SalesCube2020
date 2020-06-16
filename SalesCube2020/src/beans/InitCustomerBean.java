package beans;

public class InitCustomerBean {
	
	//敬称
	private String customerPcPreCategory;
	
	//支払い条件
	private String cutoffGroop;
	
	//単価端数処理
	private String priceFractCategory ;
	
	//税端数処理
	private String taxFractCategory;
	
	//税転嫁
	private String taxShiftCategory;
	
	//取引区分
	private String salesCmCategory;
	
	//請求書発行単位
	private String billPrintUnit;
	
	//請求書日付有無
	private String billDatePrint;

	
	//敬称を取得する
	public String getCustomerPcPreCategory() {
		return customerPcPreCategory;
	}
	
	//敬称を設定する
	public void setCustomerPcPreCategory(String customerPcPreCategory) {
		this.customerPcPreCategory = customerPcPreCategory;
	}
	
	//支払い条件を取得する
	public String getCutoffGroop() {
		return cutoffGroop;
	}
	
	//支払い条件を設定する
	public void setCutoffGroop(String cutoffGroop) {
		this.cutoffGroop = cutoffGroop;
	}
	
	//単価端数処理を取得する
	public String getPriceFractCategory() {
		return priceFractCategory;
	}
	
	//単価端数処理を設定する
	public void setPriceFractCategory(String priceFractCategory) {
		this.priceFractCategory = priceFractCategory;
	}
	
	//税端数処理を取得する
	public String getTaxFractCategory() {
		return taxFractCategory;
	}
	
	//税端数処理を設定する
	public void setTaxFractCategory(String taxFractCategory) {
		this.taxFractCategory = taxFractCategory;
	}
	
	//税転嫁を取得する
	public String getTaxShiftCategory() {
		return taxShiftCategory;
	}
	
	//税転嫁を設定する
	public void setTaxShiftCategory(String taxShiftCategory) {
		this.taxShiftCategory = taxShiftCategory;
	}
	
	//取引区分を取得する
	public String getSalesCmCategory() {
		return salesCmCategory;
	}
	
	//取引区分を設定する
	public void setSalesCmCategory(String salesCmCategory) {
		this.salesCmCategory = salesCmCategory;
	}
	
	//請求書発行単位を取得する
	public String getBillPrintUnit() {
		return billPrintUnit;
	}

	//請求書発行単位を設定する
	public void setBillPrintUnit(String billPrintUnit) {
		this.billPrintUnit = billPrintUnit;
	}
	
	//請求書日付有無を取得する
	public String getBillDatePrint() {
		return billDatePrint;
	}
	
	//請求書日付有無を設定する
	public void setBillDatePrint(String billDatePrint) {
		this.billDatePrint = billDatePrint;
	}
	
}