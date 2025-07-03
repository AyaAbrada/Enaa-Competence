package com.example.enaacompetense;
import com.example.enaacompetense.Entities.Competence;
import com.example.enaacompetense.Repositories.CompetenceRepository;
import com.example.enaacompetense.Services.CompetenceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EnaaCompetenseApplicationTests {

        private CompetenceRepository competenceRepository;
        private CompetenceService competenceService;

        @BeforeEach
        void setUp() {
            competenceRepository = Mockito.mock(CompetenceRepository.class);
            competenceService = new CompetenceService(competenceRepository);
        }

        @Test
        void testGetAll_ShouldReturnListOfCompetences() {
            Competence c1 = new Competence();
            c1.setId(1L);
            c1.setNom("Java");

            Competence c2 = new Competence();
            c2.setId(2L);
            c2.setNom("Spring");

            List<Competence> mockList = Arrays.asList(c1, c2);

            when(competenceRepository.findAll()).thenReturn(mockList);

            List<Competence> result = competenceService.getAll();

            assertEquals(2, result.size());
            assertEquals("Java", result.get(0).getNom());
            assertEquals("Spring", result.get(1).getNom());

            verify(competenceRepository, times(1)).findAll();
        }
    }



