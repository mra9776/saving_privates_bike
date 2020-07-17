package com.github.mra9776.saving_privates_bike;

import java.util.List;

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
				officer.setOfficer_status(OfficerStatus.BUSY);
				// assign job to officer
				Cases cases = availableCases.get(0);
				officer.setCase_id(cases.getCase_id());
				cases.setOfficer_id(officer.getOfficer_id());
				cases.setCase_status(CaseStatus.WORKING);
			}
		}
	}
	
}
