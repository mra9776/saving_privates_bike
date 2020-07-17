package com.github.mra9776.saving_privates_bike;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaseResource {
	
	@Autowired
	//private CasesService caseService;
	
	@GetMapping("/cases/")
	public List<Cases> retrieveAllCases(){
		return null;
	}
	@GetMapping("/cases/{state}")
	public List<Cases> retrieveCasesFiltered(@PathVariable String state){
		throw new RuntimeException();
	}
	@PostMapping("/cases/")
	public List<Cases> newCases(){
		throw new RuntimeException();
	}
	@DeleteMapping("/cases/{case_id}")
	public List<Cases> deleteCases(@PathVariable Integer case_id){
		throw new RuntimeException();
	}
}
