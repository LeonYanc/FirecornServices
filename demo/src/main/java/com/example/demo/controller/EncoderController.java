package com.example.demo.controller;

import com.example.demo.service.EncoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EncoderController {
    @Autowired
    EncoderService encoder;

    @RequestMapping("/encodeA")
    @ResponseBody
    public String encode(String longUrl) {
        return encoder.encodeA(longUrl);
    }
    @RequestMapping("/encodeB")
    @ResponseBody
    public String encode1(String longUrl) {
        return encoder.encodeB(longUrl);
    }
}
