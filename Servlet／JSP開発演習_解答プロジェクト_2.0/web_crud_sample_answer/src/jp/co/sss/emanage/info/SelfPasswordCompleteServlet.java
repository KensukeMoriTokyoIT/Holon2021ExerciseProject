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
import jp.co.sss.emanage.form.UpdateForm;
import jp.co.sss.emanage.util.InputValidator;
import jp.co.sss.emanage.util.Property;

/**
 * 自分の情報のパスワード変更完了画面クラス
 *
 * @author System Shared
 */
@WebServlet("/public/SelfPasswordCompleteServlet")
public class SelfPasswordCompleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelfPasswordCompleteServlet() {
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
        updateForm.setEmpPassNow(request.getParameter("empPassNow"));
        updateForm.setEmpPass(request.getParameter("empPass"));
        updateForm.setEmpPassTwo(request.getParameter("empPassTwo"));

        // 入力チェッククラスの宣言
        InputValidator inputValidator = new InputValidator();
        String[] check = new String[3];
        check[0] = inputValidator.passwordValidate(updateForm.getEmpPassNow());
        check[1] = inputValidator.passwordValidate(updateForm.getEmpPass());
        check[2] = inputValidator.passwordValidate(updateForm.getEmpPassTwo());

        // 判定用boolean変数
        boolean errorCheck = false;

        // エラーメッセージを格納する配列
        String[] errorMassage = { "errorPasswordNow", "errorPassword",
                "errorPasswordTwo" };

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
                    .getRequestDispatcher("/jsp/password/self_password_input.jsp");
            dispatcher.forward(request, response);

            // 入力したパスワードが一致しない場合
        } else if (!updateForm.getEmpPass().equals(updateForm.getEmpPassTwo())) {
            // エラーメッセージをリクエストに登録
            request.setAttribute("passwordMismatch", Property.PASSWORD_MISMATCH);

            // 入力情報の入ったリストをリクエスト属性に登録しておく
            request.setAttribute("updateForm", updateForm);
            // 入力情報に誤りがあるため、入力画面に遷移
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/jsp/password/self_password_input.jsp");
            dispatcher.forward(request, response);

        } else {

            // フォームから社員IDを取得し、社員ID検索による取得
            empBean = EmpDao.findById(updateForm.getEmpId());

            // 現在のパスワードが正しいかどうか判定
            if (empBean.getEmpPass().equals(updateForm.getEmpPassNow())) {

                empBean.setEmpId(updateForm.getEmpId());
                empBean.setEmpPass(updateForm.getEmpPass());

                // 変更処理を実行する
                EmpDao.empPassUpdate(empBean);

                // 変更情報完了画面に遷移
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("/jsp/password/self_password_complete.jsp");
                dispatcher.forward(request, response);
            } else {
                // エラーメッセージをリクエストに登録
                request.setAttribute("nowPasswordMismatch",
                        Property.NOW_PASSWORD_MISMATCH);

                // 入力情報の入ったリストをリクエスト属性に登録しておく
                request.setAttribute("updateForm", updateForm);
                // 入力情報に誤りがあるため、入力画面に遷移
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("/jsp/password/self_password_input.jsp");
                dispatcher.forward(request, response);

            }

        }
    }

}
