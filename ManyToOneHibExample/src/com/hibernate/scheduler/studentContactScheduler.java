package com.hibernate.scheduler;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.entity.Student;
import com.hibernate.entity.Student_contact;

public class studentContactScheduler {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		/*Transaction tx = null;*/
		try{
			Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			 
			session = sessionFactory.openSession();
			/*tx = session.beginTransaction();
			Student st = new Student();
			st.setFirstName("ajay");
			st.setLastName("singh");
			session.save(st);
			
			Student_contact sc = new Student_contact();
			sc.setAddrLine1("h no -12 near market");
			sc.setAddrLine2("housing board colony");
			sc.setDistrict("pathankot");
			sc.setPin(234l);
			sc.setState("punjab");
			sc.setStudent(st);
			session.save(sc);
			
			Student_contact sc1 = new Student_contact();
			sc1.setAddrLine1("h.no 123");
			sc1.setAddrLine2("mdc5");
			sc1.setDistrict("panchkula");
			sc1.setPin(56789l);
			sc1.setState("haryana");
			sc1.setStudent(st);
			session.save(sc1);
			tx.commit();*/
			
			/*Student st1 = (Student) session.get(Student.class,4l);
			
			List<Student_contact> contactList = st1.getContacts();
			for (Student_contact student_contact : contactList) {
				System.out.println("address line 1 :"+student_contact.getAddrLine1()+": address line 2 :"+student_contact.getAddrLine2());
			}
			*/
			//getContactsInfo(session);	//joins in hql
			//getContactsInfoByOrder(session); 
			//getContactsInfoByNamedParameters(session, "punjab");    // for named parameters
			//getContactsInfoByPositonParameters(session, "punjab");	// for position parameters
			
			//getContactsInfoForPagination(session); // for pagination
			//getUniqueResult(session); // for unique result
			//getMaxPinCode(session);
			
			//getContactsInfoBynativeSQl(session);
			//getWholeObjectBynativeSQl(session);
			
			//getContactsForParticularStudent(session);
			getStudentInfo(session);
			
			
		}
		catch(Exception e){
		/*	tx.rollback();*/
			e.printStackTrace();
		}
		finally{
			session.close();
			sessionFactory.close();
			
		}
	}

	
	private static void getContactsInfo(Session session) {
		
		String query = "select c.addrLine1, s.firstName from Student_contact c inner join c.student s where c.state ='punjab'";
		
		Query hqlQuery = session.createQuery(query);
		List<Object[]> result= hqlQuery.list();
		
		if(result != null && !result.isEmpty()) {
			for (Object[] row : result) {
				String address = String.valueOf(row[0]);
				String firstName =String.valueOf(row[1]);
				System.out.println("the address is :"+address+": the firstName is :"+firstName);
				
			}
		}
	}
	
	private static void getContactsInfoByOrder(Session session) {

		String query = "select c.addrLine1, s.firstName from Student_contact c inner join c.student s where c.state ='punjab' order by c.addrLine1 ";
		
		Query hqlQuery = session.createQuery(query);
		List<Object[]> result= hqlQuery.list();
		
		if(result != null && !result.isEmpty()) {
			for (Object[] row : result) {
				String address = String.valueOf(row[0]);
				String firstName =String.valueOf(row[1]);
				System.out.println("the address is :"+address+": the firstName is :"+firstName);
				
			}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	private static void getContactsInfoByPositonParameters(Session session,String stateName) {

		String query = "select c.addrLine1, s.firstName from Student_contact c inner join c.student s where c.state =? order by c.addrLine1 ";
		
		Query hqlQuery = session.createQuery(query);
		hqlQuery.setParameter(0, stateName);
		List<Object[]> result= hqlQuery.list();
		
		System.out.println("Result data using positional parameters");
		if(result != null && !result.isEmpty()) {
			for (Object[] row : result) {
				String address = String.valueOf(row[0]);
				String firstName =String.valueOf(row[1]);
				System.out.println("the address is :"+address+": the firstName is :"+firstName);
				
			}
		}
		
	}

	@SuppressWarnings("unchecked")
	private static void getContactsInfoByNamedParameters(Session session,String stateName) {

		String query = "select c.addrLine1, s.firstName from Student_contact c inner join c.student s where c.state =:stateName order by c.addrLine1 ";
		
		Query hqlQuery = session.createQuery(query);
		hqlQuery.setParameter("stateName", stateName);
		List<Object[]> result= hqlQuery.list();
		
		System.out.println("Result data using named parameters");
		if(result != null && !result.isEmpty()) {
			for (Object[] row : result) {
				String address = String.valueOf(row[0]);
				String firstName =String.valueOf(row[1]);
				System.out.println("the address is :"+address+": the firstName is :"+firstName);
				
			}
		}
		
	}
	
	private static void getContactsInfoForPagination(Session session) {
		
		String query = "select c from Student_contact c ";
		
		Query hqlQuery = session.createQuery(query);
		/*hqlQuery.setFirstResult(3);
		hqlQuery.setMaxResults(2);*/
		List<Student_contact> result= hqlQuery.list();
		
		System.out.println("Result data for pagination");
		if(result != null && !result.isEmpty()) {
			for (Student_contact student_contact : result) {
				student_contact.getStudent().getFirstName();
				System.out.println("the state is :"+student_contact.getState()+": and district is :"+student_contact.getDistrict());
			}
		}
	}
	
	private static void getUniqueResult(Session session) {
		String query = "select c from Student_contact c where c.pin > 1212";
		
		Query hqlQuery = session.createQuery(query);
		Student_contact student_contact= (Student_contact) hqlQuery.uniqueResult();
		
		System.out.println("Result data for pagination");
		if(student_contact != null) {
			System.out.println("the state is :"+student_contact.getState()+": and district is :"+student_contact.getDistrict());
		}
		
	}
	
	private static void getMaxPinCode(Session session) {
		String query = "select Max(c.pin) from Student_contact c";
		
		Query hqlQuery = session.createQuery(query);
		Long maxPin= (Long) hqlQuery.uniqueResult();
		
		System.out.println("the max pinValue is :"+maxPin);
		
	}
	
	@SuppressWarnings("unchecked")
	private static void getContactsInfoBynativeSQl(Session session) {

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT contact.`address_line_1`,contact.`address_line_2`, student.`STD_FNAME` FROM `student_contact` contact ")
		.append(" JOIN `student` student ON student.`STD_ID` = contact.`student_id` ");
		
		SQLQuery sqlQuery = session.createSQLQuery(sb.toString());
		//sqlQuery.list();
		List<Object[]> result= sqlQuery.list();
		
		if(result != null && !result.isEmpty()) {
			for (Object[] row : result) {
				String address = String.valueOf(row[0]);
				String firstName =String.valueOf(row[2]);
				System.out.println("the address is :"+address+": the firstName is :"+firstName);
				
			}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	private static void getWholeObjectBynativeSQl(Session session) {

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT contact.* from  student_contact contact");
		
		SQLQuery sqlQuery = session.createSQLQuery(sb.toString());
		sqlQuery.addEntity("contact",Student_contact.class);
		List<Student_contact> result= sqlQuery.list();
		
		if(result != null && !result.isEmpty()) {
			for (Student_contact studentContact : result) {
				System.out.println("the address is :"+studentContact.getAddrLine1()+": the firstName is :"+studentContact.getState());
				
			}
		}
		
	}

	private static void getContactsForParticularStudent(Session session) {
		Criteria crit = session.createCriteria(Student_contact.class);
		Criteria prdCrit = crit.createCriteria("student");
		prdCrit.add(Restrictions.eq("firstName","lakhvir"));
		List<Student_contact> results = crit.list();
		
		if(results != null && !results.isEmpty()) {
			for (Student_contact student_contact : results) {
				System.out.println("the state is :"+student_contact.getState()+": and district is :"+student_contact.getDistrict());
			}
		}
		
	}

@SuppressWarnings("unchecked")
private static void getStudentInfo(Session session) {
		
		String query = "select c from Student c ";
		
		Query hqlQuery = session.createQuery(query);
		/*hqlQuery.setFirstResult(3);
		hqlQuery.setMaxResults(2);*/
		List<Student> result= hqlQuery.list();
		
		System.out.println("Result data for student");
		if(result != null && !result.isEmpty()) {
			for (Student student : result) {
				
				System.out.println("the state is :"+student.getFirstName()+": and district is :"+student.getLastName());
			}
		}
	}
	



	

	

	
}
