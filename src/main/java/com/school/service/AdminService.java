package com.school.service;

import com.school.vo.Status;
import com.school.vo.User;
import com.school.vo.UserStatus;

public interface AdminService {
	public Status passwordReset(User user);

	Status deleteUser(User user);

	public Status createUser(User user);

}
