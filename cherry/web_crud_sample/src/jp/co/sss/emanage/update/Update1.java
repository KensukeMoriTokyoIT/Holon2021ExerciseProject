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
@WebServlet("/Update1")
public class Update1 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String empId = request.getParameter("empId");
	        String empName = request.getParameter("empName");
	        String gender = request.getParameter("gender");
	        String address = request.getParameter("address");
	        String birthday = request.getParameter("birthday");
	        String authority = request.getParameter("authority");
	        String deptName = request.getParameter("deptName");
	        EmpBean emp = new EmpBean();
	        emp.setEmpId(empId);
	        emp.setEmpName(empName);
	        emp.setGender(gender);
	        emp.setAddress(address);
	        emp.setBirthday(birthday);
	        emp.setAuthority(authority);
	        emp.setDeptId(deptName);
	        EmpDao.update(emp);

	        System.out.println(empId);
	        System.out.println(empName);
	        System.out.println(gender);
	        System.out.println(address);
	        System.out.println(birthday);
	        System.out.println(authority);
	        System.out.println(deptName);

	        request.getRequestDispatcher("/jsp/update/employee_updatecon.jsp").forward(request, response);

	}

}