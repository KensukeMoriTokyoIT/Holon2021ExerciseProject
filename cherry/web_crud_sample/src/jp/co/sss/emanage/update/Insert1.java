package jp.co.sss.emanage.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.EmpDao;

/**
 * Servlet implementation class Check1
 */
@WebServlet("/Insert1")
public class Insert1 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String empId = request.getParameter("empId");
	        String empPass = request.getParameter("empPass");
	        String empName = request.getParameter("empName");
	        String gender = request.getParameter("gender");
	        String address = request.getParameter("address");
	        String birthday = request.getParameter("birthday");
	        String authority = request.getParameter("authority");
	        String deptName = request.getParameter("deptName");
	        EmpBean emp = new EmpBean();
	        emp.setEmpId(empId);
	        emp.setEmpPass(empPass);
	        emp.setEmpName(empName);
	        emp.setGender(gender);
	        emp.setAddress(address);
	        emp.setBirthday(birthday);
	        emp.setAuthority(authority);
	        emp.setDeptId(deptName);
	        EmpDao.insert(emp);
	        request.getRequestDispatcher("/jsp/update/employee_insertcon.jsp").forward(request, response);

	}

}