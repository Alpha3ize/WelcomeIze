package jp.co.alpha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.alpha.bean.Team;

public class TeamDao {
	public ArrayList<Team> getAll() {

		Connection conn = null;
		ArrayList<Team> list = new ArrayList<Team>();

		try {

			Class.forName("com.mysql.jdbc.Driver");

			conn = DBManager.getConnection();

			String sql = "SELECT name FROM members";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				Team bean = new Team();
				list.add(bean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}

		return list;

	}
}
