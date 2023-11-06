package fr.inventiv.cases.repository;

import fr.inventiv.cases.model.Case;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepository extends CrudRepository<Case, Long> {
}
