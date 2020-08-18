package order.input.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;


import common.dao.BaseDAO;
import order.input.beans.OrderInputBean;
import sql.order.OrderSQL;

public class OrderInputDAO extends BaseDAO{
	
	/* 受注番号最後 */
	public int roSlipLast() throws SQLException, ClassNotFoundException {
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String sql;
	 	con = super.getConnection();
	 	stmt = con.createStatement();

	 	sql = "select " + 
				"ro_slip_id " + 
				"from " + 
				"ro_slip_trn_xxxxx " + 
				"order by ro_slip_id desc " + 
				"limit 1 offset 0";
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	int num = 0;
	 	
	 	while(result.next()) {
	 		num = result.getInt("RO_SLIP_ID");
	 	}
	 	super.releaseDB(con, stmt, result);
	 	
	 	return num;	 	
		
	}
	
	/* 受注新規登録 */
	public int orderInputInfo(OrderInputBean bean) throws SQLException, ClassNotFoundException{
		
		Connection con;
	 	PreparedStatement stmt = null;
	 	int result = 0;	
	 	String sql;
	 	con = super.getConnection();	

	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.orderInputInfo();

	 	stmt = con.prepareStatement(sql);
	 	
	 	stmt.setString(1, bean.getRoDate());
	 	
	 	if(bean.getShipDate() == null) {
	 		stmt.setNull(2,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(2, bean.getShipDate());
	 	}
	 	if(bean.getDeliveryDate() == null) {
	 		stmt.setNull(3,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(3, bean.getDeliveryDate());
	 	}
	 	if(bean.getReceptNo() == null) {
	 		stmt.setNull(4,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(4, bean.getReceptNo());
	 	}
	 	if(bean.getCustomerSlipNo() == null) {
	 		stmt.setNull(5,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(5, bean.getCustomerSlipNo());
	 	}
	 	if(bean.getUserName() == null) {
	 		stmt.setNull(6,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(6, bean.getUserName());
	 	}
	 	if(bean.getRemarks() == null) {
	 		stmt.setNull(7,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(7, bean.getRemarks());
	 	}
	 	if(bean.getDcName() == null) {
	 		stmt.setNull(8,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(8, bean.getDcName());
	 	}
	 	if(bean.getDcTimezone() == null) {
	 		stmt.setNull(9,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(9, bean.getDcTimezone());
	 	}
	 	if(bean.getCtaxRate() == null) {
	 		stmt.setNull(10,  java.sql.Types.NULL);
	 	}else {
		 	stmt.setString(10, bean.getCtaxRate());
	 	}
	 	if(bean.getCustomerCode() == null) {
	 		stmt.setNull(11,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(11, bean.getCustomerCode());
	 	}
	 	if(bean.getCustomerName() == null) {
	 		stmt.setNull(12,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(12, bean.getCustomerName());
	 	}
	 	if(bean.getTaxShiftCategory() == null) {
	 		stmt.setNull(13,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(13, bean.getTaxShiftCategory());
	 	}
	 	if(bean.getCutoffGroup() == null) {
	 		stmt.setNull(14,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(14, bean.getCutoffGroup());
	 	}
	 	if(bean.getSalesCmCategory() == null) {
	 		stmt.setNull(15,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(15, bean.getSalesCmCategory());
	 	}
	 	if(bean.getCustomerRemarks() == null) {
	 		stmt.setNull(16,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(16, bean.getCustomerRemarks());
	 	}
	 	if(bean.getCustomerCommentData() == null) {
	 		stmt.setNull(17,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(17, bean.getCustomerCommentData());
	 	}
	 	if(bean.getDeliveryName() == null) {
	 		stmt.setNull(18,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(18, bean.getDeliveryName());
	 	}
	 	if(bean.getDeliveryOfficeName() == null) {
	 		stmt.setNull(19,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(19, bean.getDeliveryOfficeName());
	 	}
	 	if(bean.getDeliveryDeptName() == null) {
	 		stmt.setNull(20,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(20, bean.getDeliveryDeptName());
	 	}
	 	if(bean.getDeliveryZipCode() == null) {
	 		stmt.setNull(21,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(21, bean.getDeliveryZipCode());
	 	}
	 	if(bean.getDeliveryAddress1() == null) {
	 		stmt.setNull(22,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(22, bean.getDeliveryAddress1());
	 	}
	 	if(bean.getDeliveryAddress2() == null) {
	 		stmt.setNull(23,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(23, bean.getDeliveryAddress2());
	 	}
	 	if(bean.getDeliveryPcName() == null) {
	 		stmt.setNull(24,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(24, bean.getDeliveryPcName());
	 	}
	 	if(bean.getDeliveryPcKana() == null) {
	 		stmt.setNull(25,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(25, bean.getDeliveryPcKana());
	 	}
	 	if(bean.getDeliveryPcPre() == null) {
	 		stmt.setNull(26,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(26, bean.getDeliveryPcPre());
	 	}
	 	if(bean.getDeliveryTel() == null) {
	 		stmt.setNull(27,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(27, bean.getDeliveryTel());
	 	}
	 	if(bean.getDeliveryFax() == null) {
	 		stmt.setNull(28,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(28, bean.getDeliveryFax());
	 	}
	 	if(bean.getDeliveryEmail() == null) {
	 		stmt.setNull(29,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(29, bean.getDeliveryEmail());
	 	}
	 	if(bean.getRetailPriceTotal() == null) {
	 		stmt.setNull(30,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setInt(30, bean.getRetailPriceTotal());
	 	}
	 	if(bean.getCtaxPriceTotal() == null) {
	 		stmt.setNull(31,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setInt(31, bean.getCtaxPriceTotal());
	 	}
	 	if(bean.getPriceTotal() == null) {
	 		stmt.setNull(32,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setInt(32, bean.getPriceTotal());
	 	}
	 	stmt.setInt(33, bean.getStatus());
	 	stmt.setInt(34, roSlipLast()+1);

	 	try {
	 		System.out.println(sql);
	 		result = stmt.executeUpdate();
	 		System.out.println("1登録完了");
	 		con.commit();
	 	}catch(SQLException e){
	 		e.printStackTrace();
	 		System.out.println("2登録できませんでした");
	 		result = 0;
	 	}finally {
	 		super.releaseDB(con,stmt);
	 	}
	 
		return result;
	 	
	}
	
	/* 受注新規登録明細 */
	public int orderInputDetail(List<OrderInputBean> list) throws SQLException, ClassNotFoundException{
		
		Connection con;
	 	PreparedStatement stmt = null;
	 	int result = 0;	
	 	String sql;
	 	con = super.getConnection();	

	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.orderInputDetail();

	 	stmt = con.prepareStatement(sql);
	 	
	 	for (OrderInputBean bean : list) {
		 	stmt.setString(1, bean.getProductCode());
		 	stmt.setString(2, bean.getProductName());
		 	stmt.setString(3, bean.getProductRemarks());
		 	stmt.setString(4, bean.getRackCode());
		 	stmt.setInt(5, bean.getQuantity());
		 	stmt.setInt(6, bean.getUnitCost());
		 	stmt.setInt(7, bean.getCost());
		 	stmt.setInt(8, bean.getUnitRetailPrice());
		 	stmt.setInt(9, bean.getRetailPrice());
		 	stmt.setString(10, bean.getInputProductRemarks());
		 	stmt.setString(11, bean.getEadRemarks());
		 	stmt.setInt(12, roSlipLast()+1);
		 	result = stmt.executeUpdate();
	 	}
	 	
	 	try {
	 		System.out.println("3登録完了");
	 		con.commit();
	 	}catch(SQLException e){
	 		e.printStackTrace();
	 		System.out.println("4登録できませんでした");
	 		result = 0;
	 	}finally {
	 		super.releaseDB(con,stmt);
	 	}
	 
		return result;
	 
	}
	
	/* 受注更新 */
	public int orderUpdateInfo(OrderInputBean bean) throws SQLException, ClassNotFoundException{
		
		Connection con;
	 	PreparedStatement stmt = null;
	 	int result = 0;	
	 	String sql;
	 	con = super.getConnection();	

	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.orderInputInfo();

	 	stmt = con.prepareStatement(sql);
	 	
	 	stmt.setString(1, bean.getRoDate());
	 	
	 	if(bean.getShipDate() == null) {
	 		stmt.setNull(2,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(2, bean.getShipDate());
	 	}
	 	if(bean.getDeliveryDate() == null) {
	 		stmt.setNull(3,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(3, bean.getDeliveryDate());
	 	}
	 	if(bean.getReceptNo() == null) {
	 		stmt.setNull(4,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(4, bean.getReceptNo());
	 	}
	 	if(bean.getCustomerSlipNo() == null) {
	 		stmt.setNull(5,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(5, bean.getCustomerSlipNo());
	 	}
	 	if(bean.getUserName() == null) {
	 		stmt.setNull(6,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(6, bean.getUserName());
	 	}
	 	if(bean.getRemarks() == null) {
	 		stmt.setNull(7,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(7, bean.getRemarks());
	 	}
	 	if(bean.getDcName() == null) {
	 		stmt.setNull(8,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(8, bean.getDcName());
	 	}
	 	if(bean.getDcTimezone() == null) {
	 		stmt.setNull(9,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(9, bean.getDcTimezone());
	 	}
	 	if(bean.getCtaxRate() == null) {
	 		stmt.setNull(10,  java.sql.Types.NULL);
	 	}else {
		 	stmt.setString(10, bean.getCtaxRate());
	 	}
	 	if(bean.getCustomerCode() == null) {
	 		stmt.setNull(11,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(11, bean.getCustomerCode());
	 	}
	 	if(bean.getCustomerName() == null) {
	 		stmt.setNull(12,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(12, bean.getCustomerName());
	 	}
	 	if(bean.getTaxShiftCategory() == null) {
	 		stmt.setNull(13,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(13, bean.getTaxShiftCategory());
	 	}
	 	if(bean.getCutoffGroup() == null) {
	 		stmt.setNull(14,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(14, bean.getCutoffGroup());
	 	}
	 	if(bean.getSalesCmCategory() == null) {
	 		stmt.setNull(15,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(15, bean.getSalesCmCategory());
	 	}
	 	if(bean.getCustomerRemarks() == null) {
	 		stmt.setNull(16,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(16, bean.getCustomerRemarks());
	 	}
	 	if(bean.getCustomerCommentData() == null) {
	 		stmt.setNull(17,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(17, bean.getCustomerCommentData());
	 	}
	 	if(bean.getDeliveryName() == null) {
	 		stmt.setNull(18,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(18, bean.getDeliveryName());
	 	}
	 	if(bean.getDeliveryOfficeName() == null) {
	 		stmt.setNull(19,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(19, bean.getDeliveryOfficeName());
	 	}
	 	if(bean.getDeliveryDeptName() == null) {
	 		stmt.setNull(20,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(20, bean.getDeliveryDeptName());
	 	}
	 	if(bean.getDeliveryZipCode() == null) {
	 		stmt.setNull(21,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(21, bean.getDeliveryZipCode());
	 	}
	 	if(bean.getDeliveryAddress1() == null) {
	 		stmt.setNull(22,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(22, bean.getDeliveryAddress1());
	 	}
	 	if(bean.getDeliveryAddress2() == null) {
	 		stmt.setNull(23,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(23, bean.getDeliveryAddress2());
	 	}
	 	if(bean.getDeliveryPcName() == null) {
	 		stmt.setNull(24,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(24, bean.getDeliveryPcName());
	 	}
	 	if(bean.getDeliveryPcKana() == null) {
	 		stmt.setNull(25,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(25, bean.getDeliveryPcKana());
	 	}
	 	if(bean.getDeliveryPcPre() == null) {
	 		stmt.setNull(26,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(26, bean.getDeliveryPcPre());
	 	}
	 	if(bean.getDeliveryTel() == null) {
	 		stmt.setNull(27,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(27, bean.getDeliveryTel());
	 	}
	 	if(bean.getDeliveryFax() == null) {
	 		stmt.setNull(28,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(28, bean.getDeliveryFax());
	 	}
	 	if(bean.getDeliveryEmail() == null) {
	 		stmt.setNull(29,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setString(29, bean.getDeliveryEmail());
	 	}
	 	if(bean.getRetailPriceTotal() == null) {
	 		stmt.setNull(30,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setInt(30, bean.getRetailPriceTotal());
	 	}
	 	if(bean.getCtaxPriceTotal() == null) {
	 		stmt.setNull(31,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setInt(31, bean.getCtaxPriceTotal());
	 	}
	 	if(bean.getPriceTotal() == null) {
	 		stmt.setNull(32,  java.sql.Types.NULL);
	 	}else {
	 		stmt.setInt(32, bean.getPriceTotal());
	 	}
	 	stmt.setInt(33, bean.getStatus());
	 	stmt.setInt(34, roSlipLast()+1);
	 	
	 	result = stmt.executeUpdate();
	 	
	 	try {
	 		System.out.println("1更新完了");
	 		con.commit();
	 	}catch(SQLException e){
	 		System.out.println("2更新できませんでした");
	 		e.printStackTrace();
	 		result = 0;
	 	}finally {
	 		super.releaseDB(con,stmt);
	 	}
	 
		return result;
	 	
	}
	
	/* 受注更新 明細 */
	public int orderUpdateDetail(List<OrderInputBean> list) throws SQLException, ClassNotFoundException{
		Connection con;
	 	PreparedStatement stmt = null;
	 	int result = 0;	
	 	String sql;
	 	con = super.getConnection();	

	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.orderInputDetail();

	 	stmt = con.prepareStatement(sql);
	 	
	 	for (OrderInputBean bean : list) {
		 	stmt.setString(1, bean.getProductCode());
		 	stmt.setString(2, bean.getProductName());
		 	stmt.setString(3, bean.getProductRemarks());
		 	stmt.setString(4, bean.getRackCode());
		 	stmt.setInt(5, bean.getQuantity());
		 	stmt.setInt(6, bean.getUnitCost());
		 	stmt.setInt(7, bean.getCost());
		 	stmt.setInt(8, bean.getUnitRetailPrice());
		 	stmt.setInt(9, bean.getRetailPrice());
		 	stmt.setString(10, bean.getInputProductRemarks());
		 	stmt.setString(11, bean.getEadRemarks());
		 	stmt.setInt(12, roSlipLast()+1);
	 		result = stmt.executeUpdate();
	 	}
	 	
	 	try {
	 		System.out.println("3明細更新完了");
	 		con.commit();
	 	}catch(SQLException e){
	 		System.out.println("4明細更新できませんでした");
	 		e.printStackTrace();
	 		result = 0;
	 	}finally {
	 		super.releaseDB(con,stmt);
	 	}
	 	
		return result;
	 
	}
	
	/* 新規登録画面→受注更新画面 */
	public OrderInputBean getOrderInfo(Integer roSlipId) throws SQLException, ClassNotFoundException {
		
		OrderInputBean bean = new OrderInputBean();

		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;
	 	String sql1;
	 	String sql2;
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	sql1 = ordersql.moveOrderUpdateInfo(roSlipId);
	 	sql2 = ordersql.moveOrderUpdateDetail(roSlipId);
	 	
	 	result = stmt.executeQuery(sql1);

	 	if (result.next()) {
	 		bean.setRoSlipId(Integer.parseInt(result.getString("rstx.RO_SLIP_ID")));
	 		bean.setRoDate(result.getString("rstx.RO_DATE"));
	 		bean.setShipDate(result.getString("rstx.SHIP_DATE"));
	 		bean.setDeliveryDate(result.getString("rstx.DELIVERY_DATE"));
	 		bean.setReceptNo(result.getString("rstx.RECEPT_NO"));
	 		bean.setCustomerSlipNo(result.getString("rstx.CUSTOMER_SLIP_NO"));
	 		bean.setUserName(result.getString("rstx.USER_NAME"));
	 		bean.setRemarks(result.getString("rstx.REMARKS"));
	 		bean.setDcName(result.getString("rstx.DC_NAME"));
	 		bean.setDcTimezone(result.getString("rstx.DC_TIMEZONE"));
	 		bean.setCtaxRate(result.getString("rstx.CTAX_RATE"));
	 		bean.setCustomerCode(result.getString("rstx.CUSTOMER_CODE"));
	 		bean.setCustomerName(result.getString("rstx.CUSTOMER_NAME"));
	 		bean.setTaxShiftCategory(result.getString("a.CATEGORY_CODE_NAME"));
	 		bean.setCutoffGroup(result.getString("b.CATEGORY_CODE_NAME"));
	 		bean.setSalesCmCategory(result.getString("c.CATEGORY_CODE_NAME"));
	 		bean.setCustomerRemarks(result.getString("rstx.CUSTOMER_REMARKS"));
	 		bean.setCustomerCommentData(result.getString("rstx.CUSTOMER_COMMENT_DATA"));
	 		bean.setDeliveryName(result.getString("rstx.DELIVERY_NAME"));
	 		bean.setDeliveryOfficeName(result.getString("rstx.DELIVERY_OFFICE_NAME"));
	 		bean.setDeliveryDeptName(result.getString("rstx.DELIVERY_DEPT_NAME"));
	 		bean.setDeliveryZipCode(result.getString("rstx.DELIVERY_ZIP_CODE"));
	 		bean.setDeliveryAddress1(result.getString("rstx.DELIVERY_ADDRESS_1"));
	 		bean.setDeliveryAddress2(result.getString("rstx.DELIVERY_ADDRESS_2"));
	 		bean.setDeliveryPcName(result.getString("rstx.DELIVERY_PC_NAME"));
	 		bean.setDeliveryPcKana(result.getString("rstx.DELIVERY_PC_KANA"));
	 		bean.setDeliveryPcPre(result.getString("rstx.DELIVERY_PC_PRE"));
	 		bean.setDeliveryTel(result.getString("rstx.DELIVERY_TEL"));
	 		bean.setDeliveryFax(result.getString("rstx.DELIVERY_FAX"));
	 		bean.setDeliveryEmail(result.getString("rstx.DELIVERY_EMAIL"));
	 	}
	 	
	 	result = stmt.executeQuery(sql2);
	 	
	 	if (result.next()) {
	 		bean.setProductCode(result.getString("rltx.PRODUCT_CODE"));
	 		bean.setProductName(result.getString("pmx.PRODUCT_NAME"));
	 		bean.setProductRemarks(result.getString("pmx.REMARKS"));
	 		bean.setRackCode(result.getString("rltx.RACK_CODE_SRC"));
	 		bean.setQuantity(Integer.parseInt(result.getString("rltx.QUANTITY").substring(0, result.getString("rltx.QUANTITY").length() - 4)));
	 		bean.setUnitCost(Integer.parseInt(result.getString("rltx.UNIT_COST").substring(0, result.getString("rltx.UNIT_COST").length() - 4)));
	 		bean.setCost(Integer.parseInt(result.getString("rltx.COST").substring(0, result.getString("rltx.COST").length() - 4)));
	 		bean.setUnitRetailPrice(Integer.parseInt(result.getString("rltx.UNIT_RETAIL_PRICE").substring(0, result.getString("rltx.UNIT_RETAIL_PRICE").length() - 4)));
	 		bean.setRetailPrice(Integer.parseInt(result.getString("rltx.RETAIL_PRICE").substring(0, result.getString("rltx.RETAIL_PRICE").length() - 4)));
	 		bean.setInputProductRemarks(result.getString("rltx.REMARKS"));
	 		bean.setEadRemarks(result.getString("rltx.EAD_REMARKS"));
	 	}

	 	super.releaseDB(con, stmt, result);
	 	
	 	return bean;
	}
	
	/* 商品コード/名押下 明細に反映 */
	public List<OrderInputBean> productLinkToDetail(String productCode, String productName, OrderInputBean bean) throws SQLException, ClassNotFoundException{
	
		List<OrderInputBean> list = new ArrayList<OrderInputBean>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.productToDetail(productCode, productName, bean);
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	while (result.next()) {
	 		bean.setProductCode(result.getString("pmx.PRODUCT_CODE"));
	 		bean.setProductName(result.getString("pmx.PRODUCT_NAME"));
	 		bean.setRemarks(result.getString("pmx.REMARKS"));
	 		bean.setRackCode(result.getString("pmx.RACK_CODE"));
	 		bean.setQuantity(result.getInt("rltn.QUANTITY"));
	 		bean.setCost(result.getInt("rltn.COST"));
	 		bean.setUnitRetailPrice(result.getInt("rltn.UNIT_RETAIL_PRICE"));
	 		bean.setRetailPrice(result.getInt("rltn.RETAIL_PRICE"));
	 		bean.setInputProductRemarks(result.getString("pmx.REMARKS"));
	 		bean.setEadRemarks(result.getString("pmx.EAD_REMARKS"));
	 		list.add(bean);
	 	}
	 	
	 	super.releaseDB(con, stmt, result);
	 	
	 	return list;
		
	}

	/* 取引区分コンボボックス */
	public List<OrderInputBean> getSalesCmCategory() throws SQLException, ClassNotFoundException{
		
		List<OrderInputBean> list = new ArrayList<OrderInputBean>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.initSalesCmCategory();
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	while (result.next()) {
	 		OrderInputBean bean = new OrderInputBean();
	 		bean.setSalesCmCategory(result.getString("SALES_CM_CATEGORY"));
	 		bean.setCategoryCodeName(result.getString("CATEGORY_CODE_NAME"));
	 		list.add(bean);
	 	}
	 	
	 	super.releaseDB(con, stmt, result);
	 	
	 	return list;
	}
	
	/* 支払条件コンボボックス */
	public List<OrderInputBean> getCutoffGroup() throws SQLException, ClassNotFoundException {
		
		List<OrderInputBean> list = new ArrayList<>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.initCutoffGroup();
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	while (result.next()) {
	 		OrderInputBean bean = new OrderInputBean();
	 		bean.setCategoryCodeName(result.getString("CATEGORY_CODE_NAME"));
	 		list.add(bean);
	 	}
	 	
	 	super.releaseDB(con, stmt, result);
	 	
	 	return list;
	 	
	}
	
	/* 税転嫁コンボボックス */
	public List<OrderInputBean> getTaxShiftCategory() throws SQLException, ClassNotFoundException {
		
		List<OrderInputBean> list = new ArrayList<>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.initTaxShiftCategory();
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	while (result.next()) {
	 		OrderInputBean bean = new OrderInputBean();
	 		bean.setCategoryCodeName(result.getString("CATEGORY_CODE_NAME"));
	 		list.add(bean);
	 	}
	 	
	 	super.releaseDB(con, stmt, result);
	 	
	 	return list;
	 	
	}
	
	/* 顧客納入先コンボボックス */
	public List<OrderInputBean> getDeliveryName(String customerCode) throws SQLException, ClassNotFoundException {
		
		List<OrderInputBean> list = new ArrayList<>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.initDeliveryName(customerCode);
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	while (result.next()) {
	 		OrderInputBean bean = new OrderInputBean();
	 		bean.setDeliveryName(result.getString("DELIVERY_NAME"));
	 		list.add(bean);
	 	}
	 	
	 	super.releaseDB(con, stmt, result);
	 	
	 	return list;
	 	
	}
	
	/* 配送業者コンボボックス */
	public List<OrderInputBean> getDcName() throws SQLException, ClassNotFoundException {
		
		List<OrderInputBean> list = new ArrayList<>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.initDcName();
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	while (result.next()) {
	 		OrderInputBean bean = new OrderInputBean();
	 		bean.setCategoryCodeName(result.getString("CATEGORY_CODE_NAME"));
	 		bean.setCategoryCode(result.getString("CATEGORY_CODE"));
	 		list.add(bean);
	 	}
	 
	 	super.releaseDB(con, stmt, result);
	 	
	 	return list;
	 	
	}
	
	/* 配送時間帯コンボボックス */
	public List<OrderInputBean> getDcTimezone() throws SQLException, ClassNotFoundException {
		
		List<OrderInputBean> list = new ArrayList<>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.initDcTimezone();
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	while (result.next()) {
	 		OrderInputBean bean = new OrderInputBean();
	 		bean.setCategoryCodeName(result.getString("CATEGORY_CODE_NAME"));
	 		bean.setCategoryCode(result.getString("CATEGORY_CODE"));
	 		list.add(bean);
	 	}
	 	
	 	super.releaseDB(con, stmt, result);
	 	
	 	return list;
	 	
	}
	
	/* 消費税率コンボボックス */
	public List<OrderInputBean> getTaxRate() throws SQLException, ClassNotFoundException {
		
		List<OrderInputBean> list = new ArrayList<>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.initTaxRate();
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	while (result.next()) {
	 		OrderInputBean bean = new OrderInputBean();
	 		bean.setCtaxRate(result.getString("TAX_RATE"));
	 		list.add(bean);
	 	}
	 	
	 	super.releaseDB(con, stmt, result);
	 	
	 	return list;
	 	
	}
	
	/* 顧客納入先コンボボックス */
	public List<OrderInputBean> getDelivery() throws SQLException, ClassNotFoundException{
		
		List<OrderInputBean> list = new ArrayList<>();
		
		Connection con;
	 	Statement stmt = null;
	 	ResultSet result = null;	
	 	String  sql;
	 	
	 	con = super.getConnection();	
	 	stmt = con.createStatement();
	 	
	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.initTaxRate();
	 	
	 	result = stmt.executeQuery(sql);
	 	
	 	while (result.next()) {
	 		OrderInputBean bean = new OrderInputBean();
	 		bean.setDeliveryName(result.getString("DELIVERY_NAME"));
	 		list.add(bean);
	 	}
	 	
	 	super.releaseDB(con, stmt, result);
	 	
	 	return list;
	}

}
