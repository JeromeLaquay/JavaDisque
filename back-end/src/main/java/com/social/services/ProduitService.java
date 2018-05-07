package com.social.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.dao.ProduitRepository;
import com.social.dao.UserRepository;
import com.social.entities.Produit;
import com.social.entities.User;
/** 
 * @author kamal berriga
 *
 */
@Service
public class ProduitService {

	@Autowired
	ProduitRepository produitRepository;

	public Produit save(Produit produit) {
		return produitRepository.saveAndFlush(produit);
	}

	public Produit update(Produit produit) {
		return produitRepository.save(produit);
	}

	public Produit find(Long id) {
		return produitRepository.findOne(id);
	}
	
	public List<Produit> findAll() {
		return produitRepository.findAll();
	}
}
