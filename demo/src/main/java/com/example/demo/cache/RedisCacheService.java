package com.example.demo.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisCacheService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    public void insertUrl(String shortUrl, String longUrl) {
        stringRedisTemplate.opsForValue().set(shortUrl, longUrl);
    }


    public String getUrl(String shortUrl) {
        String url = stringRedisTemplate.opsForValue().get(shortUrl);
        return url;
    }

    public String getshortUrl(String longUrl) {
        String url = stringRedisTemplate.opsForValue().get(longUrl);
        return url;
    }

    public void deleteUrl(String shortUrl) {
        stringRedisTemplate.delete(shortUrl);
    }


    public void setTimeOut(String key, long timeout){
        stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }
}