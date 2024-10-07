/**
 * 
 */
package com.gem.student.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gem.student.dao.StudentDAO;
import com.gem.student.dao.impl.StudentDAOImpl;
import com.gem.student.entity.Student;
import com.gem.student.service.StudentService;

/**
 * @author: jzhang
 * @QQ: 1104975916
 * @CreateDate: 2019年12月25日 上午9:00:51
 * @Description: 
 */
public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDao = new StudentDAOImpl();
	
	@Override
	public List<Student> findAll(String sname) {
		return studentDao.selectAll(sname);
	}

	@Override
	public void deleteStudent(String ids) {
		//处理参数，分割成数组
		String[] idArr = ids.split(",");
		Integer[] intIdArr = new Integer[idArr.length];
		for (int i = 0; i < idArr.length; i++) {
			intIdArr[i] = Integer.valueOf(idArr[i]);
		}
		studentDao.deleteBatch(intIdArr);
	}

	@Override
	public void save(HttpServletRequest request) {
		String id = request.getParameter("id");
		String sname = request.getParameter("sname");
		String sage = request.getParameter("sage");
		String sgender = request.getParameter("sgender");
		String birthday = request.getParameter("birthday");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Student student = null;
		try {
			student = new Student(sname, sage, sgender, sdf.parse(birthday));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//判断新记录还是原记录
		if (id == null || id == "") {
			studentDao.insert(student);
		} else {
			//更新记录
			student.setId(Integer.valueOf(id));
			//调用dao完成记录更新
			studentDao.update(student);
		}
	}

	@Override
	public Student findOne(Integer id) {
		return studentDao.selectOneByPrimarykey(id);
	}

}
