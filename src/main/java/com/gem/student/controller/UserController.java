package com.gem.student.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gem.student.service.UserService;
import com.gem.student.service.impl.UserServiceImpl;


/**
 * @author: jzhang
 * @QQ: 1104975916
 * @CreateDate: 2019年12月24日 下午1:54:12
 * @Description: 用户控制器
 */
@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService = new UserServiceImpl();
    
    public UserController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取资源路径
		String path = request.getPathInfo();
		HttpSession session = request.getSession();
		
		if (path.equals("/login.html")) {
			//转发跳转至登录界面
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		} else if ("/login".equals(path)) {
			//用户提交表单，请求登录
			//1.接收用户提交的账户和密码
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			//2.验证账户和密码是否正确
			String flag = userService.checkUser(username, password);
			
			if (flag.equals("101")) {
				//重定向到学生列表页面（重定向到学生控制器）
				System.out.println("用户登录成功！");
				
				//将用户的信息添加到session中  
				session.setAttribute("user", username);
				
				response.sendRedirect(request.getContextPath() + "/student/list");
			} else {
				//用户名或密码错误
				response.sendRedirect(request.getContextPath() + "/user/login.html");
			}
		} else if (path.equals("/logout")) {
			//安全退出
			session.invalidate();
			response.sendRedirect(request.getContextPath() + "/user/login.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
