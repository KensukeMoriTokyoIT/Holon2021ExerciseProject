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

/**
 * Servlet implementation class SelfPassupdateServlet
 */
@WebServlet("/SelfPassupdateServlet")
public class SelfPassupdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public SelfPassupdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stuo}
	  // setCharacterEncodingメソッドを使って受け取った文字列の文字コードを指定
    request.setCharacterEncoding("UTF-8");

    String oldpassword = request.getParameter("oldpass");
    String newpassword1 = request.getParameter("newpass1");
    String newpassword2 = request.getParameter("newpass2");

    String empId = request.getParameter("empId");
    request.setAttribute("empId", empId);

    // 入力されたID、パスワードで検索する
    EmpBean empBean = EmpDao.findByIdPass (empId,oldpassword);

    // 該当する社員が見つかった場合
    if (empBean != null)

    		{

    	 //新パスワードを設定

    	if( newpassword1.equals(newpassword2)){



      EmpDao.updatePassword(empId,newpassword1);



    	//完了画面へ遷移
   	 RequestDispatcher dispatcher = request
                .getRequestDispatcher("/jsp/error/passok.jsp");
        dispatcher.forward(request, response);
return;



    }//if

    	else{ //エラー表示
    	 RequestDispatcher dispatcher = request
                 .getRequestDispatcher("/jsp/error/passerror1.jsp");
         dispatcher.forward(request, response);
         return;
     }
 }
    else { //エラー表示
	 RequestDispatcher dispatcher = request
             .getRequestDispatcher("/jsp/error/passerorr2.jsp");
     dispatcher.forward(request, response);
     return;
 }
}


}//dontfind