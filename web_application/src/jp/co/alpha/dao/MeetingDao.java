package jp.co.alpha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.beanTw.Tweets;
import jp.co.sss.dao.DBManagerTw;

public class MeetingDao {
	public static List<Tweets> allTweets() {
		Connection con = null;
		PreparedStatement ps = null;
		List<Tweets> tweetList = new ArrayList<>();
		try {
			con = DBManagerTw.getConnection();
			ps = con.prepareStatement(
					"SELECT t.id, t.body, t.post_date, t.user_id, u.name FROM tweets t INNER JOIN users u ON t.user_id = u.id ORDER BY t.post_date DESC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Tweets tweet = new Tweets();
				tweet.setId(Integer.parseInt(rs.getString("id")));
				tweet.setBody(rs.getString("body"));
				tweet.setPostDate(rs.getString("post_date"));
				tweet.setUserId(Integer.parseInt(rs.getString("user_id")));
				tweet.setName(rs.getString("name"));
				tweetList.add(tweet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManagerTw.close(ps, con);
		}
		return tweetList;
	}

	public static void insert(Tweets tw) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBManagerTw.getConnection();
			ps = con.prepareStatement("INSERT INTO tweets VALUES(users_seq.NEXTVAL,?,?,?)");
			ps.setString(1, tw.getBody());
			System.out.println(tw.getPostDate());
			ps.setString(2, tw.getPostDate());
			ps.setInt(3, tw.getUserId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManagerTw.close(ps, con);
		}
	}

}
