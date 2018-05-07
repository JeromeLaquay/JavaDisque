package com.social.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.social.services.ProduitService;
import com.social.services.UserService;
import com.social.util.CustomErrorType;
import com.social.entities.Produit;
import com.social.entities.User;
/** 
 * @author kamal berriga
 *
 */
@RestController
@RequestMapping("produit")
public class ProduitController {

	public static final Logger logger = LoggerFactory.getLogger(ProduitController.class);

	@Autowired
	private ProduitService produitService;

	// request method to create a new account by a guest
	@CrossOrigin
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Produit> getAllProducts() {
		return produitService.findAll();	}

	// this is the login api/service
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Produit getOne(@PathVariable("id") Long id) {
		return produitService.find(id);	}
	
}
