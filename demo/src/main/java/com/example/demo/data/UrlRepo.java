package com.example.demo.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UrlRepo extends CrudRepository<Url,Integer> {
    List<Url> findByLongurlIs(String longurl);
    List<Url> findByShorturlIs(String shorturl);
}
