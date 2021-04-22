package update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.EmpDao;

/**
 * Servlet implementation class UpdateConfirm
 */
@WebServlet("/online/authority/MgrUpdateConfirmServlet")
public class MgrUpdateConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmpBean userInfo = new EmpBean();
		userInfo.setEmpId(request.getParameter("empId"));
		userInfo.setEmpName(request.getParameter("empName"));
		userInfo.setGender(request.getParameter("gender"));
		userInfo.setAddress(request.getParameter("address"));
		userInfo.setBirthday(request.getParameter("birthday"));
		userInfo.setAuthority(request.getParameter("authority"));
		userInfo.setDeptId(request.getParameter("deptId"));

		EmpDao.update(userInfo);

		request.getRequestDispatcher("/jsp/update/MgrUpdateConfirm.jsp").forward(request, response);
	}

}

