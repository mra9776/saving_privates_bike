package com.github.mra9776.saving_privates_bike;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.*;

import com.github.mra9776.saving_privates_bike.model.Cases;
import com.github.mra9776.saving_privates_bike.model.helper.CaseStatus;
import com.github.mra9776.saving_privates_bike.resources.CaseResource;
import com.github.mra9776.saving_privates_bike.service.CasesService;

@RunWith(SpringRunner.class)
@WebMvcTest(CaseResource.class)
public class CasesResourceTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private CasesService casesService;
	
	Cases cases;
	@Before
	public void setup() {
		cases = new Cases();
		cases.setCaseStatus(CaseStatus.PENDING);
		cases.setOfficerId(null);
		cases.setCaseId(UUID.fromString("ab7d6803-40d1-4300-9b84-aa3cbc0d1019"));

		List<Cases> listOfCases = new ArrayList<Cases>();
		listOfCases.add(cases);
		
		Mockito.when(casesService.findAll()).thenReturn(listOfCases);
	}
	
	@Test
	public void getCases() throws Exception {
		mvc.perform(get("/cases/").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(1)))
			.andExpect(jsonPath("$[0].caseId", is(cases.getCaseId().toString())));
	}
}
