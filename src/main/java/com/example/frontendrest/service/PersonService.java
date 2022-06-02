package com.example.frontendrest.service;

import com.example.frontendrest.model.Person;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface PersonService {

    @GetExchange("/person/{name}")
    Person personByName(@PathVariable String name);

    @GetExchange("/person")
    List<Person> personList();

}
