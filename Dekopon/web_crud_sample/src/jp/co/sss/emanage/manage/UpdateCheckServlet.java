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
import javax.servlet.http.HttpSession;

import jp.co.sss.emanage.action.UserCheck;
import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.form.UpdateForm;
import jp.co.sss.emanage.util.InputValidator; //入力チェック

/**
 * Servlet implementation class UpdateCheckServlet
 */
@WebServlet("/UpdateCheckServlet")
public class UpdateCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//セッション取得
		HttpSession session = request.getSession();
		EmpBean user = (EmpBean) session.getAttribute("user");

		//ログイン管理 & 権限チェック
		if (UserCheck.loginCheck(user) && UserCheck.authorityCheck(user)) {
			//ログインOK、権限OK -->処理実行
			//入力チェック用クラス
			InputValidator iv = new InputValidator();
			String error = new String();
			List<String> errorMessages = new ArrayList<>();

			//アップデートフォーム
			UpdateForm updateForm = new UpdateForm();

			//社員ID
			String empId = request.getParameter("empId");
			updateForm.setEmpId(empId);
			//パスワード
			String empPass = request.getParameter("empPass");
			updateForm.setEmpPass(empPass);
			if ((error = iv.passwordValidate(empPass)) != null) {
				errorMessages.add(error);
			}
			//名前
			String empName = request.getParameter("empName");
			updateForm.setEmpName(empName);
			if ((error = iv.nameValidate(empName)) != null) {
				errorMessages.add(error);
			}
			//性別
			String gender = request.getParameter("gender");
			updateForm.setGender(gender);
			if ((error = iv.genderValidate(gender)) != null) {
				errorMessages.add(error);
			}
			//住所
			String address = request.getParameter("address");
			updateForm.setAddress(address);
			if ((error = iv.addressValidate(address)) != null) {
				errorMessages.add(error);
			}
			//生年月日
			String birthday = request.getParameter("birthday");
			birthday=birthday.replace("-", "/");
			updateForm.setBirthday(birthday);
			if ((error = iv.birthdayValidate(birthday)) != null) {
				errorMessages.add(error);
			}
			//権限
			String authority = request.getParameter("authority");
			updateForm.setAuthority(authority);
			if ((error = iv.authorityValidate(authority)) != null) {
				errorMessages.add(error);
			}
			//部署ID
			String deptId = request.getParameter("deptId");
			updateForm.setDeptId(deptId);
			if ((error = iv.deptIdValidate(deptId)) != null) {
				errorMessages.add(error);
			}

			//入力チェック
			if (errorMessages.isEmpty()) {
				request.setAttribute("updateForm", updateForm);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("jsp/update/check.jsp");
				dispatcher.forward(request, response);
			} else {
				//エラーあり
				request.setAttribute("errorMessages", errorMessages);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("jsp/update/update.jsp");
				dispatcher.forward(request, response);
			}

		} else {
			//ログインNG、または権限NG
			//ログイン画面へ遷移
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

	}

}
