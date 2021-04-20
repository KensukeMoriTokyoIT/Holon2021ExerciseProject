package jp.co.sss.emanage.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.EmpDao;
import jp.co.sss.emanage.util.Property;

/**
 * Servlet implementation class SelfPasswordInputServlet
 */
@WebServlet("/SelfPasswordInputServlet")
public class SelfPasswordInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelfPasswordInputServlet() {
        super();}
        // TODO Auto-generated constructor stub

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

            // setCharacterEncodingメソッドを使って受け取った文字列の文字コードを指定
            request.setCharacterEncoding("UTF-8");

            String oldpassword = request.getParameter("oldpass");
            String newpassword1 = request.getParameter("newpass1");
            String newpassword2 = request.getParameter("newpass2");

           
      
            // 入力されたID、パスワードで検索する
            EmpBean empBean = EmpDao.findByIdPass (empid,oldpassword);

            // 該当する社員が見つかり、かつ一般権限だった場合
            if (empBean != null
                    && empBean.getAuthority().equals(Property.EMPLOYEE)) {


            //新パスワードを設定

            	if( newpassword1.equals(newpassword2)){
            	  String newpassword1 = request.getParameter("newpass1");
            	  newpassword1.setnewpassword1("newpass1");
            	EmpBean empbean = EmpDao. 
              



            }//if
         
            { //エラー表示
            	 RequestDispatcher dispatcher = request
                         .getRequestDispatcher("/jsp/error/passerror1.jsp");
                 dispatcher.forward(request, response);
             }
         }{ //エラー表示
        	 RequestDispatcher dispatcher = request
                     .getRequestDispatcher("/jsp/error/passerror2.jsp");
             dispatcher.forward(request, response);
         }
     }

   
        }//dontfind


       



