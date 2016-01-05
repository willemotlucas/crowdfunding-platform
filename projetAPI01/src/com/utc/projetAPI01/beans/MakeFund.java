package com.utc.projetAPI01.beans;

public class MakeFund {
	
	private Integer 		id;
	private Integer			amount;
	private Utilisateur		utilisateur;
	private	Fund			fund;
	
	public MakeFund()
	{
	}
	
	public MakeFund(Integer id, Integer amount, Utilisateur utilisateur, Fund fund)
	{
		this.id = id;
		this.amount = amount;
		this.utilisateur = utilisateur;
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
