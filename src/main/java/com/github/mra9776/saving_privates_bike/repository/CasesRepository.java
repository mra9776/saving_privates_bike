package com.github.mra9776.saving_privates_bike.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.github.mra9776.saving_privates_bike.data.Cases;
import com.github.mra9776.saving_privates_bike.data.helper.CaseStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CasesRepository extends JpaRepository<Cases, Integer> {
	List <Cases> findByCaseStatus(CaseStatus caseStatus);

	Optional<Cases> findByCaseId(UUID case_id);
	void deleteByCaseId(UUID case_id);
}
