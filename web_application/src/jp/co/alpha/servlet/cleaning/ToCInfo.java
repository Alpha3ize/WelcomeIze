package jp.co.alpha.servlet.cleaning;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToCInfo
 */
@WebServlet("/to_c_info")
public class ToCInfo extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getAttribute("CleanInfo_List", CleanInfo_List);
		request.getRequestDispatcher("/jsp/sample06/pizza.jsp").forward(request,
				response);
	}

}