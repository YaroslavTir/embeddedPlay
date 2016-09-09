package com.example;

import com.example.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ymolodkov on 09.09.16.
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/*", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Person index() {
        return testService.getPerson();
    }
}