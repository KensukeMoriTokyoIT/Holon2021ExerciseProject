package jp.co.sss.general;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    //オブジェクトを生成
		    EmpBean emp = new EmpBean();
		    //パスワードを受け取る
		    String password = request.getParameter("empPass");
		    //社員名が無記入の場合、エラーメッセージを表示
		    if(password!=null) {
		    	request.setAttribute("errormessage","パスワードを入力して下さい！");
		    }
			//社員名を受け取る
		    String name = request.getParameter("empName");
		    //社員名が無記入の場合、エラーメッセージを表示
		    if(name!=null) {
		    	request.setAttribute("errormessage1","社員名を入力して下さい！");
		    }
		    //性別の選択を受け取る
	     	String gender = request.getParameter("gender");
	     	//性別が無選択の場合、エラーメッセージを表示
	     	if(gender!="1"||gender!="2") {
		    	request.setAttribute("errormessage2","性別を選択して下さい！");
		    }
	     	//住所を受け取る
		    String address = request.getParameter("address");
		    //住所が無記入の場合、エラーメッセージを表示
		    if(address!=null) {
		    	request.setAttribute("errormessage3","住所を入力して下さい！");
		    }
		    //生年月日を受け取る
		    String birthday = request.getParameter("birthday");
		    //生年月日が無記入の場合、エラーメッセージを表示
		    if(birthday!=null) {
		    	request.setAttribute("errormessage4","生年月日を入力して下さい！");
		    }
		    String authority = request.getParameter("authority");
		    //権限を受け取る
	     	if(authority!="1"||authority!="2") {
		    	request.setAttribute("errormessage5","権限を選択して下さい！");
		    }
		    //部署名を受け取る
		    String department = request.getParameter("department");
		    //部署名が無無記入の場合、エラーメッセージを表示//
		    if(department!=null) {
		    	request.setAttribute("errormessage6","部署名を選択して下さい！");
		    }
		    //エラーメッセージを表示する条件式
		    if(name!=null||gender!=null||address!=null||birthday!=null||department!=null) {
		    	RequestDispatcher dispatcher = request
                        .getRequestDispatcher("jsp/empinfo/Change.jsp");
                dispatcher.forward(request, response);
		    }
		    //変数を格納する
		    //社員名
		    emp.setEmpName(name);
		    //性別
		    emp.setGender(gender);
		    //住所
		    emp.setAddress(address);
		    //生年月日
		    emp.setBirthday(birthday);
		    //部署名
		    emp.setDeptName(department);
		    //リクエストスコープの設置
		   request.setAttribute("emp", emp);
		   RequestDispatcher dispatcher = request
	                .getRequestDispatcher("jsp/empinfo/Complete.jsp");
	        dispatcher.forward(request, response);
	}
}
