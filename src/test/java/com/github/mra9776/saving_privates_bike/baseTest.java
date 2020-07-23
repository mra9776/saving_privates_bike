package com.github.mra9776.saving_privates_bike;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
public class baseTest {
	
	private Jedis jedis;
	
	public Jedis getJedis() {
		return jedis;
	}

	public void setJedis(Jedis jedis) {
		this.jedis = jedis;
	}

	public void init() {
		jedis = new Jedis("localhost", 6379);
		RedisTest.insertStuf(jedis);
		
	}

	public baseTest() {
		super();
		this.init();
	}
	
}
