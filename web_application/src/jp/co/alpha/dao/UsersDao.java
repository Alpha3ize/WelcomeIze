package jp.co.alpha.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.alpha.bean.Users;
public class UsersDao {
	
//	public static List<Users> allUser() {
//		return ;
//	}	
		public static List<Users> selectNameId(String email, String password) {
			Connection con = null;
			PreparedStatement ps = null;
			List<Users> usersList = new ArrayList<Users>();
			try {
				con = DBManager.getConnection();
				ps = con.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
				ps.setString(1, email);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Users users = new Users();
					users.setId(Integer.parseInt(rs.getString("id")));
					users.setName(rs.getString("name"));
					usersList.add(users);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(ps, con);
			}
			return usersList;
		}
	}

