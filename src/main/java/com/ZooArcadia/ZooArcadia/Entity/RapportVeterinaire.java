package com.ZooArcadia.ZooArcadia.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class RapportVeterinaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rapportVeterinaireId;
    private Date date;
    private String detail;

    public RapportVeterinaire() {}

    public RapportVeterinaire(Date date, String detail) {
        this.date = date;
        this.detail = detail;
    }


    public Long getRapportVeterinaireId() {
        return rapportVeterinaireId;
    }

    public void setRapportVeterinaireId(Long rapportVeterinaireId) {
        this.rapportVeterinaireId = rapportVeterinaireId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
