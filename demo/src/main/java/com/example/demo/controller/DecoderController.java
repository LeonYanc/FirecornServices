package com.example.demo.controller;

import com.example.demo.data.UrlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.NoSuchElementException;
@Controller
public class DecoderController {
    @Autowired
    UrlRepo ob;
    @ResponseBody
    public String decode(String shortUrl) {


        return ob.findByShorturlIs("http://localhost:8080/"+shortUrl).get(0).getLong_url();
    }
    @GetMapping("/{shortUrl}")
    public void redirect(@PathVariable String shortUrl, HttpServletResponse response) throws IOException {
        String longUrl =decode(shortUrl);
        if (longUrl == null) {
            throw new NoSuchElementException(shortUrl);
        } else {
            response.sendRedirect(longUrl);

        }
    }
}
