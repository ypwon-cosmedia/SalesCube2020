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
		 			"				    PRODUCT_NAME = ?"'','"' + 
		 			"				    PRODUCT_KANA = ?,\r\n" + 
		 			"				    ONLINE_PCODE = ?,\r\n" + 
		 			"				    SUPPLIER_PCODE = ?,\r\n" + 
		 			"				    SUPPLIER_CODE = ?,\r\n" + 
		 			"				    RACK_CODE = ?,\r\n" + 
		 			"				    SUPPLIER_PRICE_YEN = ?,\r\n" + 
		 			"				    SUPPLIER_PRICE_DOL = ?,\r\n" + 
		 			"				    RETAIL_PRICE = ?,\r\n" + 
		 			"				    SO_RATE = ?,\r\n" + 
		 			"				    UNIT_CATEGORY = ?,\r\n" + 
		 			"				    PACK_QUANTITY = ?,\r\n" + 
		 			"				    JAN_PCODE = ?,\r\n" + 
		 			"				    WIDTH = ?,\r\n" + 
		 			"				    WIDTH_UNIT_SIZE_CATEGORY = ?,\r\n" + 
		 			"				    DEPTH = ?,\r\n" + 
		 			"				    DEPTH_UNIT_SIZE_CATEGORY = ?,\r\n" + 
		 			"				    HEIGHT = ?,\r\n" + 
		 			"				    HEIGHT_UNIT_SIZE_CATEGORY = ?,\r\n" + 
		 			"				    WEIGHT = ?,\r\n" + 
		 			"				    WEIGHT_UNIT_SIZE_CATEGORY = ?,\r\n" + 
		 			"				    LENGTH = ?,\r\n" + 
		 			"				    LENGTH_UNIT_SIZE_CATEGORY = ?,\r\n" + 
		 			"				    PO_LOT = ?,\r\n" + 
		 			"				    LOT_UPD_FLAG = ?,\r\n" + 
		 			"				    LEAD_TIME = ?,\r\n" + 
		 			"				    PO_NUM = ?,\r\n" + 
		 			"				    PO_UPD_FLAG = ?,\r\n" + 
		 			"				    AVG_SHIP_COUNT = ?,\r\n" + 
		 			"				    MAX_STOCK_NUM = ?,\r\n" + 
		 			"				    STOCK_UPD_FLAG = ?,\r\n" + 
		 			"				    TEAM_SHIP_NUM = ?,\r\n" + 
		 			"				    MAX_PO_NUM = ?,\r\n" + 
		 			"				    MAX_PO_UPD_FLAG = ?,\r\n" + 
		 			"				    FRACT_CATEGORY = ?,\r\n" + 
		 			"				    TAX_CATEGORY = ?,\r\n" + 
		 			"				    STOCK_CTL_CATEGORY = ?,\r\n" + 
		 			"				    STOCK_ASSES_CATEGORY = ?,\r\n" + 
		 			"				    PRODUCT_CATEGORY = ?,\r\n" + 
		 			"				    PRODUCT_1 = ?,\r\n" + 
		 			"				    PRODUCT_2 = ?,\r\n" + 
		 			"				    PRODUCT_3 = ?,\r\n" + 
		 			"				    RO_MAX_NUM = ?,\r\n" + 
		 			"		  		    PRODUCT_RANK = ?,\r\n" + 
		 			"				    SET_TYPE_CATEGORY = ?,\r\n" + 
		 			"				    PRODUCT_STATUS_CATEGORY = ?,\r\n" + 
		 			"				    PRODUCT_STOCK_CATEGORY = ?,\r\n" + 
		 			"				    PRODUCT_PURVAY_CATEGORY = ?,\r\n" + 
		 			"				    PRODUCT_STANDARD_CATEGORY = ?,\r\n" + 
		 			"				    CORE_NUM = ?,\r\n" + 
		 			"				    NUM_1 = ?,\r\n" + 
		 			"				    NUM_2 = ?,\r\n" + 
		 			"				    NUM_3 = ?,\r\n" + 
		 			"				    NUM_4 = ?,\r\n" + 
		 			"				    NUM_5 = ?,\r\n" + 
		 			"				    DEC_1 = ?,\r\n" + 
		 			"				    DEC_2 = ?,\r\n" + 
		 			"				    DEC_3 = ?,\r\n" + 
		 			"				    DEC_4 = ?,\r\n" + 
		 			"				    DEC_5 = ?,\r\n" + 
		 			"				    DISCARD_DATE = ?,\r\n" + 
		 			"				    REMARKS = ?,\r\n" + 
		 			"				    END REMARKS = ?,\r\n" + 
		 			"				    COMMENT_DATA = ?,\r\n" + 
		 			"				    LAST_RO_DATE = ?,\r\n" + 
		 			"				    SALES_STANDARD_DEVIATION = ?,\r\n" + 
		 			"		    		    MINE_SAFETY_STOCK = ?,\r\n" + 
		 			"				    MINE_SAFETY_STOCK_UPD_FLAG = ?,\r\n" + 
		 			"				    ENTRUST_SAFETY_STOCK = ?,\r\n" + 
		 			"				    CRE_FUNC = ?,\r\n" + 
		 			"				    CRE_DATETM = ?,\r\n" + 
		 			"				    CRE_USER = ?,\r\n" + 
		 			"				    UPD_FUNC = ?,\r\n" + 
		 			"				    UPD_DATETM = ?,\r\n" + 
		 			"				    UPD_USER = ?,\r\n" + 
		 			"				    DEL_FUNC = ?,\r\n" + 
		 			"				    DEL_DATETM = ?,\r\n" + 
		 			"				    DEL_USER = ?\";
}
