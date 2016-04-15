package com.school.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.school.dao.AdminDAO;
import com.school.dao.UserDao;
import com.school.util.SchoolMnginitialization;
import com.school.vo.Status;
import com.school.vo.User;

@Component
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private SchoolMnginitialization schoolMnginitialization;
	@Autowired
	private UserDao userDao;
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Override
	public Status passwordReset(User user) {
		Status status = new Status();
		long result = 0;
		try {
			user.setPassword(bcryptEncoder.encode(user.getPassword()));
			result = adminDAO.passwordReset(user);
		} catch (RuntimeException runtimeException) {
			status.setStatuscd("0");
			status.setErrorDesc("Data Base Error.");
			return status;
		}
		if (result != 0 && result == 1) {
			status.setStatuscd("1");
		} else {
			status.setStatuscd("0");
			status.setErrorDesc("Password Reset Failed.");
		}
		return status;
	}

	@Override
	public Status deleteUser(User user) {
		Status status = new Status();
		long result = 0;
		try {
			// FIXME:Validate delete user should not be current logged in User
			result = adminDAO.deleteUser(user);
		} catch (RuntimeException runtimeException) {
			status.setStatuscd("0");
			status.setErrorDesc("Data Base Error.");
			return status;
		}
		if (result != 0 && result == 1) {
			status.setStatuscd("1");
		} else {
			status.setStatuscd("0");
			status.setErrorDesc("Delete user Failed.");
		}
		return status;
	}

	@Override
	public Status createUser(User user) {
		Status status = new Status();
		if (userDao.fetchUser(user) == null) {
			user.setPassword(bcryptEncoder.encode(user.getPassword()));
			user.setCreationDate(new Date());
			user.setUpdatedDate(new Date());
			List<User> userList = new ArrayList<User>();
			userList.add(user);
			long result = adminDAO.insertManyDocuments("userCredentials", userList);
			if (result > 0) {
				status.setStatuscd("1");
			} else {
				status.setStatuscd("0");
				status.setErrorDesc("Create user Failed.");
			}
		} else {
			status.setStatuscd("0");
			status.setErrorDesc("User Already Exists.");
		}
		return status;
	}

	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
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
}
