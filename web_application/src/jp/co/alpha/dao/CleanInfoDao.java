package jp.co.alpha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import jp.co.alpha.bean.Clean_Info;

//ホーム画面「もっと見る」クリックした後の処理

public class CleanInfoDao extends HttpServlet {

	public static List<Clean_Info> twoCleanInfo(String CleanInfotext) {
		Connection con = null;
		PreparedStatement ps = null;
		List<Clean_Info> CleanInfo_List = new ArrayList<Clean_Info>();
		//最新2件の取得
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
	
	public ArrayList<ToCInfo> getPlaces() throws SQLException {
		// SQL文を準備
		String sql = "SELECT c_place_name FROM clean_place";
		// ステートメントオブジェクトを作成
		PreparedStatement stmt = conn.prepareStatement(sql);
		// クエリを実行して結果セットを取得
		ResultSet rs = stmt.executeQuery();
		// ArrayListオブジェクトを作成してデータを格納
		ArrayList<String> places = new ArrayList<>();
		while (rs.next()) {
		places.add(rs.getString("c_place_name"));
		ToClinfo places = new ToClnfo(place);
		placeList.add(places);
		}
		// 結果セットとステートメントを閉じる
		rs.close();
		stmt.close();
		// ArrayListオブジェクトを返す
		return clean_places;
		}

		// プルダウンで選択した場所に対応する掃除内容を取得するメソッド
		public String getCleaningByPlace(String place) throws SQLException {
		// SQL文を準備
		String sql = "SELECT c_content FROM clean_place WHERE c_place_name = ?";
		// ステートメントオブジェクトを作成
		PreparedStatement stmt = conn.prepareStatement(sql);
		// パラメータをセット
		stmt.setString(1, place);
		// クエリを実行して結果セットを取得
		ResultSet rs = stmt.executeQuery();
		
		 while (rs.next()) {
		        String task = rs.getString("c_content");
		        ToClinfo detail = new ToClnfo(task);
		        detailList.add(detail);
		      }
		// 結果セットとステートメントを閉じる
		rs.close();
		stmt.close();
		// 掃除内容の文字列変数を返す
		return cleaning_content;
		}
	}
}