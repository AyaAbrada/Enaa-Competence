package com.example.enaacompetense.Entities;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Apprenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String email;

    @OneToMany(mappedBy = "apprenant", cascade = CascadeType.ALL)
    private List<Evaluation> evaluations = new ArrayList<>();

    public Apprenant() {}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }
}
