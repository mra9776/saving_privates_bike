package com.github.mra9776.saving_privates_bike;

import java.util.List;
import java.util.Optional;

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
	
	@GetMapping("/officers/{officer_id}")
	public Officers retrieveOfficers(@PathVariable Integer officer_id){
		Optional<Officers> findByIdResult = officerRepository.findById(officer_id);
		if (findByIdResult.isEmpty())
			throw new OfficerNotFoundException("officer_id = " + officer_id);
		return findByIdResult.get();
	}

	@GetMapping("/officers/")
	public List<Officers> retrieveOfficers(@RequestParam() Optional<OfficerStatus> state ){
		//TODO: handle exception.
		if (state.isEmpty()) {
			return officerRepository.findAll();
		} else {
			return officerRepository.findByOfficerStatus(state.get());
		}
	}
	
	@DeleteMapping("/officers/{officer_id}")
	public void deleteOfficers(@PathVariable Integer officer_id) {
		officerRepository.deleteById(officer_id);
	}
	
	@PatchMapping("/officers/{officer_id}")
	public Officers jobDoneOfficers(@PathVariable Integer officer_id) {
		throw new RuntimeException();
	}
	
	
}
