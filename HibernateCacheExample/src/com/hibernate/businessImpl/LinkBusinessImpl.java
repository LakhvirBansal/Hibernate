package com.hibernate.businessImpl;

import org.hibernate.Session;

import com.hibernate.business.LinkData;
import com.hibernate.dao.LinkDao;
import com.hibernate.daoImpl.LinkDaoImpl;
import com.hibernate.entity.Link;

public class LinkBusinessImpl implements LinkData {


	@Override
	public void getSpecificLink(Session session, long linkId) {
		LinkDao linkDao = new LinkDaoImpl();
		Link link = linkDao.getLinksForSpecifiedLinkId(session, linkId);
		//session.evict(link);
		//session.clear();
		if(link != null){
			System.out.println("the link description is "+link.getLinkDescription());
			System.out.println("the link identifier is "+link.getLinkIdentifier());
		}
		
	}

}
