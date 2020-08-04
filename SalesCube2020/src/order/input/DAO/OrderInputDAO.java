package order.input.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;


import common.dao.BaseDAO;
import order.input.beans.OrderInputBean;
import sql.order.OrderSQL;

public class OrderInputDAO extends BaseDAO{
	
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
	 	
	 	stmt.setDate(1, bean.getRoDate());
	 	stmt.setDate(2, bean.getShipDate());
	 	stmt.setDate(3, bean.getDeliveryDate());
	 	stmt.setString(4, bean.getReceptNo());
	 	stmt.setString(5, bean.getCustomerSlipNo());
	 	stmt.setString(6, bean.getUserName());
	 	stmt.setString(7, bean.getRemarks());
	 	stmt.setString(8, bean.getDcName());
	 	stmt.setString(9, bean.getDcTimezone());
	 	stmt.setBigDecimal(10, bean.getCtaxRate());
	 	stmt.setString(11, bean.getCustomerCode());
	 	stmt.setString(12, bean.getCustomerName());
	 	stmt.setString(13, bean.getTaxShiftCategory());
	 	stmt.setString(14, bean.getCutoffGroup());
	 	stmt.setString(15, bean.getSalesCmCategory());
	 	stmt.setString(16, bean.getCustomerRemarks());
	 	stmt.setString(17, bean.getCustomerCommentData());
	 	stmt.setString(18, bean.getDeliveryName());
	 	stmt.setString(19, bean.getDeliveryOfficeName());
	 	stmt.setString(20, bean.getDeliveryDeptName());
	 	stmt.setString(21, bean.getDeliveryZipCode());
	 	stmt.setString(21, bean.getDeliveryAddress1());
	 	stmt.setString(22, bean.getDeliveryAddress2());
	 	stmt.setString(23, bean.getDeliveryPcName());
	 	stmt.setString(24, bean.getDeliveryPcKana());
	 	stmt.setString(25, bean.getDeliveryPcPre());
	 	stmt.setString(26, bean.getDeliveryTel());
	 	stmt.setString(27, bean.getDeliveryFax());
	 	stmt.setString(28, bean.getDeliveryEmail());
	 	stmt.setString(29, bean.getRetailPriceTotal());
	 	stmt.setInt(30, bean.getCtaxPriceTotal());
	 	stmt.setString(31, bean.getPriceTotal());

	 	try {
	 		result = stmt.executeUpdate();
	 		System.out.println("新規登録完了");
	 		con.commit();
	 	}catch(SQLException e){
	 		e.printStackTrace();
	 		result = 0;
	 	}finally {
	 		super.releaseDB(con,stmt);
	 	}
	 
		return result;
	 	
	}
	
	/* 受注新規登録明細 */
	public int orderInputDetail(OrderInputBean bean) throws SQLException, ClassNotFoundException{
		Connection con;
	 	PreparedStatement stmt = null;
	 	int result = 0;	
	 	String sql;
	 	con = super.getConnection();	

	 	OrderSQL ordersql = new OrderSQL();
	 	sql = ordersql.orderInputDetail();

	 	stmt = con.prepareStatement(sql);
	 	
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
	 	
	 	try {
	 		result = stmt.executeUpdate();
	 		System.out.println("新規登録完了");
	 		con.commit();
	 	}catch(SQLException e){
	 		e.printStackTrace();
	 		result = 0;
	 	}finally {
	 		super.releaseDB(con,stmt);
	 	}
	 
		return result;
	 
	}
	
	/* 受注番号押下 */
	public OrderInputDAO orderUpdate() throws SQLException, ClassNotFoundException{
		return null;
	}
}
