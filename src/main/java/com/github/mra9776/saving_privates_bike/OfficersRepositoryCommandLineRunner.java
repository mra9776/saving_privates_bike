package com.github.mra9776.saving_privates_bike;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OfficersRepositoryCommandLineRunner implements CommandLineRunner{

	@Autowired
	private OfficersRepository officersRepository;
	
	@Override
	public void run(String... arg0)  {
		officersRepository.save(new Officers(0,  OfficerStatus.FREE, new Date(), -1));
		officersRepository.save(new Officers(0,  OfficerStatus.FREE, new Date(), -1));
		officersRepository.save(new Officers(0,  OfficerStatus.FREE, new Date(), -1));
	
	}
}
