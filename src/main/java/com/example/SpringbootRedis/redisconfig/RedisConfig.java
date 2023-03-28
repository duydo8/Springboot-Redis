//package com.example.SpringbootRedis.redisconfig;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
//import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//@Configuration
//
//public class RedisConfig {
//    @Bean
//    public JedisConnectionFactory redisConnectionFactory() {
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
//        jedisConnectionFactory.setHostName("your_host_name_or_ip");
//        jedisConnectionFactory.setPort(6379);
//        jedisConnectionFactory.afterPropertiesSet();
//        return jedisConnectionFactory;
//    }
//@Bean
//@Primary
//    public  RedisTemplate<String, Object> redisTemplate() {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String ,Object>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory());
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
//}
