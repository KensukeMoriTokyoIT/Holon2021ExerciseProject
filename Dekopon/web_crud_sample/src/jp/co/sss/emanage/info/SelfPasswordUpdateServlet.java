package jp.co.sss.emanage.info;

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
import jp.co.sss.emanage.dao.EmpDao;
import jp.co.sss.emanage.util.InputValidator; //入力チェック
import jp.co.sss.emanage.util.Property;

/**
 * Servlet implementation class SelfPasswordUpdateServlet
 */
@WebServlet("/SelfPasswordUpdateServlet")
public class SelfPasswordUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelfPasswordUpdateServlet() {
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

		//ログイン管理
		if (UserCheck.loginCheck(user)) {
			//ログインOK -->処理実行
			//入力チェック用クラス
			InputValidator iv = new InputValidator();
			String error = new String();
			List<String> errorMessages = new ArrayList<>();

			//前ページの情報取得
			String empId = request.getParameter("empId");
			String nowPass = request.getParameter("nowPass");
			String newPass = request.getParameter("newPass");
			String newPassTwo = request.getParameter("newPassTwo");

			// IDで検索する
			EmpBean empBean = EmpDao.findById(empId);

			request.setAttribute("empBean", empBean);

			//社員IDに対応すること社員が存在するか確認
			if (empBean != null) {
				//現在のパスワード正誤確認
				if (!empBean.getEmpPass().equals(nowPass)) {
					errorMessages.add(Property.NOW_PASSWORD_MISMATCH);
				}
				//新しいパスワードの入力チェック
				if ((error = iv.passwordValidate(newPass)) != null) {
					errorMessages.add(error);
				}
				//新しいパスワードの再入力があっているか
				if (!newPass.equals(newPassTwo)) {
					errorMessages.add("再入力されたパスワードが一致していません");
				}

				if (errorMessages.isEmpty()) {
					//新しいパスワードに変更
					empBean.setEmpPass(newPass);
					//データベースに反映
					EmpDao.update(empBean);

					//完了画面に遷移
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("jsp/selfPass/selfPassComplete.jsp");
					dispatcher.forward(request, response);

				} else {
					request.setAttribute("errorMessages", errorMessages);
					// 入力画面へ遷移を行う
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/jsp/selfPass/selfPassInput.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				// エラー画面へ遷移を行う
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/jsp/error/error.jsp");
				dispatcher.forward(request, response);
			}

		} else {
			//ログインNG
			//ログイン画面へ遷移
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

	}

}
