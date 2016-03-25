package com.school.dao;

import com.school.vo.User;

public interface AdminDAO {
	public User fetchUser(User user);

	public long passwordReset(User user);

	long deleteUser(User user);
/**
 * 
 * @param user
 * @return
 */
	public long createUser(User user);
	
}
