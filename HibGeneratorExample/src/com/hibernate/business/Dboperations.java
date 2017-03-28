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

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
			Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			 
			session = sessionFactory.openSession();
			// assigned generator (we have to assign the id value explicitly)
			
			/*Student std=new Student(); 
			std.setId(19l);
			std.setFirstName("vijay");
			std.setMiddleName("prakash");
			std.setLastName("uniyal");
			
			tx = session.beginTransaction();
			session.persist(std);
			tx.commit();*/
			
			// increment generator (find the max Idvalue from db and user formula Idvalue+1)
			Student std=new Student(); 
			
			std.setFirstName("a1");
			std.setMiddleName("b1");
			std.setLastName("c1");
			
			tx = session.beginTransaction();
			session.persist(std);
			tx.commit();
			
			// identity generator DB dependent internally db generates the idval
			/*Student std=new Student();
			 *  
			std.setFirstName("a");
			std.setMiddleName("b");
			std.setLastName("c");
			
			tx = session.beginTransaction();
			session.persist(std);
			tx.commit();*/
			
			
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

	private static void updateStudent(Session session) {
		
		String hql = "update Student s set s.firstName='Rajat' where s.id = 1 ";
		
		Query query = session.createQuery(hql);
		int res = query.executeUpdate();
		if(res == 1){
			System.out.println("record updated successfully");
		}
		
	}

	private static void getParticularColumn(Session session) {
		
		String hql = "select s.firstName from Student s";
		
		Query query = session.createQuery(hql);
		List<String> stdList = query.list();
		if(stdList != null){
			for (String firstName : stdList) {
				System.out.println("std name is "+firstName);
			}
		}
	}

	private static void getSpecificData(Session session) {
	String hql = "select s.firstName, s.lastName from Student s";
		
		Query query = session.createQuery(hql);
		List<Object[]> stdList = query.list();
		if(stdList != null){
			for (Object[] row : stdList) {
				System.out.println("std name is "+row[0]+" "+row[1]);
			}
		}
		
	}

	private static void getStudentData(Session session) {
		String hql = "from Student s";
		
		Query query = session.createQuery(hql);
		List<Student> stdList = query.list();
		if(stdList != null){
			for (Student student : stdList) {
				System.out.println("std name is "+student.getFirstName()+" "+student.getMiddleName()+" "+student.getLastName());
			}
		}
		
	}
}
