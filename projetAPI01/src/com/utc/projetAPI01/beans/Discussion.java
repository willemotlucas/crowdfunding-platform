package com.utc.projetAPI01.beans;

import java.sql.Date;
import java.util.Set;

public class Discussion extends APhase {
	
	private Set<Thumb> thumbs;
	
	public Discussion(){
		super();
	}
	
	public Discussion(Date d, PhaseContext c){
		super(d,c);
	}
	
	public void setThumbs(Set<Thumb> thumbs) {
		this.thumbs = thumbs;
	}
	
	public Set<Thumb> getThumbs() {
		return thumbs;
	}
	
}
