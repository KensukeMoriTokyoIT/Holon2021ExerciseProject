package jp.co.sss.emanage.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.dao.EmpDao;
import jp.co.sss.emanage.util.InputValidator;

/**
 * Servlet implementation class ManagePasswordCompleteServlet
 */
@WebServlet("/ManagePasswordCompleteServlet")
public class ManagePasswordCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagePasswordCompleteServlet() {
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
		// TODO Auto-generated method stub

		String newpassword1 = request.getParameter("newpass1");
		String newpassword2 = request.getParameter("newpass2");

		InputValidator passValid1 = new InputValidator();
		InputValidator passValid2 = new InputValidator();

		String error1 = passValid1.passwordValidate(newpassword1);
		String error2 = passValid2.passwordValidate(newpassword2);

		if ((error1 == null && error2 == null) && newpassword1.equals(newpassword2)) {
			String empId = request.getParameter("empId");
			EmpDao.updatePassword(empId, newpassword1);
			request.getRequestDispatcher("jsp/manage/managepass_complete.jsp").forward(request, response);
			return;
		} else if (!newpassword1.equals(newpassword2)) {
			request.setAttribute("password_error", "パスワードが一致しません");
			request.getRequestDispatcher("jsp/manage/managepass_insert.jsp").forward(request, response);
			return;
		} else if (error1 != null) {
			request.setAttribute("password_error", error1);
			request.getRequestDispatcher("jsp/manage/managepass_insert.jsp").forward(request, response);
			return;
		} else {
			request.setAttribute("password_error", error2);
			request.getRequestDispatcher("jsp/manage/managepass_insert.jsp").forward(request, response);
		}
	}
}