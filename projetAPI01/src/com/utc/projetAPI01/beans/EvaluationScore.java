package com.utc.projetAPI01.beans;

public class EvaluationScore {
	
	private Integer		id;
	private Integer		feasibiliy;
	private Integer		marketInterest;
	private Integer		impact;
	private Utilisateur	utilisateur;
	private Evaluation 	evaluation;
	
	public EvaluationScore()
	{
	}
	
	public EvaluationScore(Integer id, Integer feasibility, Integer marketInterest, Integer impact, Utilisateur utilisateur, Evaluation evaluation)
	{
		this.id = id;
		this.feasibiliy = feasibility;
		this.marketInterest = marketInterest;
		this.impact = impact;
		this.utilisateur = utilisateur;
		this.evaluation = evaluation;
	}
	
	public Evaluation getEvaluation() {
		return evaluation;
	}
	
	public Integer getFeasibiliy() {
		return feasibiliy;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Integer getImpact() {
		return impact;
	}
	
	public Integer getMarketInterest() {
		return marketInterest;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}
	
	public void setFeasibiliy(Integer feasibiliy) {
		this.feasibiliy = feasibiliy;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setImpact(Integer impact) {
		this.impact = impact;
	}
	
	public void setMarketInterest(Integer marketInterest) {
		this.marketInterest = marketInterest;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}
