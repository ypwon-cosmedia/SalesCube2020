/**
 * 
 */
package estimate.unitPriceInquiry.beans;

/**
 * @author cosmedia
 *
 */
public class OrderStatementBean {
	/** 受注番号-行 */
	private String orderNoLine;
	
	/** 出荷日 */
	private String shipDate;
	
	/** 受注残数 */
	private int quantity;

	/**
	 * @return the orderNoLine
	 */
	public String getOrderNoLine() {
		return orderNoLine;
	}

	/**
	 * @param orderNoLine the orderNoLine to set
	 */
	public void setOrderNoLine(String orderNoLine) {
		this.orderNoLine = orderNoLine;
	}

	/**
	 * @return the shipDate
	 */
	public String getShipDate() {
		return shipDate;
	}

	/**
	 * @param shipDate the shipDate to set
	 */
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
