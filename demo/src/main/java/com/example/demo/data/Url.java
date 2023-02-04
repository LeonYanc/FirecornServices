package com.example.demo.data;

import javax.persistence.*;


@Entity
@Table(name = "url")
public class Url {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String longurl;

    private String shorturl;

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", longurl='" + longurl + '\'' +
                ", shorturl='" + shorturl + '\'' +
                '}';
    }

    public Url(){}
    public Url(String longurl, String shorturl) {
        this.longurl = longurl;
        this.shorturl = shorturl;
    }

    public String getLong_url() {
        return longurl;
    }

    public void setLong_url(String longurl) {
        longurl = longurl;
    }

    public String getShort_url() {
        return shorturl;
    }

    public void setShort_url(String shorturl) {
        shorturl = shorturl;
    }

}
