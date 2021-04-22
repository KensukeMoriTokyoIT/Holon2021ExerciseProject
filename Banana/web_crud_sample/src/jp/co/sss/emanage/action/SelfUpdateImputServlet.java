package jp.co.sss.emanage.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.EmpDao;

/**
 * Servlet implementation class SelfUpdateImputServlet
 */
@WebServlet("/SelfUpdateImputServlet")
public class SelfUpdateImputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelfUpdateImputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String empId = request.getParameter("empId");
		String empName = request.getParameter("empName");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String birthday = request.getParameter("birthday");
		String deptId = request.getParameter("deptId");


		EmpBean emp = EmpDao.findById(empId);

		System.out.println(emp.getEmpName());
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("jsp/manage/self_update_confirm.jsp").forward(request,response);

	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
