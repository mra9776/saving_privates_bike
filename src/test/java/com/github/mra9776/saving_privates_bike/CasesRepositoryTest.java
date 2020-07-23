package com.github.mra9776.saving_privates_bike;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.mra9776.saving_privates_bike.model.Cases;
import com.github.mra9776.saving_privates_bike.model.helper.CaseStatus;
import com.github.mra9776.saving_privates_bike.repository.CasesRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CasesRepositoryTest {
	@Autowired
	private CasesRepository casesRepository;
	
	@Test
	public void test1() {
		Cases cases = new Cases();
		cases.setCaseStatus(CaseStatus.PENDING);
		cases.setOfficerId(null);
		
		casesRepository.save(cases);
		Optional<Cases> found = casesRepository.findByCaseId(cases.getCaseId());
		if(found.isPresent()) {
			assertEquals(found.get(), cases);
		} else {
			fail();
		}
		
	}
}
