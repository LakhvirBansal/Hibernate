package com.hibernate.business;


import org.hibernate.Session;


public interface LinkData {

	
	
	void getSpecificLink(Session session, long linkId);
	
	
}
