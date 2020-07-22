package com.github.mra9776.saving_privates_bike.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.github.mra9776.saving_privates_bike.model.Cases;
import com.github.mra9776.saving_privates_bike.model.helper.CaseStatus;
import com.github.mra9776.saving_privates_bike.repository.CasesRepository;
import com.github.mra9776.saving_privates_bike.repository.CasesRepositoryInMem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CasesService {
	@Autowired
	CasesRepository casesRepository;

	@Autowired
	CasesRepositoryInMem casesRepositoryInMem;
	public List <Cases> findByCaseStatus(CaseStatus caseStatus){
		return casesRepository.findByCaseStatus(caseStatus);
	}

	public Optional<Cases> findByCaseId(UUID caseId){
		Cases casesInMem = casesRepositoryInMem.find(caseId);
		
		if (casesInMem == null){

			Optional<Cases> res = casesRepository.findByCaseId(caseId);
			if (res.isPresent()){
				casesRepositoryInMem.store(caseId, res.get());
			}
			return res;
		}
		return Optional.of(casesInMem );
	}

	public void deleteByCaseId(UUID case_id){
		casesRepository.deleteByCaseId(case_id);
	}

	public List<Cases> findAll(){
		return casesRepository.findAll();
	}

	public Cases save(Cases cases){
		return casesRepository.save(cases);
	}

}
