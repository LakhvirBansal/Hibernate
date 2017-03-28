package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;

import com.hibernate.entity.Link;

public interface LinkDao {

	List<Link> getAllLinks(Session session);
	
	List<Link> getLinksForSpecifiedLinkId(Session session, long linkId);
	
	List<Link> getAllLinksForSpecificStatus(Session session, int statusId);
	
	List<Object[]> getPartialDataForAllLinks(Session session);
	
	List<String> getLinkNames(Session session);
	
	List<Link> getLinksFromNamedQuery(Session session);
	
	List<Object[]> getLinkFromSqlNamedQuery(Session session);
	
	List<String> getLinkNameFromSqlNamedQuery(Session session);
}
