package com.intuitiv.campus.test.service;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.intuitiv.campus.service.CampusService;

public class CampusServiceTest extends AbstractServiceTest {

	@Autowired
	CampusService campusService;

	@Test
	public void testListCampus() {
		Assert.assertTrue(CollectionUtils.isNotEmpty(campusService.list()));
	}

}
