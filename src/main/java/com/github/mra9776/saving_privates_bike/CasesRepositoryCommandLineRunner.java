package com.github.mra9776.saving_privates_bike;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CasesRepositoryCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CasesRepository casesRepository;
	
	@Override
	public void run(String... arg0)  {
		Cases case1 = new Cases(1, CaseStatus.PENDING, 0);
		casesRepository.save(case1);
		Cases case2 = new Cases(2, CaseStatus.PENDING, 0);
		casesRepository.save(case2);
		Cases case3 = new Cases(3, CaseStatus.PENDING, 0);
		casesRepository.save(case3);
		
	}
}
