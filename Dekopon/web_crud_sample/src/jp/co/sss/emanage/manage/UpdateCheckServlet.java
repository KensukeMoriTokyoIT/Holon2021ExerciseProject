package jp.co.sss.emanage.manage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.form.UpdateForm;

/**
 * Servlet implementation class UpdateCheckServlet
 */
@WebServlet("/UpdateCheckServlet")
public class UpdateCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdateForm updateForm = new UpdateForm();

		String empId = request.getParameter("empId"); //社員ID
		String empPass = request.getParameter("empPass"); //パスワード
		String empName = request.getParameter("empName"); //名前
		String gender = request.getParameter("gender"); //性別
		String address = request.getParameter("address"); //住所
		String birthday = request.getParameter("birthday"); //生年月日
		String authority = request.getParameter("authority"); //権限
		String deptId = request.getParameter("deptId"); //部署ID

		updateForm.setEmpId(empId);
		updateForm.setEmpPass(empPass);
		updateForm.setEmpName(empName);
		updateForm.setGender(gender);
		updateForm.setAddress(address);
		updateForm.setBirthday(birthday);
		updateForm.setAuthority(authority);
		updateForm.setDeptId(deptId);

		request.setAttribute("updateForm", updateForm);
		RequestDispatcher dispatcher = request
                .getRequestDispatcher("jsp/update/check.jsp");
        dispatcher.forward(request, response);

	}

}
