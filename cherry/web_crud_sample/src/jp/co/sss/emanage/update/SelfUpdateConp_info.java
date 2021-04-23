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
@WebServlet("/SelfUpdateConp_info")
public class SelfUpdateConp_info extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	        String empName = request.getParameter("empName");
	        String gender = request.getParameter("gender");
	        String address = request.getParameter("address");
	        String birthday = request.getParameter("birthday");
	        String deptName = request.getParameter("deptName");
	        EmpBean emp = new EmpBean();
	        emp.setEmpName(empName);
	        emp.setGender(gender);
	        emp.setAddress(address);
	        emp.setBirthday(birthday);
	        emp.setDeptName(deptName);
	        EmpDao.update(emp);
	        request.getRequestDispatcher("/jsp/update/employee_conp_info.jsp").forward(request, response);

	}

}