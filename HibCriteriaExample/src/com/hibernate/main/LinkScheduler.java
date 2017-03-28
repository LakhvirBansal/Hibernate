package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.business.LinkData;
import com.hibernate.businessImpl.LinkBusinessImpl;

public class LinkScheduler {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try{
			Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			 
			session = sessionFactory.openSession();
			LinkData data = new LinkBusinessImpl();
			//data.getAllLinks(session);
			data.getSpecificLink(session, 2351);
			//data.getLinkForSpecificStatus(session, 12);
			//data.getPartialDataForAllLinks(session);
			//data.getLinkNames(session);
			//data.getNamedQuery(session);
			//data.getSqlNamedQuery(session);
			//data.getLinkNameFromSqlNamedQuery(session);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
