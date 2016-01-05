package com.utc.projetAPI01.beans;

public class PhaseContext {
	
	private Integer		id;
	private String		currentPhase;
	private Idea		idea;
	
	public PhaseContext() {
	}
	
	public PhaseContext(Integer i, String c, Idea idea)
	{
		this.id = i;
		this.currentPhase = c;
		this.idea = idea;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setCurrentPhase(String currentPhase) {
		this.currentPhase = currentPhase;
	}
	
	public String getCurrentPhase() {
		return currentPhase;
	}
	
	public void setIdea(Idea idea) {
		this.idea = idea;
	}
	
	public Idea getIdea() {
		return idea;
	}

}
