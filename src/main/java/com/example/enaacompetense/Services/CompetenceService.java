package com.example.enaacompetense.Services;
import com.example.enaacompetense.Entities.Competence;
import com.example.enaacompetense.Repositories.CompetenceRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CompetenceService {
    private final CompetenceRepository competenceRepository;

    public CompetenceService(CompetenceRepository competenceRepository) {
        this.competenceRepository = competenceRepository;
    }
    public List<Competence> getAll(){
        return competenceRepository.findAll();
    }
    public Competence save(Competence competence){
        return competenceRepository.save(competence);
    }
    public void delete(Long id){
        competenceRepository.findById(id);
    }
    public Optional<Competence> getById(Long id) {
        return competenceRepository.findById(id);
    }
}
