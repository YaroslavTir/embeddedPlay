package com.example.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

/**
 * @author ymolodkov on 09.09.16.
 */
@Data
@Embeddable
public class Address implements Serializable {
    @Column(name = "street")
    private String street;
    @Column(name = "post")
    private String post;
    @Embedded
    private Geo geo;
}
