package estimate.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.dao.BaseDAO;
import estimate.common.beans.UserModalResultBean;
import estimate.common.beans.UserModalSearchBean;
import sql.estimate.EstimateSQL;

public class UserModalDAO extends BaseDAO {
	public List<UserModalResultBean> userModalResult(UserModalSearchBean bean) throws SQLException, ClassNotFoundException{
		
		List<UserModalResultBean> list = new ArrayList<>();
		
		EstimateSQL sqllist = new EstimateSQL();
		
		Connection con;
		Statement stmt = null;
		ResultSet result = null;
		
		con = super.getConnection();
		stmt = con.createStatement();

		String sql;
		
		sql = sqllist.userModalSearch(bean);
		System.out.println(sql);
		result = stmt.executeQuery(sql);
		
		while(result.next()) {
			UserModalResultBean bean1 = new UserModalResultBean();
			bean1.setUserId(result.getString("USER_ID"));
			bean1.setNameKnj(result.getString("NAME_KNJ"));
			bean1.setDeptId(result.getString("DEPT_ID"));		
			
			if(bean1.getUserId()== null || bean1.getUserId().equals("")) {bean1.setUserId("");};
			if(bean1.getNameKnj()== null || bean1.getNameKnj().equals("")) {bean1.setNameKnj("");};
			if(bean1.getDeptId()== null || bean1.getDeptId().equals("")) {bean1.setDeptId("");};
			
			list.add(bean1);
		}
		System.out.println("listSize;"+list.size());
		super.releaseDB(con,stmt,result);
		
		return list;
	}
	
}
