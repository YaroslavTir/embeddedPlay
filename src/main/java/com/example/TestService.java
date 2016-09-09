package com.example;

import com.example.entity.Person;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author ymolodkov on 09.09.16.
 */
@Service
public class TestService {
    private PersonRepository personRepository;

    @Autowired
    public TestService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPerson(){
        return personRepository.getOne(UUID.fromString("8ea1af81-767e-11e6-9ba7-44a842ecf33c"));
    }


}
