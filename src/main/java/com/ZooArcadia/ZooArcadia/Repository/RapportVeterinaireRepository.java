package com.ZooArcadia.ZooArcadia.Repository;

import com.ZooArcadia.ZooArcadia.Entity.RapportVeterinaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RapportVeterinaireRepository extends JpaRepository<RapportVeterinaire, Long> {
}
