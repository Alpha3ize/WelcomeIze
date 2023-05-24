package jp.co.alpha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.alpha.bean.Users;

public class UsersDao {
	public static List<Users> allUsers() {
		// SQL文
		String sql = "SELECT * FROM users";

		// データベース接続準備
		Connection con = null;
		PreparedStatement ps = null;
		// 戻り値のデータベース上にあるユーザー一覧
		List<Users> usersList = new ArrayList<>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Users users = new Users();
				users.setId(rs.getInt("u_id"));
				users.setName(rs.getString("u_name"));
				users.setEmail(rs.getString("u_mail"));
				users.setPassword(rs.getString("u_pass"));
				users.setFlag(rs.getInt("u_flag"));
				usersList.add(users);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
		return usersList;
	}

	public static Users findUsers(int userId) {
		// SQL文
		String sql = "SELECT * FROM users WHERE u_id = ?";

		// データベース接続準備
		Connection con = null;
		PreparedStatement ps = null;
		// 戻り値のデータベース上にあるユーザー
		Users users = new Users();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			users.setId(rs.getInt("u_id"));
			users.setName(rs.getString("u_name"));
			users.setEmail(rs.getString("u_mail"));
			users.setPassword(rs.getString("u_pass"));
			users.setFlag(rs.getInt("u_flag"));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
		return users;
	}
}
