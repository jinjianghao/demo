package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void test1(){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
        // jedis.auth("123456");
        System.out.println(jedis.get("second").toString());
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }

    @Test
    public void testStream(){
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1);
        a.add(2);
        a.add(2);
        a.add(3);
        a.add(4);
        List<Integer> b = Arrays.asList(1,2,3,4,5,6);
        List<Integer> collect = a.stream().distinct().filter(b::contains).collect(Collectors.toList());
        System.out.println(collect);
    }
    @Test
    public void testStringBuffer(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a").append("b").append("c");
        String s = "a"+"b"+"c";

        System.out.println(stringBuffer);
        System.out.println("----------------------");
        System.out.println(s);
        System.out.println("----------------------");
        System.out.println(stringBuffer.equals(s));


    }



}
