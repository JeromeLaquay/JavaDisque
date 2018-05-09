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
@RequestMapping("panier")
public class PanierController {

	public static final Logger logger = LoggerFactory.getLogger(PanierController.class);

	@Autowired
	private PanierService panierService;

	// request method to create a new account by a guest
	@CrossOrigin
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Panier> getAllPanier() {
		return panierService.findAll();	}

	// this is the login api/service
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Panier getOne(@PathVariable("id") Long id) {
		return panierService.find(id);	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/save", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public void save(@RequestBody Panier panier) {
		panierService.save(panier);	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT, value = "/update", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public void update(@RequestBody Panier panier) {
		panierService.update(panier);	}
	
	@CrossOrigin
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public Panier getPanierByUser(@PathVariable("id") Long id) {
		return panierService.findByUserId(id);	}
	
}
