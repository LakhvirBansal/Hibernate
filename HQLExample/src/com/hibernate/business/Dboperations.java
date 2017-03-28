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
		try{
			Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			 
			session = sessionFactory.openSession();
			//getStudentData(session);
			//getSpecificData(session);
			//getParticularColumn(session);
			
			//updateStudent(session);
			//deleteStudent(session);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
			sessionFactory.close();
		}
	
	}

	private static void deleteStudent(Session session) {
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String hql = "Delete Student s where s.id = 1 ";
			Query query = session.createQuery(hql);
			int res = query.executeUpdate();
			if(res == 1){
				System.out.println("record deleted successfully");
			}
		} catch(Exception e){
			tx.rollback();
		} finally{
			tx.commit();
		}
		
	}

	private static void updateStudent(Session session) {
		
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			String hql = "update Student s set s.firstName='Rajat'  ";
			Query query = session.createQuery(hql);
			int res = query.executeUpdate();
			
				System.out.println("record updated successfully"+res);
			
		} catch(Exception e){
			tx.rollback();
		} finally{
			tx.commit();
		}
	}

	@SuppressWarnings("unchecked")
	private static void getParticularColumn(Session session) {
		
		String hql = "select s.firstName from Student s";
		
		Query query = session.createQuery(hql);
		List<String> stdList = query.list();
		if(stdList != null){
			for (String firstName : stdList) {
				System.out.println("std Firstname is "+firstName);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static void getSpecificData(Session session) {
	String hql = "select s.firstName, s.lastName from Student s";
		
		Query query = session.createQuery(hql);
		List<Object[]> stdList = query.list();
		if(stdList != null){
			for (Object[] row : stdList) {
				System.out.println("std firstname and lastname is "+row[0]+" "+row[1]);
			}
		}
		
	}

	@SuppressWarnings("unchecked")
	private static void getStudentData(Session session) {
		String hql = "from Student s";
		
		Query query = session.createQuery(hql);
		List<Student> stdList = query.list();
		if(stdList != null){
			for (Student student : stdList) {
				System.out.println("std full name is "+student.getFirstName()+" "+student.getMiddleName()+" "+student.getLastName());
			}
		}
		
	}
}
