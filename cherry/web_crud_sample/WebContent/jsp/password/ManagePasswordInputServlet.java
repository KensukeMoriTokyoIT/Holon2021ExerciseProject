package password;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class ManagePasswordChangeServlet
 */
@WebServlet("/ManagePasswordInputServlet")
public class ManagePasswordInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagePasswordInputServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       	// 管理者用パスワード変更画面へ遷移を行う
         RequestDispatcher dispatcher = request
                        .getRequestDispatcher("/jsp/password/manage_pass.jsp");
                dispatcher.forward(request, response);
            }
}
