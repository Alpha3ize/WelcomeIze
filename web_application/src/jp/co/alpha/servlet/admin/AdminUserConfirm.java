package jp.co.alpha.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.alpha.bean.Users;
import jp.co.alpha.dao.UsersDao;

/**
 * ユーザーの追加するサーブレットです。
 */
@WebServlet("/admin_user_confirm")
public class AdminUserConfirm extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Users> userList = (ArrayList<Users>) session.getAttribute("userList");
		UsersDao.insertList(userList);
		request.getRequestDispatcher("/jsp/admin_user_completion.jsp").forward(request, response);
		//		response.setContentType("text/html; charset=UTF-8");
		//		PrintWriter out = response.getWriter();
		//		out.println("<html>");
		//		out.println("<head>");
		//		out.println("<title>ホームに戻ります</title>");
		//		out.println("</head>");
		//		out.println("<BODY>");
		//		out.println("HTMLを出力するサーブレット");
		//		out.println("</BODY>");
		//		out.println("</HTML>");

	}
}
