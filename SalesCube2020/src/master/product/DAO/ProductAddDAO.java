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
		 	sql = " insert into product_mst_xxxxx value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 	stmt = con.prepareStatement(sql);
		 	stmt.setString(1, bean.getProductCode());
		 	stmt.setString(2, bean.getProductName());
		 	stmt.setString(3, bean.getProductKana());
		 	stmt.setString(4, bean.getOnlinePcode());
		 	stmt.setString(5, bean.getSupplierPcode());
		 	stmt.setString(6, bean.getSupplierCode());
		 	stmt.setString(7, bean.getRackCode());
		 	stmt.setString(8, bean.getSupplierPriceYen());
		 	stmt.setString(9, bean.getSupplierPriceDol());
		 	stmt.setString(10, bean.getRetailPrice());
		 	stmt.setString(11, bean.getSoRate());
		 	stmt.setString(12, bean.getUnitCategory());
		 	stmt.setString(13, bean.getPackQuantity());
		 	stmt.setString(14, bean.getJanPcode());
		 	stmt.setString(15, bean.getWidth());
		 	stmt.setString(16, bean.getWidthUnitSizeCategory());
		 	stmt.setString(17, bean.getDepth());
		 	stmt.setString(18, bean.getDepthUnitSizeCategory());
		 	stmt.setString(19, bean.getHeight());
		 	stmt.setString(20, bean.getHeightUnitSizeCategory());
		 	stmt.setString(21, bean.getWeight());
		 	stmt.setString(22, bean.getWeightUnitSizeCategory());
		 	stmt.setString(23, bean.getLength());
		 	stmt.setString(24, bean.getLengthUnitSizeCategory());
		 	stmt.setString(25, bean.getPoLot());
		 	stmt.setString(26, bean.getLotUpdFlag());
		 	stmt.setString(27, bean.getLeadTime());
		 	stmt.setString(28, bean.getPoNum());
		 	stmt.setString(29, bean.getPoUpdFlag());
		 	stmt.setString(30, bean.getAvgShipCount());
		 	stmt.setString(31, bean.getMaxStockNum());
		 	stmt.setString(32, bean.getStockUpdFlag());
		 	stmt.setString(33, bean.getTermShipNum());
		 	stmt.setString(34, bean.getMaxPoNum());
		 	stmt.setString(35, bean.getMaxPoUpdNum());
		 	stmt.setString(36, bean.getFractCategory());
		 	stmt.setString(37, bean.getTaxCategory());
		 	stmt.setString(38, bean.getStockCtlCategory());
		 	stmt.setString(39, bean.getStockAssesCategory());
		 	stmt.setString(40, bean.getProductCategory());
		 	stmt.setString(41, bean.getProduct1());
		 	stmt.setString(42, bean.getProduct2());
		 	stmt.setString(43, bean.getProduct3());
		 	stmt.setString(44, bean.getRoMaxNum());
		 	stmt.setString(45, bean.getProductRank());
		 	stmt.setString(46, bean.getSetTypeCategory());
		 	stmt.setString(47, bean.getProductStatusCategory());
		 	stmt.setString(48, bean.getProductStockCategory());
		 	stmt.setString(49, bean.getProductPurvayCategory());
		 	stmt.setString(50, bean.getProductStandardCategory());
		 	stmt.setString(51, bean.getCoreNum());
		 	stmt.setString(52, bean.getNum1());
		 	stmt.setString(53, bean.getNum2());
		 	stmt.setString(54, bean.getNum3());
		 	stmt.setString(55, bean.getNum4());
		 	stmt.setString(56, bean.getNum5());
		 	stmt.setString(57, bean.getDec1());
		 	stmt.setString(58, bean.getDec2());
		 	stmt.setString(59, bean.getDec3());
		 	stmt.setString(60, bean.getDec4());
		 	stmt.setString(61, bean.getDec5());
		 	stmt.setString(62, bean.getDiscardDate());
		 	stmt.setString(63, bean.getRemarks());
		 	stmt.setString(64, bean.getEndRemarks());
		 	stmt.setString(65, bean.getCommentData());
		 	stmt.setString(66, bean.getLastRoDate());
		 	stmt.setString(67, bean.getSalesStandardDeviation());
		 	stmt.setString(68, bean.getMineSafetyStock());
		 	stmt.setString(69, bean.getMineSafetyStockUpdFlag());
		 	stmt.setString(70, bean.getEntrustSafetyStock());
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