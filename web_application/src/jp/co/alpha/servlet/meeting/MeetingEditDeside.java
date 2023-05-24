package jp.co.alpha.servlet.meeting;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MeetingEditer
 */
@WebServlet("/meetingeditdeside") //編集画面表示サーブレット
public class MeetingEditDeside extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int m_id = request.getParameter("meeting_id");
		int m_date = request.getParameter("m_date");
		int m_date_end = request.getParameter("m_date_end");
		int m_name = request.getParameter("m_name");
		int m_place = request.getParameter("m_place");
		List<Meeting> meetList = MeetingDao.updateMeet(m_id, m_date, m_date_end, m_name, m_place);
		request.setAttribute("meetList", meetList);
		request.getRequestDispatcher("/jsp/Meeting.jsp").forward(request, response);//更新後の画面に遷移　スコープに保存はするべき？
	}

}