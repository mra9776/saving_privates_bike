package com.github.mra9776.saving_privates_bike;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaseResource {
	
	@Autowired
	private CasesRepository caseRepository;

	@GetMapping("/cases/{case_id}")
	public Cases retrieveCasesById(@PathVariable UUID case_id){
		 Optional<Cases> findByIdResult = caseRepository.findByCaseId( case_id);
		 if (!findByIdResult.isPresent()) {
			 throw new CaseNotFoundException("id - " + case_id);
		 }
		 
		 return findByIdResult.get();
	}
	
	@GetMapping("/cases/")
	public List<Cases> retrieveCasesFiltered(@RequestParam  Optional<CaseStatus> state){
		// TODO: Catching transformation Exception.
		
		if(!state.isPresent()) {
			return caseRepository.findAll();
		} else {
			return caseRepository.findByCaseStatus(state.get());
		}
	}
	
	@PostMapping("/cases/")
	public Cases createCases(@RequestBody Cases cases){
		// TODO: validation
		
		cases.setOfficer_id(null);
		Cases saved = caseRepository.save(cases);
		//throw new RuntimeException();
		return saved;
		
	}
	
	@DeleteMapping("/cases/{case_id}")
	public void deleteCases(@PathVariable UUID case_id){
		caseRepository.deleteByCaseId(case_id);
		
	}
}
