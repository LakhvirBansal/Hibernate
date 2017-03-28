package com.hibernate.business;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.entity.Student;


public class Dboperations {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		
		try{
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			
			Student std=new Student(); 
			std.setId(15l);
			std.setFirstName("nishant");
			std.setMiddleName("kumar");
			std.setLastName("garg");
			
			tx = session.beginTransaction();
			Long id = (Long) session.save(std);
			System.out.println("the primary key is :"+ id);
			
			/*session.persist(std);*/
			
			//get method
			/*Student stdObj = (Student) session.get(Student.class, 2l);
			System.out.println(stdObj.getId());
			System.out.println(stdObj.getFirstName());
			System.out.println(stdObj.getLastName());
			
			stdObj.setFirstName("vijay");
			stdObj.setLastName("uniyal");*/
			
			// load method
			
			/*Student stdObj1 = (Student) session.load(Student.class, 2l);
			System.out.println(stdObj1.getId());
			System.out.println(stdObj1.getLastName());*/
			
			
			//System.out.println("Object saved successfully using annotations.....!!");
			//getStudentData(session);
			//getSpecificData(session);
			//getParticularColumn(session);
			//updateStudent(session);
			tx.commit();
			
			
		}
		catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
			sessionFactory.close();
		}
	
	}
}
