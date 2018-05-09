package com.social.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.social.entities.Panier;
@Repository
public interface PanierRepository extends JpaRepository<Panier, Long> {

public List<Panier> findAll();

@Query("SELECT panier FROM Panier panier, User user WHERE panier.user.id=user.id and panier.user.id= :id")
public Panier findByUserId(@Param("id") Long id);
}
