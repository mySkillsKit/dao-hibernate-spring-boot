package ru.netology.daohibernatespringboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daohibernatespringboot.entity.Person;
import ru.netology.daohibernatespringboot.service.PersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/by-city")
    public List<Person> getPersonByCity(@RequestParam String city) {
        return personService.getPersonByCity(city);
    }
}

