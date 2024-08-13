package com.example.springBootDeneme.controllers;

import com.example.springBootDeneme.models.Person;
import com.example.springBootDeneme.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private PersonRepository _personRepository;

    //CONSTRUCTOR
    public HelloController(PersonRepository personRepository) {
        this._personRepository = personRepository;
        Person person = new Person();
        person.setName("abcdef");
        _personRepository.save(person);
    }

    @GetMapping
    public List<Person> getAll() {
        return _personRepository.findAll();
    }
}
