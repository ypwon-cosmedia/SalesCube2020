package master.product.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import common.dao.BaseDAO;
import master.product.beans.ProductModifyBean;
import master.product.beans.ProductResultBean;
import master.product.beans.ProductSearchBean;


public class ProductSearchDAO extends BaseDAO{
	
	/* �ｿｽ�ｽｿ�ｽｽ�ｿｽ�ｽｿ�ｽｽ�ｿｽ�ｽｿ�ｽｽi�ｿｽ�ｽｿ�ｽｽ�ｿｽ�ｽｿ�ｽｽ�ｿｽ�ｽｿ�ｽｽ�ｿｽ�ｽｿ�ｽｽ�ｿｽ�ｽｿ�ｽｽ�ｿｽ�ｽｿ�ｽｽ�ｿｽ�ｽｿ�ｽｽ�ｾ悟叙蠕�(�ｿｽ�ｽｿ�ｽｽ�ｿｽ�ｽｿ�ｽｽ�ｿｽ�ｽｿ�ｽｽ�ｿｽ�ｽｿ�ｽｽ�ｿｽ�ｽｿ�ｽｽ�ｿｽ�ｽｿ�ｽｽ�ｾ顔畑) */
	public List<ProductResultBean> searchProduct(ProductSearchBean input) throws SQLException, ClassNotFoundException {

		List<ProductResultBean> list = new ArrayList<ProductResultBean>();

		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;

	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	if(input.getProductCode() == null || input.getProductCode().equals("")) {
	 		input.setProductCode("%'");
	 	}
	 	else {
	 		input.setProductCode(input.getProductCode().concat("%'"));
	 	}
	 	if(input.getProductName() == null || input.getProductName().equals("")) {
	 		input.setProductName("%'");
	 	}
	 	else {
	 		input.setProductName(input.getProductName().concat("%'"));
	 	}
	 	if(input.getProductKana() == null || input.getProductKana().equals("")) {
	 		input.setProductKana("%' OR pmx.PRODUCT_KANA IS NULL");
	 	}
	 	else {
	 		input.setProductKana(input.getProductKana().concat("%'"));
	 	}
	 	if(input.getSupplierCode() == null || input.getSupplierCode().equals("")) {
	 		input.setSupplierCode("%' OR pmx.SUPPLIER_CODE IS NULL");
	 	}
	 	else {
	 		input.setSupplierCode(input.getSupplierCode().concat("%'"));
	 	}
	 	if(input.getSupplierName() == null || input.getSupplierName().equals("")) {
	 		input.setSupplierName("%' OR A.SUPPLIER_NAME IS NULL");
	 	}
	 	else {
	 		input.setSupplierName(input.getSupplierName().concat("%'"));
	 	}
	 	if(input.getProductStandardCategory() == null || input.getProductStandardCategory().equals("")) {
	 		input.setProductStandardCategory("%' OR pmx.PRODUCT_STANDARD_CATEGORY IS NULL");
	 	}
	 	else {
	 		input.setProductStandardCategory(input.getProductStandardCategory().concat("%'"));
	 	}
	 	if(input.getProductStatusCategory() == null || input.getProductStatusCategory().equals("")) {
	 		input.setProductStatusCategory("%' OR pmx.PRODUCT_STATUS_CATEGORY IS NULL");
	 	}
	 	else {
	 		input.setProductStatusCategory(input.getProductStatusCategory().concat("%'"));
	 	}
	 	if(input.getProductStockCategory() == null || input.getProductStockCategory().equals("")) {
	 		input.setProductStockCategory("%' OR pmx.PRODUCT_STOCK_CATEGORY IS NULL");
	 	}
	 	else {
	 		input.setProductStockCategory(input.getProductStockCategory().concat("%'"));
	 	}
	 	if(input.getSetTypeCategory() == null || input.getSetTypeCategory().equals("")) {
	 		input.setSetTypeCategory("%' OR pmx.SET_TYPE_CATEGORY IS NULL");
	 	}
	 	else {
	 		input.setSetTypeCategory(input.getSetTypeCategory().concat("%'"));
	 	}
	 	if(input.getRemarks() == null || input.getRemarks().equals("")) {
	 		input.setRemarks("%' OR pmx.REMARKS IS NULL");
	 	}
	 	else {
	 		input.setRemarks(input.getRemarks().concat("%'"));
	 	}
	 	if(input.getProduct1() == null || input.getProduct1().equals("")) {
	 		input.setProduct1("%' OR pmx.PRODUCT_1 IS NULL");
	 	}
	 	else {
	 		input.setProduct1(input.getProduct1().concat("%'"));
	 	}
	 	if(input.getProduct2() == null || input.getProduct2().equals("")) {
	 		input.setProduct2("%' OR pmx.PRODUCT_2 IS NULL");
	 	}
	 	else {
	 		input.setProduct2(input.getProduct2().concat("%'"));
	 	}
	 	if(input.getProduct3() == null || input.getProduct3().equals("")) {
	 		input.setProduct3("%' OR pmx.PRODUCT_3 IS NULL");
	 	}
	 	else {
	 		input.setProduct3(input.getProduct3().concat("%'"));
	 	}
	 	
	 	sql = "SELECT DISTINCT"
	 			+" pmx.PRODUCT_CODE,"
	 			+" pmx.PRODUCT_NAME,"
	 			+" A.SUPPLIER_NAME,"
	 			+" B.CLASS_NAME,"
	 			+" pmx.REMARKS"
	 		  +" FROM"
	 			+" product_mst_xxxxx pmx"
	 			+" LEFT OUTER JOIN (SELECT SUPPLIER_CODE ,SUPPLIER_NAME FROM supplier_mst_xxxxx AS smx) A on pmx.SUPPLIER_CODE = A.SUPPLIER_CODE"
	 			+" LEFT OUTER JOIN (SELECT pcm.CLASS_CODE_1, pcm.CLASS_CODE_2, pcm.CLASS_NAME FROM product_class_mst_xxxxx pcm, product_mst_xxxxx pmx) B ON pmx.PRODUCT_1 = B.CLASS_CODE_1 AND CLASS_CODE_2 =''"
	 		  +" WHERE"
	 			+" pmx.PRODUCT_CODE LIKE '" + input.getProductCode()
	 		  +" AND pmx.PRODUCT_NAME LIKE '" + input.getProductName()
	 		  +" AND (pmx.PRODUCT_KANA LIKE '" + input.getProductKana() 
	 		  +") AND (pmx.SUPPLIER_CODE LIKE '" + input.getSupplierCode()
	 		  +") AND (A.SUPPLIER_NAME LIKE '" + input.getSupplierName()
	 		  +") AND (pmx.PRODUCT_STANDARD_CATEGORY LIKE '" + input.getProductStandardCategory()
	 		  +") AND (pmx.PRODUCT_STATUS_CATEGORY LIKE '" + input.getProductStatusCategory()
	 		  +") AND (pmx.PRODUCT_STOCK_CATEGORY LIKE '" + input.getProductStockCategory()
	 		  +") AND (pmx.SET_TYPE_CATEGORY LIKE '" + input.getSetTypeCategory()
	 		  +") AND (pmx.REMARKS LIKE '" + input.getRemarks()
	 		  +") AND (pmx.PRODUCT_1 LIKE '" + input.getProduct1()
	 		  +") AND (pmx.PRODUCT_2 LIKE '" + input.getProduct2()
	 		  +") AND (pmx.PRODUCT_3 LIKE '" + input.getProduct3()
	 		  +") GROUP BY"
	 			+" pmx.PRODUCT_CODE"
	 		  +" ORDER BY"
	 			+" pmx.PRODUCT_CODE";
	 	

		 	result = stmt.executeQuery(sql);

		 	
		 	while( result.next() ) {
		 		ProductResultBean prb = new ProductResultBean();
		 		prb.setProductCode(result.getString("pmx.PRODUCT_CODE"));
		 		prb.setProductName(result.getString("pmx.PRODUCT_NAME"));
		 		prb.setSupplierName(result.getString("A.SUPPLIER_NAME"));
		 		prb.setProduct1(result.getString("B.CLASS_NAME"));
		 		prb.setRemarks(result.getString("pmx.REMARKS"));
		 		
		 		list.add(prb);
		 	}
		 	
		 	super.releaseDB(con, stmt, result);
		 	return list; 	
	}
	
	//Excel
	public List<ProductModifyBean> searchAllProduct(ProductSearchBean input) throws SQLException, ClassNotFoundException {

		List<ProductModifyBean> listAll = new ArrayList<ProductModifyBean>();

		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;

	 	con = super.getConnection();
	 	stmt = con.createStatement();
	 	
	 	if(input.getProductCode() == null || input.getProductCode().equals("")) {
	 		input.setProductCode("%'");
	 	}
	 	else {
	 		input.setProductCode(input.getProductCode().concat("%'"));
	 	}
	 	if(input.getProductName() == null || input.getProductName().equals("")) {
	 		input.setProductName("%'");
	 	}
	 	else {
	 		input.setProductName(input.getProductName().concat("%'"));
	 	}
	 	if(input.getProductKana() == null || input.getProductKana().equals("")) {
	 		input.setProductKana("%' OR pmx.PRODUCT_KANA IS NULL");
	 	}
	 	else {
	 		input.setProductKana(input.getProductKana().concat("%'"));
	 	}
	 	if(input.getSupplierCode() == null || input.getSupplierCode().equals("")) {
	 		input.setSupplierCode("%' OR pmx.SUPPLIER_CODE IS NULL");
	 	}
	 	else {
	 		input.setSupplierCode(input.getSupplierCode().concat("%'"));
	 	}
	 	if(input.getSupplierName() == null || input.getSupplierName().equals("")) {
	 		input.setSupplierName("%' OR A.SUPPLIER_NAME IS NULL");
	 	}
	 	else {
	 		input.setSupplierName(input.getSupplierName().concat("%'"));
	 	}
	 	if(input.getProductStandardCategory() == null || input.getProductStandardCategory().equals("")) {
	 		input.setProductStandardCategory("%' OR pmx.PRODUCT_STANDARD_CATEGORY IS NULL");
	 	}
	 	else {
	 		input.setProductStandardCategory(input.getProductStandardCategory().concat("%'"));
	 	}
	 	if(input.getProductStatusCategory() == null || input.getProductStatusCategory().equals("")) {
	 		input.setProductStatusCategory("%' OR pmx.PRODUCT_STATUS_CATEGORY IS NULL");
	 	}
	 	else {
	 		input.setProductStatusCategory(input.getProductStatusCategory().concat("%'"));
	 	}
	 	if(input.getProductStockCategory() == null || input.getProductStockCategory().equals("")) {
	 		input.setProductStockCategory("%' OR pmx.PRODUCT_STOCK_CATEGORY IS NULL");
	 	}
	 	else {
	 		input.setProductStockCategory(input.getProductStockCategory().concat("%'"));
	 	}
	 	if(input.getSetTypeCategory() == null || input.getSetTypeCategory().equals("")) {
	 		input.setSetTypeCategory("%' OR pmx.SET_TYPE_CATEGORY IS NULL");
	 	}
	 	else {
	 		input.setSetTypeCategory(input.getSetTypeCategory().concat("%'"));
	 	}
	 	if(input.getRemarks() == null || input.getRemarks().equals("")) {
	 		input.setRemarks("%' OR pmx.REMARKS IS NULL");
	 	}
	 	else {
	 		input.setRemarks(input.getRemarks().concat("%'"));
	 	}
	 	if(input.getProduct1() == null || input.getProduct1().equals("")) {
	 		input.setProduct1("%' OR pmx.PRODUCT_1 IS NULL");
	 	}
	 	else {
	 		input.setProduct1(input.getProduct1().concat("%'"));
	 	}
	 	if(input.getProduct2() == null || input.getProduct2().equals("")) {
	 		input.setProduct2("%' OR pmx.PRODUCT_2 IS NULL");
	 	}
	 	else {
	 		input.setProduct2(input.getProduct2().concat("%'"));
	 	}
	 	if(input.getProduct3() == null || input.getProduct3().equals("")) {
	 		input.setProduct3("%' OR pmx.PRODUCT_3 IS NULL");
	 	}
	 	else {
	 		input.setProduct3(input.getProduct3().concat("%'"));
	 	}
	 	
	 	sql = "SELECT DISTINCT"
	 			+" pmx.PRODUCT_CODE,"
	 			+" pmx.PRODUCT_NAME,"
	 			+" A.SUPPLIER_NAME,"
	 			+" B.CLASS_NAME,"
	 			+" pmx.REMARKS"
	 		  +" FROM"
	 			+" product_mst_xxxxx pmx"
	 			+" LEFT OUTER JOIN (SELECT SUPPLIER_CODE ,SUPPLIER_NAME FROM supplier_mst_xxxxx AS smx) A on pmx.SUPPLIER_CODE = A.SUPPLIER_CODE"
	 			+" LEFT OUTER JOIN (SELECT pcm.CLASS_CODE_1, pcm.CLASS_CODE_2, pcm.CLASS_NAME FROM product_class_mst_xxxxx pcm, product_mst_xxxxx pmx) B ON pmx.PRODUCT_1 = B.CLASS_CODE_1 AND CLASS_CODE_2 =''"
	 		  +" WHERE"
	 			+" pmx.PRODUCT_CODE LIKE '" + input.getProductCode()
	 		  +" AND pmx.PRODUCT_NAME LIKE '" + input.getProductName()
	 		  +" AND (pmx.PRODUCT_KANA LIKE '" + input.getProductKana() 
	 		  +") AND (pmx.SUPPLIER_CODE LIKE '" + input.getSupplierCode()
	 		  +") AND (A.SUPPLIER_NAME LIKE '" + input.getSupplierName()
	 		  +") AND (pmx.PRODUCT_STANDARD_CATEGORY LIKE '" + input.getProductStandardCategory()
	 		  +") AND (pmx.PRODUCT_STATUS_CATEGORY LIKE '" + input.getProductStatusCategory()
	 		  +") AND (pmx.PRODUCT_STOCK_CATEGORY LIKE '" + input.getProductStockCategory()
	 		  +") AND (pmx.SET_TYPE_CATEGORY LIKE '" + input.getSetTypeCategory()
	 		  +") AND (pmx.REMARKS LIKE '" + input.getRemarks()
	 		  +") AND (pmx.PRODUCT_1 LIKE '" + input.getProduct1()
	 		  +") AND (pmx.PRODUCT_2 LIKE '" + input.getProduct2()
	 		  +") AND (pmx.PRODUCT_3 LIKE '" + input.getProduct3()
	 		  +") GROUP BY"
	 			+" pmx.PRODUCT_CODE"
	 		  +" ORDER BY"
	 			+" pmx.PRODUCT_CODE";
	 	

		 	result = stmt.executeQuery(sql);
	 		
	 		
	 			while( result.next() ) {
	 				//Bean
	 				ProductModifyBean pb =new ProductModifyBean();
	 				
	 				pb.setProductCode(result.getString("pmx.PRODUCT_CODE"));
	 				pb.setProductName(result.getString("pmx.PRODUCT_NAME"));
	 				pb.setProductKana(result.getString("pmx.PRODUCT_KANA"));
	 				pb.setOnlinePcode(result.getString("pmx.ONLINE_PCODE"));
	 				pb.setSupplierPcode(result.getString("pmx.SUPPLIER_PCODE"));
	 				pb.setSupplierCode(result.getString("pmx.SUPPLIER_CODE"));
	 				pb.setRackCode(result.getString("pmx.RACK_CODE"));
	 				pb.setSupplierPriceYen(result.getInt("pmx.SUPPLIER_PRICE_YEN"));
	 				pb.setSupplierPriceDol(result.getInt("pmx.SUPPLIER_PRICE_DOL"));
	 				pb.setRetailPrice(result.getInt("pmx.RETAIL_PRICE"));
	 				pb.setSoRate(result.getInt("pmx.SO_RATE"));
		 			pb.setUnitCategory(result.getString("pmx.UNIT_CATEGORY"));
		 			pb.setPackQuantity(result.getShort("pmx.PACK_QUANTITY"));
		 			pb.setJanPcode(result.getString("pmx.JAN_PCODE"));
		 			pb.setWidth(result.getDouble("pmx.WIDTH"));
		 			pb.setWidthUnitSizeCategory(result.getString("pmx.WIDTH_UNIT_SIZE_CATEGORY"));
		 			pb.setDepth(result.getDouble("pmx.DEPTH"));
		 			pb.setDepthUnitSizeCategory(result.getString("pmx.DEPTH_UNIT_SIZE_CATEGORY"));
		 			pb.setHeight(result.getDouble("pmx.HEIGHT"));
		 			pb.setHeightUnitSizeCategory(result.getString("pmx.HEIGHT_UNIT_SIZE_CATEGORY"));
		 			pb.setWeight(result.getDouble("pmx.WEIGHT"));
		 			pb.setWeightUnitSizeCategory(result.getString("pmx.WEIGHT_UNIT_SIZE_CATEGORY"));
		 			pb.setLength(result.getDouble("pmx.LENGTH"));
		 			pb.setLengthUnitSizeCategory(result.getString("pmx.LENGTH_UNIT_SIZE_CATEGORY"));
		 			pb.setPoLot(result.getInt("pmx.PO_LOT"));
		 			pb.setLotUpdFlag(result.getShort("pmx.LOT_UPD_FLAG"));
		 			pb.setLeadTime(result.getInt("pmx.LEAD_TIME"));
		 			pb.setPoNum(result.getInt("pmx.PO_NUM"));
		 			pb.setPoUpdFlag(result.getShort("pmx.PO_UPD_FLAG"));
		 			pb.setAvgShipCount(result.getInt("pmx.AVG_SHIP_COUNT"));
		 			pb.setMaxStockNum(result.getInt("pmx.MAX_STOCK_NUM"));
		 			pb.setStockUpdFlag(result.getShort("pmx.STOCK_UPD_FLAG"));
		 			pb.setTermShipNum(result.getInt("pmx.TERM_SHIP_NUM"));
		 			pb.setMaxPoNum(result.getInt("pmx.MAX_PO_NUM"));
		 			pb.setMaxPoUpdFlag(result.getShort("pmx.MAX_PO_UPD_FLAG"));
		 			pb.setFractCategory(result.getString("pmx.FRACT_CATEGORY"));
		 			pb.setTaxCategory(result.getString("pmx.TAX_CATEGORY"));
		 			pb.setStockCtlCategory(result.getString("pmx.STOCK_CTL_CATEGORY"));
		 			pb.setStockAssesCategory(result.getString("pmx.STOCK_ASSES_CATEGORY"));
		 			pb.setProductCategory(result.getString("pmx.PRODUCT_CATEGORY"));
		 			pb.setProduct1(result.getString("pmx.PRODUCT_1"));
		 			pb.setProduct2(result.getString("pmx.PRODUCT_2"));
		 			pb.setProduct3(result.getString("pmx.PRODUCT_3"));
		 			pb.setRoMaxNum(result.getShort("pmx.RO_MAX_NUM"));
		 			pb.setProductRank(result.getString("pmx.PRODUCT_RANK"));
		 			pb.setSetTypeCategory(result.getString("pmx.SET_TYPE_CATEGORY"));
		 			pb.setProductStatusCategory(result.getString("pmx.PRODUCT_STATUS_CATEGORY"));
		 			pb.setProductStockCategory(result.getString("pmx.PRODUCT_STOCK_CATEGORY"));
		 			pb.setProductPurvayCategory(result.getString("pmx.PRODUCT_PURVAY_CATEGORY"));
		 			pb.setProductStandardCategory(result.getString("pmx.PRODUCT_STANDARD_CATEGORY"));
		 			pb.setCoreNum(result.getString("pmx.CORE_NUM"));
		 			pb.setNum1(result.getShort("pmx.NUM_1"));
		 			pb.setNum2(result.getShort("pmx.NUM_2"));
		 			pb.setNum3(result.getShort("pmx.NUM_3"));
		 			pb.setNum4(result.getShort("pmx.NUM_4"));
		 			pb.setNum5(result.getShort("pmx.NUM_5"));
		 			pb.setDec1(result.getDouble("pmx.DEC_1"));
		 			pb.setDec2(result.getDouble("pmx.DEC_2"));
		 			pb.setDec3(result.getDouble("pmx.DEC_3"));
		 			pb.setDec4(result.getDouble("pmx.DEC_4"));
		 			pb.setDec5(result.getDouble("pmx.DEC_5"));
		 			pb.setDiscardDate(result.getDate("pmx.DISCARD_DATE"));
		 			pb.setRemarks(result.getString("pmx.REMARKS"));
		 			pb.setEadRemarks(result.getString("pmx.EAD_REMARKS"));
		 			pb.setCommentData(result.getString("pmx.COMMENT_DATA"));
		 			pb.setLastRoDate(result.getDate("pmx.LAST_RO_DATE"));
		 			pb.setSalesStandardDeviation(result.getInt("pmx.SALES_STANDARD_DEVIATION"));
		 			pb.setMineSafetyStock(result.getInt("pmx.MINE_SAFETY_STOCK"));
			 		pb.setMineSafetyStockUpdFlag(result.getShort("pmx.MINE_SAFETY_STOCK_UPD_FLAG"));
			 		pb.setEntrustSafetyStock(result.getInt("pmx.ENTRUST_SAFETY_STOCK"));
			 		pb.setCreFunc(result.getString("pmx.CRE_FUNC"));
			 		pb.setCreDatetm(result.getTimestamp("pmx.CRE_DATETM"));
			 		pb.setCreUser(result.getString("pmx.CRE_USER"));
			 		pb.setUpdFunc(result.getString("pmx.UPD_FUNC"));
			 		pb.setUpdDatetm(result.getTimestamp("pmx.UPD_DATETM"));		 		
			 		pb.setUpdUser(result.getString("pmx.UPD_USER"));
			 		pb.setDelFunc(result.getString("pmx.DEL_FUNC"));
			 		pb.setDelDatetm(result.getTimestamp("pmx.DEL_DATETM"));
			 		pb.setDelUser(result.getString("pmx.DEL_USER"));		 		

			 		listAll.add(pb);
		 		
	 			}
	 		//DB
		 	super.releaseDB(con, stmt, result);
		 	
		 	return listAll;

	}
	
	public int getCount() throws ClassNotFoundException, MissingResourceException, SQLException {
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;
	 	String  sql1;

	 	int count = 0;
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	sql1 = "select COUNT(*) from product_mst_xxxxx";
	 	result = stmt.executeQuery(sql1);

	 	while(result.next()) {
	 		count = result.getInt("COUNT(*)");
	 	}

	 	
	 	
	 	super.releaseDB(con, stmt);
	 	
	 	return count;
	
	}
}