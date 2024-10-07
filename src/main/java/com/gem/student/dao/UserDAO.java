/**
 * 
 */
package com.gem.student.dao;

import com.gem.student.entity.User;

/**
 * @author: jzhang
 * @QQ: 1104975916
 * @CreateDate: 2019年12月24日 下午3:31:56
 * @Description: 
 */
public interface UserDAO {
	/**
	 * 	根据用户名查询
	 */
	User selectOne(String username);
}
