package jp.co.sss.emanage.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.EmpDao;

/**
 * Servlet implementation class InsertCompleteServlet
 */
@WebServlet("/InsertCompleteServlet")
public class InsertCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertCompleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			EmpBean empBean = new EmpBean();

			empBean.setEmpPass(request.getParameter("empPass"));
			empBean.setEmpName(request.getParameter("empName"));
			empBean.setGender(request.getParameter("gender"));
			empBean.setAddress(request.getParameter("address"));
			empBean.setBirthday(request.getParameter("birthday"));
			empBean.setAuthority(request.getParameter("authority"));
			empBean.setDeptId(request.getParameter("deptId"));
			EmpDao.insert(empBean);
			request.getRequestDispatcher("/jsp/Insert/insertcomplete.jsp").forward(request, response);

	}

}
