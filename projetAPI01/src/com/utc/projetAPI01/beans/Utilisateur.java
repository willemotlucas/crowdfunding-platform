package com.utc.projetAPI01.beans;

import java.sql.Date;

public class Utilisateur {
	private Integer		id;
	private String		email;
	private String		nom;
	private String		prenom;
	private String		telephone;
	private Date		dateCreation;
	private String		accountStatus;
	private String		accountType;
	private Adress		adress;
	
	public Utilisateur(String e, String n, String p, String t, Date d, String aS, String aT, Adress add)
	{
		this.email = e;
		this.nom = n;
		this.prenom = p;
		this.telephone = t;
		this.dateCreation = d;
		this.accountStatus = aS;
		this.accountType = aT;
		this.adress = add;
	}
	
	public Utilisateur()
	{
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

}
