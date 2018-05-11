package com.social.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * Description of User.
 * 
 * @author kamal berriga
 */
@Entity
@Table(name="Produit")
@Scope("session")
public  class Produit{
	
//	@Id
//	  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUIT_SEQ")
//	  @SequenceGenerator(sequenceName = "produit_seq", initialValue = 1, allocationSize = 1, name = "PRODUIT_SEQ")
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id ;
	@Column(unique = true)
	private String title ;
	private String image_url ;
    private Date  annee_sortie;
    private String genre;
    private String description;
    private Double prix;
    private String auteur;
    
    @JsonIgnore
    @OneToMany(mappedBy="produit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProduitCommande> produitsCommandes;

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
