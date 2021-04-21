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
import jp.co.sss.emanage.util.DateFormat;

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
		String birthday = DateFormat.formatDate((String)empBean.getBirthday());

		updateForm.setEmpId(empBean.getEmpId()); //社員ID
		updateForm.setEmpName(empBean.getEmpName()); //社員名
		updateForm.setGender(empBean.getGender());//性別
		updateForm.setAddress(empBean.getAddress());//住所
		updateForm.setBirthday(birthday);//生年月日
		updateForm.setAuthority(empBean.getAuthority());//権限
		updateForm.setDeptId(empBean.getDeptId());//部署ID
		updateForm.setDeptName(empBean.getDeptName());//部署名

		request.setAttribute("updateForm", updateForm);
		RequestDispatcher dispatcher = request
                .getRequestDispatcher("jsp/update/check.jsp");
        dispatcher.forward(request, response);
	}
}
