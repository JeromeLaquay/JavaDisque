package com.social.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name="ProduitCommande")
@Scope("session")
public  class ProduitCommande{
	
	@Id
	  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUIT_COMMANDE_SEQ")
	  @SequenceGenerator(sequenceName = "produit_commande_seq", initialValue = 1, allocationSize = 1, name = "PRODUIT_COMMANDE_SEQ")
	private Long id ;
	
	@ManyToOne
	private Produit produit ;
	
	@ManyToOne
	private Panier panier ;
	
    private int quantite;

    public ProduitCommande(){
    	
    }

	public ProduitCommande(Long id, Produit produit, Panier panier, int quantite) {
		super();
		this.id = id;
		this.produit = produit;
		this.panier = panier;
		this.quantite = quantite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
}
