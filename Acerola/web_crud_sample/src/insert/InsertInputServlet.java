package insert;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.EmpDao;
import jp.co.sss.emanage.util.DateFormat;



@WebServlet("/online/authority/InsertInputServlet")
public class InsertInputServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		EmpBean empBeans = new EmpBean();
		String empId = request.getParameter("empId");
		empBeans = EmpDao.findById(empId);

		empBeans.setBirthday(DateFormat.selectFormatDate(empBeans.getBirthday()));

		request.setAttribute("user", empBeans);


	request.getRequestDispatcher("/jsp/insert/InsertInput.jsp").forward(request, response);


	}

}




