package jp.co.sss.emanage.info;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//入力チェック用クラス
		InputValidator iv = new InputValidator();

		//前ページの情報取得
		String empId = request.getParameter("empId");
		String nowPass = request.getParameter("nowPass");
		String newPass = request.getParameter("newPass");
		String newPassTwo = request.getParameter("newPassTwo");

		// IDで検索する
		EmpBean empBean = EmpDao.findById(empId);
		String errorMessage = iv.passwordValidate(newPass);

		request.setAttribute("empBean", empBean);

		//入力した現在のパスワードがデータベースの値と一致しているとき
		if (empBean != null && empBean.getEmpPass().equals(nowPass)) {
			if (newPass.equals(newPassTwo)) {
				//新しいパスワードの入力チェック
				//OK
				if (errorMessage == null) {
					//新しいパスワードに変更
					empBean.setEmpPass(newPass);

					//データベースに反映
					EmpDao.update(empBean);

					//完了画面に遷移
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("jsp/selfPass/selfPassComplete.jsp");
					dispatcher.forward(request, response);

				} else { //未入力または桁数オーバー
					request.setAttribute("errorMessageNewPass", errorMessage);

					// 入力画面へ遷移を行う
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("/jsp/selfPass/selfPassInput.jsp");
					dispatcher.forward(request, response);
				}

			}else { //新しいパスワードが再入力と一致しない
				request.setAttribute("errorMessageNewPass2", "再入力されたパスワードが新しいパスワードと一致しません");

				// 入力画面へ遷移を行う
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/jsp/selfPass/selfPassInput.jsp");
				dispatcher.forward(request, response);
			}

		} else {
			request.setAttribute("errorMessageNowPass", Property.NOW_PASSWORD_MISMATCH);

			// 入力画面へ遷移を行う
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/jsp/selfPass/selfPassInput.jsp");
			dispatcher.forward(request, response);
		}

	}

}
