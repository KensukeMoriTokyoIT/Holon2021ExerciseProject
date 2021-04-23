package jp.co.sss.emanage.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Check1
 */
@WebServlet("/InsertInputServlet")
public class Forward1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//隠し属性のIDの値をスコープに入れる
		String id = request.getParameter("empId");
		request.setAttribute("empId", id);


		request.getRequestDispatcher("/jsp/update/employee_insert.jsp").forward(request, response);

	}

}
