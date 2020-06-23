package master.product.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.dao.BaseDAO;
import master.product.beans.ProductModifyBean;

public class ProductModifyDAO extends BaseDAO {
	
	/* è§ïiïœçXèÓïÒÇÃéÊìæÅ@*/
	 public int modifyProduct(ProductModifyBean bean) throws SQLException, ClassNotFoundException {
		 	Connection con;
		 	PreparedStatement stmt=null;
		 	int result = 0;	
		 	String  sql;
		 	
		 	con = super.getConnection();
		 	sql = " update  product_mst_xxxxx set PRODUCT_CODE = ? ," 
		 								+ "PRODUCT_NAME = ? ,"
		 								+ "PRODUCT_KANA = ? ," 
		 								+ "ONLINE_PCODE = ? ," 
		 								+ "SUPPLIER_PCODE = ? ,"  
		 								+ "SUPPLIER_CODE = ? ,"  
		 								+ "RACK_CODE = ? ," 
		 								+ "SUPPLIER_PRICE_YEN = ? ,"  
		 								+ "SUPPLIER_PRICE_DOL = ? ,"  
		 								+ "RETAIL_PRICE = ? ,"
		 								+ "SO_RATE = ? ," 
		 								+ "UNIT_CATEGORY = ? ," 
		 								+ "PACK_QUANTITY = ? ," 
		 								+ "JAN_PCODE = ? ,"
		 								+ "WIDTH = ?  ,"
		 								+ "WIDTH_UNIT_SIZE_CATEGORY = ? ,"
		 								+ "DEPTH = ? ,"
		 								+ "DEPTH_UNIT_SIZE_CATEGORY = ? ,"
		 								+ "HEIGHT = ? ,"
		 								+ "HEIGHT_UNIT_SIZE_CATEGORY = ? ,"
		 								+ "WEIGHT = ? ,"
		 								+ "WEIGHT_UNIT_SIZE_CATEGORY = ? ,"
		 								+ "LENGTH = ? ," 
		 								+ "LENGTH_UNIT_SIZE_CATEGORY = ? ,"
		 								+ "PO_LOT = ? ,"
		 								+ "LOT_UPD_FLAG = ? ,"
		 								+ "LEAD_TIME = ? ,"
		 								+ "PO_NUM = ? ,"
		 								+ "PO_UPD_FLAG = ? ,"
		 								+ "AVG_SHIP_COUNT = ? ,"
		 								+ "MAX_STOCK_NUM = ? ,"
		 								+ "STOCK_UPD_FLAG = ? ,"
		 								+ "TERM_SHIP_NUM = ? ,"
		 								+ "MAX_PO_NUM = ? ,"
		 								+ "MAX_PO_UPD_FLAG = ? ,"
		 								+ "FRACT_CATEGORY = ? ,"
		 								+ "TAX_CATEGORY = ? ,"
		 								+ "STOCK_CTL_CATEGORY = ? ,"
		 								+ "STOCK_ASSES_CATEGORY = ? ,"
		 								+ "PRODUCT_CATEGORY = ? ,"
		 								+ "PRODUCT_1 = ? ,"
		 								+ "PRODUCT_2 = ? ,"
		 								+ "PRODUCT_3 = ? ,"
		 								+ "RO_MAX_NUM = ? ,"
		 								+ "PRODUCT_RANK = ? ,"
		 								+ "SET_TYPE_CATEGORY = ? ,"
		 								+ "PRODUCT_STATUS_CATEGORY = ? ,"
		 								+ "PRODUCT_STOCK_CATEGORY = ? ,"
		 								+ "PRODUCT_PURVAY_CATEGORY = ? ,"
		 								+ "PRODUCT_STANDARD_CATEGORY = ? ,"
		 								+ "CORE_NUM = ? ,"
		 								+ "NUM_1 = ? ,"
		 								+ "NUM_2 = ? ,"
		 								+ "NUM_3 = ? ,"
		 								+ "NUM_4 = ? ,"
		 								+ "NUM_5 = ? ,"
		 								+ "DEC_1 = ? ,"
		 								+ "DEC_2 = ? ,"
		 								+ "DEC_3 = ? ,"
		 								+ "DEC_4 = ? ,"
		 								+ "DEC_5 = ? ,"
		 								+ "DISCARD_DATE = ? ,"
		 								+ "REMARKS = ? ,"
		 								+ "END REMARKS = ? ,"
		 								+ "COMMENT_DATA = ? ,"
		 								+ "LAST_RO_DATE = ? ,"
		 								+ "SALES_STANDARD_DEVIATION = ? ,"
		 								+ "MINE_SAFETY_STOCK = ? ,"
		 								+ "MINE_SAFETY_STOCK_UPD_FLAG = ? ,"
		 								+ "ENTRUST_SAFETY_STOCK = ? ,"
		 								+ "CRE_FUNC = ? ,"
		 								+ "CRE_DATETM = ? ,"
		 								+ "CRE_USER = ? ,"
		 								+ "UPD_FUNC = ? ,"
		 								+ "UPD_DATETM = ? ,"
		 								+ "UPD_USER = ? ,"
		 								+ "DEL_FUNC = ? ,"
		 								+ "DEL_DATETM = ? ," 
		 								+ "DEL_USER = ?"
		 								+ "where PRODUCT_CODE = ?";
		 	
		 	stmt = con.prepareStatement(sql);
		 	stmt.setString(1, bean.getProductCode());
		 	stmt.setString(2, bean.getProductName());
		 	stmt.setString(3, bean.getProductKana());
		 	stmt.setString(4, bean.getOnlinePcode());
		 	stmt.setString(5, bean.getSupplierPcode());
		 	stmt.setString(6, bean.getSupplierCode());
		 	stmt.setString(7, bean.getRackCode());
		 	stmt.setInt(8, bean.getSupplierPriceYen());
		 	stmt.setInt(9, bean.getSupplierPriceDol());
		 	stmt.setInt(10, bean.getRetailPrice());
		 	stmt.setInt(11, bean.getSoRate());
		 	stmt.setString(12, bean.getUnitCategory());
		 	stmt.setInt(13, bean.getPackQuantity());
		 	stmt.setString(14, bean.getJanPcode());
		 	stmt.setDouble(15, bean.getWidth());
		 	stmt.setString(16, bean.getWidthUnitSizeCategory());
		 	stmt.setDouble(17, bean.getDepth());
		 	stmt.setString(18, bean.getDepthUnitSizeCategory());
		 	stmt.setDouble(19, bean.getHeight());
		 	stmt.setString(20, bean.getHeightUnitSizeCategory());
		 	stmt.setDouble(21, bean.getWeight());
		 	stmt.setString(22, bean.getWeightUnitSizeCategory());
		 	stmt.setDouble(23, bean.getLength());
		 	stmt.setString(24, bean.getLengthUnitSizeCategory());
		 	stmt.setInt(25, bean.getPoLot());
		 	stmt.setInt(26, bean.getLotUpdFlag());
		 	stmt.setInt(27, bean.getLeadTime());
		 	stmt.setInt(28, bean.getPoNum());
		 	stmt.setInt(29, bean.getPoUpdFlag());
		 	stmt.setInt(30, bean.getAvgShipCount());
		 	stmt.setInt(31, bean.getMaxStockNum());
		 	stmt.setInt(32, bean.getStockUpdFlag());
		 	stmt.setInt(33, bean.getTermShipNum());
		 	stmt.setInt(34, bean.getMaxPoNum());
		 	stmt.setInt(35, bean.getMaxPoUpdNum());
		 	stmt.setString(36, bean.getFractCategory());
		 	stmt.setString(37, bean.getTaxCategory());
		 	stmt.setString(38, bean.getStockCtlCategory());
		 	stmt.setString(39, bean.getStockAssesCategory());
		 	stmt.setString(40, bean.getProductCategory());
		 	stmt.setString(41, bean.getProduct1());
		 	stmt.setString(42, bean.getProduct2());
		 	stmt.setString(43, bean.getProduct3());
		 	stmt.setInt(44, bean.getRoMaxNum());
		 	stmt.setString(45, bean.getProductRank());
		 	stmt.setString(46, bean.getSetTypeCategory());
		 	stmt.setString(47, bean.getProductStatusCategory());
		 	stmt.setString(48, bean.getProductStockCategory());
		 	stmt.setString(49, bean.getProductPurvayCategory());
		 	stmt.setString(50, bean.getProductStandardCategory());
		 	stmt.setString(51, bean.getCoreNum());
		 	stmt.setInt(52, bean.getNum1());
		 	stmt.setInt(53, bean.getNum2());
		 	stmt.setInt(54, bean.getNum3());
		 	stmt.setInt(55, bean.getNum4());
		 	stmt.setInt(56, bean.getNum5());
		 	stmt.setDouble(57, bean.getDec1());
		 	stmt.setDouble(58, bean.getDec2());
		 	stmt.setDouble(59, bean.getDec3());
		 	stmt.setDouble(60, bean.getDec4());
		 	stmt.setDouble(61, bean.getDec5());
		 	stmt.setDate(62, bean.getDiscardDate());
		 	stmt.setString(63, bean.getRemarks());
		 	stmt.setString(64, bean.getEndRemarks());
		 	stmt.setString(65, bean.getCommentData());
		 	stmt.setDate(66, bean.getLastRoDate());
		 	stmt.setInt(67, bean.getSalesStandardDeviation());
		 	stmt.setInt(68, bean.getMineSafetyStock());
		 	stmt.setInt(69, bean.getMineSafetyStockUpdFlag());
		 	stmt.setInt(70, bean.getEntrustSafetyStock());
		 	stmt.setString(71, bean.getCreFunc());
		 	stmt.setTimestamp(72, bean.getCreDatetm());
		 	stmt.setString(73, bean.getCreUser());
		 	stmt.setString(74, bean.getUpdFunc());
		 	stmt.setTimestamp(75, bean.getUpdDatetm());
		 	stmt.setString(76, bean.getUpdUser());
		 	stmt.setString(77, bean.getDelFunc());
		 	stmt.setTimestamp(78, bean.getDelDatetm());
		 	stmt.setString(79, bean.getDelUser());
		 	
		 	try{
		 		result = stmt.executeUpdate(sql);
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
