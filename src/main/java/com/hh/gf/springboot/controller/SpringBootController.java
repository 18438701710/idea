package com.hh.gf.springboot.controller;

import com.hh.gf.springboot.entity.People;
import com.hh.gf.springboot.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootController {

    @Autowired
    private Person person;
    @Autowired
    private People people;
    @Value("${person.name}")
    private String name;

    @RequestMapping(value = "/person")
    public String person() {

        return "ID:" + person.getId() + "   name:" + name;
    }

    @RequestMapping(value = "/people")
    public String people() {

        return "ID:" + people.getId() + "   name:" + people.getName() + "  age:" + people.getId();
    }

    @RequestMapping(value = "/people2")
    public People people2() {

        return people;
    }

}
