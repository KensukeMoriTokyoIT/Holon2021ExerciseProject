package jp.co.sss.emanage.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.dao.EmpDao;


@WebServlet("/Delete1")
public class Delete1 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String empId = request.getParameter("empId");
			EmpDao.delete(empId);
	        request.getRequestDispatcher("/jsp/update/employee_deletecon.jsp").forward(request, response);
	}

}
