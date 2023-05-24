package jp.co.alpha.servlet.generic;

import java.io.IOException;
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
 * アプリのログイン認証処理を行うサーブレット
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("email", email);
		session.setAttribute("password", password);

		List<Users> UsersList = UsersDao.selectId(email, password);

		if (UsersList.size() >= 1) {
			request.getRequestDispatcher("/home/to_home.java").forward(request, response);

			//			if()  //flagでユーザーの識別

		} else {
			//			System.out.println("失敗しました");
			request.getRequestDispatcher("/jsp/login.jsp").forward(request,
					response);
		}
		request.setAttribute("email", email);
		request.setAttribute("password", password);
	}

	//	
	//	 */
	//	 @WebServlet("/tubuyaki")
	//	 public class Tubuyaki extends HttpServlet {
	//	 	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	//	 			throws ServletException, IOException {
	//	 		request.setCharacterEncoding("UTF-8");
	//	 		String mailAdd = request.getParameter("mailAdd");
	//	 		String password = request.getParameter("password");
	//	 		HttpSession session = request.getSession();
	//	 		session.setAttribute("mailAdd", mailAdd);
	//	 		session.setAttribute("password", password);
	//
	//	 		if (mailAdd.equals("xxx@mail.co.jp") && password.equals("pass1234")) {
	//
	//	 		} else {
	//	 			response.sendRedirect("/servlet_sample/jsp/ensyu/tubuyaki.jsp");
	//	 			return;
	//	 		}
	//	 		request.setAttribute("mailAdd", mailAdd);
	//	 		request.setAttribute("password", password);
	//	 		request.getRequestDispatcher("/jsp/ensyu/tubuyaki_time.jsp").forward(request,
	//	 				response);
	//	 	}
	//
	//	 }
	//	

	//	import jp.co.sss.bean2.Users;
	//	import jp.co.sss.dao.UsersDao2;
	//
	//	@WebServlet("/login")
	//	public class Login extends HttpServlet {
	//		protected void doPost(HttpServletRequest request, HttpServletResponse response)
	//				throws ServletException, IOException {
	//			String stateMess = "OK";
	//			request.setCharacterEncoding("UTF-8");
	//			String mailAdd = request.getParameter("mailAdd");
	//			String password = request.getParameter("password");
	//			HttpSession session = request.getSession();
	//			session.setAttribute("mailAdd", mailAdd);
	//			session.setAttribute("password", password);
	//			List<Users> userList = UsersDao2.selectNameId(mailAdd, password);
	//			session.setAttribute("name", userList.get(0).getName());
	//			if (userList.size() >= 1) {
	//				System.out.println("ok");
	//				request.getRequestDispatcher("/jsp/ensyu/tubuyaki_time.jsp").forward(request, response);
	//
	//			} else {
	//				System.out.println("NG");
	//				stateMess = "NG";
	//				session.setAttribute("stateMess", stateMess);
	//				response.sendRedirect("/servlet_sample/jsp/ensyu/tubuyaki.jsp");
	//			}
	//		}
}