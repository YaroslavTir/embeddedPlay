package com.example.entity;

import org.hibernate.cfg.EmbeddedPrefix;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author ymolodkov on 09.09.16.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Data
public class Person implements Serializable {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "id", length = 36)
    private UUID id;

    @Embedded
    private Address address;

    @Embedded
    @EmbeddedPrefix("office")
    private Address officeAddress;

}
