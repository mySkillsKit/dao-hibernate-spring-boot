package ru.netology.daohibernatespringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.daohibernatespringboot.entity.Person;
import ru.netology.daohibernatespringboot.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person getPersonById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        personNotFound(optionalPerson);
        return optionalPerson.get();
    }

    public Person updatePerson(Long id, Person person) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        personNotFound(optionalPerson);
        person.setId(id);
        return personRepository.save(person);
    }

    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }

    public List<Person> getPersonByCity(String city) {
        return personRepository.findByCity(city);
    }

    public List<Person> getPersonsByAgeLessThanOrderBy(int age) {
        return personRepository.findByAgeLessThanOrderByAge(age);
    }

    public Person getPersonByNameAndSurname(String name, String surname) {
        Optional<Person> optionalPerson = personRepository.findByNameAndSurname(name, surname);
        personNotFound(optionalPerson);
        return optionalPerson.get();
    }

    private void personNotFound(Optional<Person> optionalPerson) {
        if (optionalPerson.isEmpty()) {
            throw new RuntimeException("Person not found");
        }
    }
}
