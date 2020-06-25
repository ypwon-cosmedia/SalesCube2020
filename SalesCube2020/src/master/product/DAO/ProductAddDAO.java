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
		 	sql = " insert into product_mst_xxxxx values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
		 	stmt.setInt(8, Integer.parseInt(bean.getSupplierPriceYen()));
		 	stmt.setInt(9, Integer.parseInt(bean.getSupplierPriceDol()));
		 	stmt.setInt(10, Integer.parseInt(bean.getRetailPrice()));
		 	stmt.setInt(11, Integer.parseInt(bean.getSoRate()));
		 	stmt.setString(12, bean.getUnitCategory());
		 	stmt.setInt(13, Integer.parseInt(bean.getPackQuantity()));
		 	stmt.setString(14, bean.getJanPcode());
		 	stmt.setInt(15, Integer.parseInt(bean.getWidth()));
		 	stmt.setString(16, bean.getWidthUnitSizeCategory());
		 	stmt.setInt(17, Integer.parseInt(bean.getDepth()));
		 	stmt.setString(18, bean.getDepthUnitSizeCategory());
		 	stmt.setInt(19, Integer.parseInt(bean.getHeight()));
		 	stmt.setString(20, bean.getHeightUnitSizeCategory());
		 	stmt.setInt(21, Integer.parseInt(bean.getWeight()));
		 	stmt.setString(22, bean.getWeightUnitSizeCategory());
		 	stmt.setInt(23, Integer.parseInt(bean.getLength()));
		 	stmt.setString(24, bean.getLengthUnitSizeCategory());
		 	stmt.setInt(25, Integer.parseInt(bean.getPoLot()));
		 	stmt.setInt(26, Integer.parseInt(bean.getLotUpdFlag()));
		 	stmt.setInt(27, Integer.parseInt(bean.getLeadTime()));
		 	stmt.setInt(28, Integer.parseInt(bean.getPoNum()));
		 	stmt.setInt(29, Integer.parseInt(bean.getPoUpdFlag()));
		 	stmt.setInt(30, Integer.parseInt(bean.getAvgShipCount()));
		 	stmt.setInt(31, Integer.parseInt(bean.getMaxStockNum()));
		 	stmt.setInt(32, Integer.parseInt(bean.getStockUpdFlag()));
		 	stmt.setInt(33, Integer.parseInt(bean.getTermShipNum()));
		 	stmt.setInt(34, Integer.parseInt(bean.getMaxPoNum()));
		 	stmt.setInt(35, Integer.parseInt(bean.getMaxPoUpdFlag()));
		 	stmt.setString(36, bean.getFractCategory());
		 	stmt.setString(37, bean.getTaxCategory());
		 	stmt.setString(38, bean.getStockCtlCategory());
		 	stmt.setString(39, bean.getStockAssesCategory());
		 	stmt.setString(40, bean.getProductCategory());
		 	stmt.setString(41, bean.getProduct1());
		 	stmt.setString(42, bean.getProduct2());
		 	stmt.setString(43, bean.getProduct3());
		 	stmt.setInt(44, Integer.parseInt(bean.getRoMaxNum()));
		 	stmt.setString(45, bean.getProductRank());
		 	stmt.setString(46, bean.getSetTypeCategory());
		 	stmt.setString(47, bean.getProductStatusCategory());
		 	stmt.setString(48, bean.getProductStockCategory());
		 	stmt.setString(49, bean.getProductPurvayCategory());
		 	stmt.setString(50, bean.getProductStandardCategory());
		 	stmt.setString(51, bean.getCoreNum());
		 	stmt.setInt(52, Integer.parseInt(bean.getNum1()));
		 	stmt.setInt(53, Integer.parseInt(bean.getNum2()));
		 	stmt.setInt(54, Integer.parseInt(bean.getNum3()));
		 	stmt.setInt(55, Integer.parseInt(bean.getNum4()));
		 	stmt.setInt(56, Integer.parseInt(bean.getNum5()));
		 	stmt.setInt(57, Integer.parseInt(bean.getDec1()));
		 	stmt.setInt(58, Integer.parseInt(bean.getDec2()));
		 	stmt.setInt(59, Integer.parseInt(bean.getDec3()));
		 	stmt.setInt(60, Integer.parseInt(bean.getDec4()));
		 	stmt.setInt(61, Integer.parseInt(bean.getDec5()));
		 	stmt.setString(62, bean.getDiscardDate());
		 	stmt.setString(63, bean.getRemarks());
		 	stmt.setString(64, bean.getEndRemarks());
		 	stmt.setString(65, bean.getCommentData());
		 	stmt.setString(66, bean.getLastRoDate());
		 	stmt.setInt(67, Integer.parseInt(bean.getSalesStandardDeviation()));
		 	stmt.setInt(68, Integer.parseInt(bean.getMineSafetyStock()));
		 	stmt.setInt(69, Integer.parseInt(bean.getMineSafetyStockUpdFlag()));
		 	stmt.setInt(70, Integer.parseInt(bean.getEntrustSafetyStock()));
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