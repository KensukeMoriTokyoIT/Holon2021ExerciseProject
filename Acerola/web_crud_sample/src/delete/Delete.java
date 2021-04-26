package delete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.EmpDao;

@WebServlet("/online/authority/Delete")   //
public class Delete extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmpBean emp = new EmpBean();
		emp.setEmpId(request.getParameter("empId"));
		EmpDao.delete(emp.getEmpId());
		request.getRequestDispatcher("/jsp/delete/employee_complete.jsp").
		forward(request,response);
	}
}