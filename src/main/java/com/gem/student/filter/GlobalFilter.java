package com.gem.student.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


/**
 * @author: jzhang
 * @QQ: 1104975916
 * @CreateDate: 2019年12月24日 下午3:54:14
 * @Description: 全局过滤器
 */
@WebFilter("/*")
public class GlobalFilter implements Filter {

    public GlobalFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		//获取应用路径
		request.setAttribute("contextPath", req.getContextPath());
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
