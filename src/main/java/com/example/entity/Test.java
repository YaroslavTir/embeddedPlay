package com.example.entity;

import com.example.EmbeddedPrefix;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author ymolodkov on 09.09.16.
 */
@Entity
@Data
public class Test {

    private static final long serialVersionUID = 1L;

    @Id
    @Type(type="uuid-char")
    @Column(name = "id", length = 36)
    private UUID id;

    @Embedded
    private Address address;

    @Embedded
    @EmbeddedPrefix("office")
    private Address officeAddress;

}
