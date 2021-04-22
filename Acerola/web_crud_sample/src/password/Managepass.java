package password;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.PassBean;
import jp.co.sss.emanage.dao.EmpDao;
import jp.co.sss.emanage.util.Property;

/**
 * Servlet implementation class pass
 */
@WebServlet("/ManagePass")
public class Managepass extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PassBean passBean = new PassBean();
		passBean.setNewPass(request.getParameter("newPass"));
		passBean.setEmpId(request.getParameter("empId"));
		passBean.setPassCheck(request.getParameter("passCheck"));

		try {
			request.setCharacterEncoding("UTF-8");
			if(passBean.getNewPass().equals("")) {
				request.setAttribute("user", passBean);
				request.setAttribute("eNewPass", Property.PASSWORD_EMPTY);
				request.getRequestDispatcher("/jsp/password/PasswordManage.jsp").forward(request,response);}

			if(passBean.getPassCheck().equals("")) {
					request.setAttribute("user", passBean);
					request.setAttribute("ePassCheck", Property.PASSWORD_EMPTY);
					request.getRequestDispatcher("/jsp/password/PasswordManage.jsp").forward(request,response);
			}

		if(passBean.getNewPass().equals(passBean.getPassCheck())) {
			EmpDao.updateNewPass(passBean.getNewPass(),passBean.getEmpId());
			request.getRequestDispatcher("/jsp/password/managepass.jsp").forward(request,response);
		}
		else {
			request.setAttribute("user", passBean);
			request.setAttribute("ePassCheck", Property.PASSWORD_MISMATCH);
			request.getRequestDispatcher("/jsp/password/PasswordManage.jsp").forward(request,response);
		}


		} catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/error/error.jsp");
			dispatcher.forward(request, response);
		}
}
	}
