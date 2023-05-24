package jp.co.alpha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//掃除備品一覧DAO
import jp.co.alpha.bean.CleanTool;

public class CleanToolDao {
	public static List<CleanTool> findAll() {
		
		Connection con = null;
		PreparedStatement ps = null;
		List<CleanTool> CleanToolList = new ArrayList<CleanTool>();
		
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM CleanTool");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				CleanTool cleanTool = new CleanTool();
				cleanTool.setName(rs.getString("name"));
				cleanTool.setUpdateDate(rs.getDate("updateDate"));
				cleanTool.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
		return CleanToolList;
	}
}
