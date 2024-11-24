package com.ZooArcadia.ZooArcadia.Controller;

import com.ZooArcadia.ZooArcadia.Entity.Utilisateur;
import com.ZooArcadia.ZooArcadia.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @GetMapping("/{userName}")
    public Utilisateur getUtilisateurById(@PathVariable Long utilisateurId) {
        return utilisateurRepository.findById(utilisateurId).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé !"));
    }

    @PostMapping
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @PutMapping("/{userName}")
    public Utilisateur updateUtilisateur(@PathVariable Long userName, @RequestBody Utilisateur updateUtilisateur) {
        return utilisateurRepository.findById(userName).map(utilisateur -> {
            utilisateur.setPassword(updateUtilisateur.getPassword());
            utilisateur.setName(updateUtilisateur.getName());
            utilisateur.setFirstName(updateUtilisateur.getFirstName());
            return utilisateurRepository.save(utilisateur);
        }).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé pour mise à jour !"));
    }

    @DeleteMapping("/{userName}")
    public String deleteUtilisateur(@PathVariable Long userName) {
        utilisateurRepository.deleteById(userName);
        return "Utilisateur supprimé avec succès !";
    }

    @GetMapping("/test")
    public String test() {
        return "l'accès Utilisateurs fonctionne !";
    }
}
