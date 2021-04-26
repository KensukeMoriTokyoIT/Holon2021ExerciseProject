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
import jp.co.sss.emanage.util.InputValidator;
import jp.co.sss.emanage.util.Property;

/**
 * パスワード入力完了画面クラス
 *
 * @author System Shared
 */
@WebServlet("/manage/ManagePasswordCompleteServlet")
public class ManagePasswordCompleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagePasswordCompleteServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

         // 更新する社員情報の全項目について検索して取得する
        EmpBean empBean = EmpDao.findById(request.getParameter("empId"));

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("emp", empBean);

        // 入力フォームクラスの宣言
        UpdateForm updateForm = new UpdateForm();

        // 入力された変更情報を受け取る

        updateForm.setEmpId(request.getParameter("empId"));
        updateForm.setEmpPass(request.getParameter("empPass"));
        updateForm.setEmpPassTwo(request.getParameter("empPassTwo"));

        // 入力チェッククラスの宣言
        InputValidator inputValidator = new InputValidator();
        String[] check = new String[2];
        check[0] = inputValidator.passwordValidate(updateForm.getEmpPass());
        check[1] = inputValidator.passwordValidate(updateForm.getEmpPassTwo());

        // 判定用boolean変数
        boolean errorCheck = false;

        // エラーメッセージを格納する配列
        String[] errorMassage = { "errorPassword", "errorPasswordTwo" };

        // エラーメッセージを取得
        for (int i = 0; i < check.length; i++) {
            // エラーメッセージが入っている場合はtrueを代入
            if (!(check[i] == null)) {
                errorCheck = true;
                request.setAttribute(errorMassage[i], check[i]);
            }
        }

        // エラーメッセージがある場合
        if (errorCheck) {
            // 入力情報の入ったリストをリクエスト属性に登録しておく
            request.setAttribute("updateForm", updateForm);
            // 入力情報に誤りがあるため、入力画面に遷移
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/jsp/password/password_input.jsp");
            dispatcher.forward(request, response);

            // 入力したパスワードが一致しない場合
        } else if (!updateForm.getEmpPass().equals(updateForm.getEmpPassTwo())) {
            // エラーメッセージをリクエストに登録
            request.setAttribute("passwordMismatch", Property.PASSWORD_MISMATCH);

            // 入力情報の入ったリストをリクエスト属性に登録しておく
            request.setAttribute("updateForm", updateForm);
            // 入力情報に誤りがあるため、入力画面に遷移
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/jsp/password/password_input.jsp");
            dispatcher.forward(request, response);

        } else {

            // 変更処理で利用するbeanを用意しておく

            empBean.setEmpId(updateForm.getEmpId());
            empBean.setEmpPass(updateForm.getEmpPass());

            // 変更処理を実行する
            EmpDao.empPassUpdate(empBean);

            // 変更情報完了画面に遷移
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/jsp/password/password_complete.jsp");
            dispatcher.forward(request, response);
        }
    }
}
