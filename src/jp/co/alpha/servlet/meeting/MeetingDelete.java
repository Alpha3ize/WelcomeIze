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
@WebServlet("/meetingdelete")//削除サーブレット
public class MeetingDelete extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int m_id = request.getParameter("meeting_id");
		List<Meeting> meetList = MeetingDao.deleteMeet(m_id);
		request.setAttribute("meetList", meetList);
		request.getRequestDispatcher("/jsp/Meeting.jsp").forward(request, response);//削除の画面に遷移　スコープに保存はするべき？
	}

}
