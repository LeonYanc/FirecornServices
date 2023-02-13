package com.example.demo.service;

import com.example.demo.cache.RedisCacheService;
import com.example.demo.data.UrlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.NoSuchElementException;

@Controller
public class DecoderService {
    @Autowired
    UrlRepo ob;
    @Autowired
    RedisCacheService ca;
    public String decode(String shortUrl) throws IOException {


        String longUrl2= ca.getUrl("http://localhost:8080/"+shortUrl);
        System.out.println(longUrl2);
        if (longUrl2 == null) {
            String longUrl =ob.findByShorturlIs("http://localhost:8080/"+shortUrl).get(0).getLong_url();
            ca.insertUrl(shortUrl,longUrl);
            if (longUrl == null) {
                throw new NoSuchElementException(shortUrl);
            }
            else{
                System.out.println("form db");
                return longUrl;
            }
        } else {
            System.out.println("form cache");
            return longUrl2;

        }
    }
}
