package com.example.repository;

import com.example.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author ymolodkov on 09.09.16.
 */

public interface PersonRepository extends JpaRepository<Person, UUID> {
}
