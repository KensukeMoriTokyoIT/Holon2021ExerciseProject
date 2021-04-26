package jp.co.sss.emanage.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.EmpDao;
import jp.co.sss.emanage.form.SelfSelectForm;


@WebServlet("/SelfUpdateInputServlet")
public class SelfUpdateInputServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 // 入力された検索情報を受け取るフォームの準備
    	SelfSelectForm infoSelectForm = new SelfSelectForm();
    	// フォームから社員IDを取得し、社員ID検索による取得
        infoSelectForm.setEmpId(request.getParameter("empId"));
        EmpBean empBean = EmpDao.findById(infoSelectForm.getEmpId());
        request.setAttribute("empBean", empBean);
		request.getRequestDispatcher("/jsp/update/employee_update_info.jsp").forward(request, response);




}
}
