package jp.co.sss.emanage.manage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.EmpDao;
import jp.co.sss.emanage.form.UpdateForm;

/**
 * パスワード変更入力画面クラス
 *
 * @author System Shared
 */
@WebServlet("/manage/ManagePasswordInputServlet")
public class ManagePasswordInputServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagePasswordInputServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // 更新対象のIDを受け取る
        String id = request.getParameter("empId");

        // 更新する社員情報の全項目について検索して取得する
        EmpBean empBean = EmpDao.findById(id);

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("emp", empBean);

        // 入力フォームクラスの宣言
        UpdateForm updateForm = new UpdateForm();
        updateForm.setEmpPass(empBean.getEmpPass());

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("updateForm", updateForm);

        // 更新情報入力画面に遷移
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/jsp/password/password_input.jsp");
        dispatcher.forward(request, response);

    }

}
