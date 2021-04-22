package password;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.form.SelfUpdateForm;

/**
 * Servlet implementation class pass
 */
@WebServlet("/pass")
public class Pass extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		SelfUpdateForm userInfo = new SelfUpdateForm();


		try {
			request.setCharacterEncoding("UTF-8");



		} catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/error/error.jsp");
			dispatcher.forward(request, response);
		}


}
}
