package com.intuitiv.campus.test.controller;

import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

import org.junit.Test;

public class UserControllerTest extends AbstractControllerTest {

	@Test
	public void testUserFailLoginBecauseofEmail() throws Exception {
		request.setRequestURI("/user/login");
		request.setMethod("POST");
		request.addParameter("email", "unknown@campus.fr");
		request.addParameter("password", "Test13");

		assertViewName(getResponsePage(), "Home");
	}

	@Test
	public void testUserFailLoginBecauseofPassword() throws Exception {
		request.setRequestURI("/user/login");
		request.setMethod("POST");
		request.addParameter("email", "select@campus.fr");
		request.addParameter("password", "wrongpass");

		assertViewName(getResponsePage(), "Home");
	}

	@Test
	public void testUserSucceedLogin() throws Exception {
		request.setRequestURI("/user/login");
		request.setMethod("POST");
		request.addParameter("email", "select@campus.fr");
		request.addParameter("password", "Test13");

		assertViewName(getResponsePage(), "User");
	}

}
