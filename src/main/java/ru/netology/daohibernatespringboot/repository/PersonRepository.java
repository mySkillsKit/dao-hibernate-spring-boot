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
        final String sql = "select p from Person p where lower(p.cityOfLiving) = lower(:city)";
        List<Person> resultList = entityManager.createQuery(sql, Person.class)
                .setParameter("city", city)
                .getResultList();
        resultList.forEach(System.out::println);
        return resultList;
    }
}
