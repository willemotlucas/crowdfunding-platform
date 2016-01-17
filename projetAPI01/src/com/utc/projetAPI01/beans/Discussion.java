package com.utc.projetAPI01.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Discussion extends APhase {
	
	private Set<Thumb> thumbs = new HashSet<Thumb>();
	
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
