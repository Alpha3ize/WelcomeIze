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

	public static List<Users> selectId(String email, String password) {
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
				users.setFlag(rs.getInt("flag"));
				usersList.add(users);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
		return usersList;
	}

	public static void insert(Users user) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("INSERT INTO users VALUES(?,?,?,?,?)");
			ps.setInt(1, user.getId());
			ps.setString(4, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setInt(5, user.getFlag());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
	}

	public static int findId(String mail) {
		final int ERROR_NUMBER = -1;
		Connection con = null;
		PreparedStatement ps = null;
		int id = 0;
		List<Integer> idList = new ArrayList<>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM users WHERE email = ?");
			ps.setString(1, mail);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				idList.add(rs.getInt("id"));
			}
			if (idList.size() == 1) {
				id = ERROR_NUMBER;
			} else {
				id = UsersDao.allUsers().size() + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
		return id;
	}
}
