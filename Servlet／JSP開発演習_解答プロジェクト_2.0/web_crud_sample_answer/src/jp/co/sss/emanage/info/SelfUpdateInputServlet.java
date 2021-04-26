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
import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.DeptDao;
import jp.co.sss.emanage.dao.EmpDao;
import jp.co.sss.emanage.form.SelfUpdateForm;
import jp.co.sss.emanage.util.DateFormat;

/**
 * 自分の情報の更新入力画面クラス
 *
 * @author System Shared
 */
@WebServlet("/public/SelfUpdateInputServlet")
public class SelfUpdateInputServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelfUpdateInputServlet() {
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
        SelfUpdateForm selfUpdateForm = new SelfUpdateForm();
        selfUpdateForm.setEmpId(empBean.getEmpId());
        selfUpdateForm.setEmpName(empBean.getEmpName());
        selfUpdateForm.setGender(empBean.getGender());
        selfUpdateForm.setAddress(empBean.getAddress());
        selfUpdateForm.setBirthday(DateFormat.selectFormatDate(empBean.getBirthday()));
        selfUpdateForm.setAuthority(empBean.getAuthority());
        selfUpdateForm.setDeptId(empBean.getDeptId());

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("updateForm", selfUpdateForm);

     // 更新情報入力画面に遷移
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/jsp/info/info_input.jsp");
        dispatcher.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 更新対象のIDを受け取る
        String id = request.getParameter("empId");

        // 更新する社員情報の全項目について検索して取得する
        EmpBean empBean = EmpDao.findById(id);

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("emp", empBean);

        // 入力フォームクラスの宣言
        SelfUpdateForm selfUpdateForm = new SelfUpdateForm();
        selfUpdateForm.setEmpId(request.getParameter("empId"));
        selfUpdateForm.setEmpName(request.getParameter("empName"));
        selfUpdateForm.setGender(request.getParameter("gender"));
        selfUpdateForm.setAddress(request.getParameter("address"));
        selfUpdateForm.setBirthday(request.getParameter("birthday"));
        selfUpdateForm.setDeptId(request.getParameter("deptId"));

        // 検索結果の入ったリストをリクエスト属性に登録しておく
        request.setAttribute("updateForm", selfUpdateForm);

        // 部署テーブルの全件を取得
        List<DeptBean> deptList = DeptDao.findAll();

        // 部署テーブルの全件が入ったリストをリクエスト属性に登録しておく
        request.setAttribute("deptList", deptList);

        // 更新情報入力画面に遷移
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/jsp/info/info_input.jsp");
        dispatcher.forward(request, response);
    }
}
