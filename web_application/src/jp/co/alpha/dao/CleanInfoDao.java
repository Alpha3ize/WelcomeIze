package jp.co.alpha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import jp.co.alpha.bean.Clean_Info;

public class CleanInfoDao extends HttpServlet {

	public static List<Clean_Info> twoCleanInfo(String CleanInfotext) {
		Connection con = null;
		PreparedStatement ps = null;
		List<Clean_Info> CleanInfo_List = new ArrayList<Clean_Info>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("SELECT cs_body FROM clean_share ORDER BY cs_date DESC FETCH FIRST 2 ROWS ONLY");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Clean_Info cleanInfo = new Clean_Info();
				cleanInfo.setSerch_CleanInfo(rs.getString("cs_body"));
				CleanInfo_List.add(cleanInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
		return CleanInfo_List;
	}

}