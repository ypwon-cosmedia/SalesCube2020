package order.common.bill.beans;

/**
 * 
 * 作成日：2020/08/03
 * 作成者：宮本
 * 
 */

public class OrderCommonBillBean {
	/* 見積番号 */
	public String estimateSheetId;
	
	/* 見積日 */
	public String estimateDate;
	
	/* 提出先名 */
	public String submitName;
	
	/* 件名 */
	public String title;

	public String getEstimateSheetId() {
		return estimateSheetId;
	}

	public void setEstimateSheetId(String estimateSheetId) {
		this.estimateSheetId = estimateSheetId;
	}

	public String getEstimateDate() {
		return estimateDate;
	}

	public void setEstimateDate(String estimateDate) {
		this.estimateDate = estimateDate;
	}

	public String getSubmitName() {
		return submitName;
	}

	public void setSubmitName(String submitName) {
		this.submitName = submitName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
