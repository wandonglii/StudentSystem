/**
 * 
 */
package com.gem.student.service;

/**
 * @author: jzhang
 * @QQ: 1104975916
 * @CreateDate: 2019年12月24日 下午3:36:36
 * @Description: 
 */
public interface UserService {
	/**
	 * 	判断用户名和密码是否正确
	 */
	String checkUser(String username, String password);
	
}
