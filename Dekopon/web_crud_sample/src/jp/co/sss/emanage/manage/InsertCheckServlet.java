package jp.co.sss.emanage.manage;

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
import jp.co.sss.emanage.util.InputValidator;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertCheckServlet")
public class InsertCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertCheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


			//オブジェクトを生成
			EmpBean emp = new EmpBean();
			//入力チェック用クラス
			InputValidator iv = new InputValidator();
			String error = new String();
			List<String> errorMessages = new ArrayList<>();
			//パスワードを受け取る
			String password = request.getParameter("empPass");
			//社員名が無記入の場合、エラーメッセージを表示
			if ((error = iv.passwordValidate(password)) != null) {
				errorMessages.add(error);
			}
			//社員名を受け取る
			String name = request.getParameter("empName");
			//社員名が無記入の場合、エラーメッセージを表示
			if ((error = iv.nameValidate(name)) != null) {
				errorMessages.add(error);
			}
			//性別の選択を受け取る
			String gender = request.getParameter("gender");
			//性別が無選択の場合、エラーメッセージを表示
			if ((error = iv.genderValidate(gender)) != null) {
				errorMessages.add(error);
			}
			//住所を受け取る
			String address = request.getParameter("address");
			//住所が無記入の場合、エラーメッセージを表示
			if ((error = iv.addressValidate(address)) != null) {
				errorMessages.add(error);
			}
			//生年月日を受け取る
			String birthday = request.getParameter("birthday");
			birthday = DateFormat.selectFormatDate(birthday);
			//生年月日が無記入の場合、エラーメッセージを表示
			if ((error = iv.birthdayValidate(birthday)) != null) {
				errorMessages.add(error);
			}
			String authority = request.getParameter("authority");
			//権限を受け取る
			if ((error = iv.authorityValidate(authority)) != null) {
				errorMessages.add(error);
			}
			//部署名を受け取る
			String department = request.getParameter("deptId");
			//部署名が無無記入の場合、エラーメッセージを表示//
			if ((error = iv.deptIdValidate(department)) != null) {
				errorMessages.add(error);
			}
			//変数を格納する
			//パスワード
			emp.setEmpPass(password);
			//社員名
			emp.setEmpName(name);
			//性別
			emp.setGender(gender);
			//住所
			emp.setAddress(address);
			//生年月日
			emp.setBirthday(birthday);
			//権限
			emp.setAuthority(authority);
			//部署名
			emp.setDeptId(department);
			//入力チェック
			if (errorMessages.isEmpty()) {
				request.setAttribute("emp", emp);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("jsp/Insert/insertcheck.jsp");
				dispatcher.forward(request, response);
			} else {
				//エラーあり
				request.setAttribute("errorMessages", errorMessages);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("jsp/Insert/insertinput.jsp");
				dispatcher.forward(request, response);
			}

	}
}