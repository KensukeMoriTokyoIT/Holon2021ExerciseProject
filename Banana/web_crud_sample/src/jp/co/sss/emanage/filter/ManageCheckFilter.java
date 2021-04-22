package jp.co.sss.emanage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jp.co.sss.emanage.bean.EmpBean;

public class ManageCheckFilter implements Filter{

	/**
	 * Default constructor.
	 */
	public ManageCheckFilter() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		// セッションが存在しない場合NULLを返す
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		if (session == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}

		EmpBean emp = (EmpBean) session.getAttribute("user");
		String empAuth = emp.getAuthority();

		if (empAuth.equals("2")) {
			// 管理者でログインしていれば、通常どおりの遷移
			chain.doFilter(request, response);
		} else {
			//管理者でないならば、ログイン画面へ飛ばす
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
