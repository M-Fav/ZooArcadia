package com.ZooArcadia.ZooArcadia.Repository;

import com.ZooArcadia.ZooArcadia.Entity.Habitat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitatRepository extends JpaRepository<Habitat, Long> {
}
