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

import jp.co.sss.emanage.bean.EmpBean;
import jp.co.sss.emanage.util.Property;

/**
 * Servlet Filter implementation class AuthorityCheckFilter
 */
@WebFilter("/AuthorityCheckFilter")
public class AuthorityCheckFilter implements Filter {

    /**
     * Default constructor.
     */
    public AuthorityCheckFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpSession session = ((HttpServletRequest)request).getSession();
		if (session.getAttribute("user") == null) {
			System.out.println("null");
			RequestDispatcher dispatcher = request
	                .getRequestDispatcher("/index.jsp");
	        dispatcher.forward(request, response);
		} else {
		EmpBean em2 = (EmpBean) session.getAttribute("user");
		System.out.println("authoritycheck done");
		if (em2.getAuthority().equals(Property.MANAGER)) {
		} else {
			RequestDispatcher dispatcher = request
	                .getRequestDispatcher("/index.jsp");
	        dispatcher.forward(request, response);
		}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
