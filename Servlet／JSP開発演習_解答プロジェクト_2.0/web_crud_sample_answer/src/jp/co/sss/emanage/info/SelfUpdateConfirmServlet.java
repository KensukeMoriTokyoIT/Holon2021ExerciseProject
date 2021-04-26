package jp.co.sss.emanage.info;

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
import jp.co.sss.emanage.form.SelfUpdateForm;
import jp.co.sss.emanage.util.InputValidator;

/**
 * 自分の情報の更新確認画面クラス
 *
 * @author System Shared
 */
@WebServlet("/public/SelfUpdateConfirmServlet")
public class SelfUpdateConfirmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelfUpdateConfirmServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // 入力フォームクラスの宣言
        SelfUpdateForm selfUpdateForm = new SelfUpdateForm();

        // 部署テーブルの全件を取得
        List<DeptBean> deptList = DeptDao.findAll();

        // 部署テーブルの全件が入ったリストをリクエスト属性に登録しておく
        request.setAttribute("deptList", deptList);

        // 入力された変更情報を受け取る

        selfUpdateForm.setEmpId(request.getParameter("empId"));
        selfUpdateForm.setEmpName(request.getParameter("empName"));
        selfUpdateForm.setGender(request.getParameter("gender"));
        selfUpdateForm.setAddress(request.getParameter("address"));
        selfUpdateForm.setBirthday(request.getParameter("birthday"));
        selfUpdateForm.setDeptId(request.getParameter("deptId"));

        // 入力チェッククラスの宣言
        InputValidator inputValidator = new InputValidator();
        String[] check = new String[5];
        check[0] = inputValidator.nameValidate(selfUpdateForm.getEmpName());
        check[1] = inputValidator.genderValidate(selfUpdateForm.getGender());
        check[2] = inputValidator.addressValidate(selfUpdateForm.getAddress());
        check[3] = inputValidator
                .birthdayValidate(selfUpdateForm.getBirthday());
        check[4] = inputValidator.deptIdValidate(selfUpdateForm.getDeptId());

        // 判定用boolean変数
        boolean errorCheck = false;

        // エラーメッセージを格納する配列
        String[] errorMassage = { "errorName", "errorGender", "errorAddress",
                "errorBirthday", "errorDeptId" };

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
            request.setAttribute("updateForm", selfUpdateForm);
            // 入力情報に誤りがあるため、入力画面に遷移
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/jsp/info/info_input.jsp");
            dispatcher.forward(request, response);
        } else {

            // 入力された部署IDを元に部署情報を検索する
            DeptBean deptBean = DeptDao.findById(selfUpdateForm.getDeptId());

            // 部署名をフォームに格納しておく
            selfUpdateForm.setDeptName(deptBean.getDeptName());

            // 入力情報の入ったリストをリクエスト属性に登録しておく
            request.setAttribute("updateForm", selfUpdateForm);

            // 変更情報確認画面に遷移
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/jsp/info/info_confirm.jsp");
            dispatcher.forward(request, response);
        }
    }

}
