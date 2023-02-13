package com.example.demo.controller;

import com.example.demo.service.DecoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Controller
public class DecoderController {
    @Autowired
    DecoderService decoder;
    @ResponseBody
    @GetMapping("/{shortUrl}")
    public void redirect(@PathVariable String shortUrl, HttpServletResponse response) throws IOException {

        String longUrl = decoder.decode(shortUrl);

        response.sendRedirect(longUrl);


    }
}
