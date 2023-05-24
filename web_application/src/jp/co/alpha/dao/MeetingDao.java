package jp.co.alpha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.co.alpha.bean.Meeting;

public class MeetingDao {
	public static void insertMeet(Date m_date, Date m_date_end, String[] m_name, String m_place) {
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

	public static void updateMeet(int m_id, Date m_date, Date m_date_end, String m_name, String m_place) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(
					"UPDATE meeting SET m_date = ?, m_date_end = ?, m_name = ?, m_place = ? where m_id = ?");
			ps.setDate(1, m_date);
			ps.setDate(2, m_date_end);
			ps.setString(3, m_name);
			ps.setString(4, m_place);
			ps.setInt(5, m_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
	}

	public static void deleteMeet(Meeting meet) {//名前はデリーとだけどやることはupdate。削除フラグを１にする
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("UPDATE meeting SET m_delete_flag = 1 where m_id = ?");
			ps.setInt(1, meet.getM_Id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
	}

	public static Meeting selectMeet(int meetid) {//編集用
		Connection con = null;
		PreparedStatement ps = null;
		List<Meeting> meetList = new ArrayList<Meeting>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM meeting WHERE m_id = ?");
			ps.setInt(1, meetid);
			ResultSet rs = ps.executeQuery();

			Meeting meeting = new Meeting();
			meeting.setM_Id(rs.getInt("m_id"));
			meeting.setM_Date(rs.getDate("m_date"));
			meeting.setM_Date_End(rs.getDate("m_date_end"));
			meeting.setM_Name(rs.getDate("m_name"));
			meeting.setM_Place(rs.getString("m_place"));
			meeting.setM_Delete_Flag(rs.getInt("m_delete_flag"));
			meetList.add(meeting);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
		return meetList;
	}

}