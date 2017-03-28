package com.hibernate.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.hibernate.dao.LinkDao;
import com.hibernate.entity.Link;

public class LinkDaoImpl implements LinkDao {

	@Override
	public List<Link> getAllLinks(Session session) {
		Criteria c=session.createCriteria(Link.class);
		List<Link> linkList=c.list(); 
		return linkList;
	}

	@Override
	public List<Link> getLinksForSpecifiedLinkId(Session session, long linkId) {
		Criteria c=session.createCriteria(Link.class);
		c.add(Restrictions.eq("linkIdentifier", "fae75c07180594c2"));
		c.add(Restrictions.eq("linkDescription", "Link One For Symphony Customer"));
		c.add(Restrictions.gt("LinkId", 2323l));
		@SuppressWarnings("unchecked")
		List<Link> linkList=c.list(); 
		return linkList;
	}

	@Override
	public List<Link> getAllLinksForSpecificStatus(Session session, int statusId) {
		Criteria c=session.createCriteria(Link.class);
		c.add(Restrictions.eq("LinkStatus", Long.valueOf(statusId)));
		c.addOrder(Order.asc("linkIdentifier"));
		List<Link> linkList=c.list(); 
		return linkList;
	}

	@Override
	public List<Object[]> getPartialDataForAllLinks(Session session) {
		Criteria c=session.createCriteria(Link.class);
		ProjectionList p1=Projections.projectionList();
        p1.add(Projections.property("linkIdentifier"));
        p1.add(Projections.property("linkDescription"));	
        c.setProjection(p1);
        c.addOrder(Order.asc("linkIdentifier"));
		List<Object[]> linkList=c.list(); 
		return linkList;
	}

	@Override
	public List<String> getLinkNames(Session session) {
		Criteria cr = session.createCriteria(Link.class);
		cr.setProjection(Projections.property("linkIdentifier"));
		cr.setProjection(Projections.property("linkDescription"));// linkIdentifier is overridden with linkDescription
		List<String> linkNames = cr.list();
		return linkNames;
	}

	@Override
	public List<Link> getLinksFromNamedQuery(Session session) {
		Query qry = session.getNamedQuery("getAllLinks");
		List<Link> links = qry.list();
		return links;
	}

	@Override
	public List<Object[]> getLinkFromSqlNamedQuery(Session session) {
		Query qry = session.getNamedQuery("getLinksFromSqlQuery");
		List<Object[]> links = qry.list();
		return links;
	}

	@Override
	public List<String> getLinkNameFromSqlNamedQuery(Session session) {
		Query qry = session.getNamedQuery("getLinksNameFromSqlQuery");
		List<String> linkNames = qry.list();
		return linkNames;
	}


}
