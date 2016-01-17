package com.utc.projetAPI01.beans;

import java.util.HashSet;
import java.util.Set;

public class Adress {
	private Integer		id;
	private Integer		num;
	private String		rue;
	private String		codePostale;
	private String		ville;
	private Set<Utilisateur>	utilisateurs = new HashSet<Utilisateur>();
	
	public Adress(Integer n, String r, String cp, String v)
	{
		this.num = n;
		this.rue = r;
		this.codePostale = cp;
		this.ville = v;
	}
	
	public Adress()
	{	
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer i)
	{
		id = i;
	}
	
	public Integer getNum()
	{
		return num;
	}
	
	public void setNum(Integer n)
	{
		num = n;
	}
	
	public String getRue()
	{
		return rue;
	}
	
	public void setRue(String r)
	{
		rue = r;
	}
	
	public String getCodePostale()
	{
		return codePostale;
	}
	
	public void setCodePostale(String cp)
	{
		codePostale = cp;
	}
	
	public String getVille()
	{
		return ville;
	}
	
	public void setVille(String v)
	{
		ville = v;
	}
	
	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	
	public Set<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

}
