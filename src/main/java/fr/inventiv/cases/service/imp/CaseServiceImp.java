package fr.inventiv.cases.service.imp;

import fr.inventiv.cases.exceptions.CaseNotFoundException;
import fr.inventiv.cases.model.Case;
import fr.inventiv.cases.repository.CaseRepository;
import fr.inventiv.cases.service.CaseService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CaseServiceImp implements CaseService {

    @Autowired
    private CaseRepository caseRepository;

    @Override
    public Case getCaseById(Long id) throws CaseNotFoundException {
       return caseRepository.findById(id)
                .orElseThrow(()->new CaseNotFoundException("Invalid Case Id"));    }

    @Override
    public Case saveCase(Case newCase) {
        newCase.setCreationDate(LocalDateTime.now());
        newCase.setLastUpdateDate(LocalDateTime.now());
        return caseRepository.save(newCase);
    }

    @Override
    public void deleteCase(Long id) throws CaseNotFoundException {
        caseRepository.findById(id).orElseThrow(()-> new CaseNotFoundException("Invalid Case id"));
        caseRepository.deleteById(id);
    }

    @Override
    public Case updateCase(Long id, Case c) throws CaseNotFoundException {
        return caseRepository.findById(id)
                .map(c1 -> {
                    c1.setTitle(c.getTitle());
                    c1.setDescription(c.getDescription());
                    c1.setLastUpdateDate(LocalDateTime.now());
                    return caseRepository.save(c1);
                })
                .orElseThrow(()-> new CaseNotFoundException("Invalid Case id"));
    }
}
