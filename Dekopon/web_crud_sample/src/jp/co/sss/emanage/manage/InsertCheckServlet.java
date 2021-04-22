package jp.co.sss.emanage.manage;

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
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertCheckServlet")
public class InsertCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertCheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//セッション取得
		HttpSession session = request.getSession();
		EmpBean user = (EmpBean) session.getAttribute("user");

		//ログイン管理 & 権限チェック
		if (UserCheck.loginCheck(user)==true && UserCheck.authorityCheck(user)==true) {
			//ログインOK、権限OK -->処理実行
			//オブジェクトを生成
			EmpBean emp = new EmpBean();
			//パスワードを受け取る
			String password = request.getParameter("empPass");

			//社員名を受け取る
			String name = request.getParameter("empName");

			//性別の選択を受け取る
			String gender = request.getParameter("gender");

			//住所を受け取る
			String address = request.getParameter("address");

			//生年月日を受け取る
			String birthday = request.getParameter("birthday");

			String authority = request.getParameter("authority");
			//権限を受け取る

			//部署名を受け取る
			String department = request.getParameter("department");

			//変数を格納する
			//社員名
			emp.setEmpName(name);
			//性別
			emp.setGender(gender);
			//住所
			emp.setAddress(address);
			//生年月日
			emp.setBirthday(birthday);
			//部署名
			emp.setDeptName(department);
			EmpDao.insert(emp);
			//リクエストスコープの設置
			request.setAttribute("emp", emp);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("jsp/Insert/insertComplete.jsp");
			dispatcher.forward(request, response);

		} else {
			//ログインNG、または権限NG
			//ログイン画面へ遷移
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

	}
}