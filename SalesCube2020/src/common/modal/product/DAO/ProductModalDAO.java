package common.modal.product.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import common.dao.BaseDAO;
import common.modal.product.beans.ProductModalSearchBean;
import sql.common.CommonSQL;
import common.modal.product.beans.ProductModalResultBean;

public class ProductModalDAO extends BaseDAO{

	public List<ProductModalResultBean> productModalResult(ProductModalSearchBean bean) throws SQLException, ClassNotFoundException{
		
		List<ProductModalResultBean> list = new ArrayList<>();
		
		CommonSQL sqllist = new CommonSQL();
		
		Connection con;
		Statement stmt = null;
		ResultSet result = null;
		
		con = super.getConnection();
		stmt = con.createStatement();

		String sql;
		
		sql = sqllist.productModalSearch(bean);
		
		result = stmt.executeQuery(sql);
		
		while(result.next()) {
			ProductModalResultBean bean1 = new ProductModalResultBean();
			bean1.setProductCode(result.getString("PRODUCT_CODE"));
			bean1.setProductName(result.getString("PRODUCT_NAME"));
			bean1.setSupplierName(result.getString("SUPLLIER_NAME"));
			list.add(bean1);
		}
		
		super.releaseDB(con,stmt,result);
		
		return list;
	}
}
