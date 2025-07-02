package com.example.enaacompetense.Services;
import com.example.enaacompetense.Entities.SubCompetence;
import com.example.enaacompetense.Repositories.SubCompetenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SubCompetenceService {
    private final SubCompetenceRepository subCompetenceRepository;

    public SubCompetenceService(SubCompetenceRepository subCompetenceRepository) {
        this.subCompetenceRepository = subCompetenceRepository;
    }

    public List<SubCompetence> getAll(){
        return subCompetenceRepository.findAll();
    }

    public Optional<SubCompetence> getById(Long id) {
        return subCompetenceRepository.findById(id);
    }

    public List<SubCompetence> getByCompetenceId(Long competenceId){
        return subCompetenceRepository.findByCompetenceId(competenceId);
    }
    public SubCompetence save(SubCompetence subCompetence){
        return subCompetenceRepository.save(subCompetence);
    }
    public void delete(Long id){
        subCompetenceRepository.deleteById(id);
    }
}
