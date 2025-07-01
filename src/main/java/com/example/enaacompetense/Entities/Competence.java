package com.example.enaacompetense.Entities;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "competence", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubCompetence> sousCompetences = new ArrayList<>();

    public Competence() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<SubCompetence> getSousCompetences() {
        return sousCompetences;
    }

    public void setSousCompetences(List<SubCompetence> sousCompetences) {
        this.sousCompetences = sousCompetences;
    }
}
