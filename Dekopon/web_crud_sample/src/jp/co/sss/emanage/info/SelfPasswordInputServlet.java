package jp.co.sss.emanage.info;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sss.emanage.action.UserCheck;
import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.EmpDao;

/**
 * Servlet implementation class SelfPasswordInputServlet
 */
@WebServlet("/SelfPasswordInputServlet")
public class SelfPasswordInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelfPasswordInputServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//セッション取得
		HttpSession session = request.getSession();
		EmpBean user = (EmpBean) session.getAttribute("user");

		//ログイン管理
		if (UserCheck.loginCheck(user)) {
			//ログインOK -->処理実行
			//前ページから送られた社員ID取得
			String empId = request.getParameter("empId");

			//ID検索して情報取得
			EmpBean empBean = EmpDao.findById(empId);

			request.setAttribute("empBean", empBean);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("jsp/selfPass/selfPassInput.jsp");
			dispatcher.forward(request, response);

		} else {
			//ログインNG
			//ログイン画面へ遷移
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

	}

}
