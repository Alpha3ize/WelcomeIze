package jp.co.alpha.servlet.cleaning;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class ToCInfo
 */
@WebServlet("/to_c_info")
public class ToCInfo extends HttpServlet {
	//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//		
	//		CleanInfoDao CleanInfo_List = new CleanInfoDao();
	//		//過去2日間の全体報告を取得
	//		List<Clean_Info> reports = CleanInfo_List.getSerch_CleanInfo();
	//		
	//		CleanInfo_List.setSerch_CleanInfo(reports);
	//		
	//		request.setAttribute("",);
	//		//jspにフォワード
	//		RequestDispatcher dispatcher = request.getRequestDispatcher("/cleaningReport.jsp");
	//		dispatcher.forward(request, response);
	//	}

}
