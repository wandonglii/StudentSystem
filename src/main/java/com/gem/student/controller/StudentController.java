package com.gem.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gem.student.entity.Student;
import com.gem.student.service.StudentService;
import com.gem.student.service.impl.StudentServiceImpl;


@WebServlet("/student/*")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentService studentService = new StudentServiceImpl();
    
    public StudentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		
		if (path.equals("/list")) { //查询学生列表
			//获取用户提交数据
			String name = request.getParameter("likename");
			if (name == null) {
				name = "";
			}
			
			List<Student> list = studentService.findAll(name);
			//将数据包装到request对象中
			request.setAttribute("studentList", list);
			request.setAttribute("name", name);
			//转发到学生列表页面
			request.getRequestDispatcher("/WEB-INF/jsp/studentList.jsp").forward(request, response);
		} else if (path.equals("/delete")) {
			//获取学生的id
			String ids = request.getParameter("sids");
			studentService.deleteStudent(ids);
			response.sendRedirect(request.getContextPath() + "/student/list");
		} else if (path.equals("/form")) {
			//获取请求参数
			String sid = request.getParameter("sid");
			if (sid != null) {
				//调用service查询学生记录，存放到request域中
				request.setAttribute("student", studentService.findOne(Integer.valueOf(sid)));
			}
			//转发至表单页
			request.getRequestDispatcher("/WEB-INF/jsp/studentForm.jsp").forward(request, response);
		} else if (path.equals("/save")) {
			//保存学生信息
			studentService.save(request);
			response.sendRedirect(request.getContextPath() + "/student/list");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
