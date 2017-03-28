package com.hibernate.business;


import org.hibernate.Session;


public interface LinkData {

	void getAllLinks(Session session);
	
	void getSpecificLink(Session session, long linkId);
	
	void getLinkForSpecificStatus(Session session, int statusId);
	
	void getPartialDataForAllLinks(Session session);
	
	void getLinkNames(Session session);
	
	void getNamedQuery(Session session);
	
	void getSqlNamedQuery(Session session);
	
	void getLinkNameFromSqlNamedQuery(Session session);
}
