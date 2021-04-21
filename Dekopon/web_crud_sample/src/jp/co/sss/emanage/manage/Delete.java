package jp.co.sss.emanage.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.compiler.Node.ForwardAction;

import jp.co.sss.emanage.dao.EmpDao;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/deletecheck.jsp")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empId=request.getParameter("empId");
		EmpDao.delete(empId);
		request.getRequestDispatcher("/jsp/delete/deletecomplere.jsp"),
        forward(request,response);

	}

}