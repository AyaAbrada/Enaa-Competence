package com.example.enaacompetense.Controllers;
import com.example.enaacompetense.Entities.Competence;
import com.example.enaacompetense.Services.CompetenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/competences")
public class CompetenceController {
    private final CompetenceService competenceService;

    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }
    @GetMapping
    public List<Competence> getAll(){
        return competenceService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Competence> getById(@PathVariable Long id) {
        return competenceService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Competence create(@RequestBody Competence competence){
        return competenceService.save(competence);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competence> update(@PathVariable Long id, @RequestBody Competence updated) {
        return competenceService.getById(id).map(existing -> {
            existing.setNom(updated.getNom());
            existing.setSousCompetences(updated.getSousCompetences());
            return ResponseEntity.ok(competenceService.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        competenceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


