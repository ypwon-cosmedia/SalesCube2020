package master.product.beans;

import java.sql.*;
import java.math.*;

/**
 * ���i��ǉ�����<br>
 * �E���i�R�[�h���擾����<br>
 * �E���i�����擾����<br>
 * �E���i���J�i���擾����<br>
 * �E�I�����C���i�Ԃ��擾����<br>
 * �EJAN�R�[�h���擾����<br>
 * �E�p�ԗ\������擾����<br>
 * �E�d����R�[�h���擾����<br>
 * �E�d���於���擾����<br>
 * �E�d���揤�i�R�[�h��ݒ肷��<br>
 * �E�d���P���i�~�j��ݒ肷��<br>
 * �E�d���P���i�O�݁j��ݒ肷��<br>
 * �E�݌ɊǗ���ݒ肷��<br>
 * �E������ݒ肷��<br>
 * �E�����Ϗo�א���ݒ肷��<br>
 * �E�q�ɖ���ݒ肷��<br>
 * �E�I�Ԃ�ݒ肷��<br>
 * �E���[�h�^�C�����擾����<br>
 * �E�����_���擾����<br>
 * �E�����_�����X�V���擾����<br>
 * �E���Ј��S�݌ɐ����擾����<br>
 * �E���Ј��S�݌ɐ������X�V���擾����<br>
 * �E�������b�g���擾����<br>
 * �E�������b�g�����X�V���擾����<br>
 * �E�ő�ۗL�����擾����<br>
 * �E�ő�ۗL�������X�V���擾����<br>
 * �E�P�ʔ������x�����擾����<br>
 * �E�P�ʔ������x�������X�V���擾����<br>
 * �E�󒍌��x�����擾����<br>
 * �E���P�����擾����<br>
 * �E���ʊ�����ݒ肷��<br>
 * �E�󋵂�ݒ肷��<br>
 * �E�ۊǂ�ݒ肷��<br>
 * �E���B��ݒ肷��<br>
 * �E�W������ݒ肷��<br>
 * �E�����v�Z�|����ݒ肷��<br>
 * �E�Z�b�g��ݒ肷��<br>
 * �E�J�e�S���i��j��ݒ肷��<br>
 * �E�J�e�S���i���j��ݒ肷��<br>
 * �E�J�e�S���i���j���擾����<br>
 * �E�P�ʂ��擾����<br>
 * �E�d�ʂ��擾����<br>
 * �E�d�ʒP�ʂ��擾����<br>
 * �E�������擾����<br>
 * �E�����P�ʂ��擾����<br>
 * �E�T�C�Y�i���j���擾����<br>
 * �E�T�C�Y�i���j�P�ʂ��擾����<br>
 * �E�T�C�Y�i���j���擾����<br>
 * �E�T�C�Y�i���j�P�ʂ��擾����<br>
 * �E�T�C�Y�i���j���擾����<br>
 * �E�T�C�Y�i���j�P�ʂ��擾����<br>
 * �E�c�����擾����<br>
 * �E���l��ݒ肷��<br>
 * �E�s�b�L���O���l��ݒ肷��<br>
 * �E�R�����g��ݒ肷��<br>
�@* 
 * @author ����
 * @version 1.0
 */

public class ProductAddBean {
	/** ���i�R�[�h�F���i�R�[�h��ێ����� */
	private String productCode;

	/** ���i���F���i����ێ����� */
	private String productName;
	
	/** ���i���J�i�F���i���J�i��ێ����� */
	private String productKana;
	
	/** �I�����C���i�ԁF�I�����C���i�Ԃ�ێ����� */
	private String onlinePcode;
	
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
	private int packQuantity;
	
	/** ���Ϗo�א��F���Ϗo�א���ێ����� */
	private int avgShipCount;
	
	/** �q�ɖ��F�q�ɖ���ێ����� */
	private String warehouseName;
	
	/** �I�ԁF�I�Ԃ�ێ����� */
	private String rackCode;

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
	private String setTypeCategory;

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
	private String weightUnitSizeCategory;

	/** �����F������ێ����� */
	private double length;
	
	/** �����P�ʁF�����P�ʂ�ێ����� */
	private String lengthUnitSizeCategory;

	/** �T�C�Y�i���j�F�T�C�Y�i���j��ێ����� */
	private double width;
	
	/** �T�C�Y�i���j�P�ʁF�T�C�Y�i���j�P�ʂ�ێ����� */
	private String widthUnitSizeCategory;

	/** �T�C�Y�i���j�F�T�C�Y�i���j��ێ����� */
	private double depth;

	/** �T�C�Y�i���j�P�ʁF�T�C�Y�i���j�P�ʂ�ێ����� */
	private String depthUnitSizeCategory;	
	
	/** �T�C�Y�i���j�F�T�C�Y�i���j��ێ����� */
	private double height;
	
	/** �T�C�Y�i���j�P�ʁF�T�C�Y�i���j�P�ʂ�ێ����� */
	private String heightUnitSizeCategory;

	/** �c���F�c����ێ����� */
	private String coreNum;
	
	/** ���l�F���l��ێ����� */
	private String remarks;

	/** �s�b�L���O���l�F�s�b�L���O���l��ێ����� */
	private String eadRemarks;
	
	/** �R�����g�F�R�����g��ێ����� */
	private String commentData;
	
	
	private int termShipNum;
	private int maxPoUpdNum;
	private String fractCategory;
	private	String taxCategory;
	private String stockAssesCategory;
	private String productCategory;
	private String productRank;
	private int num1;
	private int num2;
	private int num3;
	private int num4;
	private int num5;
	private double dec1;
	private double dec2;
	private double dec3;
	private double dec4;
	private double dec5;
	private String endRemarks;
	private Date lastRoDate;
	private BigDecimal salesStandardDeviation;
	private int entrustSafetyStock;
	private String creFunc;
	private Timestamp creDatetm;
	private String creUser;
	private String updFunc;
	private Timestamp updDatetm;
	private String updUser;
	private String delFunc;
	private Timestamp delDatetm;
	private String delUser;
	
	
	
	
	
	
	

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
		return onlinePcode;
	}

	public void setProductPcode(String productPcode) {
		this.onlinePcode = productPcode;
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

	public int getPackQuantity() {
		return packQuantity;
	}

	public void setPackQuantity(int packQuantity) {
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

	public String getRackCode() {
		return rackCode;
	}

	public void setRackCode(String rackCode) {
		this.rackCode = rackCode;
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

	public String getSetTypeCategory() {
		return setTypeCategory;
	}

	public void setSetTypeCategory(String setTypeCategory) {
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

	public String getWeightUnitSizeCategory() {
		return weightUnitSizeCategory;
	}

	public void setWeightUnitSizeCategory(String weightUnitSizeCategory) {
		this.weightUnitSizeCategory = weightUnitSizeCategory;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public String getLengthUnitSizeCategory() {
		return lengthUnitSizeCategory;
	}

	public void setLengthtUnitSizeCategory(String lengthUnitSizeCategory) {
		this.lengthUnitSizeCategory = lengthUnitSizeCategory;
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
		return height;
	}

	public void setHight(double height) {
		this.height = height;
	}

	public String getHightUnitSizeCategory() {
		return heightUnitSizeCategory;
	}

	public void setHeightUnitSizeCategory(String heightUnitSizeCategory) {
		this.heightUnitSizeCategory = heightUnitSizeCategory;
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

	public String getOnlinePcode() {
		return onlinePcode;
	}

	public void setOnlinePcode(String onlinePcode) {
		this.onlinePcode = onlinePcode;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getTeamShipNum() {
		return termShipNum;
	}

	public void setTeamShipNum(int teamShipNum) {
		this.termShipNum = teamShipNum;
	}

	public int getMaxPoUpdNum() {
		return maxPoUpdNum;
	}

	public void setMaxPoUpdNum(int maxPoUpdNum) {
		this.maxPoUpdNum = maxPoUpdNum;
	}

	public String getFractCategory() {
		return fractCategory;
	}

	public void setFractCategory(String fractCategory) {
		this.fractCategory = fractCategory;
	}

	public String getTaxCategory() {
		return taxCategory;
	}

	public void setTaxCategory(String taxCategory) {
		this.taxCategory = taxCategory;
	}

	public String getStockAssesCategory() {
		return stockAssesCategory;
	}

	public void setStockAssesCategory(String stockAssesCategory) {
		this.stockAssesCategory = stockAssesCategory;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductRank() {
		return productRank;
	}

	public void setProductRank(String productRank) {
		this.productRank = productRank;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public int getNum3() {
		return num3;
	}

	public void setNum3(int num3) {
		this.num3 = num3;
	}

	public int getNum4() {
		return num4;
	}

	public void setNum4(int num4) {
		this.num4 = num4;
	}

	public int getNum5() {
		return num5;
	}

	public void setNum5(int num5) {
		this.num5 = num5;
	}

	public double getDec1() {
		return dec1;
	}

	public void setDec1(double dec1) {
		this.dec1 = dec1;
	}

	public double getDec2() {
		return dec2;
	}

	public void setDec2(double dec2) {
		this.dec2 = dec2;
	}

	public double getDec3() {
		return dec3;
	}

	public void setDec3(double dec3) {
		this.dec3 = dec3;
	}

	public double getDec4() {
		return dec4;
	}

	public void setDec4(double dec4) {
		this.dec4 = dec4;
	}

	public double getDec5() {
		return dec5;
	}

	public void setDec5(double dec5) {
		this.dec5 = dec5;
	}

	public String getEndRemarks() {
		return endRemarks;
	}

	public void setEndRemarks(String endRemarks) {
		this.endRemarks = endRemarks;
	}

	public Date getLastRoDate() {
		return lastRoDate;
	}

	public void setLastRoDate(Date lastRoDate) {
		this.lastRoDate = lastRoDate;
	}

	public BigDecimal getSalesStandardDevia() {
		return salesStandardDeviation;
	}

	public void setSalesStandardDevia(BigDecimal salesStandardDevia) {
		this.salesStandardDeviation = salesStandardDevia;
	}


	public int getEntrustSafetyStock() {
		return entrustSafetyStock;
	}

	public void setEntrustSafetyStock(int entrustSafetyStock) {
		this.entrustSafetyStock = entrustSafetyStock;
	}

	public String getCreFunc() {
		return creFunc;
	}

	public void setCreFunc(String creFunc) {
		this.creFunc = creFunc;
	}

	public Timestamp getCreDatetm() {
		return creDatetm;
	}

	public void setCreDatetm(Timestamp creDatetm) {
		this.creDatetm = creDatetm;
	}

	public String getCreUser() {
		return creUser;
	}

	public void setCreUser(String creUser) {
		this.creUser = creUser;
	}

	public String getUpdFunc() {
		return updFunc;
	}

	public void setUpdFunc(String updFunc) {
		this.updFunc = updFunc;
	}

	public Timestamp getUpdDatetm() {
		return updDatetm;
	}

	public void setUpdDatetm(Timestamp updDatetm) {
		this.updDatetm = updDatetm;
	}

	public String getUpdUser() {
		return updUser;
	}

	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}

	public String getDelFunc() {
		return delFunc;
	}

	public void setDelFunc(String delFunc) {
		this.delFunc = delFunc;
	}

	public Timestamp getDelDatetm() {
		return delDatetm;
	}

	public void setDelDatetm(Timestamp delDatetm) {
		this.delDatetm = delDatetm;
	}

	public String getDelUser() {
		return delUser;
	}

	public void setDelUser(String delUser) {
		this.delUser = delUser;
	}

	public String getHeightUnitSizeCategory() {
		return heightUnitSizeCategory;
	}
	
	

}
