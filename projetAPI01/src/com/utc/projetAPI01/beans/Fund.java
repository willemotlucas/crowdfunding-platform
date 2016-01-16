package com.utc.projetAPI01.beans;

import java.sql.Date;
import java.util.Set;

public class Fund extends APhase{
	
	private Set<MakeFund> funds;
	
	public void setFunds(Set<MakeFund> funds) {
		this.funds = funds;
	}
	
	
	public Set<MakeFund> getFunds() {
		return funds;
	}
}
