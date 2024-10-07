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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @author: jzhang
 * @QQ: 1104975916
 * @CreateDate: 2019年12月26日 下午1:54:16
 * @Description: 权限拦截控制器
 */
@WebFilter("/student/*")
public class PermissionFilter implements Filter {

    public PermissionFilter() {
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		//获取session对象
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("user") != null) {
			//已确认用户登录，放行
			chain.doFilter(request, response);
		} else {
			//用户未登录，重定向至登录界面
			res.sendRedirect(req.getContextPath() + "/user/login.html");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
