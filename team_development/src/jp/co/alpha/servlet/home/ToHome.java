package jp.co.alpha.servlet.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ホームの表示を行うサーブレット
 */
@WebServlet("/to_home")
public class ToHome extends HttpServlet {
	// aタグで遷移した時に起動するメソッド
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("DoGet!");
//	}
	
	// forwardしたときに起動するメソッド
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DoPost!");
	}
}
