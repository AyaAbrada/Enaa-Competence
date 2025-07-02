package com.example.enaacompetense.Controllers;
import com.example.enaacompetense.Entities.Competence;
import com.example.enaacompetense.Entities.SubCompetence;
import com.example.enaacompetense.Services.SubCompetenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sous-competences")
public class SubCompetenceController {
    private final SubCompetenceService subCompetenceService;

    public SubCompetenceController(SubCompetenceService subCompetenceService) {
        this.subCompetenceService = subCompetenceService;
    }

    @GetMapping
    public List<SubCompetence> getAll(){
        return subCompetenceService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<SubCompetence> getById(@PathVariable Long id) {
        return subCompetenceService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/competence/{competenceId}")
    public List<SubCompetence> getByCompetence(@PathVariable Long competenceId) {
        return subCompetenceService.getByCompetenceId(competenceId);
    }

    @PostMapping
    public SubCompetence create(@RequestBody SubCompetence subCompetence){
        return subCompetenceService.save(subCompetence);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        subCompetenceService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubCompetence> update(@PathVariable Long id, @RequestBody SubCompetence updated) {
        return subCompetenceService.getById(id).map(existing -> {
            existing.setNom(updated.getNom());
            existing.setValidee(updated.isValidee());
            existing.setCompetence(updated.getCompetence());
            return ResponseEntity.ok(subCompetenceService.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }
}

