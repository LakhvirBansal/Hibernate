package com.hibernate.scheduler;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.business.LinkData;
import com.hibernate.businessImpl.LinkBusinessImpl;
import com.hibernate.entity.Link;

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
			
			System.out.println("first level cache");
			System.out.println("first time fetch");
			data.getSpecificLink(session, 2351l);
			
			System.out.println("second time fetch");
			data.getSpecificLink(session, 2351l);
			session.close();
		
			System.out.println("Second level cache");
			Session session1=sessionFactory.openSession();  
			Link link=(Link)session1.load(Link.class,2322l);  
		    System.out.println(link.getLinkIdentifier());  
		    session1.close();  
		      
		    System.out.println("waiting ");
		    try{
				Thread.sleep(6000);
			}
			catch (Exception e) {
			}		
	 
		    
		    Session session2=sessionFactory.openSession();  
		    Link link2=(Link)session2.load(Link.class,2322l);  
		    System.out.println(link2.getLinkDescription());  
		    session2.close();  
		      
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			sessionFactory.close();
		}
	}
}
