package jp.co.sss.emanage.pass_emp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.EmpDao;
import jp.co.sss.emanage.util.InputValidator;
/**
 * Servlet implementation class ManagePasswordChangeServlet
 */
@WebServlet("/SelfPasswordUpdateServlet")
public class SelfPasswordUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelfPasswordUpdateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// setCharacterEncodingメソッドを使って受け取った文字列の文字コードを指定
            request.setCharacterEncoding("UTF-8");

            //入力されたパスワードの値を受け取る
            String emprepassword = request.getParameter("emp_Pass");
            String password = request.getParameter("empPass");
            String repassword = request.getParameter("empRePass");

            // セッションを利用する準備
            HttpSession session = request.getSession(false);

            //セッションスコープからオブジェクトを取り出す
            EmpBean empl = (EmpBean) session.getAttribute("user");
            String id = empl.getEmpId();

        	//取り出したオブジェクトを使ってパスワードを取り出す
            EmpBean emp = new EmpBean();
        	emp.setEmpId(id);
        	emp.setEmpPass(emprepassword);
            EmpBean pass = EmpDao.findByIdPass(id,emprepassword);

            //InputValidatorクラスのpasswrodValidateメソッドを使う
            InputValidator vali = new InputValidator();
            String error = vali.passwordValidate(password);
            if(pass == null){
            	request.setAttribute("errorMessage", "入力されたパスワードが一致しません");

                // 一般者用パスワード変更画面へ遷移を行う
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("/jsp/password_emp/emp_pass.jsp");
                dispatcher.forward(request, response);


			}else if(!( password.equals(repassword))){
            	request.setAttribute("errorMessage", "新しいパスワードと確認用のパスワードが違います");

                // 一般者用パスワード変更画面へ遷移を行う
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("/jsp/password_emp/emp_pass.jsp");
                dispatcher.forward(request, response);

            }else if (error != null)
            {
            	request.setAttribute("errorMessage",error);
            	 // 一般者用パスワード変更画面へ遷移を行う
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("/jsp/password_emp/emp_pass.jsp");
                dispatcher.forward(request, response);


            }else {
            	//Daoを使う準備
            	EmpBean emp2 = new EmpBean();
            	emp2.setEmpId(id);
            	emp2.setEmpPass(password);

            	EmpDao.updateEmployeePassword(emp2);

            	 RequestDispatcher dispatcher = request
                 		.getRequestDispatcher("/jsp/password_emp/emp_pass_complete.jsp");
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