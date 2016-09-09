package com.example;

import com.example.entity.Test;
import com.example.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author ymolodkov on 09.09.16.
 */
@Service
public class TestService {
    private TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public Test getTest(){
        return testRepository.getOne(UUID.fromString("8ea1af81-767e-11e6-9ba7-44a842ecf33c"));
    }


}
