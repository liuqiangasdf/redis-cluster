package com.redis_cluster;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

/**
 * Hello world!
 *
 */
public class App {
	
	private static StringRedisTemplate template;
	
	public static void main(String[] args) {

		String ip1 = "10.0.68.213:";
		String ip2 = "10.0.68.214:";
		String key = "Basic_LoanProduct"; // DynamicConf Basic_LoanProduct

		// String ip1 = "10.1.34.183:";
		// String ip2 = "10.1.34.182:";

		List<String> jedisClusterNodes = new ArrayList<String>();
		jedisClusterNodes.add(ip1 + 7000);
		jedisClusterNodes.add(ip1 + 7001);
		jedisClusterNodes.add(ip1 + 7002);
		jedisClusterNodes.add(ip2 + 7000);
		jedisClusterNodes.add(ip2 + 7001);
		jedisClusterNodes.add(ip2 + 7002);
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(30);
		jedisPoolConfig.setMaxWaitMillis(500);
		jedisPoolConfig.setTimeBetweenEvictionRunsMillis(30000);
		jedisPoolConfig.setMinEvictableIdleTimeMillis(30000);
		jedisPoolConfig.setTestOnBorrow(false);
		jedisPoolConfig.setMaxIdle(30);

		RedisClusterConfiguration clusterConfig = new RedisClusterConfiguration(jedisClusterNodes);
		clusterConfig.setMaxRedirects(5);
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory(clusterConfig, jedisPoolConfig);
		connectionFactory.afterPropertiesSet();

		template = new StringRedisTemplate(connectionFactory);

		Set<String> keys = template.keys("*" + key + "*");

		System.out.println("key列表=" + keys.toString());
		
//		deleteKey(keys);
		
		connectionFactory.destroy();
	}
	
	private static void deleteKey(Set<String> keys){
		System.out.println("开始删除");
		long count = template.delete(keys);
		System.out.println("结束删除["+count+"]");
	}
}
