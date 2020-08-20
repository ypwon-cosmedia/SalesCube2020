package order.online.beans;

import java.sql.Date;

public class OrderOnlineResultBean {

	private int roSlipId;
	private String customerName;
	private Date roDate;
	
	public int getRoSlipId() {
		return roSlipId;
	}
	public void setRoSlipId(int roSlipId) {
		this.roSlipId = roSlipId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getRoDate() {
		return roDate;
	}
	public void setRoDate(Date roDate) {
		this.roDate = roDate;
	}
	
	
}
