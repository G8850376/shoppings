package com;


import com.pojo.Commodity;
//import com.repository.ComRepository;
//import com.repository.ComRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootTest
class ShoppingApplicationTests {

    @Resource
    DataSource dataSource;

    @Resource
    RedisTemplate redisTemplate;
    @Resource
    StringRedisTemplate stringRedisTemplate;

//    @Resource
//    ComRepository comMapper;
//
//    @Test
//    void test01(){
//        Commodity commodity=new Commodity();
//        commodity.setId(1);
//        commodity.setName("苹果");
//        comMapper.index(commodity);
//        System.out.println(commodity);
//    }
//
//    @Test
//    void test02(){
//        for (Commodity commodity : comMapper.findByNameLike("苹")) {
//            System.out.println(commodity);
//        }

//    }
    @Test
    void contextLoads() {

        System.out.println(stringRedisTemplate.toString());
        System.out.println(dataSource.getClass());
    }


}
