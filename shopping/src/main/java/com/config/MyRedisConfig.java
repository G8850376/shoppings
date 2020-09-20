package com.config;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Employee;
import com.pojo.Commodity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.net.UnknownHostException;

@Configuration
public class MyRedisConfig {

//        @Autowired
//        private RedisTemplate redisTemplate;
//
//        @Bean(name = "redisTemplate")
//        public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//            RedisTemplate<String, String> template = new RedisTemplate<>();
//            template.setConnectionFactory(factory);
//            template.setKeySerializer(new StringRedisSerializer());
//            template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//            template.setHashKeySerializer(new GenericJackson2JsonRedisSerializer());
//            template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
//            template.afterPropertiesSet();
//            return template;
//        }


    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate<Object, Employee>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Employee> ser = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
        template.setDefaultSerializer(ser);
        return template;
    }

//    @Bean
//    public RedisTemplate<Object, Commodity> comRedisTemplate(
//            RedisConnectionFactory redisConnectionFactory)
//            throws UnknownHostException {
//        RedisTemplate<Object, Commodity> template1 = new RedisTemplate<Object, Commodity>();
//        template1.setConnectionFactory(redisConnectionFactory);
//        Jackson2JsonRedisSerializer<Commodity> ser = new Jackson2JsonRedisSerializer<Commodity>(Commodity.class);
//        template1.setDefaultSerializer(ser);
//        return template1;
//    }

    /**
     * 自定义缓存管理器（Json序列化）
     * 如果没有配置，则使用默认的jdk序列化
     */
//    @Bean
//    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
//        Jackson2JsonRedisSerializer<Object> redisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        redisSerializer.setObjectMapper(objectMapper);
//        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer));
//        RedisCacheManager redisCacheManager = RedisCacheManager.builder(connectionFactory).cacheDefaults(cacheConfiguration).build();
//        return redisCacheManager;
//    }
}
