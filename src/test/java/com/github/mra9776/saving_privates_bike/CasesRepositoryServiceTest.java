package com.github.mra9776.saving_privates_bike;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Optional;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.mra9776.saving_privates_bike.model.Cases;
import com.github.mra9776.saving_privates_bike.model.helper.CaseStatus;
import com.github.mra9776.saving_privates_bike.repository.CasesRepository;
import com.github.mra9776.saving_privates_bike.repository.CasesRepositoryInMem;
import com.github.mra9776.saving_privates_bike.service.CasesService;

@RunWith(SpringRunner.class)
public class CasesRepositoryServiceTest extends baseTest{

	CasesRepositoryInMem casesRepositoryInMem;

	@MockBean
	private CasesRepository casesRepository;
	
	@Before
	public void setup(){
		Cases cases = new Cases();
		cases.setCaseStatus(CaseStatus.PENDING);
		cases.setOfficerId(null);
		cases.setCaseId(UUID.fromString("ab7d6803-40d1-4300-9b84-aa3cbc0d1019"));
		Mockito.when(casesRepository.findByCaseId(cases.getCaseId())).thenReturn(Optional.of(cases));
	}
	
	@TestConfiguration
	static class CasesRepositoryServiceTestContextConfiguration{		
		@Bean 
		public CasesService casesService() {
			return new CasesService();
		}
	}
	
	@Autowired
	CasesService casesService;
	
	public CasesRepositoryServiceTest() {
		super();
		casesRepositoryInMem = new CasesRepositoryInMem(super.getJedis());
	}
	
	@Test
	public void test1() {
		Cases cases = new Cases();
		cases.setCaseStatus(CaseStatus.PENDING);
		cases.setOfficerId(null);
		cases.setCaseId(UUID.fromString("ab7d6803-40d1-4300-9b84-aa3cbc0d1019"));
		
		Optional<Cases> found = casesService.findByCaseId(cases.getCaseId());;
		if(found.isPresent()) {
			assertEquals(found, cases);
		} else {
			fail();
		}

	}
	
}
