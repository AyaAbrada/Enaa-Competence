package com.example.enaacompetense.Repositories;
import com.example.enaacompetense.Entities.SubCompetence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCompetenceRepository extends JpaRepository<SubCompetence, Long> {
    List<SubCompetence> findByCompetenceId(Long competenceId);
}

