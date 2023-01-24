package com.example.nosecurity.controller;



import java.util.HashMap;
import java.util.Map;


public class MapController {




    Map<Integer, String> map = new HashMap<>();

    public int longtoshort(String longUrl){
        map.put(longUrl.hashCode(), longUrl);
        return longUrl.hashCode();
    }
    public String shorttolong(String shortUrl){
        return (map.get(Integer.parseInt(shortUrl.replace("http://localhost:8080/", ""))));
    }
}
