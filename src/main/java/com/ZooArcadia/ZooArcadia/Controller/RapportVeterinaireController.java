package com.ZooArcadia.ZooArcadia.Controller;

import com.ZooArcadia.ZooArcadia.Entity.Habitat;
import com.ZooArcadia.ZooArcadia.Entity.RapportVeterinaire;
import com.ZooArcadia.ZooArcadia.Repository.RapportVeterinaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rapportsVeterinaire")
public class RapportVeterinaireController {

    @Autowired
    private RapportVeterinaireRepository rapportVeterinaireRepository;

    @GetMapping
    public List<RapportVeterinaire> getAllRapportVeterinaire() {
        return  rapportVeterinaireRepository.findAll();
    }

    @GetMapping("/{rapportVeterinaireId}")
    public RapportVeterinaire getRapportVeterinaireById(@RequestBody Long rapportVeterinaireId) {
        return rapportVeterinaireRepository.findById(rapportVeterinaireId).orElseThrow(() -> new RuntimeException("Rapport vétérinaire non trouvé !"));
    }

    @PostMapping
    public RapportVeterinaire createRapportVeterinaire(@RequestBody RapportVeterinaire rapportVeterinaire) {
        return rapportVeterinaireRepository.save(rapportVeterinaire);
    }

    @PutMapping("/{rapportVeterinaireId}")
    public RapportVeterinaire updateRapportVeterinaire(@PathVariable Long rapportVeterinaireId, @RequestBody RapportVeterinaire updatedRapportVeterinaire) {
        return rapportVeterinaireRepository.findById(rapportVeterinaireId).map(rapportVeterinaire -> {
            rapportVeterinaire.setDate(updatedRapportVeterinaire.getDate());
            rapportVeterinaire.setDetail(updatedRapportVeterinaire.getDetail());
            return rapportVeterinaireRepository.save(rapportVeterinaire);
        }).orElseThrow(() -> new RuntimeException("Rapport vétérinaire non trouvé pour mise à jour !"));
    }

    @DeleteMapping("/{rapportVeterinaireId}")
    public String deleteRapportVeterinaire(@PathVariable Long rapportVeterinaireId) {
        rapportVeterinaireRepository.deleteById(rapportVeterinaireId);
        return "Rapport vétérinaire supprimé avec succès !";
    }

    @GetMapping("/test")
    public String test() {
        return "l'accès Rapports vétérinaire fonctionne !";
    }
}
