package com.example.demo.service;

import com.example.demo.cache.RedisCacheService;
import com.example.demo.data.Url;
import com.example.demo.data.UrlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
public class EncoderService {
    @Autowired
    UrlRepo ob;
    @Autowired
    RedisCacheService ca;
    String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int count = 1;
    public String getString() {
        int c = count;
        StringBuilder sb = new StringBuilder();
        while (c > 0) {
            c--;
            sb.append(chars.charAt(c % 62));
            c /= 62;
        }
        return sb.toString();
    }


    public String encodeB(String longUrl) {

        if(ob.findByLongurlIs(longUrl).isEmpty()){
        String key = getString();
        count++;
        String address ="http://localhost:8080/" + key;

        Url url=new Url(longUrl,address);



            ob.save(url);
            ca.insertUrl(address,longUrl);
            System.out.println("Save Url in to DB and cache");
            return address;
        }
        String address2= ob.findByLongurlIs(longUrl).get(0).getShorturl();
        if(ca.getshortUrl(longUrl)==null){
            ca.insertUrl(address2,longUrl);
        }
        System.out.println("Url already exist in db");
        return address2;
    }


    public String encodeA(String longUrl) {

        if(ob.findByLongurlIs(longUrl).isEmpty()) {
            String address="http://localhost:8080/" +longUrl.hashCode();
            Url url=new Url(longUrl,address);

            ob.save(url);
            ca.insertUrl(address, longUrl);
            System.out.println("Save Url in to DB and cache");
            return address;
        }
        String address2= ob.findByLongurlIs(longUrl).get(0).getShorturl();
        if(ca.getshortUrl(longUrl)==null){
            ca.insertUrl(address2,longUrl);
        }
        System.out.println("Url already exist in db");
        return address2;
    }
}
