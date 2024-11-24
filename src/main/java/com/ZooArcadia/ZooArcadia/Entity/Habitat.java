package com.ZooArcadia.ZooArcadia.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Habitat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long habitatId;
    private String name;
    private String commentaireHabitat;

    public Habitat() {}

    public Habitat(String name, String commentaireHabitat) {
        this.name = name;
        this.commentaireHabitat = commentaireHabitat;
    }

    public long getHabitatId() {
        return habitatId;
    }

    public void setHabitatId(long habitatId) {
        this.habitatId = habitatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommentaireHabitat() {
        return commentaireHabitat;
    }

    public void setCommentaireHabitat(String commentaireHabitat) {
        this.commentaireHabitat = commentaireHabitat;
    }
}
