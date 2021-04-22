package jp.co.sss.emanage.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelfPasswordInputServlet
 */
@WebServlet("/SelfPasswordInputServlet")
public class SelfPasswordInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelfPasswordInputServlet() {
        super();}
        // TODO Auto-generated constructor stub

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("empId");
		request.setAttribute("empId",empId);


        	 RequestDispatcher dispatcher = request
                     .getRequestDispatcher("/selfpass.jsp");
             dispatcher.forward(request, response);


         }
	}




