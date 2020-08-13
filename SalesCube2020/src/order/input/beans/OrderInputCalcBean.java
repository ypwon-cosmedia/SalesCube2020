package order.input.beans;

public class OrderInputCalcBean {

	/* 粗利益 */
	private Integer prossProfit;
	
	/* 粗利益率 */
	private double grossProfitRatio;
	
	/* 金額合計 */
	private Integer retailPriceTotal;
	
	/* 消費税 */
	private Integer ctaxPriceTotal;
	
	public Integer getProssProfit() {
		return prossProfit;
	}

	public void setProssProfit(Integer prossProfit) {
		this.prossProfit = prossProfit;
	}

	public double getGrossProfitRatio() {
		return grossProfitRatio;
	}

	public void setGrossProfitRatio(double grossProfitRatio) {
		this.grossProfitRatio = grossProfitRatio;
	}

	public Integer getRetailPriceTotal() {
		return retailPriceTotal;
	}

	public void setRetailPriceTotal(Integer retailPriceTotal) {
		this.retailPriceTotal = retailPriceTotal;
	}

	public Integer getCtaxPriceTotal() {
		return ctaxPriceTotal;
	}

	public void setCtaxPriceTotal(Integer ctaxPriceTotal) {
		this.ctaxPriceTotal = ctaxPriceTotal;
	}

	public Integer getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(Integer priceTotal) {
		this.priceTotal = priceTotal;
	}

	/* 伝票合計 */
	private Integer priceTotal;
	
}
