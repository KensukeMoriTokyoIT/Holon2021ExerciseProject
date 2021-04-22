package jp.co.sss.emanage.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.dao.EmpDao;

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

		if (newpassword1.equals("") && newpassword2.equals("")) {
			request.setAttribute("password_error","パスワードが入力されていません");
			request.getRequestDispatcher("jsp/manage/managepass_insert.jsp").forward(request, response);
		}


		if (!newpassword1.equals(newpassword2)) {
			request.setAttribute("password_error","パスワードが一致していません。");
			request.getRequestDispatcher("jsp/manage/managepass_insert.jsp").forward(request, response);
		}

		String empId = request.getParameter("empId");

		EmpDao.updatePassword(empId, newpassword1);

		request.getRequestDispatcher("jsp/manage/managepass_complete.jsp").forward(request, response);

	}

}