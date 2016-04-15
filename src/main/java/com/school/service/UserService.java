package com.school.service;

import com.school.vo.User;
import com.school.vo.UserStatus;

public interface UserService {
	UserStatus validateUser(User user);
}
