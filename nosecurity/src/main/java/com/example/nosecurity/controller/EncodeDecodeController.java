package com.example.nosecurity.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.NoSuchElementException;

@Controller
public class EncodeDecodeController {

    MapController mapController=new MapController();

    @RequestMapping("/encode")
    @ResponseBody
    public String encode(String longUrl) {


        return "http://tinyurl.com/" + mapController.longtoshort(longUrl);
    }
    @RequestMapping("/decode")
    @ResponseBody
    public String decode(String shortUrl) {

        return mapController.shorttolong(shortUrl);
    }
    @GetMapping("/{shortUrl}")
    public void redirect(@RequestParam String shortUrl, HttpServletResponse response) throws IOException {
        String longUrl =decode(shortUrl);
        if (longUrl == null) {
            throw new NoSuchElementException(shortUrl);
        } else {
            response.sendRedirect(longUrl);

        }
    }
}
