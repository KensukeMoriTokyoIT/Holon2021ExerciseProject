package jp.co.sss.emanage.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.DeptBean;
import jp.co.sss.emanage.dao.DeptDao;
import jp.co.sss.emanage.form.InsertForm;

/**
 * 社員情報登録入力画面クラス
 *
 * @author System Shared
 */
@WebServlet("/manage/InsertInputServlet")
public class InsertInputServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertInputServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

         // 部署テーブルの全件を取得
        List<DeptBean> deptList = DeptDao.findAll();

        // 部署テーブルの全件が入ったリストをセッション属性に登録しておく
        request.setAttribute("deptList", deptList);

        // 更新情報入力画面に遷移
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/jsp/insert/insert_input.jsp");
        dispatcher.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // 部署テーブルの全件を取得
        List<DeptBean> deptList = DeptDao.findAll();

        // 部署テーブルの全件が入ったリストをセッション属性に登録しておく
        request.setAttribute("deptList", deptList);

        // 入力フォームクラスの宣言
        InsertForm insertForm = new InsertForm();
        insertForm.setEmpPass(request.getParameter("empPass"));
        insertForm.setEmpName(request.getParameter("empName"));
        insertForm.setGender(request.getParameter("gender"));
        insertForm.setAddress(request.getParameter("address"));
        insertForm.setBirthday(request.getParameter("birthday"));
        insertForm.setAuthority(request.getParameter("authority"));
        insertForm.setDeptId(request.getParameter("deptId"));

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("insertForm", insertForm);

        // 更新情報入力画面に遷移
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/jsp/insert/insert_input.jsp");
        dispatcher.forward(request, response);
    }

}
