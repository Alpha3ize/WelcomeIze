package jp.co.alpha.servlet.team;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.alpha.bean.Team;
import jp.co.alpha.dao.TeamDao;

/**
 * Servlet implementation class TeamGenerater
 */
@WebServlet("/TeamGenerater")
public class TeamGenerater extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String groupNumberStr = request.getParameter("groupNumber");
		int groupNumber = Integer.parseInt(groupNumberStr);

		// データベースから対象の列（名前）を全件取得する
		TeamDao dao = new TeamDao();
		List<Team> list = dao.getAll();

		// リストのサイズとグループ数に応じて分け方を決める
		int listSize = list.size();
		int mode = 0; // 0:そのまま、1:ランダム
		if (listSize < groupNumber) {
			// リストのサイズがグループ数より小さい場合はそのままの順番で分ける
			mode = 0;
		} else if (listSize % groupNumber == 0) {
			// リストのサイズがグループ数で割り切れる場合はランダムに分ける
			mode = 1;
			Collections.shuffle(list); // リストをシャッフルする
		} else {
			// それ以外の場合はそのままの順番で分ける
			mode = 0;
		}

		// リストをグループ数だけ分ける
		List<List<Team>> groups = new ArrayList<>(); // 分けた結果を格納するリスト
		int fromIndex = 0; // 分割する開始位置
		int toIndex = 0; // 分割する終了位置
		for (int i = 0; i < groupNumber; i++) {
			if (mode == 0) {
				// そのままの順番で分ける場合は等分するか余りが出るかで場合分けする
				if (listSize % groupNumber == 0) {
					// 等分できる場合はリストサイズをグループ数で割った値ずつ増やす
					toIndex += listSize / groupNumber;
				} else {
					// 余りが出る場合は最初の方のグループに1つずつ多く入れる
					if (i < listSize % groupNumber) {
						toIndex += listSize / groupNumber + 1;
					} else {
						toIndex += listSize / groupNumber;
					}
				}
			} else if (mode == 1) {
				// ランダムに分ける場合は等分できると仮定してリストサイズをグループ数で割った値ずつ増やす
				toIndex += listSize / groupNumber;
			}
			groups.add(list.subList(fromIndex, toIndex)); // 分割した部分リストを追加する
			fromIndex = toIndex; // 開始位置を更新する
		}

		// 分けた結果をresult.jspに渡してforwardする
		request.setAttribute("groups", groups);
		String view = "/jsp/result.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

}
