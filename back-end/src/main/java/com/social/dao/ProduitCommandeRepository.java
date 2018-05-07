package com.social.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.social.entities.ProduitCommande;
/** 
 * @author kamal berriga
 *
 */
/* this the user  Repository interface  */ 
@Repository
public interface ProduitCommandeRepository extends JpaRepository<ProduitCommande, Long> {

public List<ProduitCommande> findAll();

}
