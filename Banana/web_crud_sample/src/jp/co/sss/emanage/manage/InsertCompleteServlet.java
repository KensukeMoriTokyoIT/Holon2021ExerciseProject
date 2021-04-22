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
		String deptName  = request.getParameter("deptName");

		EmpBean emp = new EmpBean();
		emp.setEmpPass(password);
		emp.setEmpName(empName);
		emp.setGender(gender);
		emp.setAddress(address);
		emp.setBirthday(birthday);
		emp.setAuthority(authority);
		emp.setDeptId(deptId);
		emp.setDeptName(deptName);

		EmpDao.insert(emp);
		request.getRequestDispatcher("jsp/manage/insert_complete.jsp").forward(request,response);

	}

}
