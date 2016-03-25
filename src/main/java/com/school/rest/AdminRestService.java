package com.school.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.service.AdminService;
import com.school.vo.Status;
import com.school.vo.User;
import com.school.vo.UserStatus;

@Component
@Path("/admin")
public class AdminRestService {
	@Autowired
	private AdminService adminService;

	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public UserStatus vaidateUserCredentials(User user) {
		return adminService.validateUser(user);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("test")
	public String vaidateUserCredentials() {
		return "helloWord";
	}

	@Path("passwordReset")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public Status passwordReset(User user) {
		return adminService.passwordReset(user);
	}

	@Path("deleteUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public Status deleteUser(User user) {
		return adminService.deleteUser(user);
	}

	@Path("createUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public Status createUser(User user) {
		return adminService.createUser(user);
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
}
