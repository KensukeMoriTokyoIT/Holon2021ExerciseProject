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
 * 自分の情報の更新完了画面クラス
 *
 * @author System Shared
 */
@WebServlet("/public/SelfUpdateCompleteServlet")
public class SelfUpdateCompleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelfUpdateCompleteServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // 変更処理で利用するbeanを用意しておく
        EmpBean empBean = new EmpBean();

        // 更新する社員情報の全項目について検索して取得する
        empBean = EmpDao.findById(request.getParameter("empId"));

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("emp", empBean);

        // 入力された変更情報を受け取り、Beanに値を詰める
        empBean.setEmpId(request.getParameter("empId"));
        empBean.setEmpName(request.getParameter("empName"));
        empBean.setGender(request.getParameter("gender"));
        empBean.setAddress(request.getParameter("address"));
        empBean.setBirthday(request.getParameter("birthday"));
        empBean.setDeptId(request.getParameter("deptId"));

        // 変更処理を実行する
        EmpDao.selfUpdate(empBean);

        // 変更完了画面に遷移
        // 変更情報確認画面に遷移
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/jsp/info/info_complete.jsp");
        dispatcher.forward(request, response);
    }

}
