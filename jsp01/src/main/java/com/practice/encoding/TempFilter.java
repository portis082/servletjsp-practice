package com.practice.encoding;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TempFilter implements Filter {

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("===init====");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("===doFilter===");
		
		//request filter
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		
		//response filter
		
	}

	public void destroy() {
		System.out.println("===destroy===");
	}





}
