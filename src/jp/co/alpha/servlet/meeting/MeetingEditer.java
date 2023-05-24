package jp.co.alpha.servlet.meeting;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.alpha.bean.Meeting;
/**
 * Servlet implementation class MeetingEditer
 */
@WebServlet("/meetingediter")//編集画面表示サーブレット
public class MeetingEditer extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int m_id = request.getParameter("meeting_id");
		List<Meeting> meetList = MeetingDao.selectMeet(m_id);
		request.setAttribute("meetList", meetList);
		request.getRequestDispatcher("/jsp/Meeting.jsp").forward(request, response);//編集画面にディスパッチ
	}

}
