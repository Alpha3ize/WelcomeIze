package jp.co.alpha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jp.co.alpha.bean.Meeting;

public class MeetingDao {
	public static void insertMeet(Meeting meet) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("INSERT INTO meeting VALUES(シーケンス.NEXTVAL,?,?,?,?,0)");
			ps.setDate(1, meet.getM_Date());
			ps.setDate(2, meet.getM_Date_End());
			ps.setString(3, meet.getM_Name());
			ps.setString(4, meet.getM_Place());
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
			ps.setDate(1, meet.getM_Date());
			ps.setDate(2, meet.getM_Date_End());
			ps.setString(3, meet.getM_Name());
			ps.setString(4, meet.getM_Place());
			ps.setInt(5, meet.getM_Id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
	}

}
