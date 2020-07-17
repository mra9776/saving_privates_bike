package com.github.mra9776.saving_privates_bike;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CasesRepository extends JpaRepository<Cases, Integer> {
	List <Cases> findByCaseStatus(CaseStatus caseStatus);

	Optional<Cases> findByCaseId(UUID case_id);
	void deleteByCaseId(UUID case_id);
}
