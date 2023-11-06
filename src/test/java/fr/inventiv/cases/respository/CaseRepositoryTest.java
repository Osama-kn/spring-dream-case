package fr.inventiv.cases.respository;

import fr.inventiv.cases.exceptions.CaseNotFoundException;
import fr.inventiv.cases.model.Case;
import fr.inventiv.cases.repository.CaseRepository;
import fr.inventiv.cases.service.CaseService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class CaseRepositoryTest {

    @Autowired
    private CaseRepository caseRepository;

    @MockBean
    CaseRepository mockCaseRepository;


    @BeforeEach
    public void setUp() throws CaseNotFoundException {
        Case mockCase = new Case();
        mockCase.setCaseId(1L);
        mockCase.setTitle("Test Case");
        mockCase.setDescription("Test Description");
        mockCase.setCreationDate(LocalDateTime.now());
        mockCase.setLastUpdateDate(LocalDateTime.now());

        Mockito.when(mockCaseRepository.findById(1L)).thenReturn(Optional.of(mockCase));
        Mockito.when(mockCaseRepository.save(Mockito.any(Case.class))).thenReturn(mockCase);

    }

    @Test
    public void testSaveCase() {
        Case newCase = new Case();
        newCase.setCaseId(1L);
        newCase.setTitle("Test Case");
        newCase.setDescription("Test Description");

        Case savedCase = caseRepository.save(newCase);

        assertNotNull(savedCase);
        assertEquals("Test Case", savedCase.getTitle());
        assertEquals("Test Description", savedCase.getDescription());
    }

    @Test
    public void testGetCaseById() throws CaseNotFoundException {
        Long caseId = 1L;
        Case foundCase = caseRepository.findById(1L).orElse(null);

        assertNotNull(foundCase);
        assertEquals(caseId, foundCase.getCaseId());
        assertEquals("Test Case", foundCase.getTitle());
        assertEquals("Test Description", foundCase.getDescription());
    }

}
