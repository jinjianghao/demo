package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Set;

@SpringBootTest
public class SpringDataRedisTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void testString(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("city123","beijing");
        String city123 = String.valueOf(redisTemplate.opsForValue().get("city123"));
        System.out.println(city123);

        Boolean b = redisTemplate.opsForValue().setIfAbsent("city123", "南京");
        System.out.println(b);

    }

    @Test
    public void testHash(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("002","name","xiaoming");
        hashOperations.put("002","age","20");

        String name = hashOperations.get("002", "name").toString();
        System.out.println(name);

        for (Object key : hashOperations.keys("002")) {
            System.out.println(key);
        }

        for (Object value : hashOperations.values("002")) {
            System.out.println(value);
        }
    }

    @Test
    public void testList(){
        ListOperations listOperations = redisTemplate.opsForList();

        listOperations.leftPush("mylist","a");
        listOperations.leftPushAll("mylist","b","c","d");

        for (Object mylist : listOperations.range("mylist", 0, -1)) {
            System.out.println(mylist+"111111111");
        }

        Long mylist1 = listOperations.size("mylist");
        int isize = mylist1.intValue();
        for (int i = 0;i < isize; i++){
            String mylist = String.valueOf(listOperations.rightPop("mylist"));
            System.out.println(mylist);
        }

    }

    @Test
    public void testSet(){
        SetOperations setOperations = redisTemplate.opsForSet();

        setOperations.add("myset","a","b","c","a");

        for (Object myset : setOperations.members("myset")) {
            System.out.println(myset);
        }

        setOperations.remove("myset","a","b");

        for (Object mysey : setOperations.members("mysey")) {
            System.out.println(mysey);
        }

    }

}
