package com.example.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author ymolodkov on 09.09.16.
 */
@Data
@Entity
public class Country implements Serializable{

    @Id
    @Type(type = "uuid-char")
    @Column(name = "id", length = 36)
    private UUID id;

    @Column(name = "iso")
    String iso;
}
