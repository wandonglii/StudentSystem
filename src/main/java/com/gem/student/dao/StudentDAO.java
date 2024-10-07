/**
 * 
 */
package com.gem.student.dao;

import java.util.List;

import com.gem.student.entity.Student;

/**
 * @author: jzhang
 * @QQ: 1104975916
 * @CreateDate: 2019年12月25日 上午8:50:48
 * @Description: 学生持久层对象
 */
public interface StudentDAO {
	/**
	 *  	查询所有学生信息
	 */
	List<Student> selectAll(String sname);
	
	/**
	 *	 批量删除
	 */
	Integer[] deleteBatch(Integer[] ids);
	
	/**
	 *  	新增学生
	 */
	void insert(Student student);
	
	/**
	 *  	根据主键查询记录
	 */
	Student selectOneByPrimarykey(Integer id);
	
	/**
	 *  	根据id更新记录
	 */
	void update(Student student);
}
