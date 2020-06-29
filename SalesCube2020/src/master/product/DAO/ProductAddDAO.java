package master.product.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.dao.BaseDAO;
import master.product.beans.ProductAddBean;

public class ProductAddDAO extends BaseDAO {

	/* è§ïií«â¡èÓïÒÇÃéÊìæÅ@*/
	 public int addProduct(ProductAddBean bean) throws SQLException, ClassNotFoundException {
		 	Connection con;
		 	PreparedStatement stmt=null;
		 	int result = 0;	
		 	String  sql;
		 	
		 	con = super.getConnection();
		 	sql = " insert into product_mst_xxxxx(PRODUCT_CODE,PRODUCT_NAME,PRODUCT_KANA,ONLINE_PCODE,SUPPLIER_PCODE,SUPPLIER_CODE,RACK_CODE,SUPPLIER_PRICE_YEN,SUPPLIER_PRICE_DOL,RETAIL_PRICE,SO_RATE,UNIT_CATEGORY,PACK_QUANTITY,JAN_PCODE,WIDTH,WIDTH_UNIT_SIZE_CATEGORY,DEPTH,DEPTH_UNIT_SIZE_CATEGORY,HEIGHT,HEIGHT_UNIT_SIZE_CATEGORY,WEIGHT,WEIGHT_UNIT_SIZE_CATEGORY,LENGTH,LENGTH_UNIT_SIZE_CATEGORY,PO_LOT,LOT_UPD_FLAG,LEAD_TIME,PO_NUM,PO_UPD_FLAG,AVG_SHIP_COUNT,MAX_STOCK_NUM,STOCK_UPD_FLAG,TERM_SHIP_NUM,MAX_PO_NUM,MAX_PO_UPD_FLAG,FRACT_CATEGORY,TAX_CATEGORY,STOCK_CTL_CATEGORY,STOCK_ASSES_CATEGORY,PRODUCT_CATEGORY,PRODUCT_1,PRODUCT_2,PRODUCT_3,RO_MAX_NUM,PRODUCT_RANK,SET_TYPE_CATEGORY,PRODUCT_STATUS_CATEGORY,PRODUCT_STOCK_CATEGORY,PRODUCT_PURVAY_CATEGORY,PRODUCT_STANDARD_CATEGORY,CORE_NUM,NUM_1,NUM_2,NUM_3,NUM_4,NUM_5,DEC_1,DEC_2,DEC_3,DEC_4,DEC_5,DISCARD_DATE,REMARKS,EAD_REMARKS,COMMENT_DATA,LAST_RO_DATE,SALES_STANDARD_DEVIATION,MINE_SAFETY_STOCK,MINE_SAFETY_STOCK_UPD_FLAG,ENTRUST_SAFETY_STOCK,CRE_FUNC,CRE_DATETM,CRE_USER,UPD_FUNC,UPD_DATETM,UPD_USER,DEL_FUNC,DEL_DATETM,DEL_USER) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 	
//		 	sql = "insert into product_mst_xxxxx(PRODUCT_CODE,PRODUCT_NAME,SUPPLIER_PRICE_YEN) values ( ? , ? , ? )";
		 	stmt = con.prepareStatement(sql);
		 	
//		 	stmt.setString(1, bean.getProductCode());
//		 	stmt.setString(2, bean.getProductName());
//		 	stmt.setInt(3, Integer.parseInt(bean.getSupplierPriceYen()));
		 	
		 	
		 	
		 	stmt.setString(1, bean.getProductCode());
		 	stmt.setString(2, bean.getProductName());
		 	stmt.setString(3, bean.getProductKana());
		 	stmt.setString(4, bean.getOnlinePcode());
		 	stmt.setString(5, bean.getSupplierPcode());
		 	stmt.setString(6, bean.getSupplierCode());
		 	stmt.setString(7, bean.getRackCode());
		 	
		 	if(bean.getSupplierPriceYen() == null) {
		 		stmt.setNull(8,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(8, Integer.parseInt(bean.getSupplierPriceYen()));
		 	}
		 	
		 	
		 	if(bean.getSupplierPriceDol() == null) {
		 		stmt.setNull(9,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(9, Integer.parseInt(bean.getSupplierPriceDol()));
		 	}
		 	
		 	
		 	if(bean.getRetailPrice() == null) {
		 		stmt.setNull(10,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(10, Integer.parseInt(bean.getRetailPrice()));
		 	}
		 			 	
		 	if(bean.getSoRate() == null) {
		 		stmt.setNull(11,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(11, Integer.parseInt(bean.getSoRate()));
		 	}
		 	
		 	
		 	stmt.setString(12, bean.getUnitCategory());
		 	
		 	if(bean.getPackQuantity() == null) {
		 		stmt.setNull(13,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(13, Integer.parseInt(bean.getPackQuantity()));
		 	}
		 	
		 	stmt.setString(14, bean.getJanPcode());
		 	
		 	if(bean.getWidth() == null) {
		 		stmt.setNull(15,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(15, Integer.parseInt(bean.getWidth()));
		 	}
		 	
		 	stmt.setString(16, bean.getWidthUnitSizeCategory());
		 	
		 	if(bean.getDepth() == null) {
		 		stmt.setNull(17,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(17, Integer.parseInt(bean.getDepth()));
		 	}
		 	
		 	stmt.setString(18, bean.getDepthUnitSizeCategory());
		 	
		 	if(bean.getHeight() == null) {
		 		stmt.setNull(19,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(19, Integer.parseInt(bean.getHeight()));
		 	}
		 	
		 	stmt.setString(20, bean.getHeightUnitSizeCategory());
		 	
		 	if(bean.getWeight() == null) {
		 		stmt.setNull(21,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(21, Integer.parseInt(bean.getWeight()));
		 	}
		
		 	
		 	stmt.setString(22, bean.getWeightUnitSizeCategory());
		 	
		 	if(bean.getLength() == null) {
		 		stmt.setNull(23,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(23, Integer.parseInt(bean.getLength()));
		 	}
		 	
		 	
		 	stmt.setString(24, bean.getLengthUnitSizeCategory());
		 	
		 	if(bean.getPoLot() == null) {
		 		stmt.setNull(25,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(25, Integer.parseInt(bean.getPoLot()));
		 	}
		 	
		 	
		 	if(bean.getLotUpdFlag() == null) {
		 		stmt.setNull(26,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(26, Integer.parseInt(bean.getLotUpdFlag()));
		 	}
		 	
		 	
		 	if(bean.getLeadTime() == null) {
		 		stmt.setNull(27,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(27, Integer.parseInt(bean.getLeadTime()));
		 	}
		 	
		 	
		 	if(bean.getPoNum() == null) {
		 		stmt.setNull(28,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(28, Integer.parseInt(bean.getPoNum()));
		 	}
		 	
		 	
		 	if(bean.getPoUpdFlag() == null) {
		 		stmt.setNull(29,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(29, Integer.parseInt(bean.getPoUpdFlag()));
		 	}
		 	
		 	
		 	if(bean.getAvgShipCount() == null) {
		 		stmt.setNull(30,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(30, Integer.parseInt(bean.getAvgShipCount()));
		 	}
		 	
		 	
		 	if(bean.getMaxStockNum() == null) {
		 		stmt.setNull(31,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(31, Integer.parseInt(bean.getMaxStockNum()));
		 	}
		 	
		 	
		 	if(bean.getStockUpdFlag() == null) {
		 		stmt.setNull(32,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(32, Integer.parseInt(bean.getStockUpdFlag()));
		 	}
		 	
		 	
		 	if(bean.getTermShipNum() == null) {
		 		stmt.setNull(33,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(33, Integer.parseInt(bean.getTermShipNum()));
		 	}
		 	
		 	
		 	if(bean.getMaxPoNum() == null) {
		 		stmt.setNull(34,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(34, Integer.parseInt(bean.getMaxPoNum()));
		 	}
		 	
		 	
		 	if(bean.getMaxPoUpdFlag() == null) {
		 		stmt.setNull(35,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(35, Integer.parseInt(bean.getMaxPoUpdFlag()));
		 	}
		 	
		 	stmt.setString(36, bean.getFractCategory());
		 	stmt.setString(37, bean.getTaxCategory());
		 	stmt.setString(38, bean.getStockCtlCategory());
		 	stmt.setString(39, bean.getStockAssesCategory());
		 	stmt.setString(40, bean.getProductCategory());
		 	stmt.setString(41, bean.getProduct1());
		 	stmt.setString(42, bean.getProduct2());
		 	stmt.setString(43, bean.getProduct3());
		 	
		 	if(bean.getRoMaxNum() == null) {
		 		stmt.setNull(44,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(44, Integer.parseInt(bean.getRoMaxNum()));
		 	}
		 	
		 	stmt.setString(45, bean.getProductRank());
		 	stmt.setString(46, bean.getSetTypeCategory());
		 	stmt.setString(47, bean.getProductStatusCategory());
		 	stmt.setString(48, bean.getProductStockCategory());
		 	stmt.setString(49, bean.getProductPurvayCategory());
		 	stmt.setString(50, bean.getProductStandardCategory());
		 	stmt.setString(51, bean.getCoreNum());
		 	
		 	if(bean.getNum1() == null) {
		 		stmt.setNull(52,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(52, Integer.parseInt(bean.getNum1()));
		 	}
		 	
		 	
		 	if(bean.getNum2() == null) {
		 		stmt.setNull(53,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(53, Integer.parseInt(bean.getNum2()));
		 	}
		 	
		 	
		 	if(bean.getNum3() == null) {
		 		stmt.setNull(54,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(54, Integer.parseInt(bean.getNum3()));
		 	}
		 	
		 	
		 	if(bean.getNum4() == null) {
		 		stmt.setNull(55,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(55, Integer.parseInt(bean.getNum4()));
		 	}
		 	
		 	
		 	if(bean.getNum5() == null) {
		 		stmt.setNull(56,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(56, Integer.parseInt(bean.getNum5()));
		 	}
		 	
		 	
		 	if(bean.getDec1() == null) {
		 		stmt.setNull(57,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(57, Integer.parseInt(bean.getDec1()));
		 	}
		 	
		 	
		 	if(bean.getDec2() == null) {
		 		stmt.setNull(58,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(58, Integer.parseInt(bean.getDec2()));
		 	}
		 	
		 	
		 	if(bean.getDec3() == null) {
		 		stmt.setNull(59,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(59, Integer.parseInt(bean.getDec3()));
		 	}
		 	
		 	
		 	if(bean.getDec4() == null) {
		 		stmt.setNull(60,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(60, Integer.parseInt(bean.getDec4()));
		 	}
		 	
		 	
		 	if(bean.getDec5() == null) {
		 		stmt.setNull(61,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(61, Integer.parseInt(bean.getDec5()));
		 	}
		 	
		 	stmt.setString(62, bean.getDiscardDate());
		 	stmt.setString(63, bean.getRemarks());
		 	stmt.setString(64, bean.getEadRemarks());
		 	stmt.setString(65, bean.getCommentData());
		 	stmt.setString(66, bean.getLastRoDate());
		 	
		 	if(bean.getSalesStandardDeviation() == null) {
		 		stmt.setNull(67,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(67, Integer.parseInt(bean.getSalesStandardDeviation()));
		 	}
		 	
		 	
		 	if(bean.getMineSafetyStock() == null) {
		 		stmt.setNull(68,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(68, Integer.parseInt(bean.getMineSafetyStock()));
		 	}
		 	
		 	
		 	if(bean.getMineSafetyStockUpdFlag() == null) {
		 		stmt.setNull(69,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(69, Integer.parseInt(bean.getMineSafetyStockUpdFlag()));
		 	}
		 	
		 	
		 	if(bean.getEntrustSafetyStock() == null) {
		 		stmt.setNull(70,java.sql.Types.NULL);
		 		
		 	}else {
		 		stmt.setInt(70, Integer.parseInt(bean.getEntrustSafetyStock()));
		 	}
		 	
		 	stmt.setString(71, bean.getCreFunc());
		 	stmt.setString(72, bean.getCreDatetm());
		 	stmt.setString(73, bean.getCreUser());
		 	stmt.setString(74, bean.getUpdFunc());
		 	stmt.setString(75, bean.getUpdDatetm());
		 	stmt.setString(76, bean.getUpdUser());
		 	stmt.setString(77, bean.getDelFunc());
		 	stmt.setString(78, bean.getDelDatetm());
		 	stmt.setString(79, bean.getDelUser());
		 	
		 	
		 	try{
		 		result = stmt.executeUpdate();
		 		System.out.println("í«â¡äÆóπ");
		 		con.commit();
		 	}catch (SQLException e) {
		 		e.printStackTrace();
		 		result = 0;
		 	}finally {
		 		super.releaseDB(con,stmt);
		 	}
		 	
		 	return result;
		 }
}