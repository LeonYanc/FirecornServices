package com.example.nosecurity.data;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Url {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "long_url")
    private String long_url;
    @Column(name = "short_url")
    private String short_url;
    public Long getId() {
        return id;
    }

    public String getLong_url() {
        return long_url;
    }

    public void setLong_url(String long_url) {
        long_url = long_url;
    }

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        short_url = short_url;
    }

}
