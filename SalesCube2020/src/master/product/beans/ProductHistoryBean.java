package master.product.beans;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ���i�̗�������ێ�����
 * @author komori
 *
 */

public class ProductHistoryBean {
	/** ����ID�F �����̏���ێ�����*/
	private int histID;
	
	/** �A�N�V�����̎�ށi�ǉ��E�ύX�E�폜�j�̏���ێ�����*/
	private String actionType;
	
	/** �A�N�V������Func�i�@�\���j��ێ�����*/
	private String actionFunc;
	
	/**���삵�������̏���ێ�����*/
	private Date recDatetm;
	
	/**���삵�����[�U��ID��ێ�����*/
	private String userID;
	
	//���i�̕ҏW�E�ǉ��̃f�[�^
	/** ���i�R�[�h�F���i�R�[�h��ێ����� */
	private String productCode;

	/** ���i���F���i����ێ����� */
	private String productName;
	
	/** ���i���J�i�F���i���J�i��ێ����� */
	private String productKana;
	
	/** �I�����C���i�ԁF�I�����C���i�Ԃ�ێ����� */
	private String productPcode;
	
	/** JAN�R�[�h�FJAN�R�[�h��ێ����� */
	private String janPcode;
	
	/** �p�����F�p������ێ����� */
	private Date discardDate;
	
	/** �d����R�[�h�F�d����R�[�h��ێ����� */
	private String supplierCode;
	
	/** �d���於�F�d���於��ێ����� */
	private String supplierName;

	/** �d����i�ԁF�d����i�Ԃ�ێ����� */
	private String supplierPcode;
	
	/** �d���P���i�~�j�F�d���P���i�~�j��ێ����� */
	private int supplierPriceYen;
	
	/** �d���P���i�O�݁j�F�d���P���i�O�݁j��ێ����� */
	private int supplierPriceDol;

	/** �݌ɊǗ��敪�F�݌ɊǗ��敪��ێ����� */
	private String stockCtlCategory;
	
	/** �����F������ێ����� */
	private String packQuantity;
	
	/** ���Ϗo�א��F���Ϗo�א���ێ����� */
	private int avgShipCount;
	
	/** �q�ɖ��F�q�ɖ���ێ����� */
	private String warehouseName;
	
	/** �I�ԁF�I�Ԃ�ێ����� */
	private String rankName;

	/** ���[�h�^�C���F���[�h�^�C����ێ����� */
	private int leadTime;

	/** �����_�F�����_��ێ����� */
	private int poNum;
	
	/** �����_�����X�V�F�����_�����X�V��ێ����� */
	private short poUpdFlag;

	/** ���Ј��S�݌ɐ��F���Ј��S�݌ɐ���ێ����� */
	private int mineSafetyStock;
	
	/** ���Ј��S�݌ɐ������X�V�F���Ј��S�݌ɐ������X�V��ێ����� */
	private short mineSafetyStockUpdFlag;

	/** �������b�g�F�������b�g��ێ����� */
	private BigDecimal poLot;
	
	/** �������b�g�����X�V�F�������b�g�����X�V��ێ����� */
	private short lotUpdFlag;

	/** �݌Ɍ��x���F�݌Ɍ��x����ێ����� */
	private int maxStockNum;
	
	/** �݌Ɍ��x�������X�V�F�݌Ɍ��x�������X�V��ێ����� */
	private int StockUpdFlag;

	/** �������x���F�������x����ێ����� */
	private int maxPoNum;
	
	/** �������x�������X�V�F�������x�������X�V��ێ����� */
	private short maxPoUpdFlag;

	/** �󒍌��x���F�󒍌��x����ێ����� */
	private short roMaxNum;
	
	/** ���F����ێ����� */
	private BigDecimal retailPrice;
	
	/** �����R�[�h�F�����R�[�h��ێ����� */
	private String discountId;
	
	/** ���ޏ󋵁F���ޏ󋵂�ێ����� */
	private String productStatusCategory;
	
	/** ���ޕۊǁF���ޕۊǂ�ێ����� */
	private String productStockCategory;
	
	/** ���ޒ��B�F���ޒ��B��ێ����� */
	private String productPurvayCategory;
	
	/** ���ޕW���F���ޕW����ێ����� */
	private String productStandardCategory;
	
	/** �����i�|���F�����i�|����ێ����� */
	private BigDecimal soRate;

	/** �Z�b�g���i�t���O�F�Z�b�g���i�t���O��ێ����� */
	private int setTypeCategory;

	/** ���i���ނP�F���i���ނP��ێ����� */
	private String product1;

	/** ���i���ނQ�F���i���ނQ��ێ����� */
	private String product2;
	
	/** ���i���ނR�F���i���ނR��ێ����� */
	private String product3;
	
	/** �P�ʃR�[�h�F�P�ʃR�[�h��ێ����� */
	private String unitCategory;
	
	/** �d�ʁF�d�ʂ�ێ����� */
	private double weight;
	
	/** �d�ʒP�ʁF�d�ʒP�ʂ�ێ����� */
	private double weightUnitSizeCategory;

	/** �����F������ێ����� */
	private double length;
	
	/** �����P�ʁF�����P�ʂ�ێ����� */
	private double lengthtUnitSizeCategory;

	/** �T�C�Y�i���j�F�T�C�Y�i���j��ێ����� */
	private double width;
	
	/** �T�C�Y�i���j�P�ʁF�T�C�Y�i���j�P�ʂ�ێ����� */
	private String widthUnitSizeCategory;

	/** �T�C�Y�i���j�F�T�C�Y�i���j��ێ����� */
	private double depth;

	/** �T�C�Y�i���j�P�ʁF�T�C�Y�i���j�P�ʂ�ێ����� */
	private String depthUnitSizeCategory;	
	
	/** �T�C�Y�i���j�F�T�C�Y�i���j��ێ����� */
	private double hight;
	
	/** �T�C�Y�i���j�P�ʁF�T�C�Y�i���j�P�ʂ�ێ����� */
	private String hightUnitSizeCategory;

	/** �c���F�c����ێ����� */
	private String coreNum;
	
	/** ���l�F���l��ێ����� */
	private String remarks;

	/** �s�b�L���O���l�F�s�b�L���O���l��ێ����� */
	private String eadRemarks;
	
	/** �R�����g�F�R�����g��ێ����� */
	private String commentData;
	
	
	/**
	 * ������ID���擾����
	 * @return histID
	 */
	public int getHistID() {
		return histID;
	}
	/**
	 * ������ID��ݒ肷��
	 * @param histID
	 */
	public void setHistID(int histID) {
		this.histID = histID;
	}
	
	/**
	 * �A�N�V�����̎�ށi�ǉ��E�ύX�E�폜�j���擾����
	 * @return actionType
	 */
	public String getActionType() {
		return actionType;
	}
	/**
	 * �A�N�V�����̎�ށi�ǉ��E�ύX�E�폜�j��ݒ肷��
	 * @param actionType
	 */
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	
	/**
	 * �A�N�V������Func�i�@�\���j���擾����
	 * @return actionFunc
	 */
	public String getActionFunc() {
		return actionFunc;
	}
	/**
	 * �A�N�V������Func�i�@�\���j��ݒ肷��
	 * @param actionFunc
	 */
	public void setActionFunc(String actionFunc) {
		this.actionFunc = actionFunc;
	}
	
	/**
	 * ���삵�������̏����擾����
	 * @return recDatetm
	 */
	public Date getRecDatetm() {
		return recDatetm;
	}
	/**
	 * ���삵�������̏���ݒ肷��
	 * @param recDatetm
	 */
	public void setRecDatetm(Date recDatetm) {
		this.recDatetm = recDatetm;
	}
	
	/**
	 * ���삵�����[�U�[��ID������ێ�����
	 * @return userID
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * ���삵�����[�U��ID��ݒ肷��
	 * @param userID
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	//���i�̕ҏW�E�ǉ��̃f�[�^
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