package com.social.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.social.services.PanierService;
import com.social.services.ProduitCommandeService;
import com.social.services.ProduitService;
import com.social.services.UserService;
import com.social.util.CustomErrorType;
import com.social.entities.Panier;
import com.social.entities.Produit;
import com.social.entities.ProduitCommande;
import com.social.entities.User;
/** 
 * @author kamal berriga
 *
 */
@RestController
@RequestMapping("produit-commande")
public class ProduitCommandeController {

	public static final Logger logger = LoggerFactory.getLogger(ProduitCommandeController.class);

	@Autowired
	private ProduitCommandeService produitCommandeService;
	
	@Autowired
	private PanierService panierService;

	// request method to create a new account by a guest
	@CrossOrigin
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<ProduitCommande> getAllOrderedProducts() {
		return produitCommandeService.findAll();	}

	// this is the login api/service
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ProduitCommande getOne(@PathVariable("id") Long id) {
		return produitCommandeService.find(id);	}
	
	@CrossOrigin
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE )
	public ResponseEntity<String> deleteOne(@PathVariable("id") Long id) {
		try{
			produitCommandeService.delete(id);
    		return new ResponseEntity<String>( HttpStatus.NO_CONTENT);
    	}catch(Exception e){
    		return new ResponseEntity<String>("can't delete this order", HttpStatus.NOT_FOUND);
    	}	
	}
	
	@CrossOrigin
	@RequestMapping(value = "/delete/panier/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletePanier(@PathVariable("id") Long id) {
		try {
			Panier panier = panierService.find(id);
			produitCommandeService.delete(panier.getProduitsCommandes());
			return new ResponseEntity<String>( HttpStatus.NO_CONTENT);
		}catch(Exception e){
			return new ResponseEntity<String>("can't delete those basket orders", HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/save", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public void save(@RequestBody ProduitCommande produitCommande) {
		produitCommandeService.save(produitCommande);	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/update", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public void update(@RequestBody ProduitCommande produitCommande) {
		produitCommandeService.update(produitCommande);	}
	
}
