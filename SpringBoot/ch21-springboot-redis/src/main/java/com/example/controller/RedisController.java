package com.example.controller;

import com.example.vo.Student;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController {
    /**
     * 注入模板 RedisTemplate
     * <p>
     * RedisTemplate 泛型
     * RedisTemplate<String,String>
     * RedisTemplate<Object,Object>
     */
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    //添加数据到 redis
    @PostMapping("/redis/addString")
    public String addToRedis(String name, String value) {
        //操作 redis 中 string 类型的数据，先获取 valueOperations对象
        ValueOperations valueOperations = redisTemplate.opsForValue();
        //添加数据到 redis
        valueOperations.set("myname", "lisi");
        return "向 Redis 添加 String 类型的数据";
    }

    //从 redis 获取数据
    @GetMapping("/redis/getK")
    public String getData(String k) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object v = valueOperations.get(k);
        return "向 Redis 请求数据，key = " + k + " 他的值是: value = " + v;
    }

    @PostMapping("/redis/{k}/{v}")
    public String addStringKV(@PathVariable String k,
                              @PathVariable String v) {
        //使用 stringRedisTemplate 对象
        stringRedisTemplate.opsForValue().set(k, v);
        return "使用的是 stringRedisTemplate 对象";
    }

    @GetMapping("/redis/getstr/{k}")
    public String getStringKV(@PathVariable String k) {
        String v = stringRedisTemplate.opsForValue().get(k);
        return "k 的 value: " + v;
    }

    /**
     * 设置 RedisTemplate 序列化机制
     * 可以设置 key 的序列化，也可以设置 value 序列化
     * 也可以同时设置 key 和 value 的序列化
     */
    @PostMapping("/redis/addstr")
    public String addString(String k, String v) {
        //设置 key 使用 string 的序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置 value 的序列化
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        redisTemplate.opsForValue().set(k, v);

        return "定义 RedisTemplate 对象的 key value 的序列化";
    }

    /**
     * 使用 JSON 的序列化，把 java 对象转为 JSON 对象
     */
    @PostMapping("/redis/addJson")
    public String addJSON() {
        Student student = new Student();

        student.setId(1001);
        student.setName("zhangsan");
        student.setAge(20);

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //要把这个值 作为 json 序列化
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Student.class));

        redisTemplate.opsForValue().set("myStudent",student);
        return "json 序列化";
    }

    @GetMapping("/redis/getJson")
    public String getJSON() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //要把这个值 作为 json 序列化
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Student.class));

        Object myStudent = redisTemplate.opsForValue().get("myStudent");
        return "json 反序列化 "+myStudent;
    }

}
