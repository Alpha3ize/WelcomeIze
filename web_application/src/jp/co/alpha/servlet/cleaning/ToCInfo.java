package jp.co.alpha.servlet.cleaning;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
		//beanを作成
		CleaningReportBean bean = new CleaningReportBean();
		//daoを作成
		CleaningReportDao dao = new CleaningReportDao();
		//過去2日間の全体報告を取得
		List<CleaningReport> reports = dao.getReports();
		//beanにセット
		bean.setReports(reports);
		//requestにbeanをセット
		request.setAttribute("bean", bean);
		//jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cleaningReport.jsp");
		dispatcher.forward(request, response);
	}
}

//掃除場所詳細表示画面に遷移するservlet
public class CleaningDetailServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//beanを作成
		CleaningDetailBean bean = new CleaningDetailBean();
		//daoを作成
		CleaningDetailDao dao = new CleaningDetailDao();
		//プルダウンメニューから選択された掃除場所を取得
		String place = request.getParameter("place");
		//掃除場所詳細を取得
		CleaningDetail detail = dao.getDetail(place);
		//beanにセット
		bean.setDetail(detail);
		//requestにbeanをセット
		request.setAttribute("bean", bean);
		//jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cleaningDetail.jsp");
		dispatcher.forward(request, response);
	}
}

//掃除場所詳細編集画面に遷移するservlet
public class CleaningEditServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//beanを作成
		CleaningEditBean bean = new CleaningEditBean();
		//daoを作成
		CleaningEditDao dao = new CleaningEditDao();
		//掃除場所詳細画面から送られた掃除場所詳細を取得
		String detail = request.getParameter("detail");
		//beanにセット
		bean.setDetail(detail);
		//requestにbeanをセット
		request.setAttribute("bean", bean);
		//jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cleaningEdit.jsp");
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//daoを作成
		CleaningEditDao dao = new CleaningEditDao();
		//掃除場所詳細編集画面から送られた更新内容を取得
		String updatedDetail = request.getParameter("updatedDetail");
		//データベースに送信する
		dao.updateDetail(updatedDetail);
	}
}
