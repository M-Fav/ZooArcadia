package com.ZooArcadia.ZooArcadia.Repository;

import com.ZooArcadia.ZooArcadia.Entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
