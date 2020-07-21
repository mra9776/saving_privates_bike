package com.github.mra9776.saving_privates_bike.runner;

import com.github.mra9776.saving_privates_bike.model.Cases;
import com.github.mra9776.saving_privates_bike.model.helper.CaseStatus;
import com.github.mra9776.saving_privates_bike.repository.CasesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CasesRepositoryCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CasesRepository casesRepository;

	@Override
	public void run(String... arg0) {
		Cases case1 = new Cases();
		case1.setCaseStatus(CaseStatus.PENDING);
		casesRepository.save(case1);
		
		Cases case2 = new Cases();
		case2.setCaseStatus(CaseStatus.PENDING);
		casesRepository.save(case2);
		
		Cases case3 = new Cases();
		case3.setCaseStatus(CaseStatus.PENDING);
		casesRepository.save(case3);
		
	}
}
