package com.hibernate.daoImpl;

import org.hibernate.Session;

import com.hibernate.dao.LinkDao;
import com.hibernate.entity.Link;

public class LinkDaoImpl implements LinkDao {

	@Override
	public Link getLinksForSpecifiedLinkId(Session session, long linkId) {
		Link link = (Link) session.get(Link.class, linkId);
		return link;
	}

}
