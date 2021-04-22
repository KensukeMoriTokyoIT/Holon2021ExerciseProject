package jp.co.sss.emanage.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.dao.EmpDao;

/**
 * Servlet implementation class ManagePasswordCompleteServlet
 */
@WebServlet("/ManagePasswordCompleteServlet")
public class ManagePasswordCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagePasswordCompleteServlet() {
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





		   String newpassword = request.getParameter("newpassword");



		String empId   = request.getParameter("empId");




			EmpDao.updatePassword(newpassword,empId);



		request.getRequestDispatcher("jsp/manage/managepass_complete.jsp").forward(request,response);



	}

}