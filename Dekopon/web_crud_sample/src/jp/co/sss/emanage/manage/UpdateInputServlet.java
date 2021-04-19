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
import jp.co.sss.emanage.form.UpdateForm;

/**
 * Servlet implementation class UpdateInputServlet
 */
@WebServlet("/UpdateInputServlet")
public class UpdateInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateInputServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UpdateForm updateForm = new UpdateForm();
		//DBからID検索
		EmpBean empBean = EmpDao.findById(request.getParameter("empId"));

		updateForm.setEmpName(empBean.getEmpName());
		updateForm.setGender(empBean.getGender());
		updateForm.setAddress(empBean.getAddress());
		updateForm.setBirthday(empBean.getBirthday());

		request.setAttribute("updateForm", updateForm);

		RequestDispatcher dispatcher = request
                .getRequestDispatcher("jsp/update/update.jsp");
        dispatcher.forward(request, response);
	}
}
