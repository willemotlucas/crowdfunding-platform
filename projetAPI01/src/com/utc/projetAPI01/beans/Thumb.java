package com.utc.projetAPI01.beans;

public class Thumb {
	
	private Integer			id;
	private Integer			score;
	private Utilisateur		utilisateur;
	private Discussion		discussion;
	
	public Thumb()
	{
	}

	public Thumb(Integer score, Utilisateur utilisateur, Discussion discussion)
	{
		this.score = score;
		this.utilisateur = utilisateur;
		this.discussion = discussion;
	}
	
	public Discussion getDiscussion() {
		return discussion;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public void setDiscussion(Discussion discussion) {
		this.discussion = discussion;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}
