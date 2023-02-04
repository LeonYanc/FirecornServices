package com.example.demo.controller;

import com.example.demo.data.Url;
import com.example.demo.data.UrlRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class EncoderController {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    UrlRepo ob;


    public EncoderController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
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




    @RequestMapping("/encode")
    @ResponseBody
    public String encode(String longUrl) {
        Url url;
        String address;
        String address1="http://localhost:8080/" +longUrl.hashCode();
        String key = getString();
        count++;
        System.out.println(longUrl);
        String address2 ="http://localhost:8080/" + key;
        if (address2.length()>address1.length()){
            url=new Url(longUrl,address1);
            address=address1;
        }
        else{
           url=new Url(longUrl,address2);
            address=address2;
        }



        if(ob.findByLongurlIs(longUrl).isEmpty()){
            ob.save(url);
        }

        return address;
    }



}
