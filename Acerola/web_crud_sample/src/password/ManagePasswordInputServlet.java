package password;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.EmpDao;

/**
 * Servlet implementation class ManagePasswordInputServlet
 */
@WebServlet("/ManagePasswordInputServlet")
public class ManagePasswordInputServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpBean empBeans = new EmpBean();
		String empId = request.getParameter("empId");
		empBeans = EmpDao.findById(empId);

		request.setAttribute("user", empBeans);
		request.getRequestDispatcher("/jsp/password/PasswordManage.jsp").forward(request, response);
	}
	}
