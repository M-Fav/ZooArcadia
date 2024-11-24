package com.ZooArcadia.ZooArcadia.Repository;

import com.ZooArcadia.ZooArcadia.Entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
