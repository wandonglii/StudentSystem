/**
 * 
 */
package com.gem.student.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gem.student.dao.StudentDAO;
import com.gem.student.entity.Student;
import com.gem.student.template.JdbcTemplate;

/**
 * @author: jzhang
 * @QQ: 1104975916
 * @CreateDate: 2019年12月25日 上午8:52:14
 * @Description: 
 */
public class StudentDAOImpl implements StudentDAO {

	@Override
	public List<Student> selectAll(String sname) {
		JdbcTemplate<List<Student>> jdbcTemplate = new JdbcTemplate<>();
		return jdbcTemplate.query((conn) -> {
			PreparedStatement pst = null;
			ResultSet rs = null;
			List<Student> list = new ArrayList<>();
			
			try {
				String sql = "select * from t_student where sname like ?";
				pst = conn.prepareStatement(sql);
				//注入参数
				pst.setString(1, "%" + sname + "%");
				rs = pst.executeQuery();
				
				while (rs.next()) {
					Student student = new Student();
					student.setId(rs.getInt("id"));
					student.setSname(rs.getString("sname"));
					student.setSage(rs.getString("sage"));
					student.setSgender(rs.getString("sgender"));
					student.setBirthday(rs.getDate("birthday"));
					list.add(student);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		});
	}

	
	@Override
	public Integer[] deleteBatch(Integer[] ids) {
		JdbcTemplate<Integer[]> jdbcTemplate = new JdbcTemplate<>();
		return jdbcTemplate.query((conn) -> {
			PreparedStatement pst = null;
			int[] result = null;
			try {
				String sql = "delete from t_student where id = ?";
				pst = conn.prepareStatement(sql);
				//批量添加参数
				for (int i = 0; i < ids.length; i++) {
					pst.setInt(1, ids[i]);
					pst.addBatch();
				}
				result = pst.executeBatch();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Integer[] id = new Integer[result.length];
			for (int i = 0; i < result.length; i++) {
				id[i] = Integer.valueOf(result[i]);
			}
			return id;
		});
	}


	@Override
	public void insert(Student student) {
		JdbcTemplate<Student> jdbcTemplate = new JdbcTemplate<>();
		jdbcTemplate.update((conn) -> {
			PreparedStatement pst = null;
			try {
				String sql = "insert into t_student (sname,sage,sgender,birthday) values (?,?,?,?)";
				pst = conn.prepareStatement(sql);
				pst.setString(1, student.getSname());
				pst.setString(2, student.getSage());
				pst.setString(3, student.getSgender());
				pst.setDate(4, new Date(student.getBirthday().getTime()));
				pst.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
	}


	@Override
	public Student selectOneByPrimarykey(Integer id) {
		JdbcTemplate<Student> jdbcTemplate = new JdbcTemplate<>();
		return jdbcTemplate.query((conn) -> {
			PreparedStatement pst = null;
			ResultSet rs = null;
			Student student = null;
			try {
				String sql = "select * from t_student where id = ?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, id);
				rs = pst.executeQuery();
				
				if (rs.next()) {
					student = new Student();
					student.setId(rs.getInt("id"));
					student.setSname(rs.getString("sname"));
					student.setSage(rs.getString("sage"));
					student.setSgender(rs.getString("sgender"));
					student.setBirthday(rs.getDate("birthday"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return student;
		});
	}


	@Override
	public void update(Student student) {
		JdbcTemplate<Student> jdbcTemplate = new JdbcTemplate<>();
		jdbcTemplate.update((conn) -> {
			PreparedStatement pst = null;
			try {
				String sql = "update t_student set sname=?,sage=?,sgender=?,birthday=? where id=?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, student.getSname());
				pst.setString(2, student.getSage());
				pst.setString(3, student.getSgender());
				pst.setDate(4, new Date(student.getBirthday().getTime()));
				pst.setInt(5, student.getId());
				pst.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
	}

}
