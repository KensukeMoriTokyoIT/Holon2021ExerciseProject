package jp.co.sss.emanage.manage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.EmpDao;

/**
 * Servlet implementation class ManagePasswordInputServlet
 */
@WebServlet("/ManagePasswordInputServlet")
public class ManagePasswordInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagePasswordInputServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			//前ページから送られた社員ID取得
			String empId = request.getParameter("empId");

			//ID検索して情報取得
			EmpBean empBean = EmpDao.findById(empId);

			request.setAttribute("empBean", empBean);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("jsp/managePass/managePassInput.jsp");
			dispatcher.forward(request, response);

	}

}
