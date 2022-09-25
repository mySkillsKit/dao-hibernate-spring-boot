package ru.netology.daohibernatespringboot.repository;

import org.springframework.stereotype.Repository;
import ru.netology.daohibernatespringboot.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Person> getPersonByCity(String city) {
        return entityManager.createQuery("select p from Person p where p.cityOfLiving = :city order by p.cityOfLiving", Person.class)
                .setParameter("city",city)
                .getResultList();
    }
}
