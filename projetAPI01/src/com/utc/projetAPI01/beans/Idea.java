package com.utc.projetAPI01.beans;

import java.sql.Date;
import java.util.Set;

public class Idea {

	private Integer id;
	private String name;
	private String shortDescription;
	private String applicationField;
	private String targetedMarket;
	private Integer fundingRequested;
	private Date proposedDate;
	private Utilisateur madeBy;
	private Set<Comments> comments;
	private PhaseContext phaseContext;

	public Idea(String n, String sD, String aF, String tM, Integer fR, Date p, Utilisateur m) {
		this.name = n;
		this.shortDescription = sD;
		this.applicationField = aF;
		this.targetedMarket = tM;
		this.fundingRequested = fR;
		this.proposedDate = p;
		this.madeBy = m;
	}

	public Idea(String n, String sD, String aF, Integer fR, Date p, Utilisateur m) {
		this.name = n;
		this.shortDescription = sD;
		this.applicationField = aF;
		this.targetedMarket = "";
		this.fundingRequested = fR;
		this.proposedDate = p;
		this.madeBy = m;
	}

	public Idea() {
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public String getApplicationField() {
		return applicationField;
	}

	public String getTargetedMarket() {
		return targetedMarket;
	}

	public Integer getFundingRequested() {
		return fundingRequested;
	}

	public Date getProposedDate() {
		return proposedDate;
	}

	public Utilisateur getMadeBy() {
		return madeBy;
	}

	public void setId(Integer i) {
		id = i;
	}

	public void setName(String n) {
		name = n;
	}

	public void setShortDescription(String s) {
		shortDescription = s;
	}

	public void setApplicationField(String a) {
		applicationField = a;
	}

	public void setTargetedMarket(String t) {
		targetedMarket = t;
	}

	public void setFundingRequested(Integer f) {
		fundingRequested = f;
	}

	public void setProposedDate(Date d) {
		proposedDate = d;
	}

	public void setMadeBy(Utilisateur m) {
		madeBy = m;
	}
	
	public Set<Comments> getComments() {
		return comments;
	}
	
	public void setComments(Set<Comments> comments) {
		this.comments = comments;
	}
	
	public void setPhaseContext(PhaseContext phaseContext) {
		this.phaseContext = phaseContext;
	}
	
	public PhaseContext getPhaseContext() {
		return phaseContext;
	}

}
