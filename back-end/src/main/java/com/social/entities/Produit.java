package com.social.entities;


/*******************************************************************************
 * 2017, this is the user entity class ,
 * this class implements users details of the spring security framework
 *******************************************************************************/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
/**
 * Description of User.
 * 
 * @author kamal berriga
 */
@Entity
@Table(name="Produit")
@Scope("session")
public  class Produit{
	
	@Id
	  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUIT_SEQ")
	  @SequenceGenerator(sequenceName = "produit_seq", initialValue = 1, allocationSize = 1, name = "PRODUIT_SEQ")
	private Long id ;
	@Column(unique = true)
	private String title ;
	private String image_url ;
    private Date  annee_sortie;
    private String genre;
    private String description;
    private Double prix;
    private String auteur;

    public Produit(){
    	
    }

	public Produit(String title, String image_url, Date annee_sortie, String genre, String description,
			Double prix, String auteur) {
		super();
		this.title = title;
		this.image_url = image_url;
		this.annee_sortie = annee_sortie;
		this.genre = genre;
		this.description = description;
		this.prix = prix;
		this.auteur = auteur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public Date getAnnee_sortie() {
		return annee_sortie;
	}

	public void setAnnee_sortie(Date annee_sortie) {
		this.annee_sortie = annee_sortie;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
}
