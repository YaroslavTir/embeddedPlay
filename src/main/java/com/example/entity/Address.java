package com.example.entity;

import lombok.Data;

import javax.persistence.Embeddable;

/**
 * @author ymolodkov on 09.09.16.
 */
@Embeddable
@Data
public class Address {
    private String street;
}
