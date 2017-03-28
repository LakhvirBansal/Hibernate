package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.entity.Cheque;
import com.hibernate.entity.CreditCard;
import com.hibernate.entity.Payment;

public class studentContactScheduler {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
			Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			 
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			Payment p = new Payment();
			p.setAmount(1000d);
			
			CreditCard c = new CreditCard();
			c.setAmount(20000d);
			c.setCreditCardType("abccc");

			Cheque ch = new Cheque();
			ch.setAmount(50000d);
			ch.setChequeType("abccc");
			
			session.save(p);
			session.save(c);
			session.save(ch);
			
			/*Cheque cq = (Cheque) session.get(Cheque.class, 4l);
			System.out.println(cq.getChequeType());*/
			tx.commit();
		}
		catch(Exception e){
			tx.rollback();
			System.out.println(e.getMessage());
		}
		finally{
			sessionFactory.close();
			
		}
	}
}
