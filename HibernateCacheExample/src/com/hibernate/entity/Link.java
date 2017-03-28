package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@NamedQuery(name="getAllLinks",query="from Link l")

@NamedNativeQueries({@NamedNativeQuery(name="getLinksFromSqlQuery",query="select * from PEN_LIS_Link "),
	@NamedNativeQuery(name="getLinksNameFromSqlQuery",query="select LinkIdentifier from PEN_LIS_Link ") })

//@NamedNativeQuery(name="getLinksFromSqlQuery",query="select * from PEN_LIS_Link ")
@Entity
@Table(name="PEN_LIS_Link")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Link {

	@Id
	@Column(name="LinkID")
	private Long LinkId;

	@Column(name="LinkIdentifier")
	private String linkIdentifier;
	
	@Column(name="LinkDescription")
	private String linkDescription;
	
	@Column(name="LinkStatusID")
	private Long LinkStatus;
	
	@Column(name="LinkType")
	private Byte LinkType;

	public Long getLinkId() {
		return LinkId;
	}

	public void setLinkId(Long linkId) {
		LinkId = linkId;
	}

	public String getLinkIdentifier() {
		return linkIdentifier;
	}

	public void setLinkIdentifier(String linkIdentifier) {
		this.linkIdentifier = linkIdentifier;
	}

	public String getLinkDescription() {
		return linkDescription;
	}

	public void setLinkDescription(String linkDescription) {
		this.linkDescription = linkDescription;
	}

	public Long getLinkStatus() {
		return LinkStatus;
	}

	public void setLinkStatus(Long linkStatus) {
		LinkStatus = linkStatus;
	}

	public Byte getLinkType() {
		return LinkType;
	}

	public void setLinkType(Byte linkType) {
		LinkType = linkType;
	}


}

