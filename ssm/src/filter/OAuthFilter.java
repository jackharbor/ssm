package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class OAuthFilter implements Filter {

	/**
	 * private IAuthService service;
	 */

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		/*
		 * ServletContext sc=arg0.getServletContext(); ApplicationContext
		 * ac=WebApplicationContextUtils.getWebApplicationContext(sc);
		 * if(service==null){ service=(IAuthService)
		 * ac.getBean(IAuthService.class); }
		 */
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {

		/*
		 * HttpServletRequest request = (HttpServletRequest) arg0;
		 * HttpServletResponse response = (HttpServletResponse) arg1;
		 */
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
