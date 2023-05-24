//掃除備品一覧Servlet
package jp.co.alpha.servlet.cleaning;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.alpha.bean.CleanTool;
import jp.co.alpha.dao.CleanToolDao;

@WebServlet("/toCtool")
public class ToCtool extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<CleanTool> CleanToolList = CleanToolDao.findAll();
		request.setAttribute("CleanToolList", CleanToolList);
		request.getRequestDispatcher("/jsp/tool.jsp").forward(request, response);
	}

}