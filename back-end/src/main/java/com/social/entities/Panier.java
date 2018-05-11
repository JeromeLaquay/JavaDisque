package com.social.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name="Panier")
@Scope("session")
public  class Panier{
	
//	@Id
//	  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PANIER_SEQ")
//	  @SequenceGenerator(sequenceName = "panier_seq", initialValue = 1, allocationSize = 1, name = "PANIER_SEQ")
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id ;
    private Double prixTotal;
    
    @JsonIgnore
    @OneToMany(mappedBy="panier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProduitCommande> produitsCommandes;
    
    @OneToOne
    private User user;

    public Panier(){
    	
    }

	public Panier(Long id, Double prixTotal, List<ProduitCommande> produitsCommandes, User user) {
		super();
		this.id = id;
		this.prixTotal = prixTotal;
		this.produitsCommandes = produitsCommandes;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(Double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public List<ProduitCommande> getProduitsCommandes() {
		return produitsCommandes;
	}

	public void setProduitsCommandes(List<ProduitCommande> produitsCommandes) {
		this.produitsCommandes = produitsCommandes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}
