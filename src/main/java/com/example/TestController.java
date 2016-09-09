package com.example;

import com.example.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/*", method = RequestMethod.GET)
    public String test() {
        Test test = testService.getTest();
//        return test.getAddress().getStreet() +" " + test.getOfficeAddress().getStreet();
        return test.getAddress().getStreet();
    }
}