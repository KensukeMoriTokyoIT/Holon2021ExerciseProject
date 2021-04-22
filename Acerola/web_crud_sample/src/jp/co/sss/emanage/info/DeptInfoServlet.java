package jp.co.sss.emanage.info;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.EmpDao;

/**
 * Servlet implementation class DeptInfoServlet
 */
@WebServlet("/DeptInfoServlet")
public class DeptInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		 // 社員テーブルを検索し、部署関連の情報を全て取得する
        List<EmpBean> empList = EmpDao.findEmployeeDeptAll();

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("empList", empList);

        // 一般用一覧表示画面へ画面遷移を行う
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("jsp/info/info.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        // 社員テーブルを検索し、部署関連の情報を全て取得する
        List<EmpBean> empList = EmpDao.findEmployeeDeptAll();

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("empList", empList);

        // 一般用一覧表示画面へ画面遷移を行う
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("jsp/info/info.jsp");
        dispatcher.forward(request, response);

    }

}


