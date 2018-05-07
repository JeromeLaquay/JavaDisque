package com.social.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.social.entities.Produit;
import com.social.entities.User;
/** 
 * @author kamal berriga
 *
 */
/* this the user  Repository interface  */ 
@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

public List<Produit> findAll();
}
