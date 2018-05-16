package com.social.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.social.entities.Panier;
import com.social.entities.ProduitCommande;
/* this the user  Repository interface  */ 
@Repository
public interface ProduitCommandeRepository extends JpaRepository<ProduitCommande, Long> {

public List<ProduitCommande> findAll();

@Query("SELECT commande FROM ProduitCommande commande, Panier panier, User user WHERE commande.panier.id=panier.id and panier.user.id=user.id and panier.user.id= :id")
public List<ProduitCommande> findByUserId(@Param("id") Long id);

}
