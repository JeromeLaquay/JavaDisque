package com.social.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.social.entities.Panier;
/** 
 * @author kamal berriga
 *
 */
/* this the user  Repository interface  */ 
@Repository
public interface PanierRepository extends JpaRepository<Panier, Long> {

public List<Panier> findAll();
}
