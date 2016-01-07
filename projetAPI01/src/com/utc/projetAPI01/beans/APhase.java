package com.utc.projetAPI01.beans;

import java.sql.Date;

public abstract class APhase {
	private Integer 		id;
	private Date			datePhase;
	private PhaseContext	context;
	
	public APhase() {
		// TODO Auto-generated constructor stub
	}
	
	public APhase(Date d, PhaseContext c)
	{
		this.datePhase = d;
		this.context = c;
	}
	
	public void setContext(PhaseContext context) {
		this.context = context;
	}
	
	public void setDatePhase(Date datePhase) {
		this.datePhase = datePhase;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public PhaseContext getContext() {
		return context;
	}
	
	public Date getDatePhase() {
		return datePhase;
	}
	
	public Integer getId() {
		return id;
	}

}
