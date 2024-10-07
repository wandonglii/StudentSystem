package com.gem.student.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


/**
 * @author: jzhang
 * @QQ: 1104975916
 * @CreateDate: 2019年12月24日 下午3:48:41
 * @Description: 字符过滤器
 */
@WebFilter(urlPatterns = "/*", initParams = {
		@WebInitParam(name = "encoding",value = "utf-8"),
		@WebInitParam(name = "contentType", value = "text/html;charset=utf-8")
})
public class EncodingFilter implements Filter {
	//定义变量接收字符编码
	private String encoding;
//	private String contentType;
	
    public EncodingFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
//		response.setContentType(contentType);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("encoding");
//		contentType = fConfig.getInitParameter("contentType");
	}

}
