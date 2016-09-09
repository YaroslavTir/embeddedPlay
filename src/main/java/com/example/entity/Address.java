package com.example.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
/**
 * @author ymolodkov on 09.09.16.
 */
@Embeddable
@Data
public class Address {
    @Column(name = "street")
    private String street;
}
