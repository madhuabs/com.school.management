package com.school.dao;

import com.school.vo.User;

public interface AdminDAO extends AbstractDAO {

	public long passwordReset(User user);

	long deleteUser(User user);
}