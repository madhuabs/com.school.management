package com.school.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Projections;
import com.school.dao.AdminDAO;
import com.school.dao.UserDao;
import com.school.vo.Facilities;
import com.school.vo.Program;
import com.school.vo.User;
import com.school.vo.UserRoles;

@Component
public class SchoolMnginitialization {
	Logger logger = LoggerFactory.getLogger(SchoolMnginitialization.class);
	public Map<Integer, String> rolesMap = new HashMap<Integer, String>();
	public Set<UserRoles> userRolesSet = new HashSet<UserRoles>();
	public Map<Integer, String> programsMap = new HashMap<Integer, String>();
	public Set<Program> programSet = new HashSet<Program>();
	public Map<Integer, String> faciliteisMap = new HashMap<Integer, String>();
	public Set<Facilities> facilitiesSet = new HashSet<Facilities>();
	@Autowired
	private UserDao userDao;
	ObjectMapper mapper = new ObjectMapper();

	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
		mapper.setDateFormat(dateFormat);
	}

	@Autowired
	private AdminDAO adminDAO;

	public void init() {

		/* Move it to properties file. */

		/* Create All collection if not found Start */

		List<String> dbCollections = adminDAO.getListOfCollections();
		Set<String> collections = new HashSet<String>();
		collections.add("userRoles");
		collections.add("program");
		collections.add("facilities");
		collections.add("userCredentials");
		collections.add("student");
		collections.add("feeDetails");		
		collections.add("feeStructure");
		collections.add("programFee");
		collections.add("dayCareFee");
		collections.add("transportFee");
		collections.add("foodFee");
		for (String coll : collections) {
			if (dbCollections == null || !dbCollections.contains(coll)) {
				/* Insert collections if not exists in DB. */
				adminDAO.createCollection(coll);
				logger.info("DB Collections Created::" + coll);
			}
		}
		/* Create All collection if not found End */

		/* Insert User Roles */

		List<UserRoles> insertRolesList = new ArrayList<UserRoles>();
		userRoleCreation(insertRolesList, 1, "Admin");
		userRoleCreation(insertRolesList, 2, "User");
		if (rolesMap.isEmpty()) {
			/* Insert new Roles */
			adminDAO.insertManyDocuments("userRoles", insertRolesList);
			loadUserRoles();
			logger.info("User Roles Added::");
		}

		/* Insert Admin user */
		List<User> insertUserList = new ArrayList<User>();
		User user = new User("$2a$10$FDY/fvJ9M3yoaZuLyfukJuyOii3iZw6X7OK694P5UEd5dCkX/5Mr6", "Admin", 1, true, new Date(), new Date());
		insertUserList.add(user);
		if (userDao.fetchUser(user) == null) {
			/* Insert Admin Credentials */
			adminDAO.insertManyDocuments("userCredentials", insertUserList);
			logger.info("Basic Credentials Added::");
		}
		/* Insert Program */

		/* Insert Facilities */

	}

	private void userRoleCreation(List<UserRoles> insertRolesList, int roleId, String roleName) {
		UserRoles role = new UserRoles(roleId, roleName, new Date(), new Date());
		insertRolesList.add(role);
	}

	@PostConstruct
	public void loadMasterData() {
		// Load User Roles
		loadUserRoles();
		// Load Programs
		MongoCursor<Document> programs = loadPrograms();
		// Load Facilities
		loadFacilities(programs);
		init();
	}

	private void loadFacilities(MongoCursor<Document> programs) {
		FindIterable<Document> facilityIdCollection = adminDAO.getCollection("facilityId");
		facilityIdCollection.projection(Projections.excludeId());
		MongoCursor<Document> facilities = facilityIdCollection.iterator();
		while (facilities.hasNext()) {
			try {
				Facilities result = mapper.readValue(facilities.next().toJson(), Facilities.class);
				facilitiesSet.add(result);
				faciliteisMap.put(result.getFacilityId(), result.getFacilityName());
			} catch (JsonParseException e) {
				logger.error("JSON Parse Exception::while Loading User Roles" + e);
			} catch (JsonMappingException e) {
				logger.error("JSON Mapping Exception::while Loading User Roles" + e);
			} catch (IOException e) {
				logger.error("IO Exception::while Loading User Roles" + e);
			}
		}
	}

	private MongoCursor<Document> loadPrograms() {
		FindIterable<Document> programsCollection = adminDAO.getCollection("program");
		programsCollection.projection(Projections.excludeId());
		MongoCursor<Document> programs = programsCollection.iterator();
		while (programs.hasNext()) {
			try {
				Program result = mapper.readValue(programs.next().toJson(), Program.class);
				programSet.add(result);
				programsMap.put(result.getProgramId(), result.getProgramName());
			} catch (JsonParseException e) {
				logger.error("JSON Parse Exception::while Loading User Roles" + e);
			} catch (JsonMappingException e) {
				logger.error("JSON Mapping Exception::while Loading User Roles" + e);
			} catch (IOException e) {
				logger.error("IO Exception::while Loading User Roles" + e);
			}
		}
		return programs;
	}

	private void loadUserRoles() {
		FindIterable<Document> userRolesCollection = adminDAO.getCollection("userRoles");
		userRolesCollection.projection(Projections.excludeId());
		MongoCursor<Document> userRoles = userRolesCollection.iterator();
		while (userRoles.hasNext()) {
			try {
				UserRoles result = mapper.readValue(userRoles.next().toJson(), UserRoles.class);
				userRolesSet.add(result);
				rolesMap.put(result.getRoleId(), result.getRoleName());
			} catch (JsonParseException e) {
				logger.error("JSON Parse Exception::while Loading User Roles" + e);
			} catch (JsonMappingException e) {
				logger.error("JSON Mapping Exception::while Loading User Roles" + e);
			} catch (IOException e) {
				logger.error("IO Exception::while Loading User Roles" + e);
			}
		}
	}

	/**
	 * @return the adminDAO
	 */
	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	/**
	 * @param adminDAO
	 *            the adminDAO to set
	 */
	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
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
}
