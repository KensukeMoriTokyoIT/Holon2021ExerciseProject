package jp.co.sss.emanage.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
//DAOとの連携

/**
 * Servlet implementation class Check1
 */
@WebServlet("/Check1")
public class Check1 extends HttpServlet {

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
	        emp.setDeptName(deptName);
	        request.setAttribute("emp", emp);
	        //遷移先アドレス入力
	        request.getRequestDispatcher("/jsp/update/employee_insertck.jsp").forward(request, response);

	}

}
