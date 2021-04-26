package jp.co.sss.emanage.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.EmpDao;

/**
 * Servlet implementation class SelfPassupdateServlet
 */
@WebServlet("/SelfPassUpdateServlet")
public class SelfPassUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SelfPassUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stuo}
		// setCharacterEncodingメソッドを使って受け取った文字列の文字コードを指定
		request.setCharacterEncoding("UTF-8");

		String empId = request.getParameter("empId");
		request.setAttribute("empId", empId);

		EmpBean emp = EmpDao.findById(empId);

		String oldpassword = request.getParameter("oldpass");

		if (!emp.getEmpPass().equals(oldpassword)) {
			request.setAttribute("password_error", "パスワードが正しくありません。");
			request.getRequestDispatcher("jsp/info/selfpass.jsp").forward(request, response);
			return;  //returnしないと処理が継続し、DBを更新してしまう。
		}

		String newpassword1 = request.getParameter("newpass1");
		String newpassword2 = request.getParameter("newpass2");

		if (newpassword1.equals(newpassword2)) {
			EmpDao.updatePassword(empId, newpassword1);
			request.getRequestDispatcher("jsp/info/passok.jsp").forward(request, response);

		} else {
			request.setAttribute("password_error", "パスワードが一致していません。");
			request.getRequestDispatcher("jsp/info/selfpass.jsp").forward(request, response);

		}

	}
}
