package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ymolodkov on 09.09.16.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Embeddable
public class Address implements Serializable {
    @Column(name = "street")
    private String street;
    @Column(name = "post")
    private String post;
    @Embedded
    private Geo geo;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
