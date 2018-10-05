package com.test.demo.controllers;

import com.test.demo.models.V1PersonResponse;
import com.test.demo.respositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/people")
public class V1PersonController {

    private final PersonRepository personRepository;

    @Autowired
    public V1PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<V1PersonResponse> getPeople() {
        return personRepository.findAllBy()
                .stream()
                .map(V1PersonResponse::fromPerson)
                .collect(Collectors.toList());
    }

}
