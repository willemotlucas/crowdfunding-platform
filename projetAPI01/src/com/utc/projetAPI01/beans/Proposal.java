package com.utc.projetAPI01.beans;

import java.sql.Date;

public class Proposal extends APhase{
	public Proposal(){
		super();
	}
	
	public Proposal(Date d, PhaseContext c){
		super(d,c);
	}
}
