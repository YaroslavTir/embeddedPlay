package com.example.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author ymolodkov on 09.09.16.
 */
@Data
@Embeddable
public class Geo implements Serializable {
    @Column(name = "coordinate")
    private String coordinate;
}
