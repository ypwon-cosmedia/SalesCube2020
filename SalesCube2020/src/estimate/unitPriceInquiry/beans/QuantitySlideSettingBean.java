/**
 * 
 */
package estimate.unitPriceInquiry.beans;

/**
 * @author cosmedia
 *
 */
public class QuantitySlideSettingBean {
	/** no */
	private String lineNo;
	
	/** 数量割引 */
	private String dataFromTo;
	
	/** 割引率 */
	private double discountRate;

	/**
	 * @return the lineNo
	 */
	public String getLineNo() {
		return lineNo;
	}

	/**
	 * @param lineNo the lineNo to set
	 */
	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}

	/**
	 * @return the dataFromTo
	 */
	public String getDataFromTo() {
		return dataFromTo;
	}

	/**
	 * @param dataFromTo the dataFromTo to set
	 */
	public void setDataFromTo(String dataFromTo) {
		this.dataFromTo = dataFromTo;
	}

	/**
	 * @return the discountRate
	 */
	public double getDiscountRate() {
		return discountRate;
	}

	/**
	 * @param discountRate the discountRate to set
	 */
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	
	
}
