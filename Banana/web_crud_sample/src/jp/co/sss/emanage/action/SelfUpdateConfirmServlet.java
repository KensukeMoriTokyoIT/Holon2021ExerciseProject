package jp.co.sss.emanage.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.util.InputValidator;

/**
 * Servlet implementation class SelfUpdateConfirmServlet
 */
@WebServlet("/SelfUpdateConfirmServlet")
public class SelfUpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelfUpdateConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String empId = request.getParameter("empId");
		String password = request.getParameter("password");
		String empName = request.getParameter("empName");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String birthday = request.getParameter("birthday");
		String authority = request.getParameter("authority");
		String deptId = request.getParameter("deptId");

		InputValidator validator = new InputValidator();
		String password_error = validator.passwordValidate(password);
		String empName_error = validator.nameValidate(empName);
		String gender_error = validator.genderValidate(gender);
		String address_error = validator.addressValidate(address);
		String birthday_error = validator.birthdayValidate(birthday);
		String authority_error = validator.authorityValidate(authority);
		String deptId_error = validator.deptIdValidate(deptId);

		request.setAttribute("password_error",password_error);
		request.setAttribute("empName_error", empName_error);
		request.setAttribute("gender_error", gender_error);
		request.setAttribute("address_error", address_error);
		request.setAttribute("birthday_error", birthday_error);
		request.setAttribute("authority_error", authority_error);
		request.setAttribute("deptId_error", deptId_error);

		EmpBean emp = new EmpBean();

		emp.setEmpId(empId);
		emp.setEmpPass(password);
		emp.setEmpName(empName);
		emp.setGender(gender);
		emp.setAddress(address);
		emp.setBirthday(birthday);
		emp.setAuthority(authority);
		emp.setDeptId(deptId);
		request.setAttribute("emp", emp);

		if (password_error != null ||
			empName_error  != null  ||
			gender_error   != null  ||
			address_error  != null  ||
			birthday_error != null  ||
			authority_error!= null  ||
			deptId_error   != null) {
			request.getRequestDispatcher("jsp/info/self_update.jsp").forward(request,response);
		}
		else {
			request.getRequestDispatcher("jsp/info/self_update_confirm.jsp").forward(request,response);
		}
	}

}
