/**
 * ユーザーの追加するサーブレットです。
 * 参考文献：https://qiita.com/ohke/items/bec00a69d3f538aab06b
 * @author okabe
 */
package jp.co.alpha.servlet.admin;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import jp.co.alpha.bean.Users;
import jp.co.alpha.dao.UsersDao;

@WebServlet("/admin_user_add")
@MultipartConfig(location = "/tmp", maxFileSize = 1048576)
//@MultipartConfig
public class AdminUserAdd extends HttpServlet {
	private final String UPLOADED_PATH = "C:\\workspace\\team_development\\WebContent\\WEB-INF\\uploaded/";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part part = null;
		try {
			// Partオブジェクトの取得
			part = request.getPart("csvFile");
			// ファイルが選択されていない時のエラーをキャッチ
		} catch (IOException e) {
			System.err.println("エラー：CSVのPARTの奴。多分tmpファイルの位置がダメ");
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/jsp/admin_user_add.jsp");
		}
		String name = this.getFileName(part);
		part.write(UPLOADED_PATH + name);
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(UPLOADED_PATH + name),
				"UTF-8"));
		String line;
		List<Users> csvList = new ArrayList<Users>();
		for (int i = 0; (line = br.readLine()) != null; i++) {
			if (i == 0) {
				continue;
			}
			String[] textArr = line.split(",");
			Users user = new Users();
			user.setName(textArr[0]);
			user.setEmail(textArr[1]);
			user.setPassword(textArr[2]);
			csvList.add(user);
		}
		br.close();
		List<Users> userList = UsersDao.listCreater(csvList);
		HttpSession session = request.getSession();
		session.setAttribute("userList", userList);
		request.getRequestDispatcher("/jsp/admin_user_confirm.jsp").forward(request, response);
	}

	private String getFileName(Part part) {
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
