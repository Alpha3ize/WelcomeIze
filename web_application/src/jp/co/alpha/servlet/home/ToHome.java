package jp.co.alpha.servlet.home;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.alpha.bean.CleanPlace;
import jp.co.alpha.dao.CleanPlaceDao;

/**
 * ホームの表示を行うサーブレット
 */
@WebServlet("/to_home")
public class ToHome extends HttpServlet {
	/** cpListが一つかを判別するための定数です。 */
	private final int ONLY_ONE_PLACE = 1;
	/** Listから一番最初の値を取るための定数です。 */
	private final int FIRST = 0;
	// forwardしたときに起動するメソッド
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// セッションから取得したユーザーのIDの取得
		int userId = (Integer)session.getAttribute("userId");
		// ユーザーのIDから取得した掃除場所リスト		
		List<CleanPlace> cpList = CleanPlaceDao.findCPName(userId);
		if(cpList.size() == ONLY_ONE_PLACE) {
			// 掃除場所リストから掃除名を格納
			String cp_name = cpList.get(FIRST).getName();
			request.setAttribute("cpName", cp_name);
			request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
		} else {
			System.err.println("エラー：掃除場所が複数もしくは掃除場所が設定されていない");
		}
	}
}
