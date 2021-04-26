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
import jp.co.sss.emanage.util.DateFormat;

/**
 * 社員情報更新入力画面クラス
 *
 * @author System Shared
 */
@WebServlet("/manage/UpdateInputServlet")
public class UpdateInputServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInputServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // 部署テーブルの全件を取得
        List<DeptBean> deptList = DeptDao.findAll();

        // 部署テーブルの全件が入ったリストをセッション属性に登録しておく
        request.setAttribute("deptList", deptList);

        // 更新対象のIDを受け取る
        String id = request.getParameter("empId");

        // 更新する社員情報の全項目について検索して取得する
        EmpBean empBean = EmpDao.findById(id);

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("emp", empBean);

        // 入力フォームクラスの宣言
        UpdateForm updateForm = new UpdateForm();
        updateForm.setEmpId(empBean.getEmpId());
        updateForm.setEmpName(empBean.getEmpName());
        updateForm.setGender(empBean.getGender());
        updateForm.setAddress(empBean.getAddress());
        updateForm.setBirthday(DateFormat.selectFormatDate(empBean.getBirthday()));
        updateForm.setAuthority(empBean.getAuthority());
        updateForm.setDeptId(empBean.getDeptId());

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("updateForm", updateForm);

        // 更新情報入力画面に遷移
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/jsp/update/update_input.jsp");
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

        // 更新対象のIDを受け取る
        String id = request.getParameter("empId");

        // 更新する社員情報の全項目について検索して取得する
        EmpBean empBean = EmpDao.findById(id);

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("emp", empBean);

        // 入力フォームクラスの宣言
        UpdateForm updateForm = new UpdateForm();
        updateForm.setEmpId(request.getParameter("empId"));
        updateForm.setEmpName(request.getParameter("empName"));
        updateForm.setGender(request.getParameter("gender"));
        updateForm.setAddress(request.getParameter("address"));
        updateForm.setBirthday(request.getParameter("birthday"));
        updateForm.setAuthority(request.getParameter("authority"));
        updateForm.setDeptId(request.getParameter("deptId"));

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("updateForm", updateForm);

        // 更新情報入力画面に遷移
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/jsp/update/update_input.jsp");
        dispatcher.forward(request, response);
    }

}
