package com.github.mra9776.saving_privates_bike;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mra9776.saving_privates_bike.model.Cases;

import redis.clients.jedis.Jedis;

public class RedisTest {
	public static void insertStuf(Jedis jedis) {
		String jsonInput = "[{\"caseId\":\"ab7d6803-40d1-4300-9b84-aa3cbc0d1019\",\"caseStatus\":\"PENDING\",\"officerId\":null},{\"caseId\":\"e6700b34-61a9-4669-bda3-66a26fedab2b\",\"caseStatus\":\"PENDING\",\"officerId\":null},{\"caseId\":\"0adc3ad1-3d9f-4482-bb4b-5dbe0111ba29\",\"caseStatus\":\"PENDING\",\"officerId\":null}]";
		 
		ObjectMapper mapper = new ObjectMapper();
		List<Cases> myObjects = new ArrayList<>();
		try {
			myObjects = mapper.readValue(jsonInput, new TypeReference<List<Cases>>(){});
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		for (Cases obj: myObjects ) {
			jedis.hmset(obj.getCaseId().toString(), obj.mapOut());
		}
		System.out.println("helllo");
		
	}

}
