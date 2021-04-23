package jp.co.sss.emanage.update;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.EmpDao;
import jp.co.sss.emanage.form.ManageSelectForm;

/**
 * Servlet implementation class Check1
 */
@WebServlet("/UpdateInputServlet")
public class Forward2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		  // 入力された検索情報を受け取るフォームの準備
        ManageSelectForm emp = new ManageSelectForm();

        // フォームから社員IDを取得し、社員ID検索による取得
        emp.setEmpId(request.getParameter("empId"));
        EmpBean empBean = EmpDao.findById(emp.getEmpId());
        request.setAttribute("empBean",empBean);

                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("/jsp/update/employee_update.jsp");
                dispatcher.forward(request, response);
            }
	}

