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
//		 	sql = " update  product_mst_xxxxx set PRODUCT_CODE = ?" + 
		 			"				    PRODUCT_NAME = ?"','" + 
		 			"				    PRODUCT_KANA = ?, + 
		 			"				    ONLINE_PCODE = ?, + 
		 			"				    SUPPLIER_PCODE = ?, + 
		 			"				    SUPPLIER_CODE = ?, + 
		 			"				    RACK_CODE = ?, + 
		 			"				    SUPPLIER_PRICE_YEN = ?, + 
		 			"				    SUPPLIER_PRICE_DOL = ?, + 
		 			"				    RETAIL_PRICE = ?, + 
		 			"				    SO_RATE = ?, + 
		 			"				    UNIT_CATEGORY = ?, + 
		 			"				    PACK_QUANTITY = ?, + 
		 			"				    JAN_PCODE = ?, + 
		 			"				    WIDTH = ?,\r\n" + 
		 			"				    WIDTH_UNIT_SIZE_CATEGORY = ?, + 
		 			"				    DEPTH = ?,\r\n" + 
		 			"				    DEPTH_UNIT_SIZE_CATEGORY = ?, + 
		 			"				    HEIGHT = ?,\r\n" + 
		 			"				    HEIGHT_UNIT_SIZE_CATEGORY = ?, + 
		 			"				    WEIGHT = ?,\r\n" + 
		 			"				    WEIGHT_UNIT_SIZE_CATEGORY = ?, + 
		 			"				    LENGTH = ?,\r\n" + 
		 			"				    LENGTH_UNIT_SIZE_CATEGORY = ?, + 
		 			"				    PO_LOT = ?, + 
		 			"				    LOT_UPD_FLAG = ?, + 
		 			"				    LEAD_TIME = ?, + 
		 			"				    PO_NUM = ?, + 
		 			"				    PO_UPD_FLAG = ?, + 
		 			"				    AVG_SHIP_COUNT = ?, + 
		 			"				    MAX_STOCK_NUM = ?, + 
		 			"				    STOCK_UPD_FLAG = ?, + 
		 			"				    TEAM_SHIP_NUM = ?, + 
		 			"				    MAX_PO_NUM = ?, + 
		 			"				    MAX_PO_UPD_FLAG = ?, + 
		 			"				    FRACT_CATEGORY = ?, + 
		 			"				    TAX_CATEGORY = ?, + 
		 			"				    STOCK_CTL_CATEGORY = ?, + 
		 			"				    STOCK_ASSES_CATEGORY = ?, + 
		 			"				    PRODUCT_CATEGORY = ?, + 
		 			"				    PRODUCT_1 = ?, + 
		 			"				    PRODUCT_2 = ?, + 
		 			"				    PRODUCT_3 = ?, + 
		 			"				    RO_MAX_NUM = ?, + 
		 			"		  		    PRODUCT_RANK = ?, + 
		 			"				    SET_TYPE_CATEGORY = ?, + 
		 			"				    PRODUCT_STATUS_CATEGORY = ?, +
		 			"				    PRODUCT_STOCK_CATEGORY = ?, + 
		 			"				    PRODUCT_PURVAY_CATEGORY = ?, + 
		 			"				    PRODUCT_STANDARD_CATEGORY = ?, + 
		 			"				    CORE_NUM = ?, + 
		 			"				    NUM_1 = ?, + 
		 			"				    NUM_2 = ?, + 
		 			"				    NUM_3 = ?, + 
		 			"				    NUM_4 = ?, + 
		 			"				    NUM_5 = ?, + 
		 			"				    DEC_1 = ?, + 
		 			"				    DEC_2 = ?, + 
		 			"				    DEC_3 = ?, + 
		 			"				    DEC_4 = ?, + 
		 			"				    DEC_5 = ?, + 
		 			"				    DISCARD_DATE = ?, + 
		 			"				    REMARKS = ?, + 
		 			"				    END REMARKS = ?, + 
		 			"				    COMMENT_DATA = ?, + 
		 			"				    LAST_RO_DATE = ?, + 
		 			"				    SALES_STANDARD_DEVIATION = ?, + 
		 			"		    		    MINE_SAFETY_STOCK = ?, + 
		 			"				    MINE_SAFETY_STOCK_UPD_FLAG = ?, + 
		 			"				    ENTRUST_SAFETY_STOCK = ?, + 
		 			"				    CRE_FUNC = ?, + 
		 			"				    CRE_DATETM = ?,\r\n" + 
		 			"				    CRE_USER = ?,\r\n" + 
		 			"				    UPD_FUNC = ?,\r\n" + 
		 			"				    UPD_DATETM = ?,\r\n" + 
		 			"				    UPD_USER = ?,\r\n" + 
		 			"				    DEL_FUNC = ?,\r\n" + 
		 			"				    DEL_DATETM = ?,\r\n" + 
		 			"				    DEL_USER = ?\";
}
