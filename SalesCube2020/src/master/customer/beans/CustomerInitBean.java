package master.customer.beans;

public class CustomerInitBean {
	
	//敬称
	private String PCPreCategory;
	
	//支払い条件
	private String paybackCycleCategory;

	//税端数処理
	private String taxFractCategory;
	
	//税転嫁
	private String taxShiftCategory;
	
	//取引区分
	private String salesCMCategory;
	
	//請求書発行単位
	private String billPrintUnit;
	
	//請求書日付有無
	private String billDatePrint;

	/**
	 * @return the pCPreCategory
	 */
	public String getPCPreCategory() {
		return PCPreCategory;
	}

	/**
	 * @param pCPreCategory the pCPreCategory to set
	 */
	public void setPCPreCategory(String pCPreCategory) {
		PCPreCategory = pCPreCategory;
	}

	/**
	 * @return the paybackCycleCategory
	 */
	public String getPaybackCycleCategory() {
		return paybackCycleCategory;
	}

	/**
	 * @param paybackCycleCategory the paybackCycleCategory to set
	 */
	public void setPaybackCycleCategory(String paybackCycleCategory) {
		this.paybackCycleCategory = paybackCycleCategory;
	}

	/**
	 * @return the taxFractCategory
	 */
	public String getTaxFractCategory() {
		return taxFractCategory;
	}

	/**
	 * @param taxFractCategory the taxFractCategory to set
	 */
	public void setTaxFractCategory(String taxFractCategory) {
		this.taxFractCategory = taxFractCategory;
	}

	/**
	 * @return the taxShiftCategory
	 */
	public String getTaxShiftCategory() {
		return taxShiftCategory;
	}

	/**
	 * @param taxShiftCategory the taxShiftCategory to set
	 */
	public void setTaxShiftCategory(String taxShiftCategory) {
		this.taxShiftCategory = taxShiftCategory;
	}

	/**
	 * @return the salesCMCategory
	 */
	public String getSalesCMCategory() {
		return salesCMCategory;
	}

	/**
	 * @param salesCMCategory the salesCMCategory to set
	 */
	public void setSalesCMCategory(String salesCMCategory) {
		this.salesCMCategory = salesCMCategory;
	}

	/**
	 * @return the billPrintUnit
	 */
	public String getBillPrintUnit() {
		return billPrintUnit;
	}

	/**
	 * @param billPrintUnit the billPrintUnit to set
	 */
	public void setBillPrintUnit(String billPrintUnit) {
		this.billPrintUnit = billPrintUnit;
	}

	/**
	 * @return the billDatePrint
	 */
	public String getBillDatePrint() {
		return billDatePrint;
	}

	/**
	 * @param billDatePrint the billDatePrint to set
	 */
	public void setBillDatePrint(String billDatePrint) {
		this.billDatePrint = billDatePrint;
	}

	
}