package jp.co.sss.emanage.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;


/**
 * Servlet implementation class InsertInputServlet
 */
@WebServlet("/InsertInputServlet")
public class InsertInputServlet extends HttpServlet {
			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



				//DBからID検索


				//それぞれの入力項目をそれぞれの変数に代入
			//パスワード
			String empPass = request.getParameter("empPass");
			//社員名
			String empname = request.getParameter("empname");
			//住所
			String address = request.getParameter("adress");
			//生年月日
			String birthday = request.getParameter("birthday");
			//部署名
			String department = request.getParameter("DeptName");
			//性別
			String gender = request.getParameter("gender");
			//権限
			String authority = request.getParameter("Authority");
			//EmpBeanのオブジェクトを生成
			EmpBean emp = new EmpBean();
		    //パスワード
		    emp.setEmpPass(empPass);
		    //社員名
		    emp.setEmpName(empname);
		    //住所
		    emp.setAddress(address);
		    //生年月日
		    emp.setBirthday(birthday);
		    //部署
		    emp.setDeptName(department);
		    //性別
		    emp.setGender(gender);
		    //権限
		    emp.setAuthority(authority);
		    //リクエストスコープを設置
		    request.setAttribute("emp",emp);
		    //入力確認画面へ遷移する
		    request.getRequestDispatcher("/jsp/Insert/insertinput.jsp").forward(request, response);
	}

}
