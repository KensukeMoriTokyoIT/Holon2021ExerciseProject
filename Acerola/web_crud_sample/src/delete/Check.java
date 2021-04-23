package delete;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.*;

@WebServlet("/check")
public class Check extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empId = request.getParameter("empId");
		EmpBean emp = EmpDao.findById(empId);
		request.setAttribute("emp",emp);
		request.getRequestDispatcher("/jsp/delete/employee_check").
		forward(request,response);
	}
}