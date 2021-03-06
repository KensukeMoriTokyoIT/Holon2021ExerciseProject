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
 * Servlet implementation class UpdateDBServlet
 */
@WebServlet("/UpdateDBServlet")
public class UpdateDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateDBServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			EmpBean empBean = new EmpBean();

			empBean.setEmpId(request.getParameter("empId")); //社員ID
			empBean.setEmpPass(request.getParameter("empPass")); //パスワード
			empBean.setEmpName(request.getParameter("empName")); //社員名
			empBean.setGender(request.getParameter("gender")); //性別
			empBean.setAddress(request.getParameter("address")); //住所
			empBean.setBirthday(request.getParameter("birthday")); //生年月日
			empBean.setAuthority(request.getParameter("authority")); //権限
			empBean.setDeptId(request.getParameter("deptId")); //部署ID

			EmpDao.update(empBean);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("jsp/update/complete.jsp");
			dispatcher.forward(request, response);

	}
}
