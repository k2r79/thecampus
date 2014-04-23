package com.intuitiv.campus.dao.impl;

import org.springframework.stereotype.Repository;

import com.intuitiv.campus.dao.AbstractDao;
import com.intuitiv.campus.dao.CampusDao;
import com.intuitiv.campus.entity.Campus;

@Repository("CampusDao")
public class CampusDaoImpl extends AbstractDao<Campus, Long> implements CampusDao {

	public CampusDaoImpl() {
		super();
	}

}
