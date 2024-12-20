package com.ZooArcadia.ZooArcadia.Controller;

import com.ZooArcadia.ZooArcadia.Entity.Habitat;
import com.ZooArcadia.ZooArcadia.Repository.HabitatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitats")
public class HabitatController {

    @Autowired
    private HabitatRepository habitatRepository;

    @GetMapping
    public List<Habitat> getAllHabitats() {

        return habitatRepository.findAll();
    }

    @GetMapping("/{habitatId}")
    public Habitat getHabitatById(@PathVariable Long habitatId) {
        return habitatRepository.findById(habitatId).orElseThrow(() -> new RuntimeException("Habitat non trouvé !"));
    }

    @PostMapping
    public Habitat createHabitat(@RequestBody Habitat habitat) {
        return habitatRepository.save(habitat);
    }


    @PutMapping("/{habitatId}")
    public Habitat updateHabitat(@PathVariable Long habitatId, @RequestBody Habitat updatedHabitat) {
        return habitatRepository.findById(habitatId).map(habitat -> {
            habitat.setName(updatedHabitat.getName());
            habitat.setCommentaireHabitat(updatedHabitat.getCommentaireHabitat());
            return habitatRepository.save(habitat);
        }).orElseThrow(() -> new RuntimeException("Habitat non trouvé pour mise à jour !"));
    }

    @DeleteMapping("/{habitatId}")
    public String deleteHabitat(@PathVariable Long habitatId) {
        habitatRepository.deleteById(habitatId);
        return "Habitat supprimé avec succès !";
    }

    @GetMapping("/test")
    public String test() {
        return "l'accès Habitats fonctionne !";
    }

}
