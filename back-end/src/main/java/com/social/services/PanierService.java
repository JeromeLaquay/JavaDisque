package com.social.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.dao.PanierRepository;
import com.social.dao.ProduitRepository;
import com.social.dao.UserRepository;
import com.social.entities.Panier;
import com.social.entities.Produit;
import com.social.entities.User;
/** 
 * @author kamal berriga
 *
 */
@Service
public class PanierService {

	@Autowired
	PanierRepository panierRepository;

	public Panier save(Panier panier) {
		return panierRepository.saveAndFlush(panier);
	}

	public Panier update(Panier panier) {
		return panierRepository.save(panier);
	}

	public Panier find(Long id) {
		return panierRepository.findOne(id);
	}
	
	public List<Panier> findAll() {
		return panierRepository.findAll();
	}
}
