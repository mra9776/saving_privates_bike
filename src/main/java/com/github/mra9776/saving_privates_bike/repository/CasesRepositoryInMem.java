package com.github.mra9776.saving_privates_bike.repository;

import java.util.Map;
import java.util.UUID;
import com.github.mra9776.saving_privates_bike.model.Cases;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

@Repository
public class CasesRepositoryInMem  {
	private Jedis jedis;

	public CasesRepositoryInMem(Jedis jedis) {
		super();
		this.jedis = jedis;
	}
    
    public CasesRepositoryInMem(){
        jedis = new Jedis("localhost", 6379);
    }
	public Cases find(UUID caseId) {
        Map<String, String> res = jedis.hgetAll(caseId.toString());
        if (res.size() == 0)
            return null;
        Cases resCase = new Cases(res);
        System.out.println("ding");
		return resCase;
	}
	public void store(UUID caseId, Cases findByCaseId) {
        jedis.hmset(caseId.toString(), findByCaseId.mapOut());
        System.out.println("dang");
    }
}
