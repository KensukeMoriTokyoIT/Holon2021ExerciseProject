package jp.co.sss.emanage.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.DeptBean;
import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.DeptDao;

/**
 * Servlet implementation class InsertConfirmServlet
 */
@WebServlet("/InsertConfirmServlet")
public class InsertConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertConfirmServlet() {
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

		String password  = request.getParameter("password");
		String empName   = request.getParameter("empName");
		String gender    = request.getParameter("gender");
		String address   = request.getParameter("address");
		String birthday  = request.getParameter("birthday");
		String authority = request.getParameter("authority");
		String deptId    = request.getParameter("deptId");
		DeptBean dept = DeptDao.findById(deptId);

		boolean get_error=false;
		if(!check_password(password)) {
			get_error = true;
			request.setAttribute("password_error", "不正な入力です。");
		}
		if(!check_empName(empName)) {
			get_error = true;
			request.setAttribute("empName_error", "不正な入力です。");
		}
		if(!check_gender(gender)) {
			get_error = true;
			request.setAttribute("gender_error", "不正な入力です。");
		}
		if(!check_address(address)) {
			get_error = true;
			request.setAttribute("address_error", "不正な入力です。");
		}
		if(!check_birthday(birthday)) {
			get_error = true;
			request.setAttribute("birthday_error", "不正な入力です。");
		}
		if(!check_authority(authority)) {
			get_error = true;
			request.setAttribute("authority_error", "不正な入力です。");
		}
		if(!check_deptId(deptId)) {
			get_error = true;
			request.setAttribute("deptId_error", "不正な入力です。");
		}
		if(get_error) {
			request.getRequestDispatcher("jsp/manage/insert_input.jsp").forward(request,response);
		}
		String deptName = dept.getDeptName();

		EmpBean emp = new EmpBean();
		emp.setEmpPass(password);
		emp.setEmpName(empName);
		emp.setGender(gender);
		emp.setAddress(address);
		emp.setBirthday(birthday);
		emp.setAuthority(authority);
		emp.setDeptId(deptId);
		emp.setDeptName(deptName);

		request.setAttribute("emp", emp);
		request.getRequestDispatcher("jsp/manage/insert_confirm.jsp").forward(request,response);

	}

	public boolean check_password(String password) {
		if(0<password.length() && password.length()<=30)return true;
		return false;

	}
	public boolean check_empName(String empName) {
		return false;

	}
	public boolean check_gender(String gender) {
		return false;

	}
	public boolean check_address(String address) {
		return false;
	}
	public boolean check_birthday(String birthday) {
		return false;
	}
	public boolean check_authority(String authority) {
		return false;
	}
	public boolean check_deptId(String deptId) {
		return false;
	}
}