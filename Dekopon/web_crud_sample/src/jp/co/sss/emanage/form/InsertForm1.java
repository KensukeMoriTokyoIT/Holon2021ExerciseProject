package jp.co.sss.emanage.form;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.servlet.sample08.HttpSession;

/**
 * Servlet implementation class InsertForm1
 */
@WebServlet("/InsertForm1")
public class InsertForm1 extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    //InsertFromのオブジェクトを生成
			InsertForm insertform = new InsertForm();
			//それぞれの入力項目をそれぞれの変数に代入
			//パスワード
			String empPass = request.getParameter("empPass");
			//社員名
			String empId = request.getParameter("empId");
			//住所
			String adress = request.getParameter("adress");
			//生年月日
			String birthday = request.getParameter("birthday");
			//部署
			String department = request.getParameter("depertment");
			//セッションスコープを作成
		    HttpSession session = request.getSession();
		    //パスワード
		    session.setAttribute("empPass", empPass);
		    //社員名
		    session.setAttribute("empId", empId);
		    //住所
		    session.setAttribute("adress", adress);
		    //生年月日
		    session.setAttribute("birthday", birthday);
		    //部署
		    session.setAttribute("department", department);
		    //入力確認画面へ遷移する
		    request.getRequestDispatcher("/jsp/infologin/infocomplete.jsp").forward(request, response);
	}

}
