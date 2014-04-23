package com.intuitiv.campus.test.dao;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.intuitiv.campus.dao.CampusDao;
import com.intuitiv.campus.entity.Campus;

public class CampusDaoTest extends AbstractDaoTest {

	@Autowired
	CampusDao campusDao;

	@Test
	public void testListCampus(){
		Assert.assertTrue(CollectionUtils.isNotEmpty(campusDao.list(Campus.class)));
	}

}
