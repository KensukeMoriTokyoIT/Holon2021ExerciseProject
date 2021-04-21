package password;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.form.SelfUpdateForm;
import jp.co.sss.emanage.util.Property;

/**
 * Servlet implementation class pass
 */
@WebServlet("/pass")
public class Pass extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		SelfUpdateForm userInfo = new SelfUpdateForm();
		userInfo.setEmpPass(request.getParameter("empPass"));

		try {
			request.setCharacterEncoding("UTF-8");

			if (userInfo.getEmpPass() != null) {
				String newpass = request.getParameter("newpass");

			String newpass2 = request.getParameter("newpass2");

			if(newpass.equals(newpass2)) {
				request.getRequestDispatcher("/jsp/password/password2.jsp").forward(request,response);
			}else {
				request.getRequestDispatcher("/jsp/error/error.jsp").forward(request,response);}
		}


			else {
				request.setAttribute("ePassword", Property.PASSWORD_EMPTY);
				request.setAttribute("user", userInfo);
				request.getRequestDispatcher("/jsp/update/InputUpdate.jsp").forward(request, response);
			}

		} catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/error/error.jsp");
			dispatcher.forward(request, response);
		}


}
}
