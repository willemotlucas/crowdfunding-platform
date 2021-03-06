package com.utc.projetAPI01.beans;

public class MakeFund {
	
	private Integer 		id;
	private Integer			amount;
	private Utilisateur		utilisateur;
	private	Fund			fund;
	
	public MakeFund()
	{
	}
	
	public MakeFund(Integer amount, Utilisateur user, Fund fund)
	{
		this.amount = amount;
		this.utilisateur = user;
		this.fund = fund;
	}
	
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public void setFund(Fund fund) {
		this.fund = fund;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public Integer getAmount() {
		return amount;
	}
	
	public Fund getFund() {
		return fund;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
}
