package insert;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.EmpDao;
import jp.co.sss.emanage.util.DateFormat;
@WebServlet("/online/authority/InsertComplete")
public class InsertComplete extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {


	String empPass = request.getParameter("empPass");
	String empName = request.getParameter("empName");
	String gender = request.getParameter("gender");
	String address = request.getParameter("address");
	String birthday = request.getParameter("birthday");
	String authority = request.getParameter("authority");
	String deptId = request.getParameter("deptId");

	EmpBean emp = new EmpBean();
	emp.setEmpPass(empPass);
	emp.setEmpName(empName);
	emp.setGender(gender);
	emp.setAddress(address);
	emp.setBirthday(DateFormat.formatDate(birthday));
	emp.setAuthority(authority);
	emp.setDeptId(deptId);

	request.setAttribute("B", emp.getBirthday());

	EmpDao.insert(emp);
	request.getRequestDispatcher("/jsp/insert/InsertComplete.jsp").forward(request, response);


	}

}

