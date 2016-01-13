package com.utc.projetAPI01.beans;

import java.sql.Date;

public class Redaction extends APhase{
	private String			longDescription;
	
	public Redaction() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Redaction(Date d, String l, PhaseContext c)
	{
		super(d, c);
		this.longDescription = l;
	}
	
	public Redaction(Date d, PhaseContext c){
		super(d,c);
	}
	
	public String getLongDescription() {
		return longDescription;
	}
	
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

}
