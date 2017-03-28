package com.hibernate.businessImpl;

import java.util.List;

import org.hibernate.Session;

import com.hibernate.business.LinkData;
import com.hibernate.dao.LinkDao;
import com.hibernate.daoImpl.LinkDaoImpl;
import com.hibernate.entity.Link;

public class LinkBusinessImpl implements LinkData {

	@Override
	public void getAllLinks(Session session) {

		LinkDao linkDao = new LinkDaoImpl();
		List<Link> linkList = linkDao.getAllLinks(session);
		
		if(linkList != null && !linkList.isEmpty()){
			for (Link link : linkList) {
				System.out.println("the link name is "+link.getLinkIdentifier());
				System.out.println("the link description is "+link.getLinkDescription());
			}
		}
	}

	@Override
	public void getSpecificLink(Session session, long linkId) {
		LinkDao linkDao = new LinkDaoImpl();
		List<Link> linkList = linkDao.getLinksForSpecifiedLinkId(session, linkId);
		
		if(linkList != null && !linkList.isEmpty()){
			for (Link link : linkList) {
				System.out.println("the link name is "+link.getLinkIdentifier());
				System.out.println("the link description is "+link.getLinkDescription());
				
			}
		}
		
	}

	@Override
	public void getLinkForSpecificStatus(Session session, int statusId) {
		LinkDao linkDao = new LinkDaoImpl();
		List<Link> linkList = linkDao.getAllLinksForSpecificStatus(session, statusId);
		
		if(linkList != null && !linkList.isEmpty()){
			System.out.println("total no of record for status is :"+linkList.size());
			for (Link link : linkList) {
				System.out.println("the link name is "+link.getLinkIdentifier());
				System.out.println("the link description is "+link.getLinkDescription());
			}
		}
		
	}

	@Override
	public void getPartialDataForAllLinks(Session session) {

		LinkDao linkDao = new LinkDaoImpl();
		List<Object[]> linkList = linkDao.getPartialDataForAllLinks(session);
		
		if(linkList != null && !linkList.isEmpty()){
			for (Object[] link : linkList) {
				System.out.println("the link name is "+link[0]);
				System.out.println("the link description is "+link[1]);
			}
		}
		
	}

	@Override
	public void getLinkNames(Session session) {
		
		LinkDao linkDao = new LinkDaoImpl();
		List<String> linkList = linkDao.getLinkNames(session);
		
		if(linkList != null && !linkList.isEmpty()){
			for (String linkName : linkList) {
				System.out.println("the link name is "+linkName);
			}
		}
		
	}

	@Override
	public void getNamedQuery(Session session) {
		System.out.println("inside getNamedQuery ");
		LinkDao linkDao = new LinkDaoImpl();
		List<Link> linkList = linkDao.getLinksFromNamedQuery(session);
		
		if(linkList != null && !linkList.isEmpty()){
			for (Link link : linkList) {
				System.out.println("the link name is "+link.getLinkIdentifier());
			}
		}
	}

	@Override
	public void getSqlNamedQuery(Session session) {
		System.out.println("inside getSQlNamedQuery ");
		LinkDao linkDao = new LinkDaoImpl();
		List<Object[]> linkList = linkDao.getLinkFromSqlNamedQuery(session);
		
		if(linkList != null && !linkList.isEmpty()){
			for (Object[] row : linkList) {
				System.out.println("the link description is "+row[4]);
			}
		}
		
	}

	@Override
	public void getLinkNameFromSqlNamedQuery(Session session) {
		System.out.println("inside getLinkNameSQlNamedQuery ");
		LinkDao linkDao = new LinkDaoImpl();
		List<String> linkList = linkDao.getLinkNameFromSqlNamedQuery(session);
		
		if(linkList != null && !linkList.isEmpty()){
			for (String linkName : linkList) {
				System.out.println("the link name is "+linkName);
			}
		}
		
	}

}
