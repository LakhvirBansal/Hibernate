package com.hibernate.dao;

import org.hibernate.Session;

import com.hibernate.entity.Link;

public interface LinkDao {

	Link getLinksForSpecifiedLinkId(Session session, long linkId);
	
}
