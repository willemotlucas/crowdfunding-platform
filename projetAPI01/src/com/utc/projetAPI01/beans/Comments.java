package com.utc.projetAPI01.beans;

import java.util.Date;

public class Comments {
	private Integer			id;
	private String			description;
	private Date			commentDate;
	private Utilisateur		utilisateur;
	private	Idea			idea;
	
	public Comments()
	{
	}
	
	public Comments(String d, Date c, Utilisateur u, Idea idea)
	{
		this.description = d;
		this.commentDate = c;
		this.utilisateur = u;
		this.idea = idea;
	}
	
	public Date getCommentDate() {
		return commentDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Idea getIdea() {
		return idea;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setIdea(Idea idea) {
		this.idea = idea;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}
