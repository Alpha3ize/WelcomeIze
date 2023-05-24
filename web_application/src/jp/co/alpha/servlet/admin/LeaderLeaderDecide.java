package jp.co.alpha.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * ユーザーの追加するサーブレットです。
 */
@WebServlet("/admin_user_add")
public class AdminUserAdd extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
}
package jp.co.alpha.servlet.admin
;

import java.rmi.ServerException;
import java.rmi.server.ServerCloneException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LeaderDecide
 */
@WebServlet("/leaderDecide")
public class LeaderDecide extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServerException IOException{
		
	}
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		Part part = null;

		try {
			// Partオブジェクトの取得
			// エラー出る https://teratail.com/questions/317521 これを参照
			part = request.getPart("csvFile");
			// ファイルが選択されていない時のエラーをキャッチ
		} catch (IOException e) {
			System.err.println("エラー：CSVのPARTの奴");
			return;
		}

		// アップロードされたファイル名の取得
		String fileName = getFileName(part);
		System.out.println(fileName);
	}

	public String getFileName(Part part) {
		String name = null;
		for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
			if (dispotion.trim().startsWith("filename")) {
				name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
				name = name.substring(name.lastIndexOf("\\") + 1);
				break;
			}
		}
		return name;
	}
}
