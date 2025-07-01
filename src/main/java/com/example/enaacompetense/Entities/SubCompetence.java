package com.example.enaacompetense.Entities;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SubCompetence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToOne
    @JoinColumn(name = "competence_id")
    private Competence competence;

    @OneToMany(mappedBy = "subCompetence", cascade = CascadeType.ALL)
    private List<Evaluation> evaluations = new ArrayList<>();

    public SubCompetence() {}

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

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }
}
