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

/**
 * 社員情報削除確認画面クラス
 *
 * @author System Shared
 */
@WebServlet("/manage/DeleteConfirmServlet")
public class DeleteConfirmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteConfirmServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // 削除対象のIDを受け取る
        String id = request.getParameter("empId");

        // DeleteForm deleteForm = (DeleteForm) form;

        // 削除する社員情報の全項目について検索して取得する
        EmpBean empBean = EmpDao.findById(id);

        // 社員テーブルを検索し、社員ID、社員名、部署名のみ取得する
        // List<EmpBean> empInfoList = EmpDao.findLimitedEmpInfo();

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("emp", empBean);

        // 削除処理用フォームに検索結果の各項目をコピーする
        // BeanUtils.copyProperties(deleteForm, empBean);

        // 削除情報確認画面に遷移
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/jsp/delete/delete_confirm.jsp");
        dispatcher.forward(request, response);
    }

}
