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
import jp.co.sss.emanage.form.DeleteForm;

/**
 * Servlet implementation class DeleteConfirmServlet
 */
@WebServlet("/DeleteConfirmServlet")
public class DeleteConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	*/
	public DeleteConfirmServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DeleteForm deleteForm = new DeleteForm();
		//DBからID検索

		EmpBean empBean = EmpDao.findById(request.getParameter("empId"));

		deleteForm.setEmpId(empBean.getEmpId());
		deleteForm.setEmpName(empBean.getEmpName());
		deleteForm.setGender(empBean.getGender());
		deleteForm.setAddress(empBean.getAddress());
		deleteForm.setBirthday(empBean.getBirthday());
		deleteForm.setAuthority(empBean.getAuthority());
		deleteForm.setDeptId(empBean.getDeptId());
		deleteForm.setDeptName(empBean.getDeptName());

		request.setAttribute("deleteForm", deleteForm);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/delete/deletecheck.jsp");
		dispatcher.forward(request, response);
	}
}