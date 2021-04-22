package update;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.form.SelfUpdateForm;
import jp.co.sss.emanage.util.Property;

/**
 * Servlet implementation class UpdateCheck
 */
@WebServlet("/MgrUpdateCheckServlet")
public class MgrUpdateCheck extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SelfUpdateForm userInfo = new SelfUpdateForm();
		userInfo.setEmpId(request.getParameter("empId"));
		userInfo.setEmpName(request.getParameter("empName"));
		userInfo.setGender(request.getParameter("gender"));
		userInfo.setAddress(request.getParameter("address"));
		userInfo.setBirthday(request.getParameter("birthday"));
		userInfo.setAuthority(request.getParameter("authority"));
		userInfo.setDeptId(request.getParameter("deptId"));
		Pattern p = Pattern.compile("^(1[0-9]{3}|20[01]{1}[0-9]{1})/(0[1-9]{1}|1[0-2]{1})/(0[1-9]{1}|[1-2]{1}[0-9]{1}|3[01]{1})$");
		Matcher m = p.matcher(userInfo.getBirthday());


		try {
			request.setCharacterEncoding("UTF-8");

			 if(userInfo.getEmpName().equals("")) {
				request.setAttribute("user", userInfo);
				request.setAttribute("eName", Property.NAME_EMPTY);
				request.getRequestDispatcher("/jsp/update/MgrInputUpdate.jsp").forward(request,response);
			}
			 else if (userInfo.getEmpName().length() > 30) {
					request.setAttribute("user", userInfo);
					request.setAttribute("eName", Property.NAME_LENGTH_OVER);
					request.getRequestDispatcher("/jsp/update/MgrInputUpdate.jsp").forward(request,response);
				}
			 if(userInfo.getGender().equals(null)) {
				request.setAttribute("user", userInfo);
				request.setAttribute("eGender", Property.GENDER_EMPTY);
				request.getRequestDispatcher("/jsp/update/MgrInputUpdate.jsp").forward(request,response);

			}
			 if(userInfo.getAddress().equals("")) {
					request.setAttribute("user", userInfo);
					request.setAttribute("eAddress", Property.ADDRESS_EMPTY);
					request.getRequestDispatcher("/jsp/update/MgrInputUpdate.jsp").forward(request,response);
				}
			 else if(userInfo.getAddress().length() > 60) {
				request.setAttribute("user", userInfo);
				request.setAttribute("eAddress", Property.ADDRESS_LENGTH_OVER);
				request.getRequestDispatcher("/jsp/update/MgrInputUpdate.jsp").forward(request,response);
			}
			if(userInfo.getBirthday().equals("")) {
				request.setAttribute("user", userInfo);
				request.setAttribute("eBirthday", Property.BIRTHDAY_EMPTY);
				request.getRequestDispatcher("/jsp/update/MgrInputUpdate.jsp").forward(request,response);
			}
			else if(m.find()==false){
				request.setAttribute("user", userInfo);
				request.setAttribute("eBirthday", Property.BIRTHDAY_MISSMATCH);
				request.getRequestDispatcher("/jsp/update/MgrInputUpdate.jsp").forward(request,response);
			}


			if(userInfo.getAuthority().equals(null)) {
				request.setAttribute("user", userInfo);
				request.setAttribute("eAuthority", Property.AUTHORITY_EMPTY);
				request.getRequestDispatcher("/jsp/update/MgrInputUpdate.jsp").forward(request,response);
			}
			 if(userInfo.getDeptId().equals(null)) {
				request.setAttribute("user", userInfo);
				request.setAttribute("eDept", Property.DEPT_EMPTY);
				request.getRequestDispatcher("/jsp/update/MgrInputUpdate.jsp").forward(request,response);
			}


request.setAttribute("user", userInfo);
request.getRequestDispatcher("/jsp/update/MgrUpdateCheck.jsp").forward(request,response);





		} catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/error/error.jsp");
			dispatcher.forward(request, response);
		}


	}

}

