package jp.co.sss.emanage.info;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sss.emanage.action.UserCheck;
import jp.co.sss.emanage.bean.DeptBean;
import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.dao.DeptDao;
import jp.co.sss.emanage.dao.EmpDao;
import jp.co.sss.emanage.form.SelfSelectForm;
import jp.co.sss.emanage.util.Property;

/**
 * Servlet implementation class InfoSelectServlet
 */
@WebServlet("/InfoSelectServlet")
public class InfoSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InfoSelectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//セッション取得
		HttpSession session = request.getSession();
		EmpBean user = (EmpBean) session.getAttribute("user");

		//ログイン管理
		if (UserCheck.loginCheck(user)) {
			//ログインOK-->処理実行
			// 入力された検索情報を受け取るフォームの準備
			SelfSelectForm selfSelectForm = new SelfSelectForm();

			// 条件検索キーを取得(ラジオボタンの値)
			selfSelectForm.setFindKey(request.getParameter("radio"));

			// 全件を格納するリストを準備しておく
			List<EmpBean> empList = null;

			// 部署テーブルの全件を取得
			List<DeptBean> deptList = DeptDao.findAll();

			// 部署テーブルの全件が入ったリストをリクエスト属性に登録しておく
			request.setAttribute("deptList", deptList);

			// 条件検索キーが選択されていなかった場合
			if (selfSelectForm.getFindKey() == null) {
				// 社員テーブルを検索し、全項目を取得する
				empList = EmpDao.findAll();

				// 検索結果の入ったリストをリクエスト属性に登録しておく
				request.setAttribute("empList", empList);

				// 検索キーが入力されていない場合,社員全件表示画面に遷移
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("jsp/info/info.jsp");
				dispatcher.forward(request, response);
			}

			//一般社員の 社員ID検索表示を行う
			else if (Property.KEY_SELECT_BY_EMP_ID.equals(selfSelectForm
					.getFindKey())) {
				// フォームから社員IDを取得し、社員ID検索による取得
				selfSelectForm.setEmpId(request.getParameter("empId"));
				EmpBean empBean = EmpDao.findById(selfSelectForm.getEmpId());

				// 検索結果がある場合
				if (empBean != null) {
					// 一覧表示のためにリストに入れる
					empList = new ArrayList<EmpBean>();
					empList.add(empBean);

					// それぞれの条件検索による取得されたリストをリクエスト属性に登録しておく
					request.setAttribute("empList", empList);
					// 社員情報一覧表示画面へ遷移する
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("jsp/info/info.jsp");
					dispatcher.forward(request, response);
				}

				// 検索結果が0件の場合
				else if (empList == null || empList.isEmpty()) {
					// エラーページへと遷移する
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("jsp/select/not_found.jsp");
					dispatcher.forward(request, response);
				}
			}
			// 一般社員の社員名検索表示を行う
			else if (Property.KEY_SELECT_BY_EMP_NAME.equals(selfSelectForm
					.getFindKey())) {

				// フォームから社員名を取得し、社員名検索によるリスト取得
				selfSelectForm.setEmpName(request.getParameter("empName"));
				empList = EmpDao.findByNameContains(selfSelectForm.getEmpName());

				// 検索結果がある場合
				if (empList != null && !empList.isEmpty()) {
					// それぞれの条件検索による取得されたリストをリクエスト属性に登録しておく
					request.setAttribute("empList", empList);
					// 社員情報一覧表示画面へ遷移する
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("jsp/info/info.jsp");
					dispatcher.forward(request, response);
				}

				// 検索結果が0件の場合
				else if (empList == null || empList.isEmpty()) {
					// エラーページへと遷移する
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("jsp/select/not_found.jsp");
					dispatcher.forward(request, response);
				}
			}

			// 一般社員の部署ID検索表示を行う
			else if (Property.KEY_SELECT_BY_DEPT_ID.equals(selfSelectForm
					.getFindKey())) {
				// フォームから部署IDを取得し、部署ID検索によるリスト取得
				selfSelectForm.setDeptId(request.getParameter("deptId"));
				empList = EmpDao.findByDeptId(selfSelectForm.getDeptId());

				// 検索結果がある場合
				if (empList != null && !empList.isEmpty()) {
					// それぞれの条件検索による取得されたリストをリクエスト属性に登録しておく
					request.setAttribute("empList", empList);
					// 社員情報一覧表示画面へ遷移する
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("jsp/info/info.jsp");
					dispatcher.forward(request, response);
				}
				// 検索結果が0件の場合
				else if (empList == null || empList.isEmpty()) {
					// エラーページへと遷移する
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("jsp/select/not_found.jsp");
					dispatcher.forward(request, response);
				}
			}

		} else {
			//ログインNG
			//ログイン画面へ遷移
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

	}

}
