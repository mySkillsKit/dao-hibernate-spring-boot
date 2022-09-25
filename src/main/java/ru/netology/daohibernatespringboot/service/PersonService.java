package ru.netology.daohibernatespringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.daohibernatespringboot.entity.Person;
import ru.netology.daohibernatespringboot.repository.PersonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<Person> getPersonByCity(String city) {
        return personRepository.getPersonByCity(city);

    }


}
