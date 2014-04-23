package com.intuitiv.campus.test.service;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.intuitiv.campus.common.CampusException;
import com.intuitiv.campus.entity.Campus;
import com.intuitiv.campus.entity.User;
import com.intuitiv.campus.service.UserService;

public class UserServiceTest extends AbstractServiceTest {

	@Autowired
	UserService userService;

	private final static User user = new User();

	@Test
	public void testPasswordMatchWithEmail() {
		user.setEmail("select@campus.fr");
		user.setPassword("Test13");
		Assert.assertTrue(userService.passwordMatchWithEmail(user.getEmail(), user.getPassword()));
	}

	@Test
	public void testPasswordDoesntMatchWithEmail() {
		user.setEmail("select@campus.fr");
		user.setPassword("WrongPass");
		Assert.assertFalse(userService.passwordMatchWithEmail(user.getEmail(), user.getPassword()));
	}

	@Test
	public void testEmailExist() throws CampusException {
		user.setEmail("select@campus.fr");
		Assert.assertTrue(userService.emailExists(user.getEmail()));
	}

	@Test
	public void testEmailDoesntExist() throws CampusException {
		user.setEmail("fakeEmail@gmail.com");
		Assert.assertFalse(userService.emailExists(user.getEmail()));
	}

	@Test
	public void testGetUserByEmail() {
		user.setEmail("select@campus.fr");
		Assert.assertTrue(userService.getUserByMail(user.getEmail()).getName().equals("SelectName"));
	}

	@Test
	public void testGetAllUsersByCampus() {
		Campus campus = new Campus(1L);
		Assert.assertTrue(userService.getAllUsersByCampus(campus).size() > 0);
	}

	@Test
	public void testList() {
		Assert.assertTrue(CollectionUtils.isNotEmpty(userService.getAllUsers()));
	}

	@Test
	public void testPasswordConfirmMatchPassword() {
		Assert.assertTrue(userService.passwordConfirmMatchPassword("Test13", "Test13"));
	}

	@Test
	public void testPasswordConfirmDoesntMatchPassword() {
		Assert.assertFalse(userService.passwordConfirmMatchPassword("Test13", "pass"));
	}

}
