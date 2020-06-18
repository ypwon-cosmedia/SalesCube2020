package user.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.dao.BaseDAO;
import user.beans.*;

public class UserDAO extends BaseDAO {
	
	public LoginBean login(String id, String password) {

		try{
			LoginBean user = null;

			Connection con;
			Statement stmt=null;
			ResultSet rs=null;
			String sql;

			con=super.getConnection();
			stmt=con.createStatement();
			sql = "select * from user_mst_xxxxx where user_id = '"+ id +"' and password = '" + password + "'";

			rs = stmt.executeQuery(sql);

			if(null==rs)
				return null;
			else{
				while(rs.next()){
					user=new LoginBean();
					user.setUserID(rs.getString("user_id"));
					user.setPassword(rs.getString("password"));
				}
			}
			return user;
		} catch (ClassNotFoundException e){	
			e.printStackTrace();
			return null;
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public UserInfoBean userInfo(String id) {
		
		try {
			UserInfoBean userInfo = null;
			
			Connection con;
			Statement stmt=null;
			ResultSet rs=null;
			String sql;
			
			con=super.getConnection();
			stmt=con.createStatement();
			sql = "select * from user_mst_xxxxx where user_id = '"+ id;
			
			rs = stmt.executeQuery(sql);

			if(null==rs)
				return null;
			else{
				while(rs.next()){
					userInfo=new UserInfoBean();
					userInfo.setUserID(rs.getString("user_id"));
					userInfo.setNameKNJ(rs.getString("NameKNJ"));
				}
			}
			return userInfo;
			
		}catch (ClassNotFoundException e){	
			e.printStackTrace();
			return null;
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}

}
