package common.modal.customer.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.dao.BaseDAO;
import common.modal.customer.beans.CustomerModalResultBean;
import common.modal.customer.beans.CustomerModalSearchBean;
import common.modal.product.beans.ProductModalSearchBean;
import sql.common.CommonSQL;

public class CustomerModalDAO extends BaseDAO {
	public List<CustomerModalResultBean> customerModalResult(ProductModalSearchBean bean) throws SQLException, ClassNotFoundException{
		
		List<CustomerModalResultBean> list = new ArrayList<>();
		
		CommonSQL sqllist = new CommonSQL();
		
		Connection con;
		Statement stmt = null;
		ResultSet result = null;
		
		con = super.getConnection();
		stmt = con.createStatement();

		String sql;
		
		sql = sqllist.customerModalSearch(bean);
		
		result = stmt.executeQuery(sql);
		
		while(result.next()) {
			CustomerModalResultBean bean1 = new CustomerModalResultBean();
			bean1.setCustomerCode(result.getString("CUSTOMER_CODE"));
			bean1.setCustomerName(result.getString("CUSTOMER_NAME"));
			bean1.setCustomerTel(result.getString("CUSTOMER_TEL"));
			bean1.setCustomerPcName(result.getString("CUSTOMER_PC_NAME"));
			bean1.setSalesCmCategory(result.getString("SALES_CM_CATEGORY"));
			bean1.setCutoffGroup(result.getString("CUTOFF_GROUP"));
			bean1.setCustomerOfficeName(result.getString("CUSTOMER_OFFICE_NAME"));
			bean1.setCustomerDeptName(result.getString("CUSTOMER_DEPT_NAME"));

			list.add(bean1);
		}
		
		super.releaseDB(con,stmt,result);
		
		return list;
	}
}
