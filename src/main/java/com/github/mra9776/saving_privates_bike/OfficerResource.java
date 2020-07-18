package com.github.mra9776.saving_privates_bike;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfficerResource {
	
	@Autowired
	OfficersRepository officerRepository;
	@Autowired
	CasesRepository casesRepository;
	
	@Autowired
	private Matcher matcher;
	
	@GetMapping("/officers/{officer_id}")
	public Officers retrieveOfficers(@PathVariable UUID officer_id){
		Optional<Officers> findByIdResult = officerRepository.findByOfficerId(officer_id);
		if (findByIdResult.isEmpty())
			throw new OfficerNotFoundException("officer_id = " + officer_id);
		return findByIdResult.get();
	}

	@GetMapping("/officers/")
	public List<Officers> retrieveOfficers(@RequestParam() Optional<OfficerStatus> state ){
		//TODO: handle exception and validation.
		if (state.isEmpty()) {
			return officerRepository.findAll();
		} else {
			return officerRepository.findByOfficerStatus(state.get());
		}
	}
	
	@DeleteMapping("/officers/{officer_id}")
	public void deleteOfficers(@PathVariable UUID officer_id) {
		//TODO: NOT FOUND EXCEPTION 
		officerRepository.deleteByOfficerId(officer_id);
	}
	
	@PatchMapping("/officers/{officer_id}")
	public Officers jobDoneOfficers(@PathVariable UUID officer_id) {
		// Find that worker;
		Optional<Officers> findByIdResult = officerRepository.findByOfficerId(officer_id);
		if (findByIdResult.isEmpty())
			throw new OfficerNotFoundException("Id = " + officer_id);
		Officers officers= findByIdResult.get();
		// let the bird fly;
		officers.setOfficerStatus(OfficerStatus.FREE);
		officerRepository.save(officers);
		
		if (officers.getCase_id()!=null) {
			// set case status as done;
			Optional<Cases> findByIdCaseResult = casesRepository.findByCaseId(officers.getCase_id());
			if (findByIdCaseResult.isEmpty())
				throw new CaseNotFoundException("Id = " + officers.getCase_id());
			Cases cases = findByIdCaseResult.get();
			cases.setCaseStatus(CaseStatus.DONE);
			casesRepository.save(cases);
		}
		// assign next one;
		matcher.assign();
		
		return officers;
	}
}
