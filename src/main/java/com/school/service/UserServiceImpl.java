package com.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.school.dao.UserDao;
import com.school.util.SchoolMnginitialization;
import com.school.vo.User;
import com.school.vo.UserStatus;

@Component
public class UserServiceImpl implements UserService, UserDetailsService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private SchoolMnginitialization schoolMnginitialization;
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Override
	public UserStatus validateUser(User user) {
		UserStatus status = new UserStatus();
		User result = null;
		try {
			result = userDao.fetchUser(user);
		} catch (RuntimeException runtimeException) {
			status.setStatuscd("0");
			status.setErrorDesc("Data Base Error.");
			return status;
		}
		if (result != null && bcryptEncoder.matches(user.getPassword(), result.getPassword())
				&& result.isActive()) {
			status.setStatuscd("1");
			status.setRoleName(schoolMnginitialization.rolesMap.get(result.getRoleId()));
		} else {
			status.setStatuscd("0");
			status.setErrorDesc("User name/Password is Incorrect.");
		}
		return status;
	}

	/**
	 * @return the userDao
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao
	 *            the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * @return the schoolMnginitialization
	 */
	public SchoolMnginitialization getSchoolMnginitialization() {
		return schoolMnginitialization;
	}

	/**
	 * @param schoolMnginitialization
	 *            the schoolMnginitialization to set
	 */
	public void setSchoolMnginitialization(SchoolMnginitialization schoolMnginitialization) {
		this.schoolMnginitialization = schoolMnginitialization;
	}

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		return null;
	}

	/**
	 * @return the bcryptEncoder
	 */
	public BCryptPasswordEncoder getBcryptEncoder() {
		return bcryptEncoder;
	}

	/**
	 * @param bcryptEncoder
	 *            the bcryptEncoder to set
	 */
	public void setBcryptEncoder(BCryptPasswordEncoder bcryptEncoder) {
		this.bcryptEncoder = bcryptEncoder;
	}

	// public static void main(String[] args) {
	// System.out.println(new BCryptPasswordEncoder().encode("password"));
	// }
}
