package com.utc.projetAPI01.beans;

import java.sql.Date;
import java.util.Set;

public class Utilisateur {
	private Integer				id;
	private String				email;
	private String				nom;
	private String				prenom;
	private String				password;
	private String				telephone;
	private Date				dateCreation;
	private String				accountStatus;
	private String				accountType;
	private Adress				adress;
	private Set<Idea>			ideas;
	private Set<Comments>		comments;
	private Set<EvaluationScore> scores;
	private Set<MakeFund>		funds;
	private	Set<Thumb>			thumbs;
	
	public Utilisateur(String e, String pwd, String n, String p, String t, Date d, String aS, String aT, Adress add)
	{
		this.password = pwd;
		this.email = e;
		this.nom = n;
		this.prenom = p;
		this.telephone = t;
		this.dateCreation = d;
		this.accountStatus = aS;
		this.accountType = aT;
		this.adress = add;
	}
	
	public Utilisateur(){
		
	}
	
	
	public Integer getId()
	{
		return id;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	public String getPrenom()
	{
		return prenom;
	}
	
	public String getTelephone()
	{
		return telephone;
	}
	
	public Date getDateCreation()
	{
		return dateCreation;
	}
	
	public String getAccountStatus()
	{
		return accountStatus;
	}
	
	public String getAccountType()
	{
		return accountType;
	}
	
	public Adress getAdress()
	{
		return adress;
	}
	
	public void setId(Integer i)
	{
		id = i;
	}
	
	public void setEmail(String e)
	{
		email = e;
	}
	
	public void setNom(String n)
	{
		nom = n;
	}
	
	public void setPrenom(String p)
	{
		prenom = p;
	}
	
	public void setTelephone(String t)
	{
		telephone = t;
	}
	
	public void setDateCreation(Date d)
	{
		dateCreation = d;
	}
	
	public void setAccountStatus(String aS)
	{
		accountStatus = aS;
	}
	
	public void setAccountType(String aT)
	{
		accountType = aT;
	}
	
	public void setAdress(Adress a)
	{
		adress = a;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setIdeas(Set<Idea> ideas) {
		this.ideas = ideas;
	}
	
	public Set<Idea> getIdeas() {
		return ideas;
	}
	
	public void setComments(Set<Comments> comments) {
		this.comments = comments;
	}
	
	public Set<Comments> getComments() {
		return comments;
	}
	
	public void setScores(Set<EvaluationScore> scores) {
		this.scores = scores;
	}
	
	public Set<EvaluationScore> getScores() {
		return scores;
	}
	
	public Set<MakeFund> getFunds() {
		return funds;
	}
	
	public void setFunds(Set<MakeFund> funds) {
		this.funds = funds;
	}
	
	public Set<Thumb> getThumbs() {
		return thumbs;
	}
	
	public void setThumbs(Set<Thumb> thumbs) {
		this.thumbs = thumbs;
	}
	
}
