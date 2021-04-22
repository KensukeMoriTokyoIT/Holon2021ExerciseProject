package jp.co.sss.emanage.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.dao.EmpDao;

/**
 * Servlet implementation class UpdateCompleteServlet
 */
@WebServlet("/UpdateCompleteServlet")
public class UpdateCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCompleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String empId = request.getParameter("empId");
		String passWord = request.getParameter("passWord");
		String empName = request.getParameter("empName");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String birthday = request.getParameter("birthday");
		String authority = request.getParameter("authority");
		String deptId = request.getParameter("deptId");

		EmpDao.update(empId, passWord, empName, gender, address, birthday, authority, deptId);

		request.getRequestDispatcher("jsp/manage/update_complete.jsp").forward(request,response);

	}

}
