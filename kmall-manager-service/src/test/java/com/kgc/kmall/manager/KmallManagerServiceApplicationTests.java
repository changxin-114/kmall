package com.kgc.kmall.manager;

import com.kgc.kmall.service.CatalogService;
import com.kgc.kmall.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

@SpringBootTest
class KmallManagerServiceApplicationTests {
	@Resource
	CatalogService catalogService;
	@Resource
	RedisUtil redisUtil;
	@Test
	void contextLoads() {
//		List<PmsBaseCatalog1> catalog1 = catalogService.getCatalog1();
//		System.out.println(catalog1.toString());
        Jedis jedis = redisUtil.getJedis();
        String ping = jedis.ping();
        System.out.println(ping);
    }

}
