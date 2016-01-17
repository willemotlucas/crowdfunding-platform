package com.utc.projetAPI01.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Fund extends APhase{
	
	private Set<MakeFund> funds = new HashSet<MakeFund>();

	public Fund(Date date, PhaseContext phaseContext) {
		super(date, phaseContext);
	}
	
	public Fund()
	{
		super();
	}


	public void setFunds(Set<MakeFund> funds) {
		this.funds = funds;
	}
	
	
	public Set<MakeFund> getFunds() {
		return funds;
	}
}
