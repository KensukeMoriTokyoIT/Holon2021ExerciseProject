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
import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.DeptDao;
import jp.co.sss.emanage.dao.EmpDao;
import jp.co.sss.emanage.form.UpdateForm;
import jp.co.sss.emanage.util.InputValidator;

/**
 * 社員情報更新確認画面クラス
 *
 * @author System Shared
 */
@WebServlet("/manage/UpdateConfirmServlet")
public class UpdateConfirmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateConfirmServlet() {
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

        // 部署テーブルの全件を取得
        List<DeptBean> deptList = DeptDao.findAll();

        // 部署テーブルの全件が入ったリストをセッション属性に登録しておく
        request.setAttribute("deptList", deptList);

        // 入力された変更情報を受け取る

        updateForm.setEmpId(request.getParameter("empId"));
        updateForm.setEmpName(request.getParameter("empName"));
        updateForm.setGender(request.getParameter("gender"));
        updateForm.setAddress(request.getParameter("address"));
        updateForm.setBirthday(request.getParameter("birthday"));
        updateForm.setAuthority(request.getParameter("authority"));
        updateForm.setDeptId(request.getParameter("deptId"));

        // 入力チェッククラスの宣言
        InputValidator inputValidator = new InputValidator();
        String[] check = new String[6];
        check[0] = inputValidator.nameValidate(updateForm.getEmpName());
        check[1] = inputValidator.genderValidate(updateForm.getGender());
        check[2] = inputValidator.addressValidate(updateForm.getAddress());
        check[3] = inputValidator.birthdayValidate(updateForm.getBirthday());
        check[4] = inputValidator.authorityValidate(updateForm.getAuthority());
        check[5] = inputValidator.deptIdValidate(updateForm.getDeptId());

        // 判定用boolean変数
        boolean errorCheck = false;

        // エラーメッセージを格納する配列
        String[] errorMassage = {"errorName", "errorGender",
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
            request.setAttribute("updateForm", updateForm);
            // 入力情報に誤りがあるため、入力画面に遷移
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/jsp/update/update_input.jsp");
            dispatcher.forward(request, response);
        } else {

            // 入力された部署IDを元に部署情報を検索する
            DeptBean deptBean = DeptDao.findById(updateForm.getDeptId());

            // 部署名をフォームに格納しておく
            updateForm.setDeptName(deptBean.getDeptName());

            // 入力情報の入ったリストをリクエスト属性に登録しておく
            request.setAttribute("updateForm", updateForm);

            // 変更情報確認画面に遷移
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/jsp/update/update_confirm.jsp");
            dispatcher.forward(request, response);
        }
    }

}
