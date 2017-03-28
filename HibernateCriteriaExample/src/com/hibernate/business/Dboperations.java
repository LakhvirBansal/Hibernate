package com.hibernate.business;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
			
			//getAllStudent(session);
			//getStudentByStudentName(session);
			//getStudentOrderByName(session);
			//getPartialDataForStudent(session);
			//getSearchStudentByName(session);
			//logicalexpression(session);
			pagination(session);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
			sessionFactory.close();
		}
	
	}

	private static void pagination(Session session) {
		Criteria crit = session.createCriteria(Student.class);
		crit.setFirstResult(1);
		crit.setMaxResults(5);
		List<Student> results = crit.list();
		
		if(results != null && !results.isEmpty()){
			for (Student student : results) {
				System.out.println("the id is"+student.getId()+"+.getthe firstname is :"+student.getFirstName()+": lastName is :"+student.getLastName());
			}
		}
		
	}

	private static void logicalexpression(Session session) {
		Criteria crit = session.createCriteria(Student.class);
		Criterion firstName = Restrictions.eq("firstName","lakhvir");
		Criterion lastName = Restrictions.like("lastName", "uniyal", MatchMode.ANYWHERE);
		LogicalExpression orExp = Restrictions.or(firstName, lastName);
		crit.add(orExp);
		List<Student> results=crit.list();
		
		if(results != null && !results.isEmpty()){
			for (Student student : results) {
				System.out.println("the firstname is :"+student.getFirstName()+": lastName is :"+student.getLastName());
			}
		}
		
	}

	private static void getSearchStudentByName(Session session) {

		Criteria crit = session.createCriteria(Student.class);
		crit.add(Restrictions.like("firstName","ra",MatchMode.ANYWHERE));
		List<Student> results = crit.list();
		
		if(results != null && !results.isEmpty()){
			for (Student student : results) {
				System.out.println("the firstname is :"+student.getFirstName()+": lastName is :"+student.getLastName());
			}
		}
		
	}

	public static void getAllStudent(Session session) {
		Criteria c=session.createCriteria(Student.class);
		List<Student> studentList=c.list(); 
		
		if(studentList != null && !studentList.isEmpty()){
			for (Student student : studentList) {
				System.out.println("student first name :"+student.getFirstName());
			}
		
		}
	}
	
	public static void getStudentByStudentName(Session session) {
		Criteria c=session.createCriteria(Student.class);
		c.add(Restrictions.eq("firstName", "lakhvir"));
		@SuppressWarnings("unchecked")
		List<Student> studentList=c.list(); 
		
		if(studentList != null && !studentList.isEmpty()){
			for (Student student : studentList) {
				System.out.println("student first name :"+student.getFirstName());
			}
		
		}
	}
	
	public static void getStudentOrderByName(Session session) {
		Criteria c=session.createCriteria(Student.class);
		c.add(Restrictions.gt("id", 10l));
		c.addOrder(Order.asc("firstName"));
		List<Student> studentList=c.list(); 
		if(studentList != null && !studentList.isEmpty()){
			for (Student student : studentList) {
				System.out.println("student first name :"+student.getFirstName());
			}
		
		}
	}
	
	public static void getPartialDataForStudent(Session session) {
		Criteria c=session.createCriteria(Student.class);
		ProjectionList p1=Projections.projectionList();
        p1.add(Projections.property("firstName"));
        p1.add(Projections.property("lastName"));	
        c.setProjection(p1);
        c.addOrder(Order.asc("firstName"));
		List<Object[]> studentList=c.list(); 

		if(studentList != null && !studentList.isEmpty()){
			for (Object[] row : studentList) {
				System.out.println("the firstname is :"+String.valueOf(row[0])+": lastName is :"+String.valueOf(row[1]));
			}
		}
	}
}
