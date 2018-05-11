package com.social.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.dao.ProduitCommandeRepository;
import com.social.entities.ProduitCommande;
/** 
 * @author kamal berriga
 *
 */
@Service
public class ProduitCommandeService {

	@Autowired
	ProduitCommandeRepository produitCommandeRepository;

	public ProduitCommande save(ProduitCommande produit) {
		return produitCommandeRepository.saveAndFlush(produit);
	}

	public ProduitCommande update(ProduitCommande produit) {
		return produitCommandeRepository.save(produit);
	}
	
	public void delete(ProduitCommande produitCommande) {
		System.out.println("entree dans le service");
		produitCommandeRepository.delete(produitCommande);
	}

	public void delete(Long id) {
		System.out.println("entree dans le service");
		produitCommandeRepository.delete(id);
	}
	
	public void delete(List<ProduitCommande> produits) {
		System.out.println("entree dans le service");
		produitCommandeRepository.delete(produits);
	}

	public ProduitCommande find(Long id) {
		return produitCommandeRepository.findOne(id);
	}
	
	public List<ProduitCommande> findAll() {
		return produitCommandeRepository.findAll();
	}
	
	public List<ProduitCommande> findByUserId(Long id) {
		return produitCommandeRepository.findByUserId(id);
	}
	
}
