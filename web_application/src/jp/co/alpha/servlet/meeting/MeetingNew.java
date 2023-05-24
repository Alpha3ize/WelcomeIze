package jp.co.alpha.servlet.meeting;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.dao.FoodDao;

/**
 * Servlet implementation class MeetingNew
 */
@WebServlet("/meetingnew")
public class MeetingNew extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Date m_date = request.getParameter("開始時間");
		Date m_date_end = request.getParameter("終了時間");
		String m_name = request.getParameter("メンバー");
		String m_place = request.getParameter("場所");
		MeetingDao.insertMeet(m_date, m_date_end, m_name, m_place);
		request.setAttribute("m_date", m_date);
		request.setAttribute("m_date_end", m_date_end);
		request.setAttribute("m_name", m_name);
		request.setAttribute("m_place", m_place);
		request.getRequestDispatcher("//MeetingDao.jsp").forward(request, response);
	}

}