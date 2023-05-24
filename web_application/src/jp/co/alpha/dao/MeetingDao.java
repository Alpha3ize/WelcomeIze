package jp.co.alpha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.alpha.bean.Meeting;
import jp.co.alpha.dao.DBManager;

public class MeetingDao {
	public static void insertMeet(Meeting meet) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("INSERT INTO meeting VALUES(シーケンス.NEXTVAL,?,?,?,?,0)");
			ps.setString(1, meet.getM_Date());
			ps.setString(2, meet.getM_Date_End());
			ps.setInt(3, meet.getM_Name());
			ps.setInt(4, meet.getM_Place());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
	}

	public static void updateMeet(Meeting meet) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("UPDATE meeting SET m_date = ?, m_date_end = ?, m_name = ?, m_place = ? where m_id = ?");
			ps.setString(1, meet.getBody());
			System.out.println(meet.getPostDate());
			ps.setString(2, meet.getPostDate());
			ps.setInt(3, tw.getUserId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManagerTw.close(ps, con);
		}
	}

}
