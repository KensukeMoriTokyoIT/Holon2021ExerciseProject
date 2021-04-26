package jp.co.sss.emanage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class UserCheckFilter
 */
@WebFilter("/UserCheckFilter")
public class UserCheckFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public UserCheckFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			HttpSession session = ((HttpServletRequest) request).getSession(false);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");

			if (session == null) {
				/* まだ認証されていない */

				dispatcher.forward(request, response);

			} else {
				Object loginCheck = session.getAttribute("user");
				if (loginCheck == null) {
					/* まだ認証されていない */
					dispatcher.forward(request, response);
				} else {
					chain.doFilter(request, response);
				}
			}
		} catch (ServletException se) {
		} catch (IOException e) {
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
