package jp.co.sss.emanage.pass;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.EmpDao;
import jp.co.sss.emanage.util.InputValidator;
/**
 * Servlet implementation class ManagePasswordChangeServlet
 */
@WebServlet("/ManagePasswordUpdateServlet")
public class ManagePasswordUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagePasswordUpdateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// setCharacterEncodingメソッドを使って受け取った文字列の文字コードを指定
            request.setCharacterEncoding("UTF-8");

            //パスワードと確認用のパスワードの値を受け取る
            String password = request.getParameter("empPass");
            String repassword = request.getParameter("empRePass");

            //指定されたid情報を受け取る
            String id = request.getParameter("empId");

            //InputValidatorクラスのpasswrodValidateメソッドを使う
            InputValidator vali = new InputValidator();
            String error = vali.passwordValidate(password);

            if(!( password.equals(repassword))){
            	request.setAttribute("errorMessage", "新しいパスワードと確認用のパスワードが違います");

                // 管理者用パスワード変更画面へ遷移を行う
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("/jsp/password/manage_pass.jsp");
                dispatcher.forward(request, response);

            }else if (error != null)
            {
            	request.setAttribute("errorMessage",error);
            	 // 管理者用パスワード変更画面へ遷移error を行う
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("/jsp/password/manage_pass.jsp");
                dispatcher.forward(request, response);


            }else {
            	EmpBean emp = new EmpBean();
            	emp.setEmpId(id);
            	emp.setEmpPass(password);

            	EmpDao.updateEmployeePassword(emp);

            	 RequestDispatcher dispatcher = request
                 		.getRequestDispatcher("/jsp/password/manage_pass_complete.jsp");
                 dispatcher.forward(request, response);

            }
		}
	  catch (Exception e) {
         // エラー画面へ遷移を行う
         RequestDispatcher dispatcher = request
                 .getRequestDispatcher("/jsp/error/error.jsp");
         dispatcher.forward(request, response);
	}
}
}