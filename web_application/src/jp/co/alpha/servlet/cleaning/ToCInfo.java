package jp.co.alpha.servlet.cleaning;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//ホーム画面「もっと見る」クリックした後の処理
import javax.servlet.http.HttpSession;

import jp.co.alpha.bean.Users;
import jp.co.alpha.dao.CleanInfoDao;

/**
 * Servlet implementation class ToCInfo
 */
@WebServlet("/to_c_info")
public class ToCInfo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");

		//ホーム画面から受け取ったデータを取得
		String id = request.getParameter("id");
		String name = request.getParameter("name");

		//detailDaoのインスタンスを生成
		CleanInfoDao detailDao = new CleanInfoDao();

		//データベースから詳細画面に必要なデータを取得
		List<Detail> detailList = detailDao.getdetailList();
		List<String> placeList = detailDao.getplaceList();

		//リクエストスコープにデータを保存
		request.setAttribute("user", user);
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("detailList", detailList);
		request.setAttribute("placeList", placeList);

		//詳細画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/clean.jsp");
		dispatcher.forward(request, response);
	}
}
