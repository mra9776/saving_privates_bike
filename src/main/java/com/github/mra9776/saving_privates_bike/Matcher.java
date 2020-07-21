package com.github.mra9776.saving_privates_bike;

import java.util.Date;
import java.util.List;

import com.github.mra9776.saving_privates_bike.data.Cases;
import com.github.mra9776.saving_privates_bike.data.Officers;
import com.github.mra9776.saving_privates_bike.data.helper.CaseStatus;
import com.github.mra9776.saving_privates_bike.data.helper.OfficerStatus;
import com.github.mra9776.saving_privates_bike.repository.CasesRepository;
import com.github.mra9776.saving_privates_bike.repository.OfficersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Matcher {
	@Autowired
	OfficersRepository officersRepository;
	@Autowired
	CasesRepository casesRepository;
	
	public Matcher(OfficersRepository officersRepository, CasesRepository casesRepository) {
		super();
		this.officersRepository = officersRepository;
		this.casesRepository = casesRepository;
		assign();
	}

	public void assign() {
		// TODO: Do some Atomic, Locky thing
		// TODO: JUST LOCK ONE ROW NOT ANY MORE
		
		// check if job available
		List <Cases> availableCases = casesRepository.findByCaseStatus(CaseStatus.PENDING);
		if (availableCases.size() > 0) {
			
			// check if officer available
			List <Officers> availableOfficers = officersRepository.findByOfficerStatusOrderByLastCase(OfficerStatus.FREE);
			if (availableOfficers.size() > 0) {
				
				// reserve officer
				Officers officer = availableOfficers.get(0);
				officer.setOfficerStatus(OfficerStatus.BUSY);
				officer.setLastCase(new Date());
				
				// assign job to officer
				Cases cases = availableCases.get(0);
				officer.setCase_id(cases.getCaseId());
				cases.setOfficer_id(officer.getOfficerId());
				cases.setCaseStatus(CaseStatus.WORKING);
				
				officersRepository.save(officer);
				casesRepository.save(cases);
				
				// Let's make Other Officers busy.
				// but there's a problem 
				// the way I'm gonna handle this problem
				// - Is kindda make a chain of calles till one of our resources finishes, and might create 
				//   some over head. but It's one of simplest solutions.
				// - The other problem is checking a known variable (count of available resource) I could solve it 
				//   Using an Atomic variable, although this can save us some processing time, 
				//	 but I have faith on cache of Database to optimize out these extra queries, 
				//	 And of course concurrency might be a pain in the ash too.
				
				if (0 < Math.min(availableCases.size() -1 , availableOfficers.size() -1 )){
					assign();
				}
			}
		}
	}
	
}
