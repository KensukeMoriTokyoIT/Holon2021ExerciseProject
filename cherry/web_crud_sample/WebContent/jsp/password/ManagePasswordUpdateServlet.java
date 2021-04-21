package password;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sss.emanage.bean.EmpBean;
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

            // セッションを利用する準備
            HttpSession session = ((HttpServletRequest)request).getSession(false);

            EmpBean empBean = (EmpBean) session.getAttribute("user");
            //パスワードと確認用のパスワードの値を受け取る
            String id = request.getParameter("empId");
            String NewPassword = request.getParameter("empNewPass");
            String reNewPassword = request.getParameter("empReNewPass");

            if (NewPassword == reNewPassword)
            {
            RequestDispatcher dispatcher = request
            		.getRequestDispatcher("/jsp/password/manage_pass_complte.jsp");
            dispatcher.forward(request, response);

            }else {

            	request.setAttribute("errorMessage", "新しいパスワードと確認用のパスワードが違います");

                // 管理者用パスワード変更画面へ遷移を行う
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("/jsp/password/manage_pass.jsp");
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