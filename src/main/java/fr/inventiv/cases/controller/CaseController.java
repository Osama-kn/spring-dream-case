package fr.inventiv.cases.controller;


import fr.inventiv.cases.exceptions.CaseNotFoundException;
import fr.inventiv.cases.model.Case;
import fr.inventiv.cases.service.imp.CaseServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cases")
@AllArgsConstructor
public class CaseController {

    private CaseServiceImp caseService;

    @GetMapping("/{id}")
    public ResponseEntity<Case> findCaseById(@PathVariable Long id) throws CaseNotFoundException {
        return new ResponseEntity<>(caseService.getCaseById(id), HttpStatus.OK);
    };

    @PostMapping()
    public ResponseEntity<Case> createCase(@Validated @RequestBody Case newCase) {
        // Code to create a new case
        return new ResponseEntity<>(caseService.saveCase(newCase), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Case> updateCase(@PathVariable Long id,@Validated @RequestBody Case c) throws CaseNotFoundException {
        return new ResponseEntity<>(caseService.updateCase(id, c), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public boolean deleteCase(@PathVariable Long id) throws CaseNotFoundException{
        caseService.deleteCase(id);
        return true;
    }
}
