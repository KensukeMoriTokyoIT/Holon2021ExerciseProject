package jp.co.sss.general;

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
import jp.co.sss.emanage.dao.EmpDao;
import jp.co.sss.emanage.util.InputValidator; //入力チェック

@WebServlet("/CompleteServlet")
public class CompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CompleteServlet() {
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InputValidator iv = new InputValidator();
		String error = new String();
		List<String> errorMessages = new ArrayList<>();

		String empId = request.getParameter("empId");
		String newPass = request.getParameter("newPass");
		String newPassTwo = request.getParameter("newPassTwo");

		EmpBean empBean = EmpDao.findById(empId);

		request.setAttribute("empBean", empBean);

		if (empBean != null) {


		if((error=iv.passwordValidate(newPass))!=null){
			errorMessages.add(error);
		}
		//新しいパスワードの再入力があっているか
		if(!newPass.equals(newPassTwo)) {
			errorMessages.add("再入力されたパスワードが一致していません");
		}

		if(errorMessages.isEmpty()) {
			//新しいパスワードに変更
			empBean.setEmpPass(newPass);
			//データベースに反映
			EmpDao.update(empBean);

			//完了画面に遷移
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("jsp/managePass/managePassComplete.jsp");
			dispatcher.forward(request, response);

		}else {
			request.setAttribute("errorMessages", errorMessages);
			// 入力画面へ遷移を行う
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/jsp/managePass/managePassInput.jsp");
			dispatcher.forward(request, response);
			}
	}else {
	// エラー画面へ遷移を行う
	RequestDispatcher dispatcher = request
			.getRequestDispatcher("/jsp/error/error.jsp");
	dispatcher.forward(request, response );
			}

		}

	}
