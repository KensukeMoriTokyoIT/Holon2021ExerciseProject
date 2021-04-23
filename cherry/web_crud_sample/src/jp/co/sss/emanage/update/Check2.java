package jp.co.sss.emanage.update;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.util.DateFormat;
//DAOとの連携
import jp.co.sss.emanage.util.InputValidator;

@WebServlet("/Check2")
public class Check2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String empId = request.getParameter("empId");
	        String empPass = request.getParameter("empPass");
	        String empName = request.getParameter("empName");
	        String gender = request.getParameter("gender");
	        String address = request.getParameter("address");
	        String birthday = request.getParameter("birthday");
	        String authority = request.getParameter("authority");
	        String deptName = request.getParameter("deptName");

	     // InputValidatorクラスのメソッドを用いてエラーチェック
	        InputValidator vali = new InputValidator();

	        List<String> error = new ArrayList<>();
	        error.add(vali.nameValidate(empName));
	        error.add(vali.genderValidate(gender));
	        error.add(vali.addressValidate(address));
	        error.add(vali.birthdayValidate(birthday));
	        error.add(vali.authorityValidate(authority));
	        error.add(vali.deptNameValidate(deptName));

	        // エラーメッセージをリクエストスコープに登録
	        request.setAttribute("errorMessage_name", error.get(0));
	        request.setAttribute("errorMessage_gender", error.get(1));
	        request.setAttribute("errorMessage_address", error.get(2));
	        request.setAttribute("errorMessage_birthday", error.get(3));
	        request.setAttribute("errorMessage_authority", error.get(4));
	        request.setAttribute("errorMessage_dept", error.get(5));

	        int count = 0;
	        for (String e : error) {
	        	if (e != null) {
	        		++count;
	        		break;
	        	}
	        }

	        EmpBean emp = new EmpBean();
	        birthday = DateFormat.tempformatDate(birthday);
        	emp.setEmpId(empId);
        	emp.setEmpPass(empPass);
        	emp.setEmpName(empName);
        	emp.setGender(gender);
        	emp.setAddress(address);
        	emp.setBirthday(birthday);
        	emp.setAuthority(authority);
        	emp.setDeptName(deptName);
        	request.setAttribute("empBean", emp);

	        if (count == 0) {
	        	//遷移先アドレス入力
	        	request.getRequestDispatcher("/jsp/update/employee_updateck.jsp").forward(request, response);
	        } else {
	        	RequestDispatcher dispatcher = request
                        .getRequestDispatcher("jsp/update/employee_update.jsp");
                dispatcher.forward(request, response);
	        }
	}

}
