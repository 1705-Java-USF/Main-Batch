package com.revature.ers.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
public class AuthenticationFilter implements Filter {
	private String[] excluded = {"LoginBoxBackgroundImg.png", "BaseBackgroundImage.png"};
	private String[] protectedPages = {"CreateUser.jsp", "ManageRequests.jsp", "ManageUsers.jsp", "ManageUsers"};
	private Logger logger = Logger.getLogger(AuthenticationFilter.class);
    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
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
		logger.debug("Fitler filtering");
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		String url = ((HttpServletRequest)request).getRequestURL().toString();
		if(session.getAttribute("username") == null && !isExcluded(url)  )
		{
			
			logger.info("User Denied Access to: " + ((HttpServletRequest) request).getRequestURL());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		if(isProtected(url) && !session.getAttribute("userRole").equals("manager"))
		{
			logger.info("Employee Denied Access to: " + ((HttpServletRequest) request).getRequestURL());
			request.setAttribute("message", "Error no permision to enter that page");
			request.getRequestDispatcher("ERS-Home.jsp").forward(request, response);
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	private boolean isExcluded(String rurl)
	{
		String[] arr = rurl.split("/");
		for(String s : arr)
		{
			for(String s2: excluded)
			{
				if(s.equals(s2))
				{
					logger.info("User allowed Access to exclusion: " + rurl);
					return true;
				}
			}
		}
		return false;
	}
	private boolean isProtected(String url)
	{
		String[] arr = url.split("/");
		for(String s: arr)
		{
			for(String s2: protectedPages)
			{
				if(s.equals(s2))
				{
					return true;
				}
			}
		}
		return false;
	}
}
