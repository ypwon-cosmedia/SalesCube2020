package master.product.beans;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品の履歴情報を保持する
 * @author komori
 *
 */

public class ProductHistoryBean {
	/** 履歴ID： 履歴の情報を保持する*/
	private int histID;
	
	/** アクションの種類（追加・変更・削除）の情報を保持する*/
	private String actionType;
	
	/** アクションのFunc（機能名）を保持する*/
	private String actionFunc;
	
	/**操作した日時の情報を保持する*/
	private Date recDatetm;
	
	/**操作したユーザのIDを保持する*/
	private String userID;
	
	//商品の編集・追加のデータ
	/** 商品コード：商品コードを保持する */
	private String productCode;

	/** 商品名：商品名を保持する */
	private String productName;
	
	/** 商品名カナ：商品名カナを保持する */
	private String productKana;
	
	/** オンライン品番：オンライン品番を保持する */
	private String productPcode;
	
	/** JANコード：JANコードを保持する */
	private String janPcode;
	
	/** 廃棄日：廃棄日を保持する */
	private Date discardDate;
	
	/** 仕入先コード：仕入先コードを保持する */
	private String supplierCode;
	
	/** 仕入先名：仕入先名を保持する */
	private String supplierName;

	/** 仕入先品番：仕入先品番を保持する */
	private String supplierPcode;
	
	/** 仕入単価（円）：仕入単価（円）を保持する */
	private int supplierPriceYen;
	
	/** 仕入単価（外貨）：仕入単価（外貨）を保持する */
	private int supplierPriceDol;

	/** 在庫管理区分：在庫管理区分を保持する */
	private String stockCtlCategory;
	
	/** 入数：入数を保持する */
	private String packQuantity;
	
	/** 平均出荷数：平均出荷数を保持する */
	private int avgShipCount;
	
	/** 倉庫名：倉庫名を保持する */
	private String warehouseName;
	
	/** 棚番：棚番を保持する */
	private String rankName;

	/** リードタイム：リードタイムを保持する */
	private int leadTime;

	/** 発注点：発注点を保持する */
	private int poNum;
	
	/** 発注点自動更新：発注点自動更新を保持する */
	private short poUpdFlag;

	/** 自社安全在庫数：自社安全在庫数を保持する */
	private int mineSafetyStock;
	
	/** 自社安全在庫数自動更新：自社安全在庫数自動更新を保持する */
	private short mineSafetyStockUpdFlag;

	/** 発注ロット：発注ロットを保持する */
	private BigDecimal poLot;
	
	/** 発注ロット自動更新：発注ロット自動更新を保持する */
	private short lotUpdFlag;

	/** 在庫限度数：在庫限度数を保持する */
	private int maxStockNum;
	
	/** 在庫限度数自動更新：在庫限度数自動更新を保持する */
	private int StockUpdFlag;

	/** 発注限度数：発注限度数を保持する */
	private int maxPoNum;
	
	/** 発注限度数自動更新：発注限度数自動更新を保持する */
	private short maxPoUpdFlag;

	/** 受注限度数：受注限度数を保持する */
	private short roMaxNum;
	
	/** 上代：上代を保持する */
	private BigDecimal retailPrice;
	
	/** 割引コード：割引コードを保持する */
	private String discountId;
	
	/** 分類状況：分類状況を保持する */
	private String productStatusCategory;
	
	/** 分類保管：分類保管を保持する */
	private String productStockCategory;
	
	/** 分類調達：分類調達を保持する */
	private String productPurvayCategory;
	
	/** 分類標準：分類標準を保持する */
	private String productStandardCategory;
	
	/** 特注品掛率：特注品掛率を保持する */
	private BigDecimal soRate;

	/** セット商品フラグ：セット商品フラグを保持する */
	private int setTypeCategory;

	/** 商品分類１：商品分類１を保持する */
	private String product1;

	/** 商品分類２：商品分類２を保持する */
	private String product2;
	
	/** 商品分類３：商品分類３を保持する */
	private String product3;
	
	/** 単位コード：単位コードを保持する */
	private String unitCategory;
	
	/** 重量：重量を保持する */
	private double weight;
	
	/** 重量単位：重量単位を保持する */
	private double weightUnitSizeCategory;

	/** 長さ：長さを保持する */
	private double length;
	
	/** 長さ単位：長さ単位を保持する */
	private double lengthtUnitSizeCategory;

	/** サイズ（幅）：サイズ（幅）を保持する */
	private double width;
	
	/** サイズ（幅）単位：サイズ（幅）単位を保持する */
	private String widthUnitSizeCategory;

	/** サイズ（奥）：サイズ（奥）を保持する */
	private double depth;

	/** サイズ（奥）単位：サイズ（奥）単位を保持する */
	private String depthUnitSizeCategory;	
	
	/** サイズ（高）：サイズ（高）を保持する */
	private double hight;
	
	/** サイズ（高）単位：サイズ（高）単位を保持する */
	private String hightUnitSizeCategory;

	/** 芯数：芯数を保持する */
	private String coreNum;
	
	/** 備考：備考を保持する */
	private String remarks;

	/** ピッキング備考：ピッキング備考を保持する */
	private String eadRemarks;
	
	/** コメント：コメントを保持する */
	private String commentData;
	
	
	/**
	 * 履歴のIDを取得する
	 * @return histID
	 */
	public int getHistID() {
		return histID;
	}
	/**
	 * 履歴のIDを設定する
	 * @param histID
	 */
	public void setHistID(int histID) {
		this.histID = histID;
	}
	
	/**
	 * アクションの種類（追加・変更・削除）を取得する
	 * @return actionType
	 */
	public String getActionType() {
		return actionType;
	}
	/**
	 * アクションの種類（追加・変更・削除）を設定する
	 * @param actionType
	 */
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	
	/**
	 * アクションのFunc（機能名）を取得する
	 * @return actionFunc
	 */
	public String getActionFunc() {
		return actionFunc;
	}
	/**
	 * アクションのFunc（機能名）を設定する
	 * @param actionFunc
	 */
	public void setActionFunc(String actionFunc) {
		this.actionFunc = actionFunc;
	}
	
	/**
	 * 操作した日時の情報を取得する
	 * @return recDatetm
	 */
	public Date getRecDatetm() {
		return recDatetm;
	}
	/**
	 * 操作した日時の情報を設定する
	 * @param recDatetm
	 */
	public void setRecDatetm(Date recDatetm) {
		this.recDatetm = recDatetm;
	}
	
	/**
	 * 操作したユーザーのIDを情報を保持する
	 * @return userID
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * 操作したユーザのIDを設定する
	 * @param userID
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	//商品の編集・追加のデータ
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductKana() {
		return productKana;
	}

	public void setProductKana(String productKana) {
		this.productKana = productKana;
	}

	public String getProductPcode() {
		return productPcode;
	}

	public void setProductPcode(String productPcode) {
		this.productPcode = productPcode;
	}

	public String getJanPcode() {
		return janPcode;
	}

	public void setJanPcode(String janPcode) {
		this.janPcode = janPcode;
	}

	public Date getDiscardDate() {
		return discardDate;
	}

	public void setDiscardDate(Date discardDate) {
		this.discardDate = discardDate;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierPcode() {
		return supplierPcode;
	}

	public void setSupplierPcode(String supplierPcode) {
		this.supplierPcode = supplierPcode;
	}

	public int getSupplierPriceYen() {
		return supplierPriceYen;
	}

	public void setSupplierPriceYen(int supplierPriceYen) {
		this.supplierPriceYen = supplierPriceYen;
	}

	public int getSupplierPriceDol() {
		return supplierPriceDol;
	}

	public void setSupplierPriceDol(int supplierPriceDol) {
		this.supplierPriceDol = supplierPriceDol;
	}

	public String getStockCtlCategory() {
		return stockCtlCategory;
	}

	public void setStockCtlCategory(String stockCtlCategory) {
		this.stockCtlCategory = stockCtlCategory;
	}

	public String getPackQuantity() {
		return packQuantity;
	}

	public void setPackQuantity(String packQuantity) {
		this.packQuantity = packQuantity;
	}

	public int getAvgShipCount() {
		return avgShipCount;
	}

	public void setAvgShipCount(int avgShipCount) {
		this.avgShipCount = avgShipCount;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public int getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(int leadTime) {
		this.leadTime = leadTime;
	}

	public int getPoNum() {
		return poNum;
	}

	public void setPoNum(int poNum) {
		this.poNum = poNum;
	}

	public short getPoUpdFlag() {
		return poUpdFlag;
	}

	public void setPoUpdFlag(short poUpdFlag) {
		this.poUpdFlag = poUpdFlag;
	}

	public int getMineSafetyStock() {
		return mineSafetyStock;
	}

	public void setMineSafetyStock(int mineSafetyStock) {
		this.mineSafetyStock = mineSafetyStock;
	}

	public short getMineSafetyStockUpdFlag() {
		return mineSafetyStockUpdFlag;
	}

	public void setMineSafetyStockUpdFlag(short mineSafetyStockUpdFlag) {
		this.mineSafetyStockUpdFlag = mineSafetyStockUpdFlag;
	}

	public BigDecimal getPoLot() {
		return poLot;
	}

	public void setPoLot(BigDecimal poLot) {
		this.poLot = poLot;
	}

	public short getLotUpdFlag() {
		return lotUpdFlag;
	}

	public void setLotUpdFlag(short lotUpdFlag) {
		this.lotUpdFlag = lotUpdFlag;
	}

	public int getMaxStockNum() {
		return maxStockNum;
	}

	public void setMaxStockNum(int maxStockNum) {
		this.maxStockNum = maxStockNum;
	}

	public int getStockUpdFlag() {
		return StockUpdFlag;
	}

	public void setStockUpdFlag(int stockUpdFlag) {
		StockUpdFlag = stockUpdFlag;
	}

	public int getMaxPoNum() {
		return maxPoNum;
	}

	public void setMaxPoNum(int maxPoNum) {
		this.maxPoNum = maxPoNum;
	}

	public short getMaxPoUpdFlag() {
		return maxPoUpdFlag;
	}

	public void setMaxPoUpdFlag(short maxPoUpdFlag) {
		this.maxPoUpdFlag = maxPoUpdFlag;
	}

	public short getRoMaxNum() {
		return roMaxNum;
	}

	public void setRoMaxNum(short roMaxNum) {
		this.roMaxNum = roMaxNum;
	}

	public BigDecimal getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}

	public String getDiscountId() {
		return discountId;
	}

	public void setDiscountId(String discountId) {
		this.discountId = discountId;
	}

	public String getProductStatusCategory() {
		return productStatusCategory;
	}

	public void setProductStatusCategory(String productStatusCategory) {
		this.productStatusCategory = productStatusCategory;
	}

	public String getProductStockCategory() {
		return productStockCategory;
	}

	public void setProductStockCategory(String productStockCategory) {
		this.productStockCategory = productStockCategory;
	}

	public String getProductPurvayCategory() {
		return productPurvayCategory;
	}

	public void setProductPurvayCategory(String productPurvayCategory) {
		this.productPurvayCategory = productPurvayCategory;
	}

	public String getProductStandardCategory() {
		return productStandardCategory;
	}

	public void setProductStandardCategory(String productStandardCategory) {
		this.productStandardCategory = productStandardCategory;
	}

	public BigDecimal getSoRate() {
		return soRate;
	}

	public void setSoRate(BigDecimal soRate) {
		this.soRate = soRate;
	}

	public int getSetTypeCategory() {
		return setTypeCategory;
	}

	public void setSetTypeCategory(int setTypeCategory) {
		this.setTypeCategory = setTypeCategory;
	}

	public String getProduct1() {
		return product1;
	}

	public void setProduct1(String product1) {
		this.product1 = product1;
	}

	public String getProduct2() {
		return product2;
	}

	public void setProduct2(String product2) {
		this.product2 = product2;
	}

	public String getProduct3() {
		return product3;
	}

	public void setProduct3(String product3) {
		this.product3 = product3;
	}

	public String getUnitCategory() {
		return unitCategory;
	}

	public void setUnitCategory(String unitCategory) {
		this.unitCategory = unitCategory;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWeightUnitSizeCategory() {
		return weightUnitSizeCategory;
	}

	public void setWeightUnitSizeCategory(double weightUnitSizeCategory) {
		this.weightUnitSizeCategory = weightUnitSizeCategory;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getLengthtUnitSizeCategory() {
		return lengthtUnitSizeCategory;
	}

	public void setLengthtUnitSizeCategory(double lengthtUnitSizeCategory) {
		this.lengthtUnitSizeCategory = lengthtUnitSizeCategory;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public String getWidthUnitSizeCategory() {
		return widthUnitSizeCategory;
	}

	public void setWidthUnitSizeCategory(String widthUnitSizeCategory) {
		this.widthUnitSizeCategory = widthUnitSizeCategory;
	}

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public String getDepthUnitSizeCategory() {
		return depthUnitSizeCategory;
	}

	public void setDepthUnitSizeCategory(String depthUnitSizeCategory) {
		this.depthUnitSizeCategory = depthUnitSizeCategory;
	}

	public double getHight() {
		return hight;
	}

	public void setHight(double hight) {
		this.hight = hight;
	}

	public String getHightUnitSizeCategory() {
		return hightUnitSizeCategory;
	}

	public void setHightUnitSizeCategory(String hightUnitSizeCategory) {
		this.hightUnitSizeCategory = hightUnitSizeCategory;
	}

	public String getCoreNum() {
		return coreNum;
	}

	public void setCoreNum(String coreNum) {
		this.coreNum = coreNum;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getEadRemarks() {
		return eadRemarks;
	}

	public void setEadRemarks(String eadRemarks) {
		this.eadRemarks = eadRemarks;
	}

	public String getCommentData() {
		return commentData;
	}

	public void setCommentData(String commentData) {
		this.commentData = commentData;
	}



}