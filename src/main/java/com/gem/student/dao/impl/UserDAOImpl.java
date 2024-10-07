/**
 * 
 */
package com.gem.student.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gem.student.dao.UserDAO;
import com.gem.student.entity.User;
import com.gem.student.template.JdbcTemplate;

/**
 * @author: jzhang
 * @QQ: 1104975916
 * @CreateDate: 2019年12月24日 下午3:32:43
 * @Description: 
 */
public class UserDAOImpl implements UserDAO{

	@Override
	public User selectOne(String username) {
		JdbcTemplate<User> jdbcTemplate = new JdbcTemplate<>();
		return jdbcTemplate.query((conn) -> {
			PreparedStatement pst = null;
			ResultSet rs = null;
			User user = null;
			try {
				String sql = "select * from t_user where username = ?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, username);
				rs = pst.executeQuery();
				if (rs.next()) {
					user = new User();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return user;
		});
	}

}
