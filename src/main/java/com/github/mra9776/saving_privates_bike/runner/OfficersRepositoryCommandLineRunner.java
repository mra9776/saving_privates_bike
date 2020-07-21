package com.github.mra9776.saving_privates_bike.runner;

import java.util.Date;

import com.github.mra9776.saving_privates_bike.data.Officers;
import com.github.mra9776.saving_privates_bike.data.helper.OfficerStatus;
import com.github.mra9776.saving_privates_bike.repository.OfficersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OfficersRepositoryCommandLineRunner implements CommandLineRunner{

	@Autowired
	private OfficersRepository officersRepository;
	
	@Override
	public void run(String... arg0)  {
		for (int i=0; i < 3 ; i++) {
			Officers officers = new Officers();
			officers.setOfficerStatus(OfficerStatus.FREE);
			officers.setCaseId(null);
			officers.setLastCase(new Date());
			officersRepository.save(officers);
		
		}
	}
}
