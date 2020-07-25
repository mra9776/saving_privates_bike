package com.github.mra9776.saving_privates_bike;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.mra9776.saving_privates_bike.model.Cases;
import com.github.mra9776.saving_privates_bike.model.helper.CaseStatus;
import com.github.mra9776.saving_privates_bike.repository.CasesRepositoryInMem;

@RunWith(SpringRunner.class)
public class CasesRepositoryInMemTest extends baseTest{

	CasesRepositoryInMem casesRepositoryInMem;

	public CasesRepositoryInMemTest() {
		super();
		casesRepositoryInMem = new CasesRepositoryInMem(super.getJedis());
	}
	
	@Test
	public void test1() {
		Cases cases = new Cases();
		cases.setCaseStatus(CaseStatus.PENDING);
		cases.setOfficerId(null);
		cases.setCaseId(UUID.fromString("ab7d6803-40d1-4300-9b84-aa3cbc0d1019"));
		
		Cases found = casesRepositoryInMem.find(cases.getCaseId());
		if(found != null) {
			assertEquals(found, cases);
		} else {
			fail();
		}

	}
	
	@Test
	public void test2() {
		Cases cases = new Cases();
		cases.setCaseStatus(CaseStatus.PENDING);
		cases.setOfficerId(null);
		cases.setCaseId(UUID.fromString("ab7d6803-40d1-4300-9b84-aa3cbc0d1011"));
		
		Cases found = casesRepositoryInMem.find(cases.getCaseId());
		if(found != null) {
			fail();
		}

	}
}
