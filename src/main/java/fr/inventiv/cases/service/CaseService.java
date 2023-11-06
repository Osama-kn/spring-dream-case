package fr.inventiv.cases.service;

import fr.inventiv.cases.exceptions.CaseNotFoundException;
import fr.inventiv.cases.model.Case;

public interface CaseService {

    Case getCaseById(Long id) throws CaseNotFoundException;

    Case saveCase(Case newCase);

    void deleteCase(Long id) throws CaseNotFoundException;

    Case updateCase(Long id, Case updateCase) throws CaseNotFoundException;
}
