package com.ZooArcadia.ZooArcadia.Controller;

import com.ZooArcadia.ZooArcadia.Entity.Animal;
import com.ZooArcadia.ZooArcadia.Repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animaux")
public class AnimalController {

    @Autowired
    private AnimalRepository  animalRepository;

    // Expose l'API pour obtenir tous les animaux
    @GetMapping
    public List<Animal> getAllAnimaux() {
        return animalRepository.findAll();
    }

    // Endpoint pour récupérer un animal par ID
    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal non trouvé !"));
    }

    // Endpoint pour ajouter un nouvel animal
    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }

    // Endpoint pour mettre à jour un animal
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Long id, @RequestBody Animal updatedAnimal) {
        return animalRepository.findById(id).map(animal -> {
            animal.setName(updatedAnimal.getName());
            animal.setRace(updatedAnimal.getRace());
            return animalRepository.save(animal);
        }).orElseThrow(() -> new RuntimeException("Animal non trouvé pour mise à jour !"));
    }

    // Endpoint pour supprimer un animal
    @DeleteMapping("/{id}")
    public String deleteAnimal(@PathVariable Long id) {
        animalRepository.deleteById(id);
        return "Animal supprimé avec succès !";
    }

    @GetMapping("/test")
    public String test() {
        return "L'API fonctionne !";
    }

}
