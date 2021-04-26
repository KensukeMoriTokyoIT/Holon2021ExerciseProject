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
import jp.co.sss.emanage.util.InputValidator;

/**
 * 社員情報登録確認画面クラス
 *
 * @author System Shared
 */
@WebServlet("/manage/InsertConfirmServlet")
public class InsertConfirmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertConfirmServlet() {
        super();
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

        // 入力された変更情報を受け取る

        insertForm.setEmpId(request.getParameter("empId"));
        insertForm.setEmpPass(request.getParameter("empPass"));
        insertForm.setEmpName(request.getParameter("empName"));
        insertForm.setGender(request.getParameter("gender"));
        insertForm.setAddress(request.getParameter("address"));
        insertForm.setBirthday(request.getParameter("birthday"));
        insertForm.setAuthority(request.getParameter("authority"));
        insertForm.setDeptId(request.getParameter("deptId"));

        // 入力チェッククラスの宣言
        InputValidator inputValidator = new InputValidator();
        String[] check = new String[7];
        check[0] = inputValidator.passwordValidate(insertForm.getEmpPass());
        check[1] = inputValidator.nameValidate(insertForm.getEmpName());
        check[2] = inputValidator.genderValidate(insertForm.getGender());
        check[3] = inputValidator.addressValidate(insertForm.getAddress());
        check[4] = inputValidator.birthdayValidate(insertForm.getBirthday());
        check[5] = inputValidator.authorityValidate(insertForm.getAuthority());
        check[6] = inputValidator.deptIdValidate(insertForm.getDeptId());

        // 判定用boolean変数
        boolean errorCheck = false;

        // エラーメッセージを格納する配列
        String[] errorMassage = { "errorPassword", "errorName", "errorGender",
                "errorAddress", "errorBirthday", "errorAuthority",
                "errorDeptId" };

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
            request.setAttribute("insertForm", insertForm);
            // 入力情報に誤りがあるため、入力画面に遷移
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/jsp/insert/insert_input.jsp");
            dispatcher.forward(request, response);
        } else {

            // 入力された部署IDを元に部署情報を検索する
            DeptBean deptBean = DeptDao.findById(insertForm.getDeptId());

            // 部署名をフォームに格納しておく
            insertForm.setDeptName(deptBean.getDeptName());

            // 入力情報の入ったリストをリクエスト属性に登録しておく
            request.setAttribute("insertForm", insertForm);

            // 変更情報確認画面に遷移
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/jsp/insert/insert_confirm.jsp");
            dispatcher.forward(request, response);
        }
    }

}
