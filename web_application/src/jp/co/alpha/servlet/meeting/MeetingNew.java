package jp.co.alpha.servlet.meeting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MeetingNew
 */
@WebServlet("/meetingnew")
public class MeetingNew extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  = request.getParameter("");
		String  = request.getParameter("");
		String  = request.getParameter("");
		String  = request.getParameter("");
		
		request.setAttribute("", );
		request.setAttribute("", catGender);
		request.setAttribute("catAge", catAge);
		request.setAttribute("catMail", catMail);
		request.getRequestDispatcher("/jsp/j0511/neko_input.jsp").forward(request, response);
	}

}
